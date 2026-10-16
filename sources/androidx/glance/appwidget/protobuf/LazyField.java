package androidx.glance.appwidget.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MessageLite f39122f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LazyEntry<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map.Entry f39123a;

        public LazyField a() {
            return (LazyField) this.f39123a.getValue();
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f39123a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField lazyField = (LazyField) this.f39123a.getValue();
            if (lazyField == null) {
                return null;
            }
            return lazyField.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return ((LazyField) this.f39123a.getValue()).d((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private LazyEntry(Map.Entry entry) {
            this.f39123a = entry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator f39124a;

        public LazyIterator(Iterator it) {
            this.f39124a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.f39124a.next();
            return entry.getValue() instanceof LazyField ? new LazyEntry(entry) : entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39124a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f39124a.remove();
        }
    }

    @Override // androidx.glance.appwidget.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public MessageLite f() {
        return c(this.f39122f);
    }

    @Override // androidx.glance.appwidget.protobuf.LazyFieldLite
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
