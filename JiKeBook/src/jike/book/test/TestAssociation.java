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
 * 关联查询测试
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
			// 联合查询
			// List<Author> ap=session.selectList("selectAuthorJoin");
			// 子查询
			List<Author> ap = session.selectList("selectAuthor");
			for (Author temp : ap) {
				// System.out.println("作者真实姓名="+temp.getRealName()+
				// ";对应的用户名="+temp.getJikeUser().getUserName());
				System.out.println("作者真是姓名="+temp.getRealName());
				System.out.println("懒加载应用了");
				//此时这条sql语句没有执行，而是用到的时候才执行
				System.out.println("对应的用户名="+temp.getJikeUser().getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
