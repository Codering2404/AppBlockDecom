package com.google.common.primitives;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UnsignedInteger f85515b = b(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UnsignedInteger f85516c = b(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UnsignedInteger f85517d = b(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f85518a;

    private UnsignedInteger(int i3) {
        this.f85518a = i3;
    }

    public static UnsignedInteger b(int i3) {
        return new UnsignedInteger(i3);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.t(unsignedInteger);
        return UnsignedInts.a(this.f85518a, unsignedInteger.f85518a);
    }

    public String c(int i3) {
        return UnsignedInts.e(this.f85518a, i3);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedInteger) && this.f85518a == ((UnsignedInteger) obj).f85518a;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.f85518a;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f85518a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.d(this.f85518a);
    }

    public String toString() {
        return c(10);
    }
}
