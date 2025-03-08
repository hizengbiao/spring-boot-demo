package com.zb.hikari.utils;

import java.io.IOException;

/**
 * Description
 *
 * @author
 * @date 2025/3/6
 */
public class CommonUtils {

    /***
     * 发起一个ping的系统调用，便于在strace结果中通过搜索找到请求的结束位置
     */
    public static void endOfCallSign() {
        try {
            Runtime.getRuntime().exec("ping 66.66.66.66");
        } catch (IOException e) {
            ;
        }

    }
}
