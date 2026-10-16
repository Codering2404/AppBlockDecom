package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzbdm extends zzbdk implements zzbey {
    protected zzbdm(zzbdn zzbdnVar) {
        super(zzbdnVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbdk
    protected final void x() {
        super.x();
        if (((zzbdn) this.f76081b).zzb != zzbdg.a()) {
            zzbdn zzbdnVar = (zzbdn) this.f76081b;
            zzbdnVar.zzb = zzbdnVar.zzb.clone();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbdk, com.google.android.libraries.places.internal.zzbew
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final zzbdn zzF() {
        if (!((zzbdn) this.f76081b).v()) {
            return (zzbdn) this.f76081b;
        }
        ((zzbdn) this.f76081b).zzb.b();
        return (zzbdn) super.zzF();
    }
}
