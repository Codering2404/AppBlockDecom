package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbnp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List f76487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzbnp f76488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzbnp f76489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzbnp f76490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzbnp f76491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzbnp f76492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzbnp f76493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzbnp f76494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final zzbnp f76495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zzbnp f76496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final zzbmc f76497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final zzbmf f76498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final zzbmc f76499p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnm f76500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f76502c;

    static {
        TreeMap treeMap = new TreeMap();
        zzbnm[] zzbnmVarArrValues = zzbnm.values();
        int length = zzbnmVarArrValues.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            byte[] bArr = null;
            if (i3 >= length) {
                f76487d = Collections.unmodifiableList(new ArrayList(treeMap.values()));
                f76488e = zzbnm.OK.a();
                f76489f = zzbnm.CANCELLED.a();
                f76490g = zzbnm.UNKNOWN.a();
                zzbnm.INVALID_ARGUMENT.a();
                f76491h = zzbnm.DEADLINE_EXCEEDED.a();
                zzbnm.NOT_FOUND.a();
                zzbnm.ALREADY_EXISTS.a();
                f76492i = zzbnm.PERMISSION_DENIED.a();
                zzbnm.UNAUTHENTICATED.a();
                f76493j = zzbnm.RESOURCE_EXHAUSTED.a();
                f76494k = zzbnm.FAILED_PRECONDITION.a();
                zzbnm.ABORTED.a();
                zzbnm.OUT_OF_RANGE.a();
                zzbnm.UNIMPLEMENTED.a();
                f76495l = zzbnm.INTERNAL.a();
                f76496m = zzbnm.UNAVAILABLE.a();
                zzbnm.DATA_LOSS.a();
                zzbnn zzbnnVar = new zzbnn(bArr);
                int i4 = zzbmc.f76393e;
                f76497n = new zzbme("grpc-status", z2, zzbnnVar, bArr);
                zzbno zzbnoVar = new zzbno(null);
                f76498o = zzbnoVar;
                f76499p = new zzbme("grpc-message", z2, zzbnoVar, bArr);
                return;
            }
            zzbnm zzbnmVar = zzbnmVarArrValues[i3];
            zzbnp zzbnpVar = (zzbnp) treeMap.put(Integer.valueOf(zzbnmVar.zza()), new zzbnp(zzbnmVar, null, null));
            if (zzbnpVar != null) {
                String strName = zzbnpVar.f76500a.name();
                String strName2 = zzbnmVar.name();
                StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 34 + String.valueOf(strName2).length());
                sb.append("Code value duplication between ");
                sb.append(strName);
                sb.append(" & ");
                sb.append(strName2);
                throw new IllegalStateException(sb.toString());
            }
            i3++;
        }
    }

    private zzbnp(zzbnm zzbnmVar, String str, Throwable th) {
        this.f76500a = (zzbnm) Preconditions.u(zzbnmVar, "code");
        this.f76501b = str;
        this.f76502c = th;
    }

    public static zzbnp a(int i3) {
        if (i3 >= 0) {
            List list = f76487d;
            if (i3 < list.size()) {
                return (zzbnp) list.get(i3);
            }
        }
        zzbnp zzbnpVar = f76490g;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 13);
        sb.append("Unknown code ");
        sb.append(i3);
        return zzbnpVar.e(sb.toString());
    }

    public static zzbnp b(Throwable th) {
        for (Throwable cause = (Throwable) Preconditions.u(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof zzbnq) {
                return ((zzbnq) cause).a();
            }
            if (cause instanceof zzbns) {
                return ((zzbns) cause).a();
            }
        }
        return f76490g.d(th);
    }

    static String c(zzbnp zzbnpVar) {
        String str = zzbnpVar.f76501b;
        zzbnm zzbnmVar = zzbnpVar.f76500a;
        if (str == null) {
            return zzbnmVar.toString();
        }
        String strValueOf = String.valueOf(zzbnmVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 2 + str.length());
        sb.append(strValueOf);
        sb.append(": ");
        sb.append(str);
        return sb.toString();
    }

    static /* synthetic */ zzbnp k(byte[] bArr) {
        int i3;
        byte b3;
        int length = bArr.length;
        char c3 = 0;
        if (length == 1) {
            if (bArr[0] == 48) {
                return f76488e;
            }
            length = 1;
        }
        if (length != 1) {
            if (length == 2 && (b3 = bArr[0]) >= 48 && b3 <= 57) {
                i3 = (b3 - 48) * 10;
                c3 = 1;
            }
            return f76490g.e("Unknown code ".concat(new String(bArr, StandardCharsets.US_ASCII)));
        }
        i3 = 0;
        byte b4 = bArr[c3];
        if (b4 >= 48 && b4 <= 57) {
            int i4 = i3 + (b4 - 48);
            List list = f76487d;
            if (i4 < list.size()) {
                return (zzbnp) list.get(i4);
            }
        }
        return f76490g.e("Unknown code ".concat(new String(bArr, StandardCharsets.US_ASCII)));
    }

    public final zzbnp d(Throwable th) {
        return Objects.a(this.f76502c, th) ? this : new zzbnp(this.f76500a, this.f76501b, th);
    }

    public final zzbnp e(String str) {
        return Objects.a(this.f76501b, str) ? this : new zzbnp(this.f76500a, str, this.f76502c);
    }

    public final zzbnp f(String str) {
        String str2 = this.f76501b;
        if (str2 == null) {
            return new zzbnp(this.f76500a, str, this.f76502c);
        }
        zzbnm zzbnmVar = this.f76500a;
        StringBuilder sb = new StringBuilder(str2.length() + 1 + str.length());
        sb.append(str2);
        sb.append("\n");
        sb.append(str);
        return new zzbnp(zzbnmVar, sb.toString(), this.f76502c);
    }

    public final zzbnm g() {
        return this.f76500a;
    }

    public final String h() {
        return this.f76501b;
    }

    public final Throwable i() {
        return this.f76502c;
    }

    public final boolean j() {
        return zzbnm.OK == this.f76500a;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperD = MoreObjects.c(this).d("code", this.f76500a.name()).d("description", this.f76501b);
        Throwable th = this.f76502c;
        Object objI = th;
        if (th != null) {
            objI = Throwables.i(th);
        }
        return toStringHelperD.d("cause", objI).toString();
    }
}
