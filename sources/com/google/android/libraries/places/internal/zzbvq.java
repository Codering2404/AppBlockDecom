package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f76972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Collection f76973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    zzbnp f76974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbvr f76975d;

    /* synthetic */ zzbvq(zzbvr zzbvrVar, byte[] bArr) {
        Objects.requireNonNull(zzbvrVar);
        this.f76975d = zzbvrVar;
        this.f76972a = new Object();
        this.f76973b = new HashSet();
    }

    final void a(zzbnp zzbnpVar) {
        synchronized (this.f76972a) {
            try {
                if (this.f76974c != null) {
                    return;
                }
                this.f76974c = zzbnpVar;
                boolean zIsEmpty = this.f76973b.isEmpty();
                if (zIsEmpty) {
                    this.f76975d.s().a(zzbnpVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
