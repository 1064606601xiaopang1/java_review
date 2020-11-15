package com.review.agent;

/**
 * 静态代理
 */
public class Agent {
    public static void main(String[] args) {
        // 小郭结婚清婚庆公司帮忙
        You you = new You(); // You是Mary的实现类
        WeddingCelebration weddingCelebration = new WeddingCelebration(you);
        weddingCelebration.HappyMarry();
    }
}

interface Mary{
    // 结婚动作
    public void HappyMarry();
}

// 自己
class You implements Mary{
    @Override
    public void HappyMarry() {
        System.out.println(" 小郭要结婚了，很开心…… ");
    }
}
// 创建婚庆公司代理
class WeddingCelebration implements Mary{
    // 结婚实现
    private Mary mary;
    public WeddingCelebration(Mary marys){
        this.mary = marys;
    }
    @Override
    public void HappyMarry() {
        // 结婚之前
        before();
        // 结婚实现方法
        mary.HappyMarry();
        after();
    }

    // 结婚之后
    private void after() {
        System.out.println("收份子钱，入洞房");
    }

    // 结婚之前
    private void before() {
        System.out.println("婚礼布置现场");
    }
}
