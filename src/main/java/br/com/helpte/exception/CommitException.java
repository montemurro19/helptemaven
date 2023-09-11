package br.com.helpte.exception;

@SuppressWarnings("serial")
public class CommitException extends Exception {

	public CommitException() {
		super("Erro realizando commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
	
}