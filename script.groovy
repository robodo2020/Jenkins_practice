def buildApp () {
    echo 'building the apps...'
    echo "building the version ${NEV_VERSION}" // should use double quote instead of single
}

def testApp () {
    echo 'testing the apps...'
}

def deployApp () {
    echo 'deploying the apps...'
    echo "deploying version ${params.VERSION}"
    echo "deploying with ${SERVER_CREDENTIALS}"
}

return this
