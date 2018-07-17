
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) 
            return false;
        
        ListNode runner = head;
        ListNode walker = head;
        
        while(runner.next != null && runner.next.next != null && walker.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)
                return true;
        }
        return false;
    }
}
