import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCPracticeDao implements PracticeDao{
    @Override
    public boolean insert(Practice practice) {
        boolean result = false;

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement(
                    "INSERT INTO JDBC_PRACTICE(TEST_STRING, TEST_INT, TEST_DOUBLE, TEST_STAMP)\n" +
                            "    VALUES (?, ?, ?, SYSDATE)"))
        {
            pStatement.setString(1, practice.getTest_string());
            pStatement.setInt(2, practice.getTest_int());
            pStatement.setDouble(3, practice.getTest_double());

            int rows = pStatement.executeUpdate();
            if(rows > 0)
                result = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    //테스트 완료. // 커밋 확인할것...
    @Override
    public List<Practice> fildAll() {
        List<Practice> pLst = new ArrayList();

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM JDBC_PRACTICE");
            ResultSet rs = pStatement.executeQuery())
        {
            while(rs.next())
            {
                Practice pr = new Practice();
                pr.setTest_index(rs.getInt("TEST_INDEX"));
                pr.setTest_string(rs.getString("TEST_STRING"));
                pr.setTest_int(rs.getInt("TEST_INT"));
                pr.setTest_double(rs.getDouble("TEST_DOUBLE"));
                pr.setTest_stamp(rs.getTimestamp("TEST_STAMP"));

                pLst.add(pr);
            }

            if (pLst.isEmpty()) {
                System.out.println("정보가 들어있지 않습니다.");
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return pLst;
    }

    @Override
    public Practice findByIndex(int _index) {
        Practice pr = null ;

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM JDBC_PRACTICE WHERE TEST_INDEX = ?"))
        {
            pStatement .setInt(1, _index);
            String query = "SELECT * FROM JDBC_PRACTICE WHERE TEST_INDEX = " + _index;

            ResultSet rs = pStatement.executeQuery();
            if(rs.next())
            {
                pr = new Practice();
                pr.setTest_index(rs.getInt("TEST_INDEX"));
                pr.setTest_string(rs.getString("TEST_STRING"));
                pr.setTest_int(rs.getInt("TEST_INT"));
                pr.setTest_double(rs.getDouble("TEST_DOUBLE"));
                pr.setTest_stamp(rs.getTimestamp("TEST_STAMP"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if(pr == null)
        {
            System.out.println("탐색에 실패했습니다.");
        }

        return pr;
    }

    @Override
    public Practice findByName(String _string) {
        Practice pr = null ;

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM JDBC_PRACTICE WHERE TEST_STRING = ?"))
        {
            pStatement .setString(1, _string);

            ResultSet rs = pStatement.executeQuery();
            if(rs.next())
            {
                pr = new Practice();
                pr.setTest_index(rs.getInt("TEST_INDEX"));
                pr.setTest_string(rs.getString("TEST_STRING"));
                pr.setTest_int(rs.getInt("TEST_INT"));
                pr.setTest_double(rs.getDouble("TEST_DOUBLE"));
                pr.setTest_stamp(rs.getTimestamp("TEST_STAMP"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if(pr == null)
        {
            System.out.println("탐색에 실패했습니다.");
        }

        return pr;
    }

    //INDEX를 비교하여 해당 INDEX 의 데이터를 수정해줌.
    @Override
    public boolean update(Practice practice) {
        boolean result = false;

        try(Connection conn = DataSource.getInstance().getConnection();
        PreparedStatement pStatement =
                conn.prepareStatement("UPDATE JDBC_PRACTICE SET TEST_STRING = ? , TEST_INT = ?, TEST_DOUBLE = ?, TEST_STAMP = ? WHERE TEST_INDEX = ?"))
        {
            pStatement.setString(1, practice.getTest_string());
            pStatement.setInt(2, practice.getTest_int());
            pStatement.setDouble(3, practice.getTest_double());
            pStatement.setTimestamp(4, practice.getTest_stamp());
            pStatement.setInt(5, practice.getTest_index());

            int executeCount = pStatement.executeUpdate();

            if(executeCount > 0)
                result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("변경 실패!");
            result = false;
        }

        return result;
    }


    @Override
    public boolean updateString(String _oldName, String _newName) {
        boolean result = false;

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement =
                    conn.prepareStatement("UPDATE JDBC_PRACTICE SET TEST_STRING = ? WHERE TEST_STRING = ?"))
        {
            pStatement.setString(1, _newName);
            pStatement.setString(2, _oldName);


            int executeCount = pStatement.executeUpdate();

            if(executeCount > 0)
                result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("변경 실패!");
            result = false;
        }

        return result;
    }

    @Override
    public boolean updateDouble(int _index, double _double) {
        boolean result = false;

        try(Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pStatement =
                    conn.prepareStatement("UPDATE JDBC_PRACTICE SET TEST_DOUBLE = ? WHERE TEST_INDEX = ?"))
        {
            pStatement.setDouble(1, _double);
            pStatement.setInt(2, _index);

            int executeCount = pStatement.executeUpdate();
            if(executeCount > 0)
                result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("변경 실패!");
            result = false;
        }

        return result;
    }

    @Override
    public boolean deleteByIndex(int _index) {
        boolean isSuecces = false;
        try (Connection conn = DataSource.getInstance().getConnection();
             PreparedStatement pStatement = conn.prepareStatement("DELETE FROM JDBC_PRACTICE WHERE TEST_INDEX = ?"))
        {
            pStatement.setInt(1, _index);
            int delectCount = pStatement.executeUpdate();

            if (delectCount > 0)
                isSuecces = true;
        } catch (Exception e) {
            System.out.println("삭제에 실패하였습니다.");
            e.printStackTrace();
            return false;
        }
        return isSuecces;
    }

}
