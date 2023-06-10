// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package projet_talend.migration_vers_pulsar_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_2
	//import java.util.List;
import javax.jms.JMSException;
import routines.ActiveMQVersPulsarRoutine;
import org.apache.pulsar.client.api.PulsarClientException;

	//the import part of tJava_1
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: Migration_Vers_Pulsar Purpose: Migrer les données vers pulsar<br>
 * Description: Permettre la migration des données vers pulsar <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Migration_Vers_Pulsar implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(MdpActiveMQ != null){
				
					this.setProperty("MdpActiveMQ", MdpActiveMQ.toString());
				
			}
			
			if(QueueConnexion != null){
				
					this.setProperty("QueueConnexion", QueueConnexion.toString());
				
			}
			
			if(UrlConnexionActiveMQ != null){
				
					this.setProperty("UrlConnexionActiveMQ", UrlConnexionActiveMQ.toString());
				
			}
			
			if(UserActiveMQ != null){
				
					this.setProperty("UserActiveMQ", UserActiveMQ.toString());
				
			}
			
			if(Connexion_PostgresSQL_AdditionalParams != null){
				
					this.setProperty("Connexion_PostgresSQL_AdditionalParams", Connexion_PostgresSQL_AdditionalParams.toString());
				
			}
			
			if(Connexion_PostgresSQL_Database != null){
				
					this.setProperty("Connexion_PostgresSQL_Database", Connexion_PostgresSQL_Database.toString());
				
			}
			
			if(Connexion_PostgresSQL_Login != null){
				
					this.setProperty("Connexion_PostgresSQL_Login", Connexion_PostgresSQL_Login.toString());
				
			}
			
			if(Connexion_PostgresSQL_Password != null){
				
					this.setProperty("Connexion_PostgresSQL_Password", Connexion_PostgresSQL_Password.toString());
				
			}
			
			if(Connexion_PostgresSQL_Port != null){
				
					this.setProperty("Connexion_PostgresSQL_Port", Connexion_PostgresSQL_Port.toString());
				
			}
			
			if(Connexion_PostgresSQL_Schema != null){
				
					this.setProperty("Connexion_PostgresSQL_Schema", Connexion_PostgresSQL_Schema.toString());
				
			}
			
			if(Connexion_PostgresSQL_Server != null){
				
					this.setProperty("Connexion_PostgresSQL_Server", Connexion_PostgresSQL_Server.toString());
				
			}
			
			if(INPUTS != null){
				
					this.setProperty("INPUTS", INPUTS.toString());
				
			}
			
			if(Project_Name != null){
				
					this.setProperty("Project_Name", Project_Name.toString());
				
			}
			
			if(OUTPUTS != null){
				
					this.setProperty("OUTPUTS", OUTPUTS.toString());
				
			}
			
			if(TopicPulsar != null){
				
					this.setProperty("TopicPulsar", TopicPulsar.toString());
				
			}
			
			if(UrlConnexionPulsar != null){
				
					this.setProperty("UrlConnexionPulsar", UrlConnexionPulsar.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String MdpActiveMQ;
public String getMdpActiveMQ(){
	return this.MdpActiveMQ;
}
public String QueueConnexion;
public String getQueueConnexion(){
	return this.QueueConnexion;
}
public String UrlConnexionActiveMQ;
public String getUrlConnexionActiveMQ(){
	return this.UrlConnexionActiveMQ;
}
public String UserActiveMQ;
public String getUserActiveMQ(){
	return this.UserActiveMQ;
}
public String Connexion_PostgresSQL_AdditionalParams;
public String getConnexion_PostgresSQL_AdditionalParams(){
	return this.Connexion_PostgresSQL_AdditionalParams;
}
public String Connexion_PostgresSQL_Database;
public String getConnexion_PostgresSQL_Database(){
	return this.Connexion_PostgresSQL_Database;
}
public String Connexion_PostgresSQL_Login;
public String getConnexion_PostgresSQL_Login(){
	return this.Connexion_PostgresSQL_Login;
}
public java.lang.String Connexion_PostgresSQL_Password;
public java.lang.String getConnexion_PostgresSQL_Password(){
	return this.Connexion_PostgresSQL_Password;
}
public String Connexion_PostgresSQL_Port;
public String getConnexion_PostgresSQL_Port(){
	return this.Connexion_PostgresSQL_Port;
}
public String Connexion_PostgresSQL_Schema;
public String getConnexion_PostgresSQL_Schema(){
	return this.Connexion_PostgresSQL_Schema;
}
public String Connexion_PostgresSQL_Server;
public String getConnexion_PostgresSQL_Server(){
	return this.Connexion_PostgresSQL_Server;
}
		public String INPUTS;
		public String getINPUTS(){
			return this.INPUTS;
		}
		
public String Project_Name;
public String getProject_Name(){
	return this.Project_Name;
}
		public String OUTPUTS;
		public String getOUTPUTS(){
			return this.OUTPUTS;
		}
		
public String TopicPulsar;
public String getTopicPulsar(){
	return this.TopicPulsar;
}
public String UrlConnexionPulsar;
public String getUrlConnexionPulsar(){
	return this.UrlConnexionPulsar;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Migration_Vers_Pulsar";
	private final String projectName = "PROJET_TALEND";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());
		
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();

private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Migration_Vers_Pulsar.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Migration_Vers_Pulsar.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
				tLogCatcher_1.addMessage("Java Exception", currentComponent, 6, e.getClass().getName() + ":" + e.getMessage(), 1);
				tLogCatcher_1Process(globalMap);
			}
			} catch (TalendException e) {
				// do nothing
			
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tFileInputExcel_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tReplicate_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJMSOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tReplicate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileList_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tForeach_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tReplicate_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogCatcher_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileOutputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_Regions_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_Flux_Produits_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_Flux_Ventes_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWriteJSONField_1_Out_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tWriteJSONField_1_In_error(exception, errorComponent, globalMap);
						
						}
					
			public void tWriteJSONField_1_In_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputExcel_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileList_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tLogCatcher_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tWriteJSONField_1_In_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class Flux_Clients_FullStruct implements routines.system.IPersistableRow<Flux_Clients_FullStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				
			    public String Regions;

				public String getRegions () {
					return this.Regions;
				}
				
			    public String Adresse_Complete;

				public String getAdresse_Complete () {
					return this.Adresse_Complete;
				}
				
			    public String Nom_Projet;

				public String getNom_Projet () {
					return this.Nom_Projet;
				}
				
			    public String Nom_Produit;

				public String getNom_Produit () {
					return this.Nom_Produit;
				}
				
			    public String Categorie;

				public String getCategorie () {
					return this.Categorie;
				}
				
			    public String SousCategorie;

				public String getSousCategorie () {
					return this.SousCategorie;
				}
				
			    public String Prix_Unitaire;

				public String getPrix_Unitaire () {
					return this.Prix_Unitaire;
				}
				
			    public String Cout_unitaire;

				public String getCout_unitaire () {
					return this.Cout_unitaire;
				}
				
			    public String NumeroCommande;

				public String getNumeroCommande () {
					return this.NumeroCommande;
				}
				
			    public java.util.Date DateCommande;

				public java.util.Date getDateCommande () {
					return this.DateCommande;
				}
				
			    public java.util.Date DateLivraison;

				public java.util.Date getDateLivraison () {
					return this.DateLivraison;
				}
				
			    public String CanalAquisition;

				public String getCanalAquisition () {
					return this.CanalAquisition;
				}
				
			    public Integer Qte;

				public Integer getQte () {
					return this.Qte;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.IdentifiantClient == null) ? 0 : this.IdentifiantClient.hashCode());
					
						result = prime * result + ((this.NumeroCommande == null) ? 0 : this.NumeroCommande.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Flux_Clients_FullStruct other = (Flux_Clients_FullStruct) obj;
		
						if (this.IdentifiantClient == null) {
							if (other.IdentifiantClient != null)
								return false;
						
						} else if (!this.IdentifiantClient.equals(other.IdentifiantClient))
						
							return false;
					
						if (this.NumeroCommande == null) {
							if (other.NumeroCommande != null)
								return false;
						
						} else if (!this.NumeroCommande.equals(other.NumeroCommande))
						
							return false;
					

		return true;
    }

	public void copyDataTo(Flux_Clients_FullStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            other.Client = this.Client;
	            other.Prenom = this.Prenom;
	            other.Nom = this.Nom;
	            other.Adresse = this.Adresse;
	            other.Code_Postal = this.Code_Postal;
	            other.Villes = this.Villes;
	            other.Telephone = this.Telephone;
	            other.Regions = this.Regions;
	            other.Adresse_Complete = this.Adresse_Complete;
	            other.Nom_Projet = this.Nom_Projet;
	            other.Nom_Produit = this.Nom_Produit;
	            other.Categorie = this.Categorie;
	            other.SousCategorie = this.SousCategorie;
	            other.Prix_Unitaire = this.Prix_Unitaire;
	            other.Cout_unitaire = this.Cout_unitaire;
	            other.NumeroCommande = this.NumeroCommande;
	            other.DateCommande = this.DateCommande;
	            other.DateLivraison = this.DateLivraison;
	            other.CanalAquisition = this.CanalAquisition;
	            other.Qte = this.Qte;
	            
	}

	public void copyKeysDataTo(Flux_Clients_FullStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            	other.NumeroCommande = this.NumeroCommande;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
		sb.append(",Regions="+Regions);
		sb.append(",Adresse_Complete="+Adresse_Complete);
		sb.append(",Nom_Projet="+Nom_Projet);
		sb.append(",Nom_Produit="+Nom_Produit);
		sb.append(",Categorie="+Categorie);
		sb.append(",SousCategorie="+SousCategorie);
		sb.append(",Prix_Unitaire="+Prix_Unitaire);
		sb.append(",Cout_unitaire="+Cout_unitaire);
		sb.append(",NumeroCommande="+NumeroCommande);
		sb.append(",DateCommande="+String.valueOf(DateCommande));
		sb.append(",DateLivraison="+String.valueOf(DateLivraison));
		sb.append(",CanalAquisition="+CanalAquisition);
		sb.append(",Qte="+String.valueOf(Qte));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Flux_Clients_FullStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.IdentifiantClient, other.IdentifiantClient);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.NumeroCommande, other.NumeroCommande);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class ClientStruct implements routines.system.IPersistableRow<ClientStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				
			    public String Regions;

				public String getRegions () {
					return this.Regions;
				}
				
			    public String Adresse_Complete;

				public String getAdresse_Complete () {
					return this.Adresse_Complete;
				}
				
			    public String Nom_Projet;

				public String getNom_Projet () {
					return this.Nom_Projet;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.IdentifiantClient == null) ? 0 : this.IdentifiantClient.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ClientStruct other = (ClientStruct) obj;
		
						if (this.IdentifiantClient == null) {
							if (other.IdentifiantClient != null)
								return false;
						
						} else if (!this.IdentifiantClient.equals(other.IdentifiantClient))
						
							return false;
					

		return true;
    }

	public void copyDataTo(ClientStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            other.Client = this.Client;
	            other.Prenom = this.Prenom;
	            other.Nom = this.Nom;
	            other.Adresse = this.Adresse;
	            other.Code_Postal = this.Code_Postal;
	            other.Villes = this.Villes;
	            other.Telephone = this.Telephone;
	            other.Regions = this.Regions;
	            other.Adresse_Complete = this.Adresse_Complete;
	            other.Nom_Projet = this.Nom_Projet;
	            
	}

	public void copyKeysDataTo(ClientStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
		sb.append(",Regions="+Regions);
		sb.append(",Adresse_Complete="+Adresse_Complete);
		sb.append(",Nom_Projet="+Nom_Projet);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ClientStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.IdentifiantClient, other.IdentifiantClient);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class Flux_ClientsStruct implements routines.system.IPersistableRow<Flux_ClientsStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				
			    public String Regions;

				public String getRegions () {
					return this.Regions;
				}
				
			    public String Adresse_Complete;

				public String getAdresse_Complete () {
					return this.Adresse_Complete;
				}
				
			    public String Nom_Projet;

				public String getNom_Projet () {
					return this.Nom_Projet;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
		sb.append(",Regions="+Regions);
		sb.append(",Adresse_Complete="+Adresse_Complete);
		sb.append(",Nom_Projet="+Nom_Projet);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Flux_ClientsStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class Clients_FullStruct implements routines.system.IPersistableRow<Clients_FullStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				
			    public String Regions;

				public String getRegions () {
					return this.Regions;
				}
				
			    public String Adresse_Complete;

				public String getAdresse_Complete () {
					return this.Adresse_Complete;
				}
				
			    public String Nom_Projet;

				public String getNom_Projet () {
					return this.Nom_Projet;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.IdentifiantClient == null) ? 0 : this.IdentifiantClient.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Clients_FullStruct other = (Clients_FullStruct) obj;
		
						if (this.IdentifiantClient == null) {
							if (other.IdentifiantClient != null)
								return false;
						
						} else if (!this.IdentifiantClient.equals(other.IdentifiantClient))
						
							return false;
					

		return true;
    }

	public void copyDataTo(Clients_FullStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            other.Client = this.Client;
	            other.Prenom = this.Prenom;
	            other.Nom = this.Nom;
	            other.Adresse = this.Adresse;
	            other.Code_Postal = this.Code_Postal;
	            other.Villes = this.Villes;
	            other.Telephone = this.Telephone;
	            other.Regions = this.Regions;
	            other.Adresse_Complete = this.Adresse_Complete;
	            other.Nom_Projet = this.Nom_Projet;
	            
	}

	public void copyKeysDataTo(Clients_FullStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
					this.Regions = readString(dis);
					
					this.Adresse_Complete = readString(dis);
					
					this.Nom_Projet = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
					// String
				
						writeString(this.Regions,dos);
					
					// String
				
						writeString(this.Adresse_Complete,dos);
					
					// String
				
						writeString(this.Nom_Projet,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
		sb.append(",Regions="+Regions);
		sb.append(",Adresse_Complete="+Adresse_Complete);
		sb.append(",Nom_Projet="+Nom_Projet);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Clients_FullStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.IdentifiantClient, other.IdentifiantClient);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class ClientsStruct implements routines.system.IPersistableRow<ClientsStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ClientsStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tFileInputExcel_1Struct implements routines.system.IPersistableRow<after_tFileInputExcel_1Struct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String Client;

				public String getClient () {
					return this.Client;
				}
				
			    public String Prenom;

				public String getPrenom () {
					return this.Prenom;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Integer Code_Postal;

				public Integer getCode_Postal () {
					return this.Code_Postal;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				
			    public String Telephone;

				public String getTelephone () {
					return this.Telephone;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
					this.Client = readString(dis);
					
					this.Prenom = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Adresse = readString(dis);
					
						this.Code_Postal = readInteger(dis);
					
					this.Villes = readString(dis);
					
					this.Telephone = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.Client,dos);
					
					// String
				
						writeString(this.Prenom,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Integer
				
						writeInteger(this.Code_Postal,dos);
					
					// String
				
						writeString(this.Villes,dos);
					
					// String
				
						writeString(this.Telephone,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",Client="+Client);
		sb.append(",Prenom="+Prenom);
		sb.append(",Nom="+Nom);
		sb.append(",Adresse="+Adresse);
		sb.append(",Code_Postal="+String.valueOf(Code_Postal));
		sb.append(",Villes="+Villes);
		sb.append(",Telephone="+Telephone);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tFileInputExcel_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputExcel_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tFileInputExcel_2Process(globalMap);
		tFileInputExcel_3Process(globalMap);
		tFileList_1Process(globalMap);

		ClientsStruct Clients = new ClientsStruct();
Clients_FullStruct Clients_Full = new Clients_FullStruct();
ClientStruct Client = new ClientStruct();
Flux_ClientsStruct Flux_Clients = new Flux_ClientsStruct();
Flux_Clients_FullStruct Flux_Clients_Full = new Flux_Clients_FullStruct();






	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Client");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("Clients");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("Clients");
}

        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 11 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	conn_tDBOutput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	



int count_tDBOutput_1=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_1 = "public";
                                    if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_1.next()){
                                                defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_1.next()) {
                                        String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                        String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_1.equals(("Clients"))
                                            && (schema_tDBOutput_1.equals(dbschema_tDBOutput_1) || ((dbschema_tDBOutput_1 ==null || dbschema_tDBOutput_1.trim().length() ==0) && defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
                                            whetherExist_tDBOutput_1 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1 + "\"(\"IdentifiantClient\" INT4 ,\"Client\" VARCHAR(14)  ,\"Prenom\" VARCHAR(20)  ,\"Nom\" VARCHAR(20)  ,\"Adresse\" VARCHAR(30)  ,\"Code_Postal\" INT8 ,\"Villes\" VARCHAR(13)  ,\"Telephone\" VARCHAR(14)  ,\"Regions\" VARCHAR(20)  ,\"Adresse_Complete\" VARCHAR(255)  ,\"Nom_Projet\" VARCHAR(255)  ,primary key(\"IdentifiantClient\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_1 + "\" WHERE \"IdentifiantClient\" = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"IdentifiantClient\",\"Client\",\"Prenom\",\"Nom\",\"Adresse\",\"Code_Postal\",\"Villes\",\"Telephone\",\"Regions\",\"Adresse_Complete\",\"Nom_Projet\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"Client\" = ?,\"Prenom\" = ?,\"Nom\" = ?,\"Adresse\" = ?,\"Code_Postal\" = ?,\"Villes\" = ?,\"Telephone\" = ?,\"Regions\" = ?,\"Adresse_Complete\" = ?,\"Nom_Projet\" = ? WHERE \"IdentifiantClient\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */





	
	/**
	 * [tWriteJSONField_1_Out begin ] start
	 */

	

	
		
		ok_Hash.put("tWriteJSONField_1_Out", false);
		start_Hash.put("tWriteJSONField_1_Out", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Flux_Clients_Full");
					}
				
		int tos_count_tWriteJSONField_1_Out = 0;
		
//tWriteXMLFieldOut_begin
				int nb_line_tWriteJSONField_1_Out = 0;
				boolean needRoot_tWriteJSONField_1_Out  = true;
				
				String  strCompCache_tWriteJSONField_1_Out= null;		
				
						        java.util.Queue<Json_ComplexeStruct> listGroupby_tWriteJSONField_1_Out = new java.util.concurrent.ConcurrentLinkedQueue<Json_ComplexeStruct>();
							
	
					class ThreadXMLField_tWriteJSONField_1_Out extends Thread {
						
									    java.util.Queue<Json_ComplexeStruct> queue;
									
						java.util.List<java.util.Map<String,String>> flows;
						java.lang.Exception lastException;
						java.lang.Error lastError;
						String currentComponent;
						
						ThreadXMLField_tWriteJSONField_1_Out(java.util.Queue q) {
							this.queue = q;
							globalMap.put("queue_tWriteJSONField_1_In", queue);
							lastException = null;
						}
						
						ThreadXMLField_tWriteJSONField_1_Out(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {
							this.queue = q;
							this.flows = l;
							lastException = null;
							globalMap.put("queue_tWriteJSONField_1_In", queue);
							globalMap.put("flows_tWriteJSONField_1_In", flows);
						}
						
						public java.lang.Exception getLastException() {
							return this.lastException;
						}
						
						public java.lang.Error getLastError() {
							return this.lastError;
						}
						
						public String getCurrentComponent() {
							return this.currentComponent;
						}
	
						@Override
						public void run() {
							try {
								tWriteJSONField_1_InProcess(globalMap);
							} catch (TalendException te) {
globalMap.put("tWriteJSONField_1_Out_ERROR_MESSAGE",te.getMessage());
								this.lastException = te.getException();
								this.currentComponent = te.getCurrentComponent();
							} catch (java.lang.Error error) {
								this.lastError = error;
							}
						}
					}
					
						ThreadXMLField_tWriteJSONField_1_Out txf_tWriteJSONField_1_Out = new ThreadXMLField_tWriteJSONField_1_Out(listGroupby_tWriteJSONField_1_Out);
					
					globalMap.put("wrtXMLFieldIn_tWriteJSONField_1_Out", txf_tWriteJSONField_1_Out);
					txf_tWriteJSONField_1_Out.start();
				

java.util.List<java.util.List<String>> groupbyList_tWriteJSONField_1_Out = new java.util.ArrayList<java.util.List<String>>();
java.util.Map<String,String> valueMap_tWriteJSONField_1_Out = new java.util.HashMap<String,String>();
java.util.Map<String,String> arraysValueMap_tWriteJSONField_1_Out = new java.util.HashMap<String,String>();

class NestXMLTool_tWriteJSONField_1_Out{
	public void parseAndAdd(org.dom4j.Element nestRoot, String value){
		try {
            org.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText("<root>"+ value + "</root>");
    		nestRoot.setContent(doc4Str.getRootElement().content());
    	} catch (java.lang.Exception e) {
globalMap.put("tWriteJSONField_1_Out_ERROR_MESSAGE",e.getMessage());
    		e.printStackTrace();
    		nestRoot.setText(value);
        }
	}
	
	public void setText(org.dom4j.Element element, String value){
		if (value.startsWith("<![CDATA[") && value.endsWith("]]>")) {
			String text = value.substring(9, value.length()-3);
			element.addCDATA(text);
		}else{
			element.setText(value);
		}
	}
	
	public void replaceDefaultNameSpace(org.dom4j.Element nestRoot){
		if (nestRoot!=null) {
			for (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {
        		if (("").equals(tmp.getQName().getNamespace().getURI()) && ("").equals(tmp.getQName().getNamespace().getPrefix())){
        			tmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));
	        	}
    	    	replaceDefaultNameSpace(tmp);
       		}
       	}
	}
	
	public void removeEmptyElement(org.dom4j.Element root){
		if (root!=null) {
			for (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {
				removeEmptyElement(tmp);
			}

            boolean noSignificantDataAnnotationsExist = root.attributes().isEmpty() ;
            if (root.content().isEmpty()
                && noSignificantDataAnnotationsExist && root.declaredNamespaces().isEmpty()) {
                if(root.getParent()!=null){
                    root.getParent().remove(root);
                }
            }
        }
    }
	public String objectToString(Object value){
		if(value.getClass().isArray()){
			StringBuilder sb = new StringBuilder();

			int length = java.lang.reflect.Array.getLength(value);
			for (int i = 0; i < length; i++) {
				Object obj = java.lang.reflect.Array.get(value, i);
				sb.append("<element>");
				sb.append(obj);
				sb.append("</element>");
			}
			return sb.toString();
		}else{
			return value.toString();
		}
	}
}
NestXMLTool_tWriteJSONField_1_Out nestXMLTool_tWriteJSONField_1_Out = new NestXMLTool_tWriteJSONField_1_Out();

Flux_Clients_FullStruct  rowStructOutput_tWriteJSONField_1_Out = new Flux_Clients_FullStruct();
// sort group root element for judgement of group
java.util.List<org.dom4j.Element> groupElementList_tWriteJSONField_1_Out = new java.util.ArrayList<org.dom4j.Element>();
org.dom4j.Element root4Group_tWriteJSONField_1_Out = null;
org.dom4j.Document doc_tWriteJSONField_1_Out  = org.dom4j.DocumentHelper.createDocument();
org.dom4j.io.OutputFormat format_tWriteJSONField_1_Out = org.dom4j.io.OutputFormat.createCompactFormat();
format_tWriteJSONField_1_Out.setNewLineAfterDeclaration(false);
format_tWriteJSONField_1_Out.setTrimText(false);
format_tWriteJSONField_1_Out.setEncoding("ISO-8859-15");
int[] orders_tWriteJSONField_1_Out = new int[1];

 



/**
 * [tWriteJSONField_1_Out begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Flux_Clients");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_ProduitsStruct> tHash_Lookup_Flux_Produits = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_ProduitsStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_ProduitsStruct>) 
					globalMap.get( "tHash_Lookup_Flux_Produits" ))
					;					
					
	
		tHash_Lookup_Flux_Produits.initGet();
	

Flux_ProduitsStruct Flux_ProduitsHashKey = new Flux_ProduitsStruct();
Flux_ProduitsStruct Flux_ProduitsDefault = new Flux_ProduitsStruct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_VentesStruct> tHash_Lookup_Flux_Ventes = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_VentesStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_VentesStruct>) 
					globalMap.get( "tHash_Lookup_Flux_Ventes" ))
					;					
					
	

Flux_VentesStruct Flux_VentesHashKey = new Flux_VentesStruct();
Flux_VentesStruct Flux_VentesDefault = new Flux_VentesStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
Flux_Clients_FullStruct Flux_Clients_Full_tmp = new Flux_Clients_FullStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tReplicate_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tReplicate_3", false);
		start_Hash.put("tReplicate_3", System.currentTimeMillis());
		
	
	currentComponent="tReplicate_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Clients_Full");
					}
				
		int tos_count_tReplicate_3 = 0;
		

 



/**
 * [tReplicate_3 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Clients");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<RegionsStruct> tHash_Lookup_Regions = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<RegionsStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<RegionsStruct>) 
					globalMap.get( "tHash_Lookup_Regions" ))
					;					
					
	

RegionsStruct RegionsHashKey = new RegionsStruct();
RegionsStruct RegionsDefault = new RegionsStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
Clients_FullStruct Clients_Full_tmp = new Clients_FullStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_1", false);
		start_Hash.put("tFileInputExcel_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_1";

	
		int tos_count_tFileInputExcel_1 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:I8U1aM8qBsG7fAmqi3egMa5tGCyAC0AU9+MWkg==");
        String password_tFileInputExcel_1 = decryptedPassword_tFileInputExcel_1;
        if (password_tFileInputExcel_1.isEmpty()){
            password_tFileInputExcel_1 = null;
        }
			class RegexUtil_tFileInputExcel_1 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();

		Object source_tFileInputExcel_1 = context.INPUTS+"/Projet_Ressources/Client_Produit_Regions/Clients.xlsx";
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_1 = null;

		if(source_tFileInputExcel_1 instanceof String){
			workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_1), password_tFileInputExcel_1, true);
		} else if(source_tFileInputExcel_1 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_1, password_tFileInputExcel_1);
		} else{
			workbook_tFileInputExcel_1 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
    	for(org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_1 : workbook_tFileInputExcel_1){
   			sheetList_tFileInputExcel_1.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_1);
    	}
    	if(sheetList_tFileInputExcel_1.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
			if(sheet_FilterNull_tFileInputExcel_1!=null && sheetList_FilterNull_tFileInputExcel_1.iterator()!=null && sheet_FilterNull_tFileInputExcel_1.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
			}
		}
		sheetList_tFileInputExcel_1 = sheetList_FilterNull_tFileInputExcel_1;
	if(sheetList_tFileInputExcel_1.size()>0){
		int nb_line_tFileInputExcel_1 = 0;

        int begin_line_tFileInputExcel_1 = 1;

        int footer_input_tFileInputExcel_1 = 0;

        int end_line_tFileInputExcel_1=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1:sheetList_tFileInputExcel_1){
			end_line_tFileInputExcel_1+=(sheet_tFileInputExcel_1.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
        int limit_tFileInputExcel_1 = -1;
        int start_column_tFileInputExcel_1 = 1-1;
        int end_column_tFileInputExcel_1 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_1 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0);
        int rowCount_tFileInputExcel_1 = 0;
        int sheetIndex_tFileInputExcel_1 = 0;
        int currentRows_tFileInputExcel_1 = (sheetList_tFileInputExcel_1.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++){

        	int emptyColumnCount_tFileInputExcel_1 = 0;

        	if (limit_tFileInputExcel_1 != -1 && nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
        		break;
        	}

            while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1 + currentRows_tFileInputExcel_1) {
                rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
                sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(++sheetIndex_tFileInputExcel_1);
                currentRows_tFileInputExcel_1 = (sheet_tFileInputExcel_1.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_1_CURRENT_SHEET",sheet_tFileInputExcel_1.getSheetName());
            if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1) {
                row_tFileInputExcel_1 = sheet_tFileInputExcel_1.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
            }
		    Clients = null;
					int tempRowLength_tFileInputExcel_1 = 8;
				
				int columnIndex_tFileInputExcel_1 = 0;
			
			String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
			int excel_end_column_tFileInputExcel_1;
			if(row_tFileInputExcel_1==null){
				excel_end_column_tFileInputExcel_1=0;
			}else{
				excel_end_column_tFileInputExcel_1=row_tFileInputExcel_1.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_1;
			if(end_column_tFileInputExcel_1 == -1){
				actual_end_column_tFileInputExcel_1 = excel_end_column_tFileInputExcel_1;
			}
			else{
				actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 >	excel_end_column_tFileInputExcel_1 ? excel_end_column_tFileInputExcel_1 : end_column_tFileInputExcel_1;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_1 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_1;i++){
				if(i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1.getCell(i + start_column_tFileInputExcel_1);
					if(cell_tFileInputExcel_1!=null){
					switch (cell_tFileInputExcel_1.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_1)) {
									temp_row_tFileInputExcel_1[i] =cell_tFileInputExcel_1.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_1[i] = df_tFileInputExcel_1.format(cell_tFileInputExcel_1.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_1[i] =String.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_1.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_1)) {
											temp_row_tFileInputExcel_1[i] =cell_tFileInputExcel_1.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_1 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_1.getNumericCellValue());
										temp_row_tFileInputExcel_1[i] = ne_tFileInputExcel_1.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_1[i] =String.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_1[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_1[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_1[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_1[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_1 = false;
			Clients = new ClientsStruct();
			int curColNum_tFileInputExcel_1 = -1;
			String curColName_tFileInputExcel_1 = "";
			try{
							columnIndex_tFileInputExcel_1 = 0;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "IdentifiantClient";

				Clients.IdentifiantClient = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null, '.'==decimalChar_tFileInputExcel_1 ? null : decimalChar_tFileInputExcel_1));
			}else{
				Clients.IdentifiantClient = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 1;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Client";

				Clients.Client = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Client = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 2;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Prenom";

				Clients.Prenom = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Prenom = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 3;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Nom";

				Clients.Nom = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Nom = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 4;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Adresse";

				Clients.Adresse = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Adresse = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 5;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Code_Postal";

				Clients.Code_Postal = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null, '.'==decimalChar_tFileInputExcel_1 ? null : decimalChar_tFileInputExcel_1));
			}else{
				Clients.Code_Postal = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 6;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Villes";

				Clients.Villes = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Villes = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 7;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Telephone";

				Clients.Telephone = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				Clients.Telephone = null;
				emptyColumnCount_tFileInputExcel_1++;
			}

				nb_line_tFileInputExcel_1++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_1 = true;
					 System.err.println(e.getMessage());
					 Clients = null;
			}


		



 



/**
 * [tFileInputExcel_1 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 


	tos_count_tFileInputExcel_1++;

/**
 * [tFileInputExcel_1 main ] stop
 */
	
	/**
	 * [tFileInputExcel_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_begin ] stop
 */
// Start of branch "Clients"
if(Clients != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Clients"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "Regions" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopRegions = false;
       		  	    	
       		  	    	
 							RegionsStruct RegionsObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    RegionsHashKey.Villes = Clients.Villes ;
                        		    		

								
		                        	RegionsHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_Regions.lookup( RegionsHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_Regions.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLoopRegions = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopRegions = true;
			           		  	} // G 21
                    		  	
                    		

							RegionsStruct Regions = null;
                    		  	 
							

								while ((tHash_Lookup_Regions != null && tHash_Lookup_Regions.hasNext()) || forceLoopRegions) { // G_TM_M_043

								
									 // CALL close loop of lookup 'Regions'
									
                    		  	 
							   
                    		  	 
	       		  	    	RegionsStruct fromLookup_Regions = null;
							Regions = RegionsDefault;
										 
							
								
								if(!forceLoopRegions) { // G 46
								
							
								 
							
								
								fromLookup_Regions = tHash_Lookup_Regions.next();

							

							if(fromLookup_Regions != null) {
								Regions = fromLookup_Regions;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopRegions = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

Clients_Full = null;


// # Output table : 'Clients_Full'
Clients_Full_tmp.IdentifiantClient = Clients.IdentifiantClient ;
Clients_Full_tmp.Client = Clients.Client ;
Clients_Full_tmp.Prenom = Clients.Prenom ;
Clients_Full_tmp.Nom = Clients.Nom ;
Clients_Full_tmp.Adresse = Clients.Adresse ;
Clients_Full_tmp.Code_Postal = Clients.Code_Postal ;
Clients_Full_tmp.Villes = Clients.Villes ;
Clients_Full_tmp.Telephone = Clients.Telephone ;
Clients_Full_tmp.Regions = Regions.Regions ;
Clients_Full_tmp.Adresse_Complete = Clients.Adresse+" " +  Clients.Code_Postal +" " +  Clients.Villes ;
Clients_Full_tmp.Nom_Projet = (String)globalMap.get("NOM_PROJET"); ;
Clients_Full = Clients_Full_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "Clients_Full"
if(Clients_Full != null) { 



	
	/**
	 * [tReplicate_3 main ] start
	 */

	

	
	
	currentComponent="tReplicate_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Clients_Full"
						
						);
					}
					


	Client = new ClientStruct();
						
	Client.IdentifiantClient = Clients_Full.IdentifiantClient;								
	Client.Client = Clients_Full.Client;								
	Client.Prenom = Clients_Full.Prenom;								
	Client.Nom = Clients_Full.Nom;								
	Client.Adresse = Clients_Full.Adresse;								
	Client.Code_Postal = Clients_Full.Code_Postal;								
	Client.Villes = Clients_Full.Villes;								
	Client.Telephone = Clients_Full.Telephone;								
	Client.Regions = Clients_Full.Regions;								
	Client.Adresse_Complete = Clients_Full.Adresse_Complete;								
	Client.Nom_Projet = Clients_Full.Nom_Projet;			
	Flux_Clients = new Flux_ClientsStruct();
						
	Flux_Clients.IdentifiantClient = Clients_Full.IdentifiantClient;								
	Flux_Clients.Client = Clients_Full.Client;								
	Flux_Clients.Prenom = Clients_Full.Prenom;								
	Flux_Clients.Nom = Clients_Full.Nom;								
	Flux_Clients.Adresse = Clients_Full.Adresse;								
	Flux_Clients.Code_Postal = Clients_Full.Code_Postal;								
	Flux_Clients.Villes = Clients_Full.Villes;								
	Flux_Clients.Telephone = Clients_Full.Telephone;								
	Flux_Clients.Regions = Clients_Full.Regions;								
	Flux_Clients.Adresse_Complete = Clients_Full.Adresse_Complete;								
	Flux_Clients.Nom_Projet = Clients_Full.Nom_Projet;			


 


	tos_count_tReplicate_3++;

/**
 * [tReplicate_3 main ] stop
 */
	
	/**
	 * [tReplicate_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tReplicate_3";

	

 



/**
 * [tReplicate_3 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Client"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(Client.IdentifiantClient == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, Client.IdentifiantClient);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(Client.Client == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, Client.Client);
}

                        if(Client.Prenom == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, Client.Prenom);
}

                        if(Client.Nom == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, Client.Nom);
}

                        if(Client.Adresse == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, Client.Adresse);
}

                        if(Client.Code_Postal == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(5, Client.Code_Postal);
}

                        if(Client.Villes == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(6, Client.Villes);
}

                        if(Client.Telephone == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(7, Client.Telephone);
}

                        if(Client.Regions == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(8, Client.Regions);
}

                        if(Client.Adresse_Complete == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(9, Client.Adresse_Complete);
}

                        if(Client.Nom_Projet == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(10, Client.Nom_Projet);
}

                        if(Client.IdentifiantClient == null) {
pstmtUpdate_tDBOutput_1.setNull(11 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(11 + count_tDBOutput_1, Client.IdentifiantClient);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        throw(e);
                }
            } else {
                        if(Client.IdentifiantClient == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, Client.IdentifiantClient);
}

                        if(Client.Client == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, Client.Client);
}

                        if(Client.Prenom == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, Client.Prenom);
}

                        if(Client.Nom == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, Client.Nom);
}

                        if(Client.Adresse == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, Client.Adresse);
}

                        if(Client.Code_Postal == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(6, Client.Code_Postal);
}

                        if(Client.Villes == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(7, Client.Villes);
}

                        if(Client.Telephone == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(8, Client.Telephone);
}

                        if(Client.Regions == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(9, Client.Regions);
}

                        if(Client.Adresse_Complete == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(10, Client.Adresse_Complete);
}

                        if(Client.Nom_Projet == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(11, Client.Nom_Projet);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        throw(e);
                }
            }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */




	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Flux_Clients"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "Flux_Produits" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopFlux_Produits = false;
       		  	    	
       		  	    	
 							Flux_ProduitsStruct Flux_ProduitsObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								

								
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_Flux_Produits.lookup( Flux_ProduitsHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_Flux_Produits.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLoopFlux_Produits = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopFlux_Produits = true;
			           		  	} // G 21
                    		  	
                    		

							Flux_ProduitsStruct Flux_Produits = null;
                    		  	 
							

								while ((tHash_Lookup_Flux_Produits != null && tHash_Lookup_Flux_Produits.hasNext()) || forceLoopFlux_Produits) { // G_TM_M_043

								
									 // CALL close loop of lookup 'Flux_Produits'
									
                    		  	 
							   
                    		  	 
	       		  	    	Flux_ProduitsStruct fromLookup_Flux_Produits = null;
							Flux_Produits = Flux_ProduitsDefault;
										 
							
								
								if(!forceLoopFlux_Produits) { // G 46
								
							
								 
							
								
								fromLookup_Flux_Produits = tHash_Lookup_Flux_Produits.next();

							

							if(fromLookup_Flux_Produits != null) {
								Flux_Produits = fromLookup_Flux_Produits;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopFlux_Produits = false;
									 	
							
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "Flux_Ventes" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopFlux_Ventes = false;
       		  	    	
       		  	    	
 							Flux_VentesStruct Flux_VentesObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    Flux_VentesHashKey.IdentifiantClient = Flux_Clients.IdentifiantClient ;
                        		    		
                        		    		    Flux_VentesHashKey.IdentifiantProduit = Flux_Produits.NumeroProduit ;
                        		    		

								
		                        	Flux_VentesHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_Flux_Ventes.lookup( Flux_VentesHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_Flux_Ventes.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
	
		  								forceLoopFlux_Ventes = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopFlux_Ventes = true;
			           		  	} // G 21
                    		  	
                    		

							Flux_VentesStruct Flux_Ventes = null;
                    		  	 
							

								while ((tHash_Lookup_Flux_Ventes != null && tHash_Lookup_Flux_Ventes.hasNext()) || forceLoopFlux_Ventes) { // G_TM_M_043

								
									 // CALL close loop of lookup 'Flux_Ventes'
									
                    		  	 
							   
                    		  	 
	       		  	    	Flux_VentesStruct fromLookup_Flux_Ventes = null;
							Flux_Ventes = Flux_VentesDefault;
										 
							
								
								if(!forceLoopFlux_Ventes) { // G 46
								
							
								 
							
								
								fromLookup_Flux_Ventes = tHash_Lookup_Flux_Ventes.next();

							

							if(fromLookup_Flux_Ventes != null) {
								Flux_Ventes = fromLookup_Flux_Ventes;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopFlux_Ventes = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

Flux_Clients_Full = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'Flux_Clients_Full'
Flux_Clients_Full_tmp.IdentifiantClient = Flux_Clients.IdentifiantClient ;
Flux_Clients_Full_tmp.Client = Flux_Clients.Client ;
Flux_Clients_Full_tmp.Prenom = Flux_Clients.Prenom ;
Flux_Clients_Full_tmp.Nom = Flux_Clients.Nom ;
Flux_Clients_Full_tmp.Adresse = Flux_Clients.Adresse ;
Flux_Clients_Full_tmp.Code_Postal = Flux_Clients.Code_Postal ;
Flux_Clients_Full_tmp.Villes = Flux_Clients.Villes ;
Flux_Clients_Full_tmp.Telephone = Flux_Clients.Telephone ;
Flux_Clients_Full_tmp.Regions = Flux_Clients.Regions ;
Flux_Clients_Full_tmp.Adresse_Complete = Flux_Clients.Adresse_Complete ;
Flux_Clients_Full_tmp.Nom_Projet = Flux_Clients.Nom_Projet ;
Flux_Clients_Full_tmp.Nom_Produit = Flux_Produits.Nom_Produit ;
Flux_Clients_Full_tmp.Categorie = Flux_Produits.Categorie ;
Flux_Clients_Full_tmp.SousCategorie = Flux_Produits.SousCategorie ;
Flux_Clients_Full_tmp.Prix_Unitaire = Flux_Produits.Prix_Unitaire ;
Flux_Clients_Full_tmp.Cout_unitaire = Flux_Produits.Cout_unitaire ;
Flux_Clients_Full_tmp.NumeroCommande = Flux_Ventes.NumeroCommande ;
Flux_Clients_Full_tmp.DateCommande = Flux_Ventes.DateCommande ;
Flux_Clients_Full_tmp.DateLivraison = Flux_Ventes.DateLivraison ;
Flux_Clients_Full_tmp.CanalAquisition = Flux_Ventes.CanalAquisition ;
Flux_Clients_Full_tmp.Qte = Flux_Ventes.Qte ;
Flux_Clients_Full = Flux_Clients_Full_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "Flux_Clients_Full"
if(Flux_Clients_Full != null) { 



	
	/**
	 * [tWriteJSONField_1_Out main ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Flux_Clients_Full"
						
						);
					}
					

	if(txf_tWriteJSONField_1_Out.getLastException()!=null) {
		currentComponent = txf_tWriteJSONField_1_Out.getCurrentComponent();
		throw txf_tWriteJSONField_1_Out.getLastException();
	}
	
	if(txf_tWriteJSONField_1_Out.getLastError()!=null) {
		throw txf_tWriteJSONField_1_Out.getLastError();
	}
	nb_line_tWriteJSONField_1_Out++;
	class ToStringHelper_tWriteJSONField_1_Out {
	    public String toString(final Object value) {
	        return value != null ? value.toString() : null;
	    }
	}
	final ToStringHelper_tWriteJSONField_1_Out helper_tWriteJSONField_1_Out = new ToStringHelper_tWriteJSONField_1_Out();

	valueMap_tWriteJSONField_1_Out.clear();
	arraysValueMap_tWriteJSONField_1_Out.clear();
	valueMap_tWriteJSONField_1_Out.put("IdentifiantClient", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.IdentifiantClient != null?
            Flux_Clients_Full.IdentifiantClient.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("IdentifiantClient", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.IdentifiantClient != null?
            Flux_Clients_Full.IdentifiantClient.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Client", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Client != null?
            Flux_Clients_Full.Client.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Client", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Client != null?
            Flux_Clients_Full.Client.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Prenom", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Prenom != null?
            Flux_Clients_Full.Prenom.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Prenom", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Prenom != null?
            Flux_Clients_Full.Prenom.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Nom", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom != null?
            Flux_Clients_Full.Nom.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Nom", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom != null?
            Flux_Clients_Full.Nom.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Adresse", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Adresse != null?
            Flux_Clients_Full.Adresse.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Adresse", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Adresse != null?
            Flux_Clients_Full.Adresse.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Code_Postal", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Code_Postal != null?
            Flux_Clients_Full.Code_Postal.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Code_Postal", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Code_Postal != null?
            Flux_Clients_Full.Code_Postal.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Villes", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Villes != null?
            Flux_Clients_Full.Villes.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Villes", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Villes != null?
            Flux_Clients_Full.Villes.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Telephone", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Telephone != null?
            Flux_Clients_Full.Telephone.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Telephone", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Telephone != null?
            Flux_Clients_Full.Telephone.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Regions", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Regions != null?
            Flux_Clients_Full.Regions.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Regions", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Regions != null?
            Flux_Clients_Full.Regions.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Adresse_Complete", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Adresse_Complete != null?
            Flux_Clients_Full.Adresse_Complete.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Adresse_Complete", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Adresse_Complete != null?
            Flux_Clients_Full.Adresse_Complete.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Nom_Projet", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom_Projet != null?
            Flux_Clients_Full.Nom_Projet.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Nom_Projet", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom_Projet != null?
            Flux_Clients_Full.Nom_Projet.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Nom_Produit", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom_Produit != null?
            Flux_Clients_Full.Nom_Produit.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Nom_Produit", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Nom_Produit != null?
            Flux_Clients_Full.Nom_Produit.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Categorie", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Categorie != null?
            Flux_Clients_Full.Categorie.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Categorie", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Categorie != null?
            Flux_Clients_Full.Categorie.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("SousCategorie", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.SousCategorie != null?
            Flux_Clients_Full.SousCategorie.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("SousCategorie", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.SousCategorie != null?
            Flux_Clients_Full.SousCategorie.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Prix_Unitaire", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Prix_Unitaire != null?
            Flux_Clients_Full.Prix_Unitaire.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Prix_Unitaire", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Prix_Unitaire != null?
            Flux_Clients_Full.Prix_Unitaire.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Cout_unitaire", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Cout_unitaire != null?
            Flux_Clients_Full.Cout_unitaire.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Cout_unitaire", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Cout_unitaire != null?
            Flux_Clients_Full.Cout_unitaire.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("NumeroCommande", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.NumeroCommande != null?
            Flux_Clients_Full.NumeroCommande.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("NumeroCommande", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.NumeroCommande != null?
            Flux_Clients_Full.NumeroCommande.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("DateCommande", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.DateCommande != null?
            FormatterUtils.format_Date(Flux_Clients_Full.DateCommande,"dd/MM/yyyy"):null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("DateCommande", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.DateCommande != null?
            FormatterUtils.format_Date(Flux_Clients_Full.DateCommande,"dd/MM/yyyy"):null
		)));
	valueMap_tWriteJSONField_1_Out.put("DateLivraison", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.DateLivraison != null?
            FormatterUtils.format_Date(Flux_Clients_Full.DateLivraison,"dd/MM/yyyy"):null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("DateLivraison", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.DateLivraison != null?
            FormatterUtils.format_Date(Flux_Clients_Full.DateLivraison,"dd/MM/yyyy"):null
		)));
	valueMap_tWriteJSONField_1_Out.put("CanalAquisition", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.CanalAquisition != null?
            Flux_Clients_Full.CanalAquisition.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("CanalAquisition", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.CanalAquisition != null?
            Flux_Clients_Full.CanalAquisition.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("Qte", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Qte != null?
            Flux_Clients_Full.Qte.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("Qte", helper_tWriteJSONField_1_Out.toString(
	(
		Flux_Clients_Full.Qte != null?
            Flux_Clients_Full.Qte.toString():null
		)));
		String strTemp_tWriteJSONField_1_Out = "";
	if(strCompCache_tWriteJSONField_1_Out==null){
		strCompCache_tWriteJSONField_1_Out=strTemp_tWriteJSONField_1_Out;
		
	}else{  
    		nestXMLTool_tWriteJSONField_1_Out.replaceDefaultNameSpace(doc_tWriteJSONField_1_Out.getRootElement());			
			java.io.StringWriter strWriter_tWriteJSONField_1_Out = new java.io.StringWriter();	
			org.dom4j.io.XMLWriter output_tWriteJSONField_1_Out = new org.dom4j.io.XMLWriter(strWriter_tWriteJSONField_1_Out, format_tWriteJSONField_1_Out);
			output_tWriteJSONField_1_Out.write(doc_tWriteJSONField_1_Out);
		    output_tWriteJSONField_1_Out.close();
			
				  		  Json_ComplexeStruct row_tWriteJSONField_1_Out = new Json_ComplexeStruct();
						  
					     		row_tWriteJSONField_1_Out.messageContent = strWriter_tWriteJSONField_1_Out.toString();
					     		listGroupby_tWriteJSONField_1_Out.add(row_tWriteJSONField_1_Out);
					
		    doc_tWriteJSONField_1_Out.clearContent();
			needRoot_tWriteJSONField_1_Out = true;
			for(int i_tWriteJSONField_1_Out=0;i_tWriteJSONField_1_Out<orders_tWriteJSONField_1_Out.length;i_tWriteJSONField_1_Out++){
				orders_tWriteJSONField_1_Out[i_tWriteJSONField_1_Out] = 0;
			}
			
			if(groupbyList_tWriteJSONField_1_Out != null && groupbyList_tWriteJSONField_1_Out.size() >= 0){
				groupbyList_tWriteJSONField_1_Out.clear();
			}
			strCompCache_tWriteJSONField_1_Out=strTemp_tWriteJSONField_1_Out;
	}

	org.dom4j.Element subTreeRootParent_tWriteJSONField_1_Out = null;
	
	// build root xml tree 
	if (needRoot_tWriteJSONField_1_Out) {
		needRoot_tWriteJSONField_1_Out=false;
		org.dom4j.Element root_tWriteJSONField_1_Out = doc_tWriteJSONField_1_Out.addElement("messageContent");
		subTreeRootParent_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out;
		org.dom4j.Element root_0_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out.addElement("Project_Name");
		if(
		valueMap_tWriteJSONField_1_Out.get("Nom_Projet")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(root_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Nom_Projet"));
		}
		org.dom4j.Element root_1_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out.addElement("IdentifiantClient");
		if(
		valueMap_tWriteJSONField_1_Out.get("IdentifiantClient")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(root_1_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("IdentifiantClient"));
            root_1_tWriteJSONField_1_Out.addAttribute("type", "number");
		}
		root4Group_tWriteJSONField_1_Out = subTreeRootParent_tWriteJSONField_1_Out;
	}else{
		subTreeRootParent_tWriteJSONField_1_Out=root4Group_tWriteJSONField_1_Out;
	}
	// build group xml tree 
	// build loop xml tree
		org.dom4j.Element loop_tWriteJSONField_1_Out = org.dom4j.DocumentHelper.createElement("Client");
        if(orders_tWriteJSONField_1_Out[0]==0){
        	orders_tWriteJSONField_1_Out[0] = 2;
        }
        if(1 < orders_tWriteJSONField_1_Out.length){
        		orders_tWriteJSONField_1_Out[1] = 0;
        }
        subTreeRootParent_tWriteJSONField_1_Out.elements().add(orders_tWriteJSONField_1_Out[0]++,loop_tWriteJSONField_1_Out);
		org.dom4j.Element loop_0_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Nom_Client");
		if(
		valueMap_tWriteJSONField_1_Out.get("Client")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Client"));
		}
		org.dom4j.Element loop_1_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Nom");
		if(
		valueMap_tWriteJSONField_1_Out.get("Nom")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_1_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Nom"));
		}
		org.dom4j.Element loop_2_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Prenom");
		if(
		valueMap_tWriteJSONField_1_Out.get("Prenom")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_2_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Prenom"));
		}
		org.dom4j.Element loop_3_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Adresse");
		if(
		valueMap_tWriteJSONField_1_Out.get("Adresse")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_3_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Adresse"));
		}
		org.dom4j.Element loop_4_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Code_Postal");
		if(
		valueMap_tWriteJSONField_1_Out.get("Code_Postal")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_4_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Code_Postal"));
            loop_4_tWriteJSONField_1_Out.addAttribute("type", "number");
		}
		org.dom4j.Element loop_5_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Ville");
		if(
		valueMap_tWriteJSONField_1_Out.get("Villes")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_5_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Villes"));
		}
		org.dom4j.Element loop_6_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Telephone");
		if(
		valueMap_tWriteJSONField_1_Out.get("Telephone")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_6_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Telephone"));
		}
		org.dom4j.Element loop_7_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Adresse_Complete");
		if(
		valueMap_tWriteJSONField_1_Out.get("Adresse_Complete")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_7_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Adresse_Complete"));
		}
		org.dom4j.Element loop_8_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Produit");
		org.dom4j.Element loop_8_0_tWriteJSONField_1_Out = loop_8_tWriteJSONField_1_Out.addElement("Nom_Produit");
		if(
		valueMap_tWriteJSONField_1_Out.get("Nom_Produit")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_8_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Nom_Produit"));
		}
		org.dom4j.Element loop_8_1_tWriteJSONField_1_Out = loop_8_tWriteJSONField_1_Out.addElement("Categorie");
		org.dom4j.Element loop_8_1_0_tWriteJSONField_1_Out = loop_8_1_tWriteJSONField_1_Out.addElement("Nom_Categorie");
		if(
		valueMap_tWriteJSONField_1_Out.get("Categorie")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_8_1_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Categorie"));
		}
		org.dom4j.Element loop_8_1_1_tWriteJSONField_1_Out = loop_8_1_tWriteJSONField_1_Out.addElement("Sous_Categorie");
		org.dom4j.Element loop_8_1_1_0_tWriteJSONField_1_Out = loop_8_1_1_tWriteJSONField_1_Out.addElement("Nom_Sous_Categorie_Produit");
		if(
		valueMap_tWriteJSONField_1_Out.get("SousCategorie")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_8_1_1_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("SousCategorie"));
		}
		org.dom4j.Element loop_8_2_tWriteJSONField_1_Out = loop_8_tWriteJSONField_1_Out.addElement("Prix_Unitaire");
		if(
		valueMap_tWriteJSONField_1_Out.get("Prix_Unitaire")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_8_2_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Prix_Unitaire"));
		}
		org.dom4j.Element loop_8_3_tWriteJSONField_1_Out = loop_8_tWriteJSONField_1_Out.addElement("Cout_Unitaire");
		if(
		valueMap_tWriteJSONField_1_Out.get("Cout_unitaire")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_8_3_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Cout_unitaire"));
		}
		org.dom4j.Element loop_9_tWriteJSONField_1_Out = loop_tWriteJSONField_1_Out.addElement("Ventes");
		org.dom4j.Element loop_9_0_tWriteJSONField_1_Out = loop_9_tWriteJSONField_1_Out.addElement("Numero_Commande");
		if(
		valueMap_tWriteJSONField_1_Out.get("NumeroCommande")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_9_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("NumeroCommande"));
		}
		org.dom4j.Element loop_9_1_tWriteJSONField_1_Out = loop_9_tWriteJSONField_1_Out.addElement("Date_Commande");
		if(
		valueMap_tWriteJSONField_1_Out.get("DateCommande")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_9_1_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("DateCommande"));
		}
		org.dom4j.Element loop_9_2_tWriteJSONField_1_Out = loop_9_tWriteJSONField_1_Out.addElement("Date_Livraison");
		if(
		valueMap_tWriteJSONField_1_Out.get("DateLivraison")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_9_2_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("DateLivraison"));
		}
		org.dom4j.Element loop_9_3_tWriteJSONField_1_Out = loop_9_tWriteJSONField_1_Out.addElement("Canal_Acquisition");
		if(
		valueMap_tWriteJSONField_1_Out.get("CanalAquisition")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_9_3_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("CanalAquisition"));
		}
		org.dom4j.Element loop_9_4_tWriteJSONField_1_Out = loop_9_tWriteJSONField_1_Out.addElement("Quantité");
		if(
		valueMap_tWriteJSONField_1_Out.get("Qte")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_9_4_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("Qte"));
            loop_9_4_tWriteJSONField_1_Out.addAttribute("type", "number");
		}

 


	tos_count_tWriteJSONField_1_Out++;

/**
 * [tWriteJSONField_1_Out main ] stop
 */
	
	/**
	 * [tWriteJSONField_1_Out process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

 



/**
 * [tWriteJSONField_1_Out process_data_begin ] stop
 */
	
	/**
	 * [tWriteJSONField_1_Out process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

 



/**
 * [tWriteJSONField_1_Out process_data_end ] stop
 */

} // End of branch "Flux_Clients_Full"



	
		} // close loop of lookup 'Flux_Ventes' // G_TM_M_043
		
		} // close loop of lookup 'Flux_Produits' // G_TM_M_043
	
	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tReplicate_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tReplicate_3";

	

 



/**
 * [tReplicate_3 process_data_end ] stop
 */

} // End of branch "Clients_Full"



	
		} // close loop of lookup 'Regions' // G_TM_M_043
	
	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "Clients"




	
	/**
	 * [tFileInputExcel_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_1_NB_LINE",nb_line_tFileInputExcel_1);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_1 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_1.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_1", true);
end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());




/**
 * [tFileInputExcel_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_Regions != null) {
						tHash_Lookup_Regions.endGet();
					}
					globalMap.remove( "tHash_Lookup_Regions" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Clients");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tReplicate_3 end ] start
	 */

	

	
	
	currentComponent="tReplicate_3";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Clients_Full");
			  	}
			  	
 

ok_Hash.put("tReplicate_3", true);
end_Hash.put("tReplicate_3", System.currentTimeMillis());




/**
 * [tReplicate_3 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
        if(pstmt_tDBOutput_1 != null) {
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Client");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */




	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_Flux_Produits != null) {
						tHash_Lookup_Flux_Produits.endGet();
					}
					globalMap.remove( "tHash_Lookup_Flux_Produits" );

					
					
				
					if(tHash_Lookup_Flux_Ventes != null) {
						tHash_Lookup_Flux_Ventes.endGet();
					}
					globalMap.remove( "tHash_Lookup_Flux_Ventes" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Flux_Clients");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tWriteJSONField_1_Out end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

if(nb_line_tWriteJSONField_1_Out > 0){  
    nestXMLTool_tWriteJSONField_1_Out.replaceDefaultNameSpace(doc_tWriteJSONField_1_Out.getRootElement());
	java.io.StringWriter strWriter_tWriteJSONField_1_Out = new java.io.StringWriter();
	org.dom4j.io.XMLWriter output_tWriteJSONField_1_Out = new org.dom4j.io.XMLWriter(strWriter_tWriteJSONField_1_Out, format_tWriteJSONField_1_Out);
	output_tWriteJSONField_1_Out.write(doc_tWriteJSONField_1_Out);
    output_tWriteJSONField_1_Out.close();
					Json_ComplexeStruct row_tWriteJSONField_1_Out = new Json_ComplexeStruct();
						  
					     		row_tWriteJSONField_1_Out.messageContent = strWriter_tWriteJSONField_1_Out.toString();
					     		listGroupby_tWriteJSONField_1_Out.add(row_tWriteJSONField_1_Out);
		    		

}
globalMap.put("tWriteJSONField_1_Out_NB_LINE",nb_line_tWriteJSONField_1_Out);
globalMap.put("tWriteJSONField_1_In_FINISH" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
	
		txf_tWriteJSONField_1_Out.join();
		
		if(txf_tWriteJSONField_1_Out.getLastException()!=null) {
			currentComponent = txf_tWriteJSONField_1_Out.getCurrentComponent();
			throw txf_tWriteJSONField_1_Out.getLastException();
		}
		
		if(txf_tWriteJSONField_1_Out.getLastError()!=null) {
			throw txf_tWriteJSONField_1_Out.getLastError();
		}
	
resourceMap.put("finish_tWriteJSONField_1_Out", true);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Flux_Clients_Full");
			  	}
			  	
 

ok_Hash.put("tWriteJSONField_1_Out", true);
end_Hash.put("tWriteJSONField_1_Out", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk", 0, "ok");
				}



/**
 * [tWriteJSONField_1_Out end ] stop
 */












				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputExcel_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tJava_2Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_Flux_Produits"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_Flux_Ventes"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_Regions"); 
				     			
				try{
					
	
	/**
	 * [tFileInputExcel_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tReplicate_3 finally ] start
	 */

	

	
	
	currentComponent="tReplicate_3";

	

 



/**
 * [tReplicate_3 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */




	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tWriteJSONField_1_Out finally ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

		java.util.Queue listGroupby_tWriteJSONField_1_Out = (java.util.Queue)globalMap.get("queue_tWriteJSONField_1_In");
		if(resourceMap.get("finish_tWriteJSONField_1_Out") == null){
			globalMap.put("tWriteJSONField_1_In_FINISH_WITH_EXCEPTION" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
		}
	
	if (listGroupby_tWriteJSONField_1_Out != null) {
		globalMap.put("tWriteJSONField_1_In_FINISH" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
	}
	// workaround for 37349 - in case of normal execution it will pass normally
	// in case it fails and handle by catch - it will wait for child thread finish
	Thread txf_tWriteJSONField_1_Out = (Thread) globalMap.get("wrtXMLFieldIn_tWriteJSONField_1_Out");
	if ( txf_tWriteJSONField_1_Out != null) {
		txf_tWriteJSONField_1_Out.join();
	}

 



/**
 * [tWriteJSONField_1_Out finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


//Creation d'une instance de routine 
ActiveMQVersPulsarRoutine routine = new ActiveMQVersPulsarRoutine();

try {
	routine.consommeFromActiveMQToPulsar(context.UrlConnexionActiveMQ, context.QueueConnexion, context.UserActiveMQ, context.MdpActiveMQ, context.UrlConnexionPulsar, context.TopicPulsar);
} catch (JMSException  | PulsarClientException e) {
	e.printStackTrace();
}
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	


public static class RegionsStruct implements routines.system.IPersistableComparableLookupRow<RegionsStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Regions;

				public String getRegions () {
					return this.Regions;
				}
				
			    public String Villes;

				public String getVilles () {
					return this.Villes;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Villes == null) ? 0 : this.Villes.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final RegionsStruct other = (RegionsStruct) obj;
		
						if (this.Villes == null) {
							if (other.Villes != null)
								return false;
						
						} else if (!this.Villes.equals(other.Villes))
						
							return false;
					

		return true;
    }

	public void copyDataTo(RegionsStruct other) {

		other.Regions = this.Regions;
	            other.Villes = this.Villes;
	            
	}

	public void copyKeysDataTo(RegionsStruct other) {

		other.Villes = this.Villes;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.Villes = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.Villes = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Villes,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Villes,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.Regions = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Regions = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.Regions, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.Regions, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Regions="+Regions);
		sb.append(",Villes="+Villes);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(RegionsStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Villes, other.Villes);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputExcel_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		RegionsStruct Regions = new RegionsStruct();




	
	/**
	 * [tAdvancedHash_Regions begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_Regions", false);
		start_Hash.put("tAdvancedHash_Regions", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_Regions";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Regions");
					}
				
		int tos_count_tAdvancedHash_Regions = 0;
		

			   		// connection name:Regions
			   		// source node:tFileInputExcel_2 - inputs:(after_tFileInputExcel_1) outputs:(Regions,Regions) | target node:tAdvancedHash_Regions - inputs:(Regions) outputs:()
			   		// linked node: tMap_1 - inputs:(Clients,Regions) outputs:(Clients_Full)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Regions = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<RegionsStruct> tHash_Lookup_Regions =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<RegionsStruct>getLookup(matchingModeEnum_Regions);
	   						   
		   	   	   globalMap.put("tHash_Lookup_Regions", tHash_Lookup_Regions);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_Regions begin ] stop
 */



	
	/**
	 * [tFileInputExcel_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_2", false);
		start_Hash.put("tFileInputExcel_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_2";

	
		int tos_count_tFileInputExcel_2 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:YwIrkq43FhK97kPYJ9Rv6J1m2zxwOCqv+tyGyw==");
        String password_tFileInputExcel_2 = decryptedPassword_tFileInputExcel_2;
        if (password_tFileInputExcel_2.isEmpty()){
            password_tFileInputExcel_2 = null;
        }
			class RegexUtil_tFileInputExcel_2 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_2 regexUtil_tFileInputExcel_2 = new RegexUtil_tFileInputExcel_2();

		Object source_tFileInputExcel_2 = context.INPUTS+"/Projet_Ressources/Client_Produit_Regions/Régions.xlsx";
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_2 = null;

		if(source_tFileInputExcel_2 instanceof String){
			workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_2), password_tFileInputExcel_2, true);
		} else if(source_tFileInputExcel_2 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_2, password_tFileInputExcel_2);
		} else{
			workbook_tFileInputExcel_2 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
    	for(org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_2 : workbook_tFileInputExcel_2){
   			sheetList_tFileInputExcel_2.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_2);
    	}
    	if(sheetList_tFileInputExcel_2.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_2 : sheetList_tFileInputExcel_2) {
			if(sheet_FilterNull_tFileInputExcel_2!=null && sheetList_FilterNull_tFileInputExcel_2.iterator()!=null && sheet_FilterNull_tFileInputExcel_2.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_2.add(sheet_FilterNull_tFileInputExcel_2);
			}
		}
		sheetList_tFileInputExcel_2 = sheetList_FilterNull_tFileInputExcel_2;
	if(sheetList_tFileInputExcel_2.size()>0){
		int nb_line_tFileInputExcel_2 = 0;

        int begin_line_tFileInputExcel_2 = 1;

        int footer_input_tFileInputExcel_2 = 0;

        int end_line_tFileInputExcel_2=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2:sheetList_tFileInputExcel_2){
			end_line_tFileInputExcel_2+=(sheet_tFileInputExcel_2.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_2 -= footer_input_tFileInputExcel_2;
        int limit_tFileInputExcel_2 = -1;
        int start_column_tFileInputExcel_2 = 1-1;
        int end_column_tFileInputExcel_2 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_2 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(0);
        int rowCount_tFileInputExcel_2 = 0;
        int sheetIndex_tFileInputExcel_2 = 0;
        int currentRows_tFileInputExcel_2 = (sheetList_tFileInputExcel_2.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_2 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_2 = df_tFileInputExcel_2.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_2 = begin_line_tFileInputExcel_2; i_tFileInputExcel_2 < end_line_tFileInputExcel_2; i_tFileInputExcel_2++){

        	int emptyColumnCount_tFileInputExcel_2 = 0;

        	if (limit_tFileInputExcel_2 != -1 && nb_line_tFileInputExcel_2 >= limit_tFileInputExcel_2) {
        		break;
        	}

            while (i_tFileInputExcel_2 >= rowCount_tFileInputExcel_2 + currentRows_tFileInputExcel_2) {
                rowCount_tFileInputExcel_2 += currentRows_tFileInputExcel_2;
                sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(++sheetIndex_tFileInputExcel_2);
                currentRows_tFileInputExcel_2 = (sheet_tFileInputExcel_2.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_2_CURRENT_SHEET",sheet_tFileInputExcel_2.getSheetName());
            if (rowCount_tFileInputExcel_2 <= i_tFileInputExcel_2) {
                row_tFileInputExcel_2 = sheet_tFileInputExcel_2.getRow(i_tFileInputExcel_2 - rowCount_tFileInputExcel_2);
            }
		    Regions = null;
		    Regions = null;
					int tempRowLength_tFileInputExcel_2 = 2;
				
				int columnIndex_tFileInputExcel_2 = 0;
			
			String[] temp_row_tFileInputExcel_2 = new String[tempRowLength_tFileInputExcel_2];
			int excel_end_column_tFileInputExcel_2;
			if(row_tFileInputExcel_2==null){
				excel_end_column_tFileInputExcel_2=0;
			}else{
				excel_end_column_tFileInputExcel_2=row_tFileInputExcel_2.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_2;
			if(end_column_tFileInputExcel_2 == -1){
				actual_end_column_tFileInputExcel_2 = excel_end_column_tFileInputExcel_2;
			}
			else{
				actual_end_column_tFileInputExcel_2 = end_column_tFileInputExcel_2 >	excel_end_column_tFileInputExcel_2 ? excel_end_column_tFileInputExcel_2 : end_column_tFileInputExcel_2;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_2 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_2;i++){
				if(i + start_column_tFileInputExcel_2 < actual_end_column_tFileInputExcel_2){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_2 = row_tFileInputExcel_2.getCell(i + start_column_tFileInputExcel_2);
					if(cell_tFileInputExcel_2!=null){
					switch (cell_tFileInputExcel_2.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
									temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_2[i] = df_tFileInputExcel_2.format(cell_tFileInputExcel_2.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_2.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
											temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_2 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_2.getNumericCellValue());
										temp_row_tFileInputExcel_2[i] = ne_tFileInputExcel_2.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_2[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_2[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_2[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_2[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_2 = false;
			Regions = new RegionsStruct();
			int curColNum_tFileInputExcel_2 = -1;
			String curColName_tFileInputExcel_2 = "";
			try{
							columnIndex_tFileInputExcel_2 = 0;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Regions";

				Regions.Regions = temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2];
			}else{
				Regions.Regions = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 1;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Villes";

				Regions.Villes = temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2];
			}else{
				Regions.Villes = null;
				emptyColumnCount_tFileInputExcel_2++;
			}

				nb_line_tFileInputExcel_2++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_2_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_2 = true;
					 System.err.println(e.getMessage());
					 Regions = null;
			}


		



 



/**
 * [tFileInputExcel_2 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 


	tos_count_tFileInputExcel_2++;

/**
 * [tFileInputExcel_2 main ] stop
 */
	
	/**
	 * [tFileInputExcel_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_begin ] stop
 */
// Start of branch "Regions"
if(Regions != null) { 



	
	/**
	 * [tAdvancedHash_Regions main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Regions";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Regions"
						
						);
					}
					


			   
			   

					RegionsStruct Regions_HashRow = new RegionsStruct();
		   	   	   
				
				Regions_HashRow.Regions = Regions.Regions;
				
				Regions_HashRow.Villes = Regions.Villes;
				
			tHash_Lookup_Regions.put(Regions_HashRow);
			
            




 


	tos_count_tAdvancedHash_Regions++;

/**
 * [tAdvancedHash_Regions main ] stop
 */
	
	/**
	 * [tAdvancedHash_Regions process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Regions";

	

 



/**
 * [tAdvancedHash_Regions process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_Regions process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Regions";

	

 



/**
 * [tAdvancedHash_Regions process_data_end ] stop
 */

} // End of branch "Regions"




	
	/**
	 * [tFileInputExcel_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_2_NB_LINE",nb_line_tFileInputExcel_2);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_2 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_2.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_2", true);
end_Hash.put("tFileInputExcel_2", System.currentTimeMillis());




/**
 * [tFileInputExcel_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_Regions end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Regions";

	

tHash_Lookup_Regions.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Regions");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_Regions", true);
end_Hash.put("tAdvancedHash_Regions", System.currentTimeMillis());




/**
 * [tAdvancedHash_Regions end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputExcel_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_Regions finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Regions";

	

 



/**
 * [tAdvancedHash_Regions finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 1);
	}
	


public static class ProduitStruct implements routines.system.IPersistableRow<ProduitStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer NumeroProduit;

				public Integer getNumeroProduit () {
					return this.NumeroProduit;
				}
				
			    public String Nom_Produit;

				public String getNom_Produit () {
					return this.Nom_Produit;
				}
				
			    public String Categorie;

				public String getCategorie () {
					return this.Categorie;
				}
				
			    public String SousCategorie;

				public String getSousCategorie () {
					return this.SousCategorie;
				}
				
			    public String Prix_Unitaire;

				public String getPrix_Unitaire () {
					return this.Prix_Unitaire;
				}
				
			    public String Cout_unitaire;

				public String getCout_unitaire () {
					return this.Cout_unitaire;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.NumeroProduit == null) ? 0 : this.NumeroProduit.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ProduitStruct other = (ProduitStruct) obj;
		
						if (this.NumeroProduit == null) {
							if (other.NumeroProduit != null)
								return false;
						
						} else if (!this.NumeroProduit.equals(other.NumeroProduit))
						
							return false;
					

		return true;
    }

	public void copyDataTo(ProduitStruct other) {

		other.NumeroProduit = this.NumeroProduit;
	            other.Nom_Produit = this.Nom_Produit;
	            other.Categorie = this.Categorie;
	            other.SousCategorie = this.SousCategorie;
	            other.Prix_Unitaire = this.Prix_Unitaire;
	            other.Cout_unitaire = this.Cout_unitaire;
	            
	}

	public void copyKeysDataTo(ProduitStruct other) {

		other.NumeroProduit = this.NumeroProduit;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroProduit="+String.valueOf(NumeroProduit));
		sb.append(",Nom_Produit="+Nom_Produit);
		sb.append(",Categorie="+Categorie);
		sb.append(",SousCategorie="+SousCategorie);
		sb.append(",Prix_Unitaire="+Prix_Unitaire);
		sb.append(",Cout_unitaire="+Cout_unitaire);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ProduitStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.NumeroProduit, other.NumeroProduit);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class Flux_ProduitsStruct implements routines.system.IPersistableRow<Flux_ProduitsStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public Integer NumeroProduit;

				public Integer getNumeroProduit () {
					return this.NumeroProduit;
				}
				
			    public String Nom_Produit;

				public String getNom_Produit () {
					return this.Nom_Produit;
				}
				
			    public String Categorie;

				public String getCategorie () {
					return this.Categorie;
				}
				
			    public String SousCategorie;

				public String getSousCategorie () {
					return this.SousCategorie;
				}
				
			    public String Prix_Unitaire;

				public String getPrix_Unitaire () {
					return this.Prix_Unitaire;
				}
				
			    public String Cout_unitaire;

				public String getCout_unitaire () {
					return this.Cout_unitaire;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroProduit="+String.valueOf(NumeroProduit));
		sb.append(",Nom_Produit="+Nom_Produit);
		sb.append(",Categorie="+Categorie);
		sb.append(",SousCategorie="+SousCategorie);
		sb.append(",Prix_Unitaire="+Prix_Unitaire);
		sb.append(",Cout_unitaire="+Cout_unitaire);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Flux_ProduitsStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class ProduitsStruct implements routines.system.IPersistableRow<ProduitsStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer NumeroProduit;

				public Integer getNumeroProduit () {
					return this.NumeroProduit;
				}
				
			    public String Nom_Produit;

				public String getNom_Produit () {
					return this.Nom_Produit;
				}
				
			    public String Categorie;

				public String getCategorie () {
					return this.Categorie;
				}
				
			    public String SousCategorie;

				public String getSousCategorie () {
					return this.SousCategorie;
				}
				
			    public String Prix_Unitaire;

				public String getPrix_Unitaire () {
					return this.Prix_Unitaire;
				}
				
			    public String Cout_unitaire;

				public String getCout_unitaire () {
					return this.Cout_unitaire;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.NumeroProduit == null) ? 0 : this.NumeroProduit.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ProduitsStruct other = (ProduitsStruct) obj;
		
						if (this.NumeroProduit == null) {
							if (other.NumeroProduit != null)
								return false;
						
						} else if (!this.NumeroProduit.equals(other.NumeroProduit))
						
							return false;
					

		return true;
    }

	public void copyDataTo(ProduitsStruct other) {

		other.NumeroProduit = this.NumeroProduit;
	            other.Nom_Produit = this.Nom_Produit;
	            other.Categorie = this.Categorie;
	            other.SousCategorie = this.SousCategorie;
	            other.Prix_Unitaire = this.Prix_Unitaire;
	            other.Cout_unitaire = this.Cout_unitaire;
	            
	}

	public void copyKeysDataTo(ProduitsStruct other) {

		other.NumeroProduit = this.NumeroProduit;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.NumeroProduit = readInteger(dis);
					
					this.Nom_Produit = readString(dis);
					
					this.Categorie = readString(dis);
					
					this.SousCategorie = readString(dis);
					
					this.Prix_Unitaire = readString(dis);
					
					this.Cout_unitaire = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.NumeroProduit,dos);
					
					// String
				
						writeString(this.Nom_Produit,dos);
					
					// String
				
						writeString(this.Categorie,dos);
					
					// String
				
						writeString(this.SousCategorie,dos);
					
					// String
				
						writeString(this.Prix_Unitaire,dos);
					
					// String
				
						writeString(this.Cout_unitaire,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroProduit="+String.valueOf(NumeroProduit));
		sb.append(",Nom_Produit="+Nom_Produit);
		sb.append(",Categorie="+Categorie);
		sb.append(",SousCategorie="+SousCategorie);
		sb.append(",Prix_Unitaire="+Prix_Unitaire);
		sb.append(",Cout_unitaire="+Cout_unitaire);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ProduitsStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.NumeroProduit, other.NumeroProduit);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputExcel_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		ProduitsStruct Produits = new ProduitsStruct();
ProduitStruct Produit = new ProduitStruct();
Flux_ProduitsStruct Flux_Produits = new Flux_ProduitsStruct();





	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Produit");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = ("Produits");
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("Produits");
}

        int updateKeyCount_tDBOutput_2 = 1;
        if(updateKeyCount_tDBOutput_2 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_2 == 6 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

boolean whetherReject_tDBOutput_2 = false;

java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;

	conn_tDBOutput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	



int count_tDBOutput_2=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_2 = conn_tDBOutput_2.getMetaData();
                                boolean whetherExist_tDBOutput_2 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_2 = "public";
                                    if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_2 = conn_tDBOutput_2.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_2 = stmtSchema_tDBOutput_2.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_2.next()){
                                                defaultSchema_tDBOutput_2 = rsSchema_tDBOutput_2.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_2.next()) {
                                        String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
                                        String schema_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_2.equals(("Produits"))
                                            && (schema_tDBOutput_2.equals(dbschema_tDBOutput_2) || ((dbschema_tDBOutput_2 ==null || dbschema_tDBOutput_2.trim().length() ==0) && defaultSchema_tDBOutput_2.equals(schema_tDBOutput_2)))) {
                                            whetherExist_tDBOutput_2 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_2) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
                                        stmtCreate_tDBOutput_2.execute("CREATE TABLE \"" + tableName_tDBOutput_2 + "\"(\"NumeroProduit\" INT2 ,\"Nom_Produit\" VARCHAR(26)  ,\"Categorie\" VARCHAR(26)  ,\"SousCategorie\" VARCHAR(33)  ,\"Prix_Unitaire\" VARCHAR(18)  ,\"Cout_unitaire\" VARCHAR(18)  ,primary key(\"NumeroProduit\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_2 + "\" WHERE \"NumeroProduit\" = ?");
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"NumeroProduit\",\"Nom_Produit\",\"Categorie\",\"SousCategorie\",\"Prix_Unitaire\",\"Cout_unitaire\") VALUES (?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmtInsert_tDBOutput_2", pstmtInsert_tDBOutput_2);
	    String update_tDBOutput_2 = "UPDATE \"" + tableName_tDBOutput_2 + "\" SET \"Nom_Produit\" = ?,\"Categorie\" = ?,\"SousCategorie\" = ?,\"Prix_Unitaire\" = ?,\"Cout_unitaire\" = ? WHERE \"NumeroProduit\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
	    resourceMap.put("pstmtUpdate_tDBOutput_2", pstmtUpdate_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Produits begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_Flux_Produits", false);
		start_Hash.put("tAdvancedHash_Flux_Produits", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_Flux_Produits";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Flux_Produits");
					}
				
		int tos_count_tAdvancedHash_Flux_Produits = 0;
		

			   		// connection name:Flux_Produits
			   		// source node:tReplicate_1 - inputs:(Produits) outputs:(Produit,Flux_Produits,Flux_Produits) | target node:tAdvancedHash_Flux_Produits - inputs:(Flux_Produits) outputs:()
			   		// linked node: tMap_2 - inputs:(Flux_Clients,Flux_Produits,Flux_Ventes) outputs:(Flux_Clients_Full)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Flux_Produits = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_ProduitsStruct> tHash_Lookup_Flux_Produits =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<Flux_ProduitsStruct>getLookup(matchingModeEnum_Flux_Produits);
	   						   
		   	   	   globalMap.put("tHash_Lookup_Flux_Produits", tHash_Lookup_Flux_Produits);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_Flux_Produits begin ] stop
 */



	
	/**
	 * [tReplicate_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tReplicate_1", false);
		start_Hash.put("tReplicate_1", System.currentTimeMillis());
		
	
	currentComponent="tReplicate_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Produits");
					}
				
		int tos_count_tReplicate_1 = 0;
		

 



/**
 * [tReplicate_1 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_3", false);
		start_Hash.put("tFileInputExcel_3", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_3";

	
		int tos_count_tFileInputExcel_3 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:KTQY/DacZUFeeTTNl24yhgF4Kfw007WTPBIJHw==");
        String password_tFileInputExcel_3 = decryptedPassword_tFileInputExcel_3;
        if (password_tFileInputExcel_3.isEmpty()){
            password_tFileInputExcel_3 = null;
        }
			class RegexUtil_tFileInputExcel_3 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_3 regexUtil_tFileInputExcel_3 = new RegexUtil_tFileInputExcel_3();

		Object source_tFileInputExcel_3 = context.INPUTS+"/Projet_Ressources/Client_Produit_Regions/Produits.xlsx";
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_3 = null;

		if(source_tFileInputExcel_3 instanceof String){
			workbook_tFileInputExcel_3 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_3), password_tFileInputExcel_3, true);
		} else if(source_tFileInputExcel_3 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_3 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_3, password_tFileInputExcel_3);
		} else{
			workbook_tFileInputExcel_3 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_3 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
    	for(org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_3 : workbook_tFileInputExcel_3){
   			sheetList_tFileInputExcel_3.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_3);
    	}
    	if(sheetList_tFileInputExcel_3.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_3 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_3 : sheetList_tFileInputExcel_3) {
			if(sheet_FilterNull_tFileInputExcel_3!=null && sheetList_FilterNull_tFileInputExcel_3.iterator()!=null && sheet_FilterNull_tFileInputExcel_3.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_3.add(sheet_FilterNull_tFileInputExcel_3);
			}
		}
		sheetList_tFileInputExcel_3 = sheetList_FilterNull_tFileInputExcel_3;
	if(sheetList_tFileInputExcel_3.size()>0){
		int nb_line_tFileInputExcel_3 = 0;

        int begin_line_tFileInputExcel_3 = 1;

        int footer_input_tFileInputExcel_3 = 0;

        int end_line_tFileInputExcel_3=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_3:sheetList_tFileInputExcel_3){
			end_line_tFileInputExcel_3+=(sheet_tFileInputExcel_3.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_3 -= footer_input_tFileInputExcel_3;
        int limit_tFileInputExcel_3 = -1;
        int start_column_tFileInputExcel_3 = 1-1;
        int end_column_tFileInputExcel_3 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_3 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_3 = sheetList_tFileInputExcel_3.get(0);
        int rowCount_tFileInputExcel_3 = 0;
        int sheetIndex_tFileInputExcel_3 = 0;
        int currentRows_tFileInputExcel_3 = (sheetList_tFileInputExcel_3.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_3 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_3 = df_tFileInputExcel_3.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_3 = begin_line_tFileInputExcel_3; i_tFileInputExcel_3 < end_line_tFileInputExcel_3; i_tFileInputExcel_3++){

        	int emptyColumnCount_tFileInputExcel_3 = 0;

        	if (limit_tFileInputExcel_3 != -1 && nb_line_tFileInputExcel_3 >= limit_tFileInputExcel_3) {
        		break;
        	}

            while (i_tFileInputExcel_3 >= rowCount_tFileInputExcel_3 + currentRows_tFileInputExcel_3) {
                rowCount_tFileInputExcel_3 += currentRows_tFileInputExcel_3;
                sheet_tFileInputExcel_3 = sheetList_tFileInputExcel_3.get(++sheetIndex_tFileInputExcel_3);
                currentRows_tFileInputExcel_3 = (sheet_tFileInputExcel_3.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_3_CURRENT_SHEET",sheet_tFileInputExcel_3.getSheetName());
            if (rowCount_tFileInputExcel_3 <= i_tFileInputExcel_3) {
                row_tFileInputExcel_3 = sheet_tFileInputExcel_3.getRow(i_tFileInputExcel_3 - rowCount_tFileInputExcel_3);
            }
		    Produits = null;
					int tempRowLength_tFileInputExcel_3 = 6;
				
				int columnIndex_tFileInputExcel_3 = 0;
			
			String[] temp_row_tFileInputExcel_3 = new String[tempRowLength_tFileInputExcel_3];
			int excel_end_column_tFileInputExcel_3;
			if(row_tFileInputExcel_3==null){
				excel_end_column_tFileInputExcel_3=0;
			}else{
				excel_end_column_tFileInputExcel_3=row_tFileInputExcel_3.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_3;
			if(end_column_tFileInputExcel_3 == -1){
				actual_end_column_tFileInputExcel_3 = excel_end_column_tFileInputExcel_3;
			}
			else{
				actual_end_column_tFileInputExcel_3 = end_column_tFileInputExcel_3 >	excel_end_column_tFileInputExcel_3 ? excel_end_column_tFileInputExcel_3 : end_column_tFileInputExcel_3;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_3 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_3;i++){
				if(i + start_column_tFileInputExcel_3 < actual_end_column_tFileInputExcel_3){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_3 = row_tFileInputExcel_3.getCell(i + start_column_tFileInputExcel_3);
					if(cell_tFileInputExcel_3!=null){
					switch (cell_tFileInputExcel_3.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_3[i] = cell_tFileInputExcel_3.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_3)) {
									temp_row_tFileInputExcel_3[i] =cell_tFileInputExcel_3.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_3[i] = df_tFileInputExcel_3.format(cell_tFileInputExcel_3.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_3[i] =String.valueOf(cell_tFileInputExcel_3.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_3.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_3[i] = cell_tFileInputExcel_3.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_3)) {
											temp_row_tFileInputExcel_3[i] =cell_tFileInputExcel_3.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_3 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_3.getNumericCellValue());
										temp_row_tFileInputExcel_3[i] = ne_tFileInputExcel_3.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_3[i] =String.valueOf(cell_tFileInputExcel_3.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_3[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_3[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_3[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_3[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_3 = false;
			Produits = new ProduitsStruct();
			int curColNum_tFileInputExcel_3 = -1;
			String curColName_tFileInputExcel_3 = "";
			try{
							columnIndex_tFileInputExcel_3 = 0;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "NumeroProduit";

				Produits.NumeroProduit = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3], null, '.'==decimalChar_tFileInputExcel_3 ? null : decimalChar_tFileInputExcel_3));
			}else{
				Produits.NumeroProduit = null;
				emptyColumnCount_tFileInputExcel_3++;
			}
							columnIndex_tFileInputExcel_3 = 1;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "Nom_Produit";

				Produits.Nom_Produit = temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3];
			}else{
				Produits.Nom_Produit = null;
				emptyColumnCount_tFileInputExcel_3++;
			}
							columnIndex_tFileInputExcel_3 = 2;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "Categorie";

				Produits.Categorie = temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3];
			}else{
				Produits.Categorie = null;
				emptyColumnCount_tFileInputExcel_3++;
			}
							columnIndex_tFileInputExcel_3 = 3;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "SousCategorie";

				Produits.SousCategorie = temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3];
			}else{
				Produits.SousCategorie = null;
				emptyColumnCount_tFileInputExcel_3++;
			}
							columnIndex_tFileInputExcel_3 = 4;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "Prix_Unitaire";

				Produits.Prix_Unitaire = temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3];
			}else{
				Produits.Prix_Unitaire = null;
				emptyColumnCount_tFileInputExcel_3++;
			}
							columnIndex_tFileInputExcel_3 = 5;
						
			if( temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3].length() > 0) {
				curColNum_tFileInputExcel_3=columnIndex_tFileInputExcel_3 + start_column_tFileInputExcel_3 + 1;
				curColName_tFileInputExcel_3 = "Cout_unitaire";

				Produits.Cout_unitaire = temp_row_tFileInputExcel_3[columnIndex_tFileInputExcel_3];
			}else{
				Produits.Cout_unitaire = null;
				emptyColumnCount_tFileInputExcel_3++;
			}

				nb_line_tFileInputExcel_3++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_3_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_3 = true;
					 System.err.println(e.getMessage());
					 Produits = null;
			}


		



 



/**
 * [tFileInputExcel_3 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_3 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_3";

	

 


	tos_count_tFileInputExcel_3++;

/**
 * [tFileInputExcel_3 main ] stop
 */
	
	/**
	 * [tFileInputExcel_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_3";

	

 



/**
 * [tFileInputExcel_3 process_data_begin ] stop
 */
// Start of branch "Produits"
if(Produits != null) { 



	
	/**
	 * [tReplicate_1 main ] start
	 */

	

	
	
	currentComponent="tReplicate_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Produits"
						
						);
					}
					


	Produit = new ProduitStruct();
						
	Produit.NumeroProduit = Produits.NumeroProduit;								
	Produit.Nom_Produit = Produits.Nom_Produit;								
	Produit.Categorie = Produits.Categorie;								
	Produit.SousCategorie = Produits.SousCategorie;								
	Produit.Prix_Unitaire = Produits.Prix_Unitaire;								
	Produit.Cout_unitaire = Produits.Cout_unitaire;			
	Flux_Produits = new Flux_ProduitsStruct();
						
	Flux_Produits.NumeroProduit = Produits.NumeroProduit;								
	Flux_Produits.Nom_Produit = Produits.Nom_Produit;								
	Flux_Produits.Categorie = Produits.Categorie;								
	Flux_Produits.SousCategorie = Produits.SousCategorie;								
	Flux_Produits.Prix_Unitaire = Produits.Prix_Unitaire;								
	Flux_Produits.Cout_unitaire = Produits.Cout_unitaire;			


 


	tos_count_tReplicate_1++;

/**
 * [tReplicate_1 main ] stop
 */
	
	/**
	 * [tReplicate_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tReplicate_1";

	

 



/**
 * [tReplicate_1 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Produit"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(Produit.NumeroProduit == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(1, Produit.NumeroProduit);
}

            int checkCount_tDBOutput_2 = -1;
            try (java.sql.ResultSet rs_tDBOutput_2 = pstmt_tDBOutput_2.executeQuery()) {
                while(rs_tDBOutput_2.next()) {
                    checkCount_tDBOutput_2 = rs_tDBOutput_2.getInt(1);
                }
            }
            if(checkCount_tDBOutput_2 > 0) {
                        if(Produit.Nom_Produit == null) {
pstmtUpdate_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(1, Produit.Nom_Produit);
}

                        if(Produit.Categorie == null) {
pstmtUpdate_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(2, Produit.Categorie);
}

                        if(Produit.SousCategorie == null) {
pstmtUpdate_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(3, Produit.SousCategorie);
}

                        if(Produit.Prix_Unitaire == null) {
pstmtUpdate_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(4, Produit.Prix_Unitaire);
}

                        if(Produit.Cout_unitaire == null) {
pstmtUpdate_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(5, Produit.Cout_unitaire);
}

                        if(Produit.NumeroProduit == null) {
pstmtUpdate_tDBOutput_2.setNull(6 + count_tDBOutput_2, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_2.setInt(6 + count_tDBOutput_2, Produit.NumeroProduit);
}

                try {
					
                    int processedCount_tDBOutput_2 = pstmtUpdate_tDBOutput_2.executeUpdate();
                    updatedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_2 = true;
                        throw(e);
                }
            } else {
                        if(Produit.NumeroProduit == null) {
pstmtInsert_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_2.setInt(1, Produit.NumeroProduit);
}

                        if(Produit.Nom_Produit == null) {
pstmtInsert_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(2, Produit.Nom_Produit);
}

                        if(Produit.Categorie == null) {
pstmtInsert_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(3, Produit.Categorie);
}

                        if(Produit.SousCategorie == null) {
pstmtInsert_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(4, Produit.SousCategorie);
}

                        if(Produit.Prix_Unitaire == null) {
pstmtInsert_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(5, Produit.Prix_Unitaire);
}

                        if(Produit.Cout_unitaire == null) {
pstmtInsert_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(6, Produit.Cout_unitaire);
}

                try {
					
                    int processedCount_tDBOutput_2 = pstmtInsert_tDBOutput_2.executeUpdate();
                    insertedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_2 = true;
                        throw(e);
                }
            }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Produits main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Produits";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Flux_Produits"
						
						);
					}
					


			   
			   

					Flux_ProduitsStruct Flux_Produits_HashRow = new Flux_ProduitsStruct();
		   	   	   
				
				Flux_Produits_HashRow.NumeroProduit = Flux_Produits.NumeroProduit;
				
				Flux_Produits_HashRow.Nom_Produit = Flux_Produits.Nom_Produit;
				
				Flux_Produits_HashRow.Categorie = Flux_Produits.Categorie;
				
				Flux_Produits_HashRow.SousCategorie = Flux_Produits.SousCategorie;
				
				Flux_Produits_HashRow.Prix_Unitaire = Flux_Produits.Prix_Unitaire;
				
				Flux_Produits_HashRow.Cout_unitaire = Flux_Produits.Cout_unitaire;
				
			tHash_Lookup_Flux_Produits.put(Flux_Produits_HashRow);
			
            




 


	tos_count_tAdvancedHash_Flux_Produits++;

/**
 * [tAdvancedHash_Flux_Produits main ] stop
 */
	
	/**
	 * [tAdvancedHash_Flux_Produits process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Produits";

	

 



/**
 * [tAdvancedHash_Flux_Produits process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_Flux_Produits process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Produits";

	

 



/**
 * [tAdvancedHash_Flux_Produits process_data_end ] stop
 */



	
	/**
	 * [tReplicate_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tReplicate_1";

	

 



/**
 * [tReplicate_1 process_data_end ] stop
 */

} // End of branch "Produits"




	
	/**
	 * [tFileInputExcel_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_3";

	

 



/**
 * [tFileInputExcel_3 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_3 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_3";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_3_NB_LINE",nb_line_tFileInputExcel_3);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_3 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_3.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_3", true);
end_Hash.put("tFileInputExcel_3", System.currentTimeMillis());




/**
 * [tFileInputExcel_3 end ] stop
 */

	
	/**
	 * [tReplicate_1 end ] start
	 */

	

	
	
	currentComponent="tReplicate_1";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Produits");
			  	}
			  	
 

ok_Hash.put("tReplicate_1", true);
end_Hash.put("tReplicate_1", System.currentTimeMillis());




/**
 * [tReplicate_1 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



        if(pstmtUpdate_tDBOutput_2 != null){
            pstmtUpdate_tDBOutput_2.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_2");
        }
        if(pstmtInsert_tDBOutput_2 != null){
            pstmtInsert_tDBOutput_2.close();
            resourceMap.remove("pstmtInsert_tDBOutput_2");
        }
        if(pstmt_tDBOutput_2 != null) {
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Produit");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Produits end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Produits";

	

tHash_Lookup_Flux_Produits.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Flux_Produits");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_Flux_Produits", true);
end_Hash.put("tAdvancedHash_Flux_Produits", System.currentTimeMillis());




/**
 * [tAdvancedHash_Flux_Produits end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputExcel_3 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_3";

	

 



/**
 * [tFileInputExcel_3 finally ] stop
 */

	
	/**
	 * [tReplicate_1 finally ] start
	 */

	

	
	
	currentComponent="tReplicate_1";

	

 



/**
 * [tReplicate_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_2 = null;
                if ((pstmtUpdateToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_2")) != null) {
                    pstmtUpdateToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_2 = null;
                if ((pstmtInsertToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_2")) != null) {
                    pstmtInsertToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Produits finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Produits";

	

 



/**
 * [tAdvancedHash_Flux_Produits finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_3_SUBPROCESS_STATE", 1);
	}
	


public static class VenteStruct implements routines.system.IPersistableRow<VenteStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String NumeroCommande;

				public String getNumeroCommande () {
					return this.NumeroCommande;
				}
				
			    public java.util.Date DateCommande;

				public java.util.Date getDateCommande () {
					return this.DateCommande;
				}
				
			    public java.util.Date DateLivraison;

				public java.util.Date getDateLivraison () {
					return this.DateLivraison;
				}
				
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String CanalAquisition;

				public String getCanalAquisition () {
					return this.CanalAquisition;
				}
				
			    public Integer IdentifiantProduit;

				public Integer getIdentifiantProduit () {
					return this.IdentifiantProduit;
				}
				
			    public Integer Qte;

				public Integer getQte () {
					return this.Qte;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.NumeroCommande == null) ? 0 : this.NumeroCommande.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final VenteStruct other = (VenteStruct) obj;
		
						if (this.NumeroCommande == null) {
							if (other.NumeroCommande != null)
								return false;
						
						} else if (!this.NumeroCommande.equals(other.NumeroCommande))
						
							return false;
					

		return true;
    }

	public void copyDataTo(VenteStruct other) {

		other.NumeroCommande = this.NumeroCommande;
	            other.DateCommande = this.DateCommande;
	            other.DateLivraison = this.DateLivraison;
	            other.IdentifiantClient = this.IdentifiantClient;
	            other.CanalAquisition = this.CanalAquisition;
	            other.IdentifiantProduit = this.IdentifiantProduit;
	            other.Qte = this.Qte;
	            
	}

	public void copyKeysDataTo(VenteStruct other) {

		other.NumeroCommande = this.NumeroCommande;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
						this.IdentifiantClient = readInteger(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
						this.IdentifiantClient = readInteger(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroCommande="+NumeroCommande);
		sb.append(",DateCommande="+String.valueOf(DateCommande));
		sb.append(",DateLivraison="+String.valueOf(DateLivraison));
		sb.append(",IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",CanalAquisition="+CanalAquisition);
		sb.append(",IdentifiantProduit="+String.valueOf(IdentifiantProduit));
		sb.append(",Qte="+String.valueOf(Qte));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(VenteStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.NumeroCommande, other.NumeroCommande);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class Flux_VentesStruct implements routines.system.IPersistableComparableLookupRow<Flux_VentesStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String NumeroCommande;

				public String getNumeroCommande () {
					return this.NumeroCommande;
				}
				
			    public java.util.Date DateCommande;

				public java.util.Date getDateCommande () {
					return this.DateCommande;
				}
				
			    public java.util.Date DateLivraison;

				public java.util.Date getDateLivraison () {
					return this.DateLivraison;
				}
				
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String CanalAquisition;

				public String getCanalAquisition () {
					return this.CanalAquisition;
				}
				
			    public Integer IdentifiantProduit;

				public Integer getIdentifiantProduit () {
					return this.IdentifiantProduit;
				}
				
			    public Integer Qte;

				public Integer getQte () {
					return this.Qte;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.IdentifiantClient == null) ? 0 : this.IdentifiantClient.hashCode());
					
						result = prime * result + ((this.IdentifiantProduit == null) ? 0 : this.IdentifiantProduit.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Flux_VentesStruct other = (Flux_VentesStruct) obj;
		
						if (this.IdentifiantClient == null) {
							if (other.IdentifiantClient != null)
								return false;
						
						} else if (!this.IdentifiantClient.equals(other.IdentifiantClient))
						
							return false;
					
						if (this.IdentifiantProduit == null) {
							if (other.IdentifiantProduit != null)
								return false;
						
						} else if (!this.IdentifiantProduit.equals(other.IdentifiantProduit))
						
							return false;
					

		return true;
    }

	public void copyDataTo(Flux_VentesStruct other) {

		other.NumeroCommande = this.NumeroCommande;
	            other.DateCommande = this.DateCommande;
	            other.DateLivraison = this.DateLivraison;
	            other.IdentifiantClient = this.IdentifiantClient;
	            other.CanalAquisition = this.CanalAquisition;
	            other.IdentifiantProduit = this.IdentifiantProduit;
	            other.Qte = this.Qte;
	            
	}

	public void copyKeysDataTo(Flux_VentesStruct other) {

		other.IdentifiantClient = this.IdentifiantClient;
	            	other.IdentifiantProduit = this.IdentifiantProduit;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
						this.IdentifiantClient = readInteger(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.NumeroCommande = readString(dis,ois);
					
						this.DateCommande = readDate(dis,ois);
					
						this.DateLivraison = readDate(dis,ois);
					
						this.CanalAquisition = readString(dis,ois);
					
						this.Qte = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.NumeroCommande = readString(dis,objectIn);
					
						this.DateCommande = readDate(dis,objectIn);
					
						this.DateLivraison = readDate(dis,objectIn);
					
						this.CanalAquisition = readString(dis,objectIn);
					
						this.Qte = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.NumeroCommande, dos, oos);
					
						writeDate(this.DateCommande, dos, oos);
					
						writeDate(this.DateLivraison, dos, oos);
					
						writeString(this.CanalAquisition, dos, oos);
					
					writeInteger(this.Qte, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.NumeroCommande, dos, objectOut);
					
						writeDate(this.DateCommande, dos, objectOut);
					
						writeDate(this.DateLivraison, dos, objectOut);
					
						writeString(this.CanalAquisition, dos, objectOut);
					
					writeInteger(this.Qte, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroCommande="+NumeroCommande);
		sb.append(",DateCommande="+String.valueOf(DateCommande));
		sb.append(",DateLivraison="+String.valueOf(DateLivraison));
		sb.append(",IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",CanalAquisition="+CanalAquisition);
		sb.append(",IdentifiantProduit="+String.valueOf(IdentifiantProduit));
		sb.append(",Qte="+String.valueOf(Qte));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Flux_VentesStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.IdentifiantClient, other.IdentifiantClient);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.IdentifiantProduit, other.IdentifiantProduit);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class ventesStruct implements routines.system.IPersistableRow<ventesStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String NumeroCommande;

				public String getNumeroCommande () {
					return this.NumeroCommande;
				}
				
			    public java.util.Date DateCommande;

				public java.util.Date getDateCommande () {
					return this.DateCommande;
				}
				
			    public java.util.Date DateLivraison;

				public java.util.Date getDateLivraison () {
					return this.DateLivraison;
				}
				
			    public Integer IdentifiantClient;

				public Integer getIdentifiantClient () {
					return this.IdentifiantClient;
				}
				
			    public String CanalAquisition;

				public String getCanalAquisition () {
					return this.CanalAquisition;
				}
				
			    public Integer IdentifiantProduit;

				public Integer getIdentifiantProduit () {
					return this.IdentifiantProduit;
				}
				
			    public Integer Qte;

				public Integer getQte () {
					return this.Qte;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.NumeroCommande == null) ? 0 : this.NumeroCommande.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ventesStruct other = (ventesStruct) obj;
		
						if (this.NumeroCommande == null) {
							if (other.NumeroCommande != null)
								return false;
						
						} else if (!this.NumeroCommande.equals(other.NumeroCommande))
						
							return false;
					

		return true;
    }

	public void copyDataTo(ventesStruct other) {

		other.NumeroCommande = this.NumeroCommande;
	            other.DateCommande = this.DateCommande;
	            other.DateLivraison = this.DateLivraison;
	            other.IdentifiantClient = this.IdentifiantClient;
	            other.CanalAquisition = this.CanalAquisition;
	            other.IdentifiantProduit = this.IdentifiantProduit;
	            other.Qte = this.Qte;
	            
	}

	public void copyKeysDataTo(ventesStruct other) {

		other.NumeroCommande = this.NumeroCommande;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
						this.IdentifiantClient = readInteger(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.NumeroCommande = readString(dis);
					
					this.DateCommande = readDate(dis);
					
					this.DateLivraison = readDate(dis);
					
						this.IdentifiantClient = readInteger(dis);
					
					this.CanalAquisition = readString(dis);
					
						this.IdentifiantProduit = readInteger(dis);
					
						this.Qte = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NumeroCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateCommande,dos);
					
					// java.util.Date
				
						writeDate(this.DateLivraison,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantClient,dos);
					
					// String
				
						writeString(this.CanalAquisition,dos);
					
					// Integer
				
						writeInteger(this.IdentifiantProduit,dos);
					
					// Integer
				
						writeInteger(this.Qte,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NumeroCommande="+NumeroCommande);
		sb.append(",DateCommande="+String.valueOf(DateCommande));
		sb.append(",DateLivraison="+String.valueOf(DateLivraison));
		sb.append(",IdentifiantClient="+String.valueOf(IdentifiantClient));
		sb.append(",CanalAquisition="+CanalAquisition);
		sb.append(",IdentifiantProduit="+String.valueOf(IdentifiantProduit));
		sb.append(",Qte="+String.valueOf(Qte));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ventesStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.NumeroCommande, other.NumeroCommande);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileList_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		ventesStruct ventes = new ventesStruct();
VenteStruct Vente = new VenteStruct();
Flux_VentesStruct Flux_Ventes = new Flux_VentesStruct();



	
	/**
	 * [tFileList_1 begin ] start
	 */

				
			int NB_ITERATE_tForeach_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tFileList_1", false);
		start_Hash.put("tFileList_1", System.currentTimeMillis());
		
	
	currentComponent="tFileList_1";

	
		int tos_count_tFileList_1 = 0;
		
	
 
     
    
  String directory_tFileList_1 = context.INPUTS+"/Projet_Ressources/ventes";
  final java.util.List<String> maskList_tFileList_1 = new java.util.ArrayList<String>();
  final java.util.List<java.util.regex.Pattern> patternList_tFileList_1 = new java.util.ArrayList<java.util.regex.Pattern>(); 
    maskList_tFileList_1.add("*.xlsx");  
  for (final String filemask_tFileList_1 : maskList_tFileList_1) {
	String filemask_compile_tFileList_1 = filemask_tFileList_1;
	
		filemask_compile_tFileList_1 = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_tFileList_1.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);
	
		java.util.regex.Pattern fileNamePattern_tFileList_1 = java.util.regex.Pattern.compile(filemask_compile_tFileList_1);
	patternList_tFileList_1.add(fileNamePattern_tFileList_1);
  }
  int NB_FILEtFileList_1 = 0;

  final boolean case_sensitive_tFileList_1 = true;
	
	
	
    final java.util.List<java.io.File> list_tFileList_1 = new java.util.ArrayList<java.io.File>();
    final java.util.Set<String> filePath_tFileList_1 = new java.util.HashSet<String>();
	java.io.File file_tFileList_1 = new java.io.File(directory_tFileList_1);
     
		file_tFileList_1.listFiles(new java.io.FilenameFilter() {
			public boolean accept(java.io.File dir, String name) {
				java.io.File file = new java.io.File(dir, name);
                if (!file.isDirectory()) {
                	
    	String fileName_tFileList_1 = file.getName();
		for (final java.util.regex.Pattern fileNamePattern_tFileList_1 : patternList_tFileList_1) {
          	if (fileNamePattern_tFileList_1.matcher(fileName_tFileList_1).matches()){
					if(!filePath_tFileList_1.contains(file.getAbsolutePath())) {
			          list_tFileList_1.add(file);
			          filePath_tFileList_1.add(file.getAbsolutePath());
			        }
			}
		}
                }
              return true;
            }
          }
      ); 
      java.util.Collections.sort(list_tFileList_1);
    
    for (int i_tFileList_1 = 0; i_tFileList_1 < list_tFileList_1.size(); i_tFileList_1++){
      java.io.File files_tFileList_1 = list_tFileList_1.get(i_tFileList_1);
      String fileName_tFileList_1 = files_tFileList_1.getName();
      
      String currentFileName_tFileList_1 = files_tFileList_1.getName(); 
      String currentFilePath_tFileList_1 = files_tFileList_1.getAbsolutePath();
      String currentFileDirectory_tFileList_1 = files_tFileList_1.getParent();
      String currentFileExtension_tFileList_1 = null;
      
      if (files_tFileList_1.getName().contains(".") && files_tFileList_1.isFile()){
        currentFileExtension_tFileList_1 = files_tFileList_1.getName().substring(files_tFileList_1.getName().lastIndexOf(".") + 1);
      } else{
        currentFileExtension_tFileList_1 = "";
      }
      
      NB_FILEtFileList_1 ++;
      globalMap.put("tFileList_1_CURRENT_FILE", currentFileName_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEPATH", currentFilePath_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_1);
      globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);
      
 



/**
 * [tFileList_1 begin ] stop
 */
	
	/**
	 * [tFileList_1 main ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 


	tos_count_tFileList_1++;

/**
 * [tFileList_1 main ] stop
 */
	
	/**
	 * [tFileList_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 process_data_begin ] stop
 */
	NB_ITERATE_tForeach_1++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("Json_Complexe", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Clients_Full", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("OnComponentOk", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("ventes", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("iterate2", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Ventes", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Vente", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Ventes", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tForeach_1);
					//Thread.sleep(1000);
				}				
			

	
	/**
	 * [tForeach_1 begin ] start
	 */

				
			int NB_ITERATE_tFileInputExcel_4 = 0; //for statistics
			

	
		
		ok_Hash.put("tForeach_1", false);
		start_Hash.put("tForeach_1", System.currentTimeMillis());
		
	
	currentComponent="tForeach_1";

	
		int tos_count_tForeach_1 = 0;
		


Object[] values_tForeach_1 = new Object[]{
    "*.xlsx",
};

for(Object tmp_tForeach_1 :values_tForeach_1) {
	
    globalMap.put("tForeach_1_CURRENT_VALUE", tmp_tForeach_1);

 



/**
 * [tForeach_1 begin ] stop
 */
	
	/**
	 * [tForeach_1 main ] start
	 */

	

	
	
	currentComponent="tForeach_1";

	

 


	tos_count_tForeach_1++;

/**
 * [tForeach_1 main ] stop
 */
	
	/**
	 * [tForeach_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tForeach_1";

	

 



/**
 * [tForeach_1 process_data_begin ] stop
 */
	NB_ITERATE_tFileInputExcel_4++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("Json_Complexe", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Clients_Full", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("OnComponentOk", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("ventes", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Ventes", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Vente", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("Flux_Ventes", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate2", 1, "exec" + NB_ITERATE_tFileInputExcel_4);
					//Thread.sleep(1000);
				}				
			



	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Vente");
					}
				
		int tos_count_tDBOutput_3 = 0;
		





String dbschema_tDBOutput_3 = null;
	dbschema_tDBOutput_3 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_3 = null;
if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
	tableName_tDBOutput_3 = ("Ventes");
} else {
	tableName_tDBOutput_3 = dbschema_tDBOutput_3 + "\".\"" + ("Ventes");
}

        int updateKeyCount_tDBOutput_3 = 1;
        if(updateKeyCount_tDBOutput_3 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_3 == 7 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

boolean whetherReject_tDBOutput_3 = false;

java.sql.Connection conn_tDBOutput_3 = null;
String dbUser_tDBOutput_3 = null;

	conn_tDBOutput_3 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	



int count_tDBOutput_3=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_3 = conn_tDBOutput_3.getMetaData();
                                boolean whetherExist_tDBOutput_3 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_3 = dbMetaData_tDBOutput_3.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_3 = "public";
                                    if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_3 = conn_tDBOutput_3.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_3 = stmtSchema_tDBOutput_3.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_3.next()){
                                                defaultSchema_tDBOutput_3 = rsSchema_tDBOutput_3.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_3.next()) {
                                        String table_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_NAME");
                                        String schema_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_3.equals(("Ventes"))
                                            && (schema_tDBOutput_3.equals(dbschema_tDBOutput_3) || ((dbschema_tDBOutput_3 ==null || dbschema_tDBOutput_3.trim().length() ==0) && defaultSchema_tDBOutput_3.equals(schema_tDBOutput_3)))) {
                                            whetherExist_tDBOutput_3 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_3) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                                        stmtCreate_tDBOutput_3.execute("CREATE TABLE \"" + tableName_tDBOutput_3 + "\"(\"NumeroCommande\" VARCHAR(13)  ,\"DateCommande\" DATE ,\"DateLivraison\" DATE ,\"IdentifiantClient\" INT4 ,\"CanalAquisition\" VARCHAR(9)  ,\"IdentifiantProduit\" INT4 ,\"Qte\" INT4 ,primary key(\"NumeroCommande\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_3 + "\" WHERE \"NumeroCommande\" = ?");
	    resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);
	    String insert_tDBOutput_3 = "INSERT INTO \"" + tableName_tDBOutput_3 + "\" (\"NumeroCommande\",\"DateCommande\",\"DateLivraison\",\"IdentifiantClient\",\"CanalAquisition\",\"IdentifiantProduit\",\"Qte\") VALUES (?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
	    resourceMap.put("pstmtInsert_tDBOutput_3", pstmtInsert_tDBOutput_3);
	    String update_tDBOutput_3 = "UPDATE \"" + tableName_tDBOutput_3 + "\" SET \"DateCommande\" = ?,\"DateLivraison\" = ?,\"IdentifiantClient\" = ?,\"CanalAquisition\" = ?,\"IdentifiantProduit\" = ?,\"Qte\" = ? WHERE \"NumeroCommande\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(update_tDBOutput_3);
	    resourceMap.put("pstmtUpdate_tDBOutput_3", pstmtUpdate_tDBOutput_3);
	    

 



/**
 * [tDBOutput_3 begin ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Ventes begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_Flux_Ventes", false);
		start_Hash.put("tAdvancedHash_Flux_Ventes", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Flux_Ventes");
					}
				
		int tos_count_tAdvancedHash_Flux_Ventes = 0;
		

			   		// connection name:Flux_Ventes
			   		// source node:tReplicate_2 - inputs:(ventes) outputs:(Vente,Flux_Ventes,Flux_Ventes) | target node:tAdvancedHash_Flux_Ventes - inputs:(Flux_Ventes) outputs:()
			   		// linked node: tMap_2 - inputs:(Flux_Clients,Flux_Produits,Flux_Ventes) outputs:(Flux_Clients_Full)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Flux_Ventes = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Flux_VentesStruct> tHash_Lookup_Flux_Ventes =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<Flux_VentesStruct>getLookup(matchingModeEnum_Flux_Ventes);
	   						   
		   	   	   globalMap.put("tHash_Lookup_Flux_Ventes", tHash_Lookup_Flux_Ventes);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_Flux_Ventes begin ] stop
 */



	
	/**
	 * [tReplicate_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tReplicate_2", false);
		start_Hash.put("tReplicate_2", System.currentTimeMillis());
		
	
	currentComponent="tReplicate_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"ventes");
					}
				
		int tos_count_tReplicate_2 = 0;
		

 



/**
 * [tReplicate_2 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_4", false);
		start_Hash.put("tFileInputExcel_4", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_4";

	
		int tos_count_tFileInputExcel_4 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:L2gEYOCO8BPQO4uR8MgDSRPS08IX4hX1XsSGqA==");
        String password_tFileInputExcel_4 = decryptedPassword_tFileInputExcel_4;
        if (password_tFileInputExcel_4.isEmpty()){
            password_tFileInputExcel_4 = null;
        }
			class RegexUtil_tFileInputExcel_4 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_4 regexUtil_tFileInputExcel_4 = new RegexUtil_tFileInputExcel_4();

		Object source_tFileInputExcel_4 = ((String)globalMap.get("tFileList_1_CURRENT_FILEPATH"));
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_4 = null;

		if(source_tFileInputExcel_4 instanceof String){
			workbook_tFileInputExcel_4 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_4), password_tFileInputExcel_4, true);
		} else if(source_tFileInputExcel_4 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_4 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_4, password_tFileInputExcel_4);
		} else{
			workbook_tFileInputExcel_4 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_4 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
    	for(org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_4 : workbook_tFileInputExcel_4){
   			sheetList_tFileInputExcel_4.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_4);
    	}
    	if(sheetList_tFileInputExcel_4.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_4 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_4 : sheetList_tFileInputExcel_4) {
			if(sheet_FilterNull_tFileInputExcel_4!=null && sheetList_FilterNull_tFileInputExcel_4.iterator()!=null && sheet_FilterNull_tFileInputExcel_4.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_4.add(sheet_FilterNull_tFileInputExcel_4);
			}
		}
		sheetList_tFileInputExcel_4 = sheetList_FilterNull_tFileInputExcel_4;
	if(sheetList_tFileInputExcel_4.size()>0){
		int nb_line_tFileInputExcel_4 = 0;

        int begin_line_tFileInputExcel_4 = 1;

        int footer_input_tFileInputExcel_4 = 0;

        int end_line_tFileInputExcel_4=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_4:sheetList_tFileInputExcel_4){
			end_line_tFileInputExcel_4+=(sheet_tFileInputExcel_4.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_4 -= footer_input_tFileInputExcel_4;
        int limit_tFileInputExcel_4 = -1;
        int start_column_tFileInputExcel_4 = 1-1;
        int end_column_tFileInputExcel_4 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_4 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_4 = sheetList_tFileInputExcel_4.get(0);
        int rowCount_tFileInputExcel_4 = 0;
        int sheetIndex_tFileInputExcel_4 = 0;
        int currentRows_tFileInputExcel_4 = (sheetList_tFileInputExcel_4.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_4 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_4 = df_tFileInputExcel_4.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_4 = begin_line_tFileInputExcel_4; i_tFileInputExcel_4 < end_line_tFileInputExcel_4; i_tFileInputExcel_4++){

        	int emptyColumnCount_tFileInputExcel_4 = 0;

        	if (limit_tFileInputExcel_4 != -1 && nb_line_tFileInputExcel_4 >= limit_tFileInputExcel_4) {
        		break;
        	}

            while (i_tFileInputExcel_4 >= rowCount_tFileInputExcel_4 + currentRows_tFileInputExcel_4) {
                rowCount_tFileInputExcel_4 += currentRows_tFileInputExcel_4;
                sheet_tFileInputExcel_4 = sheetList_tFileInputExcel_4.get(++sheetIndex_tFileInputExcel_4);
                currentRows_tFileInputExcel_4 = (sheet_tFileInputExcel_4.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_4_CURRENT_SHEET",sheet_tFileInputExcel_4.getSheetName());
            if (rowCount_tFileInputExcel_4 <= i_tFileInputExcel_4) {
                row_tFileInputExcel_4 = sheet_tFileInputExcel_4.getRow(i_tFileInputExcel_4 - rowCount_tFileInputExcel_4);
            }
		    ventes = null;
					int tempRowLength_tFileInputExcel_4 = 7;
				
				int columnIndex_tFileInputExcel_4 = 0;
			
			String[] temp_row_tFileInputExcel_4 = new String[tempRowLength_tFileInputExcel_4];
			int excel_end_column_tFileInputExcel_4;
			if(row_tFileInputExcel_4==null){
				excel_end_column_tFileInputExcel_4=0;
			}else{
				excel_end_column_tFileInputExcel_4=row_tFileInputExcel_4.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_4;
			if(end_column_tFileInputExcel_4 == -1){
				actual_end_column_tFileInputExcel_4 = excel_end_column_tFileInputExcel_4;
			}
			else{
				actual_end_column_tFileInputExcel_4 = end_column_tFileInputExcel_4 >	excel_end_column_tFileInputExcel_4 ? excel_end_column_tFileInputExcel_4 : end_column_tFileInputExcel_4;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_4 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_4;i++){
				if(i + start_column_tFileInputExcel_4 < actual_end_column_tFileInputExcel_4){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_4 = row_tFileInputExcel_4.getCell(i + start_column_tFileInputExcel_4);
					if(cell_tFileInputExcel_4!=null){
					switch (cell_tFileInputExcel_4.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_4[i] = cell_tFileInputExcel_4.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_4)) {
									temp_row_tFileInputExcel_4[i] =cell_tFileInputExcel_4.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_4[i] = df_tFileInputExcel_4.format(cell_tFileInputExcel_4.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_4[i] =String.valueOf(cell_tFileInputExcel_4.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_4.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_4[i] = cell_tFileInputExcel_4.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_4)) {
											temp_row_tFileInputExcel_4[i] =cell_tFileInputExcel_4.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_4 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_4.getNumericCellValue());
										temp_row_tFileInputExcel_4[i] = ne_tFileInputExcel_4.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_4[i] =String.valueOf(cell_tFileInputExcel_4.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_4[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_4[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_4[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_4[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_4 = false;
			ventes = new ventesStruct();
			int curColNum_tFileInputExcel_4 = -1;
			String curColName_tFileInputExcel_4 = "";
			try{
							columnIndex_tFileInputExcel_4 = 0;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "NumeroCommande";

				ventes.NumeroCommande = temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4];
			}else{
				ventes.NumeroCommande = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 1;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "DateCommande";

				if(1<actual_end_column_tFileInputExcel_4){
					try{
						if(row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4))){
							ventes.DateCommande = row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4).getDateCellValue();
						}
						else{
                            java.util.Date tempDate_tFileInputExcel_4 = ParserUtils.parseTo_Date(temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4], "dd/MM/yyyy");
                            if(tempDate_tFileInputExcel_4.after((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse("9999/12/31 23:59:59.999"))||tempDate_tFileInputExcel_4.before((new SimpleDateFormat("yyyy/MM/dd")).parse("1900/01/01"))){
                                throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_4+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_4 + " )");
                            }else{
                                ventes.DateCommande = tempDate_tFileInputExcel_4;
                            }
						}
					}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_4_ERROR_MESSAGE",e.getMessage());
						
						throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_4+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_4 + " )");
					}
				}

			}else{
				ventes.DateCommande = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 2;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "DateLivraison";

				if(2<actual_end_column_tFileInputExcel_4){
					try{
						if(row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4))){
							ventes.DateLivraison = row_tFileInputExcel_4.getCell(columnIndex_tFileInputExcel_4+ start_column_tFileInputExcel_4).getDateCellValue();
						}
						else{
                            java.util.Date tempDate_tFileInputExcel_4 = ParserUtils.parseTo_Date(temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4], "dd/MM/yyyy");
                            if(tempDate_tFileInputExcel_4.after((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse("9999/12/31 23:59:59.999"))||tempDate_tFileInputExcel_4.before((new SimpleDateFormat("yyyy/MM/dd")).parse("1900/01/01"))){
                                throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_4+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_4 + " )");
                            }else{
                                ventes.DateLivraison = tempDate_tFileInputExcel_4;
                            }
						}
					}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_4_ERROR_MESSAGE",e.getMessage());
						
						throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_4+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_4 + " )");
					}
				}

			}else{
				ventes.DateLivraison = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 3;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "IdentifiantClient";

				ventes.IdentifiantClient = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4], null, '.'==decimalChar_tFileInputExcel_4 ? null : decimalChar_tFileInputExcel_4));
			}else{
				ventes.IdentifiantClient = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 4;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "CanalAquisition";

				ventes.CanalAquisition = temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4];
			}else{
				ventes.CanalAquisition = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 5;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "IdentifiantProduit";

				ventes.IdentifiantProduit = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4], null, '.'==decimalChar_tFileInputExcel_4 ? null : decimalChar_tFileInputExcel_4));
			}else{
				ventes.IdentifiantProduit = null;
				emptyColumnCount_tFileInputExcel_4++;
			}
							columnIndex_tFileInputExcel_4 = 6;
						
			if( temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4].length() > 0) {
				curColNum_tFileInputExcel_4=columnIndex_tFileInputExcel_4 + start_column_tFileInputExcel_4 + 1;
				curColName_tFileInputExcel_4 = "Qte";

				ventes.Qte = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_4[columnIndex_tFileInputExcel_4], null, '.'==decimalChar_tFileInputExcel_4 ? null : decimalChar_tFileInputExcel_4));
			}else{
				ventes.Qte = null;
				emptyColumnCount_tFileInputExcel_4++;
			}

				nb_line_tFileInputExcel_4++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_4_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_4 = true;
					 System.err.println(e.getMessage());
					 ventes = null;
			}


		



 



/**
 * [tFileInputExcel_4 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_4 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_4";

	

 


	tos_count_tFileInputExcel_4++;

/**
 * [tFileInputExcel_4 main ] stop
 */
	
	/**
	 * [tFileInputExcel_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_4";

	

 



/**
 * [tFileInputExcel_4 process_data_begin ] stop
 */
// Start of branch "ventes"
if(ventes != null) { 



	
	/**
	 * [tReplicate_2 main ] start
	 */

	

	
	
	currentComponent="tReplicate_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"ventes"
						
						);
					}
					


	Vente = new VenteStruct();
						
	Vente.NumeroCommande = ventes.NumeroCommande;								
	Vente.DateCommande = ventes.DateCommande;								
	Vente.DateLivraison = ventes.DateLivraison;								
	Vente.IdentifiantClient = ventes.IdentifiantClient;								
	Vente.CanalAquisition = ventes.CanalAquisition;								
	Vente.IdentifiantProduit = ventes.IdentifiantProduit;								
	Vente.Qte = ventes.Qte;			
	Flux_Ventes = new Flux_VentesStruct();
						
	Flux_Ventes.NumeroCommande = ventes.NumeroCommande;								
	Flux_Ventes.DateCommande = ventes.DateCommande;								
	Flux_Ventes.DateLivraison = ventes.DateLivraison;								
	Flux_Ventes.IdentifiantClient = ventes.IdentifiantClient;								
	Flux_Ventes.CanalAquisition = ventes.CanalAquisition;								
	Flux_Ventes.IdentifiantProduit = ventes.IdentifiantProduit;								
	Flux_Ventes.Qte = ventes.Qte;			


 


	tos_count_tReplicate_2++;

/**
 * [tReplicate_2 main ] stop
 */
	
	/**
	 * [tReplicate_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tReplicate_2";

	

 



/**
 * [tReplicate_2 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Vente"
						
						);
					}
					



        whetherReject_tDBOutput_3 = false;
                    if(Vente.NumeroCommande == null) {
pstmt_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(1, Vente.NumeroCommande);
}

            int checkCount_tDBOutput_3 = -1;
            try (java.sql.ResultSet rs_tDBOutput_3 = pstmt_tDBOutput_3.executeQuery()) {
                while(rs_tDBOutput_3.next()) {
                    checkCount_tDBOutput_3 = rs_tDBOutput_3.getInt(1);
                }
            }
            if(checkCount_tDBOutput_3 > 0) {
                        if(Vente.DateCommande != null) {
pstmtUpdate_tDBOutput_3.setTimestamp(1, new java.sql.Timestamp(Vente.DateCommande.getTime()));
} else {
pstmtUpdate_tDBOutput_3.setNull(1, java.sql.Types.TIMESTAMP);
}

                        if(Vente.DateLivraison != null) {
pstmtUpdate_tDBOutput_3.setTimestamp(2, new java.sql.Timestamp(Vente.DateLivraison.getTime()));
} else {
pstmtUpdate_tDBOutput_3.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(Vente.IdentifiantClient == null) {
pstmtUpdate_tDBOutput_3.setNull(3, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(3, Vente.IdentifiantClient);
}

                        if(Vente.CanalAquisition == null) {
pstmtUpdate_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(4, Vente.CanalAquisition);
}

                        if(Vente.IdentifiantProduit == null) {
pstmtUpdate_tDBOutput_3.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(5, Vente.IdentifiantProduit);
}

                        if(Vente.Qte == null) {
pstmtUpdate_tDBOutput_3.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(6, Vente.Qte);
}

                        if(Vente.NumeroCommande == null) {
pstmtUpdate_tDBOutput_3.setNull(7 + count_tDBOutput_3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(7 + count_tDBOutput_3, Vente.NumeroCommande);
}

                try {
					
                    int processedCount_tDBOutput_3 = pstmtUpdate_tDBOutput_3.executeUpdate();
                    updatedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_3 = true;
                        throw(e);
                }
            } else {
                        if(Vente.NumeroCommande == null) {
pstmtInsert_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(1, Vente.NumeroCommande);
}

                        if(Vente.DateCommande != null) {
pstmtInsert_tDBOutput_3.setTimestamp(2, new java.sql.Timestamp(Vente.DateCommande.getTime()));
} else {
pstmtInsert_tDBOutput_3.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(Vente.DateLivraison != null) {
pstmtInsert_tDBOutput_3.setTimestamp(3, new java.sql.Timestamp(Vente.DateLivraison.getTime()));
} else {
pstmtInsert_tDBOutput_3.setNull(3, java.sql.Types.TIMESTAMP);
}

                        if(Vente.IdentifiantClient == null) {
pstmtInsert_tDBOutput_3.setNull(4, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(4, Vente.IdentifiantClient);
}

                        if(Vente.CanalAquisition == null) {
pstmtInsert_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(5, Vente.CanalAquisition);
}

                        if(Vente.IdentifiantProduit == null) {
pstmtInsert_tDBOutput_3.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(6, Vente.IdentifiantProduit);
}

                        if(Vente.Qte == null) {
pstmtInsert_tDBOutput_3.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(7, Vente.Qte);
}

                try {
					
                    int processedCount_tDBOutput_3 = pstmtInsert_tDBOutput_3.executeUpdate();
                    insertedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_3 = true;
                        throw(e);
                }
            }

 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_end ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Ventes main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Flux_Ventes"
						
						);
					}
					


			   
			   

					Flux_VentesStruct Flux_Ventes_HashRow = new Flux_VentesStruct();
		   	   	   
				
				Flux_Ventes_HashRow.NumeroCommande = Flux_Ventes.NumeroCommande;
				
				Flux_Ventes_HashRow.DateCommande = Flux_Ventes.DateCommande;
				
				Flux_Ventes_HashRow.DateLivraison = Flux_Ventes.DateLivraison;
				
				Flux_Ventes_HashRow.IdentifiantClient = Flux_Ventes.IdentifiantClient;
				
				Flux_Ventes_HashRow.CanalAquisition = Flux_Ventes.CanalAquisition;
				
				Flux_Ventes_HashRow.IdentifiantProduit = Flux_Ventes.IdentifiantProduit;
				
				Flux_Ventes_HashRow.Qte = Flux_Ventes.Qte;
				
			tHash_Lookup_Flux_Ventes.put(Flux_Ventes_HashRow);
			
            




 


	tos_count_tAdvancedHash_Flux_Ventes++;

/**
 * [tAdvancedHash_Flux_Ventes main ] stop
 */
	
	/**
	 * [tAdvancedHash_Flux_Ventes process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	

 



/**
 * [tAdvancedHash_Flux_Ventes process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_Flux_Ventes process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	

 



/**
 * [tAdvancedHash_Flux_Ventes process_data_end ] stop
 */



	
	/**
	 * [tReplicate_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tReplicate_2";

	

 



/**
 * [tReplicate_2 process_data_end ] stop
 */

} // End of branch "ventes"




	
	/**
	 * [tFileInputExcel_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_4";

	

 



/**
 * [tFileInputExcel_4 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_4 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_4";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_4_NB_LINE",nb_line_tFileInputExcel_4);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_4 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_4.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_4", true);
end_Hash.put("tFileInputExcel_4", System.currentTimeMillis());




/**
 * [tFileInputExcel_4 end ] stop
 */

	
	/**
	 * [tReplicate_2 end ] start
	 */

	

	
	
	currentComponent="tReplicate_2";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"ventes");
			  	}
			  	
 

ok_Hash.put("tReplicate_2", true);
end_Hash.put("tReplicate_2", System.currentTimeMillis());




/**
 * [tReplicate_2 end ] stop
 */

	
	/**
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



        if(pstmtUpdate_tDBOutput_3 != null){
            pstmtUpdate_tDBOutput_3.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_3");
        }
        if(pstmtInsert_tDBOutput_3 != null){
            pstmtInsert_tDBOutput_3.close();
            resourceMap.remove("pstmtInsert_tDBOutput_3");
        }
        if(pstmt_tDBOutput_3 != null) {
            pstmt_tDBOutput_3.close();
            resourceMap.remove("pstmt_tDBOutput_3");
        }
    resourceMap.put("statementClosed_tDBOutput_3", true);

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Vente");
			  	}
			  	
 

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());




/**
 * [tDBOutput_3 end ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Ventes end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	

tHash_Lookup_Flux_Ventes.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Flux_Ventes");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_Flux_Ventes", true);
end_Hash.put("tAdvancedHash_Flux_Ventes", System.currentTimeMillis());




/**
 * [tAdvancedHash_Flux_Ventes end ] stop
 */






						if(execStat){
							runStat.updateStatOnConnection("iterate2", 2, "exec" + NB_ITERATE_tFileInputExcel_4);
						}				
					




	
	/**
	 * [tForeach_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tForeach_1";

	

 



/**
 * [tForeach_1 process_data_end ] stop
 */
	
	/**
	 * [tForeach_1 end ] start
	 */

	

	
	
	currentComponent="tForeach_1";

	

}

 

ok_Hash.put("tForeach_1", true);
end_Hash.put("tForeach_1", System.currentTimeMillis());




/**
 * [tForeach_1 end ] stop
 */
						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tForeach_1);
						}				
					




	
	/**
	 * [tFileList_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 process_data_end ] stop
 */
	
	/**
	 * [tFileList_1 end ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

  
    }
  globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);
  

  
 

 

ok_Hash.put("tFileList_1", true);
end_Hash.put("tFileList_1", System.currentTimeMillis());




/**
 * [tFileList_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileList_1 finally ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 finally ] stop
 */

	
	/**
	 * [tForeach_1 finally ] start
	 */

	

	
	
	currentComponent="tForeach_1";

	

 



/**
 * [tForeach_1 finally ] stop
 */

	
	/**
	 * [tFileInputExcel_4 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_4";

	

 



/**
 * [tFileInputExcel_4 finally ] stop
 */

	
	/**
	 * [tReplicate_2 finally ] start
	 */

	

	
	
	currentComponent="tReplicate_2";

	

 



/**
 * [tReplicate_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_3 = null;
                if ((pstmtUpdateToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_3")) != null) {
                    pstmtUpdateToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_3 = null;
                if ((pstmtInsertToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_3")) != null) {
                    pstmtInsertToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
 



/**
 * [tDBOutput_3 finally ] stop
 */




	
	/**
	 * [tAdvancedHash_Flux_Ventes finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_Flux_Ventes";

	

 



/**
 * [tAdvancedHash_Flux_Ventes finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileList_1_SUBPROCESS_STATE", 1);
	}
	

public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tJava_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


String projectName = context.Project_Name + TalendDate.getDate("yyyyMMdd_HHmmss");

globalMap.put("NOM_PROJET", projectName);
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		


	
            String dbProperties_tDBConnection_1 = context.Connexion_PostgresSQL_AdditionalParams;
            String url_tDBConnection_1 = "jdbc:postgresql://"+context.Connexion_PostgresSQL_Server+":"+context.Connexion_PostgresSQL_Port+"/"+context.Connexion_PostgresSQL_Database;
            
            if(dbProperties_tDBConnection_1 != null && !"".equals(dbProperties_tDBConnection_1.trim())) {
                url_tDBConnection_1 = url_tDBConnection_1 + "?" + dbProperties_tDBConnection_1;
            }
	String dbUser_tDBConnection_1 = context.Connexion_PostgresSQL_Login;
	
	
		
	final String decryptedPassword_tDBConnection_1 = context.Connexion_PostgresSQL_Password; 
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
        java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_1 =  java.sql.DriverManager.getDrivers();
        java.util.Set<String> redShiftDriverNames_tDBConnection_1 = new java.util.HashSet<String>(java.util.Arrays
                .asList("com.amazon.redshift.jdbc.Driver","com.amazon.redshift.jdbc41.Driver","com.amazon.redshift.jdbc42.Driver"));
    while (drivers_tDBConnection_1.hasMoreElements()) {
        java.sql.Driver d_tDBConnection_1 = drivers_tDBConnection_1.nextElement();
        if (redShiftDriverNames_tDBConnection_1.contains(d_tDBConnection_1.getClass().getName())) {
            try {
                java.sql.DriverManager.deregisterDriver(d_tDBConnection_1);
                java.sql.DriverManager.registerDriver(d_tDBConnection_1);
            } catch (java.lang.Exception e_tDBConnection_1) {
globalMap.put("tDBConnection_1_ERROR_MESSAGE",e_tDBConnection_1.getMessage());
                    //do nothing
            }
        }
    }
					String driverClass_tDBConnection_1 = "org.postgresql.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("schema_" + "tDBConnection_1",context.Connexion_PostgresSQL_Schema);

 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());




/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";

	
		int tos_count_tDBCommit_1 = 0;
		

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed())
	{
	
		try{
	
			
			conn_tDBCommit_1.commit();
			
	
		}finally{
			
			conn_tDBCommit_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    }
	
	}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tDBClose_1Process(globalMap);



/**
 * [tDBCommit_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_1", false);
		start_Hash.put("tDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_1";

	
		int tos_count_tDBClose_1 = 0;
		

 



/**
 * [tDBClose_1 begin ] stop
 */
	
	/**
	 * [tDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	



	java.sql.Connection conn_tDBClose_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed())
	{
        conn_tDBClose_1.close();
	}

 


	tos_count_tDBClose_1++;

/**
 * [tDBClose_1 main ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 

ok_Hash.put("tDBClose_1", true);
end_Hash.put("tDBClose_1", System.currentTimeMillis());




/**
 * [tDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tLogCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tFileOutputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileOutputDelimited_1", false);
		start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileOutputDelimited_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tFileOutputDelimited_1 = 0;
		

String fileName_tFileOutputDelimited_1 = "";
    fileName_tFileOutputDelimited_1 = (new java.io.File(context.OUTPUTS+"/LOGS/Logs_Erreurs_Exceptions.txt")).getAbsolutePath().replace("\\","/");
    String fullName_tFileOutputDelimited_1 = null;
    String extension_tFileOutputDelimited_1 = null;
    String directory_tFileOutputDelimited_1 = null;
    if((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1.lastIndexOf("/")) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        }
        directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("/"));
    } else {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        }
        directory_tFileOutputDelimited_1 = "";
    }
    boolean isFileGenerated_tFileOutputDelimited_1 = true;
    java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
    globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
        if(filetFileOutputDelimited_1.exists()){
            isFileGenerated_tFileOutputDelimited_1 = false;
        }
            int nb_line_tFileOutputDelimited_1 = 0;
            int splitedFileNo_tFileOutputDelimited_1 = 0;
            int currentRow_tFileOutputDelimited_1 = 0;

            final String OUT_DELIM_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:FIELDSEPARATOR */";"/** End field tFileOutputDelimited_1:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:ROWSEPARATOR */"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_tFileOutputDelimited_1 != null && directory_tFileOutputDelimited_1.trim().length() != 0) {
                        java.io.File dir_tFileOutputDelimited_1 = new java.io.File(directory_tFileOutputDelimited_1);
                        if(!dir_tFileOutputDelimited_1.exists()) {
                            dir_tFileOutputDelimited_1.mkdirs();
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outtFileOutputDelimited_1 = null;

                        outtFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, true),"ISO-8859-15"));


        resourceMap.put("out_tFileOutputDelimited_1", outtFileOutputDelimited_1);
resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

 



/**
 * [tFileOutputDelimited_1 begin ] stop
 */



	
	/**
	 * [tLogCatcher_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogCatcher_1", false);
		start_Hash.put("tLogCatcher_1", System.currentTimeMillis());
		
	
	currentComponent="tLogCatcher_1";

	
		int tos_count_tLogCatcher_1 = 0;
		

try {
	for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_1.getMessages()) {
		row1.type = lcm.getType();
		row1.origin = (lcm.getOrigin()==null || lcm.getOrigin().length()<1 ? null : lcm.getOrigin());
		row1.priority = lcm.getPriority();
		row1.message = lcm.getMessage();
		row1.code = lcm.getCode();
		
		row1.moment = java.util.Calendar.getInstance().getTime();
	
    	row1.pid = pid;
		row1.root_pid = rootPid;
		row1.father_pid = fatherPid;
	
    	row1.project = projectName;
    	row1.job = jobName;
    	row1.context = contextStr;
    		
 



/**
 * [tLogCatcher_1 begin ] stop
 */
	
	/**
	 * [tLogCatcher_1 main ] start
	 */

	

	
	
	currentComponent="tLogCatcher_1";

	

 


	tos_count_tLogCatcher_1++;

/**
 * [tLogCatcher_1 main ] stop
 */
	
	/**
	 * [tLogCatcher_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogCatcher_1";

	

 



/**
 * [tLogCatcher_1 process_data_begin ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					


                    StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
                            if(row1.moment != null) {
                        sb_tFileOutputDelimited_1.append(
                            FormatterUtils.format_Date(row1.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.pid != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.pid
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.root_pid != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.root_pid
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.father_pid != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.father_pid
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.project != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.project
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.job != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.job
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.context != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.context
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.priority != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.priority
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.type != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.type
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.origin != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.origin
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.message != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.message
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(row1.code != null) {
                        sb_tFileOutputDelimited_1.append(
                            row1.code
                        );
                            }
                    sb_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);


                    nb_line_tFileOutputDelimited_1++;
                    resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

                        outtFileOutputDelimited_1.write(sb_tFileOutputDelimited_1.toString());




 


	tos_count_tFileOutputDelimited_1++;

/**
 * [tFileOutputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_end ] stop
 */



	
	/**
	 * [tLogCatcher_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogCatcher_1";

	

 



/**
 * [tLogCatcher_1 process_data_end ] stop
 */
	
	/**
	 * [tLogCatcher_1 end ] start
	 */

	

	
	
	currentComponent="tLogCatcher_1";

	
	}
} catch (Exception e_tLogCatcher_1) {
globalMap.put("tLogCatcher_1_ERROR_MESSAGE",e_tLogCatcher_1.getMessage());
	logIgnoredError(String.format("tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s", e_tLogCatcher_1), e_tLogCatcher_1);
}

 

ok_Hash.put("tLogCatcher_1", true);
end_Hash.put("tLogCatcher_1", System.currentTimeMillis());




/**
 * [tLogCatcher_1 end ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	



		
			
					if(outtFileOutputDelimited_1!=null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}
				
				globalMap.put("tFileOutputDelimited_1_NB_LINE",nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
			
		
		
		resourceMap.put("finish_tFileOutputDelimited_1", true);
	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tFileOutputDelimited_1", true);
end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());




/**
 * [tFileOutputDelimited_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tLogCatcher_1 finally ] start
	 */

	

	
	
	currentComponent="tLogCatcher_1";

	

 



/**
 * [tLogCatcher_1 finally ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	


		if(resourceMap.get("finish_tFileOutputDelimited_1") == null){ 
			
				
						java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer)resourceMap.get("out_tFileOutputDelimited_1");
						if(outtFileOutputDelimited_1!=null) {
							outtFileOutputDelimited_1.flush();
							outtFileOutputDelimited_1.close();
						}
					
				
			
		}
	

 



/**
 * [tFileOutputDelimited_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 1);
	}
	


public static class Json_ComplexeStruct implements routines.system.IPersistableRow<Json_ComplexeStruct> {
    final static byte[] commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];
    static byte[] commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[0];

	
			    public String messageContent;

				public String getMessageContent () {
					return this.messageContent;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length) {
				if(length < 1024 && commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar.length == 0) {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[1024];
				} else {
   					commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length);
			strReturn = new String(commonByteArray_PROJET_TALEND_Migration_Vers_Pulsar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.messageContent = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_TALEND_Migration_Vers_Pulsar) {

        	try {

        		int length = 0;
		
					this.messageContent = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.messageContent,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.messageContent,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("messageContent="+messageContent);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Json_ComplexeStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tWriteJSONField_1_InProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tWriteJSONField_1_In_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		Json_ComplexeStruct Json_Complexe = new Json_ComplexeStruct();




	
	/**
	 * [tJMSOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJMSOutput_1", false);
		start_Hash.put("tJMSOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tJMSOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Json_Complexe");
					}
				
		int tos_count_tJMSOutput_1 = 0;
		

	java.util.Hashtable props_tJMSOutput_1 = new java.util.Hashtable();
	props_tJMSOutput_1.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	props_tJMSOutput_1.put(javax.naming.Context.PROVIDER_URL, "tcp://localhost:61616");
	
	javax.naming.Context context_tJMSOutput_1 = new javax.naming.InitialContext(props_tJMSOutput_1);
	javax.jms.ConnectionFactory factory_tJMSOutput_1 = (javax.jms.ConnectionFactory) context_tJMSOutput_1.lookup("ConnectionFactory");
	
         
	final String decryptedPassword_tJMSOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Ex9nrwxVBzCXHtEs7pvOWGOjPLCgIbCGtaMIPQ==");
	
	javax.jms.Connection connection_tJMSOutput_1 = factory_tJMSOutput_1.createConnection();
	connection_tJMSOutput_1.start();
    resourceMap.put("connection_tJMSOutput_1",connection_tJMSOutput_1);
	javax.jms.Session session_tJMSOutput_1 = connection_tJMSOutput_1.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
    resourceMap.put("session_tJMSOutput_1",session_tJMSOutput_1);
	
	javax.jms.Destination dest_tJMSOutput_1 = session_tJMSOutput_1.createQueue("client");
	

	javax.jms.MessageProducer producer_tJMSOutput_1 = session_tJMSOutput_1.createProducer(dest_tJMSOutput_1);
    resourceMap.put("producer_tJMSOutput_1",producer_tJMSOutput_1);

	producer_tJMSOutput_1.setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);

	int nbline_tJMSOutput_1 = 0;



		

 



/**
 * [tJMSOutput_1 begin ] stop
 */



	
	/**
	 * [tWriteJSONField_1_In begin ] start
	 */

	

	
		
		ok_Hash.put("tWriteJSONField_1_In", false);
		start_Hash.put("tWriteJSONField_1_In", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	
		int tos_count_tWriteJSONField_1_In = 0;
		

				int nb_line_tWriteJSONField_1_In = 0;
				net.sf.json.xml.XMLSerializer xmlSerializer_tWriteJSONField_1_In = new net.sf.json.xml.XMLSerializer(); 
			    xmlSerializer_tWriteJSONField_1_In.clearNamespaces();
			    xmlSerializer_tWriteJSONField_1_In.setSkipNamespaces(true);
			    xmlSerializer_tWriteJSONField_1_In.setForceTopLevelObject(false);
				xmlSerializer_tWriteJSONField_1_In.setUseEmptyStrings(false);
				
					   java.util.Queue<Json_ComplexeStruct> queue_tWriteJSONField_1_In = (java.util.Queue<Json_ComplexeStruct>) globalMap.get("queue_tWriteJSONField_1_In");
					
				String readFinishMarkWithPipeId_tWriteJSONField_1_In = "tWriteJSONField_1_In_FINISH"+(queue_tWriteJSONField_1_In==null?"":queue_tWriteJSONField_1_In.hashCode());
				String str_tWriteJSONField_1_In = null;
				
				while(!globalMap.containsKey(readFinishMarkWithPipeId_tWriteJSONField_1_In) || !queue_tWriteJSONField_1_In.isEmpty()) {
					if (!queue_tWriteJSONField_1_In.isEmpty()) {
			

 



/**
 * [tWriteJSONField_1_In begin ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In main ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

                    Json_ComplexeStruct result_tWriteJSONField_1_In = queue_tWriteJSONField_1_In.poll();
                    str_tWriteJSONField_1_In = result_tWriteJSONField_1_In.messageContent;
        //Convert XML to JSON
        net.sf.json.JsonStandard jsonStandard_tWriteJSONField_1_In =  net.sf.json.JsonStandard.LEGACY  ;
        xmlSerializer_tWriteJSONField_1_In.setJsonStandard(jsonStandard_tWriteJSONField_1_In);
        net.sf.json.JSON json_tWriteJSONField_1_In = xmlSerializer_tWriteJSONField_1_In.read(str_tWriteJSONField_1_In);
        Json_Complexe.messageContent = net.sf.json.util.JSONUtils.jsonToStandardizedString(json_tWriteJSONField_1_In, jsonStandard_tWriteJSONField_1_In);
    
        nb_line_tWriteJSONField_1_In++;

 


	tos_count_tWriteJSONField_1_In++;

/**
 * [tWriteJSONField_1_In main ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In process_data_begin ] stop
 */

	
	/**
	 * [tJMSOutput_1 main ] start
	 */

	

	
	
	currentComponent="tJMSOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Json_Complexe"
						
						);
					}
					

javax.jms.TextMessage message_tJMSOutput_1 = session_tJMSOutput_1.createTextMessage();
message_tJMSOutput_1.setText(Json_Complexe.messageContent);
producer_tJMSOutput_1.send(message_tJMSOutput_1);

nbline_tJMSOutput_1++;


            

 


	tos_count_tJMSOutput_1++;

/**
 * [tJMSOutput_1 main ] stop
 */
	
	/**
	 * [tJMSOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJMSOutput_1";

	

 



/**
 * [tJMSOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tJMSOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJMSOutput_1";

	

 



/**
 * [tJMSOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tWriteJSONField_1_In process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In process_data_end ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

					}
				}
				
					String readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In = "tWriteJSONField_1_In_FINISH_WITH_EXCEPTION"+(queue_tWriteJSONField_1_In==null?"":queue_tWriteJSONField_1_In.hashCode());
					if(globalMap.containsKey(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In)){
						if(!(globalMap instanceof java.util.concurrent.ConcurrentHashMap)) {
							globalMap.put(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In, null);// syn
						}
						globalMap.remove(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In);
						return;
					}
					globalMap.remove("queue_tWriteJSONField_1_In");
    			
				if(!(globalMap instanceof java.util.concurrent.ConcurrentHashMap)) {
					globalMap.put(readFinishMarkWithPipeId_tWriteJSONField_1_In,null);//syn
				}
				globalMap.remove(readFinishMarkWithPipeId_tWriteJSONField_1_In);
			
globalMap.put("tWriteJSONField_1_NB_LINE",nb_line_tWriteJSONField_1_In);
 

ok_Hash.put("tWriteJSONField_1_In", true);
end_Hash.put("tWriteJSONField_1_In", System.currentTimeMillis());




/**
 * [tWriteJSONField_1_In end ] stop
 */

	
	/**
	 * [tJMSOutput_1 end ] start
	 */

	

	
	
	currentComponent="tJMSOutput_1";

	

producer_tJMSOutput_1.close();
resourceMap.remove("producer_tJMSOutput_1");
session_tJMSOutput_1.close();
resourceMap.remove("session_tJMSOutput_1");
connection_tJMSOutput_1.close();
resourceMap.remove("connection_tJMSOutput_1");
globalMap.put("tJMSOutput_1_NB_LINE", nbline_tJMSOutput_1);


            

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Json_Complexe");
			  	}
			  	
 

ok_Hash.put("tJMSOutput_1", true);
end_Hash.put("tJMSOutput_1", System.currentTimeMillis());




/**
 * [tJMSOutput_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tWriteJSONField_1_In finally ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In finally ] stop
 */

	
	/**
	 * [tJMSOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tJMSOutput_1";

	

if(resourceMap.containsKey("producer_tJMSOutput_1")) try {
	((javax.jms.MessageProducer)resourceMap.get("producer_tJMSOutput_1")).close();
} catch (Exception e){
globalMap.put("tJMSOutput_1_ERROR_MESSAGE",e.getMessage());
		
} finally {
    resourceMap.remove("producer_tJMSOutput_1");
}
if(resourceMap.containsKey("session_tJMSOutput_1")) try {
	((javax.jms.Session)resourceMap.get("session_tJMSOutput_1")).close();
} catch (Exception e_tJMSOutput_1){
globalMap.put("tJMSOutput_1_ERROR_MESSAGE",e_tJMSOutput_1.getMessage());
		
} finally {
    resourceMap.remove("session_tJMSOutput_1");
}
if(resourceMap.containsKey("connection_tJMSOutput_1")) try {
	((javax.jms.Connection)resourceMap.get("connection_tJMSOutput_1")).close();
} catch (Exception e_tJMSOutput_1){
globalMap.put("tJMSOutput_1_ERROR_MESSAGE",e_tJMSOutput_1.getMessage());
		
} finally {
	resourceMap.remove("connection_tJMSOutput_1");
}

 



/**
 * [tJMSOutput_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tWriteJSONField_1_In_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Migration_Vers_Pulsar Migration_Vers_PulsarClass = new Migration_Vers_Pulsar();

        int exitCode = Migration_Vers_PulsarClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Migration_Vers_Pulsar.class.getClassLoader().getResourceAsStream("projet_talend/migration_vers_pulsar_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Migration_Vers_Pulsar.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("MdpActiveMQ", "id_String");
                        if(context.getStringValue("MdpActiveMQ") == null) {
                            context.MdpActiveMQ = null;
                        } else {
                            context.MdpActiveMQ=(String) context.getProperty("MdpActiveMQ");
                        }
                        context.setContextType("QueueConnexion", "id_String");
                        if(context.getStringValue("QueueConnexion") == null) {
                            context.QueueConnexion = null;
                        } else {
                            context.QueueConnexion=(String) context.getProperty("QueueConnexion");
                        }
                        context.setContextType("UrlConnexionActiveMQ", "id_String");
                        if(context.getStringValue("UrlConnexionActiveMQ") == null) {
                            context.UrlConnexionActiveMQ = null;
                        } else {
                            context.UrlConnexionActiveMQ=(String) context.getProperty("UrlConnexionActiveMQ");
                        }
                        context.setContextType("UserActiveMQ", "id_String");
                        if(context.getStringValue("UserActiveMQ") == null) {
                            context.UserActiveMQ = null;
                        } else {
                            context.UserActiveMQ=(String) context.getProperty("UserActiveMQ");
                        }
                        context.setContextType("Connexion_PostgresSQL_AdditionalParams", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_AdditionalParams") == null) {
                            context.Connexion_PostgresSQL_AdditionalParams = null;
                        } else {
                            context.Connexion_PostgresSQL_AdditionalParams=(String) context.getProperty("Connexion_PostgresSQL_AdditionalParams");
                        }
                        context.setContextType("Connexion_PostgresSQL_Database", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_Database") == null) {
                            context.Connexion_PostgresSQL_Database = null;
                        } else {
                            context.Connexion_PostgresSQL_Database=(String) context.getProperty("Connexion_PostgresSQL_Database");
                        }
                        context.setContextType("Connexion_PostgresSQL_Login", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_Login") == null) {
                            context.Connexion_PostgresSQL_Login = null;
                        } else {
                            context.Connexion_PostgresSQL_Login=(String) context.getProperty("Connexion_PostgresSQL_Login");
                        }
                        context.setContextType("Connexion_PostgresSQL_Password", "id_Password");
                        if(context.getStringValue("Connexion_PostgresSQL_Password") == null) {
                            context.Connexion_PostgresSQL_Password = null;
                        } else {
                            String pwd_Connexion_PostgresSQL_Password_value = context.getProperty("Connexion_PostgresSQL_Password");
                            context.Connexion_PostgresSQL_Password = null;
                            if(pwd_Connexion_PostgresSQL_Password_value!=null) {
                                if(context_param.containsKey("Connexion_PostgresSQL_Password")) {//no need to decrypt if it come from program argument or parent job runtime
                                    context.Connexion_PostgresSQL_Password = pwd_Connexion_PostgresSQL_Password_value;
                                } else if (!pwd_Connexion_PostgresSQL_Password_value.isEmpty()) {
                                    try {
                                        context.Connexion_PostgresSQL_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_Connexion_PostgresSQL_Password_value);
                                        context.put("Connexion_PostgresSQL_Password",context.Connexion_PostgresSQL_Password);
                                    } catch (java.lang.RuntimeException e) {
                                        //do nothing
                                    }
                                }
                            }
                        }
                        context.setContextType("Connexion_PostgresSQL_Port", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_Port") == null) {
                            context.Connexion_PostgresSQL_Port = null;
                        } else {
                            context.Connexion_PostgresSQL_Port=(String) context.getProperty("Connexion_PostgresSQL_Port");
                        }
                        context.setContextType("Connexion_PostgresSQL_Schema", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_Schema") == null) {
                            context.Connexion_PostgresSQL_Schema = null;
                        } else {
                            context.Connexion_PostgresSQL_Schema=(String) context.getProperty("Connexion_PostgresSQL_Schema");
                        }
                        context.setContextType("Connexion_PostgresSQL_Server", "id_String");
                        if(context.getStringValue("Connexion_PostgresSQL_Server") == null) {
                            context.Connexion_PostgresSQL_Server = null;
                        } else {
                            context.Connexion_PostgresSQL_Server=(String) context.getProperty("Connexion_PostgresSQL_Server");
                        }
                        context.setContextType("INPUTS", "id_Directory");
                        if(context.getStringValue("INPUTS") == null) {
                            context.INPUTS = null;
                        } else {
                            context.INPUTS=(String) context.getProperty("INPUTS");
                        }
                        context.setContextType("Project_Name", "id_String");
                        if(context.getStringValue("Project_Name") == null) {
                            context.Project_Name = null;
                        } else {
                            context.Project_Name=(String) context.getProperty("Project_Name");
                        }
                        context.setContextType("OUTPUTS", "id_Directory");
                        if(context.getStringValue("OUTPUTS") == null) {
                            context.OUTPUTS = null;
                        } else {
                            context.OUTPUTS=(String) context.getProperty("OUTPUTS");
                        }
                        context.setContextType("TopicPulsar", "id_String");
                        if(context.getStringValue("TopicPulsar") == null) {
                            context.TopicPulsar = null;
                        } else {
                            context.TopicPulsar=(String) context.getProperty("TopicPulsar");
                        }
                        context.setContextType("UrlConnexionPulsar", "id_String");
                        if(context.getStringValue("UrlConnexionPulsar") == null) {
                            context.UrlConnexionPulsar = null;
                        } else {
                            context.UrlConnexionPulsar=(String) context.getProperty("UrlConnexionPulsar");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("MdpActiveMQ")) {
                context.MdpActiveMQ = (String) parentContextMap.get("MdpActiveMQ");
            }if (parentContextMap.containsKey("QueueConnexion")) {
                context.QueueConnexion = (String) parentContextMap.get("QueueConnexion");
            }if (parentContextMap.containsKey("UrlConnexionActiveMQ")) {
                context.UrlConnexionActiveMQ = (String) parentContextMap.get("UrlConnexionActiveMQ");
            }if (parentContextMap.containsKey("UserActiveMQ")) {
                context.UserActiveMQ = (String) parentContextMap.get("UserActiveMQ");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_AdditionalParams")) {
                context.Connexion_PostgresSQL_AdditionalParams = (String) parentContextMap.get("Connexion_PostgresSQL_AdditionalParams");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Database")) {
                context.Connexion_PostgresSQL_Database = (String) parentContextMap.get("Connexion_PostgresSQL_Database");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Login")) {
                context.Connexion_PostgresSQL_Login = (String) parentContextMap.get("Connexion_PostgresSQL_Login");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Password")) {
                context.Connexion_PostgresSQL_Password = (java.lang.String) parentContextMap.get("Connexion_PostgresSQL_Password");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Port")) {
                context.Connexion_PostgresSQL_Port = (String) parentContextMap.get("Connexion_PostgresSQL_Port");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Schema")) {
                context.Connexion_PostgresSQL_Schema = (String) parentContextMap.get("Connexion_PostgresSQL_Schema");
            }if (parentContextMap.containsKey("Connexion_PostgresSQL_Server")) {
                context.Connexion_PostgresSQL_Server = (String) parentContextMap.get("Connexion_PostgresSQL_Server");
            }if (parentContextMap.containsKey("INPUTS")) {
                context.INPUTS = (String) parentContextMap.get("INPUTS");
            }if (parentContextMap.containsKey("Project_Name")) {
                context.Project_Name = (String) parentContextMap.get("Project_Name");
            }if (parentContextMap.containsKey("OUTPUTS")) {
                context.OUTPUTS = (String) parentContextMap.get("OUTPUTS");
            }if (parentContextMap.containsKey("TopicPulsar")) {
                context.TopicPulsar = (String) parentContextMap.get("TopicPulsar");
            }if (parentContextMap.containsKey("UrlConnexionPulsar")) {
                context.UrlConnexionPulsar = (String) parentContextMap.get("UrlConnexionPulsar");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("Connexion_PostgresSQL_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileInputExcel_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputExcel_1) {
globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", -1);

e_tFileInputExcel_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Migration_Vers_Pulsar");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     448936 characters generated by Talend Open Studio for Data Integration 
 *     on the 5 juin 2023 à 13:49:34 CEST
 ************************************************************************************************/