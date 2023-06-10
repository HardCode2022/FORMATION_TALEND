#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp classpath.jar: projet_talend.job_maitre_projet_0_1.Job_Maitre_Projet --context=Default "$@" 