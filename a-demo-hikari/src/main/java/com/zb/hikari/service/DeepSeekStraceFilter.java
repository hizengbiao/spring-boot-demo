package com.zb.hikari.service;

/**
 * Description
 *
 * @author
 * @date 2025/3/6
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class DeepSeekStraceFilter {
    static Logger logger = LoggerFactory.getLogger(DeepSeekStraceFilter.class);

    /**
     * 根据 PID 列表过滤 strace 日志文件
     * @param pidList  需要过滤的 PID 列表
     * @param inputFile  输入文件路径 (如 "strace.log")
     * @param outputFile 输出文件路径 (如 "strace-filtered.log")
     */
    public static void filterStraceByPid(List<Integer> pidList, String inputFile, String outputFile, String outputFileJumpFutex)
        throws IOException {
        // 将 PID 列表转为 Set 以提高查询效率
        Set<Integer> pidSet = new HashSet<>(pidList);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter writerJumpFutex = new BufferedWriter(new FileWriter(outputFileJumpFutex))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // 跳过空行
                if (line.trim().isEmpty()) {
                    continue;
                }
                // if (jumpFutex && line.contains("futex")) {
                //     continue;
                // }

                // 提取首列 PID
                String[] columns = line.split("\\s+", 2);  // 分割为两部分: PID 和剩余内容
                if (columns.length < 1) {
                    continue;
                }

                try {
                    int pid = Integer.parseInt(columns[0]);
                    if (pidSet.contains(pid)) {
                        if (!line.contains("futex")) {
                            writerJumpFutex.write(line);
                            writerJumpFutex.newLine();
                        }
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (NumberFormatException e) {
                    // 忽略非数字 PID 行 (如错误信息)
                    logger.warn("跳过无效 PID 行: " + line);
                }
            }
        }
    }

    public static void setFilePathAndCall(List<Integer> pidList, String basePath) {
        // 将pidLIist转为字符串列表，并以-拼接
        String pidListString = "";
        for (int i = 0; i < pidList.size(); i++) {
            pidListString = pidListString + "-" + pidList.get(i);
        }

        // inputFile路径为basePath + "strace" + pidListString + ".log"
        String inputFile = basePath + "strace.log";
        String outputFile = basePath + "strace-filtered" + pidListString + ".log";
        String outputFileJumpFutex = basePath + "strace-filtered-jumpFutex" + pidListString + ".log";

        try {
            filterStraceByPid(pidList, inputFile, outputFile, outputFileJumpFutex);
            logger.info("过滤完成！结果已写入: " + outputFile);
        } catch (IOException e) {
            logger.warn("文件处理失败: " + e.getMessage());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        // 示例 PID 列表
        List<Integer> pidList = Arrays.asList(2905137);
        String basePath = "C:\\Users\\80310761\\Desktop\\";
        setFilePathAndCall(pidList, basePath);
    }
}
