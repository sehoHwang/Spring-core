package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 기존 Configuration 어노테이션이 붙은 Config 파일의 충돌을 피하기 위해 excludeFilter 사용
public class AutoAppConfig {


}
