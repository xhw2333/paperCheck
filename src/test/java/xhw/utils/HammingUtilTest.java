package xhw.utils;

import org.junit.Test;
import xhw.utils.HammingUtil;

public class HammingUtilTest {

    /**
     * 测试两个【等位数】的海明距离和相似度
     */
    @Test
    public void testHamming1() {
        String str0 = "110101010110";
        String str1 = "101101101110";
        int distance = HammingUtil.getHammingDistance(str0, str1);
        double similarity = HammingUtil.getSimilarity(str0, str1);
        System.out.println("str0和str1的海明距离：" + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }

    /**
     * 测试两个【不等位数】的海明距离和相似度
     */
    @Test
    public void testHamming2() {
        String str0 = "1101110"; //000001101110
        String str1 = "110101010110";
        int distance = HammingUtil.getHammingDistance(str0, str1);
        double similarity = HammingUtil.getSimilarity(str0, str1);
        System.out.println("str0和str1的海明距离：" + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }

    /**
     * 测试有【空字符串】时的海明距离和相似度
     */
    @Test
    public void testHamming3() {
        String str0 = "110101010110";
        String str1 = "";
        int distance = HammingUtil.getHammingDistance(str0, str1);
        double similarity = HammingUtil.getSimilarity(str0, str1);
        System.out.println("str0和str1的海明距离：" + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }

}
