package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaf implements zzdf {
    final /* synthetic */ zzak zza;

    @Override // com.google.android.gms.tagmanager.zzdf
    public final void zza(int i3) {
        if (i3 == 4) {
            this.zza.zzi.zzc();
        }
        synchronized (this.zza) {
            try {
                if (!this.zza.isReady()) {
                    if (this.zza.zzl != null) {
                        zzak zzakVar = this.zza;
                        zzakVar.setResult(zzakVar.zzl);
                    } else {
                        zzak zzakVar2 = this.zza;
                        zzakVar2.setResult(zzakVar2.createFailedResult(Status.f71540j));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzr(this.zza.zzi.zzb());
    }
}
