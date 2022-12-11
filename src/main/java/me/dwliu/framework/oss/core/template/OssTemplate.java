package me.dwliu.framework.oss.core.template;

import me.dwliu.framework.oss.core.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 文件上传接口
 *
 * @author liudw
 * @date 2019-11-05 17:03
 **/
public interface OssTemplate {

	/**
	 * 获取文件信息
	 *
	 * @param fileName 文件名称
	 * @return
	 */
	FileInfo getStatFile(String fileName);

	/**
	 * 获取文件相对路径
	 *
	 * @param fileName 文件名称
	 * @return
	 */
	String getFileRelativePath(String fileName);

	/**
	 * 获取文件地址
	 *
	 * @param fileName 文件名称
	 * @return
	 */
	String getFileFullUrl(String fileName);

	/**
	 * 上传文件
	 *
	 * @param fileName 文件名称
	 * @param stream   文件流
	 * @return
	 */
	FileInfo putFile(String fileName, InputStream stream);

	/**
	 * 上传文件
	 *
	 * @param file        上传文件
	 * @param contentType 类型
	 * @return
	 */
	FileInfo putFile(MultipartFile file, String contentType);

	/**
	 * 上传文件
	 *
	 * @param file 上传文件类
	 * @return
	 */
	FileInfo putFile(MultipartFile file);

	/**
	 * 上传文件
	 *
	 * @param fileName 文件名称
	 * @param file     上传文件类
	 * @return
	 */
	FileInfo putFile(String fileName, MultipartFile file);

	/**
	 * 上传文件
	 *
	 * @param fileName    文件名称
	 * @param file        上传文件
	 * @param contentType 类型
	 * @return
	 */
	FileInfo putFile(String fileName, MultipartFile file, String contentType);

	/**
	 * 删除文件
	 *
	 * @param fileName 文件名称
	 */
	void removeFile(String fileName);

	/**
	 * 批量删除文件
	 *
	 * @param fileNames 文件名称集合
	 */
	void removeFiles(List<String> fileNames);


}
