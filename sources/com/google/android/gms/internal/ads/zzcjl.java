package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcjl extends zzhh implements zzii {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzih zzg;
    private zzht zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    zzcjl(String str, zzin zzinVar, int i3, int i4, int i5) {
        super(true);
        this.zzc = new zzcjk(this);
        this.zzr = new HashSet();
        zzdg.zza(str);
        this.zzf = str;
        this.zzg = new zzih();
        this.zzd = i3;
        this.zze = i4;
        this.zzq = i5;
        if (zzinVar != null) {
            zze(zzinVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unexpected error while disconnecting", e3);
            }
            this.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzie {
        try {
            if (this.zzo != this.zzm) {
                AtomicReference atomicReference = zzb;
                byte[] bArr2 = (byte[]) atomicReference.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j3 = this.zzo;
                    long j4 = this.zzm;
                    if (j3 == j4) {
                        atomicReference.set(bArr2);
                        break;
                    }
                    int i5 = this.zzj.read(bArr2, 0, (int) Math.min(j4 - j3, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i5 == -1) {
                        throw new EOFException();
                    }
                    this.zzo += (long) i5;
                    zzh(i5);
                }
            }
            if (i4 == 0) {
                return 0;
            }
            long j5 = this.zzn;
            if (j5 != -1) {
                long j6 = j5 - this.zzp;
                if (j6 == 0) {
                    return -1;
                }
                i4 = (int) Math.min(i4, j6);
            }
            int i6 = this.zzj.read(bArr, i3, i4);
            if (i6 == -1) {
                if (this.zzn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzp += (long) i6;
            zzh(i6);
            return i6;
        } catch (IOException e3) {
            throw new zzie(e3, this.zzh, AdError.SERVER_ERROR_CODE, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df A[Catch: IOException -> 0x0044, TryCatch #2 {IOException -> 0x0044, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002d, B:8:0x003b, B:11:0x0047, B:12:0x005f, B:14:0x0065, B:21:0x0092, B:23:0x00b2, B:24:0x00d1, B:25:0x00d6, B:27:0x00df, B:28:0x00e6, B:41:0x010f, B:94:0x0282, B:96:0x028f, B:98:0x02a0, B:101:0x02a9, B:102:0x02b6, B:104:0x02c0, B:105:0x02c7, B:106:0x02c8, B:107:0x02e5), top: B:114:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x028f A[Catch: IOException -> 0x0044, TryCatch #2 {IOException -> 0x0044, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002d, B:8:0x003b, B:11:0x0047, B:12:0x005f, B:14:0x0065, B:21:0x0092, B:23:0x00b2, B:24:0x00d1, B:25:0x00d6, B:27:0x00df, B:28:0x00e6, B:41:0x010f, B:94:0x0282, B:96:0x028f, B:98:0x02a0, B:101:0x02a9, B:102:0x02b6, B:104:0x02c0, B:105:0x02c7, B:106:0x02c8, B:107:0x02e5), top: B:114:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzht r25) throws com.google.android.gms.internal.ads.zzie {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjl.zzb(com.google.android.gms.internal.ads.zzht):long");
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzie {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    throw new zzie(e3, this.zzh, AdError.SERVER_ERROR_CODE, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzi();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzk(int i3) {
        this.zzq = i3;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e3) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("Failed to update receive buffer size.", e3);
                }
            }
        }
    }

    final /* synthetic */ void zzl(Socket socket) {
        this.zzr.add(socket);
    }

    final /* synthetic */ int zzm() {
        return this.zzq;
    }
}
