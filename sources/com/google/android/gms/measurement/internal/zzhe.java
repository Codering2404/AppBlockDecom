package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f73796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f73797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f73798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzhh f73799e;

    public zzhe(zzhh zzhhVar, String str, long j3) {
        Objects.requireNonNull(zzhhVar);
        this.f73799e = zzhhVar;
        Preconditions.g(str);
        this.f73795a = str;
        this.f73796b = j3;
    }

    public final long a() {
        if (!this.f73797c) {
            this.f73797c = true;
            zzhh zzhhVar = this.f73799e;
            this.f73798d = zzhhVar.p().getLong(this.f73795a, this.f73796b);
        }
        return this.f73798d;
    }

    public final void b(long j3) {
        SharedPreferences.Editor editorEdit = this.f73799e.p().edit();
        editorEdit.putLong(this.f73795a, j3);
        editorEdit.apply();
        this.f73798d = j3;
    }
}
