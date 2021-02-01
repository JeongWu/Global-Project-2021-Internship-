package com.eximbay.okr.security;

import java.util.ArrayList;
import java.util.List;

import com.eximbay.okr.entity.Member;
import com.eximbay.okr.repository.MemberRepository;
import com.eximbay.okr.service.MemberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    public static final Logger LOG = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private MemberService memberService;

    public CustomAuthenticationProvider() {
        super();
    }

    // API

    @Override
    public Authentication authenticate(final Authentication authentication)  throws AuthenticationException {

        LOG.info("Member: " + authentication.getName() + " Password: " + authentication.getCredentials().toString());

        // final User user = userRepository.findByEmail(authentication.getName());
        // if ((user == null)) {
        //     System.out.println("OHHHHHHHHHHHHHHHHHHHHHEEEEEEEEEEEEREEEEEEEEEEEEEEEEEEEEEE");
        //     throw new BadCredentialsException("Invalid username or password");
        // }

        // final Authentication result = authenticate(authentication);
        // return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());

        //String verificationCode = ((CustomWebAuthenticationDetails) authentication.getDetails()).getVerificationCode();

        //LOG.info("VerificationCode: " + verificationCode);

        Member member = memberService.findByUserId(authentication.getName());
        System.out.println("Member : "+member);
        String encodedPassword = new BCryptPasswordEncoder().encode(authentication.getCredentials().toString());
        
        System.out.println(member.getPassword() + " : " + encodedPassword);

        if ((member == null) && !member.getPassword().equals(encodedPassword)) {
            throw new BadCredentialsException("Invalid username or password");
        }
        // if (user.isUsing2FA()) {
        //     Totp totp = new Totp(user.getSecret());
        //     if (!isValidLong(verificationCode) || !totp.verify(verificationCode)) {
        //         throw new BadCredentialsException("Invalid verfication code");
        //     }
        // }
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_TEAM"));

        //Authentication result = authenticate(authentication);
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authorities);

    }

    private boolean isValidLong(String code) {
        try {
            Long.parseLong(code);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}