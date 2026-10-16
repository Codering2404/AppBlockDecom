package cz.mobilesoft.coreblock.scene.more.haf;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.scene.more.haf.HaFViewCommand;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity$CommandProcessor$1$1", f = "HaFActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class HaFActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<HaFViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f107550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ HaFActivity f107551c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HaFActivity$CommandProcessor$1$1(HaFActivity haFActivity, Continuation continuation) {
        super(2, continuation);
        this.f107551c = haFActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        HaFActivity$CommandProcessor$1$1 haFActivity$CommandProcessor$1$1 = new HaFActivity$CommandProcessor$1$1(this.f107551c, continuation);
        haFActivity$CommandProcessor$1$1.f107550b = obj;
        return haFActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(HaFViewCommand haFViewCommand, Continuation continuation) {
        return ((HaFActivity$CommandProcessor$1$1) create(haFViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HaFViewCommand haFViewCommand = (HaFViewCommand) this.f107550b;
        IntrinsicsKt.f();
        if (this.f107549a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!Intrinsics.areEqual(haFViewCommand, HaFViewCommand.OpenContactSupport.f107592a)) {
            throw new NoWhenBranchMatchedException();
        }
        HaFActivity haFActivity = this.f107551c;
        FeedbackActivity.Companion companion = FeedbackActivity.f102045f;
        Context applicationContext = haFActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        haFActivity.startActivity(FeedbackActivity.Companion.b(companion, applicationContext, null, null, null, "help_screen", null, false, 110, null));
        return Unit.f139807a;
    }
}
