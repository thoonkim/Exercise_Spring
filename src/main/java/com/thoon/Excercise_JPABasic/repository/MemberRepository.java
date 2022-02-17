package com.thoon.Excercise_JPABasic.repository;

import com.thoon.Excercise_JPABasic.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
