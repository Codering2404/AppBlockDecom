package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$startWatchingForRequiredServices$2", f = "InitOverlayForegroundService.kt", l = {423}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$startWatchingForRequiredServices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InitOverlayForegroundService f94195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f94196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f94197d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitOverlayForegroundService$startWatchingForRequiredServices$2(InitOverlayForegroundService initOverlayForegroundService, AtomicBoolean atomicBoolean, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f94195b = initOverlayForegroundService;
        this.f94196c = atomicBoolean;
        this.f94197d = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(AtomicBoolean atomicBoolean, Function0 function0) {
        atomicBoolean.set(true);
        function0.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitOverlayForegroundService$startWatchingForRequiredServices$2(this.f94195b, this.f94196c, this.f94197d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94194a;
        if (i3 == 0) {
            ResultKt.b(obj);
            InitOverlayForegroundService initOverlayForegroundService = this.f94195b;
            EventDataStore eventDataStore = initOverlayForegroundService.f94155b;
            Flow flowG0 = eventDataStore != null ? eventDataStore.G0() : null;
            final AtomicBoolean atomicBoolean = this.f94196c;
            final Function0 function0 = this.f94197d;
            Function0 function02 = new Function0() { // from class: cz.mobilesoft.appblock.service.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InitOverlayForegroundService$startWatchingForRequiredServices$2.q(atomicBoolean, function0);
                }
            };
            this.f94194a = 1;
            if (initOverlayForegroundService.H(flowG0, "accessibility", function02, this) == objF) {
                return objF;
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
        return ((InitOverlayForegroundService$startWatchingForRequiredServices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
