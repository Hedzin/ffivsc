import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MemoryCard {
	private byte[] memcard;
	List<Integer> indexList =  new ArrayList<Integer>();
	
	public MemoryCard(byte[] memcard) {
		setMemCard(memcard);
		System.out.println("debug: filesize: "+memcard.length+" bytes");
		byte[] pattern = ByteUtils.hexStringToByteArray("63643130303000424142696c");
		indexList = ByteUtils.getListOfIndexes(memcard, pattern);
	}

	public byte[] getMemCard() {
		return memcard;
	}

	public void setMemCard(byte[] memcard) {
		this.memcard = memcard;
	}
	public SaveSlot getSaveSlot(int saveSlotIndex) {
		if (saveSlotIndex==5){
			return new SaveSlot(Arrays.copyOfRange(memcard, indexList.get(4), memcard.length), 5);
		}
		if (0>saveSlotIndex && saveSlotIndex<5){
			return new SaveSlot(Arrays.copyOfRange(memcard, indexList.get(saveSlotIndex-1), indexList.get(saveSlotIndex)), saveSlotIndex);
		}
		return null;
	}

}
