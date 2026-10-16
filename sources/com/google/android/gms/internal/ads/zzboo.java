package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzboo implements zzbpq {
    zzboo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    @Override // com.google.android.gms.internal.ads.zzbpq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r5, java.util.Map r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzcku r5 = (com.google.android.gms.internal.ads.zzcku) r5
            java.lang.String r0 = "appId"
            java.lang.Object r1 = r6.get(r0)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L16
            java.lang.String r5 = "Missing App Id, cannot show LMD Overlay without it"
            com.google.android.gms.ads.internal.util.zze.k(r5)
            return
        L16:
            com.google.android.gms.internal.ads.zzgrs r1 = com.google.android.gms.internal.ads.zzgrt.zzl()
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.zzb(r0)
            int r0 = r5.getWidth()
            r1.zzg(r0)
            android.view.View r0 = r5.zzE()
            android.os.IBinder r0 = r0.getWindowToken()
            r1.zza(r0)
            java.lang.String r0 = "gravityX"
            boolean r2 = r6.containsKey(r0)
            if (r2 == 0) goto L5f
            r2 = 0
            java.lang.String r2 = androidx.glance.color.Tq.KqqtdetwHMIO.CGQgDmaWcWffHx
            boolean r3 = r6.containsKey(r2)
            if (r3 == 0) goto L5f
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r0 = r0 | r2
            r1.zzc(r0)
            goto L64
        L5f:
            r0 = 81
            r1.zzc(r0)
        L64:
            java.lang.String r0 = "verticalMargin"
            boolean r2 = r6.containsKey(r0)
            if (r2 == 0) goto L7a
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            float r0 = java.lang.Float.parseFloat(r0)
            r1.zzd(r0)
            goto L80
        L7a:
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            r1.zzd(r0)
        L80:
            java.lang.String r0 = "enifd"
            boolean r2 = r6.containsKey(r0)
            if (r2 == 0) goto L91
            java.lang.Object r6 = r6.get(r0)
            java.lang.String r6 = (java.lang.String) r6
            r1.zzh(r6)
        L91:
            com.google.android.gms.ads.internal.overlay.zzz r6 = com.google.android.gms.ads.internal.zzt.x()     // Catch: java.lang.NullPointerException -> L9d
            com.google.android.gms.internal.ads.zzgrt r0 = r1.zzi()     // Catch: java.lang.NullPointerException -> L9d
            r6.c(r5, r0)     // Catch: java.lang.NullPointerException -> L9d
            return
        L9d:
            r5 = move-exception
            java.lang.String r6 = "DefaultGmsgHandlers.ShowLMDOverlay"
            com.google.android.gms.internal.ads.zzcfd r0 = com.google.android.gms.ads.internal.zzt.l()
            r0.zzg(r5, r6)
            java.lang.String r5 = "Missing parameters for LMD Overlay show request"
            com.google.android.gms.ads.internal.util.zze.k(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboo.zza(java.lang.Object, java.util.Map):void");
    }
}
