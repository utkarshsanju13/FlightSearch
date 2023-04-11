package service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Watch the given path whether there is any update(create, delete or modify any file)
 * @author utkarshgupta01
 *
 */
public class FolderWatcherService implements Runnable {
	
	public void run() {
		try {
			
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path path = Paths.get("Resources\\");
			
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey key;
			while ((key = watchService.take()) != null) {
					
				for (WatchEvent<?> event : key.pollEvents()) {
					System.out.println("Event Type : " + event.kind() + ", File affaceted: " + event.context());
				}
			}
				
		} catch (Exception e) {	
			e.printStackTrace();
		} 
	}
}


