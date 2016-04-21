package com.mobile.base;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class AppiumStartandStop {

	public void startServer()
	{
		CommandLine command = new CommandLine("C:\\Program Files (x86)\\Appium\\node");
		command.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js",false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer()
	{
//		String[] command = { "/Taskkill /IM node.exe /F" };
		try {
			Runtime.getRuntime().exec("Taskkill /IM node.exe /F");
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String args[])
//	{
//		AppiumStartandStop obj=new AppiumStartandStop();
//		obj.startServer();
//		obj.stopServer();
//	}
	
 
	
}
