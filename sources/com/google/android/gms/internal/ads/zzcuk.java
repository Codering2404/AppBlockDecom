package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcuk implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzcuk(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzcuk zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcuk(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel versionInfoParcelZza = ((zzcoi) this.zza).zza();
        JSONObject jSONObject = (JSONObject) this.zzb.zzb();
        String str = (String) this.zzc.zzb();
        boolean zEquals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str);
        com.google.android.gms.ads.internal.zzt.g();
        return new zzben(UUID.randomUUID().toString(), versionInfoParcelZza, str, jSONObject, false, zEquals);
    }
}
