package com.test;

public interface ATMTransport {

	public void communicateWithBank();
	public void setRetries(int retries);
}
