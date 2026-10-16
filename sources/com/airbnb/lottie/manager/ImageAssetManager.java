package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageAssetManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f56672e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f56673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageAssetDelegate f56675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f56676d;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f56674b = str;
        } else {
            this.f56674b = str + '/';
        }
        this.f56676d = map;
        d(imageAssetDelegate);
        if (callback instanceof View) {
            this.f56673a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f56673a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f56672e) {
            ((LottieImageAsset) this.f56676d.get(str)).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        LottieImageAsset lottieImageAsset = (LottieImageAsset) this.f56676d.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmapA = lottieImageAsset.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        ImageAssetDelegate imageAssetDelegate = this.f56675c;
        if (imageAssetDelegate != null) {
            Bitmap bitmapA2 = imageAssetDelegate.a(lottieImageAsset);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        Context context = this.f56673a;
        if (context == null) {
            return null;
        }
        String strB = lottieImageAsset.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e3) {
                Logger.d("data URL did not have correct base64 format.", e3);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f56674b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f56674b + strB), null, options);
                if (bitmapDecodeStream != null) {
                    return c(str, Utils.k(bitmapDecodeStream, lottieImageAsset.e(), lottieImageAsset.c()));
                }
                Logger.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e4) {
                Logger.d("Unable to decode image `" + str + "`.", e4);
                return null;
            }
        } catch (IOException e5) {
            Logger.d("Unable to open asset.", e5);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f56673a == null) || this.f56673a.equals(context);
    }

    public void d(ImageAssetDelegate imageAssetDelegate) {
        this.f56675c = imageAssetDelegate;
    }
}
