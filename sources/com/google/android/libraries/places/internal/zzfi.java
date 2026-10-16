package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77816a;

    private zzfi(String str) {
        this.f77816a = str;
    }

    public static zzfi a(String str) {
        return new zzfi((String) Preconditions.t(str));
    }

    public static zzfi b(zzfi zzfiVar, zzfi zzfiVar2) {
        return new zzfi(String.valueOf(zzfiVar.f77816a).concat(String.valueOf(zzfiVar2.f77816a)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfi) {
            return this.f77816a.equals(((zzfi) obj).f77816a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f77816a.hashCode();
    }

    public final String toString() {
        return this.f77816a;
    }
}
