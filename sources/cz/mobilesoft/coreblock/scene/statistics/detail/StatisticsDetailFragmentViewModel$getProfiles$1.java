package cz.mobilesoft.coreblock.scene.statistics.detail;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1", f = "StatisticsDetailFragmentViewModel.kt", l = {142, 143}, m = "invokeSuspend", v = 1)
final class StatisticsDetailFragmentViewModel$getProfiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsDetailFragmentViewModel f119848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f119849d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1$1", f = "StatisticsDetailFragmentViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f119850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f119851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f119852c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, List list, Continuation continuation) {
            super(2, continuation);
            this.f119851b = function1;
            this.f119852c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f119851b, this.f119852c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f119850a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f119851b.invoke(this.f119852c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsDetailFragmentViewModel$getProfiles$1(StatisticsDetailFragmentViewModel statisticsDetailFragmentViewModel, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f119848c = statisticsDetailFragmentViewModel;
        this.f119849d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsDetailFragmentViewModel$getProfiles$1(this.f119848c, this.f119849d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r1, r3, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f119847b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.f119846a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto L5d
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L40
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel r7 = r6.f119848c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r7 = cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel.q1(r7)
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel r1 = r6.f119848c
            java.util.List r1 = r1.x1()
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel r4 = r6.f119848c
            java.util.List r4 = r4.z1()
            r6.f119847b = r3
            java.lang.Object r7 = r7.x0(r1, r4, r6)
            if (r7 != r0) goto L40
            goto L5c
        L40:
            java.util.List r7 = (java.util.List) r7
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1$1 r3 = new cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1$1
            kotlin.jvm.functions.Function1 r4 = r6.f119849d
            r5 = 0
            r3.<init>(r4, r7, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f119846a = r7
            r6.f119847b = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r1, r3, r6)
            if (r7 != r0) goto L5d
        L5c:
            return r0
        L5d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel$getProfiles$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsDetailFragmentViewModel$getProfiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
