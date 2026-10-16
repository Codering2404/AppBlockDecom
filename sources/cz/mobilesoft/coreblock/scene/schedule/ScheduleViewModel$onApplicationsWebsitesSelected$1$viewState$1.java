package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1", f = "ScheduleViewModel.kt", l = {2512, 2513}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1 extends SuspendLambda implements Function4<ScheduleDTO, LockState, PremiumState, Continuation<? super ScheduleViewState.DetailViewState>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f114746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f114747d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f114748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114749g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(4, continuation);
        this.f114749g = scheduleViewModel;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScheduleDTO scheduleDTO, LockState lockState, PremiumState premiumState, Continuation continuation) {
        ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1 scheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1 = new ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1(this.f114749g, continuation);
        scheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1.f114746c = scheduleDTO;
        scheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1.f114747d = lockState;
        scheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1.f114748f = premiumState;
        return scheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1.invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a2, code lost:
    
        if (r11 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f114746c
            r1 = r0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r1 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) r1
            java.lang.Object r0 = r10.f114747d
            r4 = r0
            cz.mobilesoft.coreblock.scene.schedule.detail.LockState r4 = (cz.mobilesoft.coreblock.scene.schedule.detail.LockState) r4
            java.lang.Object r0 = r10.f114748f
            r5 = r0
            cz.mobilesoft.coreblock.enums.PremiumState r5 = (cz.mobilesoft.coreblock.enums.PremiumState) r5
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r10.f114745b
            r3 = 1
            r9 = 2
            if (r2 == 0) goto L33
            if (r2 == r3) goto L2f
            if (r2 != r9) goto L27
            java.lang.Object r0 = r10.f114744a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r11)
            r8 = r10
            goto La5
        L27:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2f:
            kotlin.ResultKt.b(r11)
            goto L48
        L33:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r11 = r10.f114749g
            r10.f114746c = r1
            r10.f114747d = r4
            r10.f114748f = r5
            r10.f114745b = r3
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.y1(r11, r1, r10)
            if (r11 != r0) goto L48
            r8 = r10
            goto La4
        L48:
            java.util.List r11 = (java.util.List) r11
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r2 = r10.f114749g
            android.content.Context r2 = r2.A0()
            r3 = r11
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r6 = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r7)
            r3.<init>(r7)
            java.util.Iterator r6 = r6.iterator()
        L63:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r6.next()
            cz.mobilesoft.coreblock.util.permissions.PermissionDTO r7 = (cz.mobilesoft.coreblock.util.permissions.PermissionDTO) r7
            cz.mobilesoft.coreblock.enums.Permission r7 = r7.e()
            r3.add(r7)
            goto L63
        L77:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r6 = r10.f114749g
            java.util.List r6 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.G1(r6)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r10.f114749g
            boolean r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.i2(r7)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r10.f114746c = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r10.f114747d = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r10.f114748f = r8
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f114744a = r11
            r10.f114745b = r9
            r8 = r10
            java.lang.Object r11 = cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.N(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto La5
        La4:
            return r0
        La5:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r0 = r8.f114749g
            r1 = r11
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState r1 = (cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState.DetailViewState) r1
            boolean r1 = r1.E()
            if (r1 == 0) goto Lb6
            cz.mobilesoft.coreblock.scene.selection.components.TabItem r1 = cz.mobilesoft.coreblock.scene.selection.components.TabItem.Apps
            r2 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.o4(r0, r1, r2, r9, r2)
        Lb6:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onApplicationsWebsitesSelected$1$viewState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
