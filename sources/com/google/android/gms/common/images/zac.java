package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zac implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f71938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap f71939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CountDownLatch f71940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageManager f71941d;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z2, CountDownLatch countDownLatch) {
        this.f71941d = imageManager;
        this.f71938a = uri;
        this.f71939b = bitmap;
        this.f71940c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.a("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f71941d.f71922f.remove(this.f71938a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.f71925b;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                zag zagVar = (zag) arrayList.get(i3);
                Bitmap bitmap = this.f71939b;
                if (bitmap != null) {
                    zagVar.c(this.f71941d.f71917a, bitmap, false);
                } else {
                    this.f71941d.f71923g.put(this.f71938a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f71941d;
                    zagVar.b(imageManager.f71917a, imageManager.f71920d, false);
                }
                if (!(zagVar instanceof zaf)) {
                    this.f71941d.f71921e.remove(zagVar);
                }
            }
        }
        this.f71940c.countDown();
        synchronized (ImageManager.f71915h) {
            ImageManager.f71916i.remove(this.f71938a);
        }
    }
}
