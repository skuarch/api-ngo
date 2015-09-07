package controllers.opportunity;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.GenericMessage;
import model.beans.Opportunity;
import model.components.OpportunityComponent;
import model.logic.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class OpportunityCreate extends BaseController {
   
    @Autowired
    private GenericMessage genericMessage;
    
    @Autowired
    private OpportunityComponent opportunityComponent;
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/opportunity"},
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    public GenericMessage createOpportunity(@ModelAttribute Opportunity opportunity, HttpServletResponse response) throws ServletException {
                
        //basic configuration        
        setHeaderNoChache(response);        
        long idOpportunity;                

        try {            
            
            //save opportunity            
            idOpportunity = opportunityComponent.createObject(opportunity);
            
            genericMessage.setCode(200);
            genericMessage.setId(idOpportunity);
            genericMessage.setMessage(Constants.MESSAGE_SUCCESS);

        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return genericMessage;

    }
    
}
