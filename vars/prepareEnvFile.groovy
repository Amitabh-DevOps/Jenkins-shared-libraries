def call(String credentialId, String destinationFile) {
    withCredentials([file(credentialsId: credentialId, variable: 'ENV_FILE')]) {
        sh "cp -f \$ENV_FILE ${destinationFile}"
        echo "${destinationFile} file has been copied into the workspace."
    }
}
