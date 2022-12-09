package me.dwliu.framework.oss.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 存储配置类
 *
 * @author liudw
 * @date 2019-03-13 17:51
 **/
@Data
@ConfigurationProperties(value = OssConfigProperties.OSS_CONFIG_PREFIX)
public class OssConfigProperties {

	/**
	 * 配置前缀
	 */
	public static final String OSS_CONFIG_PREFIX = "oss";

	/**
	 * 本地 配置
	 */
	public static final String OSS_CONFIG_TYPE_LOCAL = ".local";
	/**
	 * fastDFS 配置
	 */
	public static final String OSS_CONFIG_TYPE_FASTDFS = ".fastdfs";
	/**
	 * qiniu 配置
	 */
	public static final String OSS_CONFIG_TYPE_QINIU = ".qiniu";
	/**
	 * minio 配置
	 */
	public static final String OSS_CONFIG_TYPE_MINIO = ".minio";
	/**
	 * aliyun 配置
	 */
	public static final String OSS_CONFIG_TYPE_ALIYUN = ".aliyun";

	/**
	 * 是否开启租户模式
	 */
	private Boolean tenantMode;

	/**
	 * 路径前缀
	 */
	private String prefix;

	/**
	 * qiniu 存储
	 */
	private QiniuOssConfigProperties qiniu = new QiniuOssConfigProperties();

	/**
	 * minio 存储
	 */
	private MinioOssConfigProperties minio = new MinioOssConfigProperties();
	/**
	 * aliyun 存储
	 */
	private AliyunOssConfigProperties aliyun = new AliyunOssConfigProperties();

}
