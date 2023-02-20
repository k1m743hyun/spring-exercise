package com.k1m743hyun.corespring.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
