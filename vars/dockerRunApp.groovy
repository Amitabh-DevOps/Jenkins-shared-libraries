/**
 * Runs a Docker container for your application.
 *
 * This function retrieves the environment file using the provided credential ID,
 * copies it to the workspace as .env.local, stops any running container with the
 * specified name, and then starts a new container with that name.
 *
 * @param image The Docker image name.
 * @param tag The Docker image tag.
 * @param envCredentialId The Jenkins credential ID for the env file (Secret File).
 * @param containerName The name to assign to the Docker container.
 * @param options Additional docker run options (e.g., "--env-file $WORKSPACE/.env.local -p 3000:3000").
 */
def call(String image, String tag, String envCredentialId, String containerName, String options = "") {
    echo "Starting Docker container for ${image}:${tag} with container name: ${containerName} using environment credential: ${envCredentialId}"
    
    // Retrieve and copy the secret environment file to the workspace as .env.local
    withCredentials([file(credentialsId: envCredentialId, variable: 'ENV_FILE')]) {
        echo "Copying environment file from credential..."
        
        sh 'cp -f $ENV_FILE .env.local'
    }
    
    // Stop and remove any existing container with the same name
    sh "docker rm -f ${containerName} || true"
    
    // Build the docker run command with the container name option included
    def command = "docker run -d --name ${containerName} ${options} ${image}:${tag}"
    echo "Executing command: ${command}"
    sh command
}
