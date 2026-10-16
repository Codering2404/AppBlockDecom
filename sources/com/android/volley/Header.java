package com.android.volley;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57670b;

    public Header(String str, String str2) {
        this.f57669a = str;
        this.f57670b = str2;
    }

    public final String a() {
        return this.f57669a;
    }

    public final String b() {
        return this.f57670b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Header.class == obj.getClass()) {
            Header header = (Header) obj;
            if (TextUtils.equals(this.f57669a, header.f57669a) && TextUtils.equals(this.f57670b, header.f57670b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f57669a.hashCode() * 31) + this.f57670b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f57669a + ",value=" + this.f57670b + "]";
    }
}
