package me.dwliu.framework.oss;

import lombok.extern.slf4j.Slf4j;
import me.dwliu.framework.oss.core.enums.OssFileNameFormatEnum;
import me.dwliu.framework.oss.core.model.FileInfo;
import me.dwliu.framework.oss.core.rule.OssRule;
import me.dwliu.framework.oss.service.minio.MinioOssTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

@SpringBootApplication
@SpringBootTest
@Slf4j
public class MinioOssTemplateTest {
	@Autowired
	private MinioOssTemplate minioOssTemplate;
	@Autowired
	private OssRule ossRule;
	private String bucketName = "101065";
	private String fileName = "Koala.jpg";
	private String filePath = "/Users/liudw/Pictures/" + fileName;

	//public MinioOssTemplateTest(MinioOssTemplate minioOssTemplate, OssRule ossRule) {
	//	this.minioOssTemplate = minioOssTemplate;
	//	this.ossRule = ossRule;
	//}

	//@Value("${oss.minio.bucketName}")
	//private String bucketNameByYml;

	/**
	 * 默认桶名称
	 */
	@Test
	public void getBucketName() {
		String res = minioOssTemplate.getBucketName();
		// 断言返回的文本包含文件的内容
		log.info("默认桶名称：{}", res);
		Assertions.assertTrue(res.contains("default"));
		//if (StringUtils.isBlank(bucketNameByYml)) {
		//
		//} else {
		//	Assertions.assertTrue(res.contains(bucketNameByYml));
		//}
	}

	/**
	 * 自定义桶名称
	 */
	@Test
	void testGetBucketName() {
		String res = minioOssTemplate.getBucketName(bucketName);
		log.info("自定义桶名称：{}", res);
		// 断言返回的文本包含文件的内容
		Assertions.assertTrue(res.contains(bucketName));

	}

	@Test
	void makeBucket() {
		String bucketName = "bucket";
		minioOssTemplate.makeBucket(bucketName);
		String res = minioOssTemplate.getBucketName(bucketName);
		// 断言返回的文本包含文件的内容
		Assertions.assertTrue(res.contains(bucketName));
	}

	@Test
	void removeBucket() {
		String bucketName = UUID.randomUUID().toString().replace("-", "");
		minioOssTemplate.makeBucket(bucketName);
		boolean b = minioOssTemplate.bucketExists(bucketName);
		Assertions.assertTrue(b);
		minioOssTemplate.removeBucket(bucketName);
		b = minioOssTemplate.bucketExists(bucketName);
		Assertions.assertFalse(b);

	}

	@Test
	void bucketExists() {
		String bucketName = UUID.randomUUID().toString().replace("-", "");
		minioOssTemplate.makeBucket(bucketName);
		boolean b = minioOssTemplate.bucketExists(bucketName);
		Assertions.assertTrue(b);
		minioOssTemplate.removeBucket(bucketName);
		b = minioOssTemplate.bucketExists(bucketName);
		Assertions.assertFalse(b);
	}

	//@Test
	//void copyFile() {
	//	minioOssTemplate.copyFile(bucketName, fileName, "default");
	//}

	//@Test
	//void testCopyFile() {
	//}

	@Test
	void getStatFile() {
		FileInfo statFile = minioOssTemplate.getStatFile(bucketName, fileName);
		log.info("{}", statFile);
	}

	@Test
	void testGetStatFile() {
	}

	@Test
	void getFileRelativePath() {
	}

	@Test
	void testGetFileRelativePath() {
	}

	@Test
	void getFileFullUrl() {
	}

	@Test
	void testGetFileFullUrl() {
	}

	@Test
	public void putFile() throws FileNotFoundException {

		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);

		FileInfo fileInfo = minioOssTemplate.putFile(fileName, fileInputStream);
		log.info(fileInfo.toString());

	}

	@Test
	public void putFile1() throws FileNotFoundException {
		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);

		FileInfo fileInfo = minioOssTemplate.putFile(bucketName, fileName, fileInputStream);
		log.info(fileInfo.toString());
	}

	@Test
	public void putFile2() throws FileNotFoundException {

		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		String originFileName = this.fileName;
		String fileName = ossRule.setFileName(this.fileName, OssFileNameFormatEnum.CUSTOM);

		FileInfo fileInfo = minioOssTemplate.putFile(bucketName, originFileName, fileName, fileInputStream);
		log.info(fileInfo.toString());
	}

	@Test
	void testPutFile2() {
	}

	@Test
	void testPutFile3() {
	}

	@Test
	void testPutFile4() {
	}

	@Test
	void testPutFile5() {
	}

	@Test
	void testPutFile6() {
	}

	@Test
	void testPutFile7() {
	}

	@Test
	void removeFile() {
	}

	@Test
	void testRemoveFile() {
	}

	@Test
	void removeFiles() {
	}

	@Test
	void testRemoveFiles() {
	}

	@Test
	void getPolicyType() {
	}
}
