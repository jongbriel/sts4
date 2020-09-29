package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Course;

public class CourseDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.CourseMapper.";
	
	public CourseDao() {
		try {
			InputStream mybatisConfigInputStream=Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	@@@@@@@@@@@@@@@ SELECT[JOIN] @@@@@@@@@@@@@@@@@
	resultMap: [ courses + students 조인 ]
	*/
	public Course findCourseByIdWithStudents(int courseId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Course findCourse=sqlSession.selectOne(NAMESPACE+"findCourseByIdWithStudents", courseId);
		sqlSession.close();
		return findCourse;
	}
	
	
	
	
}









