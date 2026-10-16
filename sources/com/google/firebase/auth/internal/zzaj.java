package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.MultiFactor;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaj extends MultiFactor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzaf f87861a;

    public zzaj(zzaf zzafVar) {
        Preconditions.m(zzafVar);
        this.f87861a = zzafVar;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List a() {
        return this.f87861a.W2();
    }
}
