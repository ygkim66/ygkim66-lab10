import java.io.IOException;

public class TooSmallText extends IOException {
    public TooSmallText(String s){
        super(s);
    }
}
