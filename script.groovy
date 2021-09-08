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
    withCredentials([usernamePassword(credentialsId: 'ap1', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t pavansai2926/ap-2:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push pavansai2926/ap-2:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
