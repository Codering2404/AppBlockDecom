package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzxr extends zzxv implements zzzh {
    protected zzxk zza = zzxk.zze();

    private final void zzc(zzxt zzxtVar) {
        if (zzxtVar.zza != ((zzxv) zzb(6, null, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    final zzxk zzT() {
        if (this.zza.zzl()) {
            this.zza = this.zza.clone();
        }
        return this.zza;
    }

    public final Object zzU(zzxd zzxdVar) {
        zzxt zzxtVar = (zzxt) zzxdVar;
        zzc(zzxtVar);
        Object objZzf = this.zza.zzf(zzxtVar.zzd);
        if (objZzf == null) {
            return zzxtVar.zzb;
        }
        zzxs zzxsVar = zzxtVar.zzd;
        if (!zzxsVar.zzd) {
            return zzxtVar.zza(objZzf);
        }
        if (zzxsVar.zzc.zza() != zzabb.ENUM) {
            return objZzf;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) objZzf).iterator();
        while (it.hasNext()) {
            arrayList.add(zzxtVar.zza(it.next()));
        }
        return arrayList;
    }

    public final boolean zzV(zzxd zzxdVar) {
        zzxt zzxtVar = (zzxt) zzxdVar;
        zzc(zzxtVar);
        zzxk zzxkVar = this.zza;
        zzxs zzxsVar = zzxtVar.zzd;
        if (zzxsVar.zzd) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return zzxkVar.zza.get(zzxsVar) != null;
    }
}
