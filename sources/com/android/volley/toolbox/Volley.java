package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Volley {
    public static RequestQueue a(Context context) {
        return c(context, null);
    }

    private static RequestQueue b(Context context, Network network) {
        final Context applicationContext = context.getApplicationContext();
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(new DiskBasedCache.FileSupplier() { // from class: com.android.volley.toolbox.Volley.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private File f57856a = null;

            @Override // com.android.volley.toolbox.DiskBasedCache.FileSupplier
            public File get() {
                if (this.f57856a == null) {
                    this.f57856a = new File(applicationContext.getCacheDir(), "volley");
                }
                return this.f57856a;
            }
        }), network);
        requestQueue.i();
        return requestQueue;
    }

    public static RequestQueue c(Context context, BaseHttpStack baseHttpStack) {
        return b(context, baseHttpStack == null ? new BasicNetwork(new HurlStack()) : new BasicNetwork(baseHttpStack));
    }
}
