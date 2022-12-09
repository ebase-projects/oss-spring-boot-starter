package me.dwliu.framework.oss.autoconfigure;

import me.dwliu.framework.oss.core.rule.DefaultOssRule;
import me.dwliu.framework.oss.core.rule.OssRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储自动配置类
 *
 * @author liudw
 * @date 2019-03-13 17:35
 **/
@Configuration
@EnableConfigurationProperties(OssConfigProperties.class)
@ConditionalOnClass({OssRule.class})
//@ConditionalOnProperty(prefix = OssConfigProperties.OSS_CONFIG_PREFIX, value = "enabled", havingValue = "true")
public class OssAutoConfiguration {

	@ConditionalOnMissingBean(OssRule.class)
	@Bean
	public OssRule ossRule(OssConfigProperties properties) {
		return new DefaultOssRule(properties.getPrefix());
	}

}
