package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UnsignedLong f85521b = new UnsignedLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UnsignedLong f85522c = new UnsignedLong(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UnsignedLong f85523d = new UnsignedLong(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f85524a;

    private UnsignedLong(long j3) {
        this.f85524a = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.t(unsignedLong);
        return UnsignedLongs.a(this.f85524a, unsignedLong.f85524a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j3 = this.f85524a;
        if (j3 >= 0) {
            return j3;
        }
        return ((j3 & 1) | (j3 >>> 1)) * 2.0d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.f85524a == ((UnsignedLong) obj).f85524a;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j3 = this.f85524a;
        if (j3 >= 0) {
            return j3;
        }
        return ((j3 & 1) | (j3 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        return Longs.e(this.f85524a);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.f85524a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f85524a;
    }

    public String toString() {
        return UnsignedLongs.e(this.f85524a);
    }
}
