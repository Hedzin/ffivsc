import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.*;
import org.apache.commons.configuration2.builder.fluent.*;
import org.apache.commons.configuration2.ex.*;
import org.apache.commons.configuration2.tree.*;
import org.apache.commons.io.FileUtils;


public class DevMain {

	public static void main(String[] args) throws IOException, DecoderException {
		//Path path = FileSystems.getDefault().getPath(".", "save_a_or.bin");
		Path path = FileSystems.getDefault().getPath(".", "save_a_or.bin");
		Path path2 = FileSystems.getDefault().getPath(".", "SAVE_p_3.BIN");
		byte[] filearray = Files.readAllBytes(path);
		byte[] filearray2 = Files.readAllBytes(path2);
		MemoryCard memcard = new MemoryCard(filearray);
		MemoryCard memcard2 = new MemoryCard(filearray2);
		//SaveSlot slot1 = memcard.getSaveSlot(0);
		//SaveSlot slot1c = Converter.convert(slot1);
		//MemoryCard newMemcard =  new MemoryCard();
		//MemoryCard newMemcard = memcard;
		///memcard2.setSaveSlot(slot1c, 0);
		FileUtils.writeByteArrayToFile(new File("s1.BIN"), memcard2.getSaveSlot(0).getSaveSlot());
		FileUtils.writeByteArrayToFile(new File("s2.BIN"), memcard2.getSaveSlot(1).getSaveSlot());
		FileUtils.writeByteArrayToFile(new File("s3.BIN"), memcard2.getSaveSlot(2).getSaveSlot());
		FileUtils.writeByteArrayToFile(new File("s4.BIN"), memcard2.getSaveSlot(3).getSaveSlot());
		
	}

}
