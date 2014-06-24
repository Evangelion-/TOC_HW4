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
            String address = jsonItem.getString("跋琿竚┪跋礟");
            Trade tmpT = new Trade();
            
            if(address.indexOf("隔") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("隔")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("ユる"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("羆基じ"))
            			tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("羆基じ"))
            			tmpT.minPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("ユる")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("ユる"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("刁") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("刁")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("ユる"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("羆基じ"))
            			tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("羆基じ"))
            			tmpT.minPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("ユる")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("ユる"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("ユる"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("羆基じ"))
            			tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("羆基じ"))
            			tmpT.minPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("ユる")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("ユる"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("笵") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("笵")+2);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("ユる"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("羆基じ"))
            			tmpT.maxPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("羆基じ"))
            			tmpT.minPrice = jsonItem.getInt("羆基じ");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("ユる")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("ユる"));
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
				System.out.println((String)key + ", 程蔼Θユ基: " + info.get((String)key).maxPrice + ", 程Θユ基: " + info.get((String)key).minPrice);
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
