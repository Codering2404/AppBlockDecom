package com.applovin.impl;

import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinExtras;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f59193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59194b;

    public da(Map map, com.applovin.impl.sdk.j jVar) {
        this.f59193a = map == null ? Collections.EMPTY_MAP : map;
        this.f59194b = jVar;
    }

    public Drawable a() {
        Object obj = this.f59193a.get(AppLovinExtras.Keys.KEY_WATERMARK);
        if (!a(obj)) {
            this.f59194b.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f59194b.I().b("GoogleWatermarkGenerator", "Unable to render invalid watermark: " + obj);
            }
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode((String) obj, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.applovin.impl.sdk.j.m().getResources(), BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            return bitmapDrawable;
        } catch (Throwable th) {
            this.f59194b.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f59194b.I().a("GoogleWatermarkGenerator", "Failed to render watermark", th);
            }
            return null;
        }
    }

    public String b() {
        return "google watermark";
    }

    public boolean c() {
        return a(this.f59193a.get(AppLovinExtras.Keys.KEY_WATERMARK));
    }

    private boolean a(Object obj) {
        return (obj instanceof String) && StringUtils.isValidString((String) obj);
    }
}
