// START SNIPPET: echo
package org.codehaus.xfire.spring.example;

/**
 * Provides the service contract for the echo service.
 *
 * @author <a href="mailto:poutsma@mac.com">Arjen Poutsma</a>
 */
public interface Echo
{
    String echo(String in);
    
    public String echo2(int i1,int i2);
}
// END SNIPPET: echo