package APITesting.ContractValidaion;

import java.util.HashMap;
import java.util.Map;


public class scenarioContext {
	
	private Map<String, Object> context;
	
	  public scenarioContext(){
		  context = new HashMap<String, Object>();
	    }
	  
	  public void setContext(String key, Object value) {
		  context.put(key.toString(), value);
	    }

	    public Object getContext(String key){
	        return context.get(key.toString());
	    }

	    public Boolean isContains(String key){
	        return context.containsKey(key.toString());
	    }

}




