package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbce extends zzbdf {
    public zzbce(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        super(zzbbsVar, "2JfLKOCWe20PaEte0oViJ9E/+ELRHfLHNO4trOuu7IQ3kQ71vgp9bwF5/QP32+2T", "LVYC8EvnYnoIGxefzdW+bkgnD7TMgzMx712oMyZcYTg=", zzaxmVar, i3, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzaf(3);
        try {
            int i3 = 1;
            if (true == ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue()) {
                i3 = 2;
            }
            zzaxmVar.zzaf(i3);
        } catch (InvocationTargetException e3) {
            if (!(e3.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e3;
            }
        }
    }
}
