package com.tz.urule.controller;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.tz.urule.dto.ABRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * <p></p>
 *
 * @author tuanzuo
 * @version 1.7.0
 * @time 2021-07-18 20:32
 **/
@RestController
public class UruleTestController {

    @Value("${urule.resporityServerUrl}")
    private String uruleResporityServerUrl;

    @Autowired
    private RestTemplate restTemplate;

    //方式1：代码中调用知识包--http://www.bstek.com/resources/doc/13dai-ma-zhong-diao-yong.html
    //接口请求地址：http://127.0.0.1:8081/urule/test?userTag=C
    @RequestMapping("/urule/test")
    public String testCode(String userTag) throws IOException {
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包"projectName/test123"
        KnowledgePackage knowledgePackage = service.getKnowledge("ky/abrule");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        ABRule abRule = new ABRule();
        abRule.setUserDmpTag(userTag);
        //将业务数据对象ABRule插入到KnowledgeSession中
        session.insert(abRule);
        //执行所有满足条件的规则
        session.fireRules();
        return "用户标签：" + abRule.getUserDmpTag() + "-->分流到页面：" + abRule.getRedirectConfig();
    }

    //方式2：Restful方式调用知识包--http://www.bstek.com/resources/doc/22fu-wu-bao-lu-yu-diao-yong.html
    //接口请求地址：http://127.0.0.1:8081/urule/test/rest?userTag=C
    @RequestMapping("/urule/test/rest")
    public ResponseEntity<String> testRestful(String userTag) {
        String url = uruleResporityServerUrl + "/urule/rest/ky/abrule";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //入参
        String input = "[{\"name\":\"AB分流\",\"fields\":{\"userDmpTag\":\"" + userTag + "\"},\"class\":\"com.tz.urule.dto.ABRule\"}]";
        HttpEntity<String> entity = new HttpEntity<>(input, headers);
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return resp;
    }
}
