package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcif extends zzcgt implements TextureView.SurfaceTextureListener, zzchd {
    private final zzchn zzc;
    private final zzcho zzd;
    private final zzchm zze;
    private final zzdzl zzf;
    private zzcgs zzg;
    private Surface zzh;
    private zzche zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm;
    private zzchl zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcif(Context context, zzcho zzchoVar, zzchn zzchnVar, boolean z2, boolean z3, zzchm zzchmVar, zzdzl zzdzlVar) {
        super(context);
        this.zzm = 1;
        this.zzc = zzchnVar;
        this.zzd = zzchoVar;
        this.zzo = z2;
        this.zze = zzchmVar;
        zzchoVar.zza(this);
        this.zzf = zzdzlVar;
    }

    private final boolean zzT() {
        zzche zzcheVar = this.zzi;
        return (zzcheVar == null || !zzcheVar.zzB() || this.zzl) ? false : true;
    }

    private final boolean zzU() {
        return zzT() && this.zzm != 1;
    }

    private final void zzV(boolean z2, Integer num) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null && !z2) {
            zzcheVar.zzn(num);
            return;
        }
        if (this.zzj == null || this.zzh == null) {
            return;
        }
        if (z2) {
            if (!zzT()) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcheVar.zzw();
                zzW();
            }
        }
        if (this.zzj.startsWith("cache:")) {
            zzcja zzcjaVarZzr = this.zzc.zzr(this.zzj);
            if (zzcjaVarZzr instanceof zzcjj) {
                zzche zzcheVarZza = ((zzcjj) zzcjaVarZzr).zza();
                this.zzi = zzcheVarZza;
                zzcheVarZza.zzn(num);
                if (!this.zzi.zzB()) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzcjaVarZzr instanceof zzcjg)) {
                    String strValueOf = String.valueOf(this.zzj);
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Stream cache miss: ".concat(strValueOf));
                    return;
                }
                zzcjg zzcjgVar = (zzcjg) zzcjaVarZzr;
                String strZzF = zzF();
                ByteBuffer byteBufferZzu = zzcjgVar.zzu();
                boolean zZzt = zzcjgVar.zzt();
                String strZzs = zzcjgVar.zzs();
                if (strZzs == null) {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Stream cache URL is null.");
                    return;
                } else {
                    zzche zzcheVarZzE = zzE(num);
                    this.zzi = zzcheVarZzE;
                    zzcheVarZzE.zzr(new Uri[]{Uri.parse(strZzs)}, strZzF, byteBufferZzu, zZzt);
                }
            }
        } else {
            this.zzi = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzk.length];
            int i7 = 0;
            while (true) {
                String[] strArr = this.zzk;
                if (i7 >= strArr.length) {
                    break;
                }
                uriArr[i7] = Uri.parse(strArr[i7]);
                i7++;
            }
            this.zzi.zzq(uriArr, strZzF2);
        }
        this.zzi.zzs(this);
        zzX(this.zzh, false);
        if (this.zzi.zzB()) {
            int iZzC = this.zzi.zzC();
            this.zzm = iZzC;
            if (iZzC == 3) {
                zzY();
            }
        }
    }

    private final void zzW() {
        if (this.zzi != null) {
            zzX(null, true);
            zzche zzcheVar = this.zzi;
            if (zzcheVar != null) {
                zzcheVar.zzs(null);
                this.zzi.zzt();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzX(Surface surface, boolean z2) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcheVar.zzu(surface, z2);
        } catch (IOException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
        }
    }

    private final void zzY() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
        zzq();
        this.zzd.zzb();
        if (this.zzq) {
            zze();
        }
    }

    private static String zzZ(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(message);
        return sb.toString();
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i3, int i4) {
        float f3 = i4 > 0 ? i3 / i4 : 1.0f;
        if (this.zzt != f3) {
            this.zzt = f3;
            requestLayout();
        }
    }

    private final void zzac() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzM(true);
        }
    }

    private final void zzad() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzM(false);
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    protected final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = this.zzt;
        if (f3 != 0.0f && this.zzn == null) {
            float f4 = measuredWidth;
            float f5 = f4 / measuredHeight;
            if (f3 > f5) {
                measuredHeight = (int) (f4 / f3);
            }
            if (f3 < f5) {
                measuredWidth = (int) (measuredHeight * f3);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzchl zzchlVar = this.zzn;
        if (zzchlVar != null) {
            zzchlVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
        zzdzl zzdzlVar;
        if (this.zzo) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoL)).booleanValue() && (zzdzlVar = this.zzf) != null) {
                zzdzk zzdzkVarZza = zzdzlVar.zza();
                zzdzkVarZza.zzc("action", "svp_aepv");
                zzdzkVarZza.zzd();
            }
            zzchl zzchlVar = new zzchl(getContext());
            this.zzn = zzchlVar;
            zzchlVar.zzb(surfaceTexture, i3, i4);
            zzchl zzchlVar2 = this.zzn;
            zzchlVar2.start();
            SurfaceTexture surfaceTextureZze = zzchlVar2.zze();
            if (surfaceTextureZze != null) {
                surfaceTexture = surfaceTextureZze;
            } else {
                this.zzn.zzd();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzV(false, null);
        } else {
            zzX(surface, true);
            if (!this.zze.zza) {
                zzac();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i3, i4);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzf();
        zzchl zzchlVar = this.zzn;
        if (zzchlVar != null) {
            zzchlVar.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzad();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzX(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcib
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i3, final int i4) {
        zzchl zzchlVar = this.zzn;
        if (zzchlVar != null) {
            zzchlVar.zzc(i3, i4);
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcia
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzN(i3, i4);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 46);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcic
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzP(i3);
            }
        });
        super.onWindowVisibilityChanged(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzA(int i3) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzy(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzB(int i3) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzz(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzC(int i3) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzA(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzD() {
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS();
            }
        });
    }

    final zzche zzE(Integer num) {
        zzchm zzchmVar = this.zze;
        zzchn zzchnVar = this.zzc;
        zzckc zzckcVar = new zzckc(zzchnVar.getContext(), zzchmVar, zzchnVar, num);
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("ExoPlayerAdapter initialized.");
        return zzckcVar;
    }

    final String zzF() {
        zzchn zzchnVar = this.zzc;
        return com.google.android.gms.ads.internal.zzt.g().P(zzchnVar.getContext(), zzchnVar.zzs().f70149a);
    }

    final /* synthetic */ void zzG() {
        float fZzc = this.zzb.zzc();
        zzche zzcheVar = this.zzi;
        if (zzcheVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcheVar.zzv(fZzc, false);
        } catch (IOException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
        }
    }

    final /* synthetic */ void zzH() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzb();
        }
    }

    final /* synthetic */ void zzI() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zze();
        }
    }

    final /* synthetic */ void zzJ(String str) {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzf("ExoPlayerAdapter error", str);
        }
    }

    final /* synthetic */ void zzK() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzc();
        }
    }

    final /* synthetic */ void zzL() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzd();
        }
    }

    final /* synthetic */ void zzM() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zza();
        }
    }

    final /* synthetic */ void zzN(int i3, int i4) {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzj(i3, i4);
        }
    }

    final /* synthetic */ void zzO() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzh();
        }
    }

    final /* synthetic */ void zzP(int i3) {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.onWindowVisibilityChanged(i3);
        }
    }

    final /* synthetic */ void zzQ(boolean z2, long j3) {
        this.zzc.zzu(z2, j3);
    }

    final /* synthetic */ void zzR(String str) {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzg("ExoPlayerAdapter exception", str);
        }
    }

    final /* synthetic */ void zzS() {
        zzcgs zzcgsVar = this.zzg;
        if (zzcgsVar != null) {
            zzcgsVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final String zza() {
        return "ExoPlayer/2".concat(true != this.zzo ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzb(zzcgs zzcgsVar) {
        this.zzg = zzcgsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzc(String str) {
        if (str != null) {
            zzx(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzd() {
        if (zzT()) {
            this.zzi.zzw();
            zzW();
        }
        zzcho zzchoVar = this.zzd;
        zzchoVar.zzf();
        this.zzb.zze();
        zzchoVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zze() {
        if (!zzU()) {
            this.zzq = true;
            return;
        }
        if (this.zze.zza) {
            zzac();
        }
        this.zzi.zzE(true);
        this.zzd.zze();
        this.zzb.zzd();
        this.zza.zza();
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzK();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzf() {
        if (zzU()) {
            if (this.zze.zza) {
                zzad();
            }
            this.zzi.zzE(false);
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzL();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzg() {
        if (zzU()) {
            return (int) this.zzi.zzH();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzh() {
        if (zzU()) {
            return (int) this.zzi.zzD();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzi(int i3) {
        if (zzU()) {
            this.zzi.zzx(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzj(float f3, float f4) {
        zzchl zzchlVar = this.zzn;
        if (zzchlVar != null) {
            zzchlVar.zzf(f3, f4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzk() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzm() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            return zzcheVar.zzI();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzn() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            return zzcheVar.zzJ();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzo() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            return zzcheVar.zzK();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzp() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            return zzcheVar.zzL();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt, com.google.android.gms.internal.ads.zzchq
    public final void zzq() {
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcie
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzr(final boolean z2, final long j3) {
        if (this.zzc != null) {
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzQ(z2, j3);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzs(int i3) {
        if (this.zzm != i3) {
            this.zzm = i3;
            if (i3 == 3) {
                zzY();
                return;
            }
            if (i3 != 4) {
                return;
            }
            if (this.zze.zza) {
                zzad();
            }
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzI();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzt(int i3, int i4) {
        this.zzr = i3;
        this.zzs = i4;
        zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzu(String str, Exception exc) {
        final String strZzZ = zzZ(str, exc);
        String strConcat = "ExoPlayerAdapter error: ".concat(strZzZ);
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        this.zzl = true;
        if (this.zze.zza) {
            zzad();
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzJ(strZzZ);
            }
        });
        com.google.android.gms.ads.internal.zzt.l().zzh(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzv(String str, Exception exc) {
        final String strZzZ = zzZ("onLoadException", exc);
        String strConcat = "ExoPlayerAdapter exception: ".concat(strZzZ);
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        com.google.android.gms.ads.internal.zzt.l().zzh(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcht
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzR(strZzZ);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final Integer zzw() {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            return zzcheVar.zzj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzx(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzk = new String[]{str};
        } else {
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzj;
        boolean z2 = false;
        if (this.zze.zzk && str2 != null && !str.equals(str2) && this.zzm == 4) {
            z2 = true;
        }
        this.zzj = str;
        zzV(z2, num);
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzy(int i3) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzF(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzz(int i3) {
        zzche zzcheVar = this.zzi;
        if (zzcheVar != null) {
            zzcheVar.zzG(i3);
        }
    }
}
