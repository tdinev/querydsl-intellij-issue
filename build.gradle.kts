import com.ewerk.gradle.plugins.tasks.QuerydslCompile

plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

group = "com.github.tdinev"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
	implementation("com.querydsl:querydsl-core:5.1.0")
	compileOnly("com.querydsl:querydsl-codegen:5.1.0") {
		because("To avoid NoClassDefFoundError for com/mysema/codegen/model/Type. No idea why that suddenly occurred.")
	}
}

configurations.querydsl.configure {
	extendsFrom(configurations.compileClasspath.get())
}

querydsl {
	jpa = true
	querydslSourcesDir = "generated-src"
	library = "com.querydsl:querydsl-apt:5.1.0:jakarta"
}

tasks.withType<QuerydslCompile> {
	options.annotationProcessorPath = configurations.querydsl.get()
}


tasks.withType<Test> {
	useJUnitPlatform()
}
