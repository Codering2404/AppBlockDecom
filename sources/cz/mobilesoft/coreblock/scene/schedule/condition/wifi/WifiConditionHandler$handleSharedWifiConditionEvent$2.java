package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler$handleSharedWifiConditionEvent$2", f = "WifiConditionViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class WifiConditionHandler$handleSharedWifiConditionEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WifiConditionHandler f116001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SharedWifiConditionEvent f116002c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WifiConditionHandler$handleSharedWifiConditionEvent$2(WifiConditionHandler wifiConditionHandler, SharedWifiConditionEvent sharedWifiConditionEvent, Continuation continuation) {
        super(2, continuation);
        this.f116001b = wifiConditionHandler;
        this.f116002c = sharedWifiConditionEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WifiConditionHandler$handleSharedWifiConditionEvent$2(this.f116001b, this.f116002c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f116000a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        WifiConfigurationViewState wifiConfigurationViewStateY = this.f116001b.Y();
        String strJ = !((SharedWifiConditionEvent.OnSearchOpenStateChanged) this.f116002c).a() ? "" : wifiConfigurationViewStateY.j();
        WifiConditionHandler wifiConditionHandler = this.f116001b;
        wifiConditionHandler.s(WifiConfigurationViewState.d(wifiConfigurationViewStateY, null, ((SharedWifiConditionEvent.OnSearchOpenStateChanged) this.f116002c).a(), false, strJ, null, wifiConditionHandler.j0(wifiConfigurationViewStateY.e(), strJ), null, false, false, false, 981, null));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WifiConditionHandler$handleSharedWifiConditionEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
