package com.google.android.gms.common.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f72112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f72114e;

    public zzn(String str, String str2, int i3, boolean z2) {
        Preconditions.g(str);
        this.f72110a = str;
        Preconditions.g(str2);
        this.f72111b = str2;
        this.f72112c = null;
        this.f72113d = 4225;
        this.f72114e = z2;
    }

    public final String a() {
        return this.f72110a;
    }

    public final String b() {
        return this.f72111b;
    }

    public final ComponentName c() {
        return this.f72112c;
    }

    public final boolean d() {
        return this.f72114e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        return Objects.b(this.f72110a, zznVar.f72110a) && Objects.b(this.f72111b, zznVar.f72111b) && Objects.b(this.f72112c, zznVar.f72112c) && this.f72114e == zznVar.f72114e;
    }

    public final int hashCode() {
        return Objects.c(this.f72110a, this.f72111b, this.f72112c, 4225, Boolean.valueOf(this.f72114e));
    }

    public final String toString() {
        String str = this.f72110a;
        if (str != null) {
            return str;
        }
        ComponentName componentName = this.f72112c;
        Preconditions.m(componentName);
        return componentName.flattenToString();
    }
}
