package ru.noties.markwon.image;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f147368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f147369b;

    public ImageItem(String str, InputStream inputStream) {
        this.f147368a = str;
        this.f147369b = inputStream;
    }

    public String a() {
        return this.f147368a;
    }

    public InputStream b() {
        return this.f147369b;
    }
}
