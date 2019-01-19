package configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

@Configuration
@ImportResource(locations = ["classpath:/spring/spring-servlet.xml",
    "classpath:/spring/datasource.xml",
    "classpath:/spring/security.xml"])
open class XmlConfig {
}