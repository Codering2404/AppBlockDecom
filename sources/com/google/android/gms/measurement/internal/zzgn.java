package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final AtomicReference f73706b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final AtomicReference f73707c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final AtomicReference f73708d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgm f73709a;

    public zzgn(zzgm zzgmVar) {
        this.f73709a = zzgmVar;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        Preconditions.m(strArr);
        Preconditions.m(strArr2);
        Preconditions.m(atomicReference);
        Preconditions.a(strArr.length == strArr2.length);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (Objects.equals(str, strArr[i3])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i3];
                        if (str2 == null) {
                            str2 = strArr2[i3] + "(" + strArr[i3] + ")";
                            strArr3[i3] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    protected final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f73709a.zza() ? str : g(str, zzjm.f74020c, zzjm.f74018a, f73706b);
    }

    protected final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f73709a.zza() ? str : g(str, zzjn.f74023b, zzjn.f74022a, f73707c);
    }

    protected final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f73709a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, zzjo.f74027b, zzjo.f74026a, f73708d);
        }
        return "experiment_id(" + str + ")";
    }

    protected final String d(zzbg zzbgVar) {
        zzgm zzgmVar = this.f73709a;
        if (!zzgmVar.zza()) {
            return zzbgVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzbgVar.f73486c);
        sb.append(",name=");
        sb.append(a(zzbgVar.f73484a));
        sb.append(",params=");
        zzbe zzbeVar = zzbgVar.f73485b;
        sb.append(zzbeVar == null ? null : !zzgmVar.zza() ? zzbeVar.toString() : e(zzbeVar.w0()));
        return sb.toString();
    }

    protected final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f73709a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(str));
            sb.append("=");
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    protected final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strE);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
