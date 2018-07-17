
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        
        ListNode runner = head;
        ListNode walker = head;
        
        while(runner.next != null && runner.next.next != null && walker.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) {
                walker = head;
                while(walker!=runner){
                    walker = walker.next;
                    runner = runner.next;
                }
                return walker;
            }
        }
        
        return null;
    }
}
