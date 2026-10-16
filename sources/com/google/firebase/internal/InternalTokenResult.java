package com.google.firebase.internal;

import com.facebook.AccessToken;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class InternalTokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f89334a;

    public InternalTokenResult(String str) {
        this.f89334a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return Objects.b(this.f89334a, ((InternalTokenResult) obj).f89334a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(this.f89334a);
    }

    public String toString() {
        return Objects.d(this).a(AccessToken.TOKEN_KEY, this.f89334a).toString();
    }
}
