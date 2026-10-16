package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f73806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzhh f73808d;

    public zzhg(zzhh zzhhVar, String str, String str2) {
        Objects.requireNonNull(zzhhVar);
        this.f73808d = zzhhVar;
        Preconditions.g(str);
        this.f73805a = str;
    }

    public final String a() {
        if (!this.f73806b) {
            this.f73806b = true;
            zzhh zzhhVar = this.f73808d;
            this.f73807c = zzhhVar.p().getString(this.f73805a, null);
        }
        return this.f73807c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f73808d.p().edit();
        editorEdit.putString(this.f73805a, str);
        editorEdit.apply();
        this.f73807c = str;
    }
}
