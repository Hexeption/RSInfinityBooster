pipeline {
    agent {
        docker { image "openjdk:8-jdk" }
    }
    stages {
        stage('Build') {
            steps {
                 withCredentials([string(credentialsId: 'CURSE_API_KEY', variable: 'CURSE_API_KEY'),string(credentialsId: 'REPO_PASSWORD', variable: 'REPO_PASSWORD'),string(credentialsId: 'modrinth_api_key', variable: 'modrinth_api_key')]) {
                    sh "chmod +x gradlew && ./gradlew clean build publish curseforge publishModrinth -PmavenPass=$REPO_PASSWORD -Pcurse_api_key=$CURSE_API_KEY -Pmodrinth_api_key=$modrinth_api_key --console=plain --refresh-dependencies"
                 }
            }
        }
    }
    post {
        always {
            script {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true, onlyIfSuccessful: true, allowEmptyArchive: true
            }
        }
    }
}
