package com.zb.commonutils.utils;

import java.util.*;

public class MessageInterceptor_gpt4 {
    private static final Set<String> WHITE_LIST = new HashSet<>(Arrays.asList("验证码", "快递", "余额", "招聘", "简历", "校招", "笔试", "面试", "网申", "邮箱", "考试", "初面", "参加", "码", "盘", "订单", "漏接电话", "自如网", "信用卡预约还款", "扣款", "应扣人民币"));
    private static final Set<String> BLACK_LIST = new HashSet<>(Arrays.asList("退订", "云南省", "娱乐", "玩家", "邀请", "疫情", "拼多多", "TD", "邀您", "体验", "唯品会", "注册", "代理", "火爆", "恭喜", "发放", "选中", "获得", "领取", "权益", "福利", "妙招", "整治", "网贷", "云南", "省", "宣", "信用卡", "大惠", "来袭", "好礼", "戳", "回T", "定向", "订购", "权益放送", "【活动提醒】", "积分", "活动", "游戏", "特邀", "反诈", "北京市", "交管部门", "宽带", "专享消费分期卡额度已过期", "您的套餐使用情况如下", "分期", "滨江智慧社区", "收钱吧"));

    public static boolean isBlocked(String message) {
        List<String> hitWhiteList = new ArrayList<>();
        List<String> hitBlackList = new ArrayList<>();

        for (String keyword : WHITE_LIST) {
            if (message.contains(keyword)) {
                hitWhiteList.add(keyword);
            }
        }

        for (String keyword : BLACK_LIST) {
            if (message.contains(keyword)) {
                hitBlackList.add(keyword);
            }
        }

        System.out.println("命中白名单关键字: " + hitWhiteList);
        System.out.println("命中黑名单关键字: " + hitBlackList);

        return hitWhiteList.isEmpty() && !hitBlackList.isEmpty();
    }

    public static void main(String[] args) {
        String message = "【招商银行】您招行个人消费卡账户预约还款未足额扣款，应扣人民币13475.44，实扣人民币4318.96，剩余部分请自行还款。点 cmbt.cn/4Nz 自行还款或咨询信用卡客服了解更多还款方式\n" +
                "【招商银行】您账户8747关联个人信用卡扣款，应扣人民币9156.48，实扣9156.48。";
        System.out.println("短信内容: " + message);
        System.out.println("是否被拦截: " + (isBlocked(message) ? "是" : "否"));
    }
}
