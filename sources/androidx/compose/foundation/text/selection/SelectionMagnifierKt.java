package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SelectionMagnifierKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AnimationVector2D f11401a = new AnimationVector2D(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TwoWayConverter f11402b = VectorConvertersKt.a(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1
        public final AnimationVector2D c(long j3) {
            return (9223372034707292159L & j3) != 9205357640488583168L ? new AnimationVector2D(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L))) : SelectionMagnifierKt.f11401a;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Offset) obj).u());
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2
        public final long c(AnimationVector2D animationVector2D) {
            float f3 = animationVector2D.f();
            float fG = animationVector2D.g();
            return Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fG)) & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.d(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f11403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SpringSpec f11404d;

    static {
        long jE = Offset.e((((long) Float.floatToRawIntBits(0.01f)) << 32) | (((long) Float.floatToRawIntBits(0.01f)) & 4294967295L));
        f11403c = jE;
        f11404d = new SpringSpec(0.0f, 0.0f, Offset.d(jE), 3, null);
    }

    public static final Modifier d(Modifier modifier, Function0 function0, Function1 function1) {
        return ComposedModifierKt.c(modifier, null, new SelectionMagnifierKt$animatedSelectionMagnifier$1(function0, function1), 1, null);
    }

    public static final SpringSpec e() {
        return f11404d;
    }

    public static final long f() {
        return f11403c;
    }

    public static final TwoWayConverter g() {
        return f11402b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State h(Function0 function0, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1589795249, i3, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:75)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt.e(function0);
            composer.w(objG);
        }
        State state = (State) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            Object animatable = new Animatable(Offset.d(i(state)), f11402b, Offset.d(f11403c), null, 8, null);
            composer.w(animatable);
            objG2 = animatable;
        }
        Animatable animatable2 = (Animatable) objG2;
        Unit unit = Unit.f139807a;
        boolean zI = composer.I(animatable2);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(state, animatable2, null);
            composer.w(objG3);
        }
        EffectsKt.g(unit, (Function2) objG3, composer, 6);
        State stateG = animatable2.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(State state) {
        return ((Offset) state.getValue()).u();
    }
}
