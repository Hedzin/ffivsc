import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.*;
import org.apache.commons.configuration2.builder.fluent.*;
import org.apache.commons.configuration2.ex.*;
import org.apache.commons.configuration2.tree.*;
import org.apache.commons.io.EndianUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.css.CSSStyleDeclaration;


public class CopyOfDevMain {

	public static void main(String[] args) throws IOException, DecoderException {
		//Path path = FileSystems.getDefault().getPath(".", "save_a_or.bin");
		Path path = FileSystems.getDefault().getPath(".", "SAVE_p_3.bin");
		byte[] filearray = Files.readAllBytes(path);
		MemoryCard memcard = new MemoryCard(filearray);
		SaveSlot slot1 = memcard.getSaveSlot(0);
		List<byte[]> byteList = new ArrayList<byte[]>();
		byte[] slot = slot1.getSaveSlot();
		byte[] cs = ArrayUtils.subarray(slot, Integer.parseInt("1C", 16), Integer.parseInt("20", 16));
		
		System.out.println("checksummswapped: "+EndianUtils.readSwappedUnsignedInteger(cs, 0));
		System.out.println("checksummswapped: "+Long.toHexString(EndianUtils.readSwappedUnsignedInteger(cs, 0)));
		System.out.println("checksumms: "+ Hex.encodeHexString(cs));
		byte[] csData = ArrayUtils.subarray(slot, Integer.parseInt("24", 16), slot.length);
		System.out.println(cs.length);
		System.out.println(csData.length +" "+ 3944*4);
		int i = 0;
		int ccs = 0;
		while(i<csData.length){
			ccs = ccs + (int)EndianUtils.readSwappedUnsignedInteger(csData, i);
			i= i+4;
		}
		//EndianUtils.readSwappedInteger(data, offset)
	
			System.out.println("calculated: "+ccs+" : "+Integer.toHexString(ccs));
			System.out.println("calculatedswapped: "+EndianUtils.swapInteger(ccs)+" : "+Integer.toHexString(EndianUtils.swapInteger(ccs)));


		FileUtils.writeByteArrayToFile(new File("SAVE.BIN"), memcard.getMemCard());
		
	}

}
