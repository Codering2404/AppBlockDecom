package com.applovin.exoplayer2.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0095b f57963a = EnumC0095b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f57964b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f57965a;

        static {
            int[] iArr = new int[EnumC0095b.values().length];
            f57965a = iArr;
            try {
                iArr[EnumC0095b.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57965a[EnumC0095b.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum EnumC0095b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected b() {
    }

    private boolean c() {
        this.f57963a = EnumC0095b.FAILED;
        this.f57964b = a();
        if (this.f57963a == EnumC0095b.DONE) {
            return false;
        }
        this.f57963a = EnumC0095b.READY;
        return true;
    }

    protected abstract Object a();

    protected final Object b() {
        this.f57963a = EnumC0095b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.checkState(this.f57963a != EnumC0095b.FAILED);
        int i3 = a.f57965a[this.f57963a.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f57963a = EnumC0095b.NOT_READY;
        Object obj = this.f57964b;
        this.f57964b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
