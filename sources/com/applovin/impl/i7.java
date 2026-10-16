package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class i7 extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final j7 f60366o;

    public i7(List list) {
        super("DvbDecoder");
        ah ahVar = new ah((byte[]) list.get(0));
        this.f60366o = new j7(ahVar.C(), ahVar.C());
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) {
        if (z2) {
            this.f60366o.d();
        }
        return new k7(this.f60366o.a(bArr, i3));
    }
}
