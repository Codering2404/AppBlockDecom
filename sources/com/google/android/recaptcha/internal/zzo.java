package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzo extends Lambda implements Function0 {
    public static final zzo zza = new zzo();

    public zzo() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i3 = zzav.zza;
        Object objZzb = zzau.zza().zzb(zzbf.class.getName().hashCode());
        if (objZzb != null) {
            return (zzbf) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
