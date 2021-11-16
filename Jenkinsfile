#!/usr/bin/env groovy
node {
stage('checkout') {
    checkout scm
    def pom = readMavenPom file: 'pom;xml'
    if (pom){
        echo "Building version ${pom.version}"
    }
    sh "chmod +x ./mvnw"
    }
}