## dbLoader plugin per PhoneGap ##
#### Creato da Nacios Technologies <a href="https://twitter.com/NaciosTechnolog" target="_blank">@NaciosTechnolog</a> - <a href="https://www.facebook.com/NaciosTechnologies" target="_blank">Facebook</a> - <a href="www.nacios.it" target="_blank">www.nacios.it</a> - <a href="mailto:info@nacios.it">info@nacios.it</a> ####
=============================================================================================================================

### Plug-in PhoneGap che realizza il caricamento di un database SQLite su sistema Android ###

Per maggiori informazioni consultare il seguente link: http://www.nacios.it/phonegap-dbloader-per-android/

## Installare il plugin nel proprio proprio progetto ##

1) Per installare il plugin, copiare il file dbLoader.js all'interno della cartella /assets/www/ e includere il riferimento all'interno dei files html.

`<script type="text/javascript" charset="utf-8" src="dbLoader.js"></script>`

2) All'interno della cartela src creare il package 'it.nacios.app.dbloader' e successivamente copiarvi il file DBLoader.java

`mkdir <your_project>/src/it/nacios/app/dbloader`

`cp <your_path>/DBLoader.java <your_project>/src/it/nacios/app/dbloader`

3) Nel file res/xml/config.xml aggiungere la seguente linea di codice:

`<plugin name="dbLoader" value="it.nacios.app.dbloader.DBLoader"/>`
 
4) Settare i permessi nel file AndroidManifest.xml aggiungendo la seguente linea di codice qualora non fosse già presente:

`<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>`
 

## Uso del plugin ##
 
1) Creare il riferimento al plugin richiamando il comando cordova.exec():
 
 `var dbl = cordova.require("cordova/plugin/dbLoader");`
 
2) Rchiedere il caricamento di un database attraverso il metodo loadBD('nome del file',success,error):
 
 `dbl.loadDB('database.db',success,error);`

3) <strong>success</strong> ed <strong>error</strong> sono due funzioni di callback che vengono azionate in caso di successo o insuccesso dell'operazione di caricamento del database all'interno del sistema.
