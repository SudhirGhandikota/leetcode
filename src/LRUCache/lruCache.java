package LRUCache;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class lruCache {
	int capacity;
	private LinkedHashMap<String,Integer>map;
	
	public lruCache(int capacity)
	{
		this.capacity = capacity;
		map = new LinkedHashMap<>();
	}
	
	public int get(String key)
	{
		Integer value = map.get(key);
		if(value==null)
			value=-1;
		else
			this.set(key,value);
		return value;
				
	}

	private void set(String key, Integer value) {
		if(map.containsKey(key))
			map.remove(key);
		else if(map.size()==this.capacity)
		{
			Iterator<String> it = map.keySet().iterator();
			it.next();
			it.remove();
		}
		map.put(key, value);
		
	}

	public static void main(String[] args) {
		lruCache cache = new lruCache(3);
		cache.set("abc", 1);
		cache.set("def", 1);
		cache.set("123", 1);

	}

}
