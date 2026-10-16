package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public class zzclf extends WebViewClient implements zzcms {
    public static final /* synthetic */ int zzc = 0;
    private zzdzl zzA;
    private zzdbn zzB;
    private boolean zzC;
    private boolean zzD;
    private int zzE;
    private boolean zzF;
    private final zzekr zzH;
    private View.OnAttachStateChangeListener zzI;
    protected final zzcku zza;
    protected zzcdn zzb;
    private final zzbhp zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzcmq zzi;
    private zzcmr zzj;
    private zzbog zzk;
    private zzboi zzl;
    private zzdky zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzad zzw;
    private zzbyf zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbya zzz = null;
    private final HashSet zzG = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgH)).split(MHoiDDglUlPJC.BrpLpO)));

    private final void zzac(final View view, final zzcdn zzcdnVar, final int i3) {
        if (!zzcdnVar.zzc() || i3 <= 0) {
            return;
        }
        zzcdnVar.zzd(view);
        if (zzcdnVar.zzc()) {
            com.google.android.gms.ads.internal.util.zzs.f70374l.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcld
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzU(view, zzcdnVar, i3);
                }
            }, 100L);
        }
    }

    private final void zzad() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzI;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zza).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private static WebResourceResponse zzae() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbv)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:
    
        com.google.android.gms.ads.internal.zzt.g();
        com.google.android.gms.ads.internal.zzt.g();
        r0 = r13.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011a, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011e, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0120, code lost:
    
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0122, code lost:
    
        r15 = r0.split(";")[0].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012d, code lost:
    
        com.google.android.gms.ads.internal.zzt.g();
        r0 = r13.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0138, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013a, code lost:
    
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x013d, code lost:
    
        r0 = r0.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0142, code lost:
    
        if (r0.length != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0147, code lost:
    
        if (r1 >= r0.length) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0155, code lost:
    
        if (r0[r1].trim().startsWith("charset") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0157, code lost:
    
        r2 = r0[r1].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0164, code lost:
    
        if (r2.length <= 1) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0166, code lost:
    
        r4 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x016d, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0170, code lost:
    
        r0 = r13.getHeaderFields();
        r1 = new java.util.HashMap(r0.size());
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0189, code lost:
    
        if (r0.hasNext() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018b, code lost:
    
        r2 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0195, code lost:
    
        if (r2.getKey() == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019b, code lost:
    
        if (r2.getValue() == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a7, code lost:
    
        if (r2.getValue().isEmpty() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01a9, code lost:
    
        r1.put(r2.getKey(), r2.getValue().get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01bf, code lost:
    
        r9 = com.google.android.gms.ads.internal.zzt.j().c(r15, r16, r13.getResponseCode(), r13.getResponseMessage(), r1, r13.getInputStream());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse zzaf(java.lang.String r22, java.util.Map r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclf.zzaf(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public final void zzaa(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            com.google.android.gms.ads.internal.util.zze.k("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                String str3 = (String) map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbpq) it.next()).zza(this.zza, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzah, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzY(boolean z2, long j3) {
        this.zza.zzu(z2, j3);
    }

    private static final boolean zzai(zzcku zzckuVar) {
        return zzckuVar.zzC() != null && zzckuVar.zzC().zzb();
    }

    private static final boolean zzaj(boolean z2, zzcku zzckuVar) {
        return (!z2 || zzckuVar.zzN().zzg() || zzckuVar.zzO().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcms, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            try {
                zzcku zzckuVar = this.zza;
                if (zzckuVar.zzX()) {
                    com.google.android.gms.ads.internal.util.zze.k("Blank page loaded, 1...");
                    zzckuVar.zzY();
                    return;
                }
                this.zzC = true;
                zzcmr zzcmrVar = this.zzj;
                if (zzcmrVar != null) {
                    zzcmrVar.zza();
                    this.zzj = null;
                }
                zzu();
                zzcku zzckuVar2 = this.zza;
                if (zzckuVar2.zzL() != null) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzns)).booleanValue()) {
                        zzckuVar2.zzL().q5(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i3, String str, String str2) {
        this.zzo = true;
        this.zzp = i3;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzL(str, Collections.EMPTY_MAP);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.k("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZzd = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZzd.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZzd.getHost())) {
            zzQ(uriZzd);
        } else {
            if (this.zzn && webView == this.zza.zzD()) {
                String scheme = uriZzd.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzcdn zzcdnVar = this.zzb;
                        if (zzcdnVar != null) {
                            zzcdnVar.zzb(str);
                        }
                        this.zzg = null;
                    }
                    zzdky zzdkyVar = this.zzm;
                    if (zzdkyVar != null) {
                        zzdkyVar.zzdu();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            zzcku zzckuVar = this.zza;
            if (zzckuVar.zzD().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzo.f("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzbap zzbapVarZzS = zzckuVar.zzS();
                    zzflc zzflcVarZzT = zzckuVar.zzT();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznw)).booleanValue() || zzflcVarZzT == null) {
                        if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                            uriZzd = zzbapVarZzS.zzd(uriZzd, zzckuVar.getContext(), (View) zzckuVar, zzckuVar.zzj());
                        }
                    } else if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                        uriZzd = zzflcVarZzT.zza(uriZzd, zzckuVar.getContext(), (View) zzckuVar, zzckuVar.zzj());
                    }
                } catch (zzbaq unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.b()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZzd.toString(), null, null, null, null, null, null);
                    zzcku zzckuVar2 = this.zza;
                    zzv(zzcVar, true, false, zzckuVar2 != null ? zzckuVar2.zzn() : "");
                } else {
                    zzbVar.c(str);
                }
            }
        }
        return true;
    }

    public final void zzA(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbya zzbyaVar = this.zzz;
        boolean zZzd = zzbyaVar != null ? zzbyaVar.zzd() : false;
        com.google.android.gms.ads.internal.zzt.f();
        com.google.android.gms.ads.internal.overlay.zzn.a(this.zza.getContext(), adOverlayInfoParcel, !zZzd, this.zzA);
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            String str = adOverlayInfoParcel.f70052m;
            if (str == null && (zzcVar = adOverlayInfoParcel.f70041a) != null) {
                str = zzcVar.f70075b;
            }
            zzcdnVar.zzb(str);
        }
    }

    public final void zzB(String str, zzbpq zzbpqVar) {
        synchronized (this.zzf) {
            try {
                HashMap map = this.zze;
                List copyOnWriteArrayList = (List) map.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    map.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(zzbpqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzC(String str, zzbpq zzbpqVar) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.remove(zzbpqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzD(String str) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzE(String str, Predicate predicate) {
        synchronized (this.zzf) {
            try {
                List<zzbpq> list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (zzbpq zzbpqVar : list) {
                    if (predicate.apply(zzbpqVar)) {
                        arrayList.add(zzbpqVar);
                    }
                }
                list.removeAll(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzF() {
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcdnVar.zzf();
            this.zzb = null;
        }
        zzad();
        synchronized (this.zzf) {
            try {
                this.zze.clear();
                this.zzg = null;
                this.zzh = null;
                this.zzi = null;
                this.zzj = null;
                this.zzk = null;
                this.zzl = null;
                this.zzn = false;
                this.zzs = false;
                this.zzt = false;
                this.zzu = false;
                this.zzw = null;
                this.zzy = null;
                this.zzx = null;
                zzbya zzbyaVar = this.zzz;
                if (zzbyaVar != null) {
                    zzbyaVar.zzb(true);
                    this.zzz = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzG(zzcmq zzcmqVar) {
        this.zzi = zzcmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzH(zzcmr zzcmrVar) {
        this.zzj = zzcmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final zzdzl zzI() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzJ(zzdbn zzdbnVar) {
        this.zzB = zzdbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final zzdbn zzK() {
        return this.zzB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02e3 A[Catch: NoClassDefFoundError -> 0x0020, Exception -> 0x0023, TryCatch #11 {Exception -> 0x0023, NoClassDefFoundError -> 0x0020, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0026, B:12:0x0036, B:14:0x003d, B:16:0x004b, B:18:0x0067, B:20:0x0080, B:22:0x0097, B:23:0x009a, B:25:0x009d, B:28:0x00b9, B:30:0x00cd, B:33:0x00e8, B:78:0x01c8, B:50:0x017c, B:97:0x02cd, B:100:0x02dd, B:102:0x02e3, B:104:0x02f1, B:86:0x024b, B:87:0x027e, B:85:0x0219, B:49:0x014b, B:32:0x00db, B:88:0x027f, B:90:0x0289, B:92:0x028f, B:94:0x02c2), top: B:112:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020e A[Catch: all -> 0x01bb, TryCatch #12 {all -> 0x01bb, blocks: (B:71:0x01a0, B:73:0x01b2, B:77:0x01be, B:81:0x01fc, B:83:0x020e, B:84:0x0215), top: B:111:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02cd A[Catch: NoClassDefFoundError -> 0x0020, Exception -> 0x0023, TryCatch #11 {Exception -> 0x0023, NoClassDefFoundError -> 0x0020, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0026, B:12:0x0036, B:14:0x003d, B:16:0x004b, B:18:0x0067, B:20:0x0080, B:22:0x0097, B:23:0x009a, B:25:0x009d, B:28:0x00b9, B:30:0x00cd, B:33:0x00e8, B:78:0x01c8, B:50:0x017c, B:97:0x02cd, B:100:0x02dd, B:102:0x02e3, B:104:0x02f1, B:86:0x024b, B:87:0x027e, B:85:0x0219, B:49:0x014b, B:32:0x00db, B:88:0x027f, B:90:0x0289, B:92:0x028f, B:94:0x02c2), top: B:112:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final android.webkit.WebResourceResponse zzL(java.lang.String r21, java.util.Map r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclf.zzL(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final void zzM(boolean z2) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzN() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclb
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcku zzckuVar = this.zza.zza;
                    zzckuVar.zzah();
                    com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzckuVar.zzL();
                    if (zzmVarZzL != null) {
                        zzmVarZzL.zzv();
                    }
                }
            });
        }
    }

    public final void zzO(boolean z2) {
        this.zzF = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzP(int i3, int i4) {
        zzbya zzbyaVar = this.zzz;
        if (zzbyaVar != null) {
            zzbyaVar.zze(i3, i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzQ(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.k("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.k("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhH)).booleanValue() || com.google.android.gms.ads.internal.zzt.l().zza() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws Throwable {
                    int i3 = zzclf.zzc;
                    com.google.android.gms.ads.internal.zzt.l().zza().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgG)).booleanValue() && this.zzG.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgI)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.k("Parsing gmsg query params on BG thread: ".concat(path));
                zzhbw.zzr(com.google.android.gms.ads.internal.zzt.g().Q(uri), new zzckw(this, list, path, uri), zzcfr.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.g();
        zzaa(com.google.android.gms.ads.internal.util.zzs.t(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzR(boolean z2) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzS(boolean z2) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzT(boolean z2) {
        synchronized (this.zzf) {
            this.zzv = z2;
        }
    }

    final /* synthetic */ void zzU(View view, zzcdn zzcdnVar, int i3) {
        zzac(view, zzcdnVar, i3 - 1);
    }

    final /* synthetic */ void zzV(boolean z2, long j3) {
        zzY(true, j3);
    }

    final /* synthetic */ void zzZ(View view, zzcdn zzcdnVar, int i3) {
        zzac(view, zzcdnVar, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zza(int i3, int i4, boolean z2) {
        zzbyf zzbyfVar = this.zzx;
        if (zzbyfVar != null) {
            zzbyfVar.zzb(i3, i4);
        }
        zzbya zzbyaVar = this.zzz;
        if (zzbyaVar != null) {
            zzbyaVar.zzc(i3, i4, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzab(com.google.android.gms.ads.internal.client.zza zzaVar, zzbog zzbogVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzboi zzboiVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z2, zzbpt zzbptVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbyh zzbyhVar, zzcdn zzcdnVar, zzekg zzekgVar, zzfsc zzfscVar, zzdzl zzdzlVar, zzbql zzbqlVar, zzdky zzdkyVar, zzbqk zzbqkVar, zzbqe zzbqeVar, zzbpr zzbprVar, zzctj zzctjVar, zzeao zzeaoVar, zzdbs zzdbsVar, zzdbn zzdbnVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zza.getContext(), zzcdnVar, null) : zzbVar;
        zzcku zzckuVar = this.zza;
        this.zzz = new zzbya(zzckuVar, zzbyhVar);
        this.zzb = zzcdnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbE)).booleanValue()) {
            zzB("/adMetadata", new zzbof(zzbogVar));
        }
        if (zzboiVar != null) {
            zzB("/appEvent", new zzboh(zzboiVar));
        }
        zzB("/backButton", zzbpp.zzj);
        zzB("/refresh", zzbpp.zzk);
        zzB("/canOpenApp", zzbpp.zzb);
        zzB("/canOpenURLs", zzbpp.zza);
        zzB("/canOpenIntents", zzbpp.zzc);
        zzB("/close", zzbpp.zzd);
        zzB("/customClose", zzbpp.zze);
        zzB("/instrument", zzbpp.zzn);
        zzB("/delayPageLoaded", zzbpp.zzp);
        zzB("/delayPageClosed", zzbpp.zzq);
        zzB("/getLocationInfo", zzbpp.zzr);
        zzB("/log", zzbpp.zzg);
        zzB("/mraid", new zzbpx(zzbVar2, this.zzz, zzbyhVar));
        zzbyf zzbyfVar = this.zzx;
        if (zzbyfVar != null) {
            zzB("/mraidLoaded", zzbyfVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbqd(zzbVar3, this.zzz, zzekgVar, zzdzlVar, zzctjVar, zzdbsVar));
        zzB("/precache", new zzcjb());
        zzB("/touch", zzbpp.zzi);
        zzB("/video", zzbpp.zzl);
        zzB("/videoMeta", zzbpp.zzm);
        if (zzekgVar == null || zzfscVar == null) {
            zzB("/click", zzbpp.zzb(zzdkyVar, zzctjVar));
            zzB("/httpTrack", zzbpp.zzf);
        } else {
            zzB("/click", zzflj.zza(zzekgVar, zzfscVar, zzctjVar, zzdkyVar));
            zzB("/httpTrack", zzflj.zzb(zzekgVar, zzfscVar));
        }
        if (com.google.android.gms.ads.internal.zzt.d().zza(zzckuVar.getContext())) {
            Map map = new HashMap();
            if (zzckuVar.zzC() != null) {
                map = zzckuVar.zzC().zzaw;
            }
            zzB("/logScionEvent", new zzbpw(zzckuVar.getContext(), map));
        }
        if (zzbptVar != null) {
            zzB("/setInterstitialProperties", new zzbps(zzbptVar));
        }
        if (zzbqlVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue()) {
                zzB("/inspectorNetworkExtras", zzbqlVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkH)).booleanValue() && zzbqkVar != null) {
            zzB("/shareSheet", zzbqkVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziK)).booleanValue() && zzeaoVar != null) {
            zzB("/onDeviceStorageEvent", new zzbpy(zzeaoVar));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkM)).booleanValue() && zzbqeVar != null) {
            zzB("/inspectorOutOfContextTest", zzbqeVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkR)).booleanValue() && zzbprVar != null) {
            zzB("/inspectorStorage", zzbprVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmX)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzbpp.zzu);
            zzB("/presentPlayStoreOverlay", zzbpp.zzv);
            zzB("/expandPlayStoreOverlay", zzbpp.zzw);
            zzB("/collapsePlayStoreOverlay", zzbpp.zzx);
            zzB("/closePlayStoreOverlay", zzbpp.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzej)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzbpp.zzA);
            zzB("/resetPAID", zzbpp.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznr)).booleanValue() && zzckuVar.zzC() != null && zzckuVar.zzC().zzar) {
            zzB("/writeToLocalStorage", zzbpp.zzB);
            zzB("/clearLocalStorageKeys", zzbpp.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbogVar;
        this.zzl = zzboiVar;
        this.zzw = zzadVar;
        this.zzy = zzbVar3;
        this.zzm = zzdkyVar;
        this.zzA = zzdzlVar;
        this.zzB = zzdbnVar;
        this.zzn = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzb(zzfkf zzfkfVar) {
        zzcku zzckuVar = this.zza;
        if (com.google.android.gms.ads.internal.zzt.d().zza(zzckuVar.getContext())) {
            zzD("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbpw(zzckuVar.getContext(), zzfkfVar.zzaw));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzc(zzctj zzctjVar) {
        zzD("/click");
        zzB("/click", zzbpp.zzb(this.zzm, zzctjVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzd(zzctj zzctjVar, zzekg zzekgVar, zzfsc zzfscVar) {
        zzD("/click");
        if (zzekgVar == null || zzfscVar == null) {
            zzB("/click", zzbpp.zzb(this.zzm, zzctjVar));
        } else {
            zzB("/click", zzflj.zza(zzekgVar, zzfscVar, zzctjVar, this.zzm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzdky zzdkyVar = this.zzm;
        if (zzdkyVar != null) {
            zzdkyVar.zzdR();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzdky zzdkyVar = this.zzm;
        if (zzdkyVar != null) {
            zzdkyVar.zzdu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zze(zzctj zzctjVar, zzekg zzekgVar, zzdzl zzdzlVar) {
        zzD("/open");
        zzB("/open", new zzbqd(this.zzy, this.zzz, zzekgVar, zzdzlVar, zzctjVar, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final com.google.android.gms.ads.internal.zzb zzh() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzi(com.google.android.gms.ads.internal.zzb zzbVar) {
        this.zzy = zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzj(zzcdn zzcdnVar) {
        this.zzb = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final boolean zzk() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzs;
        }
        return z2;
    }

    public final boolean zzl() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzt;
        }
        return z2;
    }

    public final boolean zzm() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzu;
        }
        return z2;
    }

    public final boolean zzn() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzv;
        }
        return z2;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzo() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzp() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzq() {
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcku zzckuVar = this.zza;
            WebView webViewZzD = zzckuVar.zzD();
            if (ViewCompat.Q(webViewZzD)) {
                zzac(webViewZzD, zzcdnVar, 10);
                return;
            }
            zzad();
            zzckv zzckvVar = new zzckv(this, zzcdnVar);
            this.zzI = zzckvVar;
            ((View) zzckuVar).addOnAttachStateChangeListener(zzckvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzr() {
        synchronized (this.zzf) {
        }
        this.zzE++;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzs() {
        this.zzE--;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzt() {
        zzbhp zzbhpVar = this.zzd;
        if (zzbhpVar != null) {
            zzbhpVar.zzc(10005);
        }
        this.zzD = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzu();
        this.zza.destroy();
    }

    public final void zzu() {
        if (this.zzi != null && ((this.zzC && this.zzE <= 0) || this.zzD || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue()) {
                zzcku zzckuVar = this.zza;
                if (zzckuVar.zzq() != null) {
                    zzbix.zza(zzckuVar.zzq().zzc(), zzckuVar.zzi(), "awfllc");
                }
            }
            zzcmq zzcmqVar = this.zzi;
            boolean z2 = false;
            if (!this.zzD && !this.zzo) {
                z2 = true;
            }
            zzcmqVar.zza(z2, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zza.zzap();
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z2, boolean z3, String str) {
        boolean z4;
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean z5 = false;
        boolean z6 = zzaj(zZzW, zzckuVar) || z3;
        if (z6 || !z2) {
            z4 = zZzW;
            z5 = true;
        } else {
            z4 = zZzW;
        }
        zzA(new AdOverlayInfoParcel(zzcVar, z6 ? null : this.zzg, z4 ? null : this.zzh, this.zzw, zzckuVar.zzs(), zzckuVar, z5 ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i3) {
        zzekr zzekrVar = this.zzH;
        zzcku zzckuVar = this.zza;
        zzA(new AdOverlayInfoParcel(zzckuVar, zzckuVar.zzs(), str, str2, 14, zzekrVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbyu] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final void zzx(boolean z2, int i3, boolean z3) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzdky zzdkyVar;
        ?? r9;
        int i4;
        com.google.android.gms.ads.internal.client.zza zzaVar2;
        boolean z4;
        zzcku zzckuVar = this.zza;
        boolean zZzaj = zzaj(zzckuVar.zzW(), zzckuVar);
        boolean z5 = true;
        if (!zZzaj && z3) {
            z5 = false;
        }
        if (zZzaj) {
            zzaVar = null;
            zzdkyVar = null;
        } else {
            zzaVar = this.zzg;
            zzdkyVar = null;
        }
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzh;
        zzdky zzdkyVar2 = zzdkyVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzckuVar.zzs();
        zzdky zzdkyVar3 = z5 ? zzdkyVar2 : this.zzm;
        if (zzai(zzckuVar)) {
            r9 = this.zzH;
            z4 = z2;
            i4 = i3;
            zzaVar2 = zzaVar;
        } else {
            r9 = zzdkyVar2;
            i4 = i3;
            zzaVar2 = zzaVar;
            z4 = z2;
        }
        zzA(new AdOverlayInfoParcel(zzaVar2, zzrVar, zzadVar, zzckuVar, z4, i4, versionInfoParcelZzs, zzdkyVar3, r9));
    }

    public final void zzy(boolean z2, int i3, String str, boolean z3, boolean z4) {
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean zZzaj = zzaj(zZzW, zzckuVar);
        boolean z5 = true;
        if (!zZzaj && z3) {
            z5 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzaj ? null : this.zzg;
        zzcle zzcleVar = zZzW ? null : new zzcle(zzckuVar, this.zzh);
        zzbog zzbogVar = this.zzk;
        zzekr zzekrVar = null;
        zzboi zzboiVar = this.zzl;
        boolean z6 = z5;
        zzcle zzcleVar2 = zzcleVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzckuVar.zzs();
        zzdky zzdkyVar = z6 ? null : this.zzm;
        if (zzai(zzckuVar)) {
            zzekrVar = this.zzH;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzcleVar2, zzbogVar, zzboiVar, zzadVar, zzckuVar, z2, i3, str, versionInfoParcelZzs, zzdkyVar, zzekrVar, z4));
    }

    public final void zzz(boolean z2, int i3, String str, String str2, boolean z3) {
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean zZzaj = zzaj(zZzW, zzckuVar);
        boolean z4 = true;
        if (!zZzaj && z3) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzaj ? null : this.zzg;
        zzcle zzcleVar = zZzW ? null : new zzcle(zzckuVar, this.zzh);
        zzbog zzbogVar = this.zzk;
        zzekr zzekrVar = null;
        zzboi zzboiVar = this.zzl;
        boolean z5 = z4;
        zzcle zzcleVar2 = zzcleVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzckuVar.zzs();
        zzdky zzdkyVar = z5 ? null : this.zzm;
        if (zzai(zzckuVar)) {
            zzekrVar = this.zzH;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzcleVar2, zzbogVar, zzboiVar, zzadVar, zzckuVar, z2, i3, str, str2, versionInfoParcelZzs, zzdkyVar, zzekrVar));
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.k(MrGIhy.bopucHFmY.concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzQ(uri);
        }
    }

    public zzclf(zzcku zzckuVar, zzbhp zzbhpVar, boolean z2, zzbyf zzbyfVar, zzbya zzbyaVar, zzekr zzekrVar) {
        this.zzd = zzbhpVar;
        this.zza = zzckuVar;
        this.zzs = z2;
        this.zzx = zzbyfVar;
        this.zzH = zzekrVar;
    }
}
