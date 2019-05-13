package com.kish.boot.learning.cloudconfigclient.env.listener;

import com.kish.boot.learning.cloudconfigclient.ssl.SSLUtil;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        String activeProfiles[] = event.getEnvironment().getActiveProfiles();

        boolean profileFound = Arrays.asList(activeProfiles).stream().filter( x-> ("local".equals(x) || ("localdocker".equals(x))))
                .findFirst().isPresent();
        if(profileFound){
            try {
                SSLUtil.turnOffSslChecking();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }

    }
}
