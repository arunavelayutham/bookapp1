package Util;


		 
	import java.sql.Connection;
	 
	import org.springframework.jdbc.core.JdbcTemplate;
	 
public class Test
{
	 
	    public static void main(String[] args) throws Exception {
	        Connection con = ConnectionUtil.getConnection();
	        System.out.println(con);
	         
	        JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	        System.out.println(jdbcTemplate);
	 
	         
	    }
	 
	

}
