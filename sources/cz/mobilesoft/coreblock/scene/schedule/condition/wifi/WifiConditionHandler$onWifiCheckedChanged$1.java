package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler$onWifiCheckedChanged$1", f = "WifiConditionViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class WifiConditionHandler$onWifiCheckedChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Wifi f116004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f116005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ WifiConditionHandler f116006d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WifiConditionHandler$onWifiCheckedChanged$1(Wifi wifi, boolean z2, WifiConditionHandler wifiConditionHandler, Continuation continuation) {
        super(2, continuation);
        this.f116004b = wifi;
        this.f116005c = z2;
        this.f116006d = wifiConditionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WifiConditionHandler$onWifiCheckedChanged$1(this.f116004b, this.f116005c, this.f116006d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f116003a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!this.f116004b.g() || this.f116005c) {
            WifiConfigurationViewState wifiConfigurationViewStateY = this.f116006d.Y();
            Set setPlus = this.f116005c ? SetsKt.plus(wifiConfigurationViewStateY.k(), this.f116004b.c()) : SetsKt.minus(wifiConfigurationViewStateY.k(), this.f116004b.c());
            Wifi wifiB = Wifi.b(this.f116004b, null, null, false, false, false, this.f116005c, 31, null);
            List mutableList = CollectionsKt.toMutableList((Collection) wifiConfigurationViewStateY.e());
            Wifi wifi = this.f116004b;
            boolean z2 = this.f116005c;
            int iIndexOf = wifiConfigurationViewStateY.e().indexOf(wifi);
            if (iIndexOf != -1) {
                mutableList.set(iIndexOf, wifiB);
            } else if (z2) {
                mutableList.add(0, wifiB);
            }
            ImmutableList immutableListH = ExtensionsKt.h(mutableList);
            this.f116006d.s(WifiConfigurationViewState.d(wifiConfigurationViewStateY, null, false, false, null, ExtensionsKt.j(setPlus), this.f116006d.j0(immutableListH, wifiConfigurationViewStateY.j()), immutableListH, false, false, false, 911, null));
        } else {
            this.f116006d.c(StrictModeTitleAlternatives.Companion.a());
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WifiConditionHandler$onWifiCheckedChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
