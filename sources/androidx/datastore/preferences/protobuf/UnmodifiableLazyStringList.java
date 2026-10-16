package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyStringList f36642a;

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public void K1(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i3) {
        return this.f36642a.get(i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new Iterator<String>() { // from class: androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Iterator f36646a;

            {
                this.f36646a = UnmodifiableLazyStringList.this.f36642a.iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String next() {
                return (String) this.f36646a.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f36646a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public List k() {
        return this.f36642a.k();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        return new ListIterator<String>(i3) { // from class: androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ListIterator f36643a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f36644b;

            {
                this.f36644b = i3;
                this.f36643a = UnmodifiableLazyStringList.this.f36642a.listIterator(i3);
            }

            @Override // java.util.ListIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public String next() {
                return (String) this.f36643a.next();
            }

            @Override // java.util.ListIterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String previous() {
                return (String) this.f36643a.previous();
            }

            @Override // java.util.ListIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f36643a.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f36643a.hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f36643a.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f36643a.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public Object r(int i3) {
        return this.f36642a.r(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36642a.size();
    }
}
