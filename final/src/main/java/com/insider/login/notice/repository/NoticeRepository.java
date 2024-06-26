package com.insider.login.notice.repository;

import com.insider.login.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    List<Notice> findByMemberId(int memberId);

    Notice findByNoticeNo(int noticeNo);
}
