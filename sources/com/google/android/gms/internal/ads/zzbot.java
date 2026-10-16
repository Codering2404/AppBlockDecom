package com.google.android.gms.internal.ads;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbot implements zzbpq {
    zzbot() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        try {
            String str = (String) map.get("enabled");
            zzbpq zzbpqVar = zzbpp.zza;
            if (!zzgss.zze(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, str) && !zzgss.zze("false", str)) {
                return;
            }
            zzgch.zza(zzckuVar.getContext()).zzd(Boolean.parseBoolean(str));
        } catch (IOException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
