package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateTrialEligibility$1", f = "BlockingScreenViewModel.kt", l = {839}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$updateTrialEligibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99904b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateTrialEligibility$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateTrialEligibility$1$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, PremiumState, Continuation<? super Pair<? extends Boolean, ? extends PremiumState>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f99906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f99907c;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        public final Object h(boolean z2, PremiumState premiumState, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f99906b = z2;
            anonymousClass1.f99907c = premiumState;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h(((Boolean) obj).booleanValue(), (PremiumState) obj2, (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z2 = this.f99906b;
            PremiumState premiumState = (PremiumState) this.f99907c;
            IntrinsicsKt.f();
            if (this.f99905a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return TuplesKt.a(Boxing.a(z2), premiumState);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateTrialEligibility$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewModel f99908a;

        AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
            this.f99908a = blockingScreenViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, z2, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536866815, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.Pair r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateTrialEligibility$1.AnonymousClass2.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$updateTrialEligibility$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99904b = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$updateTrialEligibility$1(this.f99904b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99903a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowM = FlowKt.m(this.f99904b.Y1().l1(), this.f99904b.d2().K(), new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f99904b);
            this.f99903a = 1;
            if (flowM.collect(anonymousClass2, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$updateTrialEligibility$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
