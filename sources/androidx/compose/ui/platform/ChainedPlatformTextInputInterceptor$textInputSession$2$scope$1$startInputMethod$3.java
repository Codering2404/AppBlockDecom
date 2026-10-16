package androidx.compose.ui.platform;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3", f = "PlatformTextInputModifierNode.kt", l = {237}, m = "invokeSuspend")
final class ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3 extends SuspendLambda implements Function2<Unit, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f27949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ChainedPlatformTextInputInterceptor f27950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PlatformTextInputMethodRequest f27951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PlatformTextInputSessionScope f27952d;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3$2", f = "PlatformTextInputModifierNode.kt", l = {238}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<PlatformTextInputInterceptor, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PlatformTextInputMethodRequest f27956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PlatformTextInputSessionScope f27957d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PlatformTextInputMethodRequest platformTextInputMethodRequest, PlatformTextInputSessionScope platformTextInputSessionScope, Continuation continuation) {
            super(2, continuation);
            this.f27956c = platformTextInputMethodRequest;
            this.f27957d = platformTextInputSessionScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f27956c, this.f27957d, continuation);
            anonymousClass2.f27955b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PlatformTextInputInterceptor platformTextInputInterceptor, Continuation continuation) {
            return ((AnonymousClass2) create(platformTextInputInterceptor, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f27954a;
            if (i3 == 0) {
                ResultKt.b(obj);
                PlatformTextInputInterceptor platformTextInputInterceptor = (PlatformTextInputInterceptor) this.f27955b;
                PlatformTextInputMethodRequest platformTextInputMethodRequest = this.f27956c;
                PlatformTextInputSessionScope platformTextInputSessionScope = this.f27957d;
                this.f27954a = 1;
                if (platformTextInputInterceptor.a(platformTextInputMethodRequest, platformTextInputSessionScope, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3(ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, PlatformTextInputMethodRequest platformTextInputMethodRequest, PlatformTextInputSessionScope platformTextInputSessionScope, Continuation continuation) {
        super(2, continuation);
        this.f27950b = chainedPlatformTextInputInterceptor;
        this.f27951c = platformTextInputMethodRequest;
        this.f27952d = platformTextInputSessionScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3(this.f27950b, this.f27951c, this.f27952d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Unit unit, Continuation continuation) {
        return ((ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3) create(unit, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f27949a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor = this.f27950b;
            Flow flowQ = SnapshotStateKt.q(new Function0<PlatformTextInputInterceptor>() { // from class: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$3.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final PlatformTextInputInterceptor invoke() {
                    return chainedPlatformTextInputInterceptor.b();
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f27951c, this.f27952d, null);
            this.f27949a = 1;
            if (FlowKt.l(flowQ, anonymousClass2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new IllegalStateException("Interceptors flow should never terminate.");
    }
}
