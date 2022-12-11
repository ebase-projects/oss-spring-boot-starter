package me.dwliu.framework.oss.core.rule;

import me.dwliu.framework.oss.core.enums.OssFileNameFormatEnum;

/**
 * Oss通用规则
 *
 * @author liudw
 * @date 2019-11-05 14:44
 **/
public interface OssRule {

	/**
	 * 获取存储桶规则
	 *
	 * @param bucketName 存储桶名称
	 * @return
	 */
	String bucketName(String bucketName);

	/**
	 * 获取文件名规则
	 *
	 * @param originalName 原始文件名称
	 * @param format       文件前缀格式
	 * @return
	 */
	String setFileName(String originalName, OssFileNameFormatEnum format);


}
