def call(String image, String tag, String options="") {
    echo "Scanning Docker image ${image}:${tag} with Trivy..."
    sh "trivy fs ."
}
