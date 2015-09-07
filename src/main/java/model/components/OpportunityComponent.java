package model.components;

import java.util.List;
import model.beans.Opportunity;
import model.database.HibernateConnection;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class OpportunityComponent extends DataAccessObject {

    //==========================================================================
    public OpportunityComponent() {
    }
    
    //==========================================================================
    public List<Opportunity> getList() throws Exception {
    
        List<Opportunity> opportunityies = null;
        
        try {            
            
            opportunityies = new HibernateConnection().executeNamedQuery("getOpportunities", Opportunity.class);
            
        } catch (Exception e) {
            throw e;
        }
        
        return opportunityies;
    
    }

}
