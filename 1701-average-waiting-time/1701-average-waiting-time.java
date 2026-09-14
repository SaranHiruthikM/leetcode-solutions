class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currTime = customers[0][0] + customers[0][1];
        double waitTime = customers[0][1];
        for(int i=1; i<customers.length; i++)    {
            if(customers[i][0] < currTime){
                currTime += customers[i][1];
                waitTime += currTime - customers[i][0];
            }else{
                currTime = customers[i][0] + customers[i][1];
                waitTime += customers[i][1];
            }
        }

        return (double) waitTime/customers.length;
    }
}