package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.FormError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends Exception {
    private final int zza;

    public zzg(int i3, String str) {
        super(str);
        this.zza = i3;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return super.getMessage();
    }

    public final FormError zza() {
        if (getCause() == null) {
            Log.w("UserMessagingPlatform", super.getMessage());
        } else {
            Log.w("UserMessagingPlatform", super.getMessage(), getCause());
        }
        return new FormError(this.zza, super.getMessage());
    }

    public zzg(int i3, String str, Throwable th) {
        super(str, th);
        this.zza = i3;
    }
}
