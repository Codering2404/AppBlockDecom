package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzdz extends FunctionReferenceImpl implements Function1 {
    zzdz(Object obj) {
        super(1, obj, zzec.class, "isRetriable", "isRetriable(Ljava/lang/Exception;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(zzec.zzo((Exception) obj));
    }
}
