package controllers.testBean;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.TestBean;
import model.components.TestBeanComponent;
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
public class TestBeanGet extends BaseController {
    
    @Autowired
    private TestBeanComponent testBeanComponent;
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/testBean/{id}"},
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public TestBean getTestBean(@PathVariable("id") long id, HttpServletResponse response) throws ServletException {

        //basic configuration        
        setHeaderNoChache(response);

        TestBean testBean = null;

        try {

            testBean = testBeanComponent.getObject(id, TestBean.class);            
            ResponseUtil.sendError(testBean, response, HttpServletResponse.SC_NOT_FOUND);

        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return testBean;

    }
    
}
