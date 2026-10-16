package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.applovin.exoplayer2.common.base.MoreObjects;
import com.applovin.impl.db;
import com.applovin.impl.o2;
import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class uo implements o2 {
    public static final o2.a A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final uo f64291y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final uo f64292z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64296d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f64297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f64298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f64299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f64300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f64301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f64302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f64303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final db f64304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final db f64305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f64306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f64307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f64308q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final db f64309r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final db f64310s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f64311t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f64312u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f64313v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f64314w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final hb f64315x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f64316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f64317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f64318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f64319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f64320e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f64321f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f64322g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f64323h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f64324i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f64325j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f64326k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private db f64327l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private db f64328m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f64329n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f64330o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f64331p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private db f64332q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private db f64333r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f64334s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f64335t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f64336u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private boolean f64337v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private hb f64338w;

        public a() {
            this.f64316a = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64317b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64318c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64319d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64324i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64325j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64326k = true;
            this.f64327l = db.h();
            this.f64328m = db.h();
            this.f64329n = 0;
            this.f64330o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64331p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f64332q = db.h();
            this.f64333r = db.h();
            this.f64334s = 0;
            this.f64335t = false;
            this.f64336u = false;
            this.f64337v = false;
            this.f64338w = hb.h();
        }

        private static db a(String[] strArr) {
            db.a aVarF = db.f();
            for (String str : (String[]) b1.a(strArr)) {
                aVarF.b(xp.f((String) b1.a((Object) str)));
            }
            return aVarF.a();
        }

        private void b(Context context) {
            CaptioningManager captioningManager;
            if ((xp.f65027a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f64334s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f64333r = db.a(xp.a(locale));
                }
            }
        }

        public a a(int i3, int i4, boolean z2) {
            this.f64324i = i3;
            this.f64325j = i4;
            this.f64326k = z2;
            return this;
        }

        public a a(Context context, boolean z2) {
            Point pointC = xp.c(context);
            return a(pointC.x, pointC.y, z2);
        }

        public a a(Context context) {
            if (xp.f65027a >= 19) {
                b(context);
            }
            return this;
        }

        public uo a() {
            return new uo(this);
        }

        public a(Context context) {
            this();
            a(context);
            a(context, true);
        }

        protected a(Bundle bundle) {
            String strB = uo.b(6);
            uo uoVar = uo.f64291y;
            this.f64316a = bundle.getInt(strB, uoVar.f64293a);
            this.f64317b = bundle.getInt(uo.b(7), uoVar.f64294b);
            this.f64318c = bundle.getInt(uo.b(8), uoVar.f64295c);
            this.f64319d = bundle.getInt(uo.b(9), uoVar.f64296d);
            this.f64320e = bundle.getInt(uo.b(10), uoVar.f64297f);
            this.f64321f = bundle.getInt(uo.b(11), uoVar.f64298g);
            this.f64322g = bundle.getInt(uo.b(12), uoVar.f64299h);
            this.f64323h = bundle.getInt(uo.b(13), uoVar.f64300i);
            this.f64324i = bundle.getInt(uo.b(14), uoVar.f64301j);
            this.f64325j = bundle.getInt(uo.b(15), uoVar.f64302k);
            this.f64326k = bundle.getBoolean(uo.b(16), uoVar.f64303l);
            this.f64327l = db.c((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(17)), new String[0]));
            this.f64328m = a((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(1)), new String[0]));
            this.f64329n = bundle.getInt(uo.b(2), uoVar.f64306o);
            this.f64330o = bundle.getInt(uo.b(18), uoVar.f64307p);
            this.f64331p = bundle.getInt(uo.b(19), uoVar.f64308q);
            this.f64332q = db.c((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(20)), new String[0]));
            this.f64333r = a((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(3)), new String[0]));
            this.f64334s = bundle.getInt(uo.b(4), uoVar.f64311t);
            this.f64335t = bundle.getBoolean(uo.b(5), uoVar.f64312u);
            this.f64336u = bundle.getBoolean(uo.b(21), uoVar.f64313v);
            this.f64337v = bundle.getBoolean(uo.b(22), uoVar.f64314w);
            this.f64338w = hb.a((Collection) tb.a((int[]) MoreObjects.firstNonNull(bundle.getIntArray(uo.b(23)), new int[0])));
        }
    }

    static {
        uo uoVarA = new a().a();
        f64291y = uoVarA;
        f64292z = uoVarA;
        A = new o2.a() { // from class: com.applovin.impl.u60
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return uo.a(bundle);
            }
        };
    }

    protected uo(a aVar) {
        this.f64293a = aVar.f64316a;
        this.f64294b = aVar.f64317b;
        this.f64295c = aVar.f64318c;
        this.f64296d = aVar.f64319d;
        this.f64297f = aVar.f64320e;
        this.f64298g = aVar.f64321f;
        this.f64299h = aVar.f64322g;
        this.f64300i = aVar.f64323h;
        this.f64301j = aVar.f64324i;
        this.f64302k = aVar.f64325j;
        this.f64303l = aVar.f64326k;
        this.f64304m = aVar.f64327l;
        this.f64305n = aVar.f64328m;
        this.f64306o = aVar.f64329n;
        this.f64307p = aVar.f64330o;
        this.f64308q = aVar.f64331p;
        this.f64309r = aVar.f64332q;
        this.f64310s = aVar.f64333r;
        this.f64311t = aVar.f64334s;
        this.f64312u = aVar.f64335t;
        this.f64313v = aVar.f64336u;
        this.f64314w = aVar.f64337v;
        this.f64315x = aVar.f64338w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            uo uoVar = (uo) obj;
            if (this.f64293a == uoVar.f64293a && this.f64294b == uoVar.f64294b && this.f64295c == uoVar.f64295c && this.f64296d == uoVar.f64296d && this.f64297f == uoVar.f64297f && this.f64298g == uoVar.f64298g && this.f64299h == uoVar.f64299h && this.f64300i == uoVar.f64300i && this.f64303l == uoVar.f64303l && this.f64301j == uoVar.f64301j && this.f64302k == uoVar.f64302k && this.f64304m.equals(uoVar.f64304m) && this.f64305n.equals(uoVar.f64305n) && this.f64306o == uoVar.f64306o && this.f64307p == uoVar.f64307p && this.f64308q == uoVar.f64308q && this.f64309r.equals(uoVar.f64309r) && this.f64310s.equals(uoVar.f64310s) && this.f64311t == uoVar.f64311t && this.f64312u == uoVar.f64312u && this.f64313v == uoVar.f64313v && this.f64314w == uoVar.f64314w && this.f64315x.equals(uoVar.f64315x)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((this.f64293a + 31) * 31) + this.f64294b) * 31) + this.f64295c) * 31) + this.f64296d) * 31) + this.f64297f) * 31) + this.f64298g) * 31) + this.f64299h) * 31) + this.f64300i) * 31) + (this.f64303l ? 1 : 0)) * 31) + this.f64301j) * 31) + this.f64302k) * 31) + this.f64304m.hashCode()) * 31) + this.f64305n.hashCode()) * 31) + this.f64306o) * 31) + this.f64307p) * 31) + this.f64308q) * 31) + this.f64309r.hashCode()) * 31) + this.f64310s.hashCode()) * 31) + this.f64311t) * 31) + (this.f64312u ? 1 : 0)) * 31) + (this.f64313v ? 1 : 0)) * 31) + (this.f64314w ? 1 : 0)) * 31) + this.f64315x.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ uo a(Bundle bundle) {
        return new a(bundle).a();
    }
}
