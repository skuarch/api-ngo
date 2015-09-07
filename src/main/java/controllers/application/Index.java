package controllers.application;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class Index extends BaseController {

    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/", "index.*", "index"},
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    public String index(HttpServletResponse response) throws ServletException {

        //basic configuration        
        setHeaderNoChache(response);

        return "";

    }

}
