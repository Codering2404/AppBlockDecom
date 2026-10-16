package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WorkConstraintsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f54859a;

    public WorkConstraintsTracker(List controllers) {
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        this.f54859a = controllers;
    }

    public final boolean a(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        List list = this.f54859a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).d(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.e().a(WorkConstraintsTrackerKt.f54866a, "Work " + workSpec.f55013a + " constrained by " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<ConstraintController<?>, CharSequence>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final CharSequence invoke(ConstraintController it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String simpleName = it.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "it.javaClass.simpleName");
                    return simpleName;
                }
            }, 31, null));
        }
        return arrayList.isEmpty();
    }

    public final Flow b(WorkSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        List list = this.f54859a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).c(spec)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((ConstraintController) obj2).f());
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt.toList(arrayList2).toArray(new Flow[0]);
        return FlowKt.u(new Flow<ConstraintsState>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

            /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {292}, m = "invokeSuspend")
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super ConstraintsState>, ConstraintsState[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f54863a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f54864b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f54865c;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.f54864b = flowCollector;
                    anonymousClass3.f54865c = objArr;
                    return anonymousClass3.invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    ConstraintsState constraintsState;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f54863a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        FlowCollector flowCollector = (FlowCollector) this.f54864b;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.f54865c);
                        int length = constraintsStateArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                constraintsState = null;
                                break;
                            }
                            constraintsState = constraintsStateArr[i4];
                            if (!Intrinsics.areEqual(constraintsState, ConstraintsState.ConstraintsMet.f54853a)) {
                                break;
                            }
                            i4++;
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.f54853a;
                        }
                        this.f54863a = 1;
                        if (flowCollector.emit(constraintsState, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f139807a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object objA = CombineKt.a(flowCollector, flowArr2, new Function0<ConstraintsState[]>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Object[] invoke() {
                        return new ConstraintsState[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this(CollectionsKt.listOf((Object[]) new ConstraintController[]{new BatteryChargingController(trackers.a()), new BatteryNotLowController(trackers.b()), new StorageNotLowController(trackers.d()), new NetworkConnectedController(trackers.c()), new NetworkUnmeteredController(trackers.c()), new NetworkNotRoamingController(trackers.c()), new NetworkMeteredController(trackers.c())}));
        Intrinsics.checkNotNullParameter(trackers, "trackers");
    }
}
