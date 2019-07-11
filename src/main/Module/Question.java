package main.Module;

enum QUESTION_TYPE {
    multiple_choice,
}

public abstract class Question {
    private int id;
    private int score;
    QUESTION_TYPE type;
    private static int QUESTION_NUM = 0;

    public Question(int score, QUESTION_TYPE type) {
        this.score = score;
        this.type = type;
        this.id = QUESTION_NUM++;
    }

    public int getId() {
        return id;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QUESTION_TYPE getType() {
        return type;
    }
}
