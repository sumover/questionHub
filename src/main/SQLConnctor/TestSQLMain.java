package main.SQLConnctor;

import main.Module.*;

import java.util.List;

public class TestSQLMain {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "            \"A\":0,\n" +
                "            \"B\":1,\n" +
                "            \"C\":2,\n" +
                "            \"D\":3\n" +
                "        }";

        List<Options> list = MultipleChoice.getOptionsListByJSON(jsonString);
        for (int i = 0; i < list.size(); ++i) {
            Object o = list.get(i);

        }
    }
}
