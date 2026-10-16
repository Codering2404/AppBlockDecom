package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onBlockingModeSelected$1", f = "ScheduleViewModel.kt", l = {1614, 1622, 1626, 1631, 1641, 1642, 1671, 1688}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onBlockingModeSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114753d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f114754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Profile.BlockingMode f114756h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114757a;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f114757a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onBlockingModeSelected$1(ScheduleViewModel scheduleViewModel, Profile.BlockingMode blockingMode, Continuation continuation) {
        super(2, continuation);
        this.f114755g = scheduleViewModel;
        this.f114756h = blockingMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO q(ItemsDTO itemsDTO, Profile.BlockingMode blockingMode, ArrayList arrayList, ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, blockingMode, null, null, null, null, null, null, arrayList, itemsDTO.e(), itemsDTO.d(), null, null, false, false, false, 0L, 0L, null, false, CollectionsKt.emptyList(), 267976187, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onBlockingModeSelected$1(this.f114755g, this.f114756h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c9, code lost:
    
        if (r4.P2(r17) == r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010d, code lost:
    
        if (r4.P0(r6, r17) == r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013e, code lost:
    
        if (r4.P0(r5, r17) == r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x019e, code lost:
    
        if (r4 == r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0217, code lost:
    
        if (r5 == r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02a4, code lost:
    
        if (r5.P2(r17) == r1) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02aa A[PHI: r2 r3
      0x02aa: PHI (r2v16 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) = 
      (r2v3 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r2v3 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
      (r2v21 cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState)
     binds: [B:47:0x0169, B:51:0x0181, B:58:0x01ac] A[DONT_GENERATE, DONT_INLINE]
      0x02aa: PHI (r3v5 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) = 
      (r3v0 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r3v0 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
      (r3v8 cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO)
     binds: [B:47:0x0169, B:51:0x0181, B:58:0x01ac] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onBlockingModeSelected$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onBlockingModeSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
