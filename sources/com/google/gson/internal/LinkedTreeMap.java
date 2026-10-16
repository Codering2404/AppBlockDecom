package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Comparator f90357j = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator f90358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f90359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Node f90360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f90361d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f90362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Node f90363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EntrySet f90364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private KeySet f90365i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node nodeC;
            if (!(obj instanceof Map.Entry) || (nodeC = LinkedTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.f(nodeC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f90361d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public Object next() {
                    return a().f90379g;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f90361d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f90370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f90371b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f90372c;

        LinkedTreeMapIterator() {
            this.f90370a = LinkedTreeMap.this.f90363g.f90377d;
            this.f90372c = LinkedTreeMap.this.f90362f;
        }

        final Node a() {
            Node node = this.f90370a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.f90363g) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.f90362f != this.f90372c) {
                throw new ConcurrentModificationException();
            }
            this.f90370a = node.f90377d;
            this.f90371b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f90370a != LinkedTreeMap.this.f90363g;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f90371b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.f(node, true);
            this.f90371b = null;
            this.f90372c = LinkedTreeMap.this.f90362f;
        }
    }

    public LinkedTreeMap() {
        this(f90357j, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(Node node, boolean z2) {
        while (node != null) {
            Node node2 = node.f90375b;
            Node node3 = node.f90376c;
            int i3 = node2 != null ? node2.f90382j : 0;
            int i4 = node3 != null ? node3.f90382j : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node node4 = node3.f90375b;
                Node node5 = node3.f90376c;
                int i6 = (node4 != null ? node4.f90382j : 0) - (node5 != null ? node5.f90382j : 0);
                if (i6 == -1 || (i6 == 0 && !z2)) {
                    i(node);
                } else {
                    j(node3);
                    i(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                Node node6 = node2.f90375b;
                Node node7 = node2.f90376c;
                int i7 = (node6 != null ? node6.f90382j : 0) - (node7 != null ? node7.f90382j : 0);
                if (i7 == 1 || (i7 == 0 && !z2)) {
                    j(node);
                } else {
                    i(node2);
                    j(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                node.f90382j = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f90382j = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.f90374a;
        }
    }

    private void h(Node node, Node node2) {
        Node node3 = node.f90374a;
        node.f90374a = null;
        if (node2 != null) {
            node2.f90374a = node3;
        }
        if (node3 == null) {
            this.f90360c = node2;
        } else if (node3.f90375b == node) {
            node3.f90375b = node2;
        } else {
            node3.f90376c = node2;
        }
    }

    private void i(Node node) {
        Node node2 = node.f90375b;
        Node node3 = node.f90376c;
        Node node4 = node3.f90375b;
        Node node5 = node3.f90376c;
        node.f90376c = node4;
        if (node4 != null) {
            node4.f90374a = node;
        }
        h(node, node3);
        node3.f90375b = node;
        node.f90374a = node3;
        int iMax = Math.max(node2 != null ? node2.f90382j : 0, node4 != null ? node4.f90382j : 0) + 1;
        node.f90382j = iMax;
        node3.f90382j = Math.max(iMax, node5 != null ? node5.f90382j : 0) + 1;
    }

    private void j(Node node) {
        Node node2 = node.f90375b;
        Node node3 = node.f90376c;
        Node node4 = node2.f90375b;
        Node node5 = node2.f90376c;
        node.f90375b = node5;
        if (node5 != null) {
            node5.f90374a = node;
        }
        h(node, node2);
        node2.f90376c = node;
        node.f90374a = node2;
        int iMax = Math.max(node3 != null ? node3.f90382j : 0, node5 != null ? node5.f90382j : 0) + 1;
        node.f90382j = iMax;
        node2.f90382j = Math.max(iMax, node4 != null ? node4.f90382j : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    Node b(Object obj, boolean z2) {
        int iCompareTo;
        Node node;
        Comparator comparator = this.f90358a;
        Node node2 = this.f90360c;
        if (node2 != null) {
            Comparable comparable = comparator == f90357j ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(node2.f90379g) : comparator.compare(obj, node2.f90379g);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.f90375b : node2.f90376c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        Node node4 = node2;
        if (!z2) {
            return null;
        }
        Node node5 = this.f90363g;
        if (node4 != null) {
            node = new Node(this.f90359b, node4, obj, node5, node5.f90378f);
            if (iCompareTo < 0) {
                node4.f90375b = node;
            } else {
                node4.f90376c = node;
            }
            e(node4, true);
        } else {
            if (comparator == f90357j && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            node = new Node(this.f90359b, node4, obj, node5, node5.f90378f);
            this.f90360c = node;
        }
        this.f90361d++;
        this.f90362f++;
        return node;
    }

    Node c(Map.Entry entry) {
        Node nodeD = d(entry.getKey());
        if (nodeD == null || !a(nodeD.f90381i, entry.getValue())) {
            return null;
        }
        return nodeD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f90360c = null;
        this.f90361d = 0;
        this.f90362f++;
        Node node = this.f90363g;
        node.f90378f = node;
        node.f90377d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    Node d(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        EntrySet entrySet = this.f90364h;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f90364h = entrySet2;
        return entrySet2;
    }

    void f(Node node, boolean z2) {
        int i3;
        if (z2) {
            Node node2 = node.f90378f;
            node2.f90377d = node.f90377d;
            node.f90377d.f90378f = node2;
        }
        Node node3 = node.f90375b;
        Node node4 = node.f90376c;
        Node node5 = node.f90374a;
        int i4 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                h(node, node3);
                node.f90375b = null;
            } else if (node4 != null) {
                h(node, node4);
                node.f90376c = null;
            } else {
                h(node, null);
            }
            e(node5, false);
            this.f90361d--;
            this.f90362f++;
            return;
        }
        Node nodeB = node3.f90382j > node4.f90382j ? node3.b() : node4.a();
        f(nodeB, false);
        Node node6 = node.f90375b;
        if (node6 != null) {
            i3 = node6.f90382j;
            nodeB.f90375b = node6;
            node6.f90374a = nodeB;
            node.f90375b = null;
        } else {
            i3 = 0;
        }
        Node node7 = node.f90376c;
        if (node7 != null) {
            i4 = node7.f90382j;
            nodeB.f90376c = node7;
            node7.f90374a = nodeB;
            node.f90376c = null;
        }
        nodeB.f90382j = Math.max(i3, i4) + 1;
        h(node, nodeB);
    }

    Node g(Object obj) {
        Node nodeD = d(obj);
        if (nodeD != null) {
            f(nodeD, true);
        }
        return nodeD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Node nodeD = d(obj);
        if (nodeD != null) {
            return nodeD.f90381i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        KeySet keySet = this.f90365i;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f90365i = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f90359b) {
            throw new NullPointerException("value == null");
        }
        Node nodeB = b(obj, true);
        Object obj3 = nodeB.f90381i;
        nodeB.f90381i = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Node nodeG = g(obj);
        if (nodeG != null) {
            return nodeG.f90381i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f90361d;
    }

    public LinkedTreeMap(boolean z2) {
        this(f90357j, z2);
    }

    public LinkedTreeMap(Comparator comparator, boolean z2) {
        this.f90361d = 0;
        this.f90362f = 0;
        this.f90358a = comparator == null ? f90357j : comparator;
        this.f90359b = z2;
        this.f90363g = new Node(z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f90374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f90375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f90376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f90377d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Node f90378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Object f90379g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f90380h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f90381i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f90382j;

        Node(boolean z2) {
            this.f90379g = null;
            this.f90380h = z2;
            this.f90378f = this;
            this.f90377d = this;
        }

        public Node a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f90375b; node2 != null; node2 = node2.f90375b) {
                node = node2;
            }
            return node;
        }

        public Node b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f90376c; node2 != null; node2 = node2.f90376c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f90379g;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f90381i;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f90379g;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f90381i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f90379g;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f90381i;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f90380h) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f90381i;
            this.f90381i = obj;
            return obj2;
        }

        public String toString() {
            return this.f90379g + "=" + this.f90381i;
        }

        Node(boolean z2, Node node, Object obj, Node node2, Node node3) {
            this.f90374a = node;
            this.f90379g = obj;
            this.f90380h = z2;
            this.f90382j = 1;
            this.f90377d = node2;
            this.f90378f = node3;
            node3.f90377d = this;
            node2.f90378f = this;
        }
    }
}
