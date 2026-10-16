package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbum implements zzbty {
    private final zzbua zza;
    private final zzbub zzb;
    private final zzbtu zzc;
    private final String zzd;

    zzbum(zzbtu zzbtuVar, String str, zzbub zzbubVar, zzbua zzbuaVar) {
        this.zzc = zzbtuVar;
        this.zzd = str;
        this.zzb = zzbubVar;
        this.zza = zzbuaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbty
    public final ListenableFuture zzb(Object obj) {
        zzcfw zzcfwVar = new zzcfw();
        zzbto zzbtoVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.k("callJs > getEngine: Promise created");
        zzbtoVarZzb.zze(new zzbuj(this, zzbtoVarZzb, obj, zzcfwVar), new zzbuk(this, zzcfwVar, zzbtoVarZzb));
        return zzcfwVar;
    }

    final /* synthetic */ void zzc(zzbto zzbtoVar, zzbtv zzbtvVar, Object obj, zzcfw zzcfwVar) {
        try {
            com.google.android.gms.ads.internal.zzt.g();
            String string = UUID.randomUUID().toString();
            zzbpp.zzo.zzb(string, new zzbul(this, zzbtoVar, zzcfwVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", this.zzb.zzb(obj));
            zzbtvVar.zzb(this.zzd, jSONObject);
        } catch (Exception e3) {
            try {
                zzcfwVar.zzd(e3);
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to invokeJavascript", e3);
            } finally {
                zzbtoVar.zza();
            }
        }
    }

    final /* synthetic */ zzbua zzd() {
        return this.zza;
    }
}
