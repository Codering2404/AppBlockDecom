package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$12;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$12", f = "LockScreenProviderV2.kt", l = {491}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105850b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$12$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LockScreenProviderV2 f105851a;

        AnonymousClass1(LockScreenProviderV2 lockScreenProviderV2) {
            this.f105851a = lockScreenProviderV2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockViewState f(Set set, LockViewState updateViewState) {
            Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
            return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, set, null, false, null, -1, 14, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final Set set, Continuation continuation) {
            this.f105851a.V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LockScreenProviderV2$init$12.AnonymousClass1.f(set, (LockViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$12(LockScreenProviderV2 lockScreenProviderV2, Continuation continuation) {
        super(2, continuation);
        this.f105850b = lockScreenProviderV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$12(this.f105850b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105849a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowM0 = this.f105850b.q0().m0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f105850b);
            this.f105849a = 1;
            if (flowM0.collect(anonymousClass1, this) == objF) {
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
        return ((LockScreenProviderV2$init$12) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
