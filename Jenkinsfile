pipeline {
    agent any
	tools {
      maven 'MVN_HOME'
    }

    stages {
    
        stage('Build') {
            steps {
                bat "mvn clean package"
            }
            post{
                success{
                    echo "Archiving the Artifacts"
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage('Deploy to Tomcat server'){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'jenkinsDeployer', path: '', url: 'http://localhost:9080/')], contextPath: null, war: '**/*.war'
            }
        }
        stage('Docker Run') {
            steps {
                echo 'Build Docker image from the source code'
                echo 'Run Docker container from the Docker image jenkins/jenkins'
                bat 'docker run -d -p 8086:8080 -p 50000:50000 --name=JenkinsInsideContainer --restart=on-failure jenkins/jenkins:lts-jdk11'
            }
        }

    }

}
