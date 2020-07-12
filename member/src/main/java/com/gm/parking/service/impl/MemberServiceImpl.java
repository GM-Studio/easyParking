package com.gm.parking.service.impl;


import com.gm.parking.entity.Member;
import com.gm.parking.mapper.MemberMapper;
import com.gm.parking.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Squirrel-Chen
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public boolean saveMember(Member member) {
        return memberMapper.saveMember(member);
    }

    @Override
    public boolean updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    @Override
    public boolean deleteMemberById(int id) {
        return memberMapper.deleteMemberById(id);
    }

    @Override
    public Member memberById(int id) {
        return memberMapper.memberById(id);
    }

    @Override
    public List<Member> memberList() {
        return memberMapper.memberList();
    }
}
