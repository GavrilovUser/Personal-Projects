plugins {
  id("java");
  id("application");
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.mindrot:jbcrypt:0.4")
}

application {
  mainClass.set("com.example.bcrypt.App");
}