package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FontAssetManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetManager f56669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FontAssetDelegate f56670e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutablePair f56666a = new MutablePair();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f56667b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f56668c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f56671f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.f56670e = fontAssetDelegate;
        if (callback instanceof View) {
            this.f56669d = ((View) callback).getContext().getAssets();
        } else {
            Logger.c("LottieDrawable must be inside of a view for images to work.");
            this.f56669d = null;
        }
    }

    private Typeface a(Font font) {
        Typeface typefaceCreateFromAsset;
        String strA = font.a();
        Typeface typeface = (Typeface) this.f56668c.get(strA);
        if (typeface != null) {
            return typeface;
        }
        String strC = font.c();
        String strB = font.b();
        FontAssetDelegate fontAssetDelegate = this.f56670e;
        if (fontAssetDelegate != null) {
            typefaceCreateFromAsset = fontAssetDelegate.b(strA, strC, strB);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.f56670e.a(strA);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        FontAssetDelegate fontAssetDelegate2 = this.f56670e;
        if (fontAssetDelegate2 != null && typefaceCreateFromAsset == null) {
            String strD = fontAssetDelegate2.d(strA, strC, strB);
            if (strD == null) {
                strD = this.f56670e.c(strA);
            }
            if (strD != null) {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.f56669d, strD);
            }
        }
        if (font.d() != null) {
            return font.d();
        }
        if (typefaceCreateFromAsset == null) {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.f56669d, "fonts/" + strA + this.f56671f);
        }
        this.f56668c.put(strA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i3 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i3 ? typeface : Typeface.create(typeface, i3);
    }

    public Typeface b(Font font) {
        this.f56666a.b(font.a(), font.c());
        Typeface typeface = (Typeface) this.f56667b.get(this.f56666a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(font), font.c());
        this.f56667b.put(this.f56666a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.f56671f = str;
    }

    public void d(FontAssetDelegate fontAssetDelegate) {
        this.f56670e = fontAssetDelegate;
    }
}
