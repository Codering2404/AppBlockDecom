package com.applovin.impl;

import android.content.Context;
import android.os.Handler;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.applovin.impl.eg;
import com.applovin.impl.y1;
import com.facebook.ads.AdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class s5 implements y1, xo {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final eb f62968p = b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final db f62969q = db.a(6200000L, 3900000L, 2300000L, 1300000L, 620000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final db f62970r = db.a(248000L, 160000L, 142000L, 127000L, 113000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final db f62971s = db.a(2200000L, 1300000L, 950000L, 760000L, 520000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final db f62972t = db.a(4400000L, 2300000L, 1500000L, 1100000L, 640000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final db f62973u = db.a(10000000L, 7200000L, 5000000L, 2700000L, 1600000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final db f62974v = db.a(2600000L, 2200000L, 2000000L, 1500000L, 470000L);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static s5 f62975w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fb f62976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y1.a.C0128a f62977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ik f62978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l3 f62979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f62980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f62982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f62983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f62984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f62985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f62986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f62987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f62988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f62989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f62990o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f62991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f62992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f62993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private l3 f62994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f62995e;

        public b(Context context) {
            this.f62991a = context == null ? null : context.getApplicationContext();
            this.f62992b = b(xp.b(context));
            this.f62993c = AdError.SERVER_ERROR_CODE;
            this.f62994d = l3.f61106a;
            this.f62995e = true;
        }

        private static Map b(String str) {
            db dbVarA = a(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            db dbVar = s5.f62969q;
            map.put(2, (Long) dbVar.get(((Integer) dbVarA.get(0)).intValue()));
            map.put(3, (Long) s5.f62970r.get(((Integer) dbVarA.get(1)).intValue()));
            map.put(4, (Long) s5.f62971s.get(((Integer) dbVarA.get(2)).intValue()));
            map.put(5, (Long) s5.f62972t.get(((Integer) dbVarA.get(3)).intValue()));
            map.put(10, (Long) s5.f62973u.get(((Integer) dbVarA.get(4)).intValue()));
            map.put(9, (Long) s5.f62974v.get(((Integer) dbVarA.get(5)).intValue()));
            map.put(7, (Long) dbVar.get(((Integer) dbVarA.get(0)).intValue()));
            return map;
        }

        public s5 a() {
            return new s5(this.f62991a, this.f62992b, this.f62993c, this.f62994d, this.f62995e);
        }

        private static db a(String str) {
            db dbVarB = s5.f62968p.b(str);
            return dbVarB.isEmpty() ? db.a(2, 2, 2, 2, 2, 2) : dbVarB;
        }
    }

    private s5(Context context, Map map, int i3, l3 l3Var, boolean z2) {
        this.f62976a = fb.a(map);
        this.f62977b = new y1.a.C0128a();
        this.f62978c = new ik(i3);
        this.f62979d = l3Var;
        this.f62980e = z2;
        if (context == null) {
            this.f62984i = 0;
            this.f62987l = a(0);
            return;
        }
        eg egVarB = eg.b(context);
        int iA = egVarB.a();
        this.f62984i = iA;
        this.f62987l = a(iA);
        egVarB.b(new eg.c() { // from class: com.applovin.impl.p40
            @Override // com.applovin.impl.eg.c
            public final void a(int i4) throws Throwable {
                this.f62410a.b(i4);
            }
        });
    }

    @Override // com.applovin.impl.xo
    public void b(h5 h5Var, k5 k5Var, boolean z2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #1 {all -> 0x0072, blocks: (B:3:0x0001, B:7:0x0009, B:11:0x0011, B:13:0x002e, B:23:0x0060, B:22:0x0055), top: B:38:0x0001 }] */
    @Override // com.applovin.impl.xo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c(com.applovin.impl.h5 r11, com.applovin.impl.k5 r12, boolean r13) throws java.lang.Throwable {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r11 = a(r12, r13)     // Catch: java.lang.Throwable -> L72
            if (r11 != 0) goto L9
            monitor-exit(r10)
            return
        L9:
            int r11 = r10.f62981f     // Catch: java.lang.Throwable -> L72
            r12 = 1
            if (r11 <= 0) goto L10
            r11 = r12
            goto L11
        L10:
            r11 = 0
        L11:
            com.applovin.impl.b1.b(r11)     // Catch: java.lang.Throwable -> L72
            com.applovin.impl.l3 r11 = r10.f62979d     // Catch: java.lang.Throwable -> L72
            long r0 = r11.c()     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f62982g     // Catch: java.lang.Throwable -> L72
            long r2 = r0 - r2
            int r5 = (int) r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f62985j     // Catch: java.lang.Throwable -> L72
            long r6 = (long) r5     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.f62985j = r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f62986k     // Catch: java.lang.Throwable -> L72
            long r6 = r10.f62983h     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.f62986k = r2     // Catch: java.lang.Throwable -> L72
            if (r5 <= 0) goto L75
            float r11 = (float) r6     // Catch: java.lang.Throwable -> L72
            r13 = 1174011904(0x45fa0000, float:8000.0)
            float r11 = r11 * r13
            float r13 = (float) r5     // Catch: java.lang.Throwable -> L72
            float r11 = r11 / r13
            com.applovin.impl.ik r13 = r10.f62978c     // Catch: java.lang.Throwable -> L72
            double r2 = (double) r6     // Catch: java.lang.Throwable -> L72
            double r2 = java.lang.Math.sqrt(r2)     // Catch: java.lang.Throwable -> L72
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L72
            r13.a(r2, r11)     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f62985j     // Catch: java.lang.Throwable -> L72
            r6 = 2000(0x7d0, double:9.88E-321)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 >= 0) goto L55
            long r2 = r10.f62986k     // Catch: java.lang.Throwable -> L51
            r6 = 524288(0x80000, double:2.590327E-318)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 < 0) goto L60
            goto L55
        L51:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L7d
        L55:
            com.applovin.impl.ik r11 = r10.f62978c     // Catch: java.lang.Throwable -> L72
            r13 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11.a(r13)     // Catch: java.lang.Throwable -> L72
            long r2 = (long) r11     // Catch: java.lang.Throwable -> L72
            r10.f62987l = r2     // Catch: java.lang.Throwable -> L72
        L60:
            long r6 = r10.f62983h     // Catch: java.lang.Throwable -> L72
            long r8 = r10.f62987l     // Catch: java.lang.Throwable -> L72
            r4 = r10
            r4.a(r5, r6, r8)     // Catch: java.lang.Throwable -> L6f
            r4.f62982g = r0     // Catch: java.lang.Throwable -> L6f
            r0 = 0
            r4.f62983h = r0     // Catch: java.lang.Throwable -> L6f
            goto L76
        L6f:
            r0 = move-exception
        L70:
            r11 = r0
            goto L7d
        L72:
            r0 = move-exception
            r4 = r10
            goto L70
        L75:
            r4 = r10
        L76:
            int r11 = r4.f62981f     // Catch: java.lang.Throwable -> L6f
            int r11 = r11 - r12
            r4.f62981f = r11     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r10)
            return
        L7d:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6f
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.s5.c(com.applovin.impl.h5, com.applovin.impl.k5, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i3) throws Throwable {
        Throwable th;
        try {
            try {
                int i4 = this.f62984i;
                if (i4 != 0) {
                    try {
                        if (!this.f62980e) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (this.f62989n) {
                    i3 = this.f62990o;
                }
                if (i4 == i3) {
                    return;
                }
                this.f62984i = i3;
                if (i3 == 1 || i3 == 0 || i3 == 8) {
                    return;
                }
                this.f62987l = a(i3);
                long jC = this.f62979d.c();
                a(this.f62981f > 0 ? (int) (jC - this.f62982g) : 0, this.f62983h, this.f62987l);
                this.f62982g = jC;
                this.f62983h = 0L;
                this.f62986k = 0L;
                this.f62985j = 0L;
                this.f62978c.c();
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // com.applovin.impl.y1
    public xo a() {
        return this;
    }

    @Override // com.applovin.impl.y1
    public void a(Handler handler, y1.a aVar) {
        b1.a(handler);
        b1.a(aVar);
        this.f62977b.a(handler, aVar);
    }

    private long a(int i3) {
        Long l3 = (Long) this.f62976a.get(Integer.valueOf(i3));
        if (l3 == null) {
            l3 = (Long) this.f62976a.get(0);
        }
        if (l3 == null) {
            l3 = 1000000L;
        }
        return l3.longValue();
    }

    private static boolean a(k5 k5Var, boolean z2) {
        return z2 && !k5Var.b(8);
    }

    private void a(int i3, long j3, long j4) {
        if (i3 == 0 && j3 == 0 && j4 == this.f62988m) {
            return;
        }
        this.f62988m = j4;
        this.f62977b.a(i3, j3, j4);
    }

    @Override // com.applovin.impl.xo
    public synchronized void a(h5 h5Var, k5 k5Var, boolean z2, int i3) {
        if (a(k5Var, z2)) {
            this.f62983h += (long) i3;
        }
    }

    private static eb b() {
        return eb.k().b("AD", 1, 2, 0, 0, 2, 2).b("AE", 1, 4, 4, 4, 2, 2).b("AF", 4, 4, 3, 4, 2, 2).b("AG", 4, 2, 1, 4, 2, 2).b("AI", 1, 2, 2, 2, 2, 2).b("AL", 1, 1, 1, 1, 2, 2).b("AM", 2, 2, 1, 3, 2, 2).b("AO", 3, 4, 3, 1, 2, 2).b("AR", 2, 4, 2, 1, 2, 2).b("AS", 2, 2, 3, 3, 2, 2).b("AT", 0, 1, 0, 0, 0, 2).b("AU", 0, 2, 0, 1, 1, 2).b("AW", 1, 2, 0, 4, 2, 2).b("AX", 0, 2, 2, 2, 2, 2).b("AZ", 3, 3, 3, 4, 4, 2).b("BA", 1, 1, 0, 1, 2, 2).b("BB", 0, 2, 0, 0, 2, 2).b("BD", 2, 0, 3, 3, 2, 2).b("BE", 0, 0, 2, 3, 2, 2).b("BF", 4, 4, 4, 2, 2, 2).b("BG", 0, 1, 0, 0, 2, 2).b("BH", 1, 0, 2, 4, 2, 2).b("BI", 4, 4, 4, 4, 2, 2).b("BJ", 4, 4, 4, 4, 2, 2).b("BL", 1, 2, 2, 2, 2, 2).b("BM", 0, 2, 0, 0, 2, 2).b("BN", 3, 2, 1, 0, 2, 2).b("BO", 1, 2, 4, 2, 2, 2).b("BQ", 1, 2, 1, 2, 2, 2).b("BR", 2, 4, 3, 2, 2, 2).b("BS", 2, 2, 1, 3, 2, 2).b("BT", 3, 0, 3, 2, 2, 2).b("BW", 3, 4, 1, 1, 2, 2).b("BY", 1, 1, 1, 2, 2, 2).b("BZ", 2, 2, 2, 2, 2, 2).b("CA", 0, 3, 1, 2, 4, 2).b("CD", 4, 2, 2, 1, 2, 2).b("CF", 4, 2, 3, 2, 2, 2).b("CG", 3, 4, 2, 2, 2, 2).b("CH", 0, 0, 0, 0, 1, 2).b("CI", 3, 3, 3, 3, 2, 2).b("CK", 2, 2, 3, 0, 2, 2).b("CL", 1, 1, 2, 2, 2, 2).b("CM", 3, 4, 3, 2, 2, 2).b("CN", 2, 2, 2, 1, 3, 2).b("CO", 2, 3, 4, 2, 2, 2).b("CR", 2, 3, 4, 4, 2, 2).b("CU", 4, 4, 2, 2, 2, 2).b("CV", 2, 3, 1, 0, 2, 2).b("CW", 1, 2, 0, 0, 2, 2).b("CY", 1, 1, 0, 0, 2, 2).b("CZ", 0, 1, 0, 0, 1, 2).b("DE", 0, 0, 1, 1, 0, 2).b("DJ", 4, 0, 4, 4, 2, 2).b("DK", 0, 0, 1, 0, 0, 2).b("DM", 1, 2, 2, 2, 2, 2).b("DO", 3, 4, 4, 4, 2, 2).b("DZ", 3, 3, 4, 4, 2, 4).b("EC", 2, 4, 3, 1, 2, 2).b("EE", 0, 1, 0, 0, 2, 2).b(muQRKXGtpOhe.bvvnowoLLaCOT, 3, 4, 3, 3, 2, 2).b("EH", 2, 2, 2, 2, 2, 2).b("ER", 4, 2, 2, 2, 2, 2).b("ES", 0, 1, 1, 1, 2, 2).b("ET", 4, 4, 4, 1, 2, 2).b("FI", 0, 0, 0, 0, 0, 2).b("FJ", 3, 0, 2, 3, 2, 2).b("FK", 4, 2, 2, 2, 2, 2).b("FM", 3, 2, 4, 4, 2, 2).b("FO", 1, 2, 0, 1, 2, 2).b("FR", 1, 1, 2, 0, 1, 2).b("GA", 3, 4, 1, 1, 2, 2).b("GB", 0, 0, 1, 1, 1, 2).b("GD", 1, 2, 2, 2, 2, 2).b("GE", 1, 1, 1, 2, 2, 2).b("GF", 2, 2, 2, 3, 2, 2).b("GG", 1, 2, 0, 0, 2, 2).b("GH", 3, 1, 3, 2, 2, 2).b("GI", 0, 2, 0, 0, 2, 2).b("GL", 1, 2, 0, 0, 2, 2).b("GM", 4, 3, 2, 4, 2, 2).b("GN", 4, 3, 4, 2, 2, 2).b("GP", 2, 1, 2, 3, 2, 2).b("GQ", 4, 2, 2, 4, 2, 2).b("GR", 1, 2, 0, 0, 2, 2).b("GT", 3, 2, 3, 1, 2, 2).b("GU", 1, 2, 3, 4, 2, 2).b("GW", 4, 4, 4, 4, 2, 2).b("GY", 3, 3, 3, 4, 2, 2).b("HK", 0, 1, 2, 3, 2, 0).b("HN", 3, 1, 3, 3, 2, 2).b("HR", 1, 1, 0, 0, 3, 2).b("HT", 4, 4, 4, 4, 2, 2).b("HU", 0, 0, 0, 0, 0, 2).b("ID", 3, 2, 3, 3, 2, 2).b("IE", 0, 0, 1, 1, 3, 2).b("IL", 1, 0, 2, 3, 4, 2).b("IM", 0, 2, 0, 1, 2, 2).b("IN", 2, 1, 3, 3, 2, 2).b("IO", 4, 2, 2, 4, 2, 2).b("IQ", 3, 3, 4, 4, 2, 2).b("IR", 3, 2, 3, 2, 2, 2).b("IS", 0, 2, 0, 0, 2, 2).b("IT", 0, 4, 0, 1, 2, 2).b("JE", 2, 2, 1, 2, 2, 2).b("JM", 3, 3, 4, 4, 2, 2).b("JO", 2, 2, 1, 1, 2, 2).b("JP", 0, 0, 0, 0, 2, 1).b("KE", 3, 4, 2, 2, 2, 2).b("KG", 2, 0, 1, 1, 2, 2).b("KH", 1, 0, 4, 3, 2, 2).b("KI", 4, 2, 4, 3, 2, 2).b("KM", 4, 3, 2, 3, 2, 2).b("KN", 1, 2, 2, 2, 2, 2).b("KP", 4, 2, 2, 2, 2, 2).b("KR", 0, 0, 1, 3, 1, 2).b("KW", 1, 3, 1, 1, 1, 2).b("KY", 1, 2, 0, 2, 2, 2).b("KZ", 2, 2, 2, 3, 2, 2).b("LA", 1, 2, 1, 1, 2, 2).b("LB", 3, 2, 0, 0, 2, 2).b("LC", 1, 2, 0, 0, 2, 2).b("LI", 0, 2, 2, 2, 2, 2).b("LK", 2, 0, 2, 3, 2, 2).b("LR", 3, 4, 4, 3, 2, 2).b("LS", 3, 3, 2, 3, 2, 2).b("LT", 0, 0, 0, 0, 2, 2).b("LU", 1, 0, 1, 1, 2, 2).b("LV", 0, 0, 0, 0, 2, 2).b("LY", 4, 2, 4, 3, 2, 2).b("MA", 3, 2, 2, 1, 2, 2).b("MC", 0, 2, 0, 0, 2, 2).b("MD", 1, 2, 0, 0, 2, 2).b("ME", 1, 2, 0, 1, 2, 2).b("MF", 2, 2, 1, 1, 2, 2).b("MG", 3, 4, 2, 2, 2, 2).b("MH", 4, 2, 2, 4, 2, 2).b("MK", 1, 1, 0, 0, 2, 2).b("ML", 4, 4, 2, 2, 2, 2).b("MM", 2, 3, 3, 3, 2, 2).b("MN", 2, 4, 2, 2, 2, 2).b("MO", 0, 2, 4, 4, 2, 2).b("MP", 0, 2, 2, 2, 2, 2).b("MQ", 2, 2, 2, 3, 2, 2).b("MR", 3, 0, 4, 3, 2, 2).b("MS", 1, 2, 2, 2, 2, 2).b("MT", 0, 2, 0, 0, 2, 2).b("MU", 2, 1, 1, 2, 2, 2).b("MV", 4, 3, 2, 4, 2, 2).b("MW", 4, 2, 1, 0, 2, 2).b("MX", 2, 4, 4, 4, 4, 2).b("MY", 1, 0, 3, 2, 2, 2).b("MZ", 3, 3, 2, 1, 2, 2).b("NA", 4, 3, 3, 2, 2, 2).b("NC", 3, 0, 4, 4, 2, 2).b("NE", 4, 4, 4, 4, 2, 2).b("NF", 2, 2, 2, 2, 2, 2).b("NG", 3, 3, 2, 3, 2, 2).b("NI", 2, 1, 4, 4, 2, 2).b("NL", 0, 2, 3, 2, 0, 2).b("NO", 0, 1, 2, 0, 0, 2).b("NP", 2, 0, 4, 2, 2, 2).b("NR", 3, 2, 3, 1, 2, 2).b("NU", 4, 2, 2, 2, 2, 2).b("NZ", 0, 2, 1, 2, 4, 2).b("OM", 2, 2, 1, 3, 3, 2).b("PA", 1, 3, 3, 3, 2, 2).b("PE", 2, 3, 4, 4, 2, 2).b("PF", 2, 2, 2, 1, 2, 2).b("PG", 4, 4, 3, 2, 2, 2).b("PH", 2, 1, 3, 3, 3, 2).b("PK", 3, 2, 3, 3, 2, 2).b("PL", 1, 0, 1, 2, 3, 2).b("PM", 0, 2, 2, 2, 2, 2).b("PR", 2, 1, 2, 2, 4, 3).b("PS", 3, 3, 2, 2, 2, 2).b("PT", 0, 1, 1, 0, 2, 2).b("PW", 1, 2, 4, 1, 2, 2).b("PY", 2, 0, 3, 2, 2, 2).b("QA", 2, 3, 1, 2, 3, 2).b("RE", 1, 0, 2, 2, 2, 2).b("RO", 0, 1, 0, 1, 0, 2).b("RS", 1, 2, 0, 0, 2, 2).b("RU", 0, 1, 0, 1, 4, 2).b("RW", 3, 3, 3, 1, 2, 2).b("SA", 2, 2, 2, 1, 1, 2).b("SB", 4, 2, 3, 2, 2, 2).b("SC", 4, 2, 1, 3, 2, 2).b("SD", 4, 4, 4, 4, 2, 2).b("SE", 0, 0, 0, 0, 0, 2).b("SG", 1, 0, 1, 2, 3, 2).b("SH", 4, 2, 2, 2, 2, 2).b("SI", 0, 0, 0, 0, 2, 2).b("SJ", 2, 2, 2, 2, 2, 2).b("SK", 0, 1, 0, 0, 2, 2).b("SL", 4, 3, 4, 0, 2, 2).b("SM", 0, 2, 2, 2, 2, 2).b("SN", 4, 4, 4, 4, 2, 2).b("SO", 3, 3, 3, 4, 2, 2).b("SR", 3, 2, 2, 2, 2, 2).b("SS", 4, 4, 3, 3, 2, 2).b("ST", 2, 2, 1, 2, 2, 2).b("SV", 2, 1, 4, 3, 2, 2).b("SX", 2, 2, 1, 0, 2, 2).b("SY", 4, 3, 3, 2, 2, 2).b("SZ", 3, 3, 2, 4, 2, 2).b("TC", 2, 2, 2, 0, 2, 2).b("TD", 4, 3, 4, 4, 2, 2).b("TG", 3, 2, 2, 4, 2, 2).b("TH", 0, 3, 2, 3, 2, 2).b("TJ", 4, 4, 4, 4, 2, 2).b("TL", 4, 0, 4, 4, 2, 2).b("TM", 4, 2, 4, 3, 2, 2).b("TN", 2, 1, 1, 2, 2, 2).b("TO", 3, 3, 4, 3, 2, 2).b("TR", 1, 2, 1, 1, 2, 2).b("TT", 1, 4, 0, 1, 2, 2).b("TV", 3, 2, 2, 4, 2, 2).b("TW", 0, 0, 0, 0, 1, 0).b("TZ", 3, 3, 3, 2, 2, 2).b("UA", 0, 3, 1, 1, 2, 2).b("UG", 3, 2, 3, 3, 2, 2).b("US", 1, 1, 2, 2, 4, 2).b("UY", 2, 2, 1, 1, 2, 2).b("UZ", 2, 1, 3, 4, 2, 2).b("VC", 1, 2, 2, 2, 2, 2).b("VE", 4, 4, 4, 4, 2, 2).b("VG", 2, 2, 1, 1, 2, 2).b("VI", 1, 2, 1, 2, 2, 2).b("VN", 0, 1, 3, 4, 2, 2).b("VU", 4, 0, 3, 1, 2, 2).b("WF", 4, 2, 2, 4, 2, 2).b("WS", 3, 1, 3, 1, 2, 2).b("XK", 0, 1, 1, 0, 2, 2).b("YE", 4, 4, 4, 3, 2, 2).b("YT", 4, 2, 2, 3, 2, 2).b("ZA", 3, 3, 2, 1, 2, 2).b("ZM", 3, 2, 3, 3, 2, 2).b("ZW", 3, 2, 4, 3, 2, 2).c();
    }

    @Override // com.applovin.impl.xo
    public synchronized void a(h5 h5Var, k5 k5Var, boolean z2) {
        try {
            if (a(k5Var, z2)) {
                if (this.f62981f == 0) {
                    this.f62982g = this.f62979d.c();
                }
                this.f62981f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.applovin.impl.y1
    public void a(y1.a aVar) {
        this.f62977b.a(aVar);
    }

    public static synchronized s5 a(Context context) {
        try {
            if (f62975w == null) {
                f62975w = new b(context).a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f62975w;
    }
}
