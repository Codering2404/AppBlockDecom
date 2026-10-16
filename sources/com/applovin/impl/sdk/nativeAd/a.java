package com.applovin.impl.sdk.nativeAd;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.n;
import com.applovin.impl.u2;
import com.applovin.impl.yl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u2 f63446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdImpl f63447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final InterfaceC0124a f63448j;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.nativeAd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InterfaceC0124a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, com.applovin.impl.sdk.j jVar, InterfaceC0124a interfaceC0124a) {
        super("TaskCacheNativeAd", jVar);
        this.f63446h = new u2();
        this.f63447i = appLovinNativeAdImpl;
        this.f63448j = interfaceC0124a;
    }

    private float a(Uri uri) {
        FileInputStream fileInputStream;
        int i3;
        int i4;
        File file = new File(uri.getPath());
        if (!file.exists()) {
            return -1.0f;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, null, options);
                i3 = options.outWidth;
                i4 = options.outHeight;
            } finally {
            }
        } catch (IOException e3) {
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Failed to calculate aspect ratio", e3);
            }
        }
        if (i3 <= 0 || i4 <= 0) {
            fileInputStream.close();
            return -1.0f;
        }
        float f3 = i3 / i4;
        fileInputStream.close();
        return f3;
    }

    private Uri b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Attempting to cache resource: " + uri);
        }
        String strA = this.f65231a.A().a(a(), uri.toString(), this.f63447i.getCachePrefix(), Collections.EMPTY_LIST, false, false, this.f63446h, 1);
        if (TextUtils.isEmpty(strA)) {
            if (n.a()) {
                this.f65233c.b(this.f65232b, "Unable to cache resource for uri: " + uri);
            }
            return null;
        }
        File fileA = this.f65231a.A().a(strA, a());
        if (fileA != null) {
            Uri uriFromFile = Uri.fromFile(fileA);
            if (uriFromFile != null) {
                return uriFromFile;
            }
            if (n.a()) {
                this.f65233c.b(this.f65232b, "Unable to extract Uri from image file");
            }
            return null;
        }
        if (n.a()) {
            this.f65233c.b(this.f65232b, "Unable to retrieve File from cached image filename = " + strA);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Begin caching ad #" + this.f63447i.getAdIdNumber() + "...");
        }
        Uri uriB = b(this.f63447i.getIconUri());
        if (uriB != null) {
            this.f63447i.setIconUri(uriB);
        }
        Uri uriB2 = b(this.f63447i.getMainImageUri());
        if (uriB2 != null) {
            this.f63447i.setMainImageUri(uriB2);
            float fA = a(uriB2);
            if (fA > 0.0f) {
                this.f63447i.setMainImageAspectRatio(fA);
            }
        }
        Uri uriB3 = b(this.f63447i.getPrivacyIconUri());
        if (uriB3 != null) {
            this.f63447i.setPrivacyIconUri(uriB3);
        }
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Finished caching ad #" + this.f63447i.getAdIdNumber());
        }
        this.f63448j.a(this.f63447i);
    }
}
