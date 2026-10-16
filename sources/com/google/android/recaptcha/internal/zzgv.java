package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzgv implements zzgx {
    public static final zzgv zza = new zzgv();

    private zzgv() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i3, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        Object array;
        if (zzueVarArr.length != 2) {
            throw new zzce(4, 3, null);
        }
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != Objects.nonNull(objZza)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzce(4, 5, null);
        }
        Object objZza2 = zzgdVar.zzc().zza(zzueVarArr[1]);
        if (true != (objZza2 instanceof Integer)) {
            objZza2 = null;
        }
        Integer num = (Integer) objZza2;
        if (num == null) {
            throw new zzce(4, 5, null);
        }
        int iIntValue = num.intValue();
        try {
            if (objZza instanceof Integer) {
                array = Integer.valueOf(((Number) objZza).intValue() / iIntValue);
            } else {
                if (!(objZza instanceof int[])) {
                    throw new zzce(4, 5, null);
                }
                int[] iArr = (int[]) objZza;
                ArrayList arrayList = new ArrayList(iArr.length);
                for (int i4 : iArr) {
                    arrayList.add(Integer.valueOf(i4 / iIntValue));
                }
                array = arrayList.toArray(new Integer[0]);
            }
            zzgdVar.zzc().zze(i3, array);
        } catch (ArithmeticException e3) {
            throw new zzce(4, 6, e3);
        }
    }
}
