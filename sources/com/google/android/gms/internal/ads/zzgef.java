package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgef implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgef(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgef zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgef(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        ExecutorService executorService = (ExecutorService) this.zza.zzb();
        zzgdf zzgdfVar = (zzgdf) this.zzb.zzb();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(str2).length() + 1);
        sb.append("Mozilla/5.0 (Linux; Android ");
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        sb.append(")");
        return new zzgek(executorService, sb.toString(), zzgdfVar.zzn());
    }
}
