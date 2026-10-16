package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgai extends zzfzw {
    private zzgub<Integer> zza;
    private zzgub<Integer> zzb;
    private zzfzy zzc;
    private HttpURLConnection zzd;

    zzgai(zzgub<Integer> zzgubVar, zzgub<Integer> zzgubVar2, zzfzy zzfzyVar) {
        this.zza = zzgubVar;
        this.zzb = zzgubVar2;
        this.zzc = zzfzyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzA() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzB() {
        return -1;
    }

    public static void zzi(HttpURLConnection httpURLConnection) {
        zzfzx.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ URLConnection zzy(URL url) throws IOException {
        int i3 = zzfzr.zzb;
        return url.openConnection();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzi(this.zzd);
    }

    public URLConnection zzf(final URL url, final int i3) throws IOException {
        this.zza = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgaa
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i3);
            }
        };
        this.zzc = new zzfzy() { // from class: com.google.android.gms.internal.ads.zzgab
            @Override // com.google.android.gms.internal.ads.zzfzy
            public final /* synthetic */ URLConnection zza() {
                return zzgai.zzy(url);
            }
        };
        return zzj();
    }

    public HttpURLConnection zzg(final Network network, final URL url, final int i3, final int i4) throws IOException {
        this.zza = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgac
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i3);
            }
        };
        this.zzb = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgad
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i4);
            }
        };
        this.zzc = new zzfzy() { // from class: com.google.android.gms.internal.ads.zzgae
            @Override // com.google.android.gms.internal.ads.zzfzy
            public final /* synthetic */ URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzj();
    }

    public HttpURLConnection zzh(zzfzy zzfzyVar, final int i3, final int i4) throws IOException {
        this.zza = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgaf
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i3);
            }
        };
        this.zzb = new zzgub() { // from class: com.google.android.gms.internal.ads.zzgag
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i4);
            }
        };
        this.zzc = zzfzyVar;
        return zzj();
    }

    public HttpURLConnection zzj() throws IOException {
        zzfzx.zza(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfzy zzfzyVar = this.zzc;
        zzfzyVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfzyVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    zzgai() {
        this(zzgah.zza, zzfzz.zza, null);
    }
}
