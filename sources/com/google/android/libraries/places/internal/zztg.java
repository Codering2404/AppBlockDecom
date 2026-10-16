package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zztg extends zztv {
    zztg(String str, Class cls, boolean z2) {
        super("tags", cls, false);
    }

    @Override // com.google.android.libraries.places.internal.zztv
    public final /* bridge */ /* synthetic */ void b(Object obj, zztu zztuVar) {
        zzwo zzwoVar = (zzwo) obj;
        if (zzwoVar == null) {
            return;
        }
        for (Map.Entry entry : zzwoVar.a().entrySet()) {
            if (((Set) entry.getValue()).isEmpty()) {
                zztuVar.a((String) entry.getKey(), null);
            } else {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    zztuVar.a((String) entry.getKey(), it.next());
                }
            }
        }
    }
}
