package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f73787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f73788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f73789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzhh f73790e;

    public zzhc(zzhh zzhhVar, String str, boolean z2) {
        Objects.requireNonNull(zzhhVar);
        this.f73790e = zzhhVar;
        Preconditions.g(str);
        this.f73786a = str;
        this.f73787b = z2;
    }

    public final boolean a() {
        if (!this.f73788c) {
            this.f73788c = true;
            zzhh zzhhVar = this.f73790e;
            this.f73789d = zzhhVar.p().getBoolean(this.f73786a, this.f73787b);
        }
        return this.f73789d;
    }

    public final void b(boolean z2) {
        SharedPreferences.Editor editorEdit = this.f73790e.p().edit();
        editorEdit.putBoolean(this.f73786a, z2);
        editorEdit.apply();
        this.f73789d = z2;
    }
}
