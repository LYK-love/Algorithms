package Structures;

import java.util.LinkedHashMap;

/**
 * 146. LRU Cache
 * 一次get 或一次put 都被称为使用
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache  {
    int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            makeRecently(key);
            return map.get(key);
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            map.put(key, value);
            makeRecently(key);
        }
        else
        {
            if(map.size() < capacity)
                ;
            else{ //evict
                Integer keyToEvict = map.keySet().iterator().next();
                map.remove(keyToEvict);
            }
            map.put(key, value);
        }

    }

    private void makeRecently(int key)
    {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value); //update LRU
    }
}
