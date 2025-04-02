// vars/dockerBuildEnv.groovy
// vars/dockerbuild.groovy

def call(String imageName, String tag, String buildArgs = "", String apiKey) {
    sh """
        export NEXT_PUBLIC_API_KEY="${apiKey}"
        docker build ${buildArgs} -t ${imageName}:${tag} .
    """
}
