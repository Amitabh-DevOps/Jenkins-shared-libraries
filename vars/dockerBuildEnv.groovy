// vars/dockerBuildEnv.groovy
def call(String imageName, String tag, String buildArgs = "", String apiKey) {
    // Use the provided apiKey as an environment variable for the build
    sh "NEXT_PUBLIC_API_KEY=${apiKey} docker build ${buildArgs} -t ${imageName}:${tag} ."
}
