// vars/dockerBuildEnv.groovy
def call(String imageName, String tag, String buildArgs = "") {
    withCredentials([string(credentialsId: 'NEXT_PUBLIC_API_KEY', variable: 'API_KEY')]) {
        def fullBuildArgs = "${buildArgs} --build-arg NEXT_PUBLIC_API_KEY=${API_KEY}".trim()
        sh "docker build ${fullBuildArgs} -t ${imageName}:${tag} ."
    }
}
