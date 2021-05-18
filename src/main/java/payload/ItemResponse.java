package payload;

public class ItemResponse {
	private String id;
	private String name;
	private String category;
	private String description;
	private String releaseDate;
	private String userId;
	private String username;
	private int warehouse;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(int warehouse) {
		this.warehouse = warehouse;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ItemResponse(String id, String name, String category, String description, String releaseDate, String userId,
			String username, int warehouse, String url) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.releaseDate = releaseDate;
		this.userId = userId;
		this.username = username;
		this.warehouse=warehouse;
		this.url=url;
	}
	
}
