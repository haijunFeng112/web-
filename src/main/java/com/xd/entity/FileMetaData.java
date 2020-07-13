package com.xd.entity;


/**
 * @author hjfeng
 * @date 2020--07--07  15:42
 */
public class FileMetaData {

    /**
     * 文件名字
     */
    private String name;
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 文件上传的人
     */
    private String author;
    /**
     * 文件上传日期
     */
    private String uploadDate;

    /**
     * 文件下载次数
     */
    private Integer downloadCount = 0;

    public FileMetaData() {
    }

    public FileMetaData(String name, Integer size, String author, String uploadDate, Integer downloadCount) {
        this.name = name;
        this.size = size;
        this.author = author;
        this.uploadDate = uploadDate;
        this.downloadCount = downloadCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public void setDownloadCount() {
    }

    @Override
    public String toString() {
        return "FileMetaData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", author='" + author + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
