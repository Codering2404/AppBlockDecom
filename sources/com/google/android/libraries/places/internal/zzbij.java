package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76238a = zzbic.a(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f76239b = zzbic.a(0);

    /* synthetic */ zzbij(int i3, int i4, zzbii zzbiiVar) {
    }

    public final zzbij a(zzbih zzbihVar) {
        this.f76238a.add(zzbihVar);
        return this;
    }

    public final zzbik b() {
        return new zzbik(this.f76238a, this.f76239b, null);
    }
}
