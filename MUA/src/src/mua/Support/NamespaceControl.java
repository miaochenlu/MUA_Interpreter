package src.mua.Support;

/**
 * provide global static namespace list service
 */
public class NamespaceControl {
    static private NamespaceList namespaceList;
    public NamespaceControl() { }
    static public void createNamespaceList(NamespaceList initialNamespaceList) {
        namespaceList = initialNamespaceList;
    }
    static public NamespaceList getNamespaceList() { return namespaceList; }
}
