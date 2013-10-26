/*******************************************************************************
* Copyright (c) 2012, 2013 Nacios Technologies.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Apache License Version 2.0
* which accompanies this distribution, and is available at
* http://www.apache.org/licenses/
*
* Contributors:
* Nacios Technologies - initial API and implementation
* Mauro Brasiliano - Nicola Del Gobbo - Vincenzo Villani
*******************************************************************************/

package it.nacios.app.dbloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;




public class DBLoader extends CordovaPlugin {

	private static final String DATA_FOLDER = "/data/data/it.nacios.app/app_database/";
	
	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) throws JSONException {
		if(action.equals("loadDB")){ 
			this.loadDB(args.getString(0),callbackContext);
			return true;
		}
		return false;
	}
	
	private void loadDB(String dbFileName,CallbackContext callbackContext){
		InputStream in = null;
		OutputStream out = null;
		if(dbFileName != null && dbFileName.length()>0){
			try {
				in = this.webView.getContext().getAssets().open(dbFileName);
				File file = new File(DATA_FOLDER+dbFileName);
				if(file.exists() && file.isFile()){
					file.delete();
					file.createNewFile();
					out = new FileOutputStream(file);
					byte[] buffer = new byte[4096];
					int bytesRead;
					while ((bytesRead = in.read(buffer)) != -1)
						out.write(buffer, 0, bytesRead);
					in.close();
					out.close();
					callbackContext.success();
				}
					
			} catch (IOException e) {
				callbackContext.error("Error: "+e.getMessage());
			}
		}
		else{
			callbackContext.error("Error: dbFileName not defined");
		}			
	}
}
