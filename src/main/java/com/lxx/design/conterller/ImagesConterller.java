package com.lxx.design.conterller;

import com.lxx.design.ThreadRun.sendMessage;
import com.lxx.design.po.Imagesuud;
import com.lxx.design.po.JarManger;
import com.lxx.design.service.ImagesService;
import com.lxx.design.utils.CodeMsg;
import com.lxx.design.utils.CrossOriginUtil;
import com.lxx.design.utils.ExcelUtil;
import com.lxx.design.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author：
 * @Date：2020/11/25
 * @Time：9:42
 * @Desc：
 **/
@Slf4j
@Controller
public class ImagesConterller {
    @Autowired
    private ImagesService imS;
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 邮件发送功能
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(name = "/sendmailmsg",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil SendMail(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            // 发件人
            message.setFrom("xing18332916523@163.com");
            // 收件人
            message.setTo("827094742@qq.com");
            // 邮件标题
            message.setSubject("验证码");
            // 邮件内容
            int num = (int) ((Math.random() * 9 + 1) * 100000);
            message.setText("你好，您的验证码是 " + num + " 请尽快使用，有效期只有三分钟");
            // 抄送人
            //message.setCc("xxx@qq.com");
            mailSender.send(message);
        }catch (Exception e){
            return  ResultUtil.fail(CodeMsg.Mail_IS_NOTE);
        }
        return ResultUtil.success(CodeMsg.SUCCESS);
    }
    /**
     * 查询所以图片信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(name = "/SelectImags",method = RequestMethod.GET)
    @ResponseBody
    public List<Imagesuud> SelectImages(HttpServletRequest request, HttpServletResponse response){
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        List<Imagesuud> findAll = imS.findAllImages();
        return findAll;
    }

    /**
     * 图片下载
     * @param strArray
     * @param strArray1
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/download")
    @ResponseBody
    public ResultUtil Download(@RequestParam String[] strArray, @RequestParam String[] strArray1,HttpServletRequest request, HttpServletResponse response) throws Exception {
        //跨域问题
        CrossOriginUtil.setNewCrossOrigin(request, response);
        log.info("**************开始下载***************");
        for(int i=0;i<strArray.length;i++)
        {
            downloadPhotos("zhangjin", strArray1[i],strArray[i]);
        }
        log.info("**************下载结束***************");
        return ResultUtil.success(CodeMsg.SUCCESS);
    }
    public static void downloadPhotos(String USERID, String OID, String urlString) throws Exception {
        try{
            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流

            System.out.println("Start to save photo.");

            String downloadDir = "D:\\images\\"+USERID;
            File downloadFilePath = new File(downloadDir);
            if(downloadFilePath.exists() == false){
                // 如果该目录不存在,则创建之
                downloadFilePath.mkdirs();
            }
            //生成新的照片名
            String FILENAME = downloadDir+"\\"+OID+".jpg";
            System.out.println(FILENAME);
            // 开始读取
            OutputStream os = new FileOutputStream(FILENAME);
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 图片文档导入
     * @param myfiles
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/importImages",method = RequestMethod.POST)
    @ResponseBody
    public Object ImagesImport(MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info("=================批量导入开始！=================");

        //跨域问题

        //Map<String,Object> concurrentHashMap=new ConcurrentHashMap<String,Object>();

        CrossOriginUtil.setNewCrossOrigin(request, response);
        if(myfiles == null || myfiles.length<1){
            return ResultUtil.fail(CodeMsg.EXCEL_IS_NOTE);
        }
        for(MultipartFile file : myfiles){
            List<String[]> list = ExcelUtil.readExcel(file);
            if(list.isEmpty()){
                return ResultUtil.fail(CodeMsg.EXCEL_IS_NOTE);
            }
            for(int i=0;i<list.size();i++){
                String[] values = list.get(i);
                Imagesuud imagesuud = new Imagesuud();
                imagesuud.setOID(values[0]);
                imagesuud.setUrlString(values[1]);
                imS.insertImages(imagesuud);
            }
        }
//        sendMessage sendmessage = new sendMessage();
//        sendmessage.run();
        log.info("=================批量导入结束！=================");
        return ResultUtil.success(CodeMsg.SUCCESS);
    }
}
