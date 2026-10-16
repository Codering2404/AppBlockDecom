package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.c6;
import com.applovin.impl.h5;
import com.applovin.sdk.AppLovinEventTypes;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u5 implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f64095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f64096b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h5 f64097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h5 f64098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h5 f64099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h5 f64100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h5 f64101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h5 f64102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h5 f64103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h5 f64104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h5 f64105k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a implements h5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f64106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h5.a f64107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private xo f64108c;

        public a(Context context) {
            this(context, new c6.b());
        }

        @Override // com.applovin.impl.h5.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u5 a() {
            u5 u5Var = new u5(this.f64106a, this.f64107b.a());
            xo xoVar = this.f64108c;
            if (xoVar != null) {
                u5Var.a(xoVar);
            }
            return u5Var;
        }

        public a(Context context, h5.a aVar) {
            this.f64106a = context.getApplicationContext();
            this.f64107b = aVar;
        }
    }

    public u5(Context context, h5 h5Var) {
        this.f64095a = context.getApplicationContext();
        this.f64097c = (h5) b1.a(h5Var);
    }

    private void a(h5 h5Var) {
        for (int i3 = 0; i3 < this.f64096b.size(); i3++) {
            h5Var.a((xo) this.f64096b.get(i3));
        }
    }

    private h5 g() {
        if (this.f64099e == null) {
            c1 c1Var = new c1(this.f64095a);
            this.f64099e = c1Var;
            a(c1Var);
        }
        return this.f64099e;
    }

    private h5 h() {
        if (this.f64100f == null) {
            r4 r4Var = new r4(this.f64095a);
            this.f64100f = r4Var;
            a(r4Var);
        }
        return this.f64100f;
    }

    private h5 i() {
        if (this.f64103i == null) {
            g5 g5Var = new g5();
            this.f64103i = g5Var;
            a(g5Var);
        }
        return this.f64103i;
    }

    private h5 j() {
        if (this.f64098d == null) {
            o8 o8Var = new o8();
            this.f64098d = o8Var;
            a(o8Var);
        }
        return this.f64098d;
    }

    private h5 k() {
        if (this.f64104j == null) {
            li liVar = new li(this.f64095a);
            this.f64104j = liVar;
            a(liVar);
        }
        return this.f64104j;
    }

    private h5 l() {
        if (this.f64101g == null) {
            try {
                h5 h5Var = (h5) Class.forName("com.applovin.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.f64101g = h5Var;
                a(h5Var);
            } catch (ClassNotFoundException unused) {
                oc.d("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating RTMP extension", e3);
            }
            if (this.f64101g == null) {
                this.f64101g = this.f64097c;
            }
        }
        return this.f64101g;
    }

    private h5 m() {
        if (this.f64102h == null) {
            np npVar = new np();
            this.f64102h = npVar;
            a(npVar);
        }
        return this.f64102h;
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        h5 h5Var = this.f64105k;
        if (h5Var == null) {
            return null;
        }
        return h5Var.c();
    }

    @Override // com.applovin.impl.h5
    public void close() {
        h5 h5Var = this.f64105k;
        if (h5Var != null) {
            try {
                h5Var.close();
            } finally {
                this.f64105k = null;
            }
        }
    }

    @Override // com.applovin.impl.h5
    public Map e() {
        h5 h5Var = this.f64105k;
        return h5Var == null ? Collections.EMPTY_MAP : h5Var.e();
    }

    @Override // com.applovin.impl.h5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f64097c.a(xoVar);
        this.f64096b.add(xoVar);
        a(this.f64098d, xoVar);
        a(this.f64099e, xoVar);
        a(this.f64100f, xoVar);
        a(this.f64101g, xoVar);
        a(this.f64102h, xoVar);
        a(this.f64103i, xoVar);
        a(this.f64104j, xoVar);
    }

    private void a(h5 h5Var, xo xoVar) {
        if (h5Var != null) {
            h5Var.a(xoVar);
        }
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) {
        b1.b(this.f64105k == null);
        String scheme = k5Var.f60912a.getScheme();
        if (xp.a(k5Var.f60912a)) {
            String path = k5Var.f60912a.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.f64105k = g();
            } else {
                this.f64105k = j();
            }
        } else if ("asset".equals(scheme)) {
            this.f64105k = g();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.f64105k = h();
        } else if ("rtmp".equals(scheme)) {
            this.f64105k = l();
        } else if ("udp".equals(scheme)) {
            this.f64105k = m();
        } else if (MrGIhy.DwzHCXZjSWXp.equals(scheme)) {
            this.f64105k = i();
        } else if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
            this.f64105k = this.f64097c;
        } else {
            this.f64105k = k();
        }
        return this.f64105k.a(k5Var);
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) {
        return ((h5) b1.a(this.f64105k)).a(bArr, i3, i4);
    }
}
