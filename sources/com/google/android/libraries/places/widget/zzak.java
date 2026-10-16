package com.google.android.libraries.places.widget;

import android.net.Uri;
import android.widget.ImageView;
import com.google.android.libraries.places.internal.zzpm;
import com.google.android.libraries.places.internal.zzpo;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.widget.internal.placedetails.zzbj;
import com.google.android.libraries.places.widget.internal.placedetails.zzbm;
import com.google.android.libraries.places.widget.internal.placedetails.zzbq;
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
final class zzak extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PlaceDetailsFragment f79420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbq f79421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageView f79422d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzak(PlaceDetailsFragment placeDetailsFragment, zzbq zzbqVar, ImageView imageView, Continuation continuation) {
        super(2, continuation);
        this.f79420b = placeDetailsFragment;
        this.f79421c = zzbqVar;
        this.f79422d = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzak(this.f79420b, this.f79421c, this.f79422d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzak) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79419a;
        ResultKt.b(obj);
        if (i3 == 0) {
            final PlaceDetailsFragment placeDetailsFragment = this.f79420b;
            zzbj zzbjVar = placeDetailsFragment.E;
            if (zzbjVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                zzbjVar = null;
            }
            zzpt zzptVarD0 = zzbjVar.D0();
            if (zzptVarD0 != null) {
                zzbq zzbqVar = this.f79421c;
                zzpm zzpmVarZze = zzptVarD0.zze();
                Uri uriA = ((zzbm) zzbqVar).a();
                zzpo zzpoVar = new zzpo(this.f79422d, new Function1() { // from class: com.google.android.libraries.places.widget.zzaj
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Object invoke(Object obj2) {
                        PlaceDetailsFragment.D(placeDetailsFragment, (ImageView) obj2);
                        return Unit.f139807a;
                    }
                });
                this.f79419a = 1;
                if (zzpmVarZze.a(uriA, zzpoVar, this) == objF) {
                    return objF;
                }
            }
        }
        return Unit.f139807a;
    }
}
