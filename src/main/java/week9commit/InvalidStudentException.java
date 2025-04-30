package week9commit;

public class InvalidStudentException extends RuntimeException {
    public InvalidStudentException(String message) {
        super(message);
        //i remembered when you told us about this solution for making our own execption and i thought to give it a try, best decision :)
    }
}