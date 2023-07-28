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
                    url: 'https://github.com/NAciriAbdelilah/LabJenkinsDevops.git',
                    branch: 'main'
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
        stage('Docker Run'){
            steps{
                echo 'Run Docker from the source code'
            }
        }

    }

}
def getVersion(){
    def commitHash = sh label: '', returnStdout: true, script: 'git rev-parse --short HEAD'
    return commitHash
}