package jike.book.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.Author;

/*
 * ������ѯ����
 * */
public class TestAssociation {

	public static void main(String[] args) {
		String resource = "jike/book/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		session = sqlMapper.openSession();
		try {
			// ���ϲ�ѯ
			// List<Author> ap=session.selectList("selectAuthorJoin");
			// �Ӳ�ѯ
			List<Author> ap = session.selectList("selectAuthor");
			for (Author temp : ap) {
				// System.out.println("������ʵ����="+temp.getRealName()+
				// ";��Ӧ���û���="+temp.getJikeUser().getUserName());
				System.out.println("������������="+temp.getRealName());
				System.out.println("������Ӧ����");
				//��ʱ����sql���û��ִ�У������õ���ʱ���ִ��
				System.out.println("��Ӧ���û���="+temp.getJikeUser().getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}