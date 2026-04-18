import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class exp6 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int cases = Integer.parseInt(br.readLine());
        int count = 0;
        br.readLine();

        HashMap<Integer,contestant> contestants = new HashMap<Integer,contestant>();
        StringBuffer sb = new StringBuffer();
        while(count<cases)
        {
            // Read blank line after each case
            String line = br.readLine();
            String [] params;
            while(!line.trim().equals(""))
            {
                params = line.split(" ");
                int contestant = Integer.parseInt(params[0]);
                int problem = Integer.parseInt(params[1]);
                int time = Integer.parseInt(params[2]);
                char result = params[3].charAt(0);

                contestant c;
                if(contestants.containsKey(contestant))
                {
                    c = contestants.get(contestant);
                }
                else
                {
                    c = new contestant();
                    contestants.put(contestant, c);
                }

                if(!c.problems.contains(problem))
                {
                    // if its correct
                    if(result == 'C')
                    {
                        c.penalty = c.penalty + time;
                        c.problems.add(problem);
                        c.solved++;
                    }
                    else if(result == 'I')
                    {
                        c.penalty = c.penalty+20;
                    }
                }

                line = br.readLine();
                params = line.split(" ");
            }



            while(!contestants.isEmpty())
            {
                int max = getMaxKey(contestants);
                contestant c = contestants.get(max);
                sb.append(max+" "+c.solved+" "+c.penalty+"\n");
                contestants.remove(max);
            }
            sb.append("\n");

            count++;
        }

        System.out.print(sb.toString());

    }

    public static int getMaxKey(HashMap<Integer,contestant> contestants)
    {

        Iterator<Integer> keys = contestants.keySet().iterator();
        int max_solved = -1;
        int max_time = -1;
        int max_id = -1;
        while(keys.hasNext())
        {
            int key = keys.next();
            contestant c = contestants.get(key);
            if(c.solved>max_solved)
            {
                max_id = key;
                max_solved = c.solved;
                max_time = c.penalty;
            }
            else if(c.solved== max_solved)
            {
                if(c.penalty>max_time)
                {
                    max_id = key;
                    max_solved = c.solved;
                    max_time = c.penalty;
                }
                else if(c.penalty==max_time)
                {
                    if(key<max_id)
                    {
                        max_id = key;
                        max_solved = c.solved;
                        max_time = c.penalty;
                    }
                }
            }           
        }
        return max_id;      
    }
}

class contestant
{
    int solved;
    ArrayList<Integer> problems;
    int penalty;
    public contestant()
    {
        solved = 0;
        problems = new ArrayList<Integer> ();
        penalty = 0;
    }

}