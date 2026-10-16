package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class CreationContextFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f69387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f69388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f69389c;

    CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.f69387a = context;
        this.f69388b = clock;
        this.f69389c = clock2;
    }

    CreationContext a(String str) {
        return CreationContext.a(this.f69387a, this.f69388b, this.f69389c, str);
    }
}
