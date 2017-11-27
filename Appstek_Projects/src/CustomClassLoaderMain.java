
public class CustomClassLoaderMain {
public static void main(String[] args) throws Exception{
	CustomClassLoader ccl=new CustomClassLoader();
	ccl.findClass("ToLoad.class");
}
}
