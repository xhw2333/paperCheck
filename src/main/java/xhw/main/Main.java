package xhw.main;

import xhw.utils.FileUtil;
import xhw.utils.HammingUtil;
import xhw.utils.SimHashUtil;

public class Main {
    public static void main(String[] args) {
//        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
//        String str0 = FileUtil.readFile(args[0]);
//        String str1 = FileUtil.readFile(args[1]);
//        String resFile = args[2];
//        // 由字符串得出对应的 simHash值
//        String simHash0 = SimHashUtil.getSimHash(str0);
//        String simHash1 = SimHashUtil.getSimHash(str1);
//        // 由 simHash值求出相似度
//        double similarity = HammingUtil.getSimilarity(simHash0, simHash1);
//        // 把相似度写入最后的结果文件中
//        FileUtil.writeFile(similarity, resFile);
//        // 退出程序
//        System.exit(0);

        String origin=".\\files\\orig.txt";
        String[] s={
                ".\\files\\orig_0.8_add.txt",
                ".\\files\\orig_0.8_del.txt",
                ".\\files\\orig_0.8_dis_1.txt",
                ".\\files\\orig_0.8_dis_10.txt",
                ".\\files\\orig_0.8_dis_15.txt",
        };

        String simHash0 = SimHashUtil.getSimHash(FileUtil.readFile(origin));
        String originFile = FileUtil.fileName(origin);

        for (String s1 : s) {
            String simHash = SimHashUtil.getSimHash(FileUtil.readFile(s1));
            double similarity = HammingUtil.getSimilarity(simHash0, simHash);
            System.out.println("《"+FileUtil.fileName(s1) + "》文章与《"+ originFile + "》原文相似度为："+similarity);
        }
    }
}
