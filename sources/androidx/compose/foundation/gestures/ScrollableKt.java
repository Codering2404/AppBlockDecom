package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ScrollableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f6082a = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.valueOf(!PointerType.h(pointerInputChange.n(), PointerType.f26922b.b()));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ScrollScope f6083b = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float d(float f3) {
            return f3;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MotionDurationScale f6084c = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public Object fold(Object obj, Function2 function2) {
            return MotionDurationScale.DefaultImpls.a(this, obj, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext.Element get(CoroutineContext.Key key) {
            return MotionDurationScale.DefaultImpls.b(this, key);
        }

        @Override // androidx.compose.ui.MotionDurationScale
        public float k() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key key) {
            return MotionDurationScale.DefaultImpls.c(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.d(this, coroutineContext);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ScrollableKt$UnityDensity$1 f6085d = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }
    };

    public static final MotionDurationScale f() {
        return f6084c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(FlingBehavior flingBehavior) {
        return false;
    }

    public static final Modifier h(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z2, z3, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    public static final Modifier i(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return j(modifier, scrollableState, orientation, null, z2, z3, flingBehavior, mutableInteractionSource, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
    }

    public static /* synthetic */ Modifier j(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i3, Object obj) {
        BringIntoViewSpec bringIntoViewSpec2;
        Modifier modifier2;
        ScrollableState scrollableState2;
        Orientation orientation2;
        OverscrollEffect overscrollEffect2;
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        boolean z5 = (i3 & 16) != 0 ? false : z3;
        FlingBehavior flingBehavior2 = (i3 & 32) != 0 ? null : flingBehavior;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 64) != 0 ? null : mutableInteractionSource;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            bringIntoViewSpec2 = null;
            modifier2 = modifier;
            orientation2 = orientation;
            overscrollEffect2 = overscrollEffect;
            scrollableState2 = scrollableState;
        } else {
            bringIntoViewSpec2 = bringIntoViewSpec;
            modifier2 = modifier;
            scrollableState2 = scrollableState;
            orientation2 = orientation;
            overscrollEffect2 = overscrollEffect;
        }
        return h(modifier2, scrollableState2, orientation2, overscrollEffect2, z4, z5, flingBehavior2, mutableInteractionSource2, bringIntoViewSpec2);
    }

    public static /* synthetic */ Modifier k(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        return i(modifier, scrollableState, orientation, z4, z3, (i3 & 16) != 0 ? null : flingBehavior, (i3 & 32) != 0 ? null : mutableInteractionSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object l(androidx.compose.foundation.gestures.ScrollingLogic r10, long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1) r0
            int r1 = r0.f6090d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6090d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f6089c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6090d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r10 = r0.f6088b
            kotlin.jvm.internal.Ref$FloatRef r10 = (kotlin.jvm.internal.Ref.FloatRef) r10
            java.lang.Object r11 = r0.f6087a
            androidx.compose.foundation.gestures.ScrollingLogic r11 = (androidx.compose.foundation.gestures.ScrollingLogic) r11
            kotlin.ResultKt.b(r13)
            r8 = r10
            r10 = r11
            goto L5b
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.b(r13)
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.f5071a
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2 r4 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2
            r9 = 0
            r5 = r10
            r6 = r11
            r4.<init>(r5, r6, r8, r9)
            r0.f6087a = r5
            r0.f6088b = r8
            r0.f6090d = r3
            java.lang.Object r10 = r5.z(r13, r4, r0)
            if (r10 != r1) goto L5a
            return r1
        L5a:
            r10 = r5
        L5b:
            float r11 = r8.f140141a
            long r10 = r10.G(r11)
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.d(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.l(androidx.compose.foundation.gestures.ScrollingLogic, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
