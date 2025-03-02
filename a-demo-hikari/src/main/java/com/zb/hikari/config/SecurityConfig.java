package com.zb.hikari.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletRequest;

//public class SecurityConfig {
//
//}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String WHITELIST_IP = "99.17.207.";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/hikari-demo/**").permitAll()
            .antMatchers("/high/**", "/hikari-demo/**").access("@ipCheckSecurity.check(request)")  // 调用自定义鉴权逻辑
//            .antMatchers("/high/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    // 自定义鉴权逻辑 Bean
    @Bean
    public IpCheckSecurity ipCheckSecurity() {
        return new IpCheckSecurity();
    }

    public static class IpCheckSecurity {
        public boolean check(HttpServletRequest request) {

            String clientIP = getClientRealIP(request);
            // 检查域名或主机地址
            String serverName = request.getServerName().toLowerCase();

//            boolean validDomain = serverName.contains(LOCALHOST) || serverName.contains(LOCALHOST_IP)
//                || serverName.contains(WHITELIST_IP);
//            // 获取真实客户端IP（考虑代理情况）
//            boolean validIP = "55.25.1.1".equals(clientIP);

            boolean validDomain = serverName.matches(".*(localhost|127\\.0\\.0\\.1|192\\.168\\.\\d+\\.\\d+).*");
            boolean validIP = clientIP.startsWith(WHITELIST_IP); // C类地址段

            return validDomain || validIP;
        }

        private String getClientRealIP(HttpServletRequest request) {
            // 代理服务器转发时使用的标准头
            String ip = request.getHeader("X-Forwarded-For");

            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }

            // 处理多级代理情况（取第一个IP）
            if (ip != null && ip.contains(",")) {
                ip = ip.split(",")[0].trim();
            }

            return ip;
        }

    }
}
