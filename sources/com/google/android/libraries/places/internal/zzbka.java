package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbka {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbin f76310d = zzbin.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzbin f76311e = zzbin.a("io.grpc.EquivalentAddressGroup.LOCALITY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f76314c;

    public zzbka(List list, zzbio zzbioVar) {
        Preconditions.e(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f76312a = listUnmodifiableList;
        this.f76313b = (zzbio) Preconditions.u(zzbioVar, "attrs");
        this.f76314c = listUnmodifiableList.hashCode();
    }

    public final List a() {
        return this.f76312a;
    }

    public final zzbio b() {
        return this.f76313b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbka)) {
            return false;
        }
        zzbka zzbkaVar = (zzbka) obj;
        List list = this.f76312a;
        int size = list.size();
        List list2 = zzbkaVar.f76312a;
        if (size != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!((SocketAddress) list.get(i3)).equals(list2.get(i3))) {
                return false;
            }
        }
        return this.f76313b.equals(zzbkaVar.f76313b);
    }

    public final int hashCode() {
        return this.f76314c;
    }

    public final String toString() {
        zzbio zzbioVar = this.f76313b;
        String strValueOf = String.valueOf(this.f76312a);
        String strValueOf2 = String.valueOf(zzbioVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 2 + strValueOf2.length() + 1);
        sb.append("[");
        sb.append(strValueOf);
        sb.append("/");
        sb.append(strValueOf2);
        sb.append("]");
        return sb.toString();
    }
}
