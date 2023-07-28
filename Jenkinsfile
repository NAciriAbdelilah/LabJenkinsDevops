pipeline {
    agent any

    stages {
    
        stage('Build') {
            steps {
                sh "mvn clean package"
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

    }

}
