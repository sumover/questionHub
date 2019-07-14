package main.Module;


public abstract class Question {
    private int id;
    private int score;
    private String type;
    private static int QUESTION_NUM = 0;

    public Question(int score, String type) {
        this.score = score;
        this.type = type;
    }

    public Question() {
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

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
