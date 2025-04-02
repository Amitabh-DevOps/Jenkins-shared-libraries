// vars/dockerBuildEnv.groovy
def call(String imageName, String tag, String buildArgs = "") {
    withCredentials([string(credentialsId: 'NEXT_PUBLIC_API_KEY', variable: 'API_KEY')]) {
        // Pass the API key as an environment variable instead of a build arg
        sh "docker build -e NEXT_PUBLIC_API_KEY=${API_KEY} ${buildArgs} -t ${imageName}:${tag} ."
    }
}
