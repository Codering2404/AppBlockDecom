package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfg extends zzbu {
    private static final byte[] zza = "\n".getBytes();
    private final String zzb;
    private final zzfq zzc;

    zzfg(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzbv.zza, Build.VERSION.RELEASE, zzfu.zzd(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzc = new zzfq(zzbxVar.zzr());
    }

    private final URL zzh() {
        zzw();
        String strZzi = zzcv.zzi();
        zzw();
        try {
            return new URL(strZzi.concat((String) zzew.zzt.zzb()));
        } catch (MalformedURLException e3) {
            zzJ("Error trying to parse the hardcoded host url", e3);
            return null;
        }
    }

    private final URL zzi(zzez zzezVar) {
        String strConcat;
        if (zzezVar.zzh()) {
            zzw();
            String strZzi = zzcv.zzi();
            zzw();
            strConcat = strZzi.concat(zzcv.zzj());
        } else {
            zzw();
            String strZzk = zzcv.zzk();
            zzw();
            strConcat = strZzk.concat(zzcv.zzj());
        }
        try {
            return new URL(strConcat);
        } catch (MalformedURLException e3) {
            zzJ("Error trying to parse the hardcoded host url", e3);
            return null;
        }
    }

    private final URL zzj(zzez zzezVar, String str) {
        String str2;
        if (zzezVar.zzh()) {
            zzw();
            String strZzi = zzcv.zzi();
            zzw();
            str2 = strZzi + zzcv.zzj() + "?" + str;
        } else {
            zzw();
            String strZzk = zzcv.zzk();
            zzw();
            str2 = strZzk + zzcv.zzj() + "?" + str;
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e3) {
            zzJ("Error trying to parse the hardcoded host url", e3);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        zzJ("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzk(java.net.HttpURLConnection r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L1b
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L19
        La:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L19
            if (r2 > 0) goto La
            r4.close()     // Catch: java.io.IOException -> L14
            return
        L14:
            r4 = move-exception
            r3.zzJ(r0, r4)
            return
        L19:
            r1 = move-exception
            goto L1d
        L1b:
            r1 = move-exception
            r4 = 0
        L1d:
            if (r4 == 0) goto L27
            r4.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r4 = move-exception
            r3.zzJ(r0, r4)
        L27:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfg.zzk(java.net.HttpURLConnection):void");
    }

    private static final void zzl(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Utf8Charset.NAME));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Utf8Charset.NAME));
    }

    final String zza(zzez zzezVar, boolean z2) {
        Preconditions.m(zzezVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : zzezVar.zzg().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zzl(sb, str, (String) entry.getValue());
                }
            }
            zzl(sb, "ht", String.valueOf(zzezVar.zzd()));
            zzl(sb, "qt", String.valueOf(zzC().currentTimeMillis() - zzezVar.zzd()));
            zzw();
            if (z2) {
                long jZzc = zzezVar.zzc();
                zzl(sb, "z", jZzc != 0 ? String.valueOf(jZzc) : String.valueOf(zzezVar.zzb()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e3) {
            zzJ("Failed to encode name or value", e3);
            return null;
        }
    }

    final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzw();
        httpURLConnection.setConnectTimeout(((Integer) zzew.zzE.zzb()).intValue());
        zzw();
        httpURLConnection.setReadTimeout(((Integer) zzew.zzF.zzb()).intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, this.zzb);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0322 A[EDGE_INSN: B:190:0x0322->B:162:0x0322 BREAK  A[LOOP:1: B:110:0x022a->B:193:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[LOOP:1: B:110:0x022a->B:193:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzc(java.util.List r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfg.zzc(java.util.List):java.util.List");
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        zzO("Network initialized. User agent", this.zzb);
    }

    public final boolean zze() {
        NetworkInfo activeNetworkInfo;
        com.google.android.gms.analytics.zzr.h();
        zzV();
        try {
            activeNetworkInfo = ((ConnectivityManager) zzo().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzN("No network connectivity");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzg(java.net.URL r4, byte[] r5, int r6) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r6 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.m(r4)
            com.google.android.gms.common.internal.Preconditions.m(r5)
            int r0 = r5.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = 0
            java.lang.String r2 = com.google.android.gms.ads_identifier.mrU.pMpIcGE.EzGXkMYHNXgdFh
            r3.zzG(r2, r1, r4)
            boolean r1 = com.google.android.gms.internal.gtm.zzbt.zzU()
            if (r1 == 0) goto L23
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
            java.lang.String r2 = "Post payload\n"
            r3.zzO(r2, r1)
        L23:
            r1 = 0
            java.net.HttpURLConnection r4 = r3.zzb(r4)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r2 = 1
            r4.setDoOutput(r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r4.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r4.connect()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            java.io.OutputStream r1 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r1.write(r5)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r3.zzk(r4)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            int r5 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r0 = 200(0xc8, float:2.8E-43)
            if (r5 != r0) goto L51
            com.google.android.gms.internal.gtm.zzbs r5 = r3.zzs()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r5.zzi()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r5 = r0
            goto L51
        L4d:
            r5 = move-exception
            goto L81
        L4f:
            r5 = move-exception
            goto L6b
        L51:
            java.lang.String r0 = "POST status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r3.zzF(r0, r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r1.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r3.zzJ(r6, r0)
        L62:
            r4.disconnect()
            return r5
        L66:
            r5 = move-exception
            r4 = r1
            goto L81
        L69:
            r5 = move-exception
            r4 = r1
        L6b:
            java.lang.String r0 = "Network POST connection error"
            r3.zzR(r0, r5)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r5 = move-exception
            r3.zzJ(r6, r5)
        L7a:
            if (r4 == 0) goto L7f
            r4.disconnect()
        L7f:
            r4 = 0
            return r4
        L81:
            if (r1 == 0) goto L8b
            r1.close()     // Catch: java.io.IOException -> L87
            goto L8b
        L87:
            r0 = move-exception
            r3.zzJ(r6, r0)
        L8b:
            if (r4 == 0) goto L90
            r4.disconnect()
        L90:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfg.zzg(java.net.URL, byte[], int):int");
    }
}
