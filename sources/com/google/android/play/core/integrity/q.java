package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f83060a;

    private q() {
    }

    public final q a(Context context) {
        context.getClass();
        this.f83060a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.x
    public final s b() {
        com.google.android.play.integrity.internal.am.a(this.f83060a, Context.class);
        return new s(this.f83060a, null);
    }

    /* synthetic */ q(p pVar) {
    }
}
