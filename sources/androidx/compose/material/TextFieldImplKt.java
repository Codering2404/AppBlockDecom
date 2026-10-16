package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
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
public final class TextFieldImplKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f14744a = ConstraintsKt.a(0, 0, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f14745b = Dp.g(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f14746c = Dp.g(12);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Modifier f14747d;

    static {
        float f3 = 48;
        f14747d = SizeKt.a(Modifier.b8, Dp.g(f3), Dp.g(f3));
    }

    public static final void a(final TextFieldType textFieldType, final String str, final Function2 function2, final VisualTransformation visualTransformation, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, final boolean z2, final boolean z3, final boolean z4, final InteractionSource interactionSource, final PaddingValues paddingValues, final Shape shape, final TextFieldColors textFieldColors, final Function2 function26, Composer composer, final int i3, final int i4) {
        TextFieldType textFieldType2;
        int i5;
        Function2 function27;
        int i6;
        int i7;
        Composer composer2;
        Composer composerK = composer.k(341783750);
        if ((i3 & 6) == 0) {
            textFieldType2 = textFieldType;
            i5 = (composerK.Z(textFieldType2) ? 4 : 2) | i3;
        } else {
            textFieldType2 = textFieldType;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        int i8 = i3 & 384;
        int i9 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 == 0) {
            function27 = function2;
            i5 |= composerK.I(function27) ? 256 : 128;
        } else {
            function27 = function2;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(visualTransformation) ? 2048 : 1024;
        }
        int i10 = i3 & 24576;
        int i11 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (i10 == 0) {
            i5 |= composerK.I(function22) ? 16384 : 8192;
        }
        int i12 = i3 & 196608;
        int i13 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        if (i12 == 0) {
            i6 = 196608;
            i5 |= composerK.I(function23) ? 131072 : 65536;
        } else {
            i6 = 196608;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.I(function24) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(function25) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.b(z2) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.b(z3) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i7 = i4 | (composerK.b(z4) ? 4 : 2);
        } else {
            i7 = i4;
        }
        if ((i4 & 48) == 0) {
            i7 |= composerK.Z(interactionSource) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            if (composerK.Z(paddingValues)) {
                i9 = 256;
            }
            i7 |= i9;
        }
        if ((i4 & 3072) == 0) {
            i7 |= composerK.Z(shape) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            if (composerK.Z(textFieldColors)) {
                i11 = 16384;
            }
            i7 |= i11;
        }
        if ((i4 & i6) == 0) {
            if (composerK.I(function26)) {
                i13 = 131072;
            }
            i7 |= i13;
        }
        int i14 = i7;
        if ((i5 & 306783379) == 306783378 && (74899 & i14) == 74898 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(341783750, i5, i14, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:81)");
            }
            boolean z5 = ((i5 & 112) == 32) | ((i5 & 7168) == 2048);
            Object objG = composerK.G();
            if (z5 || objG == Composer.f23746a.a()) {
                objG = visualTransformation.a(new AnnotatedString(str, null, null, 6, null));
                composerK.w(objG);
            }
            final String strK = ((TransformedText) objG).b().k();
            InputPhase inputPhase = ((Boolean) FocusInteractionKt.a(interactionSource, composerK, (i14 >> 3) & 14).getValue()).booleanValue() ? InputPhase.Focused : strK.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            Function3<InputPhase, Composer, Integer, Color> function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final long c(InputPhase inputPhase2, Composer composer3, int i15) {
                    composer3.a0(-1272940975);
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1272940975, i15, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:94)");
                    }
                    long jB = ((Color) textFieldColors.h(z3, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z4, interactionSource, composer3, 0).getValue()).B();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer3.U();
                    return jB;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return Color.n(c((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                }
            };
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            Typography typographyC = materialTheme.c(composerK, 6);
            TextStyle textStyleL = typographyC.l();
            TextStyle textStyleD = typographyC.d();
            long j3 = textStyleL.j();
            Color.Companion companion = Color.f25715b;
            final boolean z6 = (Color.t(j3, companion.k()) && !Color.t(textStyleD.j(), companion.k())) || (!Color.t(textStyleL.j(), companion.k()) && Color.t(textStyleD.j(), companion.k()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.f14967a;
            composerK.a0(1578865765);
            long j4 = materialTheme.c(composerK, 6).d().j();
            if (z6) {
                composerK.a0(-1572851052);
                if (j4 == 16) {
                    j4 = ((Color) function3.invoke(inputPhase, composerK, 0)).B();
                }
            } else {
                composerK.a0(780548205);
            }
            composerK.U();
            long j5 = j4;
            composerK.U();
            composerK.a0(1578871879);
            long j6 = materialTheme.c(composerK, 6).l().j();
            if (z6) {
                composerK.a0(-1572659596);
                if (j6 == 16) {
                    j6 = ((Color) function3.invoke(inputPhase, composerK, 0)).B();
                }
            } else {
                composerK.a0(780554381);
            }
            composerK.U();
            long j7 = j6;
            composerK.U();
            boolean z7 = function22 != null;
            final TextFieldType textFieldType3 = textFieldType2;
            final Function2 function28 = function27;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(225557475, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f14766a;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        f14766a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(6);
                }

                public final void c(float f3, long j8, final long j9, final float f4, Composer composer3, int i15) {
                    int i16;
                    long j10;
                    boolean z8;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    ComposableLambda composableLambda3;
                    ComposableLambda composableLambda4;
                    final float f5 = f3;
                    if ((i15 & 6) == 0) {
                        i16 = (composer3.c(f5) ? 4 : 2) | i15;
                    } else {
                        i16 = i15;
                    }
                    if ((i15 & 48) == 0) {
                        j10 = j8;
                        i16 |= composer3.f(j10) ? 32 : 16;
                    } else {
                        j10 = j8;
                    }
                    if ((i15 & 384) == 0) {
                        i16 |= composer3.f(j9) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    }
                    if ((i15 & 3072) == 0) {
                        i16 |= composer3.c(f4) ? 2048 : 1024;
                    }
                    int i17 = i16;
                    if ((i17 & 9363) == 9362 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(225557475, i17, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:122)");
                    }
                    final Function2 function29 = function22;
                    if (function29 == null) {
                        composer3.a0(-1572365903);
                        composer3.U();
                        z8 = true;
                        composableLambda = null;
                    } else {
                        composer3.a0(-1572365902);
                        final boolean z9 = z6;
                        z8 = true;
                        final long j11 = j10;
                        Function2<Composer, Integer, Unit> function210 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i18) {
                                if ((i18 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1865025495, i18, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:124)");
                                }
                                MaterialTheme materialTheme2 = MaterialTheme.f13091a;
                                TextStyle textStyleC = TextStyleKt.c(materialTheme2.c(composer4, 6).l(), materialTheme2.c(composer4, 6).d(), f5);
                                boolean z10 = z9;
                                long j12 = j11;
                                if (z10) {
                                    textStyleC = TextStyle.e(textStyleC, j12, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                }
                                TextFieldImplKt.b(j9, textStyleC, null, function29, composer4, 384, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        };
                        f5 = f5;
                        ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(-1865025495, true, function210, composer3, 54);
                        composer3.U();
                        composableLambda = composableLambdaE2;
                    }
                    if (function23 == null || strK.length() != 0 || f4 <= 0.0f) {
                        composer3.a0(-1571160716);
                        composer3.U();
                        composableLambda2 = null;
                    } else {
                        composer3.a0(-1571586748);
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z10 = z3;
                        final Function2 function211 = function23;
                        ComposableLambda composableLambdaE3 = ComposableLambdaKt.e(-413527723, z8, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Modifier modifier, Composer composer4, int i18) {
                                if ((i18 & 6) == 0) {
                                    i18 |= composer4.Z(modifier) ? 4 : 2;
                                }
                                if ((i18 & 19) == 18 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-413527723, i18, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:140)");
                                }
                                Modifier modifierA = AlphaKt.a(modifier, f4);
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                boolean z11 = z10;
                                Function2 function212 = function211;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA = ComposablesKt.a(composer4, 0);
                                CompositionLocalMap compositionLocalMapU = composer4.u();
                                Modifier modifierF = ComposedModifierKt.f(composer4, modifierA);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                                Function0 function0A = companion2.a();
                                if (composer4.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer4.L();
                                if (composer4.i()) {
                                    composer4.P(function0A);
                                } else {
                                    composer4.v();
                                }
                                Composer composerA = Updater.a(composer4);
                                Updater.e(composerA, measurePolicyG, companion2.e());
                                Updater.e(composerA, compositionLocalMapU, companion2.g());
                                Function2 function2B = companion2.b();
                                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                    composerA.w(Integer.valueOf(iA));
                                    composerA.p(Integer.valueOf(iA), function2B);
                                }
                                Updater.e(composerA, modifierF, companion2.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                TextFieldImplKt.b(((Color) textFieldColors3.g(z11, composer4, 0).getValue()).B(), MaterialTheme.f13091a.c(composer4, 6).l(), null, function212, composer4, 0, 4);
                                composer4.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54);
                        composer3.U();
                        composableLambda2 = composableLambdaE3;
                    }
                    final long jB = ((Color) textFieldColors.d(z3, z4, interactionSource, composer3, 0).getValue()).B();
                    final Function2 function212 = function24;
                    if (function212 == null) {
                        composer3.a0(-1570983241);
                        composer3.U();
                        composableLambda3 = null;
                    } else {
                        composer3.a0(-1570983240);
                        ComposableLambda composableLambdaE4 = ComposableLambdaKt.e(-1165144581, z8, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i18) {
                                if ((i18 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1165144581, i18, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:153)");
                                }
                                TextFieldImplKt.b(jB, null, null, function212, composer4, 0, 6);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54);
                        composer3.U();
                        composableLambda3 = composableLambdaE4;
                    }
                    final long jB2 = ((Color) textFieldColors.j(z3, z4, interactionSource, composer3, 0).getValue()).B();
                    final Function2 function213 = function25;
                    if (function213 == null) {
                        composer3.a0(-1570681642);
                        composer3.U();
                        composableLambda4 = null;
                    } else {
                        composer3.a0(-1570681641);
                        ComposableLambda composableLambdaE5 = ComposableLambdaKt.e(1694126319, z8, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i18) {
                                if ((i18 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(1694126319, i18, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:160)");
                                }
                                TextFieldImplKt.b(jB2, null, null, function213, composer4, 0, 6);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54);
                        composer3.U();
                        composableLambda4 = composableLambdaE5;
                    }
                    Modifier modifierC = BackgroundKt.c(Modifier.b8, ((Color) textFieldColors.a(z3, composer3, 0).getValue()).B(), shape);
                    int i18 = WhenMappings.f14766a[textFieldType3.ordinal()];
                    if (i18 == z8) {
                        composer3.a0(-1570370153);
                        TextFieldKt.e(modifierC, function28, composableLambda, composableLambda2, composableLambda3, composableLambda4, z2, f3, paddingValues, composer3, (i17 << 21) & 29360128);
                        composer3.U();
                    } else if (i18 != 2) {
                        composer3.a0(-1568365383);
                        composer3.U();
                    } else {
                        composer3.a0(-1569791817);
                        Object objG2 = composer3.G();
                        Composer.Companion companion2 = Composer.f23746a;
                        if (objG2 == companion2.a()) {
                            objG2 = SnapshotStateKt__SnapshotStateKt.e(Size.c(Size.f25617b.b()), null, 2, null);
                            composer3.w(objG2);
                        }
                        final MutableState mutableState = (MutableState) objG2;
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function2 function214 = function26;
                        ComposableLambda composableLambdaE6 = ComposableLambdaKt.e(-1212965554, z8, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i19) {
                                if ((i19 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1212965554, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:185)");
                                }
                                Modifier modifierM = OutlinedTextFieldKt.m(LayoutIdKt.b(Modifier.b8, "border"), ((Size) mutableState.getValue()).m(), paddingValues2);
                                Function2 function215 = function214;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
                                int iA = ComposablesKt.a(composer4, 0);
                                CompositionLocalMap compositionLocalMapU = composer4.u();
                                Modifier modifierF = ComposedModifierKt.f(composer4, modifierM);
                                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                                Function0 function0A = companion3.a();
                                if (composer4.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer4.L();
                                if (composer4.i()) {
                                    composer4.P(function0A);
                                } else {
                                    composer4.v();
                                }
                                Composer composerA = Updater.a(composer4);
                                Updater.e(composerA, measurePolicyG, companion3.e());
                                Updater.e(composerA, compositionLocalMapU, companion3.g());
                                Function2 function2B = companion3.b();
                                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                    composerA.w(Integer.valueOf(iA));
                                    composerA.p(Integer.valueOf(iA), function2B);
                                }
                                Updater.e(composerA, modifierF, companion3.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                if (function215 == null) {
                                    composer4.a0(719996434);
                                } else {
                                    composer4.a0(-392416305);
                                    function215.invoke(composer4, 0);
                                }
                                composer4.U();
                                composer4.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54);
                        Function2 function215 = function28;
                        boolean z11 = false;
                        ComposableLambda composableLambda5 = composableLambda;
                        boolean z12 = z2;
                        if ((i17 & 14) == 4) {
                            z11 = true;
                        }
                        Object objG3 = composer3.G();
                        if (z11 || objG3 == companion2.a()) {
                            objG3 = new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final void c(long j12) {
                                    float fI = Size.i(j12) * f5;
                                    float fG = Size.g(j12) * f5;
                                    if (Size.i(((Size) mutableState.getValue()).m()) == fI && Size.g(((Size) mutableState.getValue()).m()) == fG) {
                                        return;
                                    }
                                    mutableState.setValue(Size.c(androidx.compose.ui.geometry.SizeKt.a(fI, fG)));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    c(((Size) obj).m());
                                    return Unit.f139807a;
                                }
                            };
                            composer3.w(objG3);
                        }
                        OutlinedTextFieldKt.e(modifierC, function215, composableLambda2, composableLambda5, composableLambda3, composableLambda4, z12, f5, (Function1) objG3, composableLambdaE6, paddingValues, composer3, ((i17 << 21) & 29360128) | 805306368, 0);
                        composer3.U();
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                    c(((Number) obj).floatValue(), ((Color) obj2).B(), ((Color) obj3).B(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54);
            composer2 = composerK;
            textFieldTransitionScope.a(inputPhase, j5, j7, function3, z7, composableLambdaE, composer2, 1769472);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i15) {
                    TextFieldImplKt.a(textFieldType, str, function2, visualTransformation, function22, function23, function24, function25, z2, z3, z4, interactionSource, paddingValues, shape, textFieldColors, function26, composer3, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    public static final void b(final long j3, TextStyle textStyle, Float f3, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        final Float f4;
        Composer composerK = composer.k(-399493340);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(textStyle) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            f4 = f3;
        } else {
            if (i6 != 0) {
                textStyle = null;
            }
            final Float f5 = i7 == 0 ? f3 : null;
            if (ComposerKt.M()) {
                ComposerKt.U(-399493340, i5, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:229)");
            }
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(494684590, i8, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:231)");
                    }
                    ProvidedValue providedValueD = ContentColorKt.a().d(Color.n(j3));
                    final Float f6 = f5;
                    final Function2 function22 = function2;
                    final long j4 = j3;
                    CompositionLocalKt.b(providedValueD, ComposableLambdaKt.e(-1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            if ((i9 & 3) == 2 && composer3.l()) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1132188434, i9, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:232)");
                            }
                            if (f6 != null) {
                                composer3.a0(-1178229056);
                                CompositionLocalKt.b(ContentAlphaKt.a().d(f6), function22, composer3, ProvidedValue.f24012i);
                                composer3.U();
                            } else {
                                composer3.a0(-1178050310);
                                CompositionLocalKt.b(ContentAlphaKt.a().d(Float.valueOf(Color.u(j4))), function22, composer3, ProvidedValue.f24012i);
                                composer3.U();
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.f24012i | 48);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54);
            if (textStyle != null) {
                composerK.a0(2115969060);
                TextKt.a(textStyle, composableLambdaE, composerK, ((i5 >> 3) & 14) | 48);
            } else {
                composerK.a0(2115970696);
                composableLambdaE.invoke(composerK, 6);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            f4 = f5;
        }
        final TextStyle textStyle2 = textStyle;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    TextFieldImplKt.b(j3, textStyle2, f4, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final Modifier c(Modifier modifier, boolean z2, final String str) {
        return z2 ? SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$defaultErrorSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.o(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final float d() {
        return f14746c;
    }

    public static final Modifier e() {
        return f14747d;
    }

    public static final Object f(IntrinsicMeasurable intrinsicMeasurable) {
        Object objP = intrinsicMeasurable.p();
        LayoutIdParentData layoutIdParentData = objP instanceof LayoutIdParentData ? (LayoutIdParentData) objP : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.Z0();
        }
        return null;
    }

    public static final float g() {
        return f14745b;
    }

    public static final long h() {
        return f14744a;
    }

    public static final int i(Placeable placeable) {
        if (placeable != null) {
            return placeable.O0();
        }
        return 0;
    }

    public static final int j(Placeable placeable) {
        if (placeable != null) {
            return placeable.X0();
        }
        return 0;
    }
}
