
package controllers.testBean;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.GenericMessage;
import model.beans.TestBean;
import model.components.TestBeanComponent;
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
public class TestBeanCreate extends BaseController {
   
    @Autowired
    private GenericMessage genericMessage;
    
    @Autowired
    private TestBeanComponent testBeanComponent;
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/testBean"},
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    public GenericMessage createTestBean(@ModelAttribute TestBean testBean, HttpServletResponse response) throws ServletException {

        //basic configuration        
        setHeaderNoChache(response);        
        long id;        

        try {            
            
            id = testBeanComponent.createObject(testBean);
            genericMessage.setCode(200);
            genericMessage.setId(id);
            genericMessage.setMessage(Constants.MESSAGE_SUCCESS);

        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return genericMessage;

    }
    
}
