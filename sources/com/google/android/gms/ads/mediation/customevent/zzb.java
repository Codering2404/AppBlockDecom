package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzb implements CustomEventInterstitialListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CustomEventAdapter f70530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationInterstitialListener f70531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomEventAdapter f70532c;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        Objects.requireNonNull(customEventAdapter);
        this.f70532c = customEventAdapter;
        this.f70530a = customEventAdapter2;
        this.f70531b = mediationInterstitialListener;
    }
}
