
public class Block {
	String startOffsetHex = null;
	Integer startOffset = null;
	
	Integer lenght = null;

	String endOffsetHex = null;
	Integer endOffset = null;

	Boolean checkSummFlag = null;
	Boolean convertFlag = null;
	
	byte[] data = null;
	byte[] checkSumm = null;
	
	
	String description =  null;
	
	
	public String getStartOffsetHex() {
		return startOffsetHex;
	}


	public void setStartOffsetHex(String startOffsetHex) {
		this.startOffsetHex = startOffsetHex;
		this.startOffset = Integer.parseInt(startOffsetHex, 16);
	}


	public Integer getStartOffset() {
		return startOffset;
	}


	public void setStartOffset(Integer startOffset) {
		this.startOffset = startOffset;
	}


	public Integer getLenght() {
		return lenght;
	}


	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}


	public String getEndOffsetHex() {
		return endOffsetHex;
	}


	public void setEndOffsetHex(String endOffsetHex) {
		this.endOffsetHex = endOffsetHex;
	}


	public Integer getEndOffset() {
		if(endOffset==null) return startOffset+lenght;
		else return endOffset;
	}


	public void setEndOffset(Integer endOffset) {
		this.endOffset = endOffset;
	}


	public Boolean hasCheckSumm() {
		return checkSummFlag;
	}


	public void setCheckSummFlag(Boolean checkSummFlag) {
		this.checkSummFlag = checkSummFlag;
	}


	public Boolean isConvertionNeeded() {
		return convertFlag;
	}


	public void setConvertFlag(Boolean convertFlag) {
		this.convertFlag = convertFlag;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}


	public byte[] getCheckSumm() {
		return checkSumm;
	}


	public void setCheckSumm(byte[] checkSumm) {
		this.checkSumm = checkSumm;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	

}
