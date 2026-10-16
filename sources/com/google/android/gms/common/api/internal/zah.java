package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zah extends zad {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListenerHolder.ListenerKey f71838c;

    public zah(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f71838c = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.v().get(this.f71838c);
        return zaciVar != null && zaciVar.f71795a.f();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] g(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.v().get(this.f71838c);
        if (zaciVar == null) {
            return null;
        }
        return zaciVar.f71795a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void h(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.v().remove(this.f71838c);
        if (zaciVar == null) {
            this.f71819b.trySetResult(Boolean.FALSE);
            return;
        }
        zaciVar.f71796b.b(zabqVar.t(), this.f71819b);
        zaciVar.f71795a.a();
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void d(zaad zaadVar, boolean z2) {
    }
}
