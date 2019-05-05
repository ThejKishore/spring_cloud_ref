
```groovy
//building images without test using bmusch springboot docker plugin
./gradlew clean build dockerBuildImage -x test

//running specific project
./gradlew :cloud-config-server:clean :cloud-config-server:build :cloud-config-server:dockerBuildImage --refresh-dependencies


//building images without test using jib springboot docker  plugin
./gradlew clean build jibDockerBuild -x test

```

for the bmusch plugin to work the jcenter in dependency is needed.

