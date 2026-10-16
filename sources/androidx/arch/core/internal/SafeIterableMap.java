package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Entry f2370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Entry f2371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHashMap f2372c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2373d = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry entry, Entry entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry b(Entry entry) {
            return entry.f2377d;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry c(Entry entry) {
            return entry.f2376c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry entry, Entry entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry b(Entry entry) {
            return entry.f2376c;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry c(Entry entry) {
            return entry.f2377d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Entry<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f2374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f2375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Entry f2376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Entry f2377d;

        Entry(Object obj, Object obj2) {
            this.f2374a = obj;
            this.f2375b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f2374a.equals(entry.f2374a) && this.f2375b.equals(entry.f2375b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f2374a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f2375b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2374a.hashCode() ^ this.f2375b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2374a + "=" + this.f2375b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Entry f2378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2379b = true;

        IteratorWithAdditions() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        void a(Entry entry) {
            Entry entry2 = this.f2378a;
            if (entry == entry2) {
                Entry entry3 = entry2.f2377d;
                this.f2378a = entry3;
                this.f2379b = entry3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f2379b) {
                this.f2379b = false;
                this.f2378a = SafeIterableMap.this.f2370a;
            } else {
                Entry entry = this.f2378a;
                this.f2378a = entry != null ? entry.f2376c : null;
            }
            return this.f2378a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2379b) {
                return SafeIterableMap.this.f2370a != null;
            }
            Entry entry = this.f2378a;
            return (entry == null || entry.f2376c == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Entry f2381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Entry f2382b;

        ListIterator(Entry entry, Entry entry2) {
            this.f2381a = entry2;
            this.f2382b = entry;
        }

        private Entry e() {
            Entry entry = this.f2382b;
            Entry entry2 = this.f2381a;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return c(entry);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void a(Entry entry) {
            if (this.f2381a == entry && entry == this.f2382b) {
                this.f2382b = null;
                this.f2381a = null;
            }
            Entry entry2 = this.f2381a;
            if (entry2 == entry) {
                this.f2381a = b(entry2);
            }
            if (this.f2382b == entry) {
                this.f2382b = e();
            }
        }

        abstract Entry b(Entry entry);

        abstract Entry c(Entry entry);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Entry entry = this.f2382b;
            this.f2382b = e();
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2382b != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SupportRemove<K, V> {
        abstract void a(Entry entry);
    }

    public Map.Entry a() {
        return this.f2370a;
    }

    protected Entry b(Object obj) {
        Entry entry = this.f2370a;
        while (entry != null && !entry.f2374a.equals(obj)) {
            entry = entry.f2376c;
        }
        return entry;
    }

    public IteratorWithAdditions d() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f2372c.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Iterator descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f2371b, this.f2370a);
        this.f2372c.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public Map.Entry e() {
        return this.f2371b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    Entry f(Object obj, Object obj2) {
        Entry entry = new Entry(obj, obj2);
        this.f2373d++;
        Entry entry2 = this.f2371b;
        if (entry2 == null) {
            this.f2370a = entry;
            this.f2371b = entry;
            return entry;
        }
        entry2.f2376c = entry;
        entry.f2377d = entry2;
        this.f2371b = entry;
        return entry;
    }

    public Object g(Object obj, Object obj2) {
        Entry entryB = b(obj);
        if (entryB != null) {
            return entryB.f2375b;
        }
        f(obj, obj2);
        return null;
    }

    public Object h(Object obj) {
        Entry entryB = b(obj);
        if (entryB == null) {
            return null;
        }
        this.f2373d--;
        if (!this.f2372c.isEmpty()) {
            Iterator<K> it = this.f2372c.keySet().iterator();
            while (it.hasNext()) {
                ((SupportRemove) it.next()).a(entryB);
            }
        }
        Entry entry = entryB.f2377d;
        if (entry != null) {
            entry.f2376c = entryB.f2376c;
        } else {
            this.f2370a = entryB.f2376c;
        }
        Entry entry2 = entryB.f2376c;
        if (entry2 != null) {
            entry2.f2377d = entry;
        } else {
            this.f2371b = entry;
        }
        entryB.f2376c = null;
        entryB.f2377d = null;
        return entryB.f2375b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f2370a, this.f2371b);
        this.f2372c.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public int size() {
        return this.f2373d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
