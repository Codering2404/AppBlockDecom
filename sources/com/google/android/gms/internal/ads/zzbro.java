package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbro implements zzasx {
    private volatile zzbrb zza;
    private final Context zzb;

    public zzbro(Context context) {
        this.zzb = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzasx
    public final zzata zza(zzate zzateVar) throws zzatn {
        Parcelable.Creator<zzbrc> creator = zzbrc.CREATOR;
        Map mapZzm = zzateVar.zzm();
        int size = mapZzm.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i3 = 0;
        for (Map.Entry entry : mapZzm.entrySet()) {
            strArr[i3] = (String) entry.getKey();
            strArr2[i3] = (String) entry.getValue();
            i3++;
        }
        zzbrc zzbrcVar = new zzbrc(zzateVar.zzh(), strArr, strArr2);
        long jA = com.google.android.gms.ads.internal.zzt.o().a();
        try {
            zzcfw zzcfwVar = new zzcfw();
            this.zza = new zzbrb(this.zzb, com.google.android.gms.ads.internal.zzt.w().a(), new zzbrm(this, zzcfwVar), new zzbrn(this, zzcfwVar));
            this.zza.checkAvailabilityAndConnect();
            zzbrk zzbrkVar = new zzbrk(this, zzbrcVar);
            zzhcg zzhcgVar = zzcfr.zza;
            ListenableFuture listenableFutureZzi = zzhbw.zzi(zzhbw.zzj(zzcfwVar, zzbrkVar, zzhcgVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfs)).intValue(), TimeUnit.MILLISECONDS, zzcfr.zzd);
            listenableFutureZzi.addListener(new zzbrl(this), zzhcgVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) listenableFutureZzi.get();
            long jA2 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
            StringBuilder sb = new StringBuilder(String.valueOf(jA2).length() + 32);
            sb.append("Http assets remote cache took ");
            sb.append(jA2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            zzbre zzbreVar = (zzbre) new zzcbb(parcelFileDescriptor).zza(zzbre.CREATOR);
            if (zzbreVar == null) {
                return null;
            }
            if (zzbreVar.zza) {
                throw new zzatn(zzbreVar.zzb);
            }
            String[] strArr3 = zzbreVar.zze;
            String[] strArr4 = zzbreVar.zzf;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i4 = 0; i4 < strArr3.length; i4++) {
                map.put(strArr3[i4], strArr4[i4]);
            }
            return new zzata(zzbreVar.zzc, zzbreVar.zzd, map, zzbreVar.zzg, zzbreVar.zzh);
        } catch (InterruptedException | ExecutionException unused) {
            long jA3 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
            StringBuilder sb2 = new StringBuilder(String.valueOf(jA3).length() + 32);
            sb2.append("Http assets remote cache took ");
            sb2.append(jA3);
            sb2.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
            return null;
        } catch (Throwable th) {
            long jA4 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
            StringBuilder sb3 = new StringBuilder(String.valueOf(jA4).length() + 32);
            sb3.append("Http assets remote cache took ");
            sb3.append(jA4);
            sb3.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
            throw th;
        }
    }

    final /* synthetic */ void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zza.disconnect();
        Binder.flushPendingCommands();
    }

    final /* synthetic */ zzbrb zzc() {
        return this.zza;
    }
}
