package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbiv {
    String zzd;
    Context zze;
    String zzf;
    private AtomicBoolean zzh;
    private File zzi;
    final BlockingQueue zza = new ArrayBlockingQueue(100);
    final LinkedHashMap zzb = new LinkedHashMap();
    final Map zzc = new HashMap();
    private final HashSet zzg = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    private final void zzg(Map map, zzbje zzbjeVar) throws Throwable {
        FileOutputStream fileOutputStream;
        Uri.Builder builderBuildUpon = Uri.parse(this.zzd).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbjeVar != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!TextUtils.isEmpty(zzbjeVar.zza())) {
                sb.append("&it=");
                sb.append(zzbjeVar.zza());
            }
            if (!TextUtils.isEmpty(zzbjeVar.zzb())) {
                sb.append("&blat=");
                sb.append(zzbjeVar.zzb());
            }
            string = sb.toString();
        }
        if (!this.zzh.get()) {
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.util.zzs.o(this.zze, this.zzf, string);
            return;
        }
        File file = this.zzi;
        if (file == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
        }
        try {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.write(10);
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e6);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e7) {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e7);
                }
            }
            throw th;
        }
    }

    public final void zza(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzh = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbkl.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(zzfzk.zza().zza(externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbiu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.zza.zzf();
            }
        });
        Map map2 = this.zzc;
        zzbjb zzbjbVar = zzbjb.zzb;
        map2.put("action", zzbjbVar);
        map2.put("ad_format", zzbjbVar);
        map2.put("e", zzbjb.zzc);
    }

    public final boolean zzb(zzbjf zzbjfVar) {
        return this.zza.offer(zzbjfVar);
    }

    final Map zzc(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zzd(str).zza((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public final zzbjb zzd(String str) {
        zzbjb zzbjbVar = (zzbjb) this.zzc.get(str);
        return zzbjbVar != null ? zzbjbVar : zzbjb.zza;
    }

    public final void zze(String str) throws Throwable {
        if (this.zzg.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzf);
        linkedHashMap.put("ue", str);
        zzg(zzc(this.zzb, linkedHashMap), null);
    }

    final /* synthetic */ void zzf() throws Throwable {
        while (true) {
            try {
                zzbjf zzbjfVar = (zzbjf) this.zza.take();
                zzbje zzbjeVarZzc = zzbjfVar.zzc();
                if (!TextUtils.isEmpty(zzbjeVarZzc.zza())) {
                    zzg(zzc(this.zzb, zzbjfVar.zze()), zzbjeVarZzc);
                }
            } catch (InterruptedException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter:reporter interrupted", e3);
                return;
            }
        }
    }
}
