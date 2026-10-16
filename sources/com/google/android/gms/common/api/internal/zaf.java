package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaf extends zad {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zaci f71834c;

    public zaf(zaci zaciVar, TaskCompletionSource taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f71834c = zaciVar;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(zabq zabqVar) {
        return this.f71834c.f71795a.f();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] g(zabq zabqVar) {
        return this.f71834c.f71795a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void h(zabq zabqVar) {
        this.f71834c.f71795a.d(zabqVar.t(), this.f71819b);
        ListenerHolder.ListenerKey listenerKeyB = this.f71834c.f71795a.b();
        if (listenerKeyB != null) {
            zabqVar.v().put(listenerKeyB, this.f71834c);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void d(zaad zaadVar, boolean z2) {
    }
}
