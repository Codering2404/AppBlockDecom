package cz.mobilesoft.coreblock.scene.strictmode3;

import androidx.compose.runtime.MutableLongState;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$StrictMode3Screen$7$1", f = "StrictMode3Screen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictMode3ScreenKt$StrictMode3Screen$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableLongState f121158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewState f121159c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ScreenKt$StrictMode3Screen$7$1(MutableLongState mutableLongState, StrictMode3ViewState strictMode3ViewState, Continuation continuation) {
        super(2, continuation);
        this.f121158b = mutableLongState;
        this.f121159c = strictMode3ViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ScreenKt$StrictMode3Screen$7$1(this.f121158b, this.f121159c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f121157a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        MutableLongState mutableLongState = this.f121158b;
        AccessMethodConfiguration accessMethodConfigurationD = this.f121159c.d();
        AccessMethodConfiguration.Cooldown cooldown = accessMethodConfigurationD instanceof AccessMethodConfiguration.Cooldown ? (AccessMethodConfiguration.Cooldown) accessMethodConfigurationD : null;
        mutableLongState.t(cooldown != null ? cooldown.b() : 0L);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ScreenKt$StrictMode3Screen$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
