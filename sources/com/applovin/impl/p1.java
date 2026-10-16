package com.applovin.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f62400a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f62401e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f62403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62405d;

        public a(int i3, int i4, int i5) {
            this.f62402a = i3;
            this.f62403b = i4;
            this.f62404c = i5;
            this.f62405d = xp.g(i5) ? xp.b(i5, i4) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f62402a + ", channelCount=" + this.f62403b + ", encoding=" + this.f62404c + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    a a(a aVar);

    void a(ByteBuffer byteBuffer);

    void b();

    boolean c();

    ByteBuffer d();

    void e();

    boolean f();

    void reset();
}
