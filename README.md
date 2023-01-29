### Badges
[![Build Status](https://github.com/vrnsky/camunda-messaging-starter/actions/workflows/package.yml/badge.svg)](https://github.com/vrnsky/camunda-messaging-starter/actions/workflows/package.yml)

### Camunda Message Starter

Send messaging to Camunda, it is trivial task, but it brings a lot of boilerplate code
By using this project you can save you time

### Usage
```
<dependency>
  <groupId>io.vrnsky</groupId>
  <artifactId>camunda-messaging-starter</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Local development
For local building:
```
clean kotlin:compile install
```
Since have to Kotlin sources need to be compiled before installing to local repository

### Usage
#### Creation 
Creation of template happens automatically, so you don't have to manually create bean,
but you can override default provided template as below
```java
import io.vrnsky.camunda.messaging.starter.CamundaMessageConfiguration;
import io.vrnsky.camunda.messaging.starter.CamundaMessageTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    @Bean
    public CamundaMessageTemplate camundaMessageTemplate() {
        var camundaMessageConfiguration = new CamundaMessageConfiguration("http://localhost:8080");
        return new CamundaMessageTemplate(camundaMessageConfiguration);
    }
}
```
#### Use
```java
import io.vrnsky.camunda.messaging.starter.CamundaMessageTemplate;
import io.vrnsky.camunda.messaging.starter.model.CamundaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaController {

    @Autowired
    private CamundaMessageTemplate camundaMessageTemplate;

    @GetMapping("/message")
    public void message(@RequestBody CamundaMessage camundaMessage) {
        camundaMessageTemplate.message(camundaMessage);
    }
}

```

### CI/CD
For CI/CD this project use GitHub Actions, all workflows placed [./github/workflows](.github/workflows)

Contacts:

### Contact
[LinkedIn](https://www.linkedin.com/in/vrnsky/)  
[Twitter](https://twitter.com/VoronyanskyE)  
[Telegram](https://t.me/vrnsky)  
