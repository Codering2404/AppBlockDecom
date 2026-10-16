package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjr;
import com.google.android.gms.internal.ads.zzink;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzk implements zzbjq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbjr f70359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f70360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f70361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Uri f70362d;

    zzk(zzs zzsVar, zzbjr zzbjrVar, Bundle bundle, Context context, Uri uri) {
        this.f70359a = zzbjrVar;
        this.f70360b = bundle;
        this.f70361c = context;
        this.f70362d = uri;
        Objects.requireNonNull(zzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zza() {
        zzbjr zzbjrVar = this.f70359a;
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(zzbjrVar.zzc());
        zzs.J(builder, this.f70360b);
        CustomTabsIntent customTabsIntentA = builder.a();
        Intent intent = customTabsIntentA.f2637a;
        Context context = this.f70361c;
        intent.setPackage(zzink.zza(context));
        customTabsIntentA.a(context, this.f70362d);
        zzbjrVar.zzb((Activity) context);
    }
}
