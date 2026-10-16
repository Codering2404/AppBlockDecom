package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.ads.AdError;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzckf extends zzhh implements zzii {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzih zze;
    private zzht zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    zzckf(String str, zzin zzinVar, int i3, int i4, long j3, long j4) {
        super(true);
        zzdg.zza(str);
        this.zzd = str;
        this.zze = new zzih();
        this.zzb = i3;
        this.zzc = i4;
        this.zzh = new ArrayDeque();
        this.zzq = j3;
        this.zzr = j4;
        if (zzinVar != null) {
            zze(zzinVar);
        }
    }

    private final void zzl() {
        while (true) {
            Queue queue = this.zzh;
            if (queue.isEmpty()) {
                this.zzg = null;
                return;
            }
            try {
                ((HttpURLConnection) queue.remove()).disconnect();
            } catch (Exception e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unexpected error while disconnecting", e3);
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
            long j4 = this.zzm;
            if (j3 - j4 == 0) {
                return -1;
            }
            long j5 = this.zzn + j4;
            long j6 = i4;
            long j7 = j5 + j6 + this.zzr;
            long j8 = this.zzp;
            long j9 = j8 + 1;
            if (j7 > j9) {
                long j10 = this.zzo;
                if (j8 < j10) {
                    long jMin = Math.min(j10, Math.max(((this.zzq + j9) - r4) - 1, (j9 + j6) - 1));
                    zzk(j9, jMin, 2);
                    this.zzp = jMin;
                    j8 = jMin;
                }
            }
            int i5 = this.zzi.read(bArr, i3, (int) Math.min(j6, ((j8 + 1) - this.zzn) - this.zzm));
            if (i5 == -1) {
                throw new EOFException();
            }
            this.zzm += (long) i5;
            zzh(i5);
            return i5;
        } catch (IOException e3) {
            throw new zzie(e3, this.zzf, AdError.SERVER_ERROR_CODE, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzie {
        this.zzf = zzhtVar;
        this.zzm = 0L;
        long j3 = zzhtVar.zze;
        long j4 = zzhtVar.zzf;
        long jMin = j4 == -1 ? this.zzq : Math.min(this.zzq, j4);
        this.zzn = j3;
        HttpURLConnection httpURLConnectionZzk = zzk(j3, (jMin + j3) - 1, 1);
        this.zzg = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j5 = Long.parseLong(matcher.group(2));
                    long j6 = Long.parseLong(matcher.group(3));
                    long j7 = zzhtVar.zzf;
                    if (j7 != -1) {
                        this.zzl = j7;
                        this.zzo = Math.max(j5, (this.zzn + j7) - 1);
                    } else {
                        this.zzl = j6 - this.zzn;
                        this.zzo = j6 - 1;
                    }
                    this.zzp = j5;
                    this.zzj = true;
                    zzg(zzhtVar);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    StringBuilder sb = new StringBuilder(String.valueOf(headerField).length() + 27);
                    sb.append("Unexpected Content-Range [");
                    sb.append(headerField);
                    sb.append("]");
                    String string = sb.toString();
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(string);
                }
            }
        }
        throw new zzckd(headerField, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzie {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    throw new zzie(e3, this.zzf, AdError.SERVER_ERROR_CODE, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final HttpURLConnection zzk(long j3, long j4, int i3) throws zzie {
        int i4;
        IOException iOException;
        String string = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                try {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } catch (IOException e3) {
                    iOException = e3;
                    i4 = i3;
                    String strValueOf = String.valueOf(string);
                    throw new zzie("Unable to connect to ".concat(strValueOf), iOException, this.zzf, AdError.SERVER_ERROR_CODE, i4);
                }
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 7 + String.valueOf(j4).length());
            sb.append("bytes=");
            sb.append(j3);
            sb.append("-");
            sb.append(j4);
            httpURLConnection.setRequestProperty("Range", sb.toString());
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, this.zzd);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String string2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcke(this.zzk, headerFields, this.zzf, i3);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e4) {
                    zzl();
                    throw new zzie(e4, this.zzf, AdError.SERVER_ERROR_CODE, i3);
                }
            } catch (IOException e5) {
                zzl();
                String strValueOf2 = String.valueOf(string2);
                throw new zzie("Unable to connect to ".concat(strValueOf2), e5, this.zzf, AdError.SERVER_ERROR_CODE, i3);
            }
        } catch (IOException e6) {
            i4 = i3;
            iOException = e6;
        }
    }
}
