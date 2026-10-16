package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcat implements zzcft {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbzq f77350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcau f77351d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzcft f77355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Socket f77356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f77357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f77358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f77359m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f77348a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcff f77349b = new zzcff();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f77352f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f77353g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f77354h = false;

    private zzcat(zzbzq zzbzqVar, zzcau zzcauVar, int i3) {
        this.f77350c = (zzbzq) Preconditions.u(zzbzqVar, "executor");
        this.f77351d = (zzcau) Preconditions.u(zzcauVar, "exceptionHandler");
    }

    static zzcat a(zzbzq zzbzqVar, zzcau zzcauVar, int i3) {
        return new zzcat(zzbzqVar, zzcauVar, ColorExtractionConstants.MAX_PIXEL_SAMPLES);
    }

    final void b(zzcft zzcftVar, Socket socket) {
        Preconditions.A(this.f77355i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f77355i = (zzcft) Preconditions.u(zzcftVar, "sink");
        this.f77356j = (Socket) Preconditions.u(socket, "socket");
    }

    final /* synthetic */ Object c() {
        return this.f77348a;
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f77354h) {
            return;
        }
        this.f77354h = true;
        this.f77350c.execute(new zzcaq(this));
    }

    final /* synthetic */ zzcau f() {
        return this.f77351d;
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    public final void flush() throws IOException {
        if (this.f77354h) {
            throw new IOException("closed");
        }
        int i3 = zzcew.f77735a;
        synchronized (this.f77348a) {
            try {
                if (this.f77353g) {
                    return;
                }
                this.f77353g = true;
                this.f77350c.execute(new zzcap(this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void i(boolean z2) {
        this.f77352f = false;
    }

    @Override // com.google.android.libraries.places.internal.zzcft
    public final void i2(zzcff zzcffVar, long j3) throws IOException {
        Preconditions.u(zzcffVar, "source");
        if (this.f77354h) {
            throw new IOException("closed");
        }
        int i3 = zzcew.f77735a;
        synchronized (this.f77348a) {
            try {
                zzcff zzcffVar2 = this.f77349b;
                zzcffVar2.i2(zzcffVar, j3);
                int i4 = this.f77359m + this.f77358l;
                this.f77359m = i4;
                boolean z2 = false;
                this.f77358l = 0;
                if (this.f77357k || i4 <= 10000) {
                    if (!this.f77352f && !this.f77353g && zzcffVar2.zzi() > 0) {
                        this.f77352f = true;
                    }
                    return;
                }
                this.f77357k = true;
                z2 = true;
                if (!z2) {
                    this.f77350c.execute(new zzcao(this));
                    return;
                }
                try {
                    this.f77356j.close();
                } catch (IOException e3) {
                    this.f77351d.d(e3);
                }
            } finally {
            }
        }
    }

    final /* synthetic */ void j(boolean z2) {
        this.f77353g = false;
    }

    final /* synthetic */ zzcft k() {
        return this.f77355i;
    }

    final /* synthetic */ Socket l() {
        return this.f77356j;
    }

    final /* synthetic */ int m() {
        return this.f77358l;
    }

    final /* synthetic */ void n(int i3) {
        this.f77358l = i3;
    }

    final /* synthetic */ void r(int i3) {
        this.f77359m = i3;
    }

    final /* synthetic */ zzcff zze() {
        return this.f77349b;
    }

    final /* synthetic */ int zzm() {
        return this.f77359m;
    }
}
