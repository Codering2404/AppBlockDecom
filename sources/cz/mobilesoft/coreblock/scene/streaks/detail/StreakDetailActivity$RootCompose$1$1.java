package cz.mobilesoft.coreblock.scene.streaks.detail;

import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailActivity$RootCompose$1$1", f = "StreakDetailActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class StreakDetailActivity$RootCompose$1$1 extends SuspendLambda implements Function2<StreakDetailViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f120669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakDetailActivity f120670c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakDetailActivity$RootCompose$1$1(StreakDetailActivity streakDetailActivity, Continuation continuation) {
        super(2, continuation);
        this.f120670c = streakDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakDetailActivity$RootCompose$1$1 streakDetailActivity$RootCompose$1$1 = new StreakDetailActivity$RootCompose$1$1(this.f120670c, continuation);
        streakDetailActivity$RootCompose$1$1.f120669b = obj;
        return streakDetailActivity$RootCompose$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StreakDetailViewCommand streakDetailViewCommand, Continuation continuation) {
        return ((StreakDetailActivity$RootCompose$1$1) create(streakDetailViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StreakDetailViewCommand streakDetailViewCommand = (StreakDetailViewCommand) this.f120669b;
        IntrinsicsKt.f();
        if (this.f120668a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(streakDetailViewCommand, StreakDetailViewCommand.OpenBetaFeedback.f120685a)) {
            this.f120670c.q0();
        } else {
            if (!Intrinsics.areEqual(streakDetailViewCommand, StreakDetailViewCommand.OpenCreateBlocking.f120686a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f120670c.s0();
        }
        return Unit.f139807a;
    }
}
