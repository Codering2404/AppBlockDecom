package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.AppBlockingSetting;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onAppBlockingSettingCheckedChanged$1", f = "ScheduleViewModel.kt", l = {1936, 1949}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onAppBlockingSettingCheckedChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f114717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f114718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f114719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114720d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f114721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f114722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f114723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f114724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ AppBlockingSetting f114725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f114727l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114728a;

        static {
            int[] iArr = new int[AppBlockingSetting.values().length];
            try {
                iArr[AppBlockingSetting.Launch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppBlockingSetting.Notifications.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f114728a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onAppBlockingSettingCheckedChanged$1(AppBlockingSetting appBlockingSetting, ScheduleViewModel scheduleViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114725j = appBlockingSetting;
        this.f114726k = scheduleViewModel;
        this.f114727l = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO q(AppBlockingSetting appBlockingSetting, boolean z2, ScheduleDTO scheduleDTO) {
        int i3 = WhenMappings.f114728a[appBlockingSetting.ordinal()];
        if (i3 == 1) {
            return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, z2, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870783, null);
        }
        if (i3 == 2) {
            return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, z2, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870847, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onAppBlockingSettingCheckedChanged$1(this.f114725j, this.f114726k, this.f114727l, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
    
        if (r2.P0(r8, r11) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0136, code lost:
    
        if (r8.O2(r11) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0138, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onAppBlockingSettingCheckedChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onAppBlockingSettingCheckedChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
