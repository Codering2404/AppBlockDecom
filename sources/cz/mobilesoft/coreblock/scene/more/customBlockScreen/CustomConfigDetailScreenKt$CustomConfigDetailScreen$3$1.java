package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreenKt$CustomConfigDetailScreen$3$1", f = "CustomConfigDetailScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class CustomConfigDetailScreenKt$CustomConfigDetailScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f107128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f107129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewState f107130d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomConfigDetailScreenKt$CustomConfigDetailScreen$3$1(String str, MutableState mutableState, CustomBlockingViewState customBlockingViewState, Continuation continuation) {
        super(2, continuation);
        this.f107128b = str;
        this.f107129c = mutableState;
        this.f107130d = customBlockingViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomConfigDetailScreenKt$CustomConfigDetailScreen$3$1(this.f107128b, this.f107129c, this.f107130d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH;
        IntrinsicsKt.f();
        if (this.f107127a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f107128b == null && (customBlockingScreenConfigEntityH = CustomConfigDetailScreenKt.H(this.f107129c)) != null) {
            CustomBlockingViewState customBlockingViewState = this.f107130d;
            MutableState mutableState = this.f107129c;
            if (customBlockingScreenConfigEntityH.l() < customBlockingViewState.d()) {
                CustomConfigDetailScreenKt.I(mutableState, CustomBlockingScreenConfigEntity.b(customBlockingScreenConfigEntityH, null, null, null, false, customBlockingViewState.d(), false, 0, null, null, null, null, 2031, null));
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomConfigDetailScreenKt$CustomConfigDetailScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
