## dbLoader plugin per PhoneGap ##
#### Creato da Nacios Technologies <a href="https://twitter.com/NaciosTechnolog" target="_blank">@NaciosTechnolog</a> - <a href="https://www.facebook.com/NaciosTechnologies" target="_blank">Facebook</a> - <a href="www.nacios.it" target="_blank">www.nacios.it</a> - <a href="mailto:info@nacios.it">info@nacios.it</a> ####
=============================================================================================================================

### Plug-in PhoneGap che realizza il caricamento di un database SQLite su sistema Android ###

Per maggiori informazioni consultare il seguente link: http://www.nacios.it/phonegap-dbloader-per-android/

## Installare il plugin nel proprio proprio progetto ##

1) Il file contenente il database SQLite deve trovarsi all'interno della cartella assets del progetto Android.


2) Per installare il plugin, copiare il file dbLoader.js all'interno della cartella /assets/www/ e includere il riferimento all'interno dei files html.

`<script type="text/javascript" charset="utf-8" src="dbLoader.js"></script>`

3) All'interno della cartela src creare il package 'it.nacios.app.dbloader' e successivamente copiarvi il file DBLoader.java

`mkdir <your_project>/src/it/nacios/app/dbloader`

`cp <your_path>/DBLoader.java <your_project>/src/it/nacios/app/dbloader`

4) Aprire il file DBLoader.java e cambiare il valore di <strong>DATA_FOLDER</strong> a secondo delle proprie necessità. <strong>DATA_FOLDER</strong>  rappresenta il path dove verrà salvato il database una volta caricato.


5) Nel file res/xml/config.xml aggiungere la seguente linea di codice:

`<plugin name="dbLoader" value="it.nacios.app.dbloader.DBLoader"/>`
 
6) Settare i permessi nel file AndroidManifest.xml aggiungendo la seguente linea di codice qualora non fosse già presente:

`<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>`
 

## Uso del plugin ##

Attenzione prima di caricare il database bisogna crearne uno con lo stesso nome impiegando le API messe a disposizione da PhoneGap di cui riporto il link:

<a href="http://docs.phonegap.com/en/2.7.0/cordova_storage_storage.md.html#Storage" target="_blank">PhoneGap Storage 2.7.0</a>

<a href="http://docs.phonegap.com/en/2.3.0/cordova_storage_storage.md.html#Storage" target="_blank">PhoneGap Storage 2.3.0</a>
 
1) Creare il riferimento al plugin richiamando il comando cordova.exec():
 
 `var dbl = cordova.require("cordova/plugin/dbLoader");`
 
2) Rchiedere il caricamento di un database attraverso il metodo loadBD('nome del file',success,error):
 
 `dbl.loadDB('database.db',success,error);`

3) <strong>success</strong> ed <strong>error</strong> sono due funzioni di callback che vengono azionate in caso di successo o insuccesso dell'operazione di caricamento del database all'interno del sistema.

`var success = function(){
    console.log('Database loaded');
}`

`var error = function(e){
    console.log('Errore:'+ e);
}`

## LICENZA ##

Apache License
Version 2.0, January 2004
http://www.apache.org/licenses/
