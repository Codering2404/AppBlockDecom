package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt$LockScreen$1$1", f = "LockScreen.kt", l = {125}, m = "invokeSuspend", v = 1)
final class LockScreenKt$LockScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f105390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f105391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f105392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockViewState f105393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f105394f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenKt$LockScreen$1$1(LockViewState lockViewState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f105393d = lockViewState;
        this.f105394f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenKt$LockScreen$1$1(this.f105393d, this.f105394f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean zL;
        boolean z2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105392c;
        if (i3 == 0) {
            ResultKt.b(obj);
            zL = this.f105393d.l();
            boolean zT = this.f105393d.t();
            this.f105390a = zL;
            this.f105391b = zT;
            this.f105392c = 1;
            if (DelayKt.b(250L, this) == objF) {
                return objF;
            }
            z2 = zT;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = this.f105391b;
            zL = this.f105390a;
            ResultKt.b(obj);
        }
        if (zL && z2) {
            LockScreenKt.o0(this.f105394f, true);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenKt$LockScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
