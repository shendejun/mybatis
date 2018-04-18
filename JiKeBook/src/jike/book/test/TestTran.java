package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.Author;
import jike.book.pojo.JiKeUser;

public class TestTran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		//�ر��Զ��ύ
		session = sqlMapper.openSession(false);//Ĭ��Ҳ��fasle
		try {
			JiKeUser one=new JiKeUser();
			one.setUserName("author001");
			one.setPassword("123456");
			session.insert("insertUser",one);
			System.out.println("�¼����user id="+one.getId());
			
			Author at=new Author();
			at.setJikeUser(one);
			at.setRealName("һֻ��ţ");
			session.insert("insertAuthor",at);
			//�ύ����
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			session.rollback();
		}finally {
			session.close();
		}
	}

}