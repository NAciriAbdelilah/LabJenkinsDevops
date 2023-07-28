pipeline {
    agent any
	tools {
      maven 'MVN_HOME'
    }
    environment {
      DOCKER_TAG = getVersion()
    }
    stages {
        stage('SCM') {
            steps {
                git credentialsId: 'github', 
                    url: 'https://github.com/NAciriAbdelilah/LabJenkinsDevops'
            }
        }

        stage('Maven Build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Docker Build'){
            steps{
                sh "docker build . -t naciriapp:${DOCKER_TAG} "
            }
        }

        stage('Docker Run') {
            steps {
                sh "docker run -d -p 8081:8080 naciriTestingLab:${env.BUILD_NUMBER}"
            }
        }
    }

}
def getVersion(){
    def commitHash = sh label: '', returnStdout: true, script: 'git rev-parse --short HEAD'
    return commitHash
}