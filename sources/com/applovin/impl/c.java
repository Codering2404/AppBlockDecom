package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class c extends qp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f58791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f58792b;

    protected c(int i3, int i4) {
        Preconditions.checkPositionIndex(i4, i3);
        this.f58791a = i3;
        this.f58792b = i4;
    }

    protected abstract Object a(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f58792b < this.f58791a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f58792b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f58792b;
        this.f58792b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f58792b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f58792b - 1;
        this.f58792b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f58792b - 1;
    }
}
