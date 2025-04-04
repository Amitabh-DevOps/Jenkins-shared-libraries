def call(String imageName, String imageTag){
  sh "docker build -t ${imageName}:${imageTag} ."

  // Clean up .env.local after the build
  sh "rm -f .env.local"
}
