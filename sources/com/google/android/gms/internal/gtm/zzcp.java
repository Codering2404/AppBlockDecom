package com.google.android.gms.internal.gtm;

import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcp extends zzbu {
    private volatile String zza;
    private Future zzb;

    protected zzcp(zzbx zzbxVar) {
        super(zzbxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004e A[EXC_TOP_SPLITTER, PHI: r4
      0x004e: PHI (r4v3 java.io.FileOutputStream) = (r4v2 java.io.FileOutputStream), (r4v4 java.io.FileOutputStream) binds: [B:20:0x004c, B:27:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzf() {
        /*
            r7 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "Failed to close clientId writing stream"
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r2 = r2.toLowerCase(r3)
            com.google.android.gms.analytics.zzr r3 = r7.zzq()     // Catch: java.lang.Exception -> L3a
            android.content.Context r3 = r3.a()     // Catch: java.lang.Exception -> L3a
            com.google.android.gms.common.internal.Preconditions.g(r2)     // Catch: java.lang.Exception -> L3a
            java.lang.String r4 = "ClientId should be saved from worker thread"
            com.google.android.gms.common.internal.Preconditions.l(r4)     // Catch: java.lang.Exception -> L3a
            r4 = 0
            java.lang.String r5 = "Storing clientId"
            r7.zzO(r5, r2)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            java.lang.String r5 = "gaClientId"
            r6 = 0
            java.io.FileOutputStream r4 = r3.openFileOutput(r5, r6)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            byte[] r3 = r2.getBytes()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r4.write(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r4.close()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c
            return r2
        L3a:
            r1 = move-exception
            goto L6b
        L3c:
            r3 = move-exception
            r7.zzJ(r1, r3)     // Catch: java.lang.Exception -> L3a
            return r2
        L41:
            r2 = move-exception
            goto L60
        L43:
            r2 = move-exception
            goto L47
        L45:
            r2 = move-exception
            goto L57
        L47:
            java.lang.String r3 = "Error writing to clientId file"
            r7.zzJ(r3, r2)     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L5f
        L4e:
            r4.close()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L52
            goto L5f
        L52:
            r2 = move-exception
            r7.zzJ(r1, r2)     // Catch: java.lang.Exception -> L3a
            goto L5f
        L57:
            java.lang.String r3 = "Error creating clientId file"
            r7.zzJ(r3, r2)     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L5f
            goto L4e
        L5f:
            return r0
        L60:
            if (r4 == 0) goto L6a
            r4.close()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L66
            goto L6a
        L66:
            r3 = move-exception
            r7.zzJ(r1, r3)     // Catch: java.lang.Exception -> L3a
        L6a:
            throw r2     // Catch: java.lang.Exception -> L3a
        L6b:
            java.lang.String r2 = "Error saving clientId file"
            r7.zzJ(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcp.zzf():java.lang.String");
    }

    public final String zzb() {
        String str;
        zzV();
        synchronized (this) {
            try {
                if (this.zza == null) {
                    this.zzb = zzq().g(new zzcn(this));
                }
                Future future = this.zzb;
                if (future != null) {
                    try {
                        this.zza = (String) future.get();
                    } catch (InterruptedException e3) {
                        zzR("ClientId loading or generation was interrupted", e3);
                        this.zza = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } catch (ExecutionException e4) {
                        zzJ("Failed to load or generate client id", e4);
                        this.zza = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    if (this.zza == null) {
                        this.zza = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    zzO("Loaded clientId", this.zza);
                    this.zzb = null;
                }
                str = this.zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(5:49|3|4|54|5)|(1:7)(2:16|(1:18)(5:19|50|20|24|(2:43|44)(1:45)))|47|8|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        zzJ("Failed to close client id reading stream", r0);
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:101), block:B:25:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String zzc() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            com.google.android.gms.analytics.zzr r2 = r9.zzq()
            android.content.Context r2 = r2.a()
            java.lang.String r3 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.l(r3)
            r3 = 0
            java.io.FileInputStream r4 = r2.openFileInput(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68 java.io.FileNotFoundException -> L80
            r5 = 36
            byte[] r6 = new byte[r5]     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r7 = 0
            int r5 = r4.read(r6, r7, r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            int r8 = r4.available()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            if (r8 <= 0) goto L3d
            java.lang.String r5 = "clientId file seems corrupted, deleting it."
            r9.zzQ(r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r4.close()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r2.deleteFile(r0)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
        L30:
            r4.close()     // Catch: java.io.IOException -> L34
            goto L84
        L34:
            r0 = move-exception
            r9.zzJ(r1, r0)
            goto L84
        L39:
            r0 = move-exception
            goto L64
        L3b:
            r5 = move-exception
            goto L6a
        L3d:
            r8 = 14
            if (r5 >= r8) goto L4d
            java.lang.String r5 = "clientId file is empty, deleting it."
            r9.zzQ(r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r4.close()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r2.deleteFile(r0)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            goto L30
        L4d:
            r4.close()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r8.<init>(r6, r7, r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            java.lang.String r5 = "Read client id from disk"
            r9.zzO(r5, r8)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b java.io.FileNotFoundException -> L81
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r9.zzJ(r1, r0)
        L62:
            r3 = r8
            goto L84
        L64:
            r3 = r4
            goto L75
        L66:
            r0 = move-exception
            goto L75
        L68:
            r5 = move-exception
            r4 = r3
        L6a:
            java.lang.String r6 = "Error reading client id file, deleting it"
            r9.zzJ(r6, r5)     // Catch: java.lang.Throwable -> L39
            r2.deleteFile(r0)     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L84
            goto L30
        L75:
            if (r3 == 0) goto L7f
            r3.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r2 = move-exception
            r9.zzJ(r1, r2)
        L7f:
            throw r0
        L80:
            r4 = r3
        L81:
            if (r4 == 0) goto L84
            goto L30
        L84:
            if (r3 != 0) goto L8b
            java.lang.String r0 = r9.zzf()
            return r0
        L8b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcp.zzc():java.lang.String");
    }

    final String zze() {
        synchronized (this) {
            this.zza = null;
            this.zzb = zzq().g(new zzco(this));
        }
        return zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }
}
