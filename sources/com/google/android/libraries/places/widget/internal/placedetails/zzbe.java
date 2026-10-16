package com.google.android.libraries.places.widget.internal.placedetails;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbe extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f79251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f79252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbj f79253d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbe(CoroutineScope coroutineScope, zzbj zzbjVar, Continuation continuation) {
        super(2, continuation);
        this.f79252c = coroutineScope;
        this.f79253d = zzbjVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzbe zzbeVar = new zzbe(this.f79252c, this.f79253d, continuation);
        zzbeVar.f79251b = obj;
        return zzbeVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbe) create((zzav) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzav zzavVar;
        Object objF = IntrinsicsKt.f();
        if (this.f79250a != 0) {
            zzavVar = (zzav) this.f79251b;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            zzav zzavVar2 = (zzav) this.f79251b;
            zzbj zzbjVar = this.f79253d;
            PhotoMetadata photoMetadataA = zzavVar2.a();
            int iB = zzavVar2.b();
            this.f79251b = zzavVar2;
            this.f79250a = 1;
            Object objM0 = zzbjVar.M0(photoMetadataA, iB, this);
            if (objM0 == objF) {
                return objF;
            }
            zzavVar = zzavVar2;
            obj = objM0;
        }
        zzavVar.c().n((zzbq) obj);
        return Unit.f139807a;
    }
}
