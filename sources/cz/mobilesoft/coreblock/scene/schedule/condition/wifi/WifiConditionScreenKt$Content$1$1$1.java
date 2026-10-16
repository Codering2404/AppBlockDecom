package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import androidx.compose.foundation.lazy.LazyListState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt$Content$1$1$1", f = "WifiConditionScreen.kt", l = {658}, m = "invokeSuspend", v = 1)
final class WifiConditionScreenKt$Content$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WifiConfigurationViewState f116025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyListState f116026c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WifiConditionScreenKt$Content$1$1$1(WifiConfigurationViewState wifiConfigurationViewState, LazyListState lazyListState, Continuation continuation) {
        super(2, continuation);
        this.f116025b = wifiConfigurationViewState;
        this.f116026c = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WifiConditionScreenKt$Content$1$1$1(this.f116025b, this.f116026c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f116024a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (StringsKt.p0(this.f116025b.j())) {
                LazyListState lazyListState = this.f116026c;
                this.f116024a = 1;
                if (LazyListState.K(lazyListState, 0, 0, this, 2, null) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WifiConditionScreenKt$Content$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
