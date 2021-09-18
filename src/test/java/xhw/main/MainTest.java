package xhw.main;

import org.junit.Test;


public class MainTest {

    private String origin = ".\\files\\orig.txt";
    private String[] txts = {
            ".\\files\\orig_0.8_add.txt",
            ".\\files\\orig_0.8_del.txt",
            ".\\files\\orig_0.8_dis_1.txt",
            ".\\files\\orig_0.8_dis_10.txt",
            ".\\files\\orig_0.8_dis_15.txt",
    };
    private String target = "./files/ans.txt";

    /**
     * 随便测试一个文件
     */
    @Test
    public void oneText() {
        new Main().main(new String[]{origin, txts[0], target});
    }

    /**
     * 测试所有文件的情况
     */
//    @Test
//    public void allText() {
//
//        new Main().main(new String[]{origin, origin, target});
//        for (String txt : txts) {
////            String simHash = SimHashUtil.getSimHash(FileUtil.readFile(txt));
////            double similarity = HammingUtil.getSimilarity(simHash0, simHash);
////            FileUtil.writeFile("《"+FileUtil.fileName(txt) + "》文章与《"+ originFile + "》原文相似度为："+similarity,target);
////            System.out.println("《"+FileUtil.fileName(txt) + "》文章与《"+ originFile + "》原文相似度为："+similarity);
//            new Main().main(new String[]{origin, txt, target});
//        }
//        System.out.println("已全部写入");
//    }

}
