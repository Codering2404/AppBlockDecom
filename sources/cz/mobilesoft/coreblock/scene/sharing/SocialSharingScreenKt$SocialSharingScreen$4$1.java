package cz.mobilesoft.coreblock.scene.sharing;

import androidx.compose.foundation.pager.PagerState;
import cz.mobilesoft.coreblock.scene.sharing.SocialsSharingViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreenKt$SocialSharingScreen$4$1", f = "SocialSharingScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class SocialSharingScreenKt$SocialSharingScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f119332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagerState f119333c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialSharingScreenKt$SocialSharingScreen$4$1(Function1 function1, PagerState pagerState, Continuation continuation) {
        super(2, continuation);
        this.f119332b = function1;
        this.f119333c = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SocialSharingScreenKt$SocialSharingScreen$4$1(this.f119332b, this.f119333c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f119331a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f119332b.invoke(new SocialsSharingViewEvent.OnPageChanged(this.f119333c.v()));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SocialSharingScreenKt$SocialSharingScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
