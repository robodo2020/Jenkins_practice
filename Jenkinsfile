def gv

pipeline {
  // the top level
  agent any // define the env for pipeline to execute (like docker, which image)
  parameters {
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  environment {
    NEV_VERSION = '1.0.1'
    // defined at jenkins global credential, and should use the ID to define the variable name
    SERVER_CREDENTIALS = credentials('server-credentials')
  }
  stages {
    stage('init') {
      stpes {
        script {
          // load the groovy file, and gv we define it as global var above
          // which allows us to use the external script
          gv = load 'script.groovy'
        }
      }
    }

    stage('build') {
      steps {
          script {
            gv.buildApp()
          }
      }
    }

    stage('test') {
      when {
        expression {
          // check the current branch, can find here: http://localhost:8080/env-vars.html/
          BRANCH_NAME == 'master' || BRANCH_NAME == 'dev' && CODE_CHANGES == true
          params.executeTests == true  // the parameters above
        }
      }

      steps {
          script {
            gv.testApp()
          }
      }
    }

    stage('deploy') {
      steps {
          script {
            gv.deployApp()
          }
      }
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
