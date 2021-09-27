pipeline {
    agent any 
    stages {
        // Validando a sintaxe do Dockerfile
        stage ('Validando a sintaxe do Dockerfile') {
            steps {
                sh '''#!/bin/bash
                    docker run --rm -i hadolint/hadolint < Dockerfile
                '''
            }
        } 
        // Download imagem do ambiente
        stage ('Docker Prepared Environment') {
            steps {
                sh '''#!/bin/bash
                    docker run --rm --name seleniumgrid -d -p 4444:4444 -v /dev/shm:/dev/shm --privileged selenium/standalone-chrome:4.0.0-rc-1-prerelease-20210804
                '''
            }
        } 
        // Contruir imagem
        stage ('Docker Build') {
            steps {
                sh '''#!/bin/bash
                    docker build -t teste-project -f ./Dockerfile .
                '''
            }
        } 
        // Rodar os testes
        stage ('Docker Run Test') {
            steps {
                sh '''#!/bin/bash
                    docker run --network="host" -v "./target:/usr/target" teste-project mvn test -Denv=uat13
                '''
            }
        } 
        // Docker Stop Environment
        stage ('Docker Stop Environment') {
            steps {
                sh '''#!/bin/bash
                    docker stop seleniumgrid
                '''
            }
        }
    }
}