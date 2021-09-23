pipeline {
    agent any 
    stages {

        stage ('[BASH] Connect SSH VM') {
            steps {
                sh '''#!/bin/bash
                    ssh -i "aws-ubuntu-henrique.pem" ubuntu@ec2-18-212-35-218.compute-1.amazonaws.com
                '''
            }
        }
       
    }
}
