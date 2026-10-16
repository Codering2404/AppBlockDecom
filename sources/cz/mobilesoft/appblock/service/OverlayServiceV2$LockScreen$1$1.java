package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.scene.lockscreen.LockOverlayIntentState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$LockScreen$1$1", f = "OverlayServiceV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OverlayServiceV2$LockScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f94663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f94664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f94665d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LockViewModel f94666f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OverlayServiceV2$LockScreen$1$1(Function1 function1, Function0 function0, Function1 function12, LockViewModel lockViewModel, Continuation continuation) {
        super(2, continuation);
        this.f94663b = function1;
        this.f94664c = function0;
        this.f94665d = function12;
        this.f94666f = lockViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OverlayServiceV2$LockScreen$1$1(this.f94663b, this.f94664c, this.f94665d, this.f94666f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94662a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f94663b.invoke(new LockViewEvent.LockProviderInitFromServiceEvent((LockOverlayIntentState) this.f94664c.invoke()));
        this.f94665d.invoke(this.f94666f.Z0());
        PrefManager.f126839a.x1();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OverlayServiceV2$LockScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
