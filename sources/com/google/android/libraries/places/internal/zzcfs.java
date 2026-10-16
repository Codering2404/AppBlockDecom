package com.google.android.libraries.places.internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfs extends zzcfj {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient byte[][] f77767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int[] f77768g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcfs(byte[][] segments, int[] directory) {
        super(zzcfj.f77742d.a());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.f77767f = segments;
        this.f77768g = directory;
    }

    private final zzcfj s() {
        return new zzcfj(k());
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcfj) {
            zzcfj zzcfjVar = (zzcfj) obj;
            return zzcfjVar.j() == j() && n(0, zzcfjVar, 0, j());
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final String g() {
        return s().g();
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final zzcfj h() {
        return s().h();
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final int hashCode() {
        int iB = b();
        if (iB != 0) {
            return iB;
        }
        byte[][] bArr = this.f77767f;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr = this.f77768g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            byte[] bArr2 = bArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr2[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        c(i4);
        return i4;
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final byte i(int i3) {
        byte[][] bArr = this.f77767f;
        int length = bArr.length;
        int[] iArr = this.f77768g;
        zzcfb.a(iArr[length - 1], i3, 1L);
        int iA = zzcgb.a(this, i3);
        return bArr[iA][(i3 - (iA == 0 ? 0 : iArr[iA - 1])) + iArr[length + iA]];
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final int j() {
        return this.f77768g[this.f77767f.length - 1];
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final byte[] k() {
        byte[] bArr = new byte[j()];
        byte[][] bArr2 = this.f77767f;
        int length = bArr2.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr = this.f77768g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = i7 - i4;
            ArraysKt.copyInto(bArr2[i3], bArr, i5, i6, i6 + i8);
            i5 += i8;
            i3++;
            i4 = i7;
        }
        return bArr;
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final byte[] l() {
        return k();
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final void m(zzcff buffer, int i3, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iA = zzcgb.a(this, 0);
        int i6 = 0;
        while (i6 < i4) {
            if (iA == 0) {
                iA = 0;
                i5 = 0;
            } else {
                i5 = this.f77768g[iA - 1];
            }
            int[] iArr = this.f77768g;
            int i7 = iArr[iA] - i5;
            byte[][] bArr = this.f77767f;
            int i8 = iArr[bArr.length + iA];
            int iMin = Math.min(i4, i7 + i5) - i6;
            int i9 = i8 + (i6 - i5);
            zzcfq zzcfqVar = new zzcfq(bArr[iA], i9, i9 + iMin, true, false);
            zzcfq zzcfqVar2 = buffer.f77740a;
            if (zzcfqVar2 == null) {
                zzcfqVar.f77763g = zzcfqVar;
                zzcfqVar.f77762f = zzcfqVar;
                buffer.f77740a = zzcfqVar;
            } else {
                Intrinsics.checkNotNull(zzcfqVar2);
                zzcfq zzcfqVar3 = zzcfqVar2.f77763g;
                Intrinsics.checkNotNull(zzcfqVar3);
                zzcfqVar3.c(zzcfqVar);
            }
            i6 += iMin;
            iA++;
        }
        buffer.zzd(buffer.zzb() + ((long) i4));
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final boolean n(int i3, zzcfj other, int i4, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(other, "other");
        if (j() - i5 < 0) {
            return false;
        }
        int iA = zzcgb.a(this, 0);
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            if (iA == 0) {
                iA = 0;
                i6 = 0;
            } else {
                i6 = this.f77768g[iA - 1];
            }
            int[] iArr = this.f77768g;
            int i9 = iArr[iA] - i6;
            byte[][] bArr = this.f77767f;
            int i10 = iArr[bArr.length + iA];
            int iMin = Math.min(i5, i9 + i6) - i7;
            if (!other.o(i8, bArr[iA], i10 + (i7 - i6), iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iA++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final boolean o(int i3, byte[] other, int i4, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0 || i3 > j() - i5 || i4 < 0 || i4 > other.length - i5) {
            return false;
        }
        int i7 = i5 + i3;
        int iA = zzcgb.a(this, i3);
        while (i3 < i7) {
            if (iA == 0) {
                iA = 0;
                i6 = 0;
            } else {
                i6 = this.f77768g[iA - 1];
            }
            int[] iArr = this.f77768g;
            int i8 = iArr[iA] - i6;
            byte[][] bArr = this.f77767f;
            int i9 = iArr[bArr.length + iA];
            int iMin = Math.min(i7, i8 + i6) - i3;
            if (!zzcfb.b(bArr[iA], i9 + (i3 - i6), other, i4, iMin)) {
                return false;
            }
            i4 += iMin;
            i3 += iMin;
            iA++;
        }
        return true;
    }

    public final byte[][] q() {
        return this.f77767f;
    }

    public final int[] r() {
        return this.f77768g;
    }

    @Override // com.google.android.libraries.places.internal.zzcfj
    public final String toString() {
        return s().toString();
    }
}
