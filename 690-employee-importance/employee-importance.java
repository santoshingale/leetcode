/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id){
        Employee emp = map.get(id);
        int imp = emp.importance;
        for(int sub : emp.subordinates){
            imp += dfs(map, sub);
        }
        return imp;
    }
}