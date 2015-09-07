package controllers.opportunity;

import controllers.application.BaseController;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.Opportunity;
import model.components.OpportunityComponent;
import model.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class OpportunityGetList extends BaseController {   
    
    @Autowired
    private OpportunityComponent opportunityComponent;    
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/opportunity/list/"},
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public ArrayList<Opportunity> getOpportunity(HttpServletResponse response) throws ServletException {
        
        //basic configuration        
        setHeaderNoChache(response);        
        ArrayList<Opportunity> opportunities = null;       

        try {            
            
            opportunities = new ArrayList(opportunityComponent.getList());            
            ResponseUtil.sendError(opportunities, response, HttpServletResponse.SC_NOT_FOUND);            
            
        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return opportunities;

    }
    
}
