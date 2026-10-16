package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzboy extends zzbsn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbqa f76575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f76576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile zzbnp f76577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbnp f76578d;

    zzboy(zzboz zzbozVar, zzbqa zzbqaVar, String str) {
        Objects.requireNonNull(zzbozVar);
        this.f76576b = new AtomicInteger(-2147483647);
        this.f76575a = (zzbqa) Preconditions.u(zzbqaVar, "delegate");
    }

    @Override // com.google.android.libraries.places.internal.zzbsn, com.google.android.libraries.places.internal.zzbwd
    public final void a(zzbnp zzbnpVar) {
        Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        synchronized (this) {
            try {
                AtomicInteger atomicInteger = this.f76576b;
                if (atomicInteger.get() < 0) {
                    this.f76577c = zzbnpVar;
                    atomicInteger.addAndGet(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                    if (atomicInteger.get() != 0) {
                        return;
                    }
                    super.a(zzbnpVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbsn, com.google.android.libraries.places.internal.zzbwd
    public final void c(zzbnp zzbnpVar) {
        Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        synchronized (this) {
            try {
                AtomicInteger atomicInteger = this.f76576b;
                if (atomicInteger.get() < 0) {
                    this.f76577c = zzbnpVar;
                    atomicInteger.addAndGet(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                } else if (this.f76578d != null) {
                    return;
                }
                if (atomicInteger.get() != 0) {
                    this.f76578d = zzbnpVar;
                } else {
                    super.c(zzbnpVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbsn
    protected final zzbqa d() {
        return this.f76575a;
    }

    @Override // com.google.android.libraries.places.internal.zzbsn, com.google.android.libraries.places.internal.zzbpo
    public final zzbpl e(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbje[] zzbjeVarArr) {
        return this.f76576b.get() >= 0 ? new zzbsi(this.f76577c, zzbpm.PROCESSED, zzbjeVarArr) : this.f76575a.e(zzbmlVar, zzbmgVar, zzbisVar, zzbjeVarArr);
    }
}
