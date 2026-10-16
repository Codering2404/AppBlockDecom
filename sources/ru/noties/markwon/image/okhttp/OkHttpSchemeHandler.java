package ru.noties.markwon.image.okhttp;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import ru.noties.markwon.image.ImageItem;
import ru.noties.markwon.image.SchemeHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpSchemeHandler extends SchemeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f147388a;

    OkHttpSchemeHandler(OkHttpClient okHttpClient) {
        this.f147388a = okHttpClient;
    }

    @Override // ru.noties.markwon.image.SchemeHandler
    public ImageItem a(String str, Uri uri) {
        Response responseD;
        ResponseBody responseBodyA;
        InputStream inputStreamA;
        try {
            responseD = this.f147388a.a(new Request.Builder().q(str).p(str).b()).d();
        } catch (IOException e3) {
            e3.printStackTrace();
            responseD = null;
        }
        if (responseD == null || (responseBodyA = responseD.a()) == null || (inputStreamA = responseBodyA.a()) == null) {
            return null;
        }
        return new ImageItem(responseD.l("Content-Type"), inputStreamA);
    }
}
