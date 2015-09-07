package controllers.stage;

import controllers.application.BaseController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.beans.GenericMessage;
import model.beans.Stage;
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
public class StageCreate extends BaseController {
   
    @Autowired
    private GenericMessage genericMessage;    
   
    @Autowired
    private StageComponent stageComponent;
    
    //==========================================================================
    @ResponseBody
    @RequestMapping(
            value = {"/v1/stage"},
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    public GenericMessage createStage(@ModelAttribute Stage stage, HttpServletResponse response) throws ServletException {

        //basic configuration        
        setHeaderNoChache(response);
        long idStage;        
        

        try {            
            
            // save stage
            idStage = stageComponent.createObject(stage);
            
            genericMessage.setCode(HttpServletResponse.SC_OK);
            genericMessage.setId(idStage);
            genericMessage.setMessage(Constants.MESSAGE_SUCCESS);

        } catch (Exception e) {            
            throw new ServletException(e);
        }

        return genericMessage;

    }
    
}
