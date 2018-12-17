package pack070tags;

public class Tag60EmpBean
{	int empNo=000;
	String eName="GumNam";
	float empSal=0.0f;
	
	public Tag60EmpBean(int empNo, String eName, float empSal)
		{	this.empNo = empNo;
			this.eName = eName;
			this.empSal = empSal;
		}
	public int getEmpNo()
		{	return empNo;	}
	
	public float getEmpSal()
		{	return empSal;	}
	
	public String getEName()
		{	return eName;	}
}
