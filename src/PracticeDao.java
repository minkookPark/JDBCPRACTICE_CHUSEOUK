import java.util.List;

public interface PracticeDao {
    boolean insert(Practice practice);
    List<Practice> fildAll();
    Practice findByIndex(int _index);
    Practice findByName(String _name);
    boolean update(Practice practice);
    boolean updateString(String _oldName, String _newName);
    boolean updateDouble(int _index, double _double);
    boolean deleteByIndex(int _index);
}
