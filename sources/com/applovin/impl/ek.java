package com.applovin.impl;

import com.applovin.impl.yg;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ek extends bk implements ol {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f59519n;

    protected ek(String str) {
        super(new rl[2], new sl[2]);
        this.f59519n = str;
        a(1024);
    }

    protected abstract nl a(byte[] bArr, int i3, boolean z2);

    @Override // com.applovin.impl.ol
    public void a(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final pl a(Throwable th) {
        return new pl("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final sl g() {
        return new fk(new yg.a() { // from class: com.applovin.impl.av
            @Override // com.applovin.impl.yg.a
            public final void a(yg ygVar) {
                this.f58515a.a(ygVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final rl f() {
        return new rl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.bk
    public final pl a(rl rlVar, sl slVar, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) b1.a(rlVar.f62183c);
            slVar.a(rlVar.f62185f, a(byteBuffer.array(), byteBuffer.limit(), z2), rlVar.f62878j);
            slVar.c(Integer.MIN_VALUE);
            return null;
        } catch (pl e3) {
            return e3;
        }
    }
}
