package exceptions;

import java.io.IOException;

public class NotDataFoundForTheKey extends IOException {

    public NotDataFoundForTheKey(String msg){
        try {
            throw new IOException(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
