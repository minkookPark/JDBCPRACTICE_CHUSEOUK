import java.sql.Timestamp;

public class Practice {
    private int test_index;
    private String test_string;
    private int test_int;
    private double test_double;
    private Timestamp test_stamp;


    public Practice() {
    }



    public Practice(String test_string, int test_int, double test_double) {
        this.test_string = test_string;
        this.test_int = test_int;
        this.test_double = test_double;
    }

    public Practice(String test_string, int test_int, double test_double, Timestamp test_stamp) {
        this.test_string = test_string;
        this.test_int = test_int;
        this.test_double = test_double;
        this.test_stamp = test_stamp;
    }

    public Practice(int test_index, String test_string, int test_int, double test_double, Timestamp test_stamp) {
        this.test_index = test_index;
        this.test_string = test_string;
        this.test_int = test_int;
        this.test_double = test_double;
        this.test_stamp = test_stamp;
    }

    //deep copy constructor
    public Practice(Practice practice)
    {
        this.test_index = practice.getTest_index();
        this.test_string = practice.getTest_string();
        this.test_int = practice.getTest_int();
        this.test_double = practice.getTest_double();
        this.test_stamp = practice.getTest_stamp();
    }

    public int getTest_index() {
        return test_index;
    }

    public void setTest_index(int test_index) {
        this.test_index = test_index;
    }

    public String getTest_string() {
        return test_string;
    }

    public void setTest_string(String test_string) {
        this.test_string = test_string;
    }

    public int getTest_int() {
        return test_int;
    }

    public void setTest_int(int test_int) {
        this.test_int = test_int;
    }

    public double getTest_double() {
        return test_double;
    }

    public void setTest_double(double test_double) {
        this.test_double = test_double;
    }

    public Timestamp getTest_stamp() {
        return test_stamp;
    }

    public void setTest_stamp(Timestamp test_stamp) {
        this.test_stamp = test_stamp;
    }

    @Override
    public String toString() {
        return "Practice{" +
                "test_index=" + test_index +
                ", test_string='" + test_string + '\'' +
                ", test_int=" + test_int +
                ", test_double=" + test_double +
                ", test_stamp=" + test_stamp +
                '}';
    }

}
