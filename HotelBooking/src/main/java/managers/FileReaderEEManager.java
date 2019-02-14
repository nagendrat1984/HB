package managers;

import dataProviders.EEConfigFileReader;

//create  a singleton class
public class FileReaderEEManager {

	private static FileReaderEEManager fileReaderEEManager = new FileReaderEEManager();
	private static EEConfigFileReader eeconfigFileReader;

	private FileReaderEEManager() {
	}

	public static FileReaderEEManager getInstance( ) {
		return fileReaderEEManager;
	}

	public EEConfigFileReader getEEConfigReader() {
		return (eeconfigFileReader == null) ? new EEConfigFileReader() : eeconfigFileReader;
	}
}