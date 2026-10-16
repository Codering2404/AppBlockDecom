package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f83682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f83683b;

    protected AbstractIndexedListIterator(int i3) {
        this(i3, 0);
    }

    protected abstract Object a(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f83683b < this.f83682a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f83683b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f83683b;
        this.f83683b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f83683b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f83683b - 1;
        this.f83683b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f83683b - 1;
    }

    protected AbstractIndexedListIterator(int i3, int i4) {
        Preconditions.w(i4, i3);
        this.f83682a = i3;
        this.f83683b = i4;
    }
}
