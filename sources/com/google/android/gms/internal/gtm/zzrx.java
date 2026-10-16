package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrx {
    private final List zza = new ArrayList();
    private final Map zzb = new HashMap();
    private String zzc = "";
    private int zzd = 0;

    private zzrx() {
    }

    public final zzrv zza() {
        return new zzrv(this.zza, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzrx zzb(zzrr zzrrVar) {
        String strZzm = com.google.android.gms.tagmanager.zzfu.zzm(com.google.android.gms.tagmanager.zzfu.zzk((zzam) zzrrVar.zzc().get(zzb.INSTANCE_NAME.toString())));
        List arrayList = (List) this.zzb.get(strZzm);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzb.put(strZzm, arrayList);
        }
        arrayList.add(zzrrVar);
        return this;
    }

    public final zzrx zzc(zzrz zzrzVar) {
        this.zza.add(zzrzVar);
        return this;
    }

    public final zzrx zzd(int i3) {
        this.zzd = i3;
        return this;
    }

    public final zzrx zze(String str) {
        this.zzc = str;
        return this;
    }

    /* synthetic */ zzrx(zzrw zzrwVar) {
    }
}
