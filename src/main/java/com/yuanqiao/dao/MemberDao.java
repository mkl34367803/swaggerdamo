package com.yuanqiao.dao;

import com.yuanqiao.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {

    public Member selectMemberByIdWithCollection(int id);
    public Member selectMemberByIdWithCollectionTest(int id);

    public Member selectMemberById(int id);
    public List<Member> selectMembers();
}