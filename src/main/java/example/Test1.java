package example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.log4j.Logger;

public class Test1 {

	private static Logger log = Logger.getLogger(Test1.class);
	// private static Logger log = Logger.getLogger();
	
	public static void main(String[] args) {
		String resource = "mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			log.debug(inputStream.getClass().getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		DefaultSqlSessionFactory sqlSessionFactory = (DefaultSqlSessionFactory) new SqlSessionFactoryBuilder().build(inputStream);
		DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("example.Test1.getUsers");
		log.info(user.toString());
		sqlSession.commit();
		sqlSession.close();
	}

}
