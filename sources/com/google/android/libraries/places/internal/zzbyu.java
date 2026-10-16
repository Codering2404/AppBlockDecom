package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f77221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List f77222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Collection f77223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Collection f77224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f77225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzbzd f77226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f77227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f77228h;

    zzbyu(List list, Collection collection, Collection collection2, zzbzd zzbzdVar, boolean z2, boolean z3, boolean z4, int i3) {
        this.f77222b = list;
        this.f77223c = (Collection) Preconditions.u(collection, "drainedSubstreams");
        this.f77226f = zzbzdVar;
        this.f77224d = collection2;
        this.f77227g = z2;
        this.f77221a = z3;
        this.f77228h = z4;
        this.f77225e = i3;
        Preconditions.A(!z3 || list == null, "passThrough should imply buffer is null");
        Preconditions.A((z3 && zzbzdVar == null) ? false : true, "passThrough should imply winningSubstream != null");
        Preconditions.A(!z3 || (collection.size() == 1 && collection.contains(zzbzdVar)) || (collection.size() == 0 && zzbzdVar.f77245b), "passThrough should imply winningSubstream is drained");
        Preconditions.A((z2 && zzbzdVar == null) ? false : true, "cancelled should imply committed");
    }

    final zzbyu a(zzbzd zzbzdVar) {
        Collection collectionUnmodifiableCollection;
        Preconditions.A(!this.f77221a, "Already passThrough");
        if (zzbzdVar.f77245b) {
            collectionUnmodifiableCollection = this.f77223c;
        } else {
            Collection collection = this.f77223c;
            if (collection.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(zzbzdVar);
            } else {
                ArrayList arrayList = new ArrayList(collection);
                arrayList.add(zzbzdVar);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
        }
        Collection collection2 = collectionUnmodifiableCollection;
        zzbzd zzbzdVar2 = this.f77226f;
        boolean z2 = zzbzdVar2 != null;
        List list = this.f77222b;
        if (z2) {
            Preconditions.A(zzbzdVar2 == zzbzdVar, "Another RPC attempt has already committed");
            list = null;
        }
        return new zzbyu(list, collection2, this.f77224d, zzbzdVar2, this.f77227g, z2, this.f77228h, this.f77225e);
    }

    final zzbyu b() {
        return this.f77228h ? this : new zzbyu(this.f77222b, this.f77223c, this.f77224d, this.f77226f, this.f77227g, this.f77221a, true, this.f77225e);
    }

    final zzbyu c(zzbzd zzbzdVar) {
        Collection collectionUnmodifiableCollection;
        boolean z2 = this.f77228h;
        Preconditions.A(!z2, "hedging frozen");
        zzbzd zzbzdVar2 = this.f77226f;
        Preconditions.A(zzbzdVar2 == null, "already committed");
        Collection collection = this.f77224d;
        if (collection == null) {
            collectionUnmodifiableCollection = Collections.singleton(zzbzdVar);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(zzbzdVar);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new zzbyu(this.f77222b, this.f77223c, collectionUnmodifiableCollection, zzbzdVar2, this.f77227g, this.f77221a, z2, this.f77225e + 1);
    }
}
