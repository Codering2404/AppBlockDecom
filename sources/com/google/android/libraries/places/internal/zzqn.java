package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzqn extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f78470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f78471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f78472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzqr f78473d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzqn(List list, zzqr zzqrVar, Continuation continuation) {
        super(2, continuation);
        this.f78472c = list;
        this.f78473d = zzqrVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzqn zzqnVar = new zzqn(this.f78472c, this.f78473d, continuation);
        zzqnVar.f78471b = obj;
        return zzqnVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzqn) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f78470a;
        ResultKt.b(obj);
        if (i3 == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.f78471b;
            List list = this.f78472c;
            zzqr zzqrVar = this.f78473d;
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new zzqm(zzqrVar, (Place) it.next(), null), 3, null));
            }
            this.f78470a = 1;
            obj = AwaitKt.a(arrayList, this);
            if (obj == objF) {
                return objF;
            }
        }
        zzqr zzqrVar2 = this.f78473d;
        zzqrVar2.f78481g.n((List) obj);
        PlacesClient placesClientC0 = zzqrVar2.C0();
        if (placesClientC0 != null) {
            placesClientC0.zzm();
        }
        return Unit.f139807a;
    }
}
