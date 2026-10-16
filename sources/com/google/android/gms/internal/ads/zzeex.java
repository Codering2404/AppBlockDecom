package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeex implements zzimu {
    private final zzind zza;

    private zzeex(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeex zza(zzind zzindVar) {
        return new zzeex(zzindVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ java.lang.Object zzb() {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzind r0 = r4.zza
            com.google.android.gms.internal.ads.zzdci r0 = (com.google.android.gms.internal.ads.zzdci) r0
            com.google.android.gms.internal.ads.zzfky r0 = r0.zza()
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzil
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L4d
            com.google.android.gms.ads.internal.client.zzm r1 = r0.zzd
            java.lang.String r1 = r1.f69987y
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "request_id"
            if (r2 != 0) goto L36
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L36
            r2.<init>(r1)     // Catch: org.json.JSONException -> L36
            java.lang.String r1 = r2.getString(r3)     // Catch: org.json.JSONException -> L36
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L36
            if (r2 != 0) goto L36
            goto L5d
        L36:
            com.google.android.gms.ads.internal.client.zzm r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.f69982t
            if (r0 == 0) goto L4d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = r0.f69846a     // Catch: org.json.JSONException -> L4d
            r1.<init>(r0)     // Catch: org.json.JSONException -> L4d
            java.lang.String r1 = r1.getString(r3)     // Catch: org.json.JSONException -> L4d
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L4d
            if (r0 == 0) goto L5d
        L4d:
            java.util.Random r0 = com.google.android.gms.ads.internal.client.zzay.h()
            int r0 = r0.nextInt()
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0 = r0 & r1
            java.lang.String r1 = java.lang.String.valueOf(r0)
        L5d:
            com.google.android.gms.internal.ads.zzinc.zzb(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeex.zzb():java.lang.Object");
    }
}
