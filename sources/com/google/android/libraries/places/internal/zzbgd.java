package com.google.android.libraries.places.internal;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbgd extends zzbge {
    zzbgd(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final void a(Object obj, long j3, byte b3) {
        if (zzbgf.f76185h) {
            zzbgf.d(obj, j3, b3);
        } else {
            zzbgf.e(obj, j3, b3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final boolean b(Object obj, long j3) {
        return zzbgf.f76185h ? zzbgf.z(obj, j3) : zzbgf.A(obj, j3);
    }

    /* JADX WARN: Failed to inline method: com.google.android.libraries.places.internal.zzbgf.B(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.libraries.places.internal.zzbgf.C(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z2' boolean)' in method call: com.google.android.libraries.places.internal.zzbgf.B(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z2' boolean)' in method call: com.google.android.libraries.places.internal.zzbgf.C(java.lang.Object, long, boolean):void */
    @Override // com.google.android.libraries.places.internal.zzbge
    public final void c(Object obj, long j3, boolean z2) {
        if (zzbgf.f76185h) {
            zzbgf.B(obj, j3, z2);
        } else {
            zzbgf.C(obj, j3, z2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final float d(Object obj, long j3) {
        return Float.intBitsToFloat(this.f76177a.getInt(obj, j3));
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final void e(Object obj, long j3, float f3) {
        this.f76177a.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final double f(Object obj, long j3) {
        return Double.longBitsToDouble(this.f76177a.getLong(obj, j3));
    }

    @Override // com.google.android.libraries.places.internal.zzbge
    public final void g(Object obj, long j3, double d3) {
        this.f76177a.putLong(obj, j3, Double.doubleToLongBits(d3));
    }
}
