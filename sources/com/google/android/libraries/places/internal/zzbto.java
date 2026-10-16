package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbto implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbqa f76859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f76860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbua f76861c;

    zzbto(zzbua zzbuaVar, zzbqa zzbqaVar, boolean z2) {
        this.f76859a = zzbqaVar;
        this.f76860b = z2;
        Objects.requireNonNull(zzbuaVar);
        this.f76861c = zzbuaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76861c.O().a(this.f76859a, this.f76860b);
    }
}
