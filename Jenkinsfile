pipeline {
  // the top level
  agent any // define the env for pipeline to execute (like docker, which image)
  evnironment {
    NEV_VERSION = '1.0.1'
    SERVER_CREDENTIALS = credentials('server-credentials') // defined at jenkins global credential, and should use the ID to define the variable name
  }
  stages {
    stage('build') {
      steps {
          echo 'building the apps...'
          echo "building the version ${NEV_VERSION}" // should use double quote instead of single
      }
    }

    stage('test') {
      when {
        expression
          // check the current branch, can find here: http://localhost:8080/env-vars.html/
          BRANCH_NAME == 'master' || BRANCH_NAME == 'dev' && CODE_CHANGES == true
      }

      steps {
          echo 'testing the apps...'
      }
    }

    stage('deploy') {
      steps {
          echo 'deploying the apps...'
          echo "deploying with ${SERVER_CREDENTIALS}"
      }
    }

    // execute the logic after all the stages executed
    post {
      // conditions
      always {
        echo 'the build finished'
      }
      failure {
        echo 'the build fails'
      }
      success {
        echo 'the build success'
      }
    }
  }
}
