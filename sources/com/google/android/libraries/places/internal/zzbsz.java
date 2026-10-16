package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbsz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f76820a = Logger.getLogger(zzbsz.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f76821b = Collections.unmodifiableSet(EnumSet.of(zzbnm.OK, zzbnm.INVALID_ARGUMENT, zzbnm.NOT_FOUND, zzbnm.ALREADY_EXISTS, zzbnm.FAILED_PRECONDITION, zzbnm.ABORTED, zzbnm.OUT_OF_RANGE, zzbnm.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzbmc f76822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbmc f76823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzbmc f76824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzbmc f76825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzbmc f76826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final zzbmc f76827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzbmc f76828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzbmc f76829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzbmc f76830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f76831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zzbnh f76832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final zzbir f76833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final zzbje f76834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final zzbzx f76835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final zzbzx f76836q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Supplier f76837r;

    static {
        Charset.forName("US-ASCII");
        f76822c = zzbmc.c("grpc-timeout", new zzbsy());
        zzbmb zzbmbVar = zzbmg.f76399d;
        f76823d = zzbmc.c("grpc-encoding", zzbmbVar);
        f76824e = zzbkw.a("grpc-accept-encoding", new zzbsw(null));
        f76825f = zzbmc.c("content-encoding", zzbmbVar);
        f76826g = zzbkw.a("accept-encoding", new zzbsw(null));
        f76827h = zzbmc.c("content-length", zzbmbVar);
        f76828i = zzbmc.c("content-type", zzbmbVar);
        f76829j = zzbmc.c("te", zzbmbVar);
        f76830k = zzbmc.c("user-agent", zzbmbVar);
        Splitter.f(',').n();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f76831l = timeUnit.toNanos(20L);
        TimeUnit.HOURS.toNanos(2L);
        timeUnit.toNanos(20L);
        f76832m = new zzbxn();
        f76833n = zzbir.a("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f76834o = new zzbss();
        f76835p = new zzbst();
        f76836q = new zzbsu();
        f76837r = new zzbsv();
    }

    private zzbsz() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.libraries.places.internal.zzbnp a(int r3) {
        /*
            r0 = 100
            if (r3 < r0) goto Lb
            r0 = 200(0xc8, float:2.8E-43)
            if (r3 >= r0) goto Lb
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.INTERNAL
            goto L37
        Lb:
            r0 = 400(0x190, float:5.6E-43)
            if (r3 == r0) goto L35
            r0 = 401(0x191, float:5.62E-43)
            if (r3 == r0) goto L32
            r0 = 403(0x193, float:5.65E-43)
            if (r3 == r0) goto L2f
            r0 = 404(0x194, float:5.66E-43)
            if (r3 == r0) goto L2c
            r0 = 429(0x1ad, float:6.01E-43)
            if (r3 == r0) goto L29
            r0 = 431(0x1af, float:6.04E-43)
            if (r3 == r0) goto L35
            switch(r3) {
                case 502: goto L29;
                case 503: goto L29;
                case 504: goto L29;
                default: goto L26;
            }
        L26:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.UNKNOWN
            goto L37
        L29:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.UNAVAILABLE
            goto L37
        L2c:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.UNIMPLEMENTED
            goto L37
        L2f:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.PERMISSION_DENIED
            goto L37
        L32:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.UNAUTHENTICATED
            goto L37
        L35:
            com.google.android.libraries.places.internal.zzbnm r0 = com.google.android.libraries.places.internal.zzbnm.INTERNAL
        L37:
            com.google.android.libraries.places.internal.zzbnp r0 = r0.a()
            java.lang.String r1 = java.lang.String.valueOf(r3)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 17
            r2.<init>(r1)
            java.lang.String r1 = "HTTP status code "
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
            com.google.android.libraries.places.internal.zzbnp r3 = r0.e(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbsz.a(int):com.google.android.libraries.places.internal.zzbnp");
    }

    public static URI b(String str) {
        String str2;
        Preconditions.u(str, "authority");
        try {
            str2 = str;
            try {
                return new URI(null, str2, null, null, null);
            } catch (URISyntaxException e3) {
                e = e3;
                throw new IllegalArgumentException("Invalid authority: ".concat(String.valueOf(str2)), e);
            }
        } catch (URISyntaxException e4) {
            e = e4;
            str2 = str;
        }
    }

    public static String c(String str, int i3) {
        String str2;
        try {
            str2 = str;
            try {
                return new URI(null, null, str2, 443, null, null, null).getAuthority();
            } catch (URISyntaxException e3) {
                e = e3;
                URISyntaxException uRISyntaxException = e;
                StringBuilder sb = new StringBuilder(str2.length() + 26);
                sb.append("Invalid host or port: ");
                sb.append(str2);
                sb.append(" 443");
                throw new IllegalArgumentException(sb.toString(), uRISyntaxException);
            }
        } catch (URISyntaxException e4) {
            e = e4;
            str2 = str;
        }
    }

    public static ThreadFactory d(String str, boolean z2) {
        return new ThreadFactoryBuilder().e(true).f(str).b();
    }

    static zzbpo e(zzbli zzbliVar, boolean z2) {
        zzblm zzblmVarE = zzbliVar.e();
        zzbpo zzbpoVarZza = zzblmVarE != null ? ((zzcai) zzblmVarE.e()).zza() : null;
        if (zzbpoVarZza != null) {
            return zzbpoVarZza;
        }
        if (!zzbliVar.f().j()) {
            if (zzbliVar.g()) {
                return new zzbsj(i(zzbliVar.f()), zzbpm.DROPPED);
            }
            if (!z2) {
                return new zzbsj(i(zzbliVar.f()), zzbpm.PROCESSED);
            }
        }
        return null;
    }

    public static zzbje[] f(zzbis zzbisVar, zzbmg zzbmgVar, int i3, boolean z2, boolean z3) {
        List listG = zzbisVar.g();
        int size = listG.size();
        zzbje[] zzbjeVarArr = new zzbje[size + 1];
        zzbjc zzbjcVarA = zzbjd.a();
        zzbjcVarA.a(zzbisVar);
        zzbjcVarA.b(i3);
        zzbjcVarA.c(z2);
        zzbjcVarA.d(z3);
        zzbjd zzbjdVarE = zzbjcVarA.e();
        for (int i4 = 0; i4 < listG.size(); i4++) {
            zzbjeVarArr[i4] = ((zzbjb) listG.get(i4)).a(zzbjdVarE, zzbmgVar);
        }
        zzbjeVarArr[size] = f76834o;
        return zzbjeVarArr;
    }

    static void g(zzcac zzcacVar) {
        while (true) {
            InputStream inputStreamZza = zzcacVar.zza();
            if (inputStreamZza == null) {
                return;
            } else {
                h(inputStreamZza);
            }
        }
    }

    public static void h(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e3) {
            f76820a.logp(Level.WARNING, "io.grpc.internal.GrpcUtil", "closeQuietly", "exception caught in closeQuietly", (Throwable) e3);
        }
    }

    public static zzbnp i(zzbnp zzbnpVar) {
        Preconditions.d(zzbnpVar != null);
        if (!f76821b.contains(zzbnpVar.g())) {
            return zzbnpVar;
        }
        zzbnp zzbnpVar2 = zzbnp.f76495l;
        String strValueOf = String.valueOf(zzbnpVar.g());
        String strH = zzbnpVar.h();
        StringBuilder sb = new StringBuilder(strValueOf.length() + 47 + String.valueOf(strH).length());
        sb.append("Inappropriate status code from control plane: ");
        sb.append(strValueOf);
        sb.append(" ");
        sb.append(strH);
        return zzbnpVar2.e(sb.toString()).d(zzbnpVar.i());
    }

    public static boolean j(String str, boolean z2) {
        String strTrim = System.getenv(str);
        if (strTrim == null) {
            strTrim = System.getProperty(str);
        }
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        return z2 ? Strings.b(strTrim) || Boolean.parseBoolean(strTrim) : !Strings.b(strTrim) && Boolean.parseBoolean(strTrim);
    }
}
