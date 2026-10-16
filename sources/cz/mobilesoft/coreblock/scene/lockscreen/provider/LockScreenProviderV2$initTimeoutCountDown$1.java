package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$initTimeoutCountDown$1", f = "LockScreenProviderV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$initTimeoutCountDown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f105902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ double f105904d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$initTimeoutCountDown$1(LockScreenProviderV2 lockScreenProviderV2, double d3, Continuation continuation) {
        super(2, continuation);
        this.f105903c = lockScreenProviderV2;
        this.f105904d = d3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState A(LockViewState lockViewState) {
        return LockViewState.b(lockViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -100663297, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState z(long j3, long j4, float f3, LockViewState lockViewState) {
        return LockViewState.b(lockViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, j3 > 0, String.valueOf(j4), f3, false, false, false, null, null, null, false, null, -234881025, 15, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockScreenProviderV2$initTimeoutCountDown$1 lockScreenProviderV2$initTimeoutCountDown$1 = new LockScreenProviderV2$initTimeoutCountDown$1(this.f105903c, this.f105904d, continuation);
        lockScreenProviderV2$initTimeoutCountDown$1.f105902b = obj;
        return lockScreenProviderV2$initTimeoutCountDown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Long l3 = (Long) this.f105902b;
        IntrinsicsKt.f();
        if (this.f105901a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (l3 != null) {
            double d3 = this.f105904d;
            LockScreenProviderV2 lockScreenProviderV2 = this.f105903c;
            final long jLongValue = l3.longValue();
            final long seconds = TimeUnit.MILLISECONDS.toSeconds(jLongValue);
            final float f3 = seconds / ((float) d3);
            lockScreenProviderV2.V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LockScreenProviderV2$initTimeoutCountDown$1.z(jLongValue, seconds, f3, (LockViewState) obj2);
                }
            });
        } else {
            this.f105903c.V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LockScreenProviderV2$initTimeoutCountDown$1.A((LockViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((LockScreenProviderV2$initTimeoutCountDown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
