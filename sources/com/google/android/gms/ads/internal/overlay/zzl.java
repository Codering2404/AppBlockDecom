package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzl extends com.google.android.gms.ads.internal.util.zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzm f70097a;

    /* synthetic */ zzl(zzm zzmVar, byte[] bArr) {
        Objects.requireNonNull(zzmVar);
        this.f70097a = zzmVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        final BitmapDrawable bitmapDrawable;
        zzm zzmVar = this.f70097a;
        Bitmap bitmapA = com.google.android.gms.ads.internal.zzt.C().a(Integer.valueOf(zzmVar.f70100b.f70055p.f70427g));
        if (bitmapA != null) {
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.zzl zzlVar = zzmVar.f70100b.f70055p;
            boolean z2 = zzlVar.f70425d;
            float f3 = zzlVar.f70426f;
            Activity activity = zzmVar.f70099a;
            if (!z2 || f3 <= 0.0f || f3 > 25.0f) {
                bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmapA);
            } else {
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, bitmapA.getWidth(), bitmapA.getHeight(), false);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                    RenderScript renderScriptCreate = RenderScript.create(activity);
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                    Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                    scriptIntrinsicBlurCreate.setRadius(f3);
                    scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                    scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                    allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmapCreateBitmap);
                } catch (RuntimeException unused) {
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmapA);
                }
            }
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f70095a.f70097a.f70099a.getWindow().setBackgroundDrawable(bitmapDrawable);
                }
            });
        }
    }
}
