package com.insider.login.member.service;

import com.insider.login.member.dto.MemberDTO;
import com.insider.login.member.entity.Member;
import com.insider.login.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.RET;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private ModelMapper modelMapper;

    private MemberRepository memberRepository;

    public MemberService(MemberRepository userRepository, ModelMapper modelMapper) {
        this.memberRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<Member> findMember(int id) {
        System.out.println("받아온 id값은: " + id);
//        System.out.println("id의 타입: " + id.);

//        Optional<User> user = userRepository.findById(id);
//        Optional<Member> member = userRepository.findByMemberId(id);
        Optional<Member> member = memberRepository.findMemberByMemberId(id);
        System.out.println("찾은 member는: " + member);

        /*
        * 별도의 검증 로직 작성
        * 예) DB 문제로 구성원의 정보를 받지 못했다거나
        *    또는 여러 구성원들의 정보들을 반환을 했다거나...
        * 추가적인 로직을 작성을 해야한다.... no...
        * */

//        return null;
//        return userRepository.findById(id);
        return member;
    }

    public Member saveMember(Member member) {
        memberRepository.save(member);
        return member;
    }


    public List<MemberDTO> selectMemberList() {

        List<Member> member = memberRepository.findAll();

        List<MemberDTO> memberList = new ArrayList<>();

        for (Member members : member) {
            MemberDTO memberDTO = modelMapper.map(members, MemberDTO.class);
            memberList.add(memberDTO);
        }

        return memberList;
    }
}
