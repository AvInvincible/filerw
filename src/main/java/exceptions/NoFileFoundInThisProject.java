package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class NoFileFoundInThisProject extends FileNotFoundException {

    public NoFileFoundInThisProject(String msg){
        try {
            throw new FileNotFoundException(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
