package mx.upiicsa.titulacion.exceptions;

import java.util.Map;
import java.util.TreeMap;

public class TitulacionException extends Exception {

    private static final long serialVersionUID = 1L;
    protected Map<String, String> messages;

    public TitulacionException() {
        super();
        messages = new TreeMap<String, String>();
    }

    public TitulacionException(String message) {
        super(message);
        messages = new TreeMap<String, String>();
    }

    public TitulacionException(Map<String, String> messages) {
        this.messages = messages;
    }

    public TitulacionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TitulacionException(Throwable cause) {
        super(cause);
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }
}
