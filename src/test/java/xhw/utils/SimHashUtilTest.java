package xhw.utils;

import com.hankcs.hanlp.HanLP;
import org.junit.Test;
import xhw.utils.SimHashUtil;

import java.util.List;

public class SimHashUtilTest {

    /**
     * 测试单词的分词及其hash值
     */
    @Test
    public void getHashTest() {
        String strs = "我是网络工程4班的刘浩斌";
        List<String> keywordList = HanLP.extractKeyword(strs, strs.length());
        for (String s : keywordList) {
            String stringHash = SimHashUtil.getHash(s);
            System.out.println("【" + s + "】的hash值：" + stringHash);
        }
    }

    /**
     * 测试单词的hash值
     */
    @Test
    public void getEmptyHashTest() {
        String[] strs = {" ",null};
        for (String s : strs) {
            String stringHash = SimHashUtil.getHash(s);
            System.out.println("【" + s + "】的hash值：" + stringHash);
        }
    }

    /**
     * 测试一段文本的分词情况及最后的hash值
     */
    @Test
    public void getSimHashTest(){
        String str0 = "活着前言" +
                "\n" +
                "    一位真正的作家永远只为内心写作，只有内心才会真实地告诉他，他的自私、他的高尚是多么突出。内心让他真实地了解自己，一旦了解了自己也就了解了世界。很多年前我就明白了这个原则，可是要捍卫这个原则必须付出艰辛的劳动和长时期的痛苦，因为内心并非时时刻刻都是敞开的，它更多的时候倒是封闭起来，于是只有写作，不停地写作才能使内心敞开，才能使自己置身于发现之中，就像日出的光芒照亮了黑暗，灵感这时候才会突然来到。\n" ;
        System.out.println(SimHashUtil.getSimHash(str0));
    }

    /**
     * 测试一段【空】文本的分词情况及最后的hash值
     */
    @Test
    public void getSimHashEmptyTest(){
        String str0 = "";
        System.out.println(SimHashUtil.getSimHash(str0));
    }
}
