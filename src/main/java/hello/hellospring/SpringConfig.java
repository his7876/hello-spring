package hello.hellospring;


import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;



   /* private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);


    }


    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }



    /*
    @Bean
    public MemberRepository memberRepository(){

        return new JpaMemberRepository(em);
    }

     */

}
