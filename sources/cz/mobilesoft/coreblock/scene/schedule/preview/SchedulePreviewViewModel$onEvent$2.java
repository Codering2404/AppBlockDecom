package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$onEvent$2", f = "SchedulePreviewViewModel.kt", l = {399, RCHTTPStatusCodes.BAD_REQUEST, 396}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$onEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f117491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f117492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f117493d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117494f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$onEvent$2(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(1, continuation);
        this.f117494f = schedulePreviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SchedulePreviewViewModel$onEvent$2(this.f117494f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        if (r5.P0(r6, r8) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f117493d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L36
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r9)
            goto L98
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            long r3 = r8.f117492c
            java.lang.Object r1 = r8.f117491b
            cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState r1 = (cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState) r1
            java.lang.Object r5 = r8.f117490a
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r5 = (cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel) r5
            kotlin.ResultKt.b(r9)
            goto L83
        L2c:
            long r4 = r8.f117492c
            java.lang.Object r1 = r8.f117490a
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r1 = (cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel) r1
            kotlin.ResultKt.b(r9)
            goto L5e
        L36:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r9 = r8.f117494f
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r1 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.b1(r9)
            long r5 = r1.k()
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r1 = r8.f117494f
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r1 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.f1(r1)
            kotlinx.coroutines.flow.Flow r1 = r1.q0()
            r8.f117490a = r9
            r8.f117492c = r5
            r8.f117493d = r4
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r8)
            if (r1 != r0) goto L5a
            goto L97
        L5a:
            r4 = r1
            r1 = r9
            r9 = r4
            r4 = r5
        L5e:
            java.lang.String r6 = "first(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState r9 = (cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState) r9
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r6 = r8.f117494f
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r6 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.Z0(r6)
            kotlinx.coroutines.flow.StateFlow r6 = r6.K()
            r8.f117490a = r1
            r8.f117491b = r9
            r8.f117492c = r4
            r8.f117493d = r3
            java.lang.Object r3 = kotlinx.coroutines.flow.FlowKt.D(r6, r8)
            if (r3 != r0) goto L7e
            goto L97
        L7e:
            r7 = r1
            r1 = r9
            r9 = r3
            r3 = r4
            r5 = r7
        L83:
            cz.mobilesoft.coreblock.enums.PremiumState r9 = (cz.mobilesoft.coreblock.enums.PremiumState) r9
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewCommand$OpenPauseBlockingActivity r6 = new cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewCommand$OpenPauseBlockingActivity
            r6.<init>(r3, r1, r9)
            r9 = 0
            r8.f117490a = r9
            r8.f117491b = r9
            r8.f117493d = r2
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.j1(r5, r6, r8)
            if (r9 != r0) goto L98
        L97:
            return r0
        L98:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SchedulePreviewViewModel$onEvent$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
