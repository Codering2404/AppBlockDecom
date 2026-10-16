package com.google.android.libraries.places.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzlu {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r2) {
        /*
            r0 = 13
            if (r2 != 0) goto L5
            return r0
        L5:
            int r1 = r2.hashCode()
            switch(r1) {
                case -1698126997: goto L41;
                case -1125000185: goto L36;
                case -813482689: goto L2c;
                case 2524: goto L23;
                case 1023286998: goto L18;
                case 1831775833: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L4c
        Ld:
            java.lang.String r1 = "OVER_QUERY_LIMIT"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
            r2 = 9010(0x2332, float:1.2626E-41)
            return r2
        L18:
            java.lang.String r1 = "NOT_FOUND"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
            r2 = 9013(0x2335, float:1.263E-41)
            return r2
        L23:
            java.lang.String r1 = "OK"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
            goto L34
        L2c:
            java.lang.String r1 = "ZERO_RESULTS"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
        L34:
            r2 = 0
            return r2
        L36:
            java.lang.String r1 = "INVALID_REQUEST"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
            r2 = 9012(0x2334, float:1.2629E-41)
            return r2
        L41:
            java.lang.String r1 = "REQUEST_DENIED"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L4c
            r2 = 9011(0x2333, float:1.2627E-41)
            return r2
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzlu.a(java.lang.String):int");
    }

    public static String b(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
