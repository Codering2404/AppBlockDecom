package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzic implements zzih {
    private static final boolean zzb(int i3) throws IOException {
        try {
            new Socket("localhost", i3).close();
            return true;
        } catch (ConnectException unused) {
            return false;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzih
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    @Override // com.google.android.recaptcha.internal.zzih
    public final Object zza(Object... objArr) throws zzce {
        ArrayList arrayList = new ArrayList(objArr.length);
        int i3 = 0;
        for (Object obj : objArr) {
            if (true != (obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            if (num == null) {
                throw new zzce(4, 5, null);
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            int iIntValue = ((Number) obj2).intValue();
            if (zzb(iIntValue)) {
                arrayList2.add(Integer.valueOf(iIntValue));
            }
        }
        return arrayList2;
    }
}
