package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f77112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f77113b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f77114c;

    zzbwv(List list, boolean z2) {
        this.f77114c = z2;
        g(list);
    }

    private static final List j(List list, List list2) {
        if (list.isEmpty()) {
            return list2;
        }
        if (list2.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        for (int i3 = 0; i3 < Math.max(list.size(), list2.size()); i3++) {
            if (i3 < list.size()) {
                arrayList.add((zzbwu) list.get(i3));
            }
            if (i3 < list2.size()) {
                arrayList.add((zzbwu) list2.get(i3));
            }
        }
        return arrayList;
    }

    public final boolean a() {
        return this.f77113b < this.f77112a.size();
    }

    public final boolean b() {
        if (!a()) {
            return false;
        }
        this.f77113b++;
        return a();
    }

    public final void c() {
        this.f77113b = 0;
    }

    public final SocketAddress d() {
        if (a()) {
            return ((zzbwu) this.f77112a.get(this.f77113b)).c();
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public final zzbio e() {
        if (a()) {
            return ((zzbwu) this.f77112a.get(this.f77113b)).b();
        }
        throw new IllegalStateException("Index is off the end of the address group list");
    }

    public final List f() {
        if (a()) {
            return Collections.singletonList(((zzbwu) this.f77112a.get(this.f77113b)).a());
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public final void g(List list) {
        List listJ;
        Preconditions.u(list, "newGroups");
        if (this.f77114c) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Boolean bool = null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzbka zzbkaVar = (zzbka) list.get(i3);
                for (int i4 = 0; i4 < zzbkaVar.a().size(); i4++) {
                    SocketAddress socketAddress = (SocketAddress) zzbkaVar.a().get(i4);
                    if ((socketAddress instanceof InetSocketAddress) && (((InetSocketAddress) socketAddress).getAddress() instanceof Inet4Address)) {
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        arrayList.add(new zzbwu(zzbkaVar.b(), socketAddress));
                    } else {
                        if (bool == null) {
                            bool = Boolean.TRUE;
                        }
                        arrayList2.add(new zzbwu(zzbkaVar.b(), socketAddress));
                    }
                }
            }
            listJ = (bool == null || !bool.booleanValue()) ? j(arrayList, arrayList2) : j(arrayList2, arrayList);
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzbka zzbkaVar2 = (zzbka) list.get(i5);
                for (int i6 = 0; i6 < zzbkaVar2.a().size(); i6++) {
                    arrayList3.add(new zzbwu(zzbkaVar2.b(), (SocketAddress) zzbkaVar2.a().get(i6)));
                }
            }
            listJ = arrayList3;
        }
        this.f77112a = listJ;
        this.f77113b = 0;
    }

    public final boolean h(SocketAddress socketAddress) {
        Preconditions.u(socketAddress, "needle");
        for (int i3 = 0; i3 < this.f77112a.size(); i3++) {
            if (((zzbwu) this.f77112a.get(i3)).c().equals(socketAddress)) {
                this.f77113b = i3;
                return true;
            }
        }
        return false;
    }

    public final int i() {
        return this.f77112a.size();
    }
}
