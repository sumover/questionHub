package main.SQLConnctor;


import main.Module.User;

public class AddUser {
    private Connector connector;
    private static boolean autoSetId = false;

    public AddUser() {
        connector = Connector.getInstance();
    }

    public static void autoSetId(boolean t) {
        autoSetId = t;
    }

    /**
     * @param user 要插入的user
     * @return 插入user的id值, 请手动或自动设置
     * 如要自动插入改变id, 请使用静态的 autoSetId() 方法
     */
    int add(User user) {
        int id = connector.insertValues(
                "insert into user_data (name, password, register_date) values (?,?,current_date);",
                new String[]{user.getName(), user.getPassword()}
        );
        if (autoSetId) user.setId(id);
        return autoSetId ? 1 : id;
    }

    Integer[] addUsers(User[] users) {
        Integer[] integers = new Integer[users.length];
        for (int i = 0; i < users.length; ++i)
            integers[i] = add(users[i]);
        return integers;
    }
}
