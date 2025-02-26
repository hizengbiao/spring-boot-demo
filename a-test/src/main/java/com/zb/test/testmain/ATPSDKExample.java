package com.zb.test.testmain;

import com.aliyun.atp.tool.ATPClient;
import com.aliyun.atp.tool.ClientException;

public class ATPSDKExample {
    public static void main(String[] args) {
        try {
            ATPClient.execute(null);
            ATPClient.execute(new String[]{"<pid>", "thread"});
            ATPClient.execute(new String[]{"<pid>", "full_jcmd"});
            ATPClient.execute(new String[]{"<pid>", "heap", "-file=/tmp/heapdump.hprof","-object=all"});
            ATPClient.execute(new String[]{"<pid>", "heap", "-file=/tmp/heapdump.hprof","-object=live"});
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
