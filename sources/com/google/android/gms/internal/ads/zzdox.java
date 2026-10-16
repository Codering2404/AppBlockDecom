package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdox implements zzimu {
    private final zzind zza;

    private zzdox(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzdox zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdox(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        VersionInfoParcel versionInfoParcelZza = ((zzcoi) this.zza).zza();
        com.google.android.gms.ads.internal.zzt.g();
        return new zzben(UUID.randomUUID().toString(), versionInfoParcelZza, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, new JSONObject(), false, true);
    }
}
