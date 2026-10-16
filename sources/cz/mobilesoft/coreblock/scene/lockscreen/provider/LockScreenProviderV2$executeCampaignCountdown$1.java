package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$executeCampaignCountdown$1;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$executeCampaignCountdown$1", f = "LockScreenProviderV2.kt", l = {731}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$executeCampaignCountdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105829b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$executeCampaignCountdown$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LockScreenProviderV2 f105830a;

        AnonymousClass1(LockScreenProviderV2 lockScreenProviderV2) {
            this.f105830a = lockScreenProviderV2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockViewState f(boolean z2, String str, LockViewState updateViewState) {
            Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
            return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, z2, z2, !z2, str, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -15361, 15, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Long l3, Continuation continuation) {
            final String string;
            final boolean z2 = l3 == null || l3.longValue() == 0;
            if ((l3 != null ? l3.longValue() : 0L) > Constants.f128444b) {
                string = this.f105830a.f105775b.getString(R.string.D9, this.f105830a.f105775b.getString(R.string.f95790f1));
            } else {
                string = this.f105830a.f105775b.getString(R.string.J4, this.f105830a.f105775b.getString(R.string.f95790f1), this.f105830a.o0(), DateHelper.l(this.f105830a.f105775b, l3 != null ? l3.longValue() : 0L, true));
            }
            Intrinsics.checkNotNull(string);
            this.f105830a.V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LockScreenProviderV2$executeCampaignCountdown$1.AnonymousClass1.f(z2, string, (LockViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$executeCampaignCountdown$1(LockScreenProviderV2 lockScreenProviderV2, Continuation continuation) {
        super(2, continuation);
        this.f105829b = lockScreenProviderV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$executeCampaignCountdown$1(this.f105829b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105828a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f105829b.f105796x;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f105829b);
            this.f105828a = 1;
            if (mutableStateFlow.collect(anonymousClass1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$executeCampaignCountdown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
