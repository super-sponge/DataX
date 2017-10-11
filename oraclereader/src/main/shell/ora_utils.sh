#!/usr/bin/env bash


base_dir=$(cd `dirname $0`/..;pwd)

LOG4J=$base_dir/conf/log4j.properties
if [ -f $LOG4J ]; then
    export LOG4J_PARAMS="-Dlog4j.configuration=file:$LOG4J"
fi

orareadlib=${base_dir}/plugin/reader/oraclereader

jars=$orareadlib/oraclereader-0.0.1-SNAPSHOT.jar
for jar in ${orareadlib}/libs/*jar
do
jars=$jars:$jar
done

java -cp $jars $LOG4J_PARAMS  com.alibaba.datax.plugin.reader.oraclereader.MetaUtils $@