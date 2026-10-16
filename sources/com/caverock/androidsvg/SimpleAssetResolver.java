package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleAssetResolver extends SVGExternalFileResolver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f67799b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AssetManager f67800a;

    static {
        HashSet hashSet = new HashSet(8);
        f67799b = hashSet;
        hashSet.add("image/svg+xml");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/pjpeg");
        hashSet.add("image/gif");
        hashSet.add("image/bmp");
        hashSet.add("image/x-windows-bmp");
        hashSet.add("image/webp");
    }

    private String e(String str) throws Throwable {
        Throwable th;
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = this.f67800a.open(str);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, Charset.forName(Utf8Charset.NAME));
                char[] cArr = new char[4096];
                StringBuilder sb = new StringBuilder();
                for (int i3 = inputStreamReader.read(cArr); i3 > 0; i3 = inputStreamReader.read(cArr)) {
                    sb.append(cArr, 0, i3);
                }
                String string = sb.toString();
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                    }
                }
                return string;
            } catch (IOException unused2) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpen = null;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public boolean a(String str) {
        return f67799b.contains(str);
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public String b(String str) {
        Log.i("SimpleAssetResolver", "resolveCSSStyleSheet(" + str + ")");
        return e(str);
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Typeface c(String str, int i3, String str2) {
        Log.i("SimpleAssetResolver", "resolveFont(" + str + "," + i3 + "," + str2 + ")");
        try {
            try {
                return Typeface.createFromAsset(this.f67800a, str + ".ttf");
            } catch (RuntimeException unused) {
                return Typeface.createFromAsset(this.f67800a, str + ".otf");
            }
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Bitmap d(String str) {
        Log.i("SimpleAssetResolver", "resolveImage(" + str + ")");
        try {
            return BitmapFactory.decodeStream(this.f67800a.open(str));
        } catch (IOException unused) {
            return null;
        }
    }
}
