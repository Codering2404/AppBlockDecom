package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public final class SheetDefaultsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f19844a = Dp.g(22);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AnimationSpec f19845b = AnimationSpecKt.n(300, 0, EasingKt.d(), 2, null);

    public static final NestedScrollConnection a(final SheetState sheetState, final Orientation orientation, final Function1 function1) {
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1
            private final float a(long j3) {
                return orientation == Orientation.f6032b ? Offset.m(j3) : Offset.n(j3);
            }

            private final long b(float f3) {
                Orientation orientation2 = orientation;
                float f4 = orientation2 == Orientation.f6032b ? f3 : 0.0f;
                if (orientation2 != Orientation.f6031a) {
                    f3 = 0.0f;
                }
                return OffsetKt.a(f4, f3);
            }

            private final float c(long j3) {
                return orientation == Orientation.f6032b ? Velocity.h(j3) : Velocity.i(j3);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            public long H0(long j3, long j4, int i3) {
                return NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) ? b(sheetState.d().n(a(j4))) : Offset.f25596b.c();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            public long J1(long j3, int i3) {
                float fA = a(j3);
                return (fA >= 0.0f || !NestedScrollSource.e(i3, NestedScrollSource.f26772b.b())) ? Offset.f25596b.c() : b(sheetState.d().n(fA));
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            public Object R1(long j3, Continuation continuation) {
                float fC = c(j3);
                float fN = sheetState.n();
                float fE = sheetState.d().o().e();
                if (fC >= 0.0f || fN <= fE) {
                    j3 = Velocity.f30015b.a();
                } else {
                    function1.invoke(Boxing.c(fC));
                }
                return Velocity.b(j3);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            public Object Y(long j3, long j4, Continuation continuation) {
                function1.invoke(Boxing.c(c(j4)));
                return Velocity.b(j4);
            }
        };
    }

    public static final SheetState d(boolean z2, Function1 function1, SheetValue sheetValue, boolean z3, Composer composer, int i3, int i4) {
        final boolean z4 = (i4 & 1) != 0 ? false : z2;
        if ((i4 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(SheetValue sheetValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        final Function1 function12 = function1;
        final SheetValue sheetValue2 = (i4 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        final boolean z5 = (i4 & 8) != 0 ? false : z3;
        if (ComposerKt.M()) {
            ComposerKt.U(1032784200, i3, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:407)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        Object[] objArr = {Boolean.valueOf(z4), function12, Boolean.valueOf(z5)};
        Saver saverA = SheetState.f19855d.a(z4, function12, density, z5);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.b(z4)) || (i3 & 6) == 4) | composer.Z(density) | ((((i3 & 896) ^ 384) > 256 && composer.Z(sheetValue2)) || (i3 & 384) == 256) | ((((i3 & 112) ^ 48) > 32 && composer.Z(function12)) || (i3 & 48) == 32) | ((((i3 & 7168) ^ 3072) > 2048 && composer.b(z5)) || (i3 & 3072) == 2048);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            Object obj = new Function0<SheetState>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final SheetState invoke() {
                    return new SheetState(z4, density, sheetValue2, function12, z5);
                }
            };
            composer.w(obj);
            objG = obj;
        }
        SheetState sheetState = (SheetState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sheetState;
    }
}
