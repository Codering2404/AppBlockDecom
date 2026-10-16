package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f71933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParcelFileDescriptor f71934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageManager f71935c;

    public zaa(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f71935c = imageManager;
        this.f71933a = uri;
        this.f71934b = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f71934b;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z2 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e3) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f71933a)), e3);
                z2 = true;
            }
            try {
                this.f71934b.close();
            } catch (IOException e4) {
                Log.e("ImageManager", "closed failed", e4);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f71935c;
        imageManager.f71918b.post(new zac(imageManager, this.f71933a, bitmapDecodeFileDescriptor, z2, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f71933a)));
        }
    }
}
