package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f67221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f67222c;

    @Override // com.bumptech.glide.request.target.Target
    public final void k(SizeReadyCallback sizeReadyCallback) {
        if (Util.v(this.f67221b, this.f67222c)) {
            sizeReadyCallback.d(this.f67221b, this.f67222c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f67221b + " and height: " + this.f67222c + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void c(SizeReadyCallback sizeReadyCallback) {
    }
}
