FLUME_SERVER_LIB_DIR=/btoddb/flume-dist/flume-server-node/lib
FLUME_CLIENT_LIB_DIR=/btoddb/flume-dist/flume-client-node/lib

rm -r tmp-staging > /dev/null
mkdir tmp-staging
pushd tmp-staging > /dev/null
tar xvfz ../target/flume-ng-hornetq-channel-1.0.0-SNAPSHOT-dist.tar.gz > /dev/null
pushd lib > /dev/null

fileList="flume-ng-hornetq-channel*.jar \
      btoddb-utils-1.0.0-SNAPSHOT.jar \
      hornetq-core-2.2.18.Final.jar \
"

cp -v ${fileList} ${FLUME_SERVER_LIB_DIR}/.
cp -v ${fileList} ${FLUME_CLIENT_LIB_DIR}/.

popd > /dev/null
popd > /dev/null

rm -r tmp-staging > /dev/null
