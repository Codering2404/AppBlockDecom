package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel$onCloseClicked$1", f = "UsageLimitConditionViewModel.kt", l = {153, 156}, m = "invokeSuspend", v = 1)
final class UsageLimitConditionViewModel$onCloseClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f115894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UsageLimitConditionViewModel f115895c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitConditionViewModel$onCloseClicked$1(UsageLimitConditionViewModel usageLimitConditionViewModel, Continuation continuation) {
        super(2, continuation);
        this.f115895c = usageLimitConditionViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UsageLimitConditionViewModel$onCloseClicked$1(this.f115895c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
    
        if (r1.P0(r2, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        if (r1.P0(r3, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f115894b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            java.lang.Object r0 = r5.f115893a
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState r0 = (cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState) r0
            kotlin.ResultKt.b(r6)
            goto L7e
        L1f:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r6 = r5.f115895c
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState r6 = cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel.U0(r6)
            cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState r1 = r6.e()
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r4 = r5.f115895c
            cz.mobilesoft.coreblock.base.ViewState r4 = r4.L0()
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState r4 = (cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState) r4
            cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState r4 = r4.e()
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L5e
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.enums.ProfileType r2 = cz.mobilesoft.coreblock.enums.ProfileType.TIME
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r4 = r5.f115895c
            boolean r4 = r4.X()
            r1.N4(r2, r4)
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r1 = r5.f115895c
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewCommand$CloseScreen r2 = cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewCommand.CloseScreen.f115877a
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f115893a = r6
            r5.f115894b = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel.V0(r1, r2, r5)
            if (r6 != r0) goto L7e
            goto L7d
        L5e:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.enums.ProfileType r3 = cz.mobilesoft.coreblock.enums.ProfileType.TIME
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r4 = r5.f115895c
            boolean r4 = r4.X()
            r1.Q4(r3, r4)
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel r1 = r5.f115895c
            cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewCommand$ShowUnsavedChangesDialog r3 = cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewCommand.ShowUnsavedChangesDialog.f115880a
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f115893a = r6
            r5.f115894b = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel.V0(r1, r3, r5)
            if (r6 != r0) goto L7e
        L7d:
            return r0
        L7e:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel$onCloseClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UsageLimitConditionViewModel$onCloseClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
