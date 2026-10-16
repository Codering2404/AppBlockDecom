package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzejk implements zzhbt {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzejl zzb;

    zzejk(zzejl zzejlVar, boolean z2) {
        this.zza = z2;
        Objects.requireNonNull(zzejlVar);
        this.zzb = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.c("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r9) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzejl r0 = r8.zzb
            android.os.Bundle r9 = (android.os.Bundle) r9
            boolean r1 = r0.zzf()
            if (r1 != 0) goto Lad
            java.lang.String r1 = "ad_types"
            java.lang.Object r1 = r9.get(r1)
            boolean r2 = r1 instanceof java.util.List
            if (r2 == 0) goto L17
            java.util.List r1 = (java.util.List) r1
            goto L21
        L17:
            boolean r2 = r1 instanceof java.lang.String[]
            if (r2 == 0) goto L47
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.List r1 = java.util.Arrays.asList(r1)
        L21:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L2e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L42
            java.lang.Object r3 = r1.next()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L2e
            java.lang.String r3 = (java.lang.String) r3
            r2.add(r3)
            goto L2e
        L42:
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
            goto L49
        L47:
            java.util.List r1 = java.util.Collections.EMPTY_LIST
        L49:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r1 = r1.iterator()
        L52:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L98
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r2.hashCode()
            switch(r3) {
                case -1396342996: goto L87;
                case -1052618729: goto L7c;
                case -239580146: goto L71;
                case 604727084: goto L66;
                default: goto L65;
            }
        L65:
            goto L92
        L66:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L92
            com.google.android.gms.internal.ads.zzbhv$zzd$zza r2 = com.google.android.gms.internal.ads.zzbhv.zzd.zza.INTERSTITIAL
            goto L94
        L71:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L92
            com.google.android.gms.internal.ads.zzbhv$zzd$zza r2 = com.google.android.gms.internal.ads.zzbhv.zzd.zza.REWARD_BASED_VIDEO_AD
            goto L94
        L7c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L92
            com.google.android.gms.internal.ads.zzbhv$zzd$zza r2 = com.google.android.gms.internal.ads.zzbhv.zzd.zza.NATIVE_APP_INSTALL
            goto L94
        L87:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L92
            com.google.android.gms.internal.ads.zzbhv$zzd$zza r2 = com.google.android.gms.internal.ads.zzbhv.zzd.zza.BANNER
            goto L94
        L92:
            com.google.android.gms.internal.ads.zzbhv$zzd$zza r2 = com.google.android.gms.internal.ads.zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED
        L94:
            r5.add(r2)
            goto L52
        L98:
            com.google.android.gms.internal.ads.zzbhv$zzaf$zzd r7 = com.google.android.gms.internal.ads.zzejl.zze(r9)
            com.google.android.gms.internal.ads.zzbhv$zzab r6 = r0.zzb(r9)
            boolean r4 = r8.zza
            com.google.android.gms.internal.ads.zzejj r2 = new com.google.android.gms.internal.ads.zzejj
            r3 = r8
            r2.<init>()
            com.google.android.gms.internal.ads.zzeiz r9 = r0.zza
            r9.zza(r2)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejk.zzb(java.lang.Object):void");
    }
}
