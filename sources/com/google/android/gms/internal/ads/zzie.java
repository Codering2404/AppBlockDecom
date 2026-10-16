package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzie extends zzhq {
    public final int zzb;

    public zzie(zzht zzhtVar, int i3, int i4) {
        super(zzb(AdError.REMOTE_ADS_SERVICE_ERROR, 1));
        this.zzb = 1;
    }

    public static zzie zza(IOException iOException, zzht zzhtVar, int i3) {
        String message = iOException.getMessage();
        int i4 = iOException instanceof SocketTimeoutException ? AdError.CACHE_ERROR_CODE : iOException instanceof InterruptedIOException ? 1004 : (message == null || !zzgss.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i4 == 2007 ? new zzid(iOException, zzhtVar) : new zzie(iOException, zzhtVar, i4, i3);
    }

    private static int zzb(int i3, int i4) {
        return i3 == 2000 ? i4 != 1 ? AdError.SERVER_ERROR_CODE : AdError.INTERNAL_ERROR_CODE : i3;
    }

    public zzie(IOException iOException, zzht zzhtVar, int i3, int i4) {
        super(iOException, zzb(i3, i4));
        this.zzb = i4;
    }

    public zzie(String str, zzht zzhtVar, int i3, int i4) {
        super(str, zzb(i3, i4));
        this.zzb = i4;
    }

    public zzie(String str, IOException iOException, zzht zzhtVar, int i3, int i4) {
        super(str, iOException, zzb(i3, i4));
        this.zzb = i4;
    }
}
