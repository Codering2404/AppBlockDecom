package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzo extends zzat {
    public final zzgwm zzc;

    public zzzo(String str, Uri uri, List list) {
        super(str, null, false, 1);
        this.zzc = zzgwm.zzq(list);
    }

    @Override // com.google.android.gms.internal.ads.zzat, java.lang.Throwable
    public final String getMessage() {
        zzgwm zzgwmVar = this.zzc;
        String message = super.getMessage();
        if (zzgwmVar.isEmpty()) {
            return message;
        }
        int length = message.length();
        String strValueOf = String.valueOf(zzgwmVar);
        StringBuilder sb = new StringBuilder(length + 17 + strValueOf.length());
        sb.append(message);
        sb.append("\nsniff failures: ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
