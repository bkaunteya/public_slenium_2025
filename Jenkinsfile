pipeline {
    agent any
    
    tools {
        maven 'Maven_3.9.6'
        jdk 'jdk11'
    }

    triggers {
        // githubPush()   // ❌ Comment this out
        pollSCM('H/2 * * * *')   // ✅ Poll every 2 minutes
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bkaunteya/public_slenium_2025.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
