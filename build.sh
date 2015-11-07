#!/bin/bash
mvn assembly:assembly -DdescriptorId=jar-with-dependencies package &&
    echo "================ Uploading ================" &&
    aws lambda update-function-code --function-name trebek --zip-file fileb://target/trebek-1.0-jar-with-dependencies.jar
