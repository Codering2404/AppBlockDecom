package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.Objects;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzhc implements zzgx {
    public static final zzhc zza = new zzhc();

    private zzhc() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i3, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        int length = zzueVarArr.length;
        if (length < 2) {
            throw new zzce(4, 3, null);
        }
        Class<?> clsZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != Objects.nonNull(clsZza)) {
            clsZza = null;
        }
        if (clsZza == null) {
            throw new zzce(4, 5, null);
        }
        Class<?> cls = clsZza instanceof Class ? clsZza : clsZza.getClass();
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[1]);
        if (true != (objZza instanceof String)) {
            objZza = null;
        }
        String str = (String) objZza;
        if (str == null) {
            throw new zzce(4, 5, null);
        }
        String strZza = zzgdVar.zzh().zza(str);
        if (Intrinsics.areEqual(strZza, "forName")) {
            throw new zzce(6, 48, null);
        }
        Class[] clsArrZzf = zzgdVar.zzc().zzf(ArraysKt.toList(zzueVarArr).subList(2, length));
        try {
            zzgdVar.zzc().zze(i3, cls.getMethod(strZza, (Class[]) Arrays.copyOf(clsArrZzf, clsArrZzf.length)));
        } catch (Exception e3) {
            throw new zzce(6, 13, e3);
        }
    }
}
