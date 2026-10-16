package com.applovin.impl;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class dj implements uq, v2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f59252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SurfaceTexture f59253k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f59256n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f59244a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f59245b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ei f59246c = new ei();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j9 f59247d = new j9();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final eo f59248f = new eo();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final eo f59249g = new eo();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f59250h = new float[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f59251i = new float[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f59254l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f59255m = -1;

    public SurfaceTexture b() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        aa.a();
        this.f59246c.a();
        aa.a();
        this.f59252j = aa.b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f59252j);
        this.f59253k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.applovin.impl.vu
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f64510a.a(surfaceTexture2);
            }
        });
        return this.f59253k;
    }

    public void a(float[] fArr, boolean z2) {
        GLES20.glClear(16384);
        aa.a();
        if (this.f59244a.compareAndSet(true, false)) {
            ((SurfaceTexture) b1.a(this.f59253k)).updateTexImage();
            aa.a();
            if (this.f59245b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f59250h, 0);
            }
            long timestamp = this.f59253k.getTimestamp();
            Long l3 = (Long) this.f59248f.b(timestamp);
            if (l3 != null) {
                this.f59247d.a(this.f59250h, l3.longValue());
            }
            ci ciVar = (ci) this.f59249g.c(timestamp);
            if (ciVar != null) {
                this.f59246c.b(ciVar);
            }
        }
        Matrix.multiplyMM(this.f59251i, 0, fArr, 0, this.f59250h, 0);
        this.f59246c.a(this.f59252j, this.f59251i, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.f59244a.set(true);
    }

    @Override // com.applovin.impl.v2
    public void a(long j3, float[] fArr) {
        this.f59247d.a(j3, fArr);
    }

    @Override // com.applovin.impl.v2
    public void a() {
        this.f59248f.a();
        this.f59247d.a();
        this.f59245b.set(true);
    }

    @Override // com.applovin.impl.uq
    public void a(long j3, long j4, e9 e9Var, MediaFormat mediaFormat) {
        this.f59248f.a(j4, Long.valueOf(j3));
        a(e9Var.f59404w, e9Var.f59405x, j4);
    }

    public void a(int i3) {
        this.f59254l = i3;
    }

    private void a(byte[] bArr, int i3, long j3) {
        byte[] bArr2 = this.f59256n;
        int i4 = this.f59255m;
        this.f59256n = bArr;
        if (i3 == -1) {
            i3 = this.f59254l;
        }
        this.f59255m = i3;
        if (i4 == i3 && Arrays.equals(bArr2, this.f59256n)) {
            return;
        }
        byte[] bArr3 = this.f59256n;
        ci ciVarA = bArr3 != null ? di.a(bArr3, this.f59255m) : null;
        if (ciVarA == null || !ei.a(ciVarA)) {
            ciVarA = ci.a(this.f59255m);
        }
        this.f59249g.a(j3, ciVarA);
    }
}
