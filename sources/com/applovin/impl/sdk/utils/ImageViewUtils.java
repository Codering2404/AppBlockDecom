package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageViewUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final j jVar, String str, final ImageView imageView, Uri uri) {
        if (!((Boolean) jVar.a(sj.f63809z)).booleanValue()) {
            InputStream inputStreamOpenStream = null;
            try {
                inputStreamOpenStream = new URL(str).openStream();
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.b(jVar, bitmapDecodeStream, imageView);
                    }
                });
                return;
            } catch (Throwable th) {
                try {
                    jVar.I();
                    if (n.a()) {
                        jVar.I().a("ImageViewUtils", "Failed to fetch image: " + uri, th);
                    }
                    return;
                } finally {
                    yp.a(inputStreamOpenStream, jVar);
                }
            }
        }
        try {
            InputStream inputStreamOpenStream2 = new URL(str).openStream();
            try {
                final Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStreamOpenStream2);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.a(jVar, bitmapDecodeStream2, imageView);
                    }
                });
                if (inputStreamOpenStream2 != null) {
                    inputStreamOpenStream2.close();
                }
            } finally {
            }
        } catch (Throwable th2) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("ImageViewUtils", "Failed to fetch image: " + uri, th2);
            }
            jVar.I().a("ImageViewUtils", th2);
            jVar.D().a("ImageViewUtils", "setImageUri", th2);
        }
    }

    public static void setAndDownscaleBitmap(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        j jVar = j.f63329u0;
        if (jVar == null) {
            n.h("ImageViewUtils", "SDK has not been initialized");
        } else {
            jVar.i0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.a(uri, imageView);
                }
            });
        }
    }

    public static void setAndDownscaleImageUri(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (imageView.getHeight() <= 0 || imageView.getWidth() <= 0) {
            imageView.post(new Runnable() { // from class: com.applovin.impl.sdk.utils.e
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.setAndDownscaleBitmap(imageView, uri);
                }
            });
        } else {
            setAndDownscaleBitmap(imageView, uri);
        }
    }

    public static void setImageUri(final ImageView imageView, final Uri uri, final j jVar) {
        if (imageView == null || uri == null) {
            return;
        }
        final String string = uri.toString();
        if (URLUtil.isFileUrl(string) || URLUtil.isContentUrl(string)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.g
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.b(imageView, uri);
                }
            });
            return;
        }
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().a("ImageViewUtils", "Fetching image: " + uri);
        }
        jVar.i0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                ImageViewUtils.a(jVar, string, imageView, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView, Uri uri) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        imageView.setImageURI(uri);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(j jVar, Bitmap bitmap, ImageView imageView) {
        jVar.I();
        if (n.a()) {
            jVar.I().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(j.m().getResources(), bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(j jVar, Bitmap bitmap, ImageView imageView) {
        jVar.I();
        if (n.a()) {
            jVar.I().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(j.m().getResources(), bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, final ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point pointB = z3.b(imageView.getContext());
            height = Math.min(pointB.x, pointB.y);
            width = height;
        }
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > height || i5 > width) {
            while (true) {
                int i6 = i3 * 2;
                if (i4 / i6 < height && i5 / i6 < width) {
                    break;
                } else {
                    i3 = i6;
                }
            }
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        j.f63329u0.I();
        if (n.a()) {
            j.f63329u0.I().a("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapDecodeFile);
            }
        });
    }
}
