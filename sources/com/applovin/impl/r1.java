package com.applovin.impl;

import com.google.common.cache.LSNn.vfptEEmYY;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface r1 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f62708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e9 f62709c;

        public b(int i3, int i4, int i5, int i6, e9 e9Var, boolean z2, Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i3);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i4);
            sb.append(", ");
            sb.append(i5);
            sb.append(", ");
            sb.append(i6);
            sb.append(")");
            sb.append(z2 ? " (recoverable)" : vfptEEmYY.pBSwUgLoTiBuB);
            super(sb.toString(), exc);
            this.f62707a = i3;
            this.f62708b = z2;
            this.f62709c = e9Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a();

        void a(int i3, long j3, long j4);

        void a(long j3);

        void a(Exception exc);

        void a(boolean z2);

        void b();

        void b(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f62710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f62711b;

        public d(long j3, long j4) {
            super("Unexpected audio track timestamp discontinuity: expected " + j4 + ", got " + j3);
            this.f62710a = j3;
            this.f62711b = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f62713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e9 f62714c;

        public e(int i3, e9 e9Var, boolean z2) {
            super("AudioTrack write failed: " + i3);
            this.f62713b = z2;
            this.f62712a = i3;
            this.f62714c = e9Var;
        }
    }

    long a(boolean z2);

    ph a();

    void a(float f3);

    void a(int i3);

    void a(e9 e9Var, int i3, int[] iArr);

    void a(l1 l1Var);

    void a(ph phVar);

    void a(c cVar);

    void a(v1 v1Var);

    boolean a(e9 e9Var);

    boolean a(ByteBuffer byteBuffer, long j3, int i3);

    int b(e9 e9Var);

    void b();

    void b(boolean z2);

    boolean c();

    void d();

    void e();

    void f();

    boolean g();

    void h();

    void i();

    void j();

    void pause();

    void reset();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e9 f62706a;

        public a(String str, e9 e9Var) {
            super(str);
            this.f62706a = e9Var;
        }

        public a(Throwable th, e9 e9Var) {
            super(th);
            this.f62706a = e9Var;
        }
    }
}
