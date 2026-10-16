package com.google.android.libraries.places.widget.internal.placedetails;

import android.net.Uri;
import android.widget.ImageView;
import com.google.android.libraries.places.internal.zzpm;
import com.google.android.libraries.places.internal.zzpo;
import com.google.android.libraries.places.internal.zzpt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzar extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzas f79219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f79220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f79221d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzbq f79222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ImageView f79223g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzar(zzas zzasVar, boolean z2, int i3, zzbq zzbqVar, ImageView imageView, Continuation continuation) {
        super(2, continuation);
        this.f79219b = zzasVar;
        this.f79220c = z2;
        this.f79221d = i3;
        this.f79222f = zzbqVar;
        this.f79223g = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzar(this.f79219b, this.f79220c, this.f79221d, this.f79222f, this.f79223g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzar) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79218a;
        ResultKt.b(obj);
        if (i3 == 0) {
            final zzas zzasVar = this.f79219b;
            zzasVar.h(this.f79220c, this.f79221d);
            zzpt zzptVar = zzasVar.f79225b;
            if (zzptVar != null) {
                zzbq zzbqVar = this.f79222f;
                zzpm zzpmVarZze = zzptVar.zze();
                Uri uriA = ((zzbm) zzbqVar).a();
                final ImageView imageView = this.f79223g;
                Intrinsics.checkNotNull(imageView);
                zzpo zzpoVar = new zzpo(imageView, new Function1() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzaq
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Object invoke(Object obj2) {
                        zzas zzasVar2 = zzasVar;
                        ImageView imageView2 = imageView;
                        Intrinsics.checkNotNull(imageView2);
                        zzasVar2.i(imageView2);
                        return Unit.f139807a;
                    }
                });
                this.f79218a = 1;
                if (zzpmVarZze.a(uriA, zzpoVar, this) == objF) {
                    return objF;
                }
            }
        }
        return Unit.f139807a;
    }
}
