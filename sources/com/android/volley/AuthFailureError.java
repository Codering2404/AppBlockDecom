package com.android.volley;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthFailureError extends VolleyError {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f57641c;

    public AuthFailureError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f57641c != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}
