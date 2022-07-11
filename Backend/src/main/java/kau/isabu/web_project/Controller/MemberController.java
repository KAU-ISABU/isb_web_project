package kau.isabu.web_project.Controller;

import kau.isabu.web_project.domain.member;
import kau.isabu.web_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        member Member = new member();
        Member.setName(form.getName());
        memberService.join(Member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<member> members=memberService.findMembers();
        model.addAttribute("members",members);//모델에 담아서 화면에 넘김
        return "members/memberList";
    }
}
