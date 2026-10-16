package cz.mobilesoft.coreblock.scene.more.help.restorepurchase;

import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreenKt$CommandProcessor$1$1", f = "RestorePurchaseScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class RestorePurchaseScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<RestorePurchaseViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f107828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f107829c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RestorePurchaseScreenKt$CommandProcessor$1$1(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f107829c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RestorePurchaseScreenKt$CommandProcessor$1$1 restorePurchaseScreenKt$CommandProcessor$1$1 = new RestorePurchaseScreenKt$CommandProcessor$1$1(this.f107829c, continuation);
        restorePurchaseScreenKt$CommandProcessor$1$1.f107828b = obj;
        return restorePurchaseScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(RestorePurchaseViewCommand restorePurchaseViewCommand, Continuation continuation) {
        return ((RestorePurchaseScreenKt$CommandProcessor$1$1) create(restorePurchaseViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RestorePurchaseViewCommand restorePurchaseViewCommand = (RestorePurchaseViewCommand) this.f107828b;
        IntrinsicsKt.f();
        if (this.f107827a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!(restorePurchaseViewCommand instanceof RestorePurchaseViewCommand.Exit)) {
            throw new NoWhenBranchMatchedException();
        }
        this.f107829c.invoke();
        return Unit.f139807a;
    }
}
