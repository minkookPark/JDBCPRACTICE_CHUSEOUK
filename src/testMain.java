public class testMain {
    public static void main(String[] args) {
        JDBCPracticeDao dao = new JDBCPracticeDao();

        Practice pr = new Practice("test2", 314, 3.14d);


        dao.insert(pr);


        for(Practice p : dao.fildAll())
        {
            System.out.println(p);
        }
    }
}
