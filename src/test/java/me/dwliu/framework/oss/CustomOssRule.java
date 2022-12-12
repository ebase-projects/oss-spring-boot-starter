package me.dwliu.framework.oss;

import me.dwliu.framework.oss.core.enums.OssFileNameFormatEnum;
import me.dwliu.framework.oss.core.rule.OssRule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 自定义的oss规则
 *
 * @author liudw
 * @date 2022/12/12 11:13
 **/
//@Component //自定义关闭
public class CustomOssRule implements OssRule {
	/**
	 * 自定义属性获取
	 */
	@Value("${oss.prefix}")
	private String prefix;


	@Override
	public String setFileName(String originalFileName, OssFileNameFormatEnum format) {
		StringBuilder builder = new StringBuilder();
		builder.append(StringUtils.isBlank(prefix) ? "" : prefix);
		System.out.println(prefix);
		if (format == OssFileNameFormatEnum.NONE) {
			builder.append(originalFileName);
		} else if (format == OssFileNameFormatEnum.UUID) {
			builder.append(UUID.randomUUID().toString().replace("-", ""));
			builder.append("-");
			builder.append(originalFileName);
		} else if (format == OssFileNameFormatEnum.DATE) {
			builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(OssFileNameFormatEnum.DATE.getDesc())));
			builder.append("/");
			builder.append(originalFileName);
		} else if (format == OssFileNameFormatEnum.DATETIME) {
			builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(OssFileNameFormatEnum.DATETIME.getDesc())));
			builder.append("-");
			builder.append(originalFileName);
		} else if (format == OssFileNameFormatEnum.DATE_UUID) {
			builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(OssFileNameFormatEnum.DATE.getDesc())));
			builder.append("/");
			builder.append(UUID.randomUUID().toString().replace("-", ""));
			builder.append("-");
			builder.append(originalFileName);
		} else if (format == OssFileNameFormatEnum.CUSTOM) {
			//自定义添加规则
			builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM")));
			builder.append("/");
			builder.append(UUID.randomUUID().toString().replace("-", ""));
			builder.append("-");
			builder.append(originalFileName);
		} else {
			builder.append(originalFileName);
		}
		return builder.toString();
	}
}
