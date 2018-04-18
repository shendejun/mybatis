package jike.book.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.JiKeUser;

public class TestSelect {

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
			/*ʹ��map��������*/
			/*HashMap<String,String> hm=new HashMap();
			hm.put("userName", "jike001");
			hm.put("password", "123456");
			JiKeUser temp=session.selectOne("loginSelect",hm);
			if(temp!=null) {
				System.out.println("��¼�ɹ�");
			}*/
			
			/*ʹ�ö��󴫵�*/
			/*JiKeUser jku=new JiKeUser();
			jku.setUserName("jike001");
			jku.setPassword("123456");
			JiKeUser temp=session.selectOne("login2",jku);
			if(temp!=null) {
				System.out.println("��¼�ɹ�");
			}*/
			
			/*���ض�����¼*/
			/*List<JiKeUser> ap=session.selectList("selectJiKeUserList");
			for(JiKeUser temp:ap) {
				System.out.println("�û���="+temp.getUserName());
			}*/
			/*ʹ��resultMap���շ��ض���*/
			List<JiKeUser> ap=session.selectList("selectUsers");
			for(JiKeUser temp:ap) {
				System.out.println("�û���="+temp.getUserName());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
