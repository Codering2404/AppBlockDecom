package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.a4;
import com.applovin.impl.cc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xh extends cc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a4.a f64981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f64982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f64983p;

    public xh(a4.a aVar, boolean z2, Context context) {
        super(cc.c.RIGHT_DETAIL);
        this.f64981n = aVar;
        this.f64982o = context;
        this.f58864c = new SpannedString(aVar.a());
        this.f64983p = z2;
    }

    @Override // com.applovin.impl.cc
    public SpannedString f() {
        return new SpannedString(this.f64981n.a(this.f64982o));
    }

    @Override // com.applovin.impl.cc
    public boolean o() {
        return false;
    }

    @Override // com.applovin.impl.cc
    public boolean p() {
        Boolean boolB = this.f64981n.b(this.f64982o);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.f64983p));
        }
        return false;
    }
}
