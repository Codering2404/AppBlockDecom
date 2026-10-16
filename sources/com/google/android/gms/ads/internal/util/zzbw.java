package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbw implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f70300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbz f70301b;

    public zzbw(zzbz zzbzVar, String str) {
        Objects.requireNonNull(zzbzVar);
        this.f70301b = zzbzVar;
        this.f70300a = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzbz zzbzVar = this.f70301b;
        synchronized (zzbzVar) {
            try {
                Iterator it = zzbzVar.d().iterator();
                while (it.hasNext()) {
                    ((zzbx) it.next()).zza(sharedPreferences, this.f70300a, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
