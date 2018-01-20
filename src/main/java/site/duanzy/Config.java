package site.duanzy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by dzy on 2018/1/20.
 */
@Configuration
@EnableRedisHttpSession         //开启spring session支持
public class Config {
    @Value("${custom.cookie.domain}")
    private String cookieDomainName;
    @Value("${custom.cookie.name}")
    private String cookieName;
    @Value("${custom.cookie.path}")
    private String cookiePath;

    /**
     * 子域session共享
     * @return
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        //cookie名字
        defaultCookieSerializer.setCookieName(cookieName);
        //域
        defaultCookieSerializer.setDomainName(cookieDomainName);
        //存储路径
        defaultCookieSerializer.setCookiePath(cookiePath);
        return defaultCookieSerializer;
    }
}
