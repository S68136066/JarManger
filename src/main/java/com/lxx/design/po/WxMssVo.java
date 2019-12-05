package com.lxx.design.po;

import lombok.Data;

import java.util.Map;

/**
 * @Author:李兴兴
 * @Date:2019/11/12
 * @Time:19:26
 * @Desc:微信推送信息
 */
@Data
public class WxMssVo {
    private String touser;//用户openid
    private String template_id;//模版id
    private String page = "pages/index/index";//默认跳到小程序首页
    private String form_id;//收集到的用户formid
    private Map<String, TemplateDataVo> data;//推送文字
}
