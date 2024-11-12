def call(String credId, String imageName,String imageTag){
  withCredentials([usernamePassword(credentialsId:credId,
                                    usernameVariable:"dockerHubUser",
                                    passwordVariable:"dockerHubPass")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
                    sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
          }
}
