%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp classpath.jar; projet_talend.job_maitre_projet_0_1.Job_Maitre_Projet --context=Default %* 