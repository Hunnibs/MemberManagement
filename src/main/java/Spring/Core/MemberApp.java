/*
스프링
 */

package Spring.Core;

import Spring.Core.member.Grade;
import Spring.Core.member.Member;
import Spring.Core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
 public static void main(String[] args) {
/*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
*/

     ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("MemberService", MemberService.class);
        Member member = new Member(1L, "LEE BYUNG HEON", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member is " + member.getName());
        System.out.println("find Member is " + findMember.getName());
    }
}
