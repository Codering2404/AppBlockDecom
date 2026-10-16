package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ao extends IntegrityTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f82980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f82981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f82982c = null;

    /* synthetic */ ao(String str, Long l3, Object obj, an anVar) {
        this.f82980a = str;
        this.f82981b = l3;
    }

    private static boolean a() {
        return true;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long cloudProjectNumber() {
        return this.f82981b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.google.android.play.core.integrity.IntegrityTokenRequest
            r2 = 0
            if (r1 == 0) goto L24
            r1 = r6
            com.google.android.play.core.integrity.IntegrityTokenRequest r1 = (com.google.android.play.core.integrity.IntegrityTokenRequest) r1
            java.lang.String r3 = r5.f82980a
            java.lang.String r4 = r1.nonce()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L24
            java.lang.Long r3 = r5.f82981b
            if (r3 != 0) goto L26
            java.lang.Long r1 = r1.cloudProjectNumber()
            if (r1 != 0) goto L24
        L22:
            r1 = r0
            goto L31
        L24:
            r1 = r2
            goto L31
        L26:
            java.lang.Long r1 = r1.cloudProjectNumber()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L24
            goto L22
        L31:
            boolean r6 = r6 instanceof com.google.android.play.core.integrity.ao
            if (r6 == 0) goto L3f
            boolean r6 = a()
            if (r6 == 0) goto L3f
            if (r1 == 0) goto L3e
            return r0
        L3e:
            return r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.ao.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = this.f82980a.hashCode() ^ 1000003;
        Long l3 = this.f82981b;
        int iHashCode2 = (iHashCode * 1000003) ^ (l3 == null ? 0 : l3.hashCode());
        return a() ? iHashCode2 * 1000003 : iHashCode2;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f82980a;
    }

    public final String toString() {
        String strConcat = "IntegrityTokenRequest{nonce=" + this.f82980a + ", cloudProjectNumber=" + this.f82981b;
        if (a()) {
            strConcat = strConcat.concat(", network=null");
        }
        return strConcat.concat("}");
    }
}
