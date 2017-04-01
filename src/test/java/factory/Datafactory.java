package factory;

import dataprovider.Configdataprovider;
import dataprovider.Exceldataprovider;

public class Datafactory {
	
	public static Configdataprovider getconfig()
	{
		Configdataprovider config = new Configdataprovider();
		
		return config;
	}
	
		
		public static Exceldataprovider getexcel()
		{
			Exceldataprovider excel = new Exceldataprovider();
			
			return excel;
		
	}

}

