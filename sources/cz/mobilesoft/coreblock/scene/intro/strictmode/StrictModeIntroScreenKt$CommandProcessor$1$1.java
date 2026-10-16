package cz.mobilesoft.coreblock.scene.intro.strictmode;

import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroScreenKt$CommandProcessor$1$1", f = "StrictModeIntroScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeIntroScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<StrictModeIntroViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f105021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f105022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavHostController f105023d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ StrictModeIntroNavigation f105024f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeIntroScreenKt$CommandProcessor$1$1(Function0 function0, NavHostController navHostController, StrictModeIntroNavigation strictModeIntroNavigation, Continuation continuation) {
        super(2, continuation);
        this.f105022c = function0;
        this.f105023d = navHostController;
        this.f105024f = strictModeIntroNavigation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeIntroScreenKt$CommandProcessor$1$1 strictModeIntroScreenKt$CommandProcessor$1$1 = new StrictModeIntroScreenKt$CommandProcessor$1$1(this.f105022c, this.f105023d, this.f105024f, continuation);
        strictModeIntroScreenKt$CommandProcessor$1$1.f105021b = obj;
        return strictModeIntroScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictModeIntroViewCommand strictModeIntroViewCommand, Continuation continuation) {
        return ((StrictModeIntroScreenKt$CommandProcessor$1$1) create(strictModeIntroViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictModeIntroViewCommand strictModeIntroViewCommand = (StrictModeIntroViewCommand) this.f105021b;
        IntrinsicsKt.f();
        if (this.f105020a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (strictModeIntroViewCommand instanceof StrictModeIntroViewCommand.Close) {
            this.f105022c.invoke();
        } else if (Intrinsics.areEqual(strictModeIntroViewCommand, StrictModeIntroViewCommand.Finish.f105028a)) {
            NavController.P(this.f105023d, StrictModeIntroNavigation.ThatIsItScreen.getRoute(), null, null, 6, null);
        } else {
            if (!Intrinsics.areEqual(strictModeIntroViewCommand, StrictModeIntroViewCommand.NavigateToStart.f105029a)) {
                throw new NoWhenBranchMatchedException();
            }
            NavController.P(this.f105023d, this.f105024f.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }
}
