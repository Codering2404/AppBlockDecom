package com.google.android.libraries.places.internal;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzjc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78014a;

    public zzjc(Context context) {
        this.f78014a = context;
    }

    private final void c(zzbmg zzbmgVar) {
        Context context = this.f78014a;
        String strA = zzmr.a(context.getPackageManager(), context.getPackageName());
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        zzbmb zzbmbVar = zzbmg.f76399d;
        zzbmgVar.c(zzbmc.c("X-Android-Package", zzbmbVar), context.getPackageName());
        zzbmgVar.c(zzbmc.c("X-Places-Android-Sdk", zzbmbVar), "5.1.1");
        zzbmgVar.c(zzbmc.c("X-Android-Cert", zzbmbVar), strA);
    }

    private static final void d(zzbmg zzbmgVar, String str) {
        if (str.isEmpty()) {
            return;
        }
        zzbmgVar.c(zzbmc.c("X-Goog-FieldMask", zzbmg.f76399d), str);
    }

    public final zzbmg a(String str, String str2) {
        zzbmg zzbmgVar = new zzbmg();
        zzbmgVar.c(zzbmc.c("X-Goog-Api-Key", zzbmg.f76399d), str);
        c(zzbmgVar);
        d(zzbmgVar, str2);
        return zzbmgVar;
    }

    public final zzbmg b(String str, String str2) {
        zzbmg zzbmgVar = new zzbmg();
        zzbmgVar.c(zzbmc.c("Authorization", zzbmg.f76399d), "Bearer ".concat(String.valueOf(str)));
        d(zzbmgVar, str2);
        c(zzbmgVar);
        return zzbmgVar;
    }
}
