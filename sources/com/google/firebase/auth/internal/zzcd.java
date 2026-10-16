package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcd implements BackgroundDetector.BackgroundStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzca f87971a;

    public zzcd(zzca zzcaVar) {
        Objects.requireNonNull(zzcaVar);
        this.f87971a = zzcaVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z2) {
        if (z2) {
            this.f87971a.f87959c = true;
            this.f87971a.b();
        } else {
            this.f87971a.f87959c = false;
            if (this.f87971a.e()) {
                this.f87971a.f87958b.c();
            }
        }
    }
}
