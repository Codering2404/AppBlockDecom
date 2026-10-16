package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzhf implements zzgx {
    public static final zzhf zza = new zzhf();

    private zzhf() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i3, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        int length = zzueVarArr.length;
        if (length < 2) {
            throw new zzce(4, 3, null);
        }
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != (objZza instanceof Method)) {
            objZza = null;
        }
        Method method = (Method) objZza;
        if (method == null) {
            throw new zzce(4, 5, null);
        }
        Object objZza2 = zzgdVar.zzc().zza(zzueVarArr[1]);
        Object[] objArrZzg = zzgdVar.zzc().zzg(ArraysKt.toList(zzueVarArr).subList(2, length));
        try {
            zzgdVar.zzc().zze(i3, method.invoke(objZza2, Arrays.copyOf(objArrZzg, objArrZzg.length)));
        } catch (Exception e3) {
            throw new zzce(6, 15, e3);
        }
    }
}
