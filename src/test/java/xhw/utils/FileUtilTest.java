package xhw.utils;

import org.junit.Test;
import xhw.utils.FileUtil;

public class FileUtilTest {

    /**
     * 测试读取原文文章
     */
    @Test
    public void readTxt(){
        //路径存在
        String txt = FileUtil.readFile("./files/orig.txt");
        String[] strings = txt.split(" ");
        for(String str : strings){
            System.out.println(str);
        }
    }

    /**
     * 测试读取不存在的文章
     */
    @Test
    public void readFailTxt(){
        //路径不存在
        String txt = FileUtil.readFile("./files/11312.txt");
        String[] strings = txt.split(" ");
        for(String str : strings){
            System.out.println(str);
        }
    }

    /**
     * 测试写入内容到存在的文件
     */
    @Test
    public void writeTxt(){
        // 路径存在，正常写入
        String text = "我是网络工程4班的刘浩斌";
        FileUtil.writeFile(text, "./3119005384.txt");
    }

    /**
     * 测试写入内容到不存在的文件
     */
    @Test
    public void writeFailTxt(){
        // 路径不存在
        String text = "我是网络工程4班的刘浩斌";
        FileUtil.writeFile(text, "user./fail.txt");
    }

    /**
     * 测试读取文件名字
     */
    @Test
    public void getFileName(){
        String path = "./files/orig.txt";
        System.out.println("文件名："+FileUtil.fileName(path));
    }

}
