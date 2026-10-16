package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaf extends zag {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f71944c;

    @Override // com.google.android.gms.common.images.zag
    protected final void a(Drawable drawable, boolean z2, boolean z3, boolean z4) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (z3 || (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f71944c.get()) == null) {
            return;
        }
        onImageLoadedListener.a(this.f71945a.f71942a, drawable, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zaf)) {
            return false;
        }
        zaf zafVar = (zaf) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f71944c.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zafVar.f71944c.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.b(onImageLoadedListener2, onImageLoadedListener) && Objects.b(zafVar.f71945a, this.f71945a);
    }

    public final int hashCode() {
        return Objects.c(this.f71945a);
    }
}
