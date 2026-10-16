package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdcm {
    public static final zzcdn zza(Context context, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, zzcdj zzcdjVar) {
        zzcdk zzcdkVar = zzfkfVar.zzA;
        if (zzcdkVar == null) {
            return null;
        }
        zzfkk zzfkkVar = zzfkfVar.zzs;
        return new zzcdi(context, versionInfoParcel, zzcdkVar, zzfkkVar != null ? zzfkkVar.zzb : null, zzcdjVar);
    }
}
