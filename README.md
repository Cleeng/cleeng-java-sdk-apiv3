# Cleeng API v3 Java SDK

Example usage:

	import com.cleeng.apiv3.CleengApi;
	import com.cleeng.apiv3.domain.*;

	...

	CleengApi cleengApi = new CleengApi();
	cleengApi.enableSandbox(); // remove this line when going live

	// you should retrieve the customerToken & offerId from the HTTP request
	String customerToken = "JS-82A_mtlZlJMuuJHvkhnFo_4F1xHRcbqllOzdIO59m-adg";
	String offerId = "P765685881_NL";

	boolean isgranted = cleengApi.isAccessGranted(customerToken, offerId);
	if(isgranted) {
		System.out.println("Access granted");
	} else {
		System.out.println("Access denied");
	}


See `src/CleengApiExample.java` for a minimal working example.

See http://cleeng.com/open/v3/Reference for details on the Cleeng API.

All functions in the API documentation have been implemented as methods
on CleengApi objects.

Additionally, the following functions have been added as shortcuts to calling
getAccessStatus():

- boolean isAccessGranted(String customerToken, String offerId)
- boolean isAccessGranted(String customerToken, String offerId, String ipAddress)

Instead of duplicating all class & type information
once more in this file, please refer to the file
`src/main/java/com/cleeng/apiv3/CleengApi.java` for the method signatures,
and to `src/main/java/com/cleeng/apiv3/domain/*.java` for the classes used
for parameters and return values.  The names map directly to the
documentation available at http://cleeng.com/open/v3/Reference.

Note that most error conditions raise exceptions which have to be
handled properly by you, the programmer.

The classes in `src/main/java/com/cleeng/apiv3/domain/` do not have
explicit constructors.  The classes that you will instantiate yourself
have many optional fields.  For example `SingleOfferData` as parameter
`offerData` to method `createSingleOffer()`.  To use, first instantiate
an empty object, then set all the fields you want to use in the API call.


## Compiling the SDK

The Cleeng Java SDK uses jsonrpc4 to communicate with the JSON-RPC API.
To build this SDK, you need Maven.  Run `mvn clean install` to do
a clean build, including fetching dependencies.

This will create a file named
`cleeng-java-sdk-apiv3-1.0-jar-with-dependencies.jar` (maybe with a
higher version number than 1.0) somewhere in your Maven install directory
(`$HOME/.m2/` for example).

You can compile the example program as follows (from the `src/` directory):

	javac -cp path/to/cleeng-java-sdk-apiv3-1.0-jar-with-dependencies.jar CleengApiExample.java

And run it (again from `src/`):

	java -cp path/to/cleeng-java-sdk-apiv3-1.0-jar-with-dependencies.jar:. CleengApiExample
