package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
final class zzclx extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcku {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcma zzB;
    private boolean zzC;
    private boolean zzD;
    private zzblr zzE;
    private zzblo zzF;
    private zzbgd zzG;
    private int zzH;
    private int zzI;
    private zzbjc zzJ;
    private final zzbjc zzK;
    private zzbjc zzL;
    private final zzbjd zzM;
    private int zzN;
    private com.google.android.gms.ads.internal.overlay.zzm zzO;
    private boolean zzP;
    private final com.google.android.gms.ads.internal.util.zzci zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private Map zzW;
    private final WindowManager zzX;
    private final zzbhp zzY;
    private boolean zzZ;
    private final zzcmw zzb;
    private final zzbap zzc;
    private final zzflc zzd;
    private final zzbjx zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzn zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfkf zzk;
    private zzfki zzl;
    private boolean zzm;
    private boolean zzn;
    private zzclf zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzeln zzq;
    private zzell zzr;
    private zzcne zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    protected zzclx(zzcmw zzcmwVar, zzcne zzcneVar, String str, boolean z2, boolean z3, zzbap zzbapVar, zzbjx zzbjxVar, VersionInfoParcel versionInfoParcel, zzbjf zzbjfVar, com.google.android.gms.ads.internal.zzn zznVar, com.google.android.gms.ads.internal.zza zzaVar, zzbhp zzbhpVar, zzfkf zzfkfVar, zzfki zzfkiVar, zzflc zzflcVar) {
        zzfki zzfkiVar2;
        super(zzcmwVar);
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzV = -1;
        this.zzb = zzcmwVar;
        this.zzs = zzcneVar;
        this.zzt = str;
        this.zzw = z2;
        this.zzc = zzbapVar;
        this.zzd = zzflcVar;
        this.zze = zzbjxVar;
        this.zzf = versionInfoParcel;
        this.zzg = zznVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzX = windowManager;
        com.google.android.gms.ads.internal.zzt.g();
        DisplayMetrics displayMetricsG0 = com.google.android.gms.ads.internal.util.zzs.g0(windowManager);
        this.zzi = displayMetricsG0;
        this.zzj = displayMetricsG0.density;
        this.zzY = zzbhpVar;
        this.zzk = zzfkfVar;
        this.zzl = zzfkiVar;
        this.zzQ = new com.google.android.gms.ads.internal.util.zzci(zzcmwVar.zzb(), this, this, null);
        this.zzZ = false;
        setBackgroundColor(0);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznb)).booleanValue()) {
            setSoundEffectsEnabled(false);
        }
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to enable Javascript.", e3);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzna)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoH)).booleanValue()) {
            settings.setGeolocationEnabled(false);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.g().P(zzcmwVar, versionInfoParcel.f70149a));
        com.google.android.gms.ads.internal.zzt.g();
        com.google.android.gms.ads.internal.util.zzs.a0(getContext(), settings);
        setDownloadListener(this);
        zzbc();
        addJavascriptInterface(new zzcmf(this, new zzcme() { // from class: com.google.android.gms.internal.ads.zzcmd
            @Override // com.google.android.gms.internal.ads.zzcme
            public final /* synthetic */ void zza(Uri uri) {
                zzclf zzclfVarZzaS = ((zzclx) this).zzaS();
                if (zzclfVarZzaS != null) {
                    zzclfVarZzaS.zzQ(uri);
                } else {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                }
            }
        }), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbh();
        zzbjd zzbjdVar = new zzbjd(new zzbjf(true, "make_wv", this.zzt));
        this.zzM = zzbjdVar;
        zzbjdVar.zzc().zza(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue() && (zzfkiVar2 = this.zzl) != null && zzfkiVar2.zzb != null) {
            zzbjdVar.zzc().zzd("gqi", this.zzl.zzb);
        }
        zzbjdVar.zzc();
        zzbjc zzbjcVarZzf = zzbjf.zzf();
        this.zzK = zzbjcVarZzf;
        zzbjdVar.zza("native:view_create", zzbjcVarZzf);
        this.zzL = null;
        this.zzJ = null;
        com.google.android.gms.ads.internal.util.zzce.a().b(zzcmwVar);
        com.google.android.gms.ads.internal.zzt.l().zzj();
    }

    private final synchronized void zzaZ(String str) {
        final String str2 = "about:blank";
        try {
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzclu
                private final /* synthetic */ String zzb = "about:blank";

                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaW(this.zzb);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdWebViewImpl.loadUrlUnsafe");
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final synchronized void zzba() {
        Boolean boolZzc = com.google.android.gms.ads.internal.zzt.l().zzc();
        this.zzy = boolZzc;
        if (boolZzc == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaQ(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaQ(Boolean.FALSE);
            }
        }
    }

    private final void zzbb() {
        zzbix.zza(this.zzM.zzc(), this.zzK, "aeh2");
    }

    private final synchronized void zzbc() {
        zzfkf zzfkfVar = this.zzk;
        if (zzfkfVar != null && zzfkfVar.zzam) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Disabling hardware acceleration on an overlay.");
            zzbd();
            return;
        }
        if (!this.zzw && !this.zzs.zzg()) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbd() {
        try {
            if (!this.zzx) {
                setLayerType(1, null);
            }
            this.zzx = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbe() {
        try {
            if (this.zzx) {
                setLayerType(0, null);
            }
            this.zzx = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbf() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        com.google.android.gms.ads.internal.zzt.l().zzk();
    }

    private final synchronized void zzbg() {
        try {
            Map map = this.zzW;
            if (map != null) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzcja) it.next()).release();
                }
            }
            this.zzW = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbh() {
        zzbjd zzbjdVar = this.zzM;
        if (zzbjdVar == null) {
            return;
        }
        zzbjf zzbjfVarZzc = zzbjdVar.zzc();
        zzbiv zzbivVarZza = com.google.android.gms.ads.internal.zzt.l().zza();
        if (zzbivVarZza != null) {
            zzbivVarZza.zzb(zzbjfVarZzc);
        }
    }

    private final void zzbi(boolean z2) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zze("onAdVisibilityChanged", map);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final synchronized void destroy() {
        try {
            zzbh();
            this.zzQ.c();
            com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
            if (zzmVar != null) {
                zzmVar.zzb();
                this.zzp.zzq();
                this.zzp = null;
            }
            this.zzq = null;
            this.zzr = null;
            this.zzo.zzF();
            this.zzG = null;
            this.zzg = null;
            setOnClickListener(null);
            setOnTouchListener(null);
            if (this.zzv) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.b().zza(this);
            zzbg();
            this.zzv = true;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmi)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.k("Destroying the WebView immediately...");
                zzY();
                return;
            }
            Activity activityZzb = this.zzb.zzb();
            if (activityZzb != null && activityZzb.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zze.k("Destroying the WebView immediately...");
                zzY();
            } else {
                com.google.android.gms.ads.internal.util.zze.k("Initiating WebView self destruct sequence in 3...");
                com.google.android.gms.ads.internal.util.zze.k("Loading blank page in WebView, 2...");
                zzaZ("about:blank");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzX()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmj)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcfr.zzf.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaU(str, valueCallback);
                }
            });
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                try {
                    if (!this.zzv) {
                        this.zzo.zzF();
                        com.google.android.gms.ads.internal.zzt.b().zza(this);
                        zzbg();
                        zzbf();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzX()) {
            super.loadData(str, str2, str3);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
            try {
                if (!zzX()) {
                    super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                    return;
                } else {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final synchronized void loadUrl(final String str) {
        if (zzX()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzaV(str);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdWebViewImpl.loadUrl");
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            if (!zzX()) {
                this.zzQ.d();
            }
            if (this.zzZ) {
                onResume();
                this.zzZ = false;
            }
            boolean z2 = this.zzC;
            zzclf zzclfVar = this.zzo;
            if (zzclfVar != null && zzclfVar.zzl()) {
                if (!this.zzD) {
                    this.zzo.zzo();
                    this.zzo.zzp();
                    this.zzD = true;
                }
                zzaM();
                z2 = true;
            }
            zzbi(z2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzclf zzclfVar;
        synchronized (this) {
            try {
                if (!zzX()) {
                    this.zzQ.e();
                }
                super.onDetachedFromWindow();
                if (this.zzD && (zzclfVar = this.zzo) != null && zzclfVar.zzl() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                    this.zzo.zzo();
                    this.zzo.zzp();
                    this.zzD = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzbi(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmx)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.util.zzs.y(getContext(), intent);
        } catch (ActivityNotFoundException e3) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzX()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaM = zzaM();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL == null || !zZzaM) {
            return;
        }
        zzmVarZzL.zzC();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclx.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final void onPause() {
        if (zzX()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzob)).booleanValue() && WebViewFeature.a("MUTE_AUDIO")) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Muting webview");
                WebViewCompat.j(this, true);
            }
        } catch (Exception e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not pause webview.", e3);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoe)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final void onResume() {
        if (zzX()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzob)).booleanValue() && WebViewFeature.a("MUTE_AUDIO")) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Unmuting webview");
                WebViewCompat.j(this, false);
            }
        } catch (Exception e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not resume webview.", e3);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoe)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzes)).booleanValue() && this.zzo.zzm();
        if ((!this.zzo.zzl() || this.zzo.zzn()) && !z2) {
            zzbap zzbapVar = this.zzc;
            if (zzbapVar != null) {
                zzbapVar.zzc(motionEvent);
            }
            zzbjx zzbjxVar = this.zze;
            if (zzbjxVar != null) {
                zzbjxVar.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                try {
                    zzblr zzblrVar = this.zzE;
                    if (zzblrVar != null) {
                        zzblrVar.zzb(motionEvent);
                    }
                } finally {
                }
            }
        }
        if (zzX()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcku
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzclf) {
            this.zzo = (zzclf) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzX()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not stop loading webview.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzA(int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzB(int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzckl
    public final zzfkf zzC() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final WebView zzD() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmp
    public final View zzE() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final List zzF() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzG() {
        zzbb();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.f70149a);
        zze("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzH(int i3) {
        if (i3 == 0) {
            zzbjd zzbjdVar = this.zzM;
            zzbix.zza(zzbjdVar.zzc(), this.zzK, "aebb2");
        }
        zzbb();
        zzbjd zzbjdVar2 = this.zzM;
        zzbjdVar2.zzc();
        zzbjdVar2.zzc().zzd("close_type", String.valueOf(i3));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i3));
        map.put("version", this.zzf.f70149a);
        zze("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzI() {
        if (this.zzJ == null) {
            zzbjd zzbjdVar = this.zzM;
            zzbix.zza(zzbjdVar.zzc(), this.zzK, "aes2");
            zzbjdVar.zzc();
            zzbjc zzbjcVarZzf = zzbjf.zzf();
            this.zzJ = zzbjcVarZzf;
            zzbjdVar.zza("native:view_show", zzbjcVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.f70149a);
        zze("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzJ() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzt.m().d()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzt.m().b()));
        map.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzaa.e(getContext())));
        zze("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final Context zzK() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmm
    public final synchronized zzcne zzN() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized String zzO() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final /* synthetic */ zzcms zzP() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final WebViewClient zzQ() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized boolean zzR() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmn
    public final zzbap zzS() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzflc zzT() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized zzeln zzU() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized zzell zzV() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized boolean zzW() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized boolean zzX() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzY() {
        com.google.android.gms.ads.internal.util.zze.k("Destroying WebView!");
        zzbf();
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcls(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized boolean zzZ() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zza(String str) {
        zzaP(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzaA(final boolean z2, final int i3) {
        destroy();
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzclv
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                int i4 = zzclx.zza;
                zzbhv.zzbl.zza zzaVarZzq = zzbhv.zzbl.zzq();
                boolean zZzb = zzaVarZzq.zzb();
                boolean z3 = z2;
                if (zZzb != z3) {
                    zzaVarZzq.zzc(z3);
                }
                zzaVarZzq.zzg(i3);
                zzaVar.zzal(zzaVarZzq.zzbu());
            }
        };
        zzbhp zzbhpVar = this.zzY;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzaB() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmb
    public final zzfki zzaC() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaD(zzfkf zzfkfVar, zzfki zzfkiVar) {
        this.zzk = zzfkfVar;
        this.zzl = zzfkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzaE(boolean z2) {
        if (z2) {
            try {
                setBackgroundColor(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzu(z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final ListenableFuture zzaF() {
        zzbjx zzbjxVar = this.zze;
        return zzbjxVar == null ? zzhbw.zza(null) : zzbjxVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaG(boolean z2) {
        this.zzZ = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaH(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z2, boolean z3, String str) {
        this.zzo.zzv(zzcVar, z2, z3, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaI(boolean z2, int i3, boolean z3) {
        this.zzo.zzx(z2, i3, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaJ(boolean z2, int i3, String str, boolean z3, boolean z4) {
        this.zzo.zzy(z2, i3, str, z3, z4);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaK(boolean z2, int i3, String str, String str2, boolean z3) {
        this.zzo.zzz(z2, i3, str, str2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaL(String str, String str2, int i3) {
        this.zzo.zzw(str, str2, 14);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (r10.zzV != r9) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzaM() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzclf r0 = r10.zzo
            boolean r0 = r0.zzk()
            r1 = 0
            if (r0 != 0) goto L13
            com.google.android.gms.internal.ads.zzclf r0 = r10.zzo
            boolean r0 = r0.zzl()
            if (r0 != 0) goto L13
            goto L88
        L13:
            com.google.android.gms.ads.internal.client.zzay.a()
            android.util.DisplayMetrics r0 = r10.zzi
            int r2 = r0.widthPixels
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.c(r0, r2)
            com.google.android.gms.ads.internal.client.zzay.a()
            int r2 = r0.heightPixels
            int r5 = com.google.android.gms.ads.internal.util.client.zzf.c(r0, r2)
            com.google.android.gms.internal.ads.zzcmw r2 = r10.zzb
            android.app.Activity r2 = r2.zzb()
            r3 = 1
            if (r2 == 0) goto L52
            android.view.Window r6 = r2.getWindow()
            if (r6 != 0) goto L37
            goto L52
        L37:
            com.google.android.gms.ads.internal.zzt.g()
            int[] r2 = com.google.android.gms.ads.internal.util.zzs.v(r2)
            com.google.android.gms.ads.internal.client.zzay.a()
            r6 = r2[r1]
            int r6 = com.google.android.gms.ads.internal.util.client.zzf.c(r0, r6)
            com.google.android.gms.ads.internal.client.zzay.a()
            r2 = r2[r3]
            int r2 = com.google.android.gms.ads.internal.util.client.zzf.c(r0, r2)
            r7 = r2
            goto L54
        L52:
            r6 = r4
            r7 = r5
        L54:
            com.google.android.gms.ads.internal.zzt.g()
            android.view.WindowManager r2 = r10.zzX
            android.view.Display r2 = r2.getDefaultDisplay()
            int r9 = r2.getRotation()
            int r2 = r10.zzS
            if (r2 != r4) goto L89
            int r2 = r10.zzR
            if (r2 != r5) goto L89
            int r2 = r10.zzT
            if (r2 != r6) goto L89
            int r2 = r10.zzU
            if (r2 != r7) goto L89
            com.google.android.gms.internal.ads.zzbih r2 = com.google.android.gms.internal.ads.zzbiq.zzaF
            com.google.android.gms.internal.ads.zzbio r8 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r2 = r8.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L88
            int r2 = r10.zzV
            if (r2 == r9) goto L88
            goto L89
        L88:
            return r1
        L89:
            int r2 = r10.zzS
            if (r2 != r4) goto La7
            int r2 = r10.zzR
            if (r2 != r5) goto La7
            com.google.android.gms.internal.ads.zzbih r2 = com.google.android.gms.internal.ads.zzbiq.zzaF
            com.google.android.gms.internal.ads.zzbio r8 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r2 = r8.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto La8
            int r2 = r10.zzV
            if (r2 == r9) goto La8
        La7:
            r1 = r3
        La8:
            r10.zzS = r4
            r10.zzR = r5
            r10.zzT = r6
            r10.zzU = r7
            r10.zzV = r9
            com.google.android.gms.internal.ads.zzbyg r3 = new com.google.android.gms.internal.ads.zzbyg
            java.lang.String r2 = ""
            r3.<init>(r10, r2)
            float r8 = r0.density
            r3.zzl(r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclx.zzaM():boolean");
    }

    protected final synchronized void zzaN(String str) {
        if (!zzX()) {
            loadUrl(str);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
        }
    }

    protected final synchronized void zzaO(String str, ValueCallback valueCallback) {
        if (!zzX()) {
            evaluateJavascript(str, null);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
        }
    }

    protected final void zzaP(String str) {
        if (zzaR() == null) {
            zzba();
        }
        if (zzaR().booleanValue()) {
            zzaO(str, null);
        } else {
            zzaN("javascript:".concat(str));
        }
    }

    final void zzaQ(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        com.google.android.gms.ads.internal.zzt.l().zzb(bool);
    }

    final synchronized Boolean zzaR() {
        return this.zzy;
    }

    public final zzclf zzaS() {
        return this.zzo;
    }

    final /* synthetic */ void zzaU(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    final /* synthetic */ void zzaV(String str) {
        super.loadUrl(str);
    }

    final /* synthetic */ void zzaW(String str) {
        super.loadUrl("about:blank");
    }

    final /* synthetic */ int zzaX() {
        return this.zzI;
    }

    final /* synthetic */ void zzaY(int i3) {
        this.zzI = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized boolean zzaa() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzab(String str, zzbpq zzbpqVar) {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.zzB(str, zzbpqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzac(String str, zzbpq zzbpqVar) {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.zzC(str, zzbpqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzad(String str, Predicate predicate) {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.zzE(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzae(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzaf(zzcne zzcneVar) {
        this.zzs = zzcneVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzag(boolean z2) {
        try {
            boolean z3 = this.zzw;
            this.zzw = z2;
            zzbc();
            if (z2 != z3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaD)).booleanValue()) {
                    if (!this.zzs.zzg()) {
                    }
                }
                new zzbyg(this, "").zzk(true != z2 ? "default" : "expanded");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzah() {
        this.zzQ.b();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzai(Context context) {
        zzcmw zzcmwVar = this.zzb;
        zzcmwVar.setBaseContext(context);
        this.zzQ.a(zzcmwVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzaj(boolean z2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.n5(this.zzo.zzk(), z2);
        } else {
            this.zzu = z2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzak(zzeln zzelnVar) {
        this.zzq = zzelnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzal(zzell zzellVar) {
        this.zzr = zzellVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzam(int i3) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.o5(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzan(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzO = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzao(boolean z2) {
        this.zzz = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzap() {
        if (this.zzL == null) {
            zzbjd zzbjdVar = this.zzM;
            zzbjdVar.zzc();
            zzbjc zzbjcVarZzf = zzbjf.zzf();
            this.zzL = zzbjcVarZzf;
            zzbjdVar.zza("native:view_load", zzbjcVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzaq(zzblr zzblrVar) {
        this.zzE = zzblrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized zzblr zzar() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzas(boolean z2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i3 = this.zzH + (true != z2 ? -1 : 1);
        this.zzH = i3;
        if (i3 > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.i5();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzat() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzau(String str, String str2, String str3) throws Throwable {
        Throwable th;
        String str4;
        try {
            try {
                if (zzX()) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                String str5 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaC);
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put(jTYhJgqLBN.xbSUYFJ, str5);
                        jSONObject.put("sdk", "Google Mobile Ads");
                        jSONObject.put("sdkVersion", "12.4.51-000");
                        str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (JSONException e3) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("Unable to build MRAID_ENV", e3);
                    str4 = null;
                }
                super.loadDataWithBaseURL(str, zzcml.zza(str2, str4), "text/html", Utf8Charset.NAME, null);
                return;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzav() {
        com.google.android.gms.ads.internal.util.zze.k("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaw(boolean z2) {
        this.zzo.zzO(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzax(zzblo zzbloVar) {
        this.zzF = zzbloVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized void zzay(zzbgd zzbgdVar) {
        this.zzG = zzbgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final synchronized zzbgd zzaz() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(String str, JSONObject jSONObject) {
        zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzc(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length() + 2);
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzaP(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void zzd(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        String string2 = sb.toString();
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Dispatching AFMA event: ".concat(string2));
        zzaP(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.zzdR();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        boolean z2;
        synchronized (this) {
            z2 = zzbepVar.zzj;
            this.zzC = z2;
        }
        zzbi(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdk() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdl() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final zzchc zzdm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzdn(boolean z2) {
        this.zzo.zzM(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzclf zzclfVar = this.zzo;
        if (zzclfVar != null) {
            zzclfVar.zzdu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void zze(String str, Map map) {
        try {
            zzd(str, com.google.android.gms.ads.internal.client.zzay.a().w(map));
        } catch (JSONException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final synchronized zzcma zzh() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final zzbjc zzi() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmg, com.google.android.gms.internal.ads.zzchn
    public final Activity zzj() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final com.google.android.gms.ads.internal.zza zzk() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzl() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzE();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized String zzm() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized String zzn() {
        zzfki zzfkiVar = this.zzl;
        if (zzfkiVar == null) {
            return null;
        }
        return zzfkiVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized void zzo(int i3) {
        this.zzN = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized int zzp() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final zzbjd zzq() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized zzcja zzr(String str) {
        Map map = this.zzW;
        if (map == null) {
            return null;
        }
        return (zzcja) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmo, com.google.android.gms.internal.ads.zzchn
    public final VersionInfoParcel zzs() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final synchronized void zzt(String str, zzcja zzcjaVar) {
        try {
            if (this.zzW == null) {
                this.zzW = new HashMap();
            }
            this.zzW.put(str, zzcjaVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzu(boolean z2, long j3) {
        HashMap map = new HashMap(2);
        map.put(GraphResponse.SUCCESS_KEY, true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        map.put("duration", Long.toString(j3));
        zze("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzv(int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final synchronized void zzw(zzcma zzcmaVar) {
        if (this.zzB == null) {
            this.zzB = zzcmaVar;
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Attempt to create multiple AdWebViewVideoControllers.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final int zzx() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final int zzy() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final synchronized void zzz() {
        zzblo zzbloVar = this.zzF;
        if (zzbloVar != null) {
            zzbloVar.zza();
        }
    }
}
