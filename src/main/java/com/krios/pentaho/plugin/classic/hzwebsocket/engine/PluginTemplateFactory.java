package com.krios.pentaho.plugin.classic.hzwebsocket.engine;

/**
 * 
 * @author Kleyson Rios<br>
 *
 */

import javax.sql.DataSource;

import org.pentaho.platform.api.data.IDBDatasourceService;
import org.pentaho.platform.engine.core.system.PentahoSystem;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class PluginTemplateFactory implements BeanFactoryPostProcessor {

	//private DataSource jndiDatabaseConn = null; 

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException 
	{
		
		initPluginProperties();
		//initDatabaseConn();

	}
	
	private void initPluginProperties() 
	{
		PluginConfig.getInstance().init();	
	}

	/*
	private void initDatabaseConn() 
	{
		String jndiName = PluginConfig.props.getProperty("DatabaseJndiName");
				
		if (getJndiDatabaseConn() != null) 
		{ 
			return; 
		}
		
		try 
		{
			IDBDatasourceService datasourceService = PentahoSystem.getObjectFactory().get(IDBDatasourceService.class, null);
			setJndiDatabaseConn( datasourceService.getDataSource(jndiName) );
		} 
		catch (Exception e) 
		{
			System.out.println("Integrator Error: Couldn't load jndi database datasource.");
			e.printStackTrace();
		}
		
	}

	public DataSource getJndiDatabaseConn() {
		return jndiDatabaseConn;
	}

	public void setJndiDatabaseConn(DataSource jndiDatabaseConn) {
		this.jndiDatabaseConn = jndiDatabaseConn;
	}*/

}