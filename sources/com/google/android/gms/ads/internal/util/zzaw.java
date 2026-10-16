package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f70250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f70251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f70252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f70253d;

    zzaw(zzax zzaxVar, Context context, String str, boolean z2, boolean z3) {
        this.f70250a = context;
        this.f70251b = str;
        this.f70252c = z2;
        this.f70253d = z3;
        Objects.requireNonNull(zzaxVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.g();
        Context context = this.f70250a;
        AlertDialog.Builder builderN = zzs.n(context);
        builderN.setMessage(this.f70251b);
        if (this.f70252c) {
            builderN.setTitle("Error");
        } else {
            builderN.setTitle("Info");
        }
        if (this.f70253d) {
            builderN.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderN.setPositiveButton("Learn More", new zzav(this, context));
            builderN.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderN.create().show();
    }
}
