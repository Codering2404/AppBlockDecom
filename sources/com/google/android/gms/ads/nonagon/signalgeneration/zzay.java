package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzdln;
import com.google.android.gms.internal.ads.zzfor;
import com.google.android.gms.internal.ads.zzfpe;
import com.google.android.gms.internal.ads.zzfpk;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzay implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzind f70697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzind f70698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzind f70699d;

    private zzay(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.f70696a = zzindVar;
        this.f70697b = zzindVar2;
        this.f70698c = zzindVar3;
        this.f70699d = zzindVar4;
    }

    public static zzay a(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzay(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfpk zzfpkVar = (zzfpk) this.f70696a.zzb();
        zzba zzbaVarZzb = ((zzbb) this.f70697b).zzb();
        zzdbw zzdbwVarZzb = ((zzdbx) this.f70698c).zzb();
        zzdln zzdlnVar = (zzdln) this.f70699d.zzb();
        zzfor zzforVarZzi = zzfpkVar.zza(zzfpe.GENERATE_SIGNALS, zzdbwVarZzb.zzb()).zzc(zzbaVarZzb).zzh(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS).zzi();
        zzhbw.zzr(zzforVarZzi, new zzar(zzdlnVar), zzcfr.zza);
        return zzforVarZzi;
    }
}
