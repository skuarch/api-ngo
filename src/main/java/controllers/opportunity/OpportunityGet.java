package controllers.opportunity;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.Opportunity;
import model.components.OpportunityComponent;
import model.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class OpportunityGet extends BaseController {   
    
    @Autowired
    private OpportunityComponent opportunityComponent;    
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/opportunity/{id}"},
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public Opportunity getOpportunity(@PathVariable("id") long id, HttpServletResponse response) throws ServletException {

        //basic configuration        
        setHeaderNoChache(response);        
        Opportunity opportunity = null;       

        try {            
            
            opportunity = opportunityComponent.getObject(id, Opportunity.class);
            ResponseUtil.sendError(opportunity, response, HttpServletResponse.SC_NOT_FOUND);            
            
        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return opportunity;

    }
    
}
