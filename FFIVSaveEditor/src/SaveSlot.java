import java.io.File;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;


public class SaveSlot {
	private byte[] saveSlot = new byte[0];
	private int saveSlotIndex;
	
	
	
	
	public SaveSlot(byte[] saveSlot, int saveSlotIndex) {
		setSaveSlot(saveSlot);
		setSaveSlotIndex(saveSlotIndex);
	}
	public byte[] getSaveSlot() {
		return saveSlot;
	}
	public void setSaveSlot(byte[] saveSlot) {
		
		this.saveSlot = saveSlot;
	}
	public int getSaveSlotIndex() {
		return saveSlotIndex;
	}
	public void setSaveSlotIndex(int saveSlotIndex) {
		this.saveSlotIndex = saveSlotIndex;
	}

}
