package androidx.compose.ui.platform;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$3", f = "AndroidPlatformTextInputSession.android.kt", l = {184}, m = "invokeSuspend")
final class AndroidPlatformTextInputSession$startInputMethod$3 extends SuspendLambda implements Function2<InputMethodSession, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f27876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f27877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f27878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AndroidPlatformTextInputSession f27879d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidPlatformTextInputSession$startInputMethod$3(AndroidPlatformTextInputSession androidPlatformTextInputSession, Continuation continuation) {
        super(2, continuation);
        this.f27879d = androidPlatformTextInputSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AndroidPlatformTextInputSession$startInputMethod$3 androidPlatformTextInputSession$startInputMethod$3 = new AndroidPlatformTextInputSession$startInputMethod$3(this.f27879d, continuation);
        androidPlatformTextInputSession$startInputMethod$3.f27878c = obj;
        return androidPlatformTextInputSession$startInputMethod$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InputMethodSession inputMethodSession, Continuation continuation) {
        return ((AndroidPlatformTextInputSession$startInputMethod$3) create(inputMethodSession, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f27877b;
        if (i3 == 0) {
            ResultKt.b(obj);
            final InputMethodSession inputMethodSession = (InputMethodSession) this.f27878c;
            final AndroidPlatformTextInputSession androidPlatformTextInputSession = this.f27879d;
            this.f27878c = inputMethodSession;
            this.f27876a = androidPlatformTextInputSession;
            this.f27877b = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            androidPlatformTextInputSession.f27867b.e();
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Throwable) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    inputMethodSession.d();
                    androidPlatformTextInputSession.f27867b.f();
                }
            });
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (objV == objF) {
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
