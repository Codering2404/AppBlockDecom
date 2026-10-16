package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbch extends zzbdf {
    public zzbch(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        super(zzbbsVar, "m7g/XX2t5caOhtOM/ogmEO9Vkwmhkxe5gTS2qje4vP8HJASoqVE/26NLNeDuMz/t", "+Weh9OuqHFyRkOD06GxXjljhJF/GsDXbBDxKrn8yplc=", zzaxmVar, i3, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzd(-1L);
        zzaxmVar.zze(-1L);
        int[] iArr = (int[]) this.zze.invoke(null, this.zza.zzb());
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzd(iArr[0]);
                zzaxmVar.zze(iArr[1]);
                int i3 = iArr[2];
                if (i3 != Integer.MIN_VALUE) {
                    zzaxmVar.zzO(i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
