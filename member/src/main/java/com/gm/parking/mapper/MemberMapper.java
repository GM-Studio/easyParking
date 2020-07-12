package com.gm.parking.mapper;


import com.gm.parking.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public boolean saveMember(Member member);
    public boolean updateMember(Member member);
    public boolean deleteMemberById(int id);
    public Member memberById(int id);
    public List<Member> memberList();

}
