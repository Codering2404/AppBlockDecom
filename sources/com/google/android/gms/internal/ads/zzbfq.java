package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbfq extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzbfh zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;

    public zzbfq() {
        zzbfh zzbfhVar = new zzbfh();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzbfhVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbkh.zzd.zze()).intValue();
        this.zzg = ((Long) zzbkh.zza.zze()).intValue();
        this.zzh = ((Long) zzbkh.zze.zze()).intValue();
        this.zzi = ((Long) zzbkh.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaG)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaH)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaI)).intValue();
        this.zze = ((Long) zzbkh.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaK);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaL)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaM)).booleanValue();
        ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaN)).getClass();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r3.importance != 100) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r0 = (android.os.PowerManager) r0.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0.isScreenOn() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r0 = com.google.android.gms.ads.internal.zzt.k().zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r0 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("ContentFetchThread: no activity. Sleeping.");
        zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        if (r0.getWindow() == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        if (r0.getWindow().getDecorView() == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        r1 = r0.getWindow().getDecorView().findViewById(android.R.id.content);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
    
        com.google.android.gms.ads.internal.zzt.l().zzg(r0, "ContentFetchTask.extractContent");
        r2 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cd, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Error in ContentFetchTask", r0);
        com.google.android.gms.ads.internal.zzt.l().zzg(r0, "ContentFetchTask.run");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Error in ContentFetchTask", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e8 A[EXC_TOP_SPLITTER, LOOP:1: B:64:0x00e8->B:73:0x00e8, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfq.run():void");
    }

    public final void zza() {
        synchronized (this.zzc) {
            try {
                if (this.zza) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Content hash thread already started, quitting...");
                } else {
                    this.zza = true;
                    start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void zzb(View view) {
        try {
            zzbfg zzbfgVar = new zzbfg(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZze = com.google.android.gms.ads.internal.zzt.k().zze();
            if (contextZze != null) {
                String str = this.zzm;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) view.getTag(contextZze.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaJ), "id", contextZze.getPackageName()));
                    if (str2 != null && str2.equals(str)) {
                        return;
                    }
                }
            }
            zzbfp zzbfpVarZzc = zzc(view, zzbfgVar);
            zzbfgVar.zzi();
            if (zzbfpVarZzc.zza == 0 && zzbfpVarZzc.zzb == 0) {
                return;
            }
            int i3 = zzbfpVarZzc.zzb;
            if (i3 == 0 && zzbfgVar.zzl() == 0) {
                return;
            }
            if (i3 == 0 && this.zzd.zza(zzbfgVar)) {
                return;
            }
            this.zzd.zzc(zzbfgVar);
        } catch (Exception e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception in fetchContentOnUIThread", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "ContentFetchTask.fetchContent");
        }
    }

    final zzbfp zzc(View view, zzbfg zzbfgVar) {
        if (view == null) {
            return new zzbfp(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzbfp(this, 0, 0);
            }
            zzbfgVar.zzg(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzbfp(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcku)) {
            WebView webView = (WebView) view;
            zzbfgVar.zze();
            webView.post(new zzbfo(this, zzbfgVar, webView, globalVisibleRect));
            return new zzbfp(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzbfp(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            zzbfp zzbfpVarZzc = zzc(viewGroup.getChildAt(i5), zzbfgVar);
            i3 += zzbfpVarZzc.zza;
            i4 += zzbfpVarZzc.zzb;
        }
        return new zzbfp(this, i3, i4);
    }

    final void zzd(zzbfg zzbfgVar, WebView webView, String str, boolean z2) {
        zzbfg zzbfgVar2;
        zzbfgVar.zzd();
        try {
            if (TextUtils.isEmpty(str)) {
                zzbfgVar2 = zzbfgVar;
            } else {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzbfgVar2 = zzbfgVar;
                    zzbfgVar2.zzf(strOptString, z2, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(strOptString);
                    zzbfgVar.zzf(sb.toString(), z2, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                    zzbfgVar2 = zzbfgVar;
                }
            }
            if (zzbfgVar2.zza()) {
                this.zzd.zzb(zzbfgVar2);
            }
        } catch (JSONException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Json string may be malformed.");
        } catch (Throwable th) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            this.zzb = true;
            StringBuilder sb = new StringBuilder(40);
            sb.append("ContentFetchThread: paused, pause = ");
            sb.append(true);
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string);
        }
    }
}
