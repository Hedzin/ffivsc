import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;


public class Converter {
	
	

	
	
	public static SaveSlot convert(SaveSlot slot) throws DecoderException, IOException{
		FileUtils.writeStringToFile(new File("slot1.txt"), Hex.encodeHexString(slot.getSaveSlot()));
		FileUtils.writeByteArrayToFile(new File("slot1.dat"), slot.getSaveSlot());
		List<Block> blockList = new ArrayList<Block>(); 
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<XMLConfiguration> builder =
		    new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
		    .configure(params.xml()
		        .setFileName("config.xml"));
		try
		{
		    XMLConfiguration config = builder.getConfiguration();
		    //System.out.println(config.getString("DataBlocks.Block.BlockStart"));
		    List<HierarchicalConfiguration<ImmutableNode>> fields =
		    	    config.configurationsAt("DataBlocks.Block");
		    	for(@SuppressWarnings("rawtypes") HierarchicalConfiguration sub : fields)
		    	{
		    	    Block newBlock = new Block();
		    	    newBlock.setStartOffsetHex(sub.getString("BlockStart"));
		    	    newBlock.setLenght(Integer.parseInt(sub.getString("BlockLenght")));
		    	    newBlock.setCheckSummFlag(Boolean.parseBoolean(sub.getString("BlockCheckSumm")));
		    	    newBlock.setDescription(sub.getString("BlockDescription"));
		    	    newBlock.setConvertFlag(Boolean.parseBoolean(sub.getString("BlockShiftFlag")));
		    	    blockList.add(newBlock);
		    	    System.out.println(sub.getString("BlockStart"));
		    	}
		}
		catch(ConfigurationException cex)
		{
		    // loading of the configuration file failed
		}
		//FileUtils.writeByteArrayToFile(new File("slot1before.dat"), slot.getSaveSlot());
		fillBlocks(blockList, slot);
//		int i = 0;
//		for (Block block: blockList){
//			System.out.println(i++);
//			System.out.println(Hex.encodeHexString(block.getData()));
//		}
		//System.out.println(Hex.encodeHexString(slot.getSaveSlot()));
		//System.out.println("...");
		slot.setSaveSlot(slotBuilder(blockList));
		
		//FileUtils.writeByteArrayToFile(new File("slot1sfter.dat"), slot.getSaveSlot());
		return slot;
	}
	
	
	private static void fillBlocks(List<Block> blockList, SaveSlot slot){
		for (Block block: blockList){
			//System.out.println("debug: endoffset"+Integer.toHexString(block.getEndOffset()));
			byte[] data = ArrayUtils.subarray(slot.getSaveSlot(), block.getStartOffset(), block.getEndOffset());
			//System.out.println(data.length);
			block.setData(data);
			if(block.hasCheckSumm()){
				byte[] checkSumm = ArrayUtils.subarray(slot.getSaveSlot(), block.getEndOffset(),block.getEndOffset()+4 );
				block.setCheckSumm(checkSumm);
			}
			
		}
	}
	
	private static byte[] slotBuilder(List<Block> blockList) throws DecoderException{
		byte[] slot = new byte[0];
	
		for (Block block: blockList){
			slot = ArrayUtils.addAll(slot, block.getData());
			if(block.isConvertionNeeded())slot = ArrayUtils.addAll(slot, Hex.decodeHex("00000000".toCharArray()));
			if(block.hasCheckSumm())slot = ArrayUtils.addAll(slot, block.getCheckSumm());
		}
		//System.out.println(slot.length);
		//System.out.println(slot.length);
		//return slot;
		return ArrayUtils.subarray(slot,0,15808);
	}
}
