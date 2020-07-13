package com.xd;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

/**
 * @author hjfeng
 * @date 2020--07--07  14:53
 */
public class DiskTest {

    @Value("${file.upload.directory}")
    public static String path;

    public static void main(String[] args) {
//        getMemInfo();
        System.out.println();
        getDiskInfo();
    }

    public static void getDiskInfo() {
        File[] disks = File.listRoots();
        for (File file : disks) {
            System.out.print(file.getPath() + "    ");
            System.out.print("空闲未使用 = " + file.getFreeSpace() / 1024 / 1024 + "M" + "    ");// 空闲空间
            System.out.print("已经使用 = " + file.getUsableSpace() / 1024 / 1024 + "M" + "    ");// 可用空间
            System.out.print("总容量 = " + file.getTotalSpace() / 1024 / 1024 + "M" + "    ");// 总空间
            System.out.println();
        }
        File file = new File("E:/test");
        long freeSpace = file.getFreeSpace();
        System.out.println(freeSpace/1024/1024+"M");
    }

//    public static void getMemInfo() {
//        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
//        System.out.println("Total RAM：" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
//        System.out.println("Available　RAM：" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
//    }


    @Test
    public void getDirec(){

        System.out.println(path);
    }


}
