package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$refreshEnvironment$1", f = "TimeNudgeSettingsViewModel.kt", l = {89, 90}, m = "invokeSuspend", v = 1)
final class TimeNudgeSettingsViewModel$refreshEnvironment$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimeNudgeSettingsViewModel f110303c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeNudgeSettingsViewModel$refreshEnvironment$1(TimeNudgeSettingsViewModel timeNudgeSettingsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f110303c = timeNudgeSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeNudgeSettingsViewState q(List list, boolean z2, TimeNudgeSettingsViewState timeNudgeSettingsViewState) {
        return TimeNudgeSettingsViewState.b(timeNudgeSettingsViewState, false, null, list, z2, 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TimeNudgeSettingsViewModel$refreshEnvironment$1(this.f110303c, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[ADDED_TO_REGION] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f110302b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r5.f110301a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r6)
            goto L65
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            java.lang.Object r1 = r5.f110301a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r6)
            goto L47
        L26:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r6 = r5.f110303c
            java.util.List r6 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.V0(r6)
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r1 = r5.f110303c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.U0(r1)
            kotlinx.coroutines.flow.Flow r1 = r1.Y()
            r5.f110301a = r6
            r5.f110302b = r3
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r5)
            if (r1 != r0) goto L44
            goto L63
        L44:
            r4 = r1
            r1 = r6
            r6 = r4
        L47:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L71
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r6 = r5.f110303c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.U0(r6)
            kotlinx.coroutines.flow.Flow r6 = r6.W()
            r5.f110301a = r1
            r5.f110302b = r2
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r5)
            if (r6 != r0) goto L64
        L63:
            return r0
        L64:
            r0 = r1
        L65:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L6f
            r1 = r0
            goto L71
        L6f:
            r3 = 0
            goto L72
        L71:
            r0 = r1
        L72:
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r6 = r5.f110303c
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.y r1 = new cz.mobilesoft.coreblock.scene.more.settings.timenudge.y
            r1.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.X0(r6, r1)
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L93
            if (r3 != 0) goto L93
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r6 = r5.f110303c
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewState r6 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.R0(r6)
            boolean r6 = r6.f()
            if (r6 == 0) goto L93
            cz.mobilesoft.coreblock.util.runnability.JobHelper.m()
        L93:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$refreshEnvironment$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((TimeNudgeSettingsViewModel$refreshEnvironment$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
