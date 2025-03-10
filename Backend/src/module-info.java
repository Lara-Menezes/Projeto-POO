/**
 * 
 */
/**
 * 
 */
module Backend {
	requires com.google.gson;
	requires java.desktop;
	exports model;
	
	requires kernel;
	requires io;
	requires layout;
	
    requires org.opentest4j;
    requires org.apiguardian.api;

    opens model to com.google.gson;
    
    
}