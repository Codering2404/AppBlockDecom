package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcer extends zzbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f77728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f77729c;

    public zzcer(List list, AtomicInteger atomicInteger) {
        Preconditions.e(!list.isEmpty(), "empty list");
        this.f77727a = list;
        this.f77728b = (AtomicInteger) Preconditions.u(atomicInteger, "index");
        Iterator it = list.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((zzbln) it.next()).hashCode();
        }
        this.f77729c = iHashCode;
    }

    @Override // com.google.android.libraries.places.internal.zzbln
    public final zzbli a(zzblj zzbljVar) {
        int andIncrement = this.f77728b.getAndIncrement() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        List list = this.f77727a;
        return ((zzbln) list.get(andIncrement % list.size())).a(zzbljVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcer)) {
            return false;
        }
        zzcer zzcerVar = (zzcer) obj;
        if (zzcerVar == this) {
            return true;
        }
        if (this.f77729c == zzcerVar.f77729c && this.f77728b == zzcerVar.f77728b) {
            List list = this.f77727a;
            int size = list.size();
            List list2 = zzcerVar.f77727a;
            if (size == list2.size() && new HashSet(list).containsAll(list2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f77729c;
    }

    public final String toString() {
        return MoreObjects.b(zzcer.class).d("subchannelPickers", this.f77727a).toString();
    }
}
