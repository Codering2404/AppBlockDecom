package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzga extends zzfx {
    private final zzfz zza;
    private final String zzb;

    public zzga(zzfz zzfzVar, String str, Object obj) {
        super(obj);
        this.zza = zzfzVar;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzfx
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List listEmptyList;
        if (!Intrinsics.areEqual(method.getName(), this.zzb)) {
            return false;
        }
        zzfz zzfzVar = this.zza;
        if (objArr == null || (listEmptyList = ArraysKt.asList(objArr)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        zzfzVar.zzb(listEmptyList);
        return true;
    }
}
