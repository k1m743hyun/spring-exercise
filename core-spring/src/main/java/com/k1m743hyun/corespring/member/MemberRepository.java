package com.k1m743hyun.corespring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
