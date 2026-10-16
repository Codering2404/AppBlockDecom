package androidx.compose.ui.scrollcapture;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsProperties;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$scrollTracker$1", f = "ComposeScrollCaptureCallback.android.kt", l = {88}, m = "invokeSuspend")
final class ComposeScrollCaptureCallback$scrollTracker$1 extends SuspendLambda implements Function2<Float, Continuation<? super Float>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f28410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f28411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ float f28412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ComposeScrollCaptureCallback f28413d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeScrollCaptureCallback$scrollTracker$1(ComposeScrollCaptureCallback composeScrollCaptureCallback, Continuation continuation) {
        super(2, continuation);
        this.f28413d = composeScrollCaptureCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ComposeScrollCaptureCallback$scrollTracker$1 composeScrollCaptureCallback$scrollTracker$1 = new ComposeScrollCaptureCallback$scrollTracker$1(this.f28413d, continuation);
        composeScrollCaptureCallback$scrollTracker$1.f28412c = ((Number) obj).floatValue();
        return composeScrollCaptureCallback$scrollTracker$1;
    }

    public final Object h(float f3, Continuation continuation) {
        return ((ComposeScrollCaptureCallback$scrollTracker$1) create(Float.valueOf(f3), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((Number) obj).floatValue(), (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z2;
        float fIntBitsToFloat;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f28411b;
        if (i3 != 0) {
            if (i3 == 1) {
                z2 = this.f28410a;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            float f3 = this.f28412c;
            Function2 function2C = ScrollCapture_androidKt.c(this.f28413d.f28386a);
            if (function2C != null) {
                boolean zB = ((ScrollAxisRange) this.f28413d.f28386a.w().g(SemanticsProperties.f28517a.M())).b();
                if (zB) {
                    f3 = -f3;
                }
                Offset offsetD = Offset.d(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)));
                this.f28410a = zB;
                this.f28411b = 1;
                obj = function2C.invoke(offsetD, this);
                if (obj == objF) {
                    return objF;
                }
                z2 = zB;
            } else {
                InlineClassHelperKt.d(muQRKXGtpOhe.avBNH);
                throw new KotlinNothingValueException();
            }
        }
        long jU = ((Offset) obj).u();
        if (z2) {
            fIntBitsToFloat = -Float.intBitsToFloat((int) (jU & 4294967295L));
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (jU & 4294967295L));
        }
        return Boxing.c(fIntBitsToFloat);
    }
}
