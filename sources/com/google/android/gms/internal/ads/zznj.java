package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zznj {
    private final zzjt zza;

    @Deprecated
    public zznj(Context context, zznf zznfVar) {
        this.zza = new zzjt(context, zznfVar);
    }

    @Deprecated
    public final zznj zza(final zzabh zzabhVar) {
        zzjt zzjtVar = this.zza;
        zzgtj.zzi(!zzjtVar.zzw);
        zzabhVar.getClass();
        zzjtVar.zze = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjq
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i3 = zzjt.zzA;
                return zzabhVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zznj zzb(final zzly zzlyVar) {
        zzjt zzjtVar = this.zza;
        zzgtj.zzi(!zzjtVar.zzw);
        zzlyVar.getClass();
        zzjtVar.zzf = new zzgub() { // from class: com.google.android.gms.internal.ads.zzjr
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                int i3 = zzjt.zzA;
                return zzlyVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zznk zzc() {
        zzjt zzjtVar = this.zza;
        zzgtj.zzi(!zzjtVar.zzw);
        zzjtVar.zzw = true;
        return new zznk(zzjtVar);
    }
}
