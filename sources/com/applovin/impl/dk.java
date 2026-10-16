package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class dk implements bf {
    @Override // com.applovin.impl.bf
    public final af a(df dfVar) {
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(dfVar.f62183c);
        b1.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dfVar.d()) {
            return null;
        }
        return a(dfVar, byteBuffer);
    }

    protected abstract af a(df dfVar, ByteBuffer byteBuffer);
}
