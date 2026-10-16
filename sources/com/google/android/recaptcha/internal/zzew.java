package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzew {
    private final HttpURLConnection zza;

    public zzew(HttpURLConnection httpURLConnection) {
        this.zza = httpURLConnection;
    }

    private final InputStream zzf() throws zzbd {
        try {
            return this.zza.getInputStream();
        } catch (UnknownServiceException e3) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e3.getMessage());
        } catch (IOException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e4.getMessage());
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e5.getMessage());
        }
    }

    private final OutputStream zzg() throws zzbd {
        try {
            return this.zza.getOutputStream();
        } catch (UnknownServiceException e3) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e3.getMessage());
        } catch (IOException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e4.getMessage());
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e5.getMessage());
        }
    }

    public final zzoi zza(zzoi zzoiVar) throws zzbd {
        try {
            int responseCode = this.zza.getResponseCode();
            if (responseCode != 200) {
                if (responseCode == 400) {
                    throw new zzbd(zzbb.zzc, zzba.zzau, null);
                }
                if (responseCode != 503 && responseCode != 403) {
                    if (responseCode != 404) {
                        throw new zzbd(zzbb.zzc, zzba.zzK, null);
                    }
                    throw new zzbd(zzbb.zzc, zzba.zzi, null);
                }
                throw new zzbd(zzbb.zzi, zzba.zzJ, null);
            }
            byte[] bArrC = ByteStreamsKt.c(zzf());
            if (bArrC.length == 0) {
                throw new zzbd(zzbb.zzc, zzba.zzat, null);
            }
            try {
                Object objZzb = zzoiVar.zzD().zzb(bArrC);
                Intrinsics.checkNotNull(objZzb, "null cannot be cast to non-null type T of com.google.android.libraries.abuse.recaptcha.network.CaptchaFeConnection.getResponse");
                return (zzoi) objZzb;
            } catch (Exception e3) {
                throw new zzbd(zzbb.zzc, zzba.zzG, e3.getMessage());
            }
        } catch (Exception e4) {
            throw new zzbd(zzbb.zzc, zzba.zzah, e4.getMessage());
        }
    }

    public final HttpURLConnection zzb() {
        return this.zza;
    }

    public final void zzc() throws zzbd {
        try {
            this.zza.connect();
        } catch (SocketTimeoutException e3) {
            throw new zzbd(zzbb.zzc, zzba.zzac, e3.getMessage());
        } catch (IOException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzad, e4.getMessage());
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzaj, e5.getMessage());
        }
    }

    public final void zzd() {
        this.zza.disconnect();
    }

    public final void zze(byte[] bArr) throws zzbd {
        try {
            zzg().write(bArr);
        } catch (zzbd e3) {
            throw e3;
        } catch (IOException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzag, e4.getMessage());
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzal, e5.getMessage());
        }
    }
}
