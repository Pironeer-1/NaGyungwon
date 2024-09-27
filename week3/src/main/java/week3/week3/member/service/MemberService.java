package week3.week3.member.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week3.week3.global.dto.response.JwtTokenSet;
import week3.week3.global.dto.response.result.SingleResult;
import week3.week3.global.exception.CustomException;
import week3.week3.global.exception.ErrorCode;
import week3.week3.global.service.AuthService;
import week3.week3.global.service.ResponseService;
import week3.week3.member.dto.request.MemberCreateRequest;
import week3.week3.member.dto.request.MemberLoginRequest;
import week3.week3.member.entity.Member;
import week3.week3.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberCreateRequest request) {
        if (memberRepository.existByMemberId(request.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();
        newMember = memberRepository.save(newMember);

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginRequest request) {
        Member member = memberRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(request.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }
}

