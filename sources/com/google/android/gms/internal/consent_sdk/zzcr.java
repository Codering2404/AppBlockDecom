package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.util.Log;
import android.webkit.WebSettings;
import com.facebook.GraphRequest;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcr {
    private final Application zzd;
    private final zzco zze;
    private final Executor zzf;
    private final boolean zzg;
    private final AtomicReference zzh = new AtomicReference(new ArrayDeque());
    public final AtomicReference zzb = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzi = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzj = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzk = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzl = new AtomicReference(new ArrayDeque());
    public final AtomicReference zzc = new AtomicReference(new ArrayDeque());
    final AtomicReference zza = new AtomicReference(null);

    zzcr(zzad zzadVar, Application application, Executor executor, zzco zzcoVar, boolean z2) {
        this.zzg = z2;
        this.zzd = application;
        this.zze = zzcoVar;
        this.zzf = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        String str = (String) this.zza.get();
        if (str == null) {
            Log.w("UserMessagingPlatform", "Metrics reporting URL is not set yet.");
            return;
        }
        AtomicReference atomicReference = this.zzl;
        int size = ((Queue) atomicReference.get()).size();
        for (int i3 = 0; i3 < size; i3++) {
            zzif zzifVar = (zzif) ((Queue) atomicReference.get()).poll();
            if (zzifVar != null) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URI(str).toURL().openConnection();
                    httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, WebSettings.getDefaultUserAgent(this.zzd));
                    httpURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/protobuf");
                    zzifVar.zzE(httpURLConnection.getOutputStream());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200 && responseCode != 204) {
                        Log.w("UserMessagingPlatform", "Fail to ping metrics reporting URL: Http error code - " + responseCode + ".\n" + (httpURLConnection.getErrorStream() != null ? new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next() : null));
                        ((Queue) atomicReference.get()).add(zzifVar);
                    }
                } catch (IOException e3) {
                    Log.w("UserMessagingPlatform", "Fail to ping metrics reporting URL: ".concat(String.valueOf(e3.getMessage())));
                    ((Queue) this.zzl.get()).add(zzifVar);
                } catch (URISyntaxException e4) {
                    Log.w("UserMessagingPlatform", "Metrics reporting URL " + str + " is not valid: " + e4.getMessage());
                }
            }
        }
    }

    private final void zzm(Queue queue, int i3, int i4, String str) {
        Long l3 = (Long) queue.poll();
        if (l3 != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - l3.longValue();
            if (str != null) {
                i3 = i4;
            }
            AtomicReference atomicReference = this.zzl;
            ((Queue) atomicReference.get()).add(this.zze.zza(i3, str, jCurrentTimeMillis));
            if (this.zzg) {
                ((ArrayDeque) this.zzc.get()).addAll((Collection) atomicReference.get());
            }
            this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzcq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl();
                }
            });
        }
    }

    public final void zzb(String str) {
        zzm((Queue) this.zzj.get(), 10, 11, str);
    }

    public final void zzc() {
        ((Queue) this.zzj.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzd(String str) {
        zzm((Queue) this.zzb.get(), 4, 5, str);
    }

    public final void zze(String str) {
        zzm((Queue) this.zzi.get(), 6, 7, str);
    }

    public final void zzf() {
        ((Queue) this.zzi.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzg(String str) {
        zzm((Queue) this.zzh.get(), 8, 9, str);
    }

    public final void zzh() {
        ((Queue) this.zzh.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzi() {
        ((Queue) this.zzk.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzj() {
        zzm((Queue) this.zzk.get(), 3, 2, null);
    }

    public final void zzk(String str) {
        this.zza.set(str);
    }
}
