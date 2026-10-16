package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f77736a;

    static {
        zzcfj zzcfjVar = zzcfj.f77742d;
        f77736a = zzcfi.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").a();
        zzcfi.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }

    public static /* synthetic */ String a(byte[] bArr, byte[] bArr2, int i3, Object obj) {
        byte[] map = f77736a;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        int length = bArr.length;
        int i4 = length + 2;
        int i5 = length - (length % 3);
        byte[] bArr3 = new byte[(i4 / 3) * 4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = i7 + 3;
            byte b3 = bArr[i6];
            int i9 = i6 + 2;
            byte b4 = bArr[i6 + 1];
            i6 += 3;
            byte b5 = bArr[i9];
            bArr3[i7] = map[(b3 & 255) >> 2];
            bArr3[i7 + 1] = map[((b3 & 3) << 4) | ((b4 & 255) >> 4)];
            bArr3[i7 + 2] = map[((b4 & Ascii.SI) << 2) | ((b5 & 255) >> 6)];
            i7 += 4;
            bArr3[i8] = map[b5 & 63];
        }
        int length2 = bArr.length - i5;
        if (length2 == 1) {
            byte b6 = bArr[i6];
            bArr3[i7] = map[(b6 & 255) >> 2];
            bArr3[i7 + 1] = map[(b6 & 3) << 4];
            bArr3[i7 + 2] = 61;
            bArr3[i7 + 3] = 61;
        } else if (length2 == 2) {
            int i10 = i6 + 1;
            byte b7 = bArr[i6];
            byte b8 = bArr[i10];
            bArr3[i7] = map[(b7 & 255) >> 2];
            bArr3[i7 + 1] = map[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr3[i7 + 2] = map[(b8 & Ascii.SI) << 2];
            bArr3[i7 + 3] = 61;
        }
        return zzcfy.a(bArr3);
    }
}
