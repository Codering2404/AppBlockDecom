package cz.mobilesoft.coreblock.scene.intro.quickblock;

import android.content.Intent;
import cz.mobilesoft.coreblock.scene.intro.BlockingTestOverlayService;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewCommand;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestActivity$CommandProcessor$1$1", f = "QuickBlockBlockingTestActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class QuickBlockBlockingTestActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<QuickBlockBlockingTestViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f104747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockBlockingTestActivity f104748c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockBlockingTestActivity$CommandProcessor$1$1(QuickBlockBlockingTestActivity quickBlockBlockingTestActivity, Continuation continuation) {
        super(2, continuation);
        this.f104748c = quickBlockBlockingTestActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        QuickBlockBlockingTestActivity$CommandProcessor$1$1 quickBlockBlockingTestActivity$CommandProcessor$1$1 = new QuickBlockBlockingTestActivity$CommandProcessor$1$1(this.f104748c, continuation);
        quickBlockBlockingTestActivity$CommandProcessor$1$1.f104747b = obj;
        return quickBlockBlockingTestActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(QuickBlockBlockingTestViewCommand quickBlockBlockingTestViewCommand, Continuation continuation) {
        return ((QuickBlockBlockingTestActivity$CommandProcessor$1$1) create(quickBlockBlockingTestViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        QuickBlockBlockingTestViewCommand quickBlockBlockingTestViewCommand = (QuickBlockBlockingTestViewCommand) this.f104747b;
        IntrinsicsKt.f();
        if (this.f104746a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(quickBlockBlockingTestViewCommand, QuickBlockBlockingTestViewCommand.StartBlockingTest.f104751a)) {
            BlockingTestOverlayService.f104462c.a(this.f104748c);
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.f104748c.startActivity(intent);
        } else {
            if (!Intrinsics.areEqual(quickBlockBlockingTestViewCommand, QuickBlockBlockingTestViewCommand.GoToSchedule.f104750a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f104748c.startActivity(IntroScheduleActivity.Companion.b(IntroScheduleActivity.f104813g, this.f104748c, false, 2, null));
        }
        return Unit.f139807a;
    }
}
