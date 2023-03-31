import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"
	
	repositories {
		mavenCentral()
	}
}

subprojects {
	apply {
		plugin("org.jetbrains.kotlin.jvm")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.apache.kafka:kafka-streams")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.springframework.kafka:spring-kafka")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.kafka:spring-kafka-test")
	}
	
	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}
	
	tasks.withType<Test> {
		useJUnitPlatform()
	}
	
	tasks.withType<Wrapper> {
		gradleVersion = "7.6.1"
	}
}
