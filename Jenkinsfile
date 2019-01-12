pipeline{
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building'
                sh 'pwd'
            }
        }
        stage('Test') {
            steps{
                echo 'This is a test step'
            }
        }
        stage('Deploy') {
            steps{
                echo 'This is a deploy step'
            }
        }
    }
}