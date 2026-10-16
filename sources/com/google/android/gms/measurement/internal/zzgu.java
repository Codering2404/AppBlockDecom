package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgu extends zzjf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char f73727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f73728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f73729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzgs f73730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzgs f73731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzgs f73732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzgs f73733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzgs f73734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzgs f73735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzgs f73736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzgs f73737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzgs f73738n;

    zzgu(zzic zzicVar) {
        super(zzicVar);
        this.f73727c = (char) 0;
        this.f73728d = -1L;
        this.f73730f = new zzgs(this, 6, false, false);
        this.f73731g = new zzgs(this, 6, true, false);
        this.f73732h = new zzgs(this, 6, false, true);
        this.f73733i = new zzgs(this, 5, false, false);
        this.f73734j = new zzgs(this, 5, true, false);
        this.f73735k = new zzgs(this, 5, false, true);
        this.f73736l = new zzgs(this, 4, false, false);
        this.f73737m = new zzgs(this, 3, false, false);
        this.f73738n = new zzgs(this, 2, false, false);
    }

    static String A(boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String strB = B(z2, obj);
        String strB2 = B(z2, obj2);
        String strB3 = B(z2, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strB)) {
            sb.append(str2);
            sb.append(strB);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strB2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strB2);
        }
        if (!TextUtils.isEmpty(strB3)) {
            sb.append(str3);
            sb.append(strB3);
        }
        return sb.toString();
    }

    static String B(boolean z2, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i3 = 0;
        if (obj instanceof Long) {
            if (!z2) {
                return obj.toString();
            }
            Long l3 = (Long) obj;
            if (Math.abs(l3.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l3.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + length + 3 + str.length() + String.valueOf(jRound2).length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof zzgt ? ((zzgt) obj).a() : z2 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z2 ? th.getClass().getName() : th.toString());
        String strC = C(zzic.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        while (true) {
            if (i3 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(strC)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i3++;
        }
        return sb2.toString();
    }

    static String C(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(46)) == -1) ? "" : str.substring(0, iLastIndexOf);
    }

    protected static Object x(String str) {
        if (str == null) {
            return null;
        }
        return new zzgt(str);
    }

    final /* synthetic */ char D() {
        return this.f73727c;
    }

    final /* synthetic */ void E(char c3) {
        this.f73727c = c3;
    }

    final /* synthetic */ long F() {
        return this.f73728d;
    }

    final /* synthetic */ void G(long j3) {
        this.f73728d = 133005L;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean i() {
        return false;
    }

    public final zzgs o() {
        return this.f73730f;
    }

    public final zzgs p() {
        return this.f73731g;
    }

    public final zzgs q() {
        return this.f73732h;
    }

    public final zzgs r() {
        return this.f73733i;
    }

    public final zzgs s() {
        return this.f73734j;
    }

    public final zzgs t() {
        return this.f73735k;
    }

    public final zzgs u() {
        return this.f73736l;
    }

    public final zzgs v() {
        return this.f73737m;
    }

    public final zzgs w() {
        return this.f73738n;
    }

    protected final void y(int i3, boolean z2, boolean z3, String str, Object obj, Object obj2, Object obj3) {
        if (!z2 && Log.isLoggable(z(), i3)) {
            Log.println(i3, z(), A(false, str, obj, obj2, obj3));
        }
        if (z3 || i3 < 5) {
            return;
        }
        Preconditions.m(str);
        zzhz zzhzVarA = this.f73997a.A();
        if (zzhzVarA == null) {
            Log.println(6, z(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzhzVarA.k()) {
                Log.println(6, z(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i3 >= 9) {
                i3 = 8;
            }
            zzhzVarA.t(new zzgr(this, i3, str, obj, obj2, obj3));
        }
    }

    protected final String z() {
        String str;
        synchronized (this) {
            try {
                if (this.f73729e == null) {
                    this.f73729e = this.f73997a.w().u();
                }
                Preconditions.m(this.f73729e);
                str = this.f73729e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
