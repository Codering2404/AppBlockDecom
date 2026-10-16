package com.google.android.libraries.places.internal;

import com.facebook.internal.Utility;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f77757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f77758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f77760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f77761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zzcfq f77762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzcfq f77763g;

    public zzcfq() {
        this.f77757a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f77761e = true;
        this.f77760d = false;
    }

    public final zzcfq a() {
        this.f77760d = true;
        return new zzcfq(this.f77757a, this.f77758b, this.f77759c, true, false);
    }

    public final zzcfq b() {
        zzcfq zzcfqVar = this.f77762f;
        if (zzcfqVar == this) {
            zzcfqVar = null;
        }
        zzcfq zzcfqVar2 = this.f77763g;
        Intrinsics.checkNotNull(zzcfqVar2);
        zzcfqVar2.f77762f = this.f77762f;
        zzcfq zzcfqVar3 = this.f77762f;
        Intrinsics.checkNotNull(zzcfqVar3);
        zzcfqVar3.f77763g = this.f77763g;
        this.f77762f = null;
        this.f77763g = null;
        return zzcfqVar;
    }

    public final zzcfq c(zzcfq segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f77763g = this;
        segment.f77762f = this.f77762f;
        zzcfq zzcfqVar = this.f77762f;
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfqVar.f77763g = segment;
        this.f77762f = segment;
        return segment;
    }

    public final zzcfq d(int i3) {
        zzcfq zzcfqVarA;
        if (i3 > this.f77759c - this.f77758b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i3 >= 1024) {
            zzcfqVarA = a();
        } else {
            byte[] bArr = this.f77757a;
            zzcfqVarA = zzcfr.a();
            byte[] bArr2 = zzcfqVarA.f77757a;
            int i4 = this.f77758b;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
        }
        zzcfqVarA.f77759c = zzcfqVarA.f77758b + i3;
        this.f77758b += i3;
        zzcfq zzcfqVar = this.f77763g;
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfqVar.c(zzcfqVarA);
        return zzcfqVarA;
    }

    public final void e(zzcfq sink, int i3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.f77761e) {
            throw new IllegalStateException("only owner can write");
        }
        int i4 = sink.f77759c;
        int i5 = i4 + i3;
        if (i5 > 8192) {
            if (sink.f77760d) {
                throw new IllegalArgumentException();
            }
            int i6 = sink.f77758b;
            if (i5 - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f77757a;
            ArraysKt.copyInto$default(bArr, bArr, 0, i6, i4, 2, (Object) null);
            i4 = sink.f77759c - sink.f77758b;
            sink.f77759c = i4;
            sink.f77758b = 0;
        }
        byte[] bArr2 = this.f77757a;
        byte[] bArr3 = sink.f77757a;
        int i7 = this.f77758b;
        ArraysKt.copyInto(bArr2, bArr3, i4, i7, i7 + i3);
        sink.f77759c += i3;
        this.f77758b += i3;
    }

    public zzcfq(byte[] data, int i3, int i4, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f77757a = data;
        this.f77758b = i3;
        this.f77759c = i4;
        this.f77760d = z2;
        this.f77761e = false;
    }
}
