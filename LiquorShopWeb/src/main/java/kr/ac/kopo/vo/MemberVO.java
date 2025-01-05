package kr.ac.kopo.vo;

import java.sql.Timestamp;

public class MemberVO {

    private int memberId;           // 회원 고유 ID
    private String email;           // 이메일
    private String password;        // 비밀번호 (일반 로그인 시)
    private String username;        // 사용자 이름
    private String phoneNumber;     // 전화번호
    private String address;         // 주소
    private Timestamp joinDate;     // 가입 날짜
    private String membershipType;  // 회원 유형 ('USER', 'ADMIN')
    private String socialProvider;  // 소셜 로그인 제공자 (Google, Facebook 등)
    private String socialAccountId; // 소셜 계정 ID

    // Getters and Setters

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getSocialProvider() {
        return socialProvider;
    }

    public void setSocialProvider(String socialProvider) {
        this.socialProvider = socialProvider;
    }

    public String getSocialAccountId() {
        return socialAccountId;
    }

    public void setSocialAccountId(String socialAccountId) {
        this.socialAccountId = socialAccountId;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "memberId=" + memberId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", joinDate=" + joinDate +
                ", membershipType='" + membershipType + '\'' +
                ", socialProvider='" + socialProvider + '\'' +
                ", socialAccountId='" + socialAccountId + '\'' +
                '}';
    }
}
