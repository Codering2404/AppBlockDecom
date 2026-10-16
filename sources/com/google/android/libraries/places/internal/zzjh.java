package com.google.android.libraries.places.internal;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzjh implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzjh f78017a = new zzjh();

    private /* synthetic */ zzjh() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        return str.substring(str.lastIndexOf("places/") + 7);
    }
}
