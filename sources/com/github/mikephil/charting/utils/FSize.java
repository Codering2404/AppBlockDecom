package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class FSize extends ObjectPool.Poolable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ObjectPool f68785f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f68786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f68787d;

    static {
        ObjectPool objectPoolA = ObjectPool.a(Function.MAX_NARGS, new FSize(0.0f, 0.0f));
        f68785f = objectPoolA;
        objectPoolA.g(0.5f);
    }

    public FSize(float f3, float f4) {
        this.f68786c = f3;
        this.f68787d = f4;
    }

    public static FSize b(float f3, float f4) {
        FSize fSize = (FSize) f68785f.b();
        fSize.f68786c = f3;
        fSize.f68787d = f4;
        return fSize;
    }

    public static void c(FSize fSize) {
        f68785f.c(fSize);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new FSize(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof FSize) {
            FSize fSize = (FSize) obj;
            if (this.f68786c == fSize.f68786c && this.f68787d == fSize.f68787d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f68786c) ^ Float.floatToIntBits(this.f68787d);
    }

    public String toString() {
        return this.f68786c + "x" + this.f68787d;
    }
}
