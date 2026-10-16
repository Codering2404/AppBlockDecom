package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f73464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f73465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f73466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f73467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f73468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzbe f73469f;

    zzbb(zzic zzicVar, String str, String str2, String str3, long j3, long j4, Bundle bundle) {
        zzbe zzbeVar;
        Preconditions.g(str2);
        Preconditions.g(str3);
        this.f73464a = str2;
        this.f73465b = str3;
        this.f73466c = true == TextUtils.isEmpty(str) ? null : str;
        this.f73467d = j3;
        this.f73468e = j4;
        if (j4 != 0 && j4 > j3) {
            zzicVar.a().r().b("Event created with reverse previous/current timestamps. appId", zzgu.x(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbeVar = new zzbe(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzicVar.a().o().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objS = zzicVar.C().s(next, bundle2.get(next));
                    if (objS == null) {
                        zzicVar.a().r().b("Param value can't be null", zzicVar.D().b(next));
                        it.remove();
                    } else {
                        zzicVar.C().A(bundle2, next, objS);
                    }
                }
            }
            zzbeVar = new zzbe(bundle2);
        }
        this.f73469f = zzbeVar;
    }

    final zzbb a(zzic zzicVar, long j3) {
        return new zzbb(zzicVar, this.f73466c, this.f73464a, this.f73465b, this.f73467d, j3, this.f73469f);
    }

    public final String toString() {
        String string = this.f73469f.toString();
        String str = this.f73464a;
        int length = String.valueOf(str).length();
        String str2 = this.f73465b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }

    private zzbb(zzic zzicVar, String str, String str2, String str3, long j3, long j4, zzbe zzbeVar) {
        Preconditions.g(str2);
        Preconditions.g(str3);
        Preconditions.m(zzbeVar);
        this.f73464a = str2;
        this.f73465b = str3;
        this.f73466c = true == TextUtils.isEmpty(str) ? null : str;
        this.f73467d = j3;
        this.f73468e = j4;
        if (j4 != 0 && j4 > j3) {
            zzicVar.a().r().c("Event created with reverse previous/current timestamps. appId, name", zzgu.x(str2), zzgu.x(str3));
        }
        this.f73469f = zzbeVar;
    }
}
