package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.c6;
import com.applovin.impl.h5;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class v5 implements h5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f64386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final xo f64387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h5.a f64388c;

    public v5(Context context, xo xoVar, h5.a aVar) {
        this.f64386a = context.getApplicationContext();
        this.f64387b = xoVar;
        this.f64388c = aVar;
    }

    @Override // com.applovin.impl.h5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u5 a() {
        u5 u5Var = new u5(this.f64386a, this.f64388c.a());
        xo xoVar = this.f64387b;
        if (xoVar != null) {
            u5Var.a(xoVar);
        }
        return u5Var;
    }

    public v5(Context context, String str) {
        this(context, str, (xo) null);
    }

    public v5(Context context, String str, xo xoVar) {
        this(context, xoVar, new c6.b().a(str));
    }
}
