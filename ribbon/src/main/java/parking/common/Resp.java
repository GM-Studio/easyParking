package parking.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Squirrel-Chen
 */
public class Resp implements Serializable {
    private static final long serialVersionUID = -1328628515087500133L;

    private String code;
    private Map<String, Object> data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Resp(String code, Map<String, Object> data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
