import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;


public class DevMain {

	public static void main(String[] args) throws IOException {
		//Path path = FileSystems.getDefault().getPath(".", "save_a_or.bin");
		Path path = FileSystems.getDefault().getPath(".", "SAVE_p_3.BIN");
		byte[] filearray = Files.readAllBytes(path);
		MemoryCard memcard = new MemoryCard(filearray);
		System.out.println(indexList.size());
		//Arrays.copyOfRange(original, from, to)
		splitSaveFile(filearray, indexList);
	}
	public static void splitSaveFile(byte[] filearray, List<Integer> indexList) throws IOException{
		for (int i = 0; i< (indexList.size()-1); i++){
			Path path = Paths.get("slot"+(i+1)+".bin");
			byte[] slot = Arrays.copyOfRange(filearray, indexList.get(i), indexList.get(i+1));
			Files.write(path, slot); //creates, overwrites
		}
		byte[] slot = Arrays.copyOfRange(filearray, indexList.get(indexList.size()-1), filearray.length);
		Path path = Paths.get("slot"+(indexList.size())+".bin");
		Files.write(path, slot); //creates, overwrites
	}

}
