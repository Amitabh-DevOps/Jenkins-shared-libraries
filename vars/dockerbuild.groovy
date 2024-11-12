def call(String imageName, String imageTag){
  sh "sudo docker build -t ${imageName}:${imageTag} ."
}
