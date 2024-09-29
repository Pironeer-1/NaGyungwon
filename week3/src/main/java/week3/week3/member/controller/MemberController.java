package week3.week3.member.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week3.week3.global.dto.response.JwtTokenSet;
import week3.week3.global.dto.response.SuccessResponse;
import week3.week3.global.dto.response.result.SingleResult;
import week3.week3.member.dto.request.MemberCreateRequest;
import week3.week3.member.dto.request.MemberLoginRequest;
import week3.week3.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberCreateRequest request) {
        SingleResult<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginRequest request) {
        SingleResult<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }
}
