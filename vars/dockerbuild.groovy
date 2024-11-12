def call(String imagename, String tagname){
  sh "docker build -t ${imagename}:${tagname}"
}
