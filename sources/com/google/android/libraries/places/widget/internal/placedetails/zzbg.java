package com.google.android.libraries.places.widget.internal.placedetails;

import android.net.Uri;
import android.util.Log;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbg implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation f79258a;

    zzbg(CancellableContinuation cancellableContinuation) {
        this.f79258a = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Uri uriA = ((FetchResolvedPhotoUriResponse) obj).a();
        if (uriA == null) {
            Log.i("PlaceDetailsViewModel", "No URI returned, falling back to placeholder image.");
            this.f79258a.resumeWith(Result.b(zzbp.f79277a));
        } else {
            this.f79258a.resumeWith(Result.b(new zzbm(uriA)));
            Log.i("PlaceDetailsViewModel", "Successfully resolved photo URI.");
        }
        return Unit.f139807a;
    }
}
