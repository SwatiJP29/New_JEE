package pack020param;

import java.io.Serializable;

public class TravAgentBean
{	String emailAddress;
	String origin;
	String destination;
	float  tCost;
	float  advance;

	public TravAgentBean()
		{	System.out.println("Constructor from CollectParameter22.");}

	public float getAdvance()
		{	return advance;	}

	public void setAdvance(float advance)
		{	this.advance = advance;	}

	public String getDestination()
		{	return destination;	}

	public void setDestination(String destination)
		{	this.destination = destination;	}

	public String getEmailAddress()
		{	return emailAddress;	}

	public void setEmailAddress(String emailAddress)
		{	this.emailAddress = emailAddress;	}

	public String getOrigin()
		{	return origin;	}

	public void setOrigin(String origin)
		{	this.origin = origin;	}

	public float getTotalCost()
		{	return tCost;	}

	public void setTotalCost(float cost)
		{	tCost = cost;	}
}
