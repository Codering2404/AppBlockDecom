package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f59039a = b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f59040b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f59041a;

        static {
            int[] iArr = new int[b.values().length];
            f59041a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59041a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected d() {
    }

    private boolean c() {
        this.f59039a = b.FAILED;
        this.f59040b = a();
        if (this.f59039a == b.DONE) {
            return false;
        }
        this.f59039a = b.READY;
        return true;
    }

    protected abstract Object a();

    protected final Object b() {
        this.f59039a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.checkState(this.f59039a != b.FAILED);
        int i3 = a.f59041a[this.f59039a.ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f59039a = b.NOT_READY;
        Object obj = this.f59040b;
        this.f59040b = null;
        return obj;
    }
}
