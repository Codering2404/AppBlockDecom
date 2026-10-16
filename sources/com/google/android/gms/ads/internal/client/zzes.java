package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzes extends zzdj {
    /* synthetic */ zzes(byte[] bArr) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdk
    public final void zze(zze zzeVar) {
        OnAdInspectorClosedListener onAdInspectorClosedListenerA = zzeu.f().a();
        if (onAdInspectorClosedListenerA != null) {
            onAdInspectorClosedListenerA.a(zzeVar == null ? null : new AdInspectorError(zzeVar.f69851a, zzeVar.f69852b, zzeVar.f69853c));
        }
    }
}
