package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Comparator f57046j = new Comparator<Comparable>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Comparator f57047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Node[] f57048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Node f57049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f57050d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f57051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f57052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EntrySet f57053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private KeySet f57054i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AvlBuilder<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Node f57055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f57056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f57057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f57058d;

        AvlBuilder() {
        }

        void a(Node node) {
            node.f57070c = null;
            node.f57068a = null;
            node.f57069b = null;
            node.f57076j = 1;
            int i3 = this.f57056b;
            if (i3 > 0) {
                int i4 = this.f57058d;
                if ((i4 & 1) == 0) {
                    this.f57058d = i4 + 1;
                    this.f57056b = i3 - 1;
                    this.f57057c++;
                }
            }
            node.f57068a = this.f57055a;
            this.f57055a = node;
            int i5 = this.f57058d;
            int i6 = i5 + 1;
            this.f57058d = i6;
            int i7 = this.f57056b;
            if (i7 > 0 && (i6 & 1) == 0) {
                this.f57058d = i5 + 2;
                this.f57056b = i7 - 1;
                this.f57057c++;
            }
            int i8 = 4;
            while (true) {
                int i9 = i8 - 1;
                if ((this.f57058d & i9) != i9) {
                    return;
                }
                int i10 = this.f57057c;
                if (i10 == 0) {
                    Node node2 = this.f57055a;
                    Node node3 = node2.f57068a;
                    Node node4 = node3.f57068a;
                    node3.f57068a = node4.f57068a;
                    this.f57055a = node3;
                    node3.f57069b = node4;
                    node3.f57070c = node2;
                    node3.f57076j = node2.f57076j + 1;
                    node4.f57068a = node3;
                    node2.f57068a = node3;
                } else if (i10 == 1) {
                    Node node5 = this.f57055a;
                    Node node6 = node5.f57068a;
                    this.f57055a = node6;
                    node6.f57070c = node5;
                    node6.f57076j = node5.f57076j + 1;
                    node5.f57068a = node6;
                    this.f57057c = 0;
                } else if (i10 == 2) {
                    this.f57057c = 0;
                }
                i8 *= 2;
            }
        }

        void b(int i3) {
            this.f57056b = ((Integer.highestOneBit(i3) * 2) - 1) - i3;
            this.f57058d = 0;
            this.f57057c = 0;
            this.f57055a = null;
        }

        Node c() {
            Node node = this.f57055a;
            if (node.f57068a == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AvlIterator<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Node f57059a;

        AvlIterator() {
        }

        public Node a() {
            Node node = this.f57059a;
            if (node == null) {
                return null;
            }
            Node node2 = node.f57068a;
            node.f57068a = null;
            Node node3 = node.f57070c;
            while (true) {
                Node node4 = node2;
                node2 = node3;
                if (node2 == null) {
                    this.f57059a = node4;
                    return node;
                }
                node2.f57068a = node4;
                node3 = node2.f57069b;
            }
        }

        void b(Node node) {
            Node node2 = null;
            while (node != null) {
                node.f57068a = node2;
                node2 = node;
                node = node.f57069b;
            }
            this.f57059a = node2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.EntrySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
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
            Node nodeE;
            if (!(obj instanceof Map.Entry) || (nodeE = LinkedHashTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.h(nodeE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.f57050d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.KeySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public Object next() {
                    return a().f57073g;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.i(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.f57050d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f57064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f57065b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f57066c;

        LinkedTreeMapIterator() {
            this.f57064a = LinkedHashTreeMap.this.f57049c.f57071d;
            this.f57066c = LinkedHashTreeMap.this.f57051f;
        }

        final Node a() {
            Node node = this.f57064a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.f57049c) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.f57051f != this.f57066c) {
                throw new ConcurrentModificationException();
            }
            this.f57064a = node.f57071d;
            this.f57065b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f57064a != LinkedHashTreeMap.this.f57049c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f57065b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.h(node, true);
            this.f57065b = null;
            this.f57066c = LinkedHashTreeMap.this.f57051f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f57068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f57069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f57070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f57071d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Node f57072f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Object f57073g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f57074h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f57075i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f57076j = 1;

        Node(Node node, Object obj, int i3, Node node2, Node node3) {
            this.f57068a = node;
            this.f57073g = obj;
            this.f57074h = i3;
            this.f57071d = node2;
            this.f57072f = node3;
            node3.f57071d = this;
            node2.f57072f = this;
        }

        public Node a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f57069b; node2 != null; node2 = node2.f57069b) {
                node = node2;
            }
            return node;
        }

        public Node b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f57070c; node2 != null; node2 = node2.f57070c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f57073g;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f57075i;
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
            return this.f57073g;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f57075i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f57073g;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f57075i;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f57075i;
            this.f57075i = obj;
            return obj2;
        }

        public String toString() {
            return this.f57073g + "=" + this.f57075i;
        }
    }

    private void a() {
        Node[] nodeArrB = b(this.f57048b);
        this.f57048b = nodeArrB;
        this.f57052g = (nodeArrB.length / 2) + (nodeArrB.length / 4);
    }

    static Node[] b(Node[] nodeArr) {
        int length = nodeArr.length;
        Node[] nodeArr2 = new Node[length * 2];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            Node node = nodeArr[i3];
            if (node != null) {
                avlIterator.b(node);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    Node nodeA = avlIterator.a();
                    if (nodeA == null) {
                        break;
                    }
                    if ((nodeA.f57074h & length) == 0) {
                        i4++;
                    } else {
                        i5++;
                    }
                }
                avlBuilder.b(i4);
                avlBuilder2.b(i5);
                avlIterator.b(node);
                while (true) {
                    Node nodeA2 = avlIterator.a();
                    if (nodeA2 == null) {
                        break;
                    }
                    if ((nodeA2.f57074h & length) == 0) {
                        avlBuilder.a(nodeA2);
                    } else {
                        avlBuilder2.a(nodeA2);
                    }
                }
                nodeArr2[i3] = i4 > 0 ? avlBuilder.c() : null;
                nodeArr2[i3 + length] = i5 > 0 ? avlBuilder2.c() : null;
            }
        }
        return nodeArr2;
    }

    private boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private void g(Node node, boolean z2) {
        while (node != null) {
            Node node2 = node.f57069b;
            Node node3 = node.f57070c;
            int i3 = node2 != null ? node2.f57076j : 0;
            int i4 = node3 != null ? node3.f57076j : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node node4 = node3.f57069b;
                Node node5 = node3.f57070c;
                int i6 = (node4 != null ? node4.f57076j : 0) - (node5 != null ? node5.f57076j : 0);
                if (i6 == -1 || (i6 == 0 && !z2)) {
                    k(node);
                } else {
                    l(node3);
                    k(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                Node node6 = node2.f57069b;
                Node node7 = node2.f57070c;
                int i7 = (node6 != null ? node6.f57076j : 0) - (node7 != null ? node7.f57076j : 0);
                if (i7 == 1 || (i7 == 0 && !z2)) {
                    l(node);
                } else {
                    k(node2);
                    l(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                node.f57076j = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f57076j = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.f57068a;
        }
    }

    private void j(Node node, Node node2) {
        Node node3 = node.f57068a;
        node.f57068a = null;
        if (node2 != null) {
            node2.f57068a = node3;
        }
        if (node3 == null) {
            int i3 = node.f57074h;
            this.f57048b[i3 & (r0.length - 1)] = node2;
        } else if (node3.f57069b == node) {
            node3.f57069b = node2;
        } else {
            node3.f57070c = node2;
        }
    }

    private void k(Node node) {
        Node node2 = node.f57069b;
        Node node3 = node.f57070c;
        Node node4 = node3.f57069b;
        Node node5 = node3.f57070c;
        node.f57070c = node4;
        if (node4 != null) {
            node4.f57068a = node;
        }
        j(node, node3);
        node3.f57069b = node;
        node.f57068a = node3;
        int iMax = Math.max(node2 != null ? node2.f57076j : 0, node4 != null ? node4.f57076j : 0) + 1;
        node.f57076j = iMax;
        node3.f57076j = Math.max(iMax, node5 != null ? node5.f57076j : 0) + 1;
    }

    private void l(Node node) {
        Node node2 = node.f57069b;
        Node node3 = node.f57070c;
        Node node4 = node2.f57069b;
        Node node5 = node2.f57070c;
        node.f57069b = node5;
        if (node5 != null) {
            node5.f57068a = node;
        }
        j(node, node2);
        node2.f57070c = node;
        node.f57068a = node2;
        int iMax = Math.max(node3 != null ? node3.f57076j : 0, node5 != null ? node5.f57076j : 0) + 1;
        node.f57076j = iMax;
        node2.f57076j = Math.max(iMax, node4 != null ? node4.f57076j : 0) + 1;
    }

    private static int m(int i3) {
        int i4 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f57048b, (Object) null);
        this.f57050d = 0;
        this.f57051f++;
        Node node = this.f57049c;
        Node node2 = node.f57071d;
        while (node2 != node) {
            Node node3 = node2.f57071d;
            node2.f57072f = null;
            node2.f57071d = null;
            node2 = node3;
        }
        node.f57072f = node;
        node.f57071d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    Node d(Object obj, boolean z2) {
        int iCompareTo;
        Node node;
        Comparator comparator = this.f57047a;
        Node[] nodeArr = this.f57048b;
        int iM = m(obj.hashCode());
        int length = (nodeArr.length - 1) & iM;
        Node node2 = nodeArr[length];
        if (node2 != null) {
            Comparable comparable = comparator == f57046j ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(node2.f57073g) : comparator.compare(obj, node2.f57073g);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.f57069b : node2.f57070c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        int i3 = iCompareTo;
        if (!z2) {
            return null;
        }
        Node node4 = this.f57049c;
        if (node2 != null) {
            Node node5 = node2;
            node = new Node(node5, obj, iM, node4, node4.f57072f);
            if (i3 < 0) {
                node5.f57069b = node;
            } else {
                node5.f57070c = node;
            }
            g(node5, true);
        } else {
            if (comparator == f57046j && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            node = new Node(node2, obj, iM, node4, node4.f57072f);
            nodeArr[length] = node;
        }
        int i4 = this.f57050d;
        this.f57050d = i4 + 1;
        if (i4 > this.f57052g) {
            a();
        }
        this.f57051f++;
        return node;
    }

    Node e(Map.Entry entry) {
        Node nodeF = f(entry.getKey());
        if (nodeF == null || !c(nodeF.f57075i, entry.getValue())) {
            return null;
        }
        return nodeF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        EntrySet entrySet = this.f57053h;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f57053h = entrySet2;
        return entrySet2;
    }

    Node f(Object obj) {
        if (obj != null) {
            try {
                return d(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Node nodeF = f(obj);
        if (nodeF != null) {
            return nodeF.f57075i;
        }
        return null;
    }

    void h(Node node, boolean z2) {
        int i3;
        if (z2) {
            Node node2 = node.f57072f;
            node2.f57071d = node.f57071d;
            node.f57071d.f57072f = node2;
            node.f57072f = null;
            node.f57071d = null;
        }
        Node node3 = node.f57069b;
        Node node4 = node.f57070c;
        Node node5 = node.f57068a;
        int i4 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                j(node, node3);
                node.f57069b = null;
            } else if (node4 != null) {
                j(node, node4);
                node.f57070c = null;
            } else {
                j(node, null);
            }
            g(node5, false);
            this.f57050d--;
            this.f57051f++;
            return;
        }
        Node nodeB = node3.f57076j > node4.f57076j ? node3.b() : node4.a();
        h(nodeB, false);
        Node node6 = node.f57069b;
        if (node6 != null) {
            i3 = node6.f57076j;
            nodeB.f57069b = node6;
            node6.f57068a = nodeB;
            node.f57069b = null;
        } else {
            i3 = 0;
        }
        Node node7 = node.f57070c;
        if (node7 != null) {
            i4 = node7.f57076j;
            nodeB.f57070c = node7;
            node7.f57068a = nodeB;
            node.f57070c = null;
        }
        nodeB.f57076j = Math.max(i3, i4) + 1;
        j(node, nodeB);
    }

    Node i(Object obj) {
        Node nodeF = f(obj);
        if (nodeF != null) {
            h(nodeF, true);
        }
        return nodeF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        KeySet keySet = this.f57054i;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f57054i = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        Node nodeD = d(obj, true);
        Object obj3 = nodeD.f57075i;
        nodeD.f57075i = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Node nodeI = i(obj);
        if (nodeI != null) {
            return nodeI.f57075i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f57050d;
    }
}
