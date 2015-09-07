package model.util;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author skuarch
 */
public class ResponseUtil {
    
    //==========================================================================
    private ResponseUtil(){
    
    }
    
    //==========================================================================
    public static void sendError(Object object, HttpServletResponse response, int httpServletResponse) throws Exception{
    
        if(response == null){
            throw new NullPointerException("response is null");
        }
        
        try {
            
            if(object == null){
                response.sendError(httpServletResponse);       
            }
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    
}
