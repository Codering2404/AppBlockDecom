package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.statistics.model.AppWithType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4", f = "InsightsViewModel.kt", l = {289, 301}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$initialize$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f102745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102746c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$1", f = "InsightsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends IgnoredStatisticsItem>, List<? extends AppWithType>, Continuation<? super Pair<? extends List<? extends IgnoredStatisticsItem>, ? extends Boolean>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f102748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f102749c;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, List list2, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f102748b = list;
            anonymousClass1.f102749c = list2;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            List list = (List) this.f102748b;
            List list2 = (List) this.f102749c;
            IntrinsicsKt.f();
            if (this.f102747a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List list3 = list2;
            boolean z2 = false;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it = list3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((AppWithType) it.next()).a() != null) {
                        z2 = true;
                        break;
                    }
                }
            }
            return TuplesKt.a(list, Boxing.a(z2));
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsightsViewModel f102750a;

        AnonymousClass2(InsightsViewModel insightsViewModel) {
            this.f102750a = insightsViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InsightsViewState f(Pair pair, InsightsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, updateState.J() || ((Boolean) pair.f()).booleanValue(), false, null, false, false, false, -1, 32255, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final Pair pair, Continuation continuation) throws Throwable {
            InsightsViewModel insightsViewModel = this.f102750a;
            Iterable iterable = (Iterable) pair.e();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (T t2 : iterable) {
                linkedHashMap.put(((IgnoredStatisticsItem) t2).c(), t2);
            }
            insightsViewModel.T = linkedHashMap;
            this.f102750a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.q7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsViewModel$initialize$4.AnonymousClass2.f(pair, (InsightsViewState) obj);
                }
            });
            Object objA2 = this.f102750a.A2(continuation);
            return objA2 == IntrinsicsKt.f() ? objA2 : Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$initialize$4(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102746c = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$initialize$4(this.f102746c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        if (r1.collect(r3, r9) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f102745b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r9.f102744a
            java.lang.Long r0 = (java.lang.Long) r0
            kotlin.ResultKt.b(r10)
            goto L7d
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.b(r10)
            goto L2e
        L22:
            kotlin.ResultKt.b(r10)
            r9.f102745b = r3
            java.lang.Object r10 = cz.mobilesoft.statistics.api.Statistics.N(r9)
            if (r10 != r0) goto L2e
            goto L7c
        L2e:
            java.lang.Long r10 = (java.lang.Long) r10
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r1 = r9.f102746c
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$InsightTypeConfig r4 = new cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$InsightTypeConfig
            if (r10 == 0) goto L3b
            long r5 = r10.longValue()
            goto L41
        L3b:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r5 = r9.f102746c
            long r5 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.D1(r5)
        L41:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r7 = r9.f102746c
            long r7 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.D1(r7)
            r4.<init>(r5, r7)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.Q1(r1, r4)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r1 = r9.f102746c
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.C1(r1)
            kotlinx.coroutines.flow.Flow r1 = r1.S(r3)
            cz.mobilesoft.statistics.api.Statistics r3 = cz.mobilesoft.statistics.api.Statistics.f133571a
            kotlinx.coroutines.flow.Flow r3 = r3.m()
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$1 r4 = new cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$1
            r5 = 0
            r4.<init>(r5)
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.J(r1, r3, r4)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$2 r3 = new cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4$2
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r4 = r9.f102746c
            r3.<init>(r4)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r9.f102744a = r10
            r9.f102745b = r2
            java.lang.Object r10 = r1.collect(r3, r9)
            if (r10 != r0) goto L7d
        L7c:
            return r0
        L7d:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$initialize$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$initialize$4) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
