[![Build and release version](https://github.com/vrnsky/camunda-messaging-starter/actions/workflows/package.yml/badge.svg?branch=main)](https://github.com/vrnsky/camunda-messaging-starter/actions/workflows/package.yml)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-%237F52FF.svg?logo=kotlin&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=fff)](#)
[![JUnit5](https://img.shields.io/badge/Tested_with-JUnit_5-1?logo=junit5)](#)
[![Linear](https://img.shields.io/badge/Task_tracker_we_prefer-Linear-5E6AD2?logo=linear&logoColor=fff)](#)

### ✉ Camunda Message Starter

Send a message to Camunda; it is a trivial task, but it brings a lot of boilerplate code.
By using this project you can save time.

### 〈〉Usage
```
<dependency>
  <groupId>io.vrnsky</groupId>
  <artifactId>camunda-messaging-starter</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

#### 🎉 Creation 
Template is created automatically. You don't need to create a bean.
But you can override the default template as below.

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

```java
import io.vrnsky.camunda.messaging.starter.CamundaMessageTemplate;
import io.vrnsky.camunda.messaging.starter.model.CamundaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaController {

    @Autowired
    private CamundaMessageTemplate camundaMessageTemplate;

    @PostMapping("/message")
    public void message(@RequestBody CamundaMessage camundaMessage) {
        camundaMessageTemplate.message(camundaMessage);
    }
}
```

#### Process definition example
![Process definition example](./img.png)

#### Successfully launch

```bash
CamundaMessageTemplate   : baseUrl obtained from configs = http://localhost:8080
```

### ⨑ CI/CD

This project uses GitHub Actions for CI and CD; the [designated directory](./.github/workflows) contains all workflows.

### ✆ Contacts

[![Medium](https://img.shields.io/badge/Medium-%23000000.svg?logo=medium&logoColor=white)](https://vrnsky.medium.com)
[![Substack](https://img.shields.io/badge/Substack-FF6719?logo=substack&logoColor=fff)](https://vrnsky.substack.com)
[![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-121013?logo=github&logoColor=white)](https://vrnsky.github.io)
[![Mastodon](https://img.shields.io/badge/Mastodon-6364FF?logo=mastodon&logoColor=fff)](https://me.dm/@vrnsky)
