class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = Integer.parseInt(event1[0].replace(":", ""));
        int end1 = Integer.parseInt(event1[1].replace(":", ""));
        int start2 = Integer.parseInt(event2[0].replace(":", ""));
        int end2 = Integer.parseInt(event2[1].replace(":", ""));

        return start1 <= end2 && start2 <= end1;
    }

}