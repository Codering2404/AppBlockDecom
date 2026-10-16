package com.google.android.libraries.places.widget.internal.placedetails;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbh implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation f79259a;

    zzbh(CancellableContinuation cancellableContinuation) {
        this.f79259a = cancellableContinuation;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        e3.printStackTrace();
        Unit unit = Unit.f139807a;
        new StringBuilder(String.valueOf(unit).length() + 38);
        Objects.toString(unit);
        Log.w("PlaceDetailsViewModel", "Failed to fetch photo URI with error: ".concat(String.valueOf(unit)));
        this.f79259a.resumeWith(Result.b(zzbl.f79273a));
    }
}
