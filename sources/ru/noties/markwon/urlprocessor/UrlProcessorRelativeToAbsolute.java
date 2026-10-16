package ru.noties.markwon.urlprocessor;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class UrlProcessorRelativeToAbsolute implements UrlProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f147396a;

    @Override // ru.noties.markwon.urlprocessor.UrlProcessor
    public String a(String str) {
        if (this.f147396a != null) {
            try {
                return new URL(this.f147396a, str).toString();
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }
}
