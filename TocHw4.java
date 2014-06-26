import org.json.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class TocHw4 {

	public static void main(String[] args) throws Exception {
        String web = args[0];
        int tmp, max = 0;
        
        readURL(web);
        File f = new File("URL.txt");
		FileReader ff = new FileReader(f);
		JSONArray jsonArray = new JSONArray(new JSONTokener(ff));
		ff.close();
		
		Map<String, Trade > info = new HashMap<String, Trade >();
		Map<String, Integer> monthCount = new HashMap<String, Integer>();
		Map<String, List<Integer>> distinct = new HashMap<String, List<Integer>>();
		
		for (int i = 0; i < jsonArray.length(); i++)
		{    
            JSONObject jsonItem = jsonArray.getJSONObject(i);
            String address = jsonItem.getString("土地區段位置或建物區門牌");
            Trade tmpT = new Trade();
            
            if(address.indexOf("路") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("路")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("總價元");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("交易年月"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("總價元"))
            			tmpT.maxPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("總價元"))
            			tmpT.minPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("交易年月")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("交易年月"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("街") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("街")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("總價元");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("交易年月"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("總價元"))
            			tmpT.maxPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("總價元"))
            			tmpT.minPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("交易年月")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("交易年月"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("巷") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("巷")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("總價元");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("交易年月"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("總價元"))
            			tmpT.maxPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("總價元"))
            			tmpT.minPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("交易年月")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("交易年月"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("大道") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("大道")+2);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("總價元");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("交易年月"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("總價元"))
            			tmpT.maxPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("總價元"))
            			tmpT.minPrice = jsonItem.getInt("總價元");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("交易年月")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("交易年月"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
        }
		for (Object key : monthCount.keySet()) 
		{
			if(monthCount.get(key) > max)
				max = monthCount.get(key);
        }
		for (Object key : monthCount.keySet()) 
		{
			if(monthCount.get(key) == max)
				System.out.println((String)key + ", 最高成交價: " + info.get((String)key).maxPrice + ", 最低成交價: " + info.get((String)key).minPrice);
		}
    }
	
	public static void readURL( String strURL ) {
        try {
            String line = null;

            URL url = new URL(strURL);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            InputStream is = uc.getInputStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
            BufferedWriter bw = new BufferedWriter(new FileWriter("URL.txt", false));    
            
            while ((line = br.readLine()) != null) {
                bw.write(line);            
            }
            br.close();
            bw.close();
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
