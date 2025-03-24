def call(String Sonar,String projectName,String projectKey){
  withSonarQubeEnv("${Sonar}"){
    sh "${SONAR_HOME}/bin/sonar-scanner -Dsonar.projectName=${projectName} -Dsonar.projectKey=${projectKey} -Dsonar.java.binaries=. -X"
  }
}
