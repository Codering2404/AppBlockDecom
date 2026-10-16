package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f71915h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashSet f71916i = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f71918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f71919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zam f71920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f71921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f71922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f71923g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ImageReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f71924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f71925b;

        ImageReceiver(Uri uri) {
            super(new zau(Looper.getMainLooper()));
            this.f71924a = uri;
            this.f71925b = new ArrayList();
        }

        public final void c(zag zagVar) {
            Asserts.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f71925b.add(zagVar);
        }

        public final void d(zag zagVar) {
            Asserts.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f71925b.remove(zagVar);
        }

        public final void e() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("com.google.android.gms.extras.uri", this.f71924a);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.f71917a.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i3, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.f71919c.execute(new zaa(imageManager, this.f71924a, parcelFileDescriptor));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnImageLoadedListener {
        void a(Uri uri, Drawable drawable, boolean z2);
    }
}
