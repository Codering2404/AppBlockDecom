package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzing implements zzimu {
    private final List zza;
    private final List zzb;

    static {
        zzimv.zza(Collections.EMPTY_SET);
    }

    /* synthetic */ zzing(List list, List list2, zzine zzineVar) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzinf zza(int i3, int i4) {
        return new zzinf(i3, i4, null);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        List list = this.zza;
        int size = list.size();
        List list2 = this.zzb;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Collection collection = (Collection) ((zzind) list2.get(i3)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZzb = zzimr.zzb(size);
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Object objZzb = ((zzind) list.get(i4)).zzb();
            objZzb.getClass();
            hashSetZzb.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i5 = 0; i5 < size4; i5++) {
            for (Object obj : (Collection) arrayList.get(i5)) {
                obj.getClass();
                hashSetZzb.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZzb);
    }
}
