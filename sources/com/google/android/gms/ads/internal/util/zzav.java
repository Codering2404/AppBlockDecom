package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzav implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f70249a;

    zzav(zzaw zzawVar, Context context) {
        this.f70249a = context;
        Objects.requireNonNull(zzawVar);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        com.google.android.gms.ads.internal.zzt.g();
        zzs.z(this.f70249a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
