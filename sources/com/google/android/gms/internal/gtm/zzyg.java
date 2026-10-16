package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzyg extends IOException {
    private zzzg zza;
    private boolean zzb;

    public zzyg(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    static zzyf zza() {
        return new zzyf("Protocol message tag had invalid wire type.");
    }

    static zzyg zzb() {
        return new zzyg("Protocol message end-group tag did not match expected tag.");
    }

    static zzyg zzc() {
        return new zzyg("Protocol message contained an invalid tag (zero).");
    }

    static zzyg zzd() {
        return new zzyg("Protocol message had invalid UTF-8.");
    }

    static zzyg zze() {
        return new zzyg("CodedInputStream encountered a malformed varint.");
    }

    static zzyg zzf() {
        return new zzyg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzyg zzg() {
        return new zzyg("Failed to parse the message.");
    }

    static zzyg zzi() {
        return new zzyg("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzyg zzj() {
        return new zzyg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzyg zzh(zzzg zzzgVar) {
        this.zza = zzzgVar;
        return this;
    }

    final void zzk() {
        this.zzb = true;
    }

    final boolean zzl() {
        return this.zzb;
    }

    public zzyg(String str) {
        super(str);
        this.zza = null;
    }
}
