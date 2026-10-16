package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.TotpSecret;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcc implements TotpSecret {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f87966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f87967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f87968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f87969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FirebaseAuth f87970g;

    public zzcc(String str, String str2, int i3, int i4, long j3, String str3, FirebaseAuth firebaseAuth) {
        Preconditions.h(str3, "sessionInfo cannot be empty.");
        Preconditions.n(firebaseAuth, "firebaseAuth cannot be null.");
        this.f87964a = Preconditions.h(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f87965b = Preconditions.h(str2, "hashAlgorithm cannot be empty.");
        this.f87966c = i3;
        this.f87967d = i4;
        this.f87968e = j3;
        this.f87969f = str3;
        this.f87970g = firebaseAuth;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String a() {
        return this.f87969f;
    }
}
