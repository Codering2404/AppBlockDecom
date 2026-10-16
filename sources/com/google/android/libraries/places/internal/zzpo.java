package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpo extends ImageViewTarget {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ImageView f78410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function1 f78411l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpo(ImageView view, Function1 function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.f78410k = view;
        this.f78411l = function1;
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public final void j(Drawable drawable) {
        Function1 function1 = this.f78411l;
        if (function1 != null) {
            function1.invoke(this.f78410k);
        }
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public final /* bridge */ /* synthetic */ void s(Object obj) {
        final Bitmap bitmap = (Bitmap) obj;
        this.f78410k.post(new Runnable() { // from class: com.google.android.libraries.places.internal.zzpn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f78408a.f78410k.setImageBitmap(bitmap);
            }
        });
    }
}
