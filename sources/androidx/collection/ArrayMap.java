package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    EntrySet f2786d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    KeySet f2787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ValueCollection f2788g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeyIterator extends IndexBasedArrayIterator<K> {
        KeyIterator() {
            super(ArrayMap.this.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected Object a(int i3) {
            return ArrayMap.this.f(i3);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void b(int i3) {
            ArrayMap.this.h(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2793b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2794c;

        MapIterator() {
            this.f2792a = ArrayMap.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2793b++;
            this.f2794c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f2794c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ContainerHelpersKt.c(entry.getKey(), ArrayMap.this.f(this.f2793b)) && ContainerHelpersKt.c(entry.getValue(), ArrayMap.this.j(this.f2793b));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f2794c) {
                return ArrayMap.this.f(this.f2793b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f2794c) {
                return ArrayMap.this.j(this.f2793b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2793b < this.f2792a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f2794c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objF = ArrayMap.this.f(this.f2793b);
            Object objJ = ArrayMap.this.j(this.f2793b);
            return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2794c) {
                throw new IllegalStateException();
            }
            ArrayMap.this.h(this.f2793b);
            this.f2793b--;
            this.f2792a--;
            this.f2794c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f2794c) {
                return ArrayMap.this.i(this.f2793b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueIterator extends IndexBasedArrayIterator<V> {
        ValueIterator() {
            super(ArrayMap.this.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected Object a(int i3) {
            return ArrayMap.this.j(i3);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void b(int i3) {
            ArrayMap.this.h(i3);
        }
    }

    public ArrayMap() {
    }

    static boolean l(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        EntrySet entrySet = this.f2786d;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f2786d = entrySet2;
        return entrySet2;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object get(Object obj) {
        return super.get(obj);
    }

    public boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Set keySet() {
        KeySet keySet = this.f2787f;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f2787f = keySet2;
        return keySet2;
    }

    public boolean m(Collection collection) {
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean n(Collection collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(f(size2))) {
                h(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        b(size() + map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public Collection values() {
        ValueCollection valueCollection = this.f2788g;
        if (valueCollection != null) {
            return valueCollection;
        }
        ValueCollection valueCollection2 = new ValueCollection();
        this.f2788g = valueCollection2;
        return valueCollection2;
    }

    public ArrayMap(int i3) {
        super(i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet implements Set<K> {
        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return ArrayMap.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return ArrayMap.l(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = ArrayMap.this.size() - 1; size >= 0; size--) {
                Object objF = ArrayMap.this.f(size);
                iHashCode += objF == null ? 0 : objF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iD = ArrayMap.this.d(obj);
            if (iD < 0) {
                return false;
            }
            ArrayMap.this.h(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return ArrayMap.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return ArrayMap.this.n(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ArrayMap.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = ArrayMap.this.size();
            Object[] objArr = new Object[size];
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i3] = ArrayMap.this.f(i3);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i3] = ArrayMap.this.f(i3);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueCollection implements Collection<V> {
        ValueCollection() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return ArrayMap.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iA = ArrayMap.this.a(obj);
            if (iA < 0) {
                return false;
            }
            ArrayMap.this.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int size = ArrayMap.this.size();
            int i3 = 0;
            boolean z2 = false;
            while (i3 < size) {
                if (collection.contains(ArrayMap.this.j(i3))) {
                    ArrayMap.this.h(i3);
                    i3--;
                    size--;
                    z2 = true;
                }
                i3++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int size = ArrayMap.this.size();
            int i3 = 0;
            boolean z2 = false;
            while (i3 < size) {
                if (!collection.contains(ArrayMap.this.j(i3))) {
                    ArrayMap.this.h(i3);
                    i3--;
                    size--;
                    z2 = true;
                }
                i3++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return ArrayMap.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = ArrayMap.this.size();
            Object[] objArr = new Object[size];
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i3] = ArrayMap.this.j(i3);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i3 = 0; i3 < size; i3++) {
                objArr[i3] = ArrayMap.this.j(i3);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
