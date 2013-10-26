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

cordova.define("cordova/plugin/dbLoader", function(require, exports, module) {
	var exec = require("cordova/exec");
	var DBLoader = function () {};
	
	DBLoader.prototype.loadDB = function(dbFileName,success,fail) {
	    cordova.exec(success,fail,"dbLoader","loadDB",[dbFileName]);    
	};
	
	var loaderDB = new DBLoader();
	module.exports = loaderDB;
});

if (!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.dbLoader) {
    window.plugins.dbLoader = cordova.require("cordova/plugin/dbLoader");
}
