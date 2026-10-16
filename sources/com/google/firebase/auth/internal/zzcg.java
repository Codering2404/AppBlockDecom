package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzcg f87973c = new zzcg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzbl f87974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzax f87975b;

    public zzcg() {
        this(zzbl.i(), zzax.b());
    }

    public static zzcg d() {
        return f87973c;
    }

    public final void a(Context context) {
        this.f87974a.a(context);
    }

    public final void b(FirebaseAuth firebaseAuth) {
        this.f87974a.g(firebaseAuth);
    }

    public final Task c() {
        return this.f87974a.h();
    }

    public zzcg(zzbl zzblVar, zzax zzaxVar) {
        this.f87974a = zzblVar;
        this.f87975b = zzaxVar;
    }
}
