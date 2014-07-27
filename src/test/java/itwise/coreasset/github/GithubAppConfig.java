package itwise.coreasset.github;

import hadrian.config.ApiConfigurationBeanFactoryPostProcessor;
import hadrian.config.ProxySupportApiBeanFactory;
import hadrian.config.SpecificationClassSupportApiConfigurationRegister;
import hadrian.config.XmlConfigurationApiHostMapFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chanwook on 2014. 6. 19..
 */
@Configuration
public class GithubAppConfig {

    @Bean
    public ApiConfigurationBeanFactoryPostProcessor getInitBeanFactoryProstProcessor() {
        SpecificationClassSupportApiConfigurationRegister scacr = new SpecificationClassSupportApiConfigurationRegister();
        scacr.setApiBeanFactory(createWebServiceBeanFactory());
        scacr.setBasePackage("itwise.coreasset.github");

        ApiConfigurationBeanFactoryPostProcessor bfpp = new ApiConfigurationBeanFactoryPostProcessor();
        bfpp.setApiConfigurationRegister(scacr);
        bfpp.setHostMapFactory(createHostMapFactory());
        return bfpp;
    }

    private ProxySupportApiBeanFactory createWebServiceBeanFactory() {
        ProxySupportApiBeanFactory factory = new ProxySupportApiBeanFactory();
        factory.setSpringTemplate(getRestTemlpate());
        return factory;
    }

    private XmlConfigurationApiHostMapFactory createHostMapFactory() {
        XmlConfigurationApiHostMapFactory factory = new XmlConfigurationApiHostMapFactory();
        return factory;
    }

    @Bean
    public RestTemplate getRestTemlpate() {
        RestTemplate t = new RestTemplate();
        return t;
    }

}
