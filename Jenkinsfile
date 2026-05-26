pipeline {
    agent any

    stages {

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t student-admission-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 9090:8080 student-admission-app'
            }
        }
    }
}