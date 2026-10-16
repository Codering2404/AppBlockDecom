package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzia extends zzhh implements zzii {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzih zze;
    private final zzih zzf;
    private zzht zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzia(String str, int i3, int i4, boolean z2, boolean z3, zzih zzihVar, zzgtk zzgtkVar, boolean z4, byte[] bArr) {
        super(true);
        this.zzd = str;
        this.zzb = i3;
        this.zzc = i4;
        this.zza = z2;
        this.zze = zzihVar;
        this.zzf = new zzih();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzb
            r3.setConnectTimeout(r4)
            int r4 = r2.zzc
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzih r5 = r2.zze
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzih r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L32
        L4e:
            r4 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r0 = -1
            if (r12 != 0) goto L5d
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L5c
            r4 = 0
            goto L7c
        L5c:
            r6 = r4
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bytes="
            r4.append(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L78
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L78:
            java.lang.String r4 = r4.toString()
        L7c:
            if (r4 == 0) goto L83
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L83:
            java.lang.String r4 = r2.zzd
            if (r4 == 0) goto L8c
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L8c:
            r4 = 1
            if (r4 == r10) goto L92
            java.lang.String r4 = "identity"
            goto L94
        L92:
            java.lang.String r4 = "gzip"
        L94:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzht.zzh
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzia.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzht zzhtVar) throws zzie {
        if (str == null) {
            throw new zzie("Null location redirect", zzhtVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new zzie("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzhtVar, AdError.INTERNAL_ERROR_CODE, 1);
            }
            if (this.zza || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sb = new StringBuilder(String.valueOf(protocol2).length() + 40 + protocol.length() + 1);
            sb.append("Disallowed cross-protocol redirect (");
            sb.append(protocol2);
            sb.append(" to ");
            sb.append(protocol);
            sb.append(")");
            throw new zzie(sb.toString(), zzhtVar, AdError.INTERNAL_ERROR_CODE, 1);
        } catch (MalformedURLException e3) {
            throw new zzie(e3, zzhtVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e3) {
                zzeg.zzf("DefaultHttpDataSource", "Unexpected error while disconnecting", e3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzie {
        if (i4 == 0) {
            return 0;
        }
        try {
            long j3 = this.zzl;
            if (j3 != -1) {
                long j4 = j3 - this.zzm;
                if (j4 == 0) {
                    return -1;
                }
                i4 = (int) Math.min(i4, j4);
            }
            InputStream inputStream = this.zzi;
            String str = zzfl.zza;
            int i5 = inputStream.read(bArr, i3, i4);
            if (i5 == -1) {
                return -1;
            }
            this.zzm += (long) i5;
            zzh(i5);
            return i5;
        } catch (IOException e3) {
            zzht zzhtVar = this.zzg;
            String str2 = zzfl.zza;
            throw zzie.zza(e3, zzhtVar, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cb  */
    @Override // com.google.android.gms.internal.ads.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzht r23) throws com.google.android.gms.internal.ads.zzie {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzia.zzb(com.google.android.gms.internal.ads.zzht):long");
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzht zzhtVar = this.zzg;
        if (zzhtVar != null) {
            return zzhtVar.zza;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzie {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    zzht zzhtVar = this.zzg;
                    String str = zzfl.zza;
                    throw new zzie(e3, zzhtVar, AdError.SERVER_ERROR_CODE, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
            this.zzh = null;
            this.zzg = null;
            TrafficStats.clearThreadStatsTag();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzgwp.zza() : new zzhz(httpURLConnection.getHeaderFields());
    }
}
