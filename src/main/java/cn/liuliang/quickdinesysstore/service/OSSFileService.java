package cn.liuliang.quickdinesysstore.service;

import java.io.InputStream;

/**
 * @Package： cn.liuliang.quickdinesysstore.service
 * @Author： liuliang
 * @CreateTime： 2020/10/26 - 9:27
 * @Description： 文件上传业务接口
 */
public interface OSSFileService {
    /**
     * 文件上传
     * @param inputStream       文件输入流
     * @param module            文件要存储的目录名称
     * @param originalFilename  文件名称
     * @return
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    /**
     * 文件删除
     * @param url   要删除的文件访问地址
     */
    void removeFile(String url);
}
