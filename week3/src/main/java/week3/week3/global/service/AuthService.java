package week3.week3.global.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week3.week3.global.dto.response.JwtTokenSet;
import week3.week3.global.jwt.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);

        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .token(token)
                .build();

        return jwtTokenSet;
    }
}
