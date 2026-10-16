package com.google.android.gms.internal.ads;

import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfxb {
    protected static final byte[] zza = {61, 122, Ascii.DC2, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, Framer.STDIN_REQUEST_FRAME_PREFIX, -25, -62, 63, Framer.STDERR_FRAME_PREFIX, 108, -113, -103, 74};
    protected static final byte[] zzb = {-110, -13, -34, 70, -83, 43, 97, Ascii.NAK, -44, Ascii.DLE, -54, -125, -28, -57, -125, -127, -7, 17, 102, -69, 116, -121, -79, 43, -13, Framer.EXIT_FRAME_PREFIX, 58, 55, -29, -108, Framer.STDIN_REQUEST_FRAME_PREFIX, 83};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] x509CertificateArrZza = zzask.zza(file.getAbsolutePath());
            if (x509CertificateArrZza.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(x509CertificateArrZza[0][0].getEncoded());
            if (Arrays.equals(this.zzd, bArrDigest)) {
                return true;
            }
            return !"user".equals(Build.TYPE) && Arrays.equals(this.zzc, bArrDigest);
        } catch (zzash e3) {
            throw new GeneralSecurityException("Package is not signed", e3);
        } catch (IOException e4) {
            e = e4;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}
