package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzky implements Application.ActivityLifecycleCallbacks, zzkw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlj f74116a;

    zzky(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.f74116a = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void a(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzic zzicVar = this.f74116a.f73997a;
        zzicVar.I().x(zzdfVar);
        zzoc zzocVarZ = zzicVar.z();
        zzic zzicVar2 = zzocVarZ.f73997a;
        zzicVar2.b().t(new zznv(zzocVarZ, zzicVar2.e().a()));
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void b(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        this.f74116a.f73997a.I().z(zzdfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void c(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        this.f74116a.f73997a.I().y(zzdfVar, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void d(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzic zzicVar = this.f74116a.f73997a;
        zzoc zzocVarZ = zzicVar.z();
        zzic zzicVar2 = zzocVarZ.f73997a;
        zzicVar2.b().t(new zznu(zzocVarZ, zzicVar2.e().a()));
        zzicVar.I().w(zzdfVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    @Override // com.google.android.gms.measurement.internal.zzkw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(com.google.android.gms.internal.measurement.zzdf r8, android.os.Bundle r9) throws java.lang.Throwable {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzlj r0 = r7.f74116a     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            com.google.android.gms.measurement.internal.zzic r1 = r0.f73997a     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            com.google.android.gms.measurement.internal.zzgu r2 = r1.a()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            com.google.android.gms.measurement.internal.zzgs r2 = r2.w()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            android.content.Intent r2 = r8.zzc     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 == 0) goto L4c
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r3 == 0) goto L2c
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r4 != 0) goto L22
            goto L2c
        L22:
            r4 = r3
            goto L44
        L24:
            r0 = move-exception
            r2 = r7
            goto Lb6
        L28:
            r0 = move-exception
            r2 = r7
            goto La0
        L2c:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            r4 = 0
            if (r3 == 0) goto L44
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r5 != 0) goto L44
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            goto L22
        L44:
            if (r4 == 0) goto L4c
            boolean r3 = r4.isHierarchical()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r3 != 0) goto L4e
        L4c:
            r2 = r7
            goto L96
        L4e:
            r1.C()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r0 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r2.getStringExtra(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 != 0) goto L74
            java.lang.String r2 = "https://www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 != 0) goto L74
            java.lang.String r2 = "android-app://com.google.appcrawler"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r0 == 0) goto L70
            goto L74
        L70:
            java.lang.String r0 = "auto"
        L72:
            r5 = r0
            goto L77
        L74:
            java.lang.String r0 = "gs"
            goto L72
        L77:
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r9 != 0) goto L82
            r0 = 1
        L80:
            r3 = r0
            goto L84
        L82:
            r0 = 0
            goto L80
        L84:
            com.google.android.gms.measurement.internal.zzhz r0 = r1.b()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            com.google.android.gms.measurement.internal.zzkx r1 = new com.google.android.gms.measurement.internal.zzkx     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L92 java.lang.RuntimeException -> L94
            r0.t(r1)     // Catch: java.lang.Throwable -> L92 java.lang.RuntimeException -> L94
            goto Lb1
        L92:
            r0 = move-exception
            goto Lb6
        L94:
            r0 = move-exception
            goto La0
        L96:
            com.google.android.gms.measurement.internal.zzic r0 = r0.f73997a
        L98:
            com.google.android.gms.measurement.internal.zzmb r0 = r0.I()
            r0.v(r8, r9)
            return
        La0:
            com.google.android.gms.measurement.internal.zzlj r1 = r2.f74116a     // Catch: java.lang.Throwable -> L92
            com.google.android.gms.measurement.internal.zzic r1 = r1.f73997a     // Catch: java.lang.Throwable -> L92
            com.google.android.gms.measurement.internal.zzgu r1 = r1.a()     // Catch: java.lang.Throwable -> L92
            com.google.android.gms.measurement.internal.zzgs r1 = r1.o()     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r1.b(r3, r0)     // Catch: java.lang.Throwable -> L92
        Lb1:
            com.google.android.gms.measurement.internal.zzlj r0 = r2.f74116a
            com.google.android.gms.measurement.internal.zzic r0 = r0.f73997a
            goto L98
        Lb6:
            com.google.android.gms.measurement.internal.zzlj r1 = r2.f74116a
            com.google.android.gms.measurement.internal.zzic r1 = r1.f73997a
            com.google.android.gms.measurement.internal.zzmb r1 = r1.I()
            r1.v(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzky.e(com.google.android.gms.internal.measurement.zzdf, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        e(com.google.android.gms.internal.measurement.zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        b(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        d(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c(com.google.android.gms.internal.measurement.zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
