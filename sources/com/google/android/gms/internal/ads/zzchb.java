package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzchb extends FrameLayout implements zzcgs {
    final zzchp zza;
    private final zzchn zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbjf zze;
    private final long zzf;
    private final zzcgt zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzchb(Context context, zzchn zzchnVar, int i3, boolean z2, zzbjf zzbjfVar, zzchm zzchmVar, zzdzl zzdzlVar) {
        zzcgt zzcgrVar;
        zzbjf zzbjfVar2;
        zzcgt zzckjVar;
        super(context);
        this.zzb = zzchnVar;
        this.zze = zzbjfVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.m(zzchnVar.zzk());
        zzcgu zzcguVar = zzchnVar.zzk().f70387a;
        zzcho zzchoVar = new zzcho(context, zzchnVar.zzs(), zzchnVar.zzm(), zzbjfVar, zzchnVar.zzi());
        if (i3 == 3) {
            zzckjVar = new zzckj(context, zzchoVar);
            zzbjfVar2 = zzbjfVar;
        } else {
            if (i3 == 2) {
                zzcgrVar = new zzcif(context, zzchoVar, zzchnVar, z2, zzcgu.zza(zzchnVar), zzchmVar, zzdzlVar);
                zzbjfVar2 = zzbjfVar;
            } else {
                zzbjfVar2 = zzbjfVar;
                zzcgrVar = new zzcgr(context, zzchnVar, z2, zzcgu.zza(zzchnVar), zzchmVar, new zzcho(context, zzchnVar.zzs(), zzchnVar.zzm(), zzbjfVar, zzchnVar.zzi()), zzdzlVar);
            }
            zzckjVar = zzcgrVar;
        }
        this.zzg = zzckjVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzckjVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzat)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaq)).booleanValue()) {
            zzD();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzav)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzas)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbjfVar2 != null) {
            zzbjfVar2.zzd("spinner_used", true != zBooleanValue ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        this.zza = new zzchp(this);
        zzckjVar.zzb(this);
    }

    private final boolean zzJ() {
        return this.zzq.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzK, reason: merged with bridge method [inline-methods] */
    public final void zzI(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zze("onVideoEvent", map);
    }

    private final void zzL() {
        zzchn zzchnVar = this.zzb;
        if (zzchnVar.zzj() == null || !this.zzi || this.zzj) {
            return;
        }
        zzchnVar.zzj().getWindow().clearFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        this.zzi = false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcgt zzcgtVar = this.zzg;
            if (zzcgtVar != null) {
                zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgy
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcgtVar.zzd();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcha
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG(z2);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcgs
    public final void onWindowVisibilityChanged(int i3) {
        boolean z2;
        super.onWindowVisibilityChanged(i3);
        if (i3 == 0) {
            this.zza.zzb();
            z2 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z2 = false;
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgx(this, z2));
    }

    public final void zzA(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzB(i3);
    }

    public final void zzB(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzC(i3);
    }

    public final void zzC(MotionEvent motionEvent) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzD() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        TextView textView = new TextView(zzcgtVar.getContext());
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        textView.setText(String.valueOf(resourcesZzf == null ? "AdMob - " : resourcesZzf.getString(R.string.f69766u)).concat(zzcgtVar.zza()));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        FrameLayout frameLayout = this.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.bringChildToFront(textView);
    }

    public final void zzE() {
        this.zza.zza();
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar != null) {
            zzcgtVar.zzd();
        }
        zzL();
    }

    final void zzF() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        long jZzh = zzcgtVar.zzh();
        if (this.zzl == jZzh || jZzh <= 0) {
            return;
        }
        float f3 = jZzh / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue()) {
            zzI("timeupdate", "time", String.valueOf(f3), "totalBytes", String.valueOf(zzcgtVar.zzo()), "qoeCachedBytes", String.valueOf(zzcgtVar.zzn()), "qoeLoadedBytes", String.valueOf(zzcgtVar.zzm()), "droppedFrames", String.valueOf(zzcgtVar.zzp()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()));
        } else {
            zzI("timeupdate", "time", String.valueOf(f3));
        }
        this.zzl = jZzh;
    }

    final /* synthetic */ void zzG(boolean z2) {
        zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(z2));
    }

    final /* synthetic */ void zzH() {
        zzI("firstFrameRendered", new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zza() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgv(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcD)).booleanValue()) {
            this.zza.zzb();
        }
        zzchn zzchnVar = this.zzb;
        if (zzchnVar.zzj() != null && !this.zzi) {
            boolean z2 = (zzchnVar.zzj().getWindow().getAttributes().flags & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
            this.zzj = z2;
            if (!z2) {
                zzchnVar.zzj().getWindow().addFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzd() {
        zzI("pause", new String[0]);
        zzL();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcD)).booleanValue()) {
            this.zza.zza();
        }
        zzI("ended", new String[0]);
        zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzf(String str, String str2) {
        zzI("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzg(String str, String str2) {
        zzI("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzh() {
        if (this.zzr && this.zzp != null && !zzJ()) {
            ImageView imageView = this.zzq;
            imageView.setImageBitmap(this.zzp);
            imageView.invalidate();
            FrameLayout frameLayout = this.zzc;
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(imageView);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzi() {
        if (this.zzh && zzJ()) {
            this.zzc.removeView(this.zzq);
        }
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null || this.zzp == null) {
            return;
        }
        long jA = com.google.android.gms.ads.internal.zzt.o().a();
        if (zzcgtVar.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jA2 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            StringBuilder sb = new StringBuilder(String.valueOf(jA2).length() + 26);
            sb.append("Spinner frame grab took ");
            sb.append(jA2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        if (jA2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbjf zzbjfVar = this.zze;
            if (zzbjfVar != null) {
                zzbjfVar.zzd("spinner_jank", Long.toString(jA2));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzj(int i3, int i4) {
        if (this.zzk) {
            zzbih zzbihVar = zzbiq.zzau;
            int iMax = Math.max(i3 / ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue(), 1);
            int iMax2 = Math.max(i4 / ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzk() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
    }

    public final Integer zzl() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar != null) {
            return zzcgtVar.zzw();
        }
        return null;
    }

    public final void zzm(int i3) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzat)).booleanValue()) {
            this.zzc.setBackgroundColor(i3);
            this.zzd.setBackgroundColor(i3);
        }
    }

    public final void zzn(int i3, int i4, int i5, int i6) {
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            int length = String.valueOf(i3).length();
            StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(i4).length() + 3 + String.valueOf(i5).length() + 3 + String.valueOf(i6).length());
            sb.append("Set video bounds to x:");
            sb.append(i3);
            sb.append(";y:");
            sb.append(i4);
            sb.append(";w:");
            sb.append(i5);
            sb.append(";h:");
            sb.append(i6);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        if (i5 == 0 || i6 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.setMargins(i3, i4, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzo(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzp(float f3, float f4) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar != null) {
            zzcgtVar.zzj(f3, f4);
        }
    }

    public final void zzq(Integer num) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzI("no_src", new String[0]);
        } else {
            zzcgtVar.zzx(this.zzn, this.zzo, num);
        }
    }

    public final void zzr() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzf();
    }

    public final void zzs() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zze();
    }

    public final void zzt(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzi(i3);
    }

    public final void zzu() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzb.zza(true);
        zzcgtVar.zzq();
    }

    public final void zzv() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzb.zza(false);
        zzcgtVar.zzq();
    }

    public final void zzw(float f3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzb.zzb(f3);
        zzcgtVar.zzq();
    }

    public final void zzx(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzy(i3);
    }

    public final void zzy(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzz(i3);
    }

    public final void zzz(int i3) {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar == null) {
            return;
        }
        zzcgtVar.zzA(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcgs
    public final void zzb() {
        zzcgt zzcgtVar = this.zzg;
        if (zzcgtVar != null && this.zzm == 0) {
            zzI("canplaythrough", KqqtdetwHMIO.UbKBEwHkfaoF, String.valueOf(zzcgtVar.zzg() / 1000.0f), "videoWidth", String.valueOf(zzcgtVar.zzk()), "videoHeight", String.valueOf(zzcgtVar.zzl()));
        }
    }
}
