package controllers.opportunity;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.GenericMessage;
import model.beans.Opportunity;
import model.beans.Stage;
import model.components.OpportunityComponent;
import model.components.StageComponent;
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
public class OpportunityUpdate extends BaseController {
   
    @Autowired
    private GenericMessage genericMessage;
    
    @Autowired
    private OpportunityComponent opportunityComponent;
    
    @Autowired
    private StageComponent stageComponent;
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/opportunity"},
            method = RequestMethod.PUT,
            produces = {"application/json"}
    )
    public GenericMessage createOpportunity(@ModelAttribute Opportunity opportunity, HttpServletResponse response) throws ServletException {
                
        //basic configuration        
        setHeaderNoChache(response);                
        Stage stage;

        try {
            
            //update stage
            //think about this
            
            //update opportunity            
            opportunityComponent.updateObject(opportunity);
            
            genericMessage.setCode(200);
            genericMessage.setId(opportunity.getId());
            genericMessage.setMessage(Constants.MESSAGE_SUCCESS);

        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return genericMessage;

    }
    
}
