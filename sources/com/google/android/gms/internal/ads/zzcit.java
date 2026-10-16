package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcit implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final boolean zza(zzchn zzchnVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcis zzcisVar = (zzcis) it.next();
            if (zzcisVar.zza == zzchnVar) {
                arrayList.add(zzcisVar);
            }
        }
        int i3 = 0;
        if (arrayList.isEmpty()) {
            return false;
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((zzcis) obj).zzb.zzl();
        }
        return true;
    }

    final zzcis zzb(zzchn zzchnVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcis zzcisVar = (zzcis) it.next();
            if (zzcisVar.zza == zzchnVar) {
                return zzcisVar;
            }
        }
        return null;
    }

    public final void zzc(zzcis zzcisVar) {
        this.zza.add(zzcisVar);
    }

    public final void zzd(zzcis zzcisVar) {
        this.zza.remove(zzcisVar);
    }
}
