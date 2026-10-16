package ru.noties.markwon.urlprocessor;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class UrlProcessorAndroidAssets implements UrlProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UrlProcessorRelativeToAbsolute f147394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UrlProcessor f147395b;

    @Override // ru.noties.markwon.urlprocessor.UrlProcessor
    public String a(String str) {
        if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
            return this.f147394a.a(str).replace("https://android.asset/", "file:///android_asset/");
        }
        UrlProcessor urlProcessor = this.f147395b;
        return urlProcessor != null ? urlProcessor.a(str) : str;
    }
}
