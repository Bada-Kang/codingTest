class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int x1 = wallet[0]>wallet[1] ? wallet[0] : wallet[1];
        int y1 = wallet[0]<wallet[1] ? wallet[0] : wallet[1];

        int x2 = bill[0]>bill[1] ? bill[0] : bill[1];
        int y2 = bill[0]<bill[1] ? bill[0] : bill[1];

        while (x1 < x2 || y1 < y2) {
            if (x1 < x2 || y1 < y2) {
                answer+=1;
                x2 = (int)Math.floor(x2/2);
            }
            
        
            if (x2 < y2) {
                int temp = x2;
                x2 = y2;
                y2 = temp;
            }
            
            if (x1 > x2 && y1 > y2) {
                break;
            }
        }

        return answer;
    }
}