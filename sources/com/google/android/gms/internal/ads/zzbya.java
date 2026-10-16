package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbya extends zzbyg {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcku zzj;
    private final Activity zzk;
    private zzcne zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbyh zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.f("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbya(zzcku zzckuVar, zzbyh zzbyhVar) {
        super(zzckuVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzckuVar;
        this.zzk = zzckuVar.zzj();
        this.zzo = zzbyhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzf(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzml)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmm)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmn)).booleanValue()) {
                try {
                    ViewGroup viewGroup2 = this.zzr;
                    zzcku zzckuVar = this.zzj;
                    viewGroup2.addView((View) zzckuVar);
                    zzckuVar.zzaf(this.zzl);
                } catch (IllegalStateException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Unable to add webview back to view hierarchy.", e3);
                    com.google.android.gms.ads.internal.zzt.l().zzg(e3, "MraidCallResizeHandler.collapseInternal");
                }
            } else {
                ViewGroup viewGroup3 = this.zzr;
                zzcku zzckuVar2 = this.zzj;
                viewGroup3.addView((View) zzckuVar2);
                zzckuVar2.zzaf(this.zzl);
            }
        }
        if (z2) {
            zzk("default");
            zzbyh zzbyhVar = this.zzo;
            if (zzbyhVar != null) {
                zzbyhVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0246 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0120, B:63:0x012c, B:123:0x0246, B:124:0x024b, B:126:0x024d, B:128:0x026a, B:130:0x0276, B:132:0x02ad, B:138:0x031f, B:161:0x0376, B:162:0x038e, B:163:0x03ab, B:165:0x03b3, B:166:0x03ba, B:167:0x03e1, B:170:0x03e4, B:172:0x0412, B:173:0x0424, B:142:0x032e, B:146:0x033d, B:150:0x034c, B:154:0x035b, B:159:0x036c, B:160:0x0370, B:131:0x02aa, B:175:0x0426, B:176:0x042b, B:65:0x0136, B:67:0x013a, B:72:0x014d, B:98:0x01d8, B:100:0x01db, B:102:0x01df, B:76:0x0165, B:77:0x0170, B:82:0x0181, B:86:0x0194, B:90:0x01a4, B:91:0x01ac, B:95:0x01b8, B:96:0x01cb, B:106:0x01e8, B:107:0x01f7, B:113:0x021d, B:119:0x022d, B:116:0x0223, B:118:0x022b, B:110:0x0215, B:112:0x021b, B:120:0x0232, B:121:0x023b, B:178:0x042d, B:179:0x0432, B:181:0x0434, B:182:0x0439), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x024d A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0120, B:63:0x012c, B:123:0x0246, B:124:0x024b, B:126:0x024d, B:128:0x026a, B:130:0x0276, B:132:0x02ad, B:138:0x031f, B:161:0x0376, B:162:0x038e, B:163:0x03ab, B:165:0x03b3, B:166:0x03ba, B:167:0x03e1, B:170:0x03e4, B:172:0x0412, B:173:0x0424, B:142:0x032e, B:146:0x033d, B:150:0x034c, B:154:0x035b, B:159:0x036c, B:160:0x0370, B:131:0x02aa, B:175:0x0426, B:176:0x042b, B:65:0x0136, B:67:0x013a, B:72:0x014d, B:98:0x01d8, B:100:0x01db, B:102:0x01df, B:76:0x0165, B:77:0x0170, B:82:0x0181, B:86:0x0194, B:90:0x01a4, B:91:0x01ac, B:95:0x01b8, B:96:0x01cb, B:106:0x01e8, B:107:0x01f7, B:113:0x021d, B:119:0x022d, B:116:0x0223, B:118:0x022b, B:110:0x0215, B:112:0x021b, B:120:0x0232, B:121:0x023b, B:178:0x042d, B:179:0x0432, B:181:0x0434, B:182:0x0439), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0370 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0120, B:63:0x012c, B:123:0x0246, B:124:0x024b, B:126:0x024d, B:128:0x026a, B:130:0x0276, B:132:0x02ad, B:138:0x031f, B:161:0x0376, B:162:0x038e, B:163:0x03ab, B:165:0x03b3, B:166:0x03ba, B:167:0x03e1, B:170:0x03e4, B:172:0x0412, B:173:0x0424, B:142:0x032e, B:146:0x033d, B:150:0x034c, B:154:0x035b, B:159:0x036c, B:160:0x0370, B:131:0x02aa, B:175:0x0426, B:176:0x042b, B:65:0x0136, B:67:0x013a, B:72:0x014d, B:98:0x01d8, B:100:0x01db, B:102:0x01df, B:76:0x0165, B:77:0x0170, B:82:0x0181, B:86:0x0194, B:90:0x01a4, B:91:0x01ac, B:95:0x01b8, B:96:0x01cb, B:106:0x01e8, B:107:0x01f7, B:113:0x021d, B:119:0x022d, B:116:0x0223, B:118:0x022b, B:110:0x0215, B:112:0x021b, B:120:0x0232, B:121:0x023b, B:178:0x042d, B:179:0x0432, B:181:0x0434, B:182:0x0439), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cb A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0120, B:63:0x012c, B:123:0x0246, B:124:0x024b, B:126:0x024d, B:128:0x026a, B:130:0x0276, B:132:0x02ad, B:138:0x031f, B:161:0x0376, B:162:0x038e, B:163:0x03ab, B:165:0x03b3, B:166:0x03ba, B:167:0x03e1, B:170:0x03e4, B:172:0x0412, B:173:0x0424, B:142:0x032e, B:146:0x033d, B:150:0x034c, B:154:0x035b, B:159:0x036c, B:160:0x0370, B:131:0x02aa, B:175:0x0426, B:176:0x042b, B:65:0x0136, B:67:0x013a, B:72:0x014d, B:98:0x01d8, B:100:0x01db, B:102:0x01df, B:76:0x0165, B:77:0x0170, B:82:0x0181, B:86:0x0194, B:90:0x01a4, B:91:0x01ac, B:95:0x01b8, B:96:0x01cb, B:106:0x01e8, B:107:0x01f7, B:113:0x021d, B:119:0x022d, B:116:0x0223, B:118:0x022b, B:110:0x0215, B:112:0x021b, B:120:0x0232, B:121:0x023b, B:178:0x042d, B:179:0x0432, B:181:0x0434, B:182:0x0439), top: B:186:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.util.Map r18) {
        /*
            Method dump skipped, instruction units count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbya.zza(java.util.Map):void");
    }

    public final void zzb(final boolean z2) {
        synchronized (this.zzi) {
            try {
                if (this.zzp != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmk)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        zzf(z2);
                    } else {
                        zzcfr.zzf.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxz
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzf(z2);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(int i3, int i4, boolean z2) {
        synchronized (this.zzi) {
            this.zzc = i3;
            this.zzd = i4;
        }
    }

    public final boolean zzd() {
        boolean z2;
        synchronized (this.zzi) {
            z2 = this.zzp != null;
        }
        return z2;
    }

    public final void zze(int i3, int i4) {
        this.zzc = i3;
        this.zzd = i4;
    }
}
