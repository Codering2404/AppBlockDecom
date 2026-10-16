package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f87094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f87095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f87096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f87097d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile EntrySet f87098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f87099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile DescendingEntrySet f87100h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f87101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator f87102b;

        private DescendingEntryIterator() {
            this.f87101a = SmallSortedMap.this.f87095b.size();
        }

        private Iterator a() {
            if (this.f87102b == null) {
                this.f87102b = SmallSortedMap.this.f87099g.entrySet().iterator();
            }
            return this.f87102b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = SmallSortedMap.this.f87095b;
            int i3 = this.f87101a - 1;
            this.f87101a = i3;
            return (Map.Entry) list.get(i3);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i3 = this.f87101a;
            return (i3 > 0 && i3 <= SmallSortedMap.this.f87095b.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EmptySet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Iterator f87105a = new Iterator<Object>() { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EmptySet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable f87106b = new Iterable<Object>() { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return EmptySet.f87105a;
            }
        };

        static Iterable b() {
            return f87106b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Comparable f87107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f87108b;

        Entry(SmallSortedMap smallSortedMap, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f87107a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f87107a, entry.getKey()) && b(this.f87108b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f87108b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f87107a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f87108b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            SmallSortedMap.this.g();
            Object obj2 = this.f87108b;
            this.f87108b = obj;
            return obj2;
        }

        public String toString() {
            return this.f87107a + "=" + this.f87108b;
        }

        Entry(Comparable comparable, Object obj) {
            this.f87107a = comparable;
            this.f87108b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f87110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f87111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator f87112c;

        private EntryIterator() {
            this.f87110a = -1;
        }

        private Iterator a() {
            if (this.f87112c == null) {
                this.f87112c = SmallSortedMap.this.f87096c.entrySet().iterator();
            }
            return this.f87112c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f87111b = true;
            int i3 = this.f87110a + 1;
            this.f87110a = i3;
            return i3 < SmallSortedMap.this.f87095b.size() ? (Map.Entry) SmallSortedMap.this.f87095b.get(this.f87110a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f87110a + 1 < SmallSortedMap.this.f87095b.size() || (!SmallSortedMap.this.f87096c.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f87111b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f87111b = false;
            SmallSortedMap.this.g();
            if (this.f87110a >= SmallSortedMap.this.f87095b.size()) {
                a().remove();
                return;
            }
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            int i3 = this.f87110a;
            this.f87110a = i3 - 1;
            smallSortedMap.s(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int f(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f87095b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f87095b
            java.lang.Object r2 = r2.get(r1)
            com.google.crypto.tink.shaded.protobuf.SmallSortedMap$Entry r2 = (com.google.crypto.tink.shaded.protobuf.SmallSortedMap.Entry) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r5 = -r0
            return r5
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f87095b
            java.lang.Object r3 = r3.get(r2)
            com.google.crypto.tink.shaded.protobuf.SmallSortedMap$Entry r3 = (com.google.crypto.tink.shaded.protobuf.SmallSortedMap.Entry) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.f(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f87097d) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (!this.f87095b.isEmpty() || (this.f87095b instanceof ArrayList)) {
            return;
        }
        this.f87095b = new ArrayList(this.f87094a);
    }

    private SortedMap n() {
        g();
        if (this.f87096c.isEmpty() && !(this.f87096c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f87096c = treeMap;
            this.f87099g = treeMap.descendingMap();
        }
        return (SortedMap) this.f87096c;
    }

    static SmallSortedMap q(int i3) {
        return new SmallSortedMap<FieldSet.FieldDescriptorLite<Object>, Object>(i3) { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.1
            @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap
            public void p() {
                if (!o()) {
                    for (int i4 = 0; i4 < k(); i4++) {
                        Map.Entry entryJ = j(i4);
                        if (((FieldSet.FieldDescriptorLite) entryJ.getKey()).K()) {
                            entryJ.setValue(Collections.unmodifiableList((List) entryJ.getValue()));
                        }
                    }
                    for (Map.Entry entry : m()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).K()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.p();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((Comparable) obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object s(int i3) {
        g();
        Object value = ((Entry) this.f87095b.remove(i3)).getValue();
        if (!this.f87096c.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f87095b.add(new Entry(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f87095b.isEmpty()) {
            this.f87095b.clear();
        }
        if (this.f87096c.isEmpty()) {
            return;
        }
        this.f87096c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f87096c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f87098f == null) {
            this.f87098f = new EntrySet();
        }
        return this.f87098f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int iK = k();
        if (iK != smallSortedMap.k()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i3 = 0; i3 < iK; i3++) {
            if (!j(i3).equals(smallSortedMap.j(i3))) {
                return false;
            }
        }
        if (iK != size) {
            return this.f87096c.equals(smallSortedMap.f87096c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((Entry) this.f87095b.get(iF)).getValue() : this.f87096c.get(comparable);
    }

    Set h() {
        if (this.f87100h == null) {
            this.f87100h = new DescendingEntrySet();
        }
        return this.f87100h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i3 = 0; i3 < iK; i3++) {
            iHashCode += ((Entry) this.f87095b.get(i3)).hashCode();
        }
        return l() > 0 ? iHashCode + this.f87096c.hashCode() : iHashCode;
    }

    public Map.Entry j(int i3) {
        return (Map.Entry) this.f87095b.get(i3);
    }

    public int k() {
        return this.f87095b.size();
    }

    public int l() {
        return this.f87096c.size();
    }

    public Iterable m() {
        return this.f87096c.isEmpty() ? EmptySet.b() : this.f87096c.entrySet();
    }

    public boolean o() {
        return this.f87097d;
    }

    public void p() {
        if (this.f87097d) {
            return;
        }
        this.f87096c = this.f87096c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f87096c);
        this.f87099g = this.f87099g.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f87099g);
        this.f87097d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Object put(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((Entry) this.f87095b.get(iF)).setValue(obj);
        }
        i();
        int i3 = -(iF + 1);
        if (i3 >= this.f87094a) {
            return n().put(comparable, obj);
        }
        int size = this.f87095b.size();
        int i4 = this.f87094a;
        if (size == i4) {
            Entry entry = (Entry) this.f87095b.remove(i4 - 1);
            n().put(entry.getKey(), entry.getValue());
        }
        this.f87095b.add(i3, new Entry(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return s(iF);
        }
        if (this.f87096c.isEmpty()) {
            return null;
        }
        return this.f87096c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f87095b.size() + this.f87096c.size();
    }

    private SmallSortedMap(int i3) {
        this.f87094a = i3;
        this.f87095b = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f87096c = map;
        this.f87099g = map;
    }
}
