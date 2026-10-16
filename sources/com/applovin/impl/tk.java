package com.applovin.impl;

import com.applovin.impl.af;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class tk extends dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f63949a = new ah();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zg f63950b = new zg();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ho f63951c;

    @Override // com.applovin.impl.dk
    protected af a(df dfVar, ByteBuffer byteBuffer) {
        ho hoVar = this.f63951c;
        if (hoVar == null || dfVar.f59210j != hoVar.c()) {
            ho hoVar2 = new ho(dfVar.f62185f);
            this.f63951c = hoVar2;
            hoVar2.a(dfVar.f62185f - dfVar.f59210j);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f63949a.a(bArrArray, iLimit);
        this.f63950b.a(bArrArray, iLimit);
        this.f63950b.d(39);
        long jA = (((long) this.f63950b.a(1)) << 32) | ((long) this.f63950b.a(32));
        this.f63950b.d(20);
        int iA = this.f63950b.a(12);
        int iA2 = this.f63950b.a(8);
        this.f63949a.g(14);
        af.b bVarA = iA2 != 0 ? iA2 != 255 ? iA2 != 4 ? iA2 != 5 ? iA2 != 6 ? null : Cdo.a(this.f63949a, jA, this.f63951c) : uk.a(this.f63949a, jA, this.f63951c) : wk.a(this.f63949a) : yh.a(this.f63949a, iA, jA) : new vk();
        return bVarA == null ? new af(new af.b[0]) : new af(bVarA);
    }
}
