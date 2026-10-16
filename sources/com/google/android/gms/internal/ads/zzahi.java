package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahi implements zzagb {
    private final long zzb;
    private final zzagb zzc;

    public zzahi(long j3, zzagb zzagbVar) {
        this.zzb = j3;
        this.zzc = zzagbVar;
    }

    final /* synthetic */ long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzahk zzu(int i3, int i4) {
        return this.zzc.zzu(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzv() {
        this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzw(zzahb zzahbVar) {
        this.zzc.zzw(new zzahh(this, zzahbVar, zzahbVar));
    }
}
