package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import com.google.android.gms.common.internal.Asserts;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zag f71936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImageManager f71937b;

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.a("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f71937b.f71921e.get(this.f71936a);
        if (imageReceiver != null) {
            ImageManager imageManager = this.f71937b;
            imageManager.f71921e.remove(this.f71936a);
            imageReceiver.d(this.f71936a);
        }
        zag zagVar = this.f71936a;
        zad zadVar = zagVar.f71945a;
        Uri uri = zadVar.f71942a;
        if (uri == null) {
            ImageManager imageManager2 = this.f71937b;
            zagVar.b(imageManager2.f71917a, imageManager2.f71920d, true);
            return;
        }
        Long l3 = (Long) this.f71937b.f71923g.get(uri);
        if (l3 != null) {
            if (SystemClock.elapsedRealtime() - l3.longValue() < 3600000) {
                zag zagVar2 = this.f71936a;
                ImageManager imageManager3 = this.f71937b;
                zagVar2.b(imageManager3.f71917a, imageManager3.f71920d, true);
                return;
            } else {
                ImageManager imageManager4 = this.f71937b;
                imageManager4.f71923g.remove(zadVar.f71942a);
            }
        }
        this.f71936a.a(null, false, true, false);
        ImageManager imageManager5 = this.f71937b;
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager5.f71922f.get(zadVar.f71942a);
        if (imageReceiver2 == null) {
            ImageManager.ImageReceiver imageReceiver3 = this.f71937b.new ImageReceiver(zadVar.f71942a);
            ImageManager imageManager6 = this.f71937b;
            imageManager6.f71922f.put(zadVar.f71942a, imageReceiver3);
            imageReceiver2 = imageReceiver3;
        }
        imageReceiver2.c(this.f71936a);
        zag zagVar3 = this.f71936a;
        if (!(zagVar3 instanceof zaf)) {
            this.f71937b.f71921e.put(zagVar3, imageReceiver2);
        }
        synchronized (ImageManager.f71915h) {
            try {
                if (!ImageManager.f71916i.contains(zadVar.f71942a)) {
                    ImageManager.f71916i.add(zadVar.f71942a);
                    imageReceiver2.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
