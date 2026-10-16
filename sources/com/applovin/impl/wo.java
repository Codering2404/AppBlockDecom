package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class wo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final si[] f64724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g8[] f64725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f64726d;

    public wo(si[] siVarArr, g8[] g8VarArr, Object obj) {
        this.f64724b = siVarArr;
        this.f64725c = (g8[]) g8VarArr.clone();
        this.f64726d = obj;
        this.f64723a = siVarArr.length;
    }

    public boolean a(wo woVar) {
        if (woVar == null || woVar.f64725c.length != this.f64725c.length) {
            return false;
        }
        for (int i3 = 0; i3 < this.f64725c.length; i3++) {
            if (!a(woVar, i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(wo woVar, int i3) {
        return woVar != null && xp.a(this.f64724b[i3], woVar.f64724b[i3]) && xp.a(this.f64725c[i3], woVar.f64725c[i3]);
    }

    public boolean a(int i3) {
        return this.f64724b[i3] != null;
    }
}
