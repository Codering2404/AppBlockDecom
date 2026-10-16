package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f83214a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f83215b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected AbstractIterator() {
    }

    private boolean c() {
        this.f83214a = State.FAILED;
        this.f83215b = a();
        if (this.f83214a == State.DONE) {
            return false;
        }
        this.f83214a = State.READY;
        return true;
    }

    protected abstract Object a();

    protected final Object b() {
        this.f83214a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.z(this.f83214a != State.FAILED);
        int iOrdinal = this.f83214a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f83214a = State.NOT_READY;
        Object objA = NullnessCasts.a(this.f83215b);
        this.f83215b = null;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
