package me.dwliu.framework.oss.autoconfigure;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import me.dwliu.framework.oss.core.rule.OssRule;
import me.dwliu.framework.oss.service.minio.MinioOssTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * minio 自动装配
 *
 * @author liudw
 * @date 2019-11-06 10:47
 **/
@Configuration
@AutoConfigureAfter(OssAutoConfiguration.class)
@Import(OssAutoConfiguration.class)
@ConditionalOnProperty(prefix = OssConfigProperties.OSS_CONFIG_PREFIX + OssConfigProperties.OSS_CONFIG_TYPE_MINIO, value = "enabled", havingValue = "true")
public class MinioOssAutoConfiguration {

	@ConditionalOnMissingBean(MinioClient.class)
	@Bean
	@SneakyThrows
	public MinioClient minioClient(OssConfigProperties properties) {
		return MinioClient.builder()
			.endpoint(properties.getMinio().getEndpoint())
			.credentials(properties.getMinio().getAccessKey(), properties.getMinio().getSecretKey())
			.build();
	}

	@ConditionalOnBean({MinioClient.class, OssRule.class})
	@ConditionalOnMissingBean(MinioOssTemplate.class)
	@Bean
	@SneakyThrows
	public MinioOssTemplate minioOssTemplate(OssConfigProperties properties, OssRule ossRule) {
		return new MinioOssTemplate(properties.getMinio().getEndpoint(),
			properties.getMinio().getBucketName(),
			minioClient(properties), ossRule);
	}

}
