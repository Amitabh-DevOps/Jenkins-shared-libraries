// def call(String image, String tag) {
//     echo "Scanning Docker image ${image}:${tag} with Trivy..."
//     sh "trivy fs ."
// }

def call(String reportFile = "table-report.html") {
    script {
        sh "trivy fs --format table -o ${reportFile} ."
        archiveArtifacts artifacts: reportFile, fingerprint: true
    }
}
