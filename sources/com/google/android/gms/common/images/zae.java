package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zae extends zag {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f71943c;

    @Override // com.google.android.gms.common.images.zag
    protected final void a(Drawable drawable, boolean z2, boolean z3, boolean z4) {
        ImageView imageView = (ImageView) this.f71943c.get();
        if (imageView != null) {
            if (!z3 && !z4 && (imageView instanceof zal)) {
                throw null;
            }
            boolean z5 = false;
            if (!z3 && !z2) {
                z5 = true;
            }
            if (z5) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zak) {
                    drawable2 = ((zak) drawable2).zaa();
                }
                drawable = new zak(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zal) {
                throw null;
            }
            if (drawable == null || !z5) {
                return;
            }
            ((zak) drawable).zab(250);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.f71943c.get();
        ImageView imageView2 = (ImageView) ((zae) obj).f71943c.get();
        return (imageView2 == null || imageView == null || !Objects.b(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }
}
