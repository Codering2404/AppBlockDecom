package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzicl implements zzifx {
    static {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzifx
    public final /* synthetic */ Object zza(InputStream inputStream, zzido zzidoVar) throws zziet {
        zzigs zzigsVarZzaU;
        zzide zzideVarZzH = zzide.zzH(inputStream, 4096);
        zzifp zzifpVar = (zzifp) zzb(zzideVarZzH, zzidoVar);
        zzideVarZzH.zzb(0);
        if (zzifpVar == null || zzifpVar.zzbi()) {
            return zzifpVar;
        }
        if (zzifpVar instanceof zzicj) {
            zzigsVarZzaU = ((zzicj) zzifpVar).zzaU();
        } else {
            if (zzifpVar instanceof zzick) {
                throw null;
            }
            zzigsVarZzaU = new zzigs(zzifpVar);
        }
        throw zzigsVarZzaU.zza();
    }
}
