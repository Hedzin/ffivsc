import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;


public class MemoryCard {
	private byte[] memcard;
	List<Integer> indexList =  new ArrayList<Integer>();
	List<SaveSlot> saveSlotList = new ArrayList<SaveSlot>();
	
	public MemoryCard(byte[] memcard) {
		setMemCard(memcard);
		System.out.println("debug: filesize: "+memcard.length+" bytes");
		splitMemCard();
	}
	
	private void splitMemCard(){
		byte[] pattern = ByteUtils.hexStringToByteArray("63643130303000424142696c");
		indexList = ByteUtils.getListOfIndexes(memcard, pattern);
		for (int i = 0;i<4;i++){
			saveSlotList.add(new SaveSlot(ArrayUtils.subarray(memcard, indexList.get(i), indexList.get(i+1)), i));
		}
		saveSlotList.add( new SaveSlot(ArrayUtils.subarray(memcard, indexList.get(4), memcard.length), 4));
	}

	public MemoryCard() {
		// TODO Auto-generated constructor stub
	}

	public byte[] getMemCard() {
		return buildMemCard();
	}

	public void setMemCard(byte[] memcard) {
		this.memcard = memcard;
	}
	public SaveSlot getSaveSlot(int saveSlotIndex) {
		if (saveSlotIndex>=0 && saveSlotIndex<=5)return saveSlotList.get(saveSlotIndex);
		else return null;
	}
	
	public void setSaveSlot(SaveSlot saveslot, int index){
		saveSlotList.set(index, saveslot);
	}
	
	private byte[] buildMemCard(){
		byte[] mc = new byte[0];
		for (SaveSlot ss: saveSlotList){
			mc = ArrayUtils.addAll(mc, ss.getSaveSlot());
		}
		return mc;
	}

}
