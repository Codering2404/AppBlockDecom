package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcen {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Collection f77716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f77717b;

    public zzcen(zzbka zzbkaVar) {
        Preconditions.u(zzbkaVar, "eag");
        if (zzbkaVar.a().size() < 10) {
            this.f77716a = zzbkaVar.a();
        } else {
            this.f77716a = new HashSet(zzbkaVar.a());
        }
        Iterator it = zzbkaVar.a().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((SocketAddress) it.next()).hashCode();
        }
        this.f77717b = iHashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcen)) {
            return false;
        }
        zzcen zzcenVar = (zzcen) obj;
        if (zzcenVar.f77717b == this.f77717b) {
            Collection collection = zzcenVar.f77716a;
            int size = collection.size();
            Collection<?> collection2 = this.f77716a;
            if (size == collection2.size()) {
                return collection.containsAll(collection2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f77717b;
    }

    public final String toString() {
        return this.f77716a.toString();
    }
}
