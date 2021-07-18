package com.tz.urule.config;

/**
 * 客户端动态配置
 * 官方文档：http://www.bstek.com/resources/doc/16ke-hu-duan-fu-wu-qi-pei-zhi.html
 */
//@Component
//public class TestClientProvider implements ClientProvider {
//
//    @Override
//    public List<ClientConfig> loadClients(String project, boolean all) {
//        String kyProject = "ky";
//        Map<String, List<ClientConfig>> map = new HashMap<>();
//        List<ClientConfig> list = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            ClientConfig cc = new ClientConfig();
//            cc.setName("客户端" + i);
//            cc.setClient("http://127.0.0.1:8081");
//            cc.setEnabled(true);
//            cc.setProject(kyProject);
//            list.add(cc);
//        }
//        map.put(kyProject, list);
//        return map.get(project);
//    }
//}