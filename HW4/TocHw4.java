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
            String address = jsonItem.getString("�g�a�Ϭq��m�Ϋت��Ϫ��P");
            Trade tmpT = new Trade();
            
            if(address.indexOf("��") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("��")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("�`����");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("����~��"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("�`����"))
            			tmpT.maxPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("�`����"))
            			tmpT.minPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("����~��")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("����~��"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("��") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("��")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("�`����");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("����~��"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("�`����"))
            			tmpT.maxPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("�`����"))
            			tmpT.minPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("����~��")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("����~��"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("��") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("��")+1);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("�`����");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("����~��"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("�`����"))
            			tmpT.maxPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("�`����"))
            			tmpT.minPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("����~��")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("����~��"));
            			tmp = monthCount.get(tmpS);
            			tmp++;
            			monthCount.put(tmpS, tmp);
            		}
            	}
            }
            else if(address.indexOf("�j�D") != -1)
            {
            	String tmpS = address.substring(0, address.indexOf("�j�D")+2);
            	if(!info.containsKey(tmpS))
                {
            		tmpT.maxPrice = jsonItem.getInt("�`����");
            		tmpT.minPrice = tmpT.maxPrice;
            		info.put(tmpS, tmpT);
                	monthCount.put(tmpS, 0);
                	List<Integer> tmpL = new LinkedList<Integer>();
                	tmpL.add(jsonItem.getInt("����~��"));
                	distinct.put(tmpS, tmpL);
                }
            	else
            	{	
            		if(info.get(tmpS).maxPrice < jsonItem.getInt("�`����"))
            			tmpT.maxPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.maxPrice = info.get(tmpS).maxPrice;
            		if(info.get(tmpS).minPrice > jsonItem.getInt("�`����"))
            			tmpT.minPrice = jsonItem.getInt("�`����");
            		else
            			tmpT.minPrice = info.get(tmpS).minPrice;
            		info.put(tmpS, tmpT);
            		
            		if(!distinct.get(tmpS).contains(jsonItem.getInt("����~��")))
            		{
            			distinct.get(tmpS).add(jsonItem.getInt("����~��"));
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
				System.out.println((String)key + ", �̰������: " + info.get((String)key).maxPrice + ", �̧C�����: " + info.get((String)key).minPrice);
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
