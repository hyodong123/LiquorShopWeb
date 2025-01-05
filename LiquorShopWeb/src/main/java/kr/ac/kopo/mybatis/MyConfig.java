package kr.ac.kopo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // MyBatis 설정 파일 경로
            String resource = "kr/ac/kopo/mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            // db.properties 파일 로드
            Properties properties = new Properties();
            try (InputStream dbStream = Resources.getResourceAsStream("kr/ac/kopo/mybatis/db.properties")) {
                if (dbStream == null) {
                    throw new IOException("db.properties 파일을 찾을 수 없습니다.");
                }
                properties.load(dbStream);
            }

            // SqlSessionFactory 생성 (환경 변수 설정)
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("MyBatis SqlSessionFactory 초기화 실패: " + e.getMessage());
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
