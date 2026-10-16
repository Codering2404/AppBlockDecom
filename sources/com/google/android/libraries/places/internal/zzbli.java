package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbli {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzbli f76370e = new zzbli(null, null, zzbnp.f76488e, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblm f76371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbjb f76372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbnp f76373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f76374d;

    private zzbli(zzblm zzblmVar, zzbjb zzbjbVar, zzbnp zzbnpVar, boolean z2) {
        this.f76371a = zzblmVar;
        this.f76373c = (zzbnp) Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        this.f76374d = z2;
    }

    public static zzbli a(zzblm zzblmVar, zzbjb zzbjbVar) {
        return new zzbli((zzblm) Preconditions.u(zzblmVar, "subchannel"), null, zzbnp.f76488e, false);
    }

    public static zzbli b(zzbnp zzbnpVar) {
        Preconditions.e(!zzbnpVar.j(), "error status shouldn't be OK");
        return new zzbli(null, null, zzbnpVar, false);
    }

    public static zzbli c(zzbnp zzbnpVar) {
        Preconditions.e(!zzbnpVar.j(), "drop status shouldn't be OK");
        return new zzbli(null, null, zzbnpVar, true);
    }

    public static zzbli d() {
        return f76370e;
    }

    public final zzblm e() {
        return this.f76371a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbli)) {
            return false;
        }
        zzbli zzbliVar = (zzbli) obj;
        return Objects.a(this.f76371a, zzbliVar.f76371a) && Objects.a(this.f76373c, zzbliVar.f76373c) && Objects.a(null, null) && this.f76374d == zzbliVar.f76374d;
    }

    public final zzbnp f() {
        return this.f76373c;
    }

    public final boolean g() {
        return this.f76374d;
    }

    public final boolean h() {
        return (this.f76371a == null && this.f76373c.j()) ? false : true;
    }

    public final int hashCode() {
        return Objects.b(this.f76371a, this.f76373c, null, Boolean.valueOf(this.f76374d));
    }

    public final String toString() {
        return MoreObjects.c(this).d("subchannel", this.f76371a).d("streamTracerFactory", null).d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f76373c).e("drop", this.f76374d).d("authority-override", null).toString();
    }
}
