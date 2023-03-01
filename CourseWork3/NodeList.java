package CourseWork3;

public class NodeList {
    public String value;
    public NodeList next;
    public NodeList(String value, NodeList next) {
        this.value = value;
        this.next = next;
    }
    public NodeList(String value) {
        this.value = value;
        this.next = null;
    }
}