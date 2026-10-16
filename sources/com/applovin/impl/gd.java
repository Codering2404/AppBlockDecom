package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.applovin.impl.ul;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface gd {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jd f59964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f59965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e9 f59966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Surface f59967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MediaCrypto f59968e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f59969f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f59970g;

        private a(jd jdVar, MediaFormat mediaFormat, e9 e9Var, Surface surface, MediaCrypto mediaCrypto, int i3, boolean z2) {
            this.f59964a = jdVar;
            this.f59965b = mediaFormat;
            this.f59966c = e9Var;
            this.f59967d = surface;
            this.f59968e = mediaCrypto;
            this.f59969f = i3;
            this.f59970g = z2;
        }

        public static a a(jd jdVar, MediaFormat mediaFormat, e9 e9Var, MediaCrypto mediaCrypto) {
            return new a(jdVar, mediaFormat, e9Var, null, mediaCrypto, 0, false);
        }

        public static a a(jd jdVar, MediaFormat mediaFormat, e9 e9Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(jdVar, mediaFormat, e9Var, surface, mediaCrypto, 0, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f59971a = new ul.c();

        gd a(a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a(gd gdVar, long j3, long j4);
    }

    int a(MediaCodec.BufferInfo bufferInfo);

    ByteBuffer a(int i3);

    void a();

    void a(int i3, int i4, int i5, long j3, int i6);

    void a(int i3, int i4, z4 z4Var, long j3, int i5);

    void a(int i3, long j3);

    void a(int i3, boolean z2);

    void a(Bundle bundle);

    void a(Surface surface);

    void a(c cVar, Handler handler);

    ByteBuffer b(int i3);

    void b();

    void c(int i3);

    boolean c();

    int d();

    MediaFormat e();
}
