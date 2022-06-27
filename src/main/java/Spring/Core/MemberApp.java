/*
스프링 사용하지 않은 테스트
 */

package Spring.Core;

import Spring.Core.member.Grade;
import Spring.Core.member.Member;
import Spring.Core.member.MemberService;
import Spring.Core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "LEE BYUNG HEON", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member is " + member.getName());
        System.out.println("find Member is " + findMember.getName());
    }
}
