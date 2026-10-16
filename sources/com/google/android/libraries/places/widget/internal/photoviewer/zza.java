package com.google.android.libraries.places.widget.internal.photoviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zza extends BitmapTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f79094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f79095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f79096d;

    public zza(Context ctx, float f3, float f4) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.f79094b = 25.0f;
        this.f79095c = 0.125f;
        Context applicationContext = ctx.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f79096d = applicationContext;
        double d3 = 25.0f;
        if (d3 < 0.0d || d3 > 25.0d) {
            throw new IllegalArgumentException("Blur radius must be between 0 and 25!");
        }
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        byte[] bytes = "blurred".getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        messageDigest.update((byte) (this.f79094b * 10.0f));
        messageDigest.update((byte) (this.f79095c * 10.0f));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap c(BitmapPool pool, Bitmap toTransform, int i3, int i4) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        float width = toTransform.getWidth();
        float f3 = this.f79095c;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(toTransform, Math.round(width * f3), Math.round(toTransform.getHeight() * f3), false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        RenderScript renderScriptCreate = RenderScript.create(this.f79096d);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
        try {
            scriptIntrinsicBlurCreate.setRadius(this.f79094b);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        } finally {
            bitmapCreateScaledBitmap.recycle();
            allocationCreateFromBitmap.destroy();
            allocationCreateFromBitmap2.destroy();
            scriptIntrinsicBlurCreate.destroy();
            renderScriptCreate.destroy();
        }
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zza)) {
            return false;
        }
        zza zzaVar = (zza) obj;
        if (Float.valueOf(this.f79094b).equals(Float.valueOf(zzaVar.f79094b))) {
            if (Float.valueOf(this.f79095c).equals(Float.valueOf(zzaVar.f79095c))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Objects.hash("com.google.android.libraries.places.widget.internal.photoviewer.BlurTransformation", Float.valueOf(this.f79094b), Float.valueOf(this.f79095c));
    }
}
