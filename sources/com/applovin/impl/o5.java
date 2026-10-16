package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o5 extends l2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z4 f62182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f62183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f62184d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f62186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f62187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f62188i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f62190b;

        public a(int i3, int i4) {
            super("Buffer too small (" + i3 + " < " + i4 + ")");
            this.f62189a = i3;
            this.f62190b = i4;
        }
    }

    public o5(int i3) {
        this(i3, 0);
    }

    private ByteBuffer f(int i3) {
        int i4 = this.f62187h;
        if (i4 == 1) {
            return ByteBuffer.allocate(i3);
        }
        if (i4 == 2) {
            return ByteBuffer.allocateDirect(i3);
        }
        ByteBuffer byteBuffer = this.f62183c;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i3);
    }

    public static o5 i() {
        return new o5(0);
    }

    @Override // com.applovin.impl.l2
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f62183c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f62186g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f62184d = false;
    }

    public void g(int i3) {
        int i4 = i3 + this.f62188i;
        ByteBuffer byteBuffer = this.f62183c;
        if (byteBuffer == null) {
            this.f62183c = f(i4);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i5 = i4 + iPosition;
        if (iCapacity >= i5) {
            this.f62183c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferF = f(i5);
        byteBufferF.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferF.put(byteBuffer);
        }
        this.f62183c = byteBufferF;
    }

    public final boolean h() {
        return d(1073741824);
    }

    public o5(int i3, int i4) {
        this.f62182b = new z4();
        this.f62187h = i3;
        this.f62188i = i4;
    }

    public void h(int i3) {
        ByteBuffer byteBuffer = this.f62186g;
        if (byteBuffer == null || byteBuffer.capacity() < i3) {
            this.f62186g = ByteBuffer.allocate(i3);
        } else {
            this.f62186g.clear();
        }
    }

    public final void g() {
        ByteBuffer byteBuffer = this.f62183c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f62186g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
