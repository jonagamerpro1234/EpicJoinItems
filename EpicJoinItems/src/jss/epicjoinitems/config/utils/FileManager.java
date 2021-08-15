package jss.epicjoinitems.config.utils;

import java.io.File;
import java.io.InputStream;

import jss.epicjoinitems.EpicJoinItems;
import jss.epicjoinitems.utils.Logger;
import jss.epicjoinitems.utils.Logger.Level;

public class FileManager {

	private EpicJoinItems plugin;
	private Logger logger = new Logger(plugin);

	public FileManager(EpicJoinItems plugin) {
		this.plugin = plugin;
	}
	
    public void createVoidFolder(String name) {
        File folder = new File(getDataFolder(), name);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
            	logger.Log(Level.ERROR, "!!Error Load Folder!!");
                logger.Log(Level.ERROR, e.getStackTrace());
            }
        }
    }

    public void createFolderAndFile(String namefolder, String namefile) {
        File folder = new File(getDataFolder(), namefolder);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
            	logger.Log(Level.ERROR, "!!Error Load Folder!!");
                logger.Log(Level.ERROR, e.getStackTrace());
            }
        }

        File file = new File(folder, namefile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
	
    public void saveResources(String filename, boolean replace) {
        plugin.saveResource(filename, replace);
    }

    public InputStream getResources(String filename) {
        return plugin.getResource(filename);
    }

    public File getDataFolder() {
        return plugin.getDataFolder();
    }
	
}
