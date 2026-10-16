package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient ImmutableList f83790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int[] f83791b;

    /* JADX INFO: Access modifiers changed from: private */
    public int e(int i3, int i4) {
        return (i3 / this.f83791b[i4 + 1]) % ((List) this.f83790a.get(i4)).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != this.f83790a.size()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!((List) this.f83790a.get(i3)).contains(it.next())) {
                return false;
            }
            i3++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImmutableList get(final int i3) {
        Preconditions.r(i3, size());
        return new ImmutableList<E>(this) { // from class: com.google.common.collect.CartesianList.1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ CartesianList f83793d;

            {
                this.f83793d = this;
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean g() {
                return true;
            }

            @Override // java.util.List
            public Object get(int i4) {
                Preconditions.r(i4, size());
                return ((List) this.f83793d.f83790a.get(i4)).get(this.f83793d.e(i3, i4));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.f83793d.f83790a.size();
            }

            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f83790a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i3 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iIndexOf = ((List) this.f83790a.get(iNextIndex)).indexOf(listIterator.next());
            if (iIndexOf == -1) {
                return -1;
            }
            i3 += iIndexOf * this.f83791b[iNextIndex + 1];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f83790a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i3 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iLastIndexOf = ((List) this.f83790a.get(iNextIndex)).lastIndexOf(listIterator.next());
            if (iLastIndexOf == -1) {
                return -1;
            }
            i3 += iLastIndexOf * this.f83791b[iNextIndex + 1];
        }
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f83791b[0];
    }
}
