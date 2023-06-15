val kotlinVersion by extra { "1.5.30" }
val junitVersion by extra { "5.8.1" }

plugins {
    kotlin("jvm") version "1.5.30"
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    `java-library`
    `maven-publish`
    signing
}

group = "io.github.seljabali"
version = "0.5"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


signing {
    useInMemoryPgpKeys(
        System.getProperty("GPG_PRIVATE_KEY"),
        System.getProperty("GPG_PRIVATE_PASSWORD")
    )
    sign(publishing.publications)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name.set("java-time-fun")
                description.set("java.time Kotlin extension functions library.")
                url.set("https://github.com/seljabali/java-time-fun")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("seljabali")
                        name.set("Sami Eljabali")
                        email.set("sami@eljabali.org")
                        url.set("sami.eljabali.org")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/seljabali/java-time-fun.git")
                    developerConnection.set("scm:git:ssh://github.com/seljabali/java-time-fun.git")
                    url.set("https://github.com/seljabali/java-time-fun/tree/main")
                }
            }
            groupId = project.group as String
            artifactId = project.name
            version = project.version as String
            from(components["java"])
            artifacts {
                artifact(tasks.kotlinSourcesJar) {
                    classifier = "sources"
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(System.getProperty("SONATYPE_USERNAME"))
            password.set(System.getProperty("SONATYPE_PASSWORD"))
        }
    }
}