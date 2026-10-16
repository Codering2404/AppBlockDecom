package com.google.android.libraries.places.internal;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcde {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f77652a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f77653b = new String[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f77654c = new String[Function.MAX_NARGS];

    static {
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            f77654c[i4] = String.format("%8s", Integer.toBinaryString(i4)).replace(' ', '0');
        }
        String[] strArr = f77653b;
        strArr[0] = "";
        strArr[1] = "END_STREAM";
        int[] iArr = {1};
        strArr[8] = "PADDED";
        for (int i5 = 0; i5 <= 0; i5++) {
            int i6 = iArr[i5];
            String[] strArr2 = f77653b;
            strArr2[i6 | 8] = String.valueOf(strArr2[i6]).concat("|PADDED");
        }
        String[] strArr3 = f77653b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i7 = 0;
        while (i7 < 3) {
            int i8 = iArr2[i7];
            for (int i9 = i3; i9 <= 0; i9++) {
                int i10 = iArr[i9];
                int i11 = i10 | i8;
                String[] strArr4 = f77653b;
                String str = strArr4[i10];
                String str2 = strArr4[i8];
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
                sb.append(str);
                sb.append("|");
                sb.append(str2);
                strArr4[i11] = sb.toString();
                int i12 = i11 | 8;
                String str3 = strArr4[i10];
                String str4 = strArr4[i8];
                StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length() + 7);
                sb2.append(str3);
                sb2.append("|");
                sb2.append(str4);
                sb2.append("|PADDED");
                strArr4[i12] = sb2.toString();
            }
            i7++;
            i3 = 0;
        }
        for (int i13 = 0; i13 < 64; i13++) {
            String[] strArr5 = f77653b;
            if (strArr5[i13] == null) {
                strArr5[i13] = f77654c[i13];
            }
        }
    }

    zzcde() {
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(boolean r5, int r6, int r7, byte r8, byte r9) {
        /*
            r0 = 10
            if (r8 >= r0) goto L9
            java.lang.String[] r0 = com.google.android.libraries.places.internal.zzcde.f77652a
            r0 = r0[r8]
            goto L17
        L9:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r8)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "0x%02x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
        L17:
            r1 = 1
            if (r9 != 0) goto L1d
            java.lang.String r8 = ""
            goto L6c
        L1d:
            r2 = 2
            if (r8 == r2) goto L68
            r2 = 3
            if (r8 == r2) goto L68
            r2 = 4
            if (r8 == r2) goto L5e
            r3 = 6
            if (r8 == r3) goto L5e
            r3 = 7
            if (r8 == r3) goto L68
            r3 = 8
            if (r8 == r3) goto L68
            r3 = 64
            if (r9 >= r3) goto L39
            java.lang.String[] r3 = com.google.android.libraries.places.internal.zzcde.f77653b
            r3 = r3[r9]
            goto L3d
        L39:
            java.lang.String[] r3 = com.google.android.libraries.places.internal.zzcde.f77654c
            r3 = r3[r9]
        L3d:
            r4 = 5
            if (r8 != r4) goto L4d
            r8 = r9 & 4
            if (r8 == 0) goto L5c
            java.lang.String r8 = "HEADERS"
            java.lang.String r9 = "PUSH_PROMISE"
            java.lang.String r8 = r3.replace(r8, r9)
            goto L6c
        L4d:
            if (r8 != 0) goto L5c
            r8 = r9 & 32
            if (r8 == 0) goto L5c
            java.lang.String r8 = "PRIORITY"
            java.lang.String r9 = "COMPRESSED"
            java.lang.String r8 = r3.replace(r8, r9)
            goto L6c
        L5c:
            r8 = r3
            goto L6c
        L5e:
            if (r9 != r1) goto L63
            java.lang.String r8 = "ACK"
            goto L6c
        L63:
            java.lang.String[] r8 = com.google.android.libraries.places.internal.zzcde.f77654c
            r8 = r8[r9]
            goto L6c
        L68:
            java.lang.String[] r8 = com.google.android.libraries.places.internal.zzcde.f77654c
            r8 = r8[r9]
        L6c:
            java.util.Locale r9 = java.util.Locale.US
            if (r1 == r5) goto L73
            java.lang.String r5 = ">>"
            goto L75
        L73:
            java.lang.String r5 = "<<"
        L75:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6, r7, r0, r8}
            java.lang.String r6 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r5 = java.lang.String.format(r9, r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcde.a(boolean, int, int, byte, byte):java.lang.String");
    }
}
