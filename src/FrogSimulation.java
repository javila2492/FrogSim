public class FrogSimulation
{
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        return (int) (Math.random() * 20) - 3;
    }

    public boolean simulate()
    {
        System.out.print("Goal: " + maxHops + " Hops:  ");
        int pos = 0;
        int hop = 0;
        for (int i = 0; i < maxHops; i++)
        {
            hop = hopDistance();
            pos += hop;
            System.out.print(hop + "  ");
            if (pos >= goalDistance)
            {
                if(pos > goalDistance)
                    System.out.println("    Success: Passed Goal Distance by " + (pos - goalDistance) + " inches");
                else
                    System.out.println("    Success: Reached Goal in " + i + " hops");
                return true;
            }
            else if (pos < 0)
            {
                System.out.println("    Failed: Reached Negative Distance of " + pos);
                return false;
            }
        }
        System.out.println("    Failed: Got Stuck at " + pos);
        return false;
    }

    public double runSimulations(int num)
    {
        int count = 0;
        for(int i = 0; i < num; i++)
        {
            if(simulate())
                count++;
        }
        return (double)count/num;
    }
}
