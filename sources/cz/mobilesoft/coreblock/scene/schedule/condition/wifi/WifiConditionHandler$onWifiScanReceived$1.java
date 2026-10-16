package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.net.wifi.ScanResult;
import android.os.Build;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler$onWifiScanReceived$1", f = "WifiConditionViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class WifiConditionHandler$onWifiScanReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WifiConditionHandler f116008b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WifiConditionHandler$onWifiScanReceived$1(WifiConditionHandler wifiConditionHandler, Continuation continuation) {
        super(2, continuation);
        this.f116008b = wifiConditionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WifiConditionHandler$onWifiScanReceived$1(this.f116008b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f116007a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List<ScanResult> scanResults = this.f116008b.J().getScanResults();
        Intrinsics.checkNotNull(scanResults);
        WifiConditionHandler wifiConditionHandler = this.f116008b;
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : scanResults) {
            String strValueOf = Build.VERSION.SDK_INT >= 33 ? String.valueOf(scanResult.getWifiSsid()) : scanResult.SSID;
            Intrinsics.checkNotNull(strValueOf);
            Wifi wifi = wifiConditionHandler.G(strValueOf) ? new Wifi(strValueOf, StringHelper.w(strValueOf), false, true, false, false, 52, null) : null;
            if (wifi != null) {
                arrayList.add(wifi);
            }
        }
        WifiConfigurationViewState wifiConfigurationViewStateY = this.f116008b.Y();
        WifiConditionHandler wifiConditionHandler2 = this.f116008b;
        ImmutableList immutableListW0 = wifiConditionHandler2.w0(wifiConditionHandler2.s0(wifiConfigurationViewStateY.e(), arrayList));
        WifiConditionHandler wifiConditionHandler3 = this.f116008b;
        wifiConditionHandler3.s(WifiConfigurationViewState.d(wifiConfigurationViewStateY, Success.f128020a, false, false, null, null, wifiConditionHandler3.j0(immutableListW0, wifiConfigurationViewStateY.j()), immutableListW0, false, false, false, 922, null));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WifiConditionHandler$onWifiScanReceived$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
