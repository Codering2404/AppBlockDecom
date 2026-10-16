package androidx.compose.ui.scrollcapture;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
final class RelativeScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f28417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f28418c;

    public RelativeScroller(int i3, Function2 function2) {
        this.f28416a = i3;
        this.f28417b = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(float r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = (androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1) r0
            int r1 = r0.f28422d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f28422d = r1
            goto L18
        L13:
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = new androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f28420b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f28422d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f28419a
            androidx.compose.ui.scrollcapture.RelativeScroller r5 = (androidx.compose.ui.scrollcapture.RelativeScroller) r5
            kotlin.ResultKt.b(r6)
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.functions.Function2 r6 = r4.f28417b
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r5)
            r0.f28419a = r4
            r0.f28422d = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r0 = r5.f28418c
            float r0 = r0 + r6
            r5.f28418c = r0
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.RelativeScroller.e(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float b() {
        return this.f28418c;
    }

    public final int c(int i3) {
        return RangesKt.p(i3 - MathKt.d(this.f28418c), 0, this.f28416a);
    }

    public final void d() {
        this.f28418c = 0.0f;
    }

    public final Object f(int i3, int i4, Continuation continuation) throws Throwable {
        if (i3 > i4) {
            throw new IllegalArgumentException(("Expected min=" + i3 + " ≤ max=" + i4).toString());
        }
        int i5 = i4 - i3;
        int i6 = this.f28416a;
        if (i5 > i6) {
            throw new IllegalArgumentException(("Expected range (" + i5 + ") to be ≤ viewportSize=" + this.f28416a).toString());
        }
        float f3 = i3;
        float f4 = this.f28418c;
        if (f3 >= f4 && i4 <= i6 + f4) {
            return Unit.f139807a;
        }
        if (f3 >= f4) {
            i3 = i4 - i6;
        }
        Object objG = g(i3, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final Object g(float f3, Continuation continuation) throws Throwable {
        Object objE = e(f3 - this.f28418c, continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }
}
