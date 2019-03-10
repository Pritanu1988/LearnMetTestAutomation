package TriggerScripts;

import java.io.IOException;

import ApplicationController.ApplicationHandlerandController;

public class ScriptTrigger 
{
	 public static void main(String args[]) throws IOException, InterruptedException
	 {
		 ApplicationHandlerandController gm = new ApplicationHandlerandController();
		 gm.teststepEval();
	 }
}
