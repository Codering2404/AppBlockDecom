package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateDiscountCountDown$1;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateDiscountCountDown$1", f = "BlockingScreenViewModel.kt", l = {899, 902, 913, 914, 915, 917, 938, 945}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$updateDiscountCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f99868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f99869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f99870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f99871d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f99872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f99873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f99874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f99875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f99876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99877k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateDiscountCountDown$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass4<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewModel f99878a;

        AnonymousClass4(BlockingScreenViewModel blockingScreenViewModel) {
            this.f99878a = blockingScreenViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState f(Long l3, BlockingScreenViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            DiscountState discountStateM = updateState.m();
            DiscountState discountStateB = null;
            if (discountStateM != null) {
                discountStateB = DiscountState.b(discountStateM, (l3 == null || l3.longValue() <= 0) ? null : l3, 0L, null, null, 14, null);
            }
            return BlockingScreenViewState.b(updateState, null, null, null, false, discountStateB, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870895, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final Long l3, Continuation continuation) {
            this.f99878a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BlockingScreenViewModel$updateDiscountCountDown$1.AnonymousClass4.f(l3, (BlockingScreenViewState) obj);
                }
            });
            if (l3 == null || l3.longValue() < 1) {
                this.f99878a.L2();
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$updateDiscountCountDown$1(BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99877k = blockingScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState A(BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870895, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState G(Ref.LongRef longRef, Ref.ObjectRef objectRef, RevenueCatOffering revenueCatOffering, BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, new DiscountState(null, longRef.f140143a, (CampaignSource) objectRef.f140144a, revenueCatOffering, 1, null), null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870895, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState z(BlockingScreenViewState blockingScreenViewState) {
        return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870895, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$updateDiscountCountDown$1(this.f99877k, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00fd, code lost:
    
        if (r7 == r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0221, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r13, r19) == r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x026a, code lost:
    
        if (r7.collect(r8, r19) == r1) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateDiscountCountDown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$updateDiscountCountDown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
