package com.applovin.impl;

import android.content.Context;
import android.util.SparseArray;
import com.applovin.impl.bi;
import com.applovin.impl.h5;
import com.applovin.impl.u5;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h6 implements ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h5.a f60131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f60132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f60133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f60134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f60135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f60136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f60137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f60138h;

    public h6(Context context, n8 n8Var) {
        this(new u5.a(context), n8Var);
    }

    private static SparseArray a(h5.a aVar, n8 n8Var) {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, (ce) Class.forName("com.applovin.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(ce.class).getConstructor(h5.a.class).newInstance(aVar));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (ce) Class.forName("com.applovin.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(ce.class).getConstructor(h5.a.class).newInstance(aVar));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (ce) Class.forName("com.applovin.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(ce.class).getConstructor(h5.a.class).newInstance(aVar));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (ce) Class.forName("com.applovin.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(ce.class).getConstructor(null).newInstance(null));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new bi.b(aVar, n8Var));
        return sparseArray;
    }

    public h6(h5.a aVar, n8 n8Var) {
        this.f60131a = aVar;
        SparseArray sparseArrayA = a(aVar, n8Var);
        this.f60132b = sparseArrayA;
        this.f60133c = new int[sparseArrayA.size()];
        for (int i3 = 0; i3 < this.f60132b.size(); i3++) {
            this.f60133c[i3] = this.f60132b.keyAt(i3);
        }
        this.f60134d = -9223372036854775807L;
        this.f60135e = -9223372036854775807L;
        this.f60136f = -9223372036854775807L;
        this.f60137g = -3.4028235E38f;
        this.f60138h = -3.4028235E38f;
    }
}
