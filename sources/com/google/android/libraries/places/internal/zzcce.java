package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcce {
    static {
        Logger.getLogger(zzcce.class.getName());
    }

    private zzcce() {
    }

    public static zzbmg a(List list) {
        return zzbkw.b(c(list));
    }

    public static zzbmg b(List list) {
        return zzbkw.b(c(list));
    }

    private static byte[][] c(List list) {
        int size = list.size();
        byte[][] bArr = new byte[size + size][];
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            zzccz zzcczVar = (zzccz) it.next();
            bArr[i3] = zzcczVar.f77627a.k();
            bArr[i3 + 1] = zzcczVar.f77628b.k();
            i3 += 2;
        }
        return zzcah.b(bArr);
    }
}
