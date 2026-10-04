plugins {
  application
}

application {
  mainClass.set("com.example.bank.Main")
}

tasks.named<JavaExec>("run") {
  standardInput = System.`in`
}