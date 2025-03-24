def call(){
  timeout(time: 15, unit: "MINUTES"){
      waitForQualityGate abortPipeline: true
  }
}
