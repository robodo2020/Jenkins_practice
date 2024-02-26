pipeline {
  agent any
  stages {
    stage("build") {
      steps {
          echo 'building the apps...'
      }
    }

    stage("test") {
      when {
        expression {
          BRANCH_NAME == 'master' || BRANCH_NAME == 'dev'
        }
      }
      
      steps {
          echo 'testing the apps...'
      }
    }

    stage("deploy") {
      steps {
          echo 'deploying the apps...'
      }
    }
  }
    
}
