package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfb {
    public static final void a(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            int length = String.valueOf(j3).length();
            StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(j4).length() + 11 + String.valueOf(j5).length());
            sb.append("size=");
            sb.append(j3);
            sb.append(" offset=");
            sb.append(j4);
            sb.append(" byteCount=");
            sb.append(j5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
    }

    public static final boolean b(byte[] a3, int i3, byte[] b3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(a3, "a");
        Intrinsics.checkNotNullParameter(b3, "b");
        for (int i6 = 0; i6 < i5; i6++) {
            if (a3[i6 + i3] != b3[i6 + i4]) {
                return false;
            }
        }
        return true;
    }

    public static final String c(int i3) {
        int i4 = 0;
        char[] cArr = {zzcga.a()[i3 >> 28], zzcga.a()[(i3 >> 24) & 15], zzcga.a()[(i3 >> 20) & 15], zzcga.a()[(i3 >> 16) & 15], zzcga.a()[(i3 >> 12) & 15], zzcga.a()[(i3 >> 8) & 15], zzcga.a()[(i3 >> 4) & 15], zzcga.a()[i3 & 15]};
        while (i4 < 8 && cArr[i4] == '0') {
            i4++;
        }
        return StringsKt.z(cArr, i4, 8);
    }
}
