package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f36593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f36594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile EntrySet f36596d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f36597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile DescendingEntrySet f36598g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator f36600b;

        private DescendingEntryIterator() {
            this.f36599a = SmallSortedMap.this.f36593a.size();
        }

        private Iterator a() {
            if (this.f36600b == null) {
                this.f36600b = SmallSortedMap.this.f36597f.entrySet().iterator();
            }
            return this.f36600b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = SmallSortedMap.this.f36593a;
            int i3 = this.f36599a - 1;
            this.f36599a = i3;
            return (Map.Entry) list.get(i3);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i3 = this.f36599a;
            return (i3 > 0 && i3 <= SmallSortedMap.this.f36593a.size()) || a().hasNext();
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

        @Override // androidx.datastore.preferences.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Comparable f36603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f36604b;

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
            return this.f36603a;
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
            return b(this.f36603a, entry.getKey()) && b(this.f36604b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f36604b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f36603a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f36604b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            SmallSortedMap.this.g();
            Object obj2 = this.f36604b;
            this.f36604b = obj;
            return obj2;
        }

        public String toString() {
            return this.f36603a + "=" + this.f36604b;
        }

        Entry(Comparable comparable, Object obj) {
            this.f36603a = comparable;
            this.f36604b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f36607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator f36608c;

        private EntryIterator() {
            this.f36606a = -1;
        }

        private Iterator a() {
            if (this.f36608c == null) {
                this.f36608c = SmallSortedMap.this.f36594b.entrySet().iterator();
            }
            return this.f36608c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f36607b = true;
            int i3 = this.f36606a + 1;
            this.f36606a = i3;
            return i3 < SmallSortedMap.this.f36593a.size() ? (Map.Entry) SmallSortedMap.this.f36593a.get(this.f36606a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f36606a + 1 < SmallSortedMap.this.f36593a.size() || (!SmallSortedMap.this.f36594b.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f36607b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f36607b = false;
            SmallSortedMap.this.g();
            if (this.f36606a >= SmallSortedMap.this.f36593a.size()) {
                a().remove();
                return;
            }
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            int i3 = this.f36606a;
            this.f36606a = i3 - 1;
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
            java.util.List r0 = r4.f36593a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f36593a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.SmallSortedMap$Entry r2 = (androidx.datastore.preferences.protobuf.SmallSortedMap.Entry) r2
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
            java.util.List r3 = r4.f36593a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.SmallSortedMap$Entry r3 = (androidx.datastore.preferences.protobuf.SmallSortedMap.Entry) r3
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.SmallSortedMap.f(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f36595c) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (!this.f36593a.isEmpty() || (this.f36593a instanceof ArrayList)) {
            return;
        }
        this.f36593a = new ArrayList(16);
    }

    private SortedMap n() {
        g();
        if (this.f36594b.isEmpty() && !(this.f36594b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f36594b = treeMap;
            this.f36597f = treeMap.descendingMap();
        }
        return (SortedMap) this.f36594b;
    }

    static SmallSortedMap q() {
        return new SmallSortedMap<FieldSet.FieldDescriptorLite<Object>, Object>() { // from class: androidx.datastore.preferences.protobuf.SmallSortedMap.1
            @Override // androidx.datastore.preferences.protobuf.SmallSortedMap
            public void p() {
                if (!o()) {
                    for (int i3 = 0; i3 < k(); i3++) {
                        Map.Entry entryJ = j(i3);
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

            @Override // androidx.datastore.preferences.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((Comparable) obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object s(int i3) {
        g();
        Object value = ((Entry) this.f36593a.remove(i3)).getValue();
        if (!this.f36594b.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f36593a.add(new Entry(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f36593a.isEmpty()) {
            this.f36593a.clear();
        }
        if (this.f36594b.isEmpty()) {
            return;
        }
        this.f36594b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f36594b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f36596d == null) {
            this.f36596d = new EntrySet();
        }
        return this.f36596d;
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
            return this.f36594b.equals(smallSortedMap.f36594b);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((Entry) this.f36593a.get(iF)).getValue() : this.f36594b.get(comparable);
    }

    Set h() {
        if (this.f36598g == null) {
            this.f36598g = new DescendingEntrySet();
        }
        return this.f36598g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i3 = 0; i3 < iK; i3++) {
            iHashCode += ((Entry) this.f36593a.get(i3)).hashCode();
        }
        return l() > 0 ? iHashCode + this.f36594b.hashCode() : iHashCode;
    }

    public Map.Entry j(int i3) {
        return (Map.Entry) this.f36593a.get(i3);
    }

    public int k() {
        return this.f36593a.size();
    }

    public int l() {
        return this.f36594b.size();
    }

    public Iterable m() {
        return this.f36594b.isEmpty() ? Collections.EMPTY_SET : this.f36594b.entrySet();
    }

    public boolean o() {
        return this.f36595c;
    }

    public void p() {
        if (this.f36595c) {
            return;
        }
        this.f36594b = this.f36594b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36594b);
        this.f36597f = this.f36597f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f36597f);
        this.f36595c = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Object put(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((Entry) this.f36593a.get(iF)).setValue(obj);
        }
        i();
        int i3 = -(iF + 1);
        if (i3 >= 16) {
            return n().put(comparable, obj);
        }
        if (this.f36593a.size() == 16) {
            Entry entry = (Entry) this.f36593a.remove(15);
            n().put(entry.getKey(), entry.getValue());
        }
        this.f36593a.add(i3, new Entry(comparable, obj));
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
        if (this.f36594b.isEmpty()) {
            return null;
        }
        return this.f36594b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f36593a.size() + this.f36594b.size();
    }

    private SmallSortedMap() {
        this.f36593a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f36594b = map;
        this.f36597f = map;
    }
}
