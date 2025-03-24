def call(String image, String tag) {
    echo "Scanning Docker image ${image}:${tag} with Trivy..."
    sh "trivy fs ."
}
