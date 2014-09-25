package powered.by.sergey.binarystorage;

public class FileInfo {
	String fileName;
	String contentType;
	long size;
	public String getFileName() {
		return fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public long getSize() {
		return size;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
