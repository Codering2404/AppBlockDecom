package com.google.android.recaptcha.internal;

import java.net.HttpURLConnection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzex {
    private final zzfm zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzex() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final zzew zza(String str) throws zzbd {
        try {
            HttpURLConnection httpURLConnectionZza = this.zza.zza(str);
            httpURLConnectionZza.setRequestMethod("POST");
            httpURLConnectionZza.setDoOutput(true);
            httpURLConnectionZza.setRequestProperty("Content-Type", "application/x-protobuffer");
            return new zzew(httpURLConnectionZza);
        } catch (zzbd e3) {
            throw e3;
        } catch (Exception e4) {
            throw new zzbd(zzbb.zzc, zzba.zzai, e4.getMessage());
        }
    }

    public /* synthetic */ zzex(zzfm zzfmVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this.zza = new zzfm();
    }
}
