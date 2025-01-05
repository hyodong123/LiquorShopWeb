package kr.ac.kopo.dao;

import kr.ac.kopo.vo.MemberVO;

import java.util.Map;

public interface MemberDAO {
    void insertMember(MemberVO member) throws Exception;

    MemberVO selectMemberById(int memberId) throws Exception;

    MemberVO selectMemberByEmail(String email) throws Exception;

    boolean isEmailDuplicate(String email) throws Exception;

    boolean isSocialAccountDuplicate(String socialProvider, String socialAccountId) throws Exception;

    MemberVO selectMemberByEmailAndPassword(Map<String, String> params) throws Exception;

    String getMemberAddressById(int memberId) throws Exception;
    
    // 회원 정보 조회
    MemberVO getMemberById(int memberId) throws Exception;

    // 회원 프로필 수정
    void updateMemberProfile(MemberVO member) throws Exception;
}
