#/bin/bash

# if JAFW_DEV variable is set
if [ "$JAFW_DEV" = "" ]
then
   echo "Error: The \$JAFW_DEV environment variable is not set"
   exit 1
fi

if [ "$ANT_HOME" = "" ]
then
   echo "Error: The \$ANT_HOME environment variable is not set"
   exit 1
fi

if [ "$JAVA_HOME" = "" ]
then
   echo "Error: The \$JAVA_HOME environment variable is not set"
   exit 1
fi


# Make sure classpath is "uncontaminated"
unset CLASSPATH

# Global Ant options
export ANT_OPTS=-Xmx512m

# Start Ant with supplied arguments
$ANT_HOME/bin/ant -buildfile $JAFW_DEV/build/build.xml $@
