package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Node f84233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Node f84234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Map f84235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient int f84236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient int f84237k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DistinctKeyIterator implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set f84245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f84246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f84247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f84248d;

        private DistinctKeyIterator() {
            this.f84245a = Sets.j(LinkedListMultimap.this.keySet().size());
            this.f84246b = LinkedListMultimap.this.f84233g;
            this.f84248d = LinkedListMultimap.this.f84237k;
        }

        private void a() {
            if (LinkedListMultimap.this.f84237k != this.f84248d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f84246b != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            Node node;
            a();
            Node node2 = this.f84246b;
            if (node2 == null) {
                throw new NoSuchElementException();
            }
            this.f84247c = node2;
            this.f84245a.add(node2.f84253a);
            do {
                node = this.f84246b.f84255c;
                this.f84246b = node;
                if (node == null) {
                    break;
                }
            } while (!this.f84245a.add(node.f84253a));
            return this.f84247c.f84253a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            Preconditions.A(this.f84247c != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.x(this.f84247c.f84253a);
            this.f84247c = null;
            this.f84248d = LinkedListMultimap.this.f84237k;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class KeyList<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f84250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f84251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f84252c;

        KeyList(Node node) {
            this.f84250a = node;
            this.f84251b = node;
            node.f84258g = null;
            node.f84257f = null;
            this.f84252c = 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<K, V> extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f84254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f84255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f84256d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Node f84257f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Node f84258g;

        Node(Object obj, Object obj2) {
            this.f84253a = obj;
            this.f84254b = obj2;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getKey() {
            return this.f84253a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            return this.f84254b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f84254b;
            this.f84254b = obj;
            return obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f84259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Node f84260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f84261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f84262d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f84263f;

        NodeIterator(int i3) {
            this.f84263f = LinkedListMultimap.this.f84237k;
            int size = LinkedListMultimap.this.size();
            Preconditions.w(i3, size);
            if (i3 < size / 2) {
                this.f84260b = LinkedListMultimap.this.f84233g;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0) {
                        break;
                    }
                    next();
                    i3 = i4;
                }
            } else {
                this.f84262d = LinkedListMultimap.this.f84234h;
                this.f84259a = size;
                while (true) {
                    int i5 = i3 + 1;
                    if (i3 >= size) {
                        break;
                    }
                    previous();
                    i3 = i5;
                }
            }
            this.f84261c = null;
        }

        private void b() {
            if (LinkedListMultimap.this.f84237k != this.f84263f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Node next() {
            b();
            Node node = this.f84260b;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f84261c = node;
            this.f84262d = node;
            this.f84260b = node.f84255c;
            this.f84259a++;
            return node;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Node previous() {
            b();
            Node node = this.f84262d;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f84261c = node;
            this.f84260b = node;
            this.f84262d = node.f84256d;
            this.f84259a--;
            return node;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        void f(Object obj) {
            Preconditions.z(this.f84261c != null);
            this.f84261c.f84254b = obj;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f84260b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f84262d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f84259a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f84259a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            Preconditions.A(this.f84261c != null, "no calls to next() since the last call to remove()");
            Node node = this.f84261c;
            if (node != this.f84260b) {
                this.f84262d = node.f84256d;
                this.f84259a--;
            } else {
                this.f84260b = node.f84255c;
            }
            LinkedListMultimap.this.y(node);
            this.f84261c = null;
            this.f84263f = LinkedListMultimap.this.f84237k;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f84235i = CompactLinkedHashMap.c0();
        int i3 = objectInputStream.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node s(Object obj, Object obj2, Node node) {
        Node node2 = new Node(obj, obj2);
        if (this.f84233g == null) {
            this.f84234h = node2;
            this.f84233g = node2;
            this.f84235i.put(obj, new KeyList(node2));
            this.f84237k++;
        } else if (node == null) {
            Node node3 = this.f84234h;
            Objects.requireNonNull(node3);
            node3.f84255c = node2;
            node2.f84256d = this.f84234h;
            this.f84234h = node2;
            KeyList keyList = (KeyList) this.f84235i.get(obj);
            if (keyList == null) {
                this.f84235i.put(obj, new KeyList(node2));
                this.f84237k++;
            } else {
                keyList.f84252c++;
                Node node4 = keyList.f84251b;
                node4.f84257f = node2;
                node2.f84258g = node4;
                keyList.f84251b = node2;
            }
        } else {
            KeyList keyList2 = (KeyList) this.f84235i.get(obj);
            Objects.requireNonNull(keyList2);
            keyList2.f84252c++;
            node2.f84256d = node.f84256d;
            node2.f84258g = node.f84258g;
            node2.f84255c = node;
            node2.f84257f = node;
            Node node5 = node.f84258g;
            if (node5 == null) {
                keyList2.f84250a = node2;
            } else {
                node5.f84257f = node2;
            }
            Node node6 = node.f84256d;
            if (node6 == null) {
                this.f84233g = node2;
            } else {
                node6.f84255c = node2;
            }
            node.f84256d = node2;
            node.f84258g = node2;
        }
        this.f84236j++;
        return node2;
    }

    private List w(Object obj) {
        return Collections.unmodifiableList(Lists.k(new ValueForKeyIterator(obj)));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : b()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Iterators.e(new ValueForKeyIterator(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Node node) {
        Node node2 = node.f84256d;
        if (node2 != null) {
            node2.f84255c = node.f84255c;
        } else {
            this.f84233g = node.f84255c;
        }
        Node node3 = node.f84255c;
        if (node3 != null) {
            node3.f84256d = node2;
        } else {
            this.f84234h = node2;
        }
        if (node.f84258g == null && node.f84257f == null) {
            KeyList keyList = (KeyList) this.f84235i.remove(node.f84253a);
            Objects.requireNonNull(keyList);
            keyList.f84252c = 0;
            this.f84237k++;
        } else {
            KeyList keyList2 = (KeyList) this.f84235i.get(node.f84253a);
            Objects.requireNonNull(keyList2);
            keyList2.f84252c--;
            Node node4 = node.f84258g;
            if (node4 == null) {
                Node node5 = node.f84257f;
                Objects.requireNonNull(node5);
                keyList2.f84250a = node5;
            } else {
                node4.f84257f = node.f84257f;
            }
            Node node6 = node.f84257f;
            if (node6 == null) {
                Node node7 = node.f84258g;
                Objects.requireNonNull(node7);
                keyList2.f84251b = node7;
            } else {
                node6.f84258g = node.f84258g;
            }
        }
        this.f84236j--;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Map a1() {
        return super.a1();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map c() {
        return new Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f84233g = null;
        this.f84234h = null;
        this.f84235i.clear();
        this.f84236j = 0;
        this.f84237k++;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.f84235i.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set e() {
        return new Sets.ImprovedAbstractSet<K>() { // from class: com.google.common.collect.LinkedListMultimap.1KeySetImpl
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new DistinctKeyIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return !LinkedListMultimap.this.a(obj).isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return LinkedListMultimap.this.f84235i.size();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset g() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator i() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.f84233g == null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        s(obj, obj2, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f84236j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public List d() {
        return new AbstractSequentialList<Map.Entry<K, V>>() { // from class: com.google.common.collect.LinkedListMultimap.1EntriesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator listIterator(int i3) {
                return new NodeIterator(i3);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.f84236j;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public List h() {
        return new AbstractSequentialList<V>() { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator listIterator(int i3) {
                final NodeIterator nodeIterator = new NodeIterator(i3);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator) { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl.1

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ C1ValuesImpl f84244c;

                    {
                        this.f84244c = this;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.TransformedIterator
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public Object a(Map.Entry entry) {
                        return entry.getValue();
                    }

                    @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
                    public void set(Object obj) {
                        nodeIterator.f(obj);
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.f84236j;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public List b() {
        return (List) super.b();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean w1(Object obj, Object obj2) {
        return super.w1(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public List values() {
        return (List) super.values();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List a(Object obj) {
        List listW = w(obj);
        x(obj);
        return listW;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List get(final Object obj) {
        return new AbstractSequentialList<V>(this) { // from class: com.google.common.collect.LinkedListMultimap.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ LinkedListMultimap f84239b;

            {
                this.f84239b = this;
            }

            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator listIterator(int i3) {
                return new ValueForKeyIterator(obj, i3);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                KeyList keyList = (KeyList) this.f84239b.f84235i.get(obj);
                if (keyList == null) {
                    return 0;
                }
                return keyList.f84252c;
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ValueForKeyIterator implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f84266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f84267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f84268d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Node f84269f;

        ValueForKeyIterator(Object obj) {
            this.f84265a = obj;
            KeyList keyList = (KeyList) LinkedListMultimap.this.f84235i.get(obj);
            this.f84267c = keyList == null ? null : keyList.f84250a;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f84269f = LinkedListMultimap.this.s(this.f84265a, obj, this.f84267c);
            this.f84266b++;
            this.f84268d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f84267c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f84269f != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            Node node = this.f84267c;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f84268d = node;
            this.f84269f = node;
            this.f84267c = node.f84257f;
            this.f84266b++;
            return node.f84254b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f84266b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            Node node = this.f84269f;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f84268d = node;
            this.f84267c = node;
            this.f84269f = node.f84258g;
            this.f84266b--;
            return node.f84254b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f84266b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Preconditions.A(this.f84268d != null, "no calls to next() since the last call to remove()");
            Node node = this.f84268d;
            if (node != this.f84267c) {
                this.f84269f = node.f84258g;
                this.f84266b--;
            } else {
                this.f84267c = node.f84257f;
            }
            LinkedListMultimap.this.y(node);
            this.f84268d = null;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            Preconditions.z(this.f84268d != null);
            this.f84268d.f84254b = obj;
        }

        public ValueForKeyIterator(Object obj, int i3) {
            KeyList keyList = (KeyList) LinkedListMultimap.this.f84235i.get(obj);
            int i4 = keyList == null ? 0 : keyList.f84252c;
            Preconditions.w(i3, i4);
            if (i3 >= i4 / 2) {
                this.f84269f = keyList == null ? null : keyList.f84251b;
                this.f84266b = i4;
                while (true) {
                    int i5 = i3 + 1;
                    if (i3 >= i4) {
                        break;
                    }
                    previous();
                    i3 = i5;
                }
            } else {
                this.f84267c = keyList == null ? null : keyList.f84250a;
                while (true) {
                    int i6 = i3 - 1;
                    if (i3 <= 0) {
                        break;
                    }
                    next();
                    i3 = i6;
                }
            }
            this.f84265a = obj;
            this.f84268d = null;
        }
    }
}
