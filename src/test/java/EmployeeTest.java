import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 *
 **/
public class EmployeeTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetEmployeeByConditionIf() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL employeeMapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(1, "tom", null, null);
        List<Employee> employeeList = employeeMapper.getEmployeeByConditionIf(employee);
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testGetEmployeeByConditionTrim() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL employeeMapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(2, "jerry", "jerry@163", null);
        List<Employee> employeeList = employeeMapper.getEmployeeByConditionTrim(employee);
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testGetEmployeeByConditionChoose() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL employeeMapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(3, "lucy", "tom@126", null);
        List<Employee> employeeList = employeeMapper.getEmployeeByConditionChoose(employee);
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testUpdateEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL employeeMapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(1, "tom", "tom@126", null);
        employeeMapper.updateEmployee(employee);
        sqlSession.commit();
        System.out.println("更新完毕");
    }

    @Test
    public void testGetEmployeeByConditionForeach() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL employeeMapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        List<Integer> list = Arrays.asList(1,2,3);
        List<Employee> employeeList = employeeMapper.getEmployeeByConditionForeach(list);
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }
}
