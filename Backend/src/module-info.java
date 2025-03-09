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

    opens model to com.google.gson;
    opens teste to com.google.gson;
}