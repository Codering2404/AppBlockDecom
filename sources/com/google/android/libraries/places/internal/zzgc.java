package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzgc extends ImageRequest {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final /* synthetic */ Map f77847y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgc(zzgg zzggVar, String str, Response.Listener listener, int i3, int i4, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener, Map map) {
        super(str, listener, 0, 0, scaleType, config, errorListener);
        this.f77847y = map;
        Objects.requireNonNull(zzggVar);
    }

    @Override // com.android.volley.Request
    public final Map n() {
        return this.f77847y;
    }
}
