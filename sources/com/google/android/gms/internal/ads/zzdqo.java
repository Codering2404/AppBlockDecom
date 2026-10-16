package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqo extends zzbmh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdrq {
    public static final zzgwm zza = zzgwm.zzl("2011", "1009", "3010");
    private final String zzb;
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzhcg zzf;
    private View zzg;
    private zzdpo zzi;
    private zzbes zzj;
    private zzbmb zzl;
    private boolean zzm;
    private GestureDetector zzo;
    private Map zzc = new HashMap();
    private IObjectWrapper zzk = null;
    private boolean zzn = false;
    private final int zzh = ModuleDescriptor.MODULE_VERSION;

    public zzdqo(FrameLayout frameLayout, FrameLayout frameLayout2, int i3) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zza(frameLayout, this);
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zzb(frameLayout, this);
        this.zzf = zzcfr.zzf;
        this.zzj = new zzbes(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzs() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmY)).booleanValue() || this.zzi.zzG() == 0) {
            return;
        }
        this.zzo = new GestureDetector(this.zzd.getContext(), new zzdqw(this.zzi, this));
    }

    private final synchronized void zzt() {
        this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzr();
            }
        });
    }

    private final synchronized void zzu(String str) {
        DisplayMetrics displayMetrics;
        try {
            View frameLayout = new FrameLayout(this.zze.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.zze.getContext();
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            if (!TextUtils.isEmpty(str)) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    try {
                        byte[] bArrDecode = Base64.decode(str, 0);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        frameLayout.setBackground(bitmapDrawable);
                    } catch (IllegalArgumentException e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.g("Encountered invalid base64 watermark.", e3);
                    }
                }
            }
            this.zze.addView(frameLayout);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar == null || !zzdpoVar.zzH()) {
            return;
        }
        this.zzi.zzz();
        this.zzi.zzi(view, this.zzd, zzi(), zzj(), false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdpoVar.zzu(frameLayout, zzi(), zzj(), zzdpo.zzI(frameLayout));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdpoVar.zzu(frameLayout, zzi(), zzj(), zzdpo.zzI(frameLayout));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar != null) {
            zzdpoVar.zzk(view, motionEvent, this.zzd);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmY)).booleanValue() && this.zzo != null && this.zzi.zzG() != 0) {
                this.zzo.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zzh(str, (View) ObjectWrapper.h5(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized IObjectWrapper zzc(String str) {
        return ObjectWrapper.i5(zzl(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzd(IObjectWrapper iObjectWrapper) {
        if (this.zzn) {
            return;
        }
        Object objH5 = ObjectWrapper.h5(iObjectWrapper);
        if (!(objH5 instanceof zzdpo)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar != null) {
            zzdpoVar.zzh(this);
        }
        zzt();
        zzdpo zzdpoVar2 = (zzdpo) objH5;
        this.zzi = zzdpoVar2;
        zzdpoVar2.zzg(this);
        this.zzi.zzN(this.zzd);
        this.zzi.zzO(this.zze);
        if (this.zzm) {
            this.zzi.zzP().zzb(this.zzl);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeN)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzK())) {
            zzu(this.zzi.zzK());
        }
        zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final FrameLayout zzdA() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzdB(IObjectWrapper iObjectWrapper) {
        this.zzi.zzx((View) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzdC(IObjectWrapper iObjectWrapper) {
        if (this.zzn) {
            return;
        }
        this.zzk = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzdD(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzdE(zzbmb zzbmbVar) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbmbVar;
            zzdpo zzdpoVar = this.zzi;
            if (zzdpoVar != null) {
                zzdpoVar.zzP().zzb(zzbmbVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final /* synthetic */ View zzdF() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zze() {
        try {
            if (this.zzn) {
                return;
            }
            zzdpo zzdpoVar = this.zzi;
            if (zzdpoVar != null) {
                zzdpoVar.zzh(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final synchronized void zzf(IObjectWrapper iObjectWrapper, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final zzbes zzg() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized void zzh(String str, View view, boolean z2) {
        if (!this.zzn) {
            if (view == null) {
                this.zzc.remove(str);
                return;
            }
            this.zzc.put(str, new WeakReference(view));
            if (!"1098".equals(str) && !"3011".equals(str)) {
                if (com.google.android.gms.ads.internal.util.zzbs.a(this.zzh)) {
                    view.setOnTouchListener(this);
                }
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzi() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzj() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized Map zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized View zzl(String str) {
        WeakReference weakReference;
        if (!this.zzn && (weakReference = (WeakReference) this.zzc.get(str)) != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized String zzm() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final IObjectWrapper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized JSONObject zzo() {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar == null) {
            return null;
        }
        return zzdpoVar.zzv(this.zzd, zzi(), zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzdrq
    public final synchronized JSONObject zzp() {
        zzdpo zzdpoVar = this.zzi;
        if (zzdpoVar == null) {
            return null;
        }
        return zzdpoVar.zzw(this.zzd, zzi(), zzj());
    }

    public final FrameLayout zzq() {
        return this.zzd;
    }

    final /* synthetic */ void zzr() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
