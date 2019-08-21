package com.gx.app.ssm.web.controller;


import com.alibaba.fastjson.JSON;
import com.gx.app.ssm.util.CsvUtils;
import com.gx.app.ssm.web.vo.OrderDeliveryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class TestController {
    @GetMapping("/index.html")
    public String index() {
        log.info("index");
        return "index";
    }

    //处理文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        String sourceName = file.getOriginalFilename(); // 原始文件名
        String fileType = sourceName.substring(sourceName.lastIndexOf("."));
        if (file.isEmpty() || StringUtils.isBlank(fileType)) {
            return "file is null";
        }
        if (!".txt".equals(fileType.toLowerCase()) && !".csv".equals(fileType.toLowerCase())) {
            return "illegal file type";
        }


        List<OrderDeliveryVo> deliveryVoList = null;
        try {
            deliveryVoList = CsvUtils.parse(file.getInputStream(), OrderDeliveryVo.class);
        } catch (Exception e) {
            log.error("csv parse error:{}", e);
        }
        log.info("deliveryVoList:{}", JSON.toJSON(deliveryVoList));

/*
        // 存放文件临时路径
        String base = request.getSession().getServletContext().getRealPath("/upload//");  //获取文件上传的路径，在webapp下的upload中
        File tempFile = new File(base);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }

        // 将文件上传到临时目录
        String path = base + File.separator + sourceName;
        File upload = new File(path);
        try {
            file.transferTo(upload);
        } catch (IOException e) {
            log.error("文件上传失败{}", e);
        }

        // 解析文件
        BufferedReader br = null;
        FileReader reader = null;
        try {
            reader = new FileReader(upload);
            br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                log.info("line:{}", line);
                if (line.trim().length() == 11) {
                    //phones.add(line.trim());
                }
            }
        } catch (Exception e) {
            log.error("文件上传失败{}", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    reader = null;
                }
                if (br != null) {
                    br.close();
                    br = null;
                }
            } catch (Exception e) {
                log.error("关闭文件流失败{}", e);
            }
            // 删除临时文件
            if (upload.isFile()) {
                //upload.delete();
            }
        }*/
        //返回json
        return "ok";
    }
}
