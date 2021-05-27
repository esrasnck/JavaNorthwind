package kodlama.io.northwind.core.utilities.results;



public class Result { // super type : interface gibi soyut görevi görüyor

	private boolean succcess;
	private String message;
	
	public Result(boolean success) {
		this.succcess = success;
	}
	
	public Result(boolean success,String message) {
		this(success); // tek parametreli olan constructor'ını Java da böyle çağırıyoruz.
		this.message =message;
	}
	
	public boolean isSuccess() {
		return this.succcess;
	}
	
	public String getMessage() {
		   return this.message;
	   }
}
