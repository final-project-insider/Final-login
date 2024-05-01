package com.insider.login.commute.repository;

import com.insider.login.commute.entity.Commute;
import com.insider.login.member.entity.Department;
import com.insider.login.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommuteRepository extends JpaRepository<Commute, Integer> {

    Commute findByCommuteNo(int commuteNo);

//    List<Commute> findByMemberId(int memberId);

    List<Commute> findByMemberIdAndWorkingDateBetween(int memberId, LocalDate startWeek, LocalDate endWeek);

    List<Commute> findByMemberDepartmentDepartNoAndWorkingDateBetween(int departNo, LocalDate startDayOfMonth, LocalDate endDayOfMonth);

    List<Commute> findByMemberAndWorkingDateBetween(Member member, LocalDate startDayOfMonth, LocalDate endDayOfMonth);
}
