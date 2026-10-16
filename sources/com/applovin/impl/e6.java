package com.applovin.impl;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e6 implements kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q5 f59361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f59362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f59363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f59364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f59365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f59366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f59367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f59368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f59369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f59370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f59371k;

    public e6() {
        this(new q5(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    private static void a(int i3, int i4, String str, String str2) {
        b1.a(i3 >= i4, str + " cannot be less than " + str2);
    }

    @Override // com.applovin.impl.kc
    public n0 b() {
        return this.f59361a;
    }

    @Override // com.applovin.impl.kc
    public void c() {
        a(true);
    }

    @Override // com.applovin.impl.kc
    public long d() {
        return this.f59368h;
    }

    @Override // com.applovin.impl.kc
    public void e() {
        a(true);
    }

    @Override // com.applovin.impl.kc
    public void f() {
        a(false);
    }

    protected e6(q5 q5Var, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8, boolean z3) {
        a(i5, 0, "bufferForPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        a(i6, 0, "bufferForPlaybackAfterRebufferMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        a(i3, i5, "minBufferMs", "bufferForPlaybackMs");
        a(i3, i6, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i4, i3, "maxBufferMs", "minBufferMs");
        a(i8, 0, "backBufferDurationMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f59361a = q5Var;
        this.f59362b = t2.a(i3);
        this.f59363c = t2.a(i4);
        this.f59364d = t2.a(i5);
        this.f59365e = t2.a(i6);
        this.f59366f = i7;
        this.f59370j = i7 == -1 ? 13107200 : i7;
        this.f59367g = z2;
        this.f59368h = t2.a(i8);
        this.f59369i = z3;
    }

    protected int a(qi[] qiVarArr, g8[] g8VarArr) {
        int iA = 0;
        for (int i3 = 0; i3 < qiVarArr.length; i3++) {
            if (g8VarArr[i3] != null) {
                iA += a(qiVarArr[i3].e());
            }
        }
        return Math.max(13107200, iA);
    }

    private static int a(int i3) {
        switch (i3) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    @Override // com.applovin.impl.kc
    public void a(qi[] qiVarArr, po poVar, g8[] g8VarArr) {
        int iA = this.f59366f;
        if (iA == -1) {
            iA = a(qiVarArr, g8VarArr);
        }
        this.f59370j = iA;
        this.f59361a.a(iA);
    }

    private void a(boolean z2) {
        int i3 = this.f59366f;
        if (i3 == -1) {
            i3 = 13107200;
        }
        this.f59370j = i3;
        this.f59371k = false;
        if (z2) {
            this.f59361a.e();
        }
    }

    @Override // com.applovin.impl.kc
    public boolean a() {
        return this.f59369i;
    }

    @Override // com.applovin.impl.kc
    public boolean a(long j3, long j4, float f3) {
        boolean z2 = true;
        boolean z3 = this.f59361a.d() >= this.f59370j;
        long jMin = this.f59362b;
        if (f3 > 1.0f) {
            jMin = Math.min(xp.a(jMin, f3), this.f59363c);
        }
        if (j4 < Math.max(jMin, 500000L)) {
            if (!this.f59367g && z3) {
                z2 = false;
            }
            this.f59371k = z2;
            if (!z2 && j4 < 500000) {
                oc.d("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j4 >= this.f59363c || z3) {
            this.f59371k = false;
        }
        return this.f59371k;
    }

    @Override // com.applovin.impl.kc
    public boolean a(long j3, float f3, boolean z2, long j4) {
        long jB = xp.b(j3, f3);
        long jMin = z2 ? this.f59365e : this.f59364d;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(j4 / 2, jMin);
        }
        if (jMin <= 0 || jB >= jMin) {
            return true;
        }
        return !this.f59367g && this.f59361a.d() >= this.f59370j;
    }
}
