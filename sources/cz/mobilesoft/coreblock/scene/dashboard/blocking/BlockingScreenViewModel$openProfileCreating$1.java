package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.enums.ProfileType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$openProfileCreating$1", f = "BlockingScreenViewModel.kt", l = {1049, 1051, 1054}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$openProfileCreating$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProfileType f99766d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f99767a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f99767a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$openProfileCreating$1(BlockingScreenViewModel blockingScreenViewModel, ProfileType profileType, Continuation continuation) {
        super(2, continuation);
        this.f99765c = blockingScreenViewModel;
        this.f99766d = profileType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$openProfileCreating$1(this.f99765c, this.f99766d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r3.P0(r4, r17) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
    
        if (r2.P0(r3, r17) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        if (r2.P0(r4, r17) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f99764b
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L25
            if (r2 == r5) goto L1c
            if (r2 == r4) goto L20
            if (r2 != r3) goto L14
            goto L20
        L14:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1c:
            java.lang.Object r1 = r0.f99763a
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO r1 = (cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO) r1
        L20:
            kotlin.ResultKt.b(r18)
            goto La1
        L25:
            kotlin.ResultKt.b(r18)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r2 = r0.f99765c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState r2 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.b1(r2)
            boolean r2 = r2.p()
            if (r2 == 0) goto L8d
            cz.mobilesoft.coreblock.enums.ProfileType r2 = r0.f99766d
            if (r2 == 0) goto L80
            int[] r3 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$openProfileCreating$1.WhenMappings.f99767a
            int r2 = r2.ordinal()
            r2 = r3[r2]
            if (r2 == r5) goto L57
            if (r2 == r4) goto L46
            r2 = 0
            goto L68
        L46:
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO r6 = new cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO
            r14 = 31
            r15 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r6.<init>(r7, r9, r10, r12, r13, r14, r15)
            r2 = r6
            goto L68
        L57:
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO r7 = new cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO
            r15 = 31
            r16 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r7.<init>(r8, r10, r11, r13, r14, r15, r16)
            r2 = r7
        L68:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r3 = r0.f99765c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenProfileWithConditionCreating r4 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenProfileWithConditionCreating
            cz.mobilesoft.coreblock.enums.ProfileType r6 = r0.f99766d
            r4.<init>(r6, r2)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f99763a = r2
            r0.f99764b = r5
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r3, r4, r0)
            if (r2 != r1) goto La1
            goto La0
        L80:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r2 = r0.f99765c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenProfileCreating r3 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand.OpenProfileCreating.f99532a
            r0.f99764b = r4
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r2, r3, r0)
            if (r2 != r1) goto La1
            goto La0
        L8d:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r2 = r0.f99765c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenPremiumFeatureActivity r4 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$OpenPremiumFeatureActivity
            cz.mobilesoft.coreblock.enums.PremiumFeature r5 = cz.mobilesoft.coreblock.enums.PremiumFeature.PROFILES_UNLIMITED
            java.lang.String r6 = "no_of_schedules_limit"
            r4.<init>(r5, r6)
            r0.f99764b = r3
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r2, r4, r0)
            if (r2 != r1) goto La1
        La0:
            return r1
        La1:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$openProfileCreating$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$openProfileCreating$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
