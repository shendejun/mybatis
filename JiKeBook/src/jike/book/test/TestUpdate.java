package jike.book.test;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.JiKeUser;

public class TestUpdate {

	public static void main(String[] args) {
		String resource = "jike/book/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		session = sqlMapper.openSession();
		try {
			/*insert*/

			JiKeUser jku=new JiKeUser();
			jku.setUserName("jike001");
			jku.setPassword("123456");
			session.insert("insertUser",jku);
			session.commit();

			
			/*update*/
			/*JiKeUser jku=new JiKeUser();
			jku.setUserName("jike001");
			jku.setPassword("1234567");
			jku.setId(1);
			session.update("updateUser",jku);
			session.commit();*/
			
			/*delete*/
			/*采用接口映射的方式，实际开发中不推荐使用*/
			/*InterfaceJiKeUserMap ijum=session.getMapper(InterfaceJiKeUserMap.class);
			ijum.deleteUser(1);
			session.commit();*/
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
