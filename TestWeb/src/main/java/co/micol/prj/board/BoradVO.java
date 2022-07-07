package co.micol.prj.board;

public class BoradVO {
	private String id;
	private String tilte;
	private String content;
	private String writer;
	private String rdt;
	private String hit;
	
	public BoradVO() {
		super();
	}
	public BoradVO(String id, String tilte, String content, String writer, String rdt, String hit) {
		super();
		this.id = id;
		this.tilte = tilte;
		this.content = content;
		this.writer = writer;
		this.rdt = rdt;
		this.hit = hit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTilte() {
		return tilte;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRdt() {
		return rdt;
	}
	public void setRdt(String rdt) {
		this.rdt = rdt;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
}
