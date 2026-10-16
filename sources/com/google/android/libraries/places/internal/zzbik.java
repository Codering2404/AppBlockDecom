package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbik implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f76241b;

    static {
        zzbif.a(Collections.EMPTY_SET);
    }

    /* synthetic */ zzbik(List list, List list2, zzbii zzbiiVar) {
        this.f76240a = list;
        this.f76241b = list2;
    }

    public static zzbij a(int i3, int i4) {
        return new zzbij(1, 0, null);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        List list = this.f76240a;
        int size = list.size();
        List list2 = this.f76241b;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Collection collection = (Collection) ((zzbih) list2.get(i3)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSet = new HashSet(size < 3 ? size + 1 : size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER);
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Object objZzb = ((zzbih) list.get(i4)).zzb();
            objZzb.getClass();
            hashSet.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i5 = 0; i5 < size4; i5++) {
            for (Object obj : (Collection) arrayList.get(i5)) {
                obj.getClass();
                hashSet.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
