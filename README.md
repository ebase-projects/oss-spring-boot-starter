## oss-spring-boot-starter

> 基于 SpringBoot 3.0  通用文件存储工具类

支持的容器

- minio
- qiniu
- aliyun
- ...

## spring boot starter依赖

| 版本          | 支持               |
|-------------|------------------|
| 1.0-3.0.0   | 适配 SpringBoot3.x |


```xml
<dependency>
    <groupId>me.dwliu.framework</groupId>
    <artifactId>oss-spring-boot-starter</artifactId>
    <version>${lastVersion}</version>
</dependency>
```

## 使用方法

### 配置文件

```yaml
oss:
    prefix: XX
    minio:
        enabled: true
        endpoint: http://xxx:9000
        accessKey: XX
        secretKey: XX
        bucketName: image

```

