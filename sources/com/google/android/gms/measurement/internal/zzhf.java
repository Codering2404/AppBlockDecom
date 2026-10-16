package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f73800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f73801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f73802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f73803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzhh f73804e;

    /* synthetic */ zzhf(zzhh zzhhVar, String str, long j3, byte[] bArr) {
        Objects.requireNonNull(zzhhVar);
        this.f73804e = zzhhVar;
        Preconditions.g("health_monitor");
        Preconditions.a(j3 > 0);
        this.f73800a = "health_monitor:start";
        this.f73801b = "health_monitor:count";
        this.f73802c = "health_monitor:value";
        this.f73803d = j3;
    }

    private final void c() {
        zzhh zzhhVar = this.f73804e;
        zzhhVar.h();
        long jCurrentTimeMillis = zzhhVar.f73997a.e().currentTimeMillis();
        SharedPreferences.Editor editorEdit = zzhhVar.p().edit();
        editorEdit.remove(this.f73801b);
        editorEdit.remove(this.f73802c);
        editorEdit.putLong(this.f73800a, jCurrentTimeMillis);
        editorEdit.apply();
    }

    private final long d() {
        return this.f73804e.p().getLong(this.f73800a, 0L);
    }

    public final void a(String str, long j3) {
        zzhh zzhhVar = this.f73804e;
        zzhhVar.h();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences sharedPreferencesP = zzhhVar.p();
        String str2 = this.f73801b;
        long j4 = sharedPreferencesP.getLong(str2, 0L);
        if (j4 <= 0) {
            SharedPreferences.Editor editorEdit = zzhhVar.p().edit();
            editorEdit.putString(this.f73802c, str);
            editorEdit.putLong(str2, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = zzhhVar.f73997a.C().q0().nextLong() & Long.MAX_VALUE;
        long j5 = j4 + 1;
        long j6 = Long.MAX_VALUE / j5;
        SharedPreferences.Editor editorEdit2 = zzhhVar.p().edit();
        if (jNextLong < j6) {
            editorEdit2.putString(this.f73802c, str);
        }
        editorEdit2.putLong(str2, j5);
        editorEdit2.apply();
    }

    public final Pair b() {
        long jAbs;
        zzhh zzhhVar = this.f73804e;
        zzhhVar.h();
        zzhhVar.h();
        long jD = d();
        if (jD == 0) {
            c();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jD - zzhhVar.f73997a.e().currentTimeMillis());
        }
        long j3 = this.f73803d;
        if (jAbs < j3) {
            return null;
        }
        if (jAbs > j3 + j3) {
            c();
            return null;
        }
        String string = zzhhVar.p().getString(this.f73802c, null);
        long j4 = zzhhVar.p().getLong(this.f73801b, 0L);
        c();
        return (string == null || j4 <= 0) ? zzhh.A : new Pair(string, Long.valueOf(j4));
    }
}
