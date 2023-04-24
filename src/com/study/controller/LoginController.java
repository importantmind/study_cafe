package com.study.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.dto.MemberDTO;

public class LoginController {
	
	private List<MemberDTO> members = new ArrayList<>();
	private MemberDTO member;
	
	public LoginController() {
		members.add(new MemberDTO("주진선", "010-1234-5678", 10000));
		members.add(new MemberDTO("장혜성", "010-1212-1212", 15000));
		members.add(new MemberDTO("김해든", "010-1212-3434", 12000));	
	}
	
	// 1. 회원 추가
	public boolean add(MemberDTO member) {
		if(findByMember(member) != null) {
			MemberDTO.count--;
			return false;
		}
		
		members.add(member);
		this.member = member;
		return true;
	}
	
	//2. 전체조회
	public List<MemberDTO> findAll(){
		System.out.println(members);
		return members;
	}
	
	//3. 한명 조회
	public MemberDTO findByMember(MemberDTO member) {
		for (MemberDTO memberDto : members) {
			if(memberDto.equals(member))
				this.member = memberDto;
				return memberDto;
		}
		MemberDTO.count--;
		return null; // 널...밖에 없나
	}
	
	//4. 수정
	public MemberDTO update(String name, String phoneNumber) {
		if(name.isEmpty() && phoneNumber.isEmpty()) return member;
		
		if(!(name.isEmpty()) && phoneNumber.isEmpty()) {
			member.setName(name);
			return member;
		}
		if(name.isEmpty() && !(phoneNumber.isEmpty())) {
			member.setPhoneNumber(phoneNumber);
			return member;
		}
		
		member.setName(name);
		member.setPhoneNumber(phoneNumber);
		return member;
	}
	
	//5. 회원 삭제
	public void remove (MemberDTO member) {
		if(member == null) {
			System.out.println("해당 회원이 없습니다.");
			return;
		}
		
		members.remove(member);
	}
	
	// 6. 돈 변경
	public void changeMoney(int money) {
		if(member == null) {
			System.out.println("로그인이 안되어 있습니다.");
			return;
		}
		member.setMoney(money);
		System.out.println("현재 보유한 돈이 수정되었습니다.");
	}
	
	// 7. 현재 회원
	public MemberDTO getMember() {
		return this.member;
	}

	
	
	

}
