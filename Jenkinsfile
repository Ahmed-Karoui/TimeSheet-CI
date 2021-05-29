pipeline {
    agent any
        stages{    
        stage("build & sonar analysis ") {
            steps {
                withSonarQubeEnv('Sonar'){
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    bat "mvn clean package sonar:sonar"
                }
            }
        }
             stage('uploading to nexus'){
                 steps{
                     nexusArtifactUploader artifacts: [
                        [artifactId: 'Timesheet-spring-boot-core-data-jpa-mvc-REST-1',
                        classifier: '', 
                        file: 'target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war', 
                        type: 'war']], credentialsId: 'nexus3', groupId: 'tn.esprit.spring', 
                        nexusUrl: 'localhost:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'Timesheet/', 
                        version: '1.0'
                 }
             }
             stage('Email Notifications'){
                 steps{
                 mail bcc: '', body: '''Hello , 
                A Build has been executed on Your Project Timesheet , if you notice any bugs or abnormal behaviour please contact your team leader
                Best Regards , 
                Bouhmid''', 
                cc: '', from: '', replyTo: '', subject: 'A Build was executed on timesheet', to: 'karouii.ahmed@gmail.com'
             
                 }
                 } 
                stage('Slack Notification'){
                steps{
                slackSend baseUrl: 'https://hooks.slack.com/services/',
                channel: '#jenkins-bot',
                color: 'good', 
                message: 'A build on your Project Timesheet Has started if you notice any abnormal behaviour contact your team leader', 
                tokenCredentialId: 'slack-id'
                    }
                }

        }
}
