package org.aitesting.microservices.drivermanagement.amqp;
import java.io.Serializable;

public final class CustomMessage implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iddriver;
    private int iddriverState;

    // Default constructor is needed to deserialize JSON
    public CustomMessage() {
    }
    
    public CustomMessage(int iddriver, int iddriverState) {
    	this.iddriver = iddriver;
    	this.iddriverState = iddriverState;
    }

	public int getIddriver() {
		return iddriver;
	}

	public void setIddriver(int iddriver) {
		this.iddriver = iddriver;
	}

	public int getIddriverState() {
		return iddriverState;
	}

	public void setIddriverState(int iddriverState) {
		this.iddriverState = iddriverState;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID Driver: "+ iddriver +" - ID State: "+iddriverState;
	}
}
