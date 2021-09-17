package xhw.main;

import xhw.utils.FileUtil;
import xhw.utils.HammingUtil;
import xhw.utils.SimHashUtil;

public class Main {

    public static void main(String[] args) {
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String txt0 = FileUtil.readFile(args[0]);
        String txt1 = FileUtil.readFile(args[1]);
        String resFile = args[2];
        // 由字符串得出对应的 simHash值
        String simHash0 = SimHashUtil.getSimHash(txt0);
        String simHash1 = SimHashUtil.getSimHash(txt1);
        // 由 simHash值求出相似度
        double similarity = HammingUtil.getSimilarity(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
        FileUtil.writeFile( "《"+FileUtil.fileName(args[0]) + "》文章与《"+ FileUtil.fileName(args[1]) + "》文章相似度为："+similarity, resFile);
        // 退出程序
//        System.exit(0);
    }

}
