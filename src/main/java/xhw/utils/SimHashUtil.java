package xhw.utils;

import com.hankcs.hanlp.HanLP;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class SimHashUtil {

    private static int hashbit = 64;

    /**
     * 计算每个单词的hash值，并以字符串形式输出
     *
     * @param word 传入的String类型的单词
     * @return 返回word的hash值
     */
    public static String getHash(String word) {

        if (word == null || word.length() == 0) {
            return new BigInteger("0").toString(2);
        }
        /**
         * 当 str 的长度过短，会导致hash算法失效，需要对过短的词补偿
         */
        while (word.length() < 3) {
            word = word + word.charAt(0);
        }
        char[] strArray = word.toCharArray();
        BigInteger x = BigInteger.valueOf(((long) strArray[0]) << 7);
        BigInteger m = new BigInteger("1000003");
        BigInteger mask = new BigInteger("2").pow(hashbit).subtract(new BigInteger("1"));
        for (char item : strArray) {
            BigInteger temp = BigInteger.valueOf((long) item);
            x = x.multiply(m).xor(temp).and(mask);
        }
        x = x.xor(new BigInteger(String.valueOf(word.length())));
        return x.toString(2);
    }

    /**
     * 计算整个文本的simHash值，并以字符串形式输出
     *
     * @param text 传入的String类型的文本
     * @return 返回text的simHash值
     */
    public static String getSimHash(String text) {
        if(text.equals("")){
            throw new Error("文章无内容");
        }


        // 用数组表示特征向量,取64位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[hashbit];

        // 分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(text, text.length());//这一步是取出所有关键词
        int size = keywordList.size();
        int i = 0;
        for (String keyword : keywordList) {

            // 获取每个单词的hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < hashbit) {
                // hash值少于64位的话，就会在高位以0补齐
                int dif = hashbit - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash = "0" + keywordHash;
                }
            }

            // 加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }

        // 降维
        String simHash = "";// 储存返回的simHash值
        for (int j = 0; j < v.length; j++) {
            // 从高位遍历到低位
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }
}
