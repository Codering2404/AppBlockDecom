package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ObjectPool<T extends Poolable> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f68795g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f68796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f68797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f68798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f68799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Poolable f68800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f68801f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Poolable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f68802b = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f68803a = f68802b;

        protected abstract Poolable a();
    }

    private ObjectPool(int i3, Poolable poolable) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.f68797b = i3;
        this.f68798c = new Object[i3];
        this.f68799d = 0;
        this.f68800e = poolable;
        this.f68801f = 1.0f;
        d();
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] (LINE:1) com.github.mikephil.charting.utils.ObjectPool.class) */
    public static synchronized ObjectPool a(int i3, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i3, poolable);
            int i4 = f68795g;
            objectPool.f68796a = i4;
            f68795g = i4 + 1;
        }
        return objectPool;
    }

    private void d() {
        e(this.f68801f);
    }

    private void e(float f3) {
        int i3 = this.f68797b;
        int i4 = (int) (i3 * f3);
        if (i4 < 1) {
            i3 = 1;
        } else if (i4 <= i3) {
            i3 = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.f68798c[i5] = this.f68800e.a();
        }
        this.f68799d = i3 - 1;
    }

    private void f() {
        int i3 = this.f68797b;
        int i4 = i3 * 2;
        this.f68797b = i4;
        Object[] objArr = new Object[i4];
        for (int i5 = 0; i5 < i3; i5++) {
            objArr[i5] = this.f68798c[i5];
        }
        this.f68798c = objArr;
    }

    public synchronized Poolable b() {
        Poolable poolable;
        try {
            if (this.f68799d == -1 && this.f68801f > 0.0f) {
                d();
            }
            Object[] objArr = this.f68798c;
            int i3 = this.f68799d;
            poolable = (Poolable) objArr[i3];
            poolable.f68803a = Poolable.f68802b;
            this.f68799d = i3 - 1;
        } catch (Throwable th) {
            throw th;
        }
        return poolable;
    }

    public synchronized void c(Poolable poolable) {
        try {
            int i3 = poolable.f68803a;
            if (i3 != Poolable.f68802b) {
                if (i3 == this.f68796a) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + poolable.f68803a + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i4 = this.f68799d + 1;
            this.f68799d = i4;
            if (i4 >= this.f68798c.length) {
                f();
            }
            poolable.f68803a = this.f68796a;
            this.f68798c[this.f68799d] = poolable;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v2 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            r2.f68801f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.ObjectPool.g(float):void");
    }
}
