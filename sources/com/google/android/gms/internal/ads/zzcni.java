package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcni implements zzbak {
    private final Context zza;
    private final zzgda zzb;

    zzcni(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdD)).intValue();
        int i3 = iIntValue != 1 ? (iIntValue == 2 || iIntValue != 3) ? 3 : 4 : 2;
        zzgdw zzgdwVarZze = zzgdx.zze();
        zzgdwVarZze.zza(((Float) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdJ)).floatValue());
        zzgdx zzgdxVar = (zzgdx) zzgdwVarZze.zzbu();
        zzgdy zzgdyVarZzi = zzgdz.zzi();
        zzgdyVarZzi.zza(((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdK)).booleanValue());
        zzgdyVarZzi.zzb(((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdM)).longValue());
        zzgdz zzgdzVar = (zzgdz) zzgdyVarZzi.zzbu();
        zzgdd zzgddVarZzw = zzgdf.zzw();
        zzgddVarZzw.zzi(i3);
        zzgddVarZzw.zzb(versionInfoParcel.f70149a);
        zzgddVarZzw.zzj(3);
        zzgddVarZzw.zza(((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdk)).booleanValue());
        zzgddVarZzw.zzh(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdA)).intValue() == -1);
        zzgddVarZzw.zzg(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdC)).intValue());
        zzgddVarZzw.zze(((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdL)).longValue());
        zzgddVarZzw.zzd(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdB)).intValue());
        zzgddVarZzw.zzc(zzgdxVar);
        zzgddVarZzw.zzf(zzgdzVar);
        zzgda zzgdaVarZza = zzgda.zza(context, zzcfr.zza, (zzgdf) zzgddVarZzw.zzbu());
        this.zzb = zzgdaVarZza;
        zzgdaVarZza.zzb();
    }

    public final String zza() {
        int iZzh = this.zzb.zzh() - 1;
        return iZzh != 1 ? iZzh != 2 ? iZzh != 3 ? "uns" : "3.0" : "2.0" : "1.0";
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzd(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.zzb.zzg(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    @Deprecated
    public final void zze(int i3, int i4, int i5) {
        com.google.android.gms.ads.internal.client.zzay.a();
        Context context = this.zza;
        float fE = com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
        com.google.android.gms.ads.internal.client.zzay.a();
        float fE2 = com.google.android.gms.ads.internal.util.client.zzf.e(context, i4);
        zzgda zzgdaVar = this.zzb;
        long j3 = i5;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, j3, 0, fE, fE2, 0);
        zzgdaVar.zzg(motionEventObtain);
        motionEventObtain.recycle();
        com.google.android.gms.ads.internal.client.zzay.a();
        float fE3 = com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
        com.google.android.gms.ads.internal.client.zzay.a();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, j3, 2, fE3, com.google.android.gms.ads.internal.util.client.zzf.e(context, i4), 0);
        zzgdaVar.zzg(motionEventObtain2);
        motionEventObtain2.recycle();
        com.google.android.gms.ads.internal.client.zzay.a();
        float fE4 = com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
        com.google.android.gms.ads.internal.client.zzay.a();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, j3, 1, fE4, com.google.android.gms.ads.internal.util.client.zzf.e(context, i4), 0);
        zzgdaVar.zzg(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzf(Context context, String str, View view, Activity activity) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzg(Context context, String str, View view) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        this.zzb.zzf(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzj(Context context, View view, Activity activity) {
        return this.zzb.zzd(context, null, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzk(Context context) {
        return this.zzb.zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzl(Context context) {
        return this.zzb.zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzh(View view) {
    }
}
