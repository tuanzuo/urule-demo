package com.tz.urule.controller;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.tz.urule.dto.ABRule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //接口请求地址：http://127.0.0.1:8081/urule/test?userTag=C
    @RequestMapping("/urule/test")
    public String test(String userTag) throws IOException {
        /**参考文档“代码中调用规则”：http://www.bstek.com/resources/doc/13dai-ma-zhong-diao-yong.html*/
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
}
