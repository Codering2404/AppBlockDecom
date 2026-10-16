package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdhv extends zzdip implements zzboi {
    public zzdhv(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzboi
    public final synchronized void zzb(final String str, final String str2) {
        zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdhu
            @Override // com.google.android.gms.internal.ads.zzdio
            public final /* synthetic */ void zza(Object obj) {
                ((AppEventListener) obj).onAppEvent(str, str2);
            }
        });
    }
}
