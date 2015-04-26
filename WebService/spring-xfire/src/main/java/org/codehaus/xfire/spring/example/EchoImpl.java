// START SNIPPET: echo
package org.codehaus.xfire.spring.example;

/**
 * Provides a default implementation of the echo service interface.
 */
public class EchoImpl
        implements Echo
{
    public String echo(String in)
    {
        return in;
    }

	public String echo2(int i1,int i2) {
		return i1+""+i2;
	}

}
