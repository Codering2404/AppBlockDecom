package com.google.android.libraries.places.widget.internal.photoviewer;

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
final class zzk extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzl f79110b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzk(zzl zzlVar, Continuation continuation) {
        super(2, continuation);
        this.f79110b = zzlVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzk(this.f79110b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzk) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79109a;
        ResultKt.b(obj);
        if (i3 == 0) {
            final zzl zzlVar = this.f79110b;
            zzd zzdVar = zzlVar.f79114c;
            ImageView imageView = null;
            if (zzdVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageData");
                zzdVar = null;
            }
            Uri uri = Uri.parse(zzdVar.c());
            zzpt zzptVarW = zzlVar.w();
            if (zzptVarW != null) {
                zzpm zzpmVarZze = zzptVarW.zze();
                ImageView imageView2 = zzlVar.f79112a;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("image");
                } else {
                    imageView = imageView2;
                }
                zzpo zzpoVar = new zzpo(imageView, new Function1() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzj
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Object invoke(Object obj2) {
                        zzl.z(zzlVar);
                        return Unit.f139807a;
                    }
                });
                this.f79109a = 1;
                if (zzpmVarZze.a(uri, zzpoVar, this) == objF) {
                    return objF;
                }
            }
        }
        return Unit.f139807a;
    }
}
