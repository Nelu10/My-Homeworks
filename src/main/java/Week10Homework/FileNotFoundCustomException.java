package Week10Homework;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileNotFoundCustomException extends IOException{
    public FileNotFoundCustomException(String message, Throwable cause){
        super(message, cause);
    }
}