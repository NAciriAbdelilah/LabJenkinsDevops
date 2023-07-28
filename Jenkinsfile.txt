pipeline {
    agent any
	tools {
      maven 'MVN_HOME'
    }

    stages {
        stage('SCM') {
            steps {
                git credentialsId: 'github', 
                    url: 'https://github.com/NAciriAbdelilah/LabJenkinsDevops.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build . -t naciriTestingLab:${env.BUILD_NUMBER}"
            }
        }

        stage('Docker Run') {
            steps {
                sh "docker run -d -p 8081:8080 naciriTestingLab:${env.BUILD_NUMBER}"
            }
        }
    }

}
