IVORY=${IVORY:-}

# Only build once, or if you want to override it for testing
if [ ! -e "$IVORY" ]; then
    echo "Building ivory-cli"

    TARGET="${PROJECT}/target/ivory-cli"
    mkdir -p "${TARGET}"
    ${PROJECT}/sbt -Dsbt.log.noformat=true ";project cli; clean; universal:package-zip-tarball"
    tar xvf ${PROJECT}/ivory-cli/target/universal/ivory-cli*.tgz --strip-components 1 -C ${TARGET}
    export IVORY=${TARGET}/bin/ivory
fi
