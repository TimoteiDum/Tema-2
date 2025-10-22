package ro.emanuel.tema2.pojo;

public class Employees {
		private int id;
		private String name;
		private String position;
		private String salary;
		
		public Employees(int id, String name, String position, String salary) {
			super();
			this.id = id;
			this.name = name;
			this.position = position;
			this.salary = salary;
		}
		
		

		public Employees(String name, String position, String salary) {
			super();
			this.name = name;
			this.position = position;
			this.salary = salary;
		}



		public Employees() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPosition() {
			return position;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		

		public void setPosition(String position) {  
		    this.position = position;
		}



		public String getSalary() {
			
			return salary;
		}



		
		
		
		
}
