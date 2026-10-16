package com.google.android.libraries.places.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbpp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f76627a = "unknown-authority";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbio f76628b = zzbio.f76249c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f76629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbki f76630d;

    public final String a() {
        return this.f76627a;
    }

    public final zzbpp b(String str) {
        this.f76627a = (String) Preconditions.u(str, "authority");
        return this;
    }

    public final zzbio c() {
        return this.f76628b;
    }

    public final zzbpp d(zzbio zzbioVar) {
        Preconditions.u(zzbioVar, "eagAttributes");
        this.f76628b = zzbioVar;
        return this;
    }

    public final String e() {
        return this.f76629c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbpp)) {
            return false;
        }
        zzbpp zzbppVar = (zzbpp) obj;
        return this.f76627a.equals(zzbppVar.f76627a) && this.f76628b.equals(zzbppVar.f76628b) && Objects.a(this.f76629c, zzbppVar.f76629c) && Objects.a(this.f76630d, zzbppVar.f76630d);
    }

    public final zzbpp f(String str) {
        this.f76629c = str;
        return this;
    }

    public final zzbki g() {
        return this.f76630d;
    }

    public final zzbpp h(zzbki zzbkiVar) {
        this.f76630d = zzbkiVar;
        return this;
    }

    public final int hashCode() {
        return Objects.b(this.f76627a, this.f76628b, this.f76629c, this.f76630d);
    }
}
