package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Response<T extends Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Result f71533a;

    protected Response(Result result) {
        this.f71533a = result;
    }

    protected Result a() {
        return this.f71533a;
    }

    public void b(Result result) {
        this.f71533a = result;
    }
}
