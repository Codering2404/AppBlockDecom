package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzv extends ActionCodeMultiFactorInfo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiFactorInfo f88007b;

    public zzv(String str, MultiFactorInfo multiFactorInfo) {
        this.f87708a = Preconditions.g(str);
        this.f88007b = (MultiFactorInfo) Preconditions.m(multiFactorInfo);
    }
}
