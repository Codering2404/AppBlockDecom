package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeim implements zzfok {
    protected final Context zza;
    protected final String zzb;
    private final String zzc;

    public zzeim(Context context, String str, zzcbl zzcblVar, int i3, String str2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeil zza(zzeik zzeikVar) throws zzeed {
        return zzc(zzeikVar.zza, zzeikVar.zzb, zzeikVar.zzc, zzeikVar.zzd, zzeikVar.zze, com.google.android.gms.ads.internal.zzt.o().a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x029a, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bd, code lost:
    
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023f, code lost:
    
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 35);
        r3.append("Received error HTTP response code: ");
        r3.append(r0);
        com.google.android.gms.ads.internal.util.client.zzo.f(r3.toString());
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 35);
        r4.append("Received error HTTP response code: ");
        r4.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0279, code lost:
    
        throw new com.google.android.gms.internal.ads.zzeed(1, r4.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzeil zzc(java.lang.String r19, int r20, java.util.Map r21, byte[] r22, java.lang.String r23, long r24) throws java.net.MalformedURLException, com.google.android.gms.internal.ads.zzeed {
        /*
            Method dump skipped, instruction units count: 697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeim.zzc(java.lang.String, int, java.util.Map, byte[], java.lang.String, long):com.google.android.gms.internal.ads.zzeil");
    }
}
