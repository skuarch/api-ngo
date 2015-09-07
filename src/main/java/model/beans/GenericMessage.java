package model.beans;

/**
 *
 * @author skuarch
 */
public class GenericMessage {

    private long id;
    private int code;
    private String message;

    public GenericMessage() {
    }
    
    public GenericMessage(long id, int code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
