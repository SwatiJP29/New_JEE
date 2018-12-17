package packcommon.packexceptions;

public class UnauthenticatedUserException extends BankException {

	public UnauthenticatedUserException(String msg){
		super(msg);
	}
}
