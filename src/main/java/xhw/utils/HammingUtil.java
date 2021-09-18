package xhw.utils;

import java.text.DecimalFormat;

public class HammingUtil {
    /**
     * 输入两个simHash值，计算它们的海明距离
     *
     * @param simHash1
     * @param simHash2
     * @return 海明距离
     */
    public static int getHammingDistance(String simHash1, String simHash2) {

        //前者小于后者重新调用此方法
        if (simHash1.length() < simHash2.length()) {
            return getHammingDistance(simHash2,simHash1);
        }

        // 不相等则高位补0
        while(simHash1.length() > simHash2.length()){
            simHash2 = "0" + simHash2;
        }

        int distance = 0;
        for (int i = 0; i < simHash1.length(); i++) {
            // 每一位进行比较
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 输入两个simHash值，输出相似度
     *
     * @param simHash1
     * @param simHash2
     * @return 相似度
     */
    public static double getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        // 通过海明距离计算出相似度，并返回(保留两位小数)
        DecimalFormat format = new DecimalFormat("#.00");
        String similarity = format.format(0.01 * (100 - distance * 100 / 64));
        return Double.parseDouble(similarity);
    }
}
