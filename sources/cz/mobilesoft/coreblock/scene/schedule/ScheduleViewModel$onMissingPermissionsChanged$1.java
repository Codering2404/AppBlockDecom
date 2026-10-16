package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.MissingPermissions;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onMissingPermissionsChanged$1", f = "ScheduleViewModel.kt", l = {2614, 2616, 2629, 2642, 2654}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onMissingPermissionsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f114869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114872d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PermissionRequestReason f114873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f114875h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114876a;

        static {
            int[] iArr = new int[PermissionRequestReason.values().length];
            try {
                iArr[PermissionRequestReason.Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionRequestReason.General.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f114876a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onMissingPermissionsChanged$1(PermissionRequestReason permissionRequestReason, ScheduleViewModel scheduleViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114873f = permissionRequestReason;
        this.f114874g = scheduleViewModel;
        this.f114875h = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState y(List list, boolean z2, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), null, null, null, false, false, null, null, null, false, null, new MissingPermissions(ExtensionsKt.h(list), z2), null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67107839, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState z(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), null, null, null, false, false, null, null, null, false, null, MissingPermissions.b(scheduleViewState.g().l(), null, false, 1, null), null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67107839, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onMissingPermissionsChanged$1(this.f114873f, this.f114874g, this.f114875h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r5, r16) == r1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0118, code lost:
    
        if (r4.P0(r5, r16) == r1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b6, code lost:
    
        if (r2.P0(r3, r16) == r1) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b9  */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onMissingPermissionsChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onMissingPermissionsChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
