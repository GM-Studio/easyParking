package com.gm.parking.service;

import com.gm.parking.entity.Member;
import java.util.List;

public interface MemberService {


    public boolean saveMember(Member member);
    public boolean updateMember(Member member);
    public boolean deleteMemberById(int id);
    public Member memberById(int id);
    public List<Member> memberList();

}
