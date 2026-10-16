package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

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
final class PathPropertyValues extends PropertyValues<List<? extends PathNode>> {
    public PathPropertyValues() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List e(float f3) {
        Object objPrevious;
        List listC = c();
        ListIterator listIterator = listC.listIterator(listC.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((Timestamp) objPrevious).f() <= f3) {
                break;
            }
        }
        Timestamp timestamp = (Timestamp) objPrevious;
        if (timestamp == null) {
            timestamp = (Timestamp) CollectionsKt.first(c());
        }
        float f4 = (f3 - timestamp.f()) / timestamp.b();
        if (timestamp.d() != 0) {
            int i3 = 0;
            while (f4 > 1.0f) {
                f4 -= 1.0f;
                i3++;
            }
            if (timestamp.e() == RepeatMode.f4053b && i3 % 2 != 0) {
                f4 = 1.0f - f4;
            }
        }
        PropertyValuesHolder propertyValuesHolderC = timestamp.c();
        Intrinsics.checkNotNull(propertyValuesHolderC, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderPath");
        return ((PropertyValuesHolderPath) propertyValuesHolderC).c(f4);
    }

    @Override // androidx.compose.animation.graphics.vector.PropertyValues
    public State b(Transition transition, String str, final int i3, Composer composer, int i4) {
        composer.a0(119461169);
        if (ComposerKt.M()) {
            ComposerKt.U(119461169, i4, -1, "androidx.compose.animation.graphics.vector.PathPropertyValues.createState (Animator.kt:228)");
        }
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.graphics.vector.PathPropertyValues$createState$timeState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer2, int i5) {
                composer2.a0(2115989621);
                if (ComposerKt.M()) {
                    ComposerKt.U(2115989621, i5, -1, "androidx.compose.animation.graphics.vector.PathPropertyValues.createState.<anonymous> (Animator.kt:232)");
                }
                FiniteAnimationSpec finiteAnimationSpecN = AnimationSpecKt.n(i3, 0, EasingKt.e(), 2, null);
                if (!((Boolean) segment.a()).booleanValue()) {
                    finiteAnimationSpecN = AnimatorAnimationSpecsKt.d(finiteAnimationSpecN, i3);
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer2.U();
                return finiteAnimationSpecN;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        };
        int i5 = (i4 & 14) | ((i4 << 3) & 896);
        TwoWayConverter twoWayConverterI = VectorConvertersKt.i(FloatCompanionObject.f140130a);
        int i6 = ((i5 << 3) & 7168) | (i5 & 14);
        boolean zBooleanValue = ((Boolean) transition.i()).booleanValue();
        composer.a0(-1210845840);
        if (ComposerKt.M()) {
            ComposerKt.U(-1210845840, 0, -1, "androidx.compose.animation.graphics.vector.PathPropertyValues.createState.<anonymous> (Animator.kt:237)");
        }
        float f3 = zBooleanValue ? i3 : 0.0f;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        Float fValueOf = Float.valueOf(f3);
        boolean zBooleanValue2 = ((Boolean) transition.q()).booleanValue();
        composer.a0(-1210845840);
        if (ComposerKt.M()) {
            ComposerKt.U(-1210845840, 0, -1, "androidx.compose.animation.graphics.vector.PathPropertyValues.createState.<anonymous> (Animator.kt:237)");
        }
        float f4 = zBooleanValue2 ? i3 : 0.0f;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        final State stateF = TransitionKt.f(transition, fValueOf, Float.valueOf(f4), (FiniteAnimationSpec) function3.invoke(transition.o(), composer, 0), twoWayConverterI, str, composer, (i6 & 14) | ((i6 << 6) & 458752));
        boolean Z = composer.Z(stateF) | ((((i4 & 7168) ^ 3072) > 2048 && composer.Z(this)) || (i4 & 3072) == 2048);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0<List<? extends PathNode>>() { // from class: androidx.compose.animation.graphics.vector.PathPropertyValues$createState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    return this.f4424a.e(((Number) stateF.getValue()).floatValue());
                }
            };
            composer.w(objG);
        }
        State stateE = SnapshotStateKt.e((Function0) objG);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateE;
    }
}
