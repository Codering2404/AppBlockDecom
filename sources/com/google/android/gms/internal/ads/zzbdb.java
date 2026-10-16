package com.google.android.gms.internal.ads;

import androidx.legacy.content.Werj.QgXempTBEfV;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdb extends zzbdf {
    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzae(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (zzaxmVar) {
            try {
                if (zBooleanValue) {
                    zzaxmVar.zzae(2);
                } else {
                    zzaxmVar.zzae(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzbdb(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        super(zzbbsVar, "GkIdfnRezKvEfAeB5157D8Ci3lpp/e7Oge9xr/GzO3KjC7JXvYHgpg7VRCtGuOw4", QgXempTBEfV.wLUz, zzaxmVar, i3, 48);
    }
}
