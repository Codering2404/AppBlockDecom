package cz.mobilesoft.coreblock.scene.insights.trial_summary;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreenKt$TrialSummaryScreen$1$1", f = "TrialSummaryScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class TrialSummaryScreenKt$TrialSummaryScreen$1$1 extends SuspendLambda implements Function2<TrialSummaryViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f103595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f103596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f103597c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrialSummaryScreenKt$TrialSummaryScreen$1$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f103597c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TrialSummaryScreenKt$TrialSummaryScreen$1$1 trialSummaryScreenKt$TrialSummaryScreen$1$1 = new TrialSummaryScreenKt$TrialSummaryScreen$1$1(this.f103597c, continuation);
        trialSummaryScreenKt$TrialSummaryScreen$1$1.f103596b = obj;
        return trialSummaryScreenKt$TrialSummaryScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TrialSummaryViewCommand trialSummaryViewCommand, Continuation continuation) {
        return ((TrialSummaryScreenKt$TrialSummaryScreen$1$1) create(trialSummaryViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TrialSummaryViewCommand trialSummaryViewCommand = (TrialSummaryViewCommand) this.f103596b;
        IntrinsicsKt.f();
        if (this.f103595a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!Intrinsics.areEqual(trialSummaryViewCommand, TrialSummaryViewCommand.GoToDashboard.f103598a)) {
            throw new NoWhenBranchMatchedException();
        }
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, this.f103597c, null, null, 6, null);
        intentC.setFlags(268468224);
        this.f103597c.startActivity(intentC);
        return Unit.f139807a;
    }
}
