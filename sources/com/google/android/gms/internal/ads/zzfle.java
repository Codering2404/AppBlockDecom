package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfle {
    public static com.google.android.gms.ads.internal.client.zzr zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfkg zzfkgVar = (zzfkg) it.next();
            if (zzfkgVar.zzc) {
                arrayList.add(AdSize.f69652q);
            } else {
                arrayList.add(new AdSize(zzfkgVar.zza, zzfkgVar.zzb));
            }
        }
        return new com.google.android.gms.ads.internal.client.zzr(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfkg zzb(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzrVar.f70012j ? new zzfkg(-3, 0, true) : new zzfkg(zzrVar.f70008f, zzrVar.f70005b, false);
    }
}
