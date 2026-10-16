package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Challenge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92837b;

    public Challenge(String str, String str2) {
        this.f92836a = str;
        this.f92837b = str2;
    }

    public String a() {
        return this.f92837b;
    }

    public String b() {
        return this.f92836a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return Util.h(this.f92836a, challenge.f92836a) && Util.h(this.f92837b, challenge.f92837b);
    }

    public int hashCode() {
        String str = this.f92837b;
        int iHashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f92836a;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f92836a + " realm=\"" + this.f92837b + "\"";
    }
}
