package com.ballistic.barco.util;

import com.ballistic.barco.domain.auth.Authority;
import com.ballistic.barco.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mobile.device.Device;

/**
 * Created by Nabeel on 1/17/2018.
 */
@Component
public class BuiltInUtil {

    @Autowired
    private AuthorityRepository authorityRepository;
    private String[] authoritys;

    public BuiltInUtil() {}

    public String[] getAuthoritys() {
        Integer i = 0;
        for (Authority authority: this.authorityRepository.findAll()) {
            authoritys[i++] = authority.getName();
        }
        return authoritys;
    }


    public static Long getProcessTime() {
        return System.currentTimeMillis();
    }

}
