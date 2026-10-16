package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgjc extends zzgix {
    private final DisplayMetrics zza;
    private final View zzb;

    zzgjc(zzaxm zzaxmVar, zzght zzghtVar, DisplayMetrics displayMetrics, View view, zzgqh zzgqhVar) {
        super("vv376EC8RwpMxMmfATqMVweHyPhjqO5Qlm7WPZKD2npMq6jNCymiQXlS7PGFwNKe", "PixIPnnEkiaTW1Va/iznvLY8lrCk4xSlXLHjlbwwIbo=", zzaxmVar, zzghtVar, zzgqhVar.zza(124));
        this.zza = displayMetrics;
        this.zzb = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        View view = this.zzb;
        if (view == null) {
            return;
        }
        Object objInvoke = method.invoke("", this.zza, view);
        objInvoke.getClass();
        Long[] lArr = (Long[]) objInvoke;
        zzayk zzaykVarZza = zzayl.zza();
        zzaykVarZza.zzb(lArr[2].longValue());
        zzaykVarZza.zzc(lArr[1].longValue());
        zzaykVarZza.zzd(lArr[0].longValue());
        zzaykVarZza.zza(lArr[3].longValue());
        zzaykVarZza.zze(lArr[4].longValue());
        zzaxmVar.zzM((zzayl) zzaykVarZza.zzbu());
    }
}
