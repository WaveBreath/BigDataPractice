package task1;

public class AgeException extends Exception{

    static final long serialVersionUID = -3387516993124229948L;
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
