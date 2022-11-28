
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
public class Schedule {
	private String name;
	private LocalDateTime start_time;
	private LocalDateTime finish_time; 
	private String memo;
	public Schedule() {}; //기본 생성자

	public Schedule(String name, LocalDateTime start_time, LocalDateTime finish_time, String memo) {//생성자 오버로딩
		this.name = name; 
		this.start_time = start_time; 
		this.finish_time = finish_time; 
		this.memo = memo;
		}

	public Schedule(String name, LocalDateTime start_time, LocalDateTime finish_time) {//생성자 오버로딩 메모 없는 경우
		this.name = name;
		this.start_time = start_time; 
		this.finish_time = finish_time; 
		this.memo = "";
		}

	public String print_string(LocalDateTime a) { 
		String str = "";
		str = a.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); 
		return str;
		}

	public void print() {
		System.out.println(name+" "+print_string(start_time)+" "+print_string(finish_time)+" "+memo);
		}

	public String getName() { 
		return name; 
		}

	public void setName(String name) {
		this.name = name;
		}

	public LocalDateTime getStart_time() {
		return start_time;
		}
	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time; 
		}
	
	public LocalDateTime getFinish_time() {
		return finish_time;
		}
	public void setFinish_time(LocalDateTime finish_time) {
		this.finish_time = finish_time; 
		}
	public String getMemo() {
		return memo;
		}
	public void setMemo(String memo) {
		this.memo = memo;
		}
}
