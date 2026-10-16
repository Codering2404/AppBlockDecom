package cz.mobilesoft.coreblock.scene.premium.superwall;

import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1", f = "SuperwallPlacementViewModel.kt", l = {258}, m = "invokeSuspend", v = 1)
final class SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f113834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f113835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f113836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f113837d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1(AtomicBoolean atomicBoolean, String str, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f113835b = atomicBoolean;
        this.f113836c = str;
        this.f113837d = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1(this.f113835b, this.f113836c, this.f113837d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f113834a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f113834a = 1;
            if (DelayKt.b(10000L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f113835b.set(true);
        SuperwallPlacementViewModel.f113807u.d(this.f113836c, "no answer from Superwall, falling back", new Pair[0]);
        this.f113837d.h(SuperwallPlacementViewEvent.OnPaywallFailed.f113803a);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
