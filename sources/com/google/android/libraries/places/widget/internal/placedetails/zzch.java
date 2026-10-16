package com.google.android.libraries.places.widget.internal.placedetails;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.libraries.places.internal.zzpm;
import com.google.android.libraries.places.internal.zzpo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzch extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzci f79320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f79321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzcf f79322d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Drawable f79323f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzch(zzci zzciVar, String str, zzcf zzcfVar, Drawable drawable, Continuation continuation) {
        super(2, continuation);
        this.f79320b = zzciVar;
        this.f79321c = str;
        this.f79322d = zzcfVar;
        this.f79323f = drawable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzch(this.f79320b, this.f79321c, this.f79322d, this.f79323f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzch) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzpm zzpmVar;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79319a;
        ResultKt.b(obj);
        if (i3 == 0 && (zzpmVar = this.f79320b.f79330m) != null) {
            String str = this.f79321c;
            final zzcf zzcfVar = this.f79322d;
            final Drawable drawable = this.f79323f;
            Uri uri = Uri.parse(str);
            zzpo zzpoVar = new zzpo(zzcfVar.c(), new Function1() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzcg
                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Object invoke(Object obj2) {
                    zzcfVar.c().setImageDrawable(drawable);
                    return Unit.f139807a;
                }
            });
            this.f79319a = 1;
            if (zzpmVar.a(uri, zzpoVar, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
