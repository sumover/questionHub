package main.SQLConnctor.Exception;

public class NoAnswerException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("no answer in answer");
    }
}