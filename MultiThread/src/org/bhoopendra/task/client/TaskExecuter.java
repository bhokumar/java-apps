package org.bhoopendra.task.client;

import org.axway.task.DataCopy;
import org.axway.task.Editor;
import org.axway.task.Music;

public class TaskExecuter {
	public static void main(String[] args){
		DataCopy dataCopy = new DataCopy("Copying data");
		Editor editor = new Editor("editor");
		Music music = new Music("music");
		dataCopy.start();
		editor.start();
		music.start();
	}

}
