package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1lSDK {
    private final int valueOf;

    public AFc1lSDK(int i3) {
        this.valueOf = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String AFInAppEventType(java.net.HttpURLConnection r3, boolean r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 == 0) goto Lb
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L8
            goto Lf
        L8:
            r3 = move-exception
            r4 = r0
            goto L4f
        Lb:
            java.io.InputStream r3 = r3.getErrorStream()     // Catch: java.lang.Throwable -> L8
        Lf:
            if (r3 != 0) goto L14
            java.lang.String r3 = ""
            return r3
        L14:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8
            r4.<init>()     // Catch: java.lang.Throwable -> L8
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8
            java.nio.charset.Charset r2 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L8
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L8
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L4c
            r0 = 1
        L28:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L41
            if (r0 != 0) goto L3c
            r0 = 10
            r4.append(r0)     // Catch: java.lang.Throwable -> L36
            goto L3c
        L36:
            r4 = move-exception
            r0 = r4
            r4 = r3
            r3 = r0
        L3a:
            r0 = r1
            goto L4f
        L3c:
            r4.append(r2)     // Catch: java.lang.Throwable -> L36
            r0 = 0
            goto L28
        L41:
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L36
            r1.close()
            r3.close()
            return r4
        L4c:
            r3 = move-exception
            r4 = r0
            goto L3a
        L4f:
            if (r0 == 0) goto L54
            r0.close()
        L54:
            if (r4 == 0) goto L59
            r4.close()
        L59:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.AFInAppEventType(java.net.HttpURLConnection, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.appsflyer.internal.AFc1dSDK<java.lang.String> AFKeystoreWrapper(com.appsflyer.internal.AFb1zSDK r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.AFKeystoreWrapper(com.appsflyer.internal.AFb1zSDK):com.appsflyer.internal.AFc1dSDK");
    }
}
