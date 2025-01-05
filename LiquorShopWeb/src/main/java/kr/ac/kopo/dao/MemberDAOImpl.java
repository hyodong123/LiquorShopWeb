package kr.ac.kopo.dao;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

public class MemberDAOImpl implements MemberDAO {
    private SqlSessionFactory sqlSessionFactory;

    public MemberDAOImpl() {
        this.sqlSessionFactory = MyConfig.getSqlSessionFactory();
    }

    @Override
    public void insertMember(MemberVO member) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("MemberMapper.insertMember", member);
            session.commit();
        }
    }

    @Override
    public MemberVO selectMemberById(int memberId) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.selectMemberById", memberId);
        }
    }

    @Override
    public MemberVO selectMemberByEmail(String email) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.selectMemberByEmail", email);
        }
    }

    @Override
    public boolean isEmailDuplicate(String email) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Integer count = session.selectOne("MemberMapper.isEmailDuplicate", email);
            return count != null && count > 0;
        }
    }

    @Override
    public boolean isSocialAccountDuplicate(String socialProvider, String socialAccountId) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, String> params = new HashMap<>();
            params.put("socialProvider", socialProvider);
            params.put("socialAccountId", socialAccountId);
            Integer count = session.selectOne("MemberMapper.isSocialAccountDuplicate", params);
            return count != null && count > 0;
        }
    }

    @Override
    public MemberVO selectMemberByEmailAndPassword(Map<String, String> params) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.selectMemberByEmailAndPassword", params);
        }
    }

    @Override
    public String getMemberAddressById(int memberId) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.getMemberAddressById", memberId);
        }
    }

    // 회원 프로필 수정
    @Override
    public void updateMemberProfile(MemberVO member) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("MemberMapper.updateMemberProfile", member); // MyBatis 매퍼에서 처리
            session.commit();
        }
    }

    @Override
    public MemberVO getMemberById(int memberId) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("MemberMapper.selectMemberById", memberId);
        }
    }
}
