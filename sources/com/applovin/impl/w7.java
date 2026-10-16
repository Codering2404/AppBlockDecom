package com.applovin.impl;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class w7 extends dk {
    public v7 a(ah ahVar) {
        return new v7((String) b1.a((Object) ahVar.t()), (String) b1.a((Object) ahVar.t()), ahVar.s(), ahVar.s(), Arrays.copyOfRange(ahVar.c(), ahVar.d(), ahVar.e()));
    }

    @Override // com.applovin.impl.dk
    protected af a(df dfVar, ByteBuffer byteBuffer) {
        return new af(a(new ah(byteBuffer.array(), byteBuffer.limit())));
    }
}
