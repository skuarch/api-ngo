package controllers.testBean;

import controllers.application.BaseController;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.TestBean;
import model.database.HibernateConnection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class TestBeanGetList extends BaseController {

    //==========================================================================
    @RequestMapping (
            value = "/v1/testBean/list", 
            method = RequestMethod.GET, 
            produces = {"application/json"}
    )
    public @ResponseBody
    List<TestBean> getTestBeanList(HttpServletResponse response) throws ServletException {        
        
       //basic configuration        
        setHeaderNoChache(response);

        List<TestBean> testBeanList = null;

        try {

            testBeanList = new HibernateConnection().getList(TestBean.class);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        return testBeanList;

    }

}
