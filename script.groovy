def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def testApp() {
    echo "Testing the application..."
    sh 'mvn test'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: '40b0b10e-64ab-438d-b09e-8a5218d6fafd', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t pavansai2926/ap-1:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push pavansai2926/ap-1:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
