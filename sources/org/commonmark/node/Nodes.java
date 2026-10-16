package org.commonmark.node;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Nodes {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NodeIterable implements Iterable<Node> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Node f145537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Node f145538b;

        @Override // java.lang.Iterable
        public Iterator<Node> iterator() {
            return new NodeIterator(this.f145537a, this.f145538b);
        }

        private NodeIterable(Node node, Node node2) {
            this.f145537a = node;
            this.f145538b = node2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NodeIterator implements Iterator<Node> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Node f145539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Node f145540b;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Node next() {
            Node node = this.f145539a;
            this.f145539a = node.f();
            return node;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Node node = this.f145539a;
            return (node == null || node == this.f145540b) ? false : true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        private NodeIterator(Node node, Node node2) {
            this.f145539a = node;
            this.f145540b = node2;
        }
    }

    public static Iterable a(Node node, Node node2) {
        return new NodeIterable(node.f(), node2);
    }
}
