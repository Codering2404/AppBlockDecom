package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.impl.o2;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z7 extends nh {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o2.a f65377l = new o2.a() { // from class: com.applovin.impl.k90
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return z7.c(bundle);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f65378d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f65379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f65380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e9 f65381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f65382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final xd f65383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f65384k;

    private z7(int i3, Throwable th, int i4) {
        this(i3, th, null, i4, null, -1, null, 4, false);
    }

    public static z7 a(Throwable th, String str, int i3, e9 e9Var, int i4, boolean z2, int i5) {
        if (e9Var == null) {
            i4 = 4;
        }
        return new z7(1, th, null, i5, str, i3, e9Var, i4, z2);
    }

    public static /* synthetic */ z7 c(Bundle bundle) {
        return new z7(bundle);
    }

    private z7(int i3, Throwable th, String str, int i4, String str2, int i5, e9 e9Var, int i6, boolean z2) {
        this(a(i3, str, str2, i5, e9Var, i6), th, i4, i3, str2, i5, e9Var, i6, null, SystemClock.elapsedRealtime(), z2);
    }

    public static z7 a(RuntimeException runtimeException) {
        return a(runtimeException, 1000);
    }

    private static String a(int i3, String str, String str2, int i4, e9 e9Var, int i5) {
        String str3;
        if (i3 == 0) {
            str3 = "Source error";
        } else if (i3 == 1) {
            str3 = str2 + " error, index=" + i4 + ", format=" + e9Var + ", format_supported=" + t2.b(i5);
        } else if (i3 != 3) {
            str3 = "Unexpected runtime error";
        } else {
            str3 = "Remote error";
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    private z7(Bundle bundle) {
        super(bundle);
        this.f65378d = bundle.getInt(nh.b(AdError.NO_FILL_ERROR_CODE), 2);
        this.f65379f = bundle.getString(nh.b(1002));
        this.f65380g = bundle.getInt(nh.b(1003), -1);
        this.f65381h = (e9) p2.a(e9.I, bundle.getBundle(nh.b(1004)));
        this.f65382i = bundle.getInt(nh.b(1005), 4);
        this.f65384k = bundle.getBoolean(nh.b(CloseCodes.CLOSED_ABNORMALLY), false);
        this.f65383j = null;
    }

    public static z7 a(IOException iOException, int i3) {
        return new z7(0, iOException, i3);
    }

    public static z7 a(RuntimeException runtimeException, int i3) {
        return new z7(2, runtimeException, i3);
    }

    z7 a(xd xdVar) {
        return new z7((String) xp.a((Object) getMessage()), getCause(), this.f62049a, this.f65378d, this.f65379f, this.f65380g, this.f65381h, this.f65382i, xdVar, this.f62050b, this.f65384k);
    }

    private z7(String str, Throwable th, int i3, int i4, String str2, int i5, e9 e9Var, int i6, xd xdVar, long j3, boolean z2) {
        super(str, th, i3, j3);
        b1.a(!z2 || i4 == 1);
        b1.a(th != null || i4 == 3);
        this.f65378d = i4;
        this.f65379f = str2;
        this.f65380g = i5;
        this.f65381h = e9Var;
        this.f65382i = i6;
        this.f65383j = xdVar;
        this.f65384k = z2;
    }
}
