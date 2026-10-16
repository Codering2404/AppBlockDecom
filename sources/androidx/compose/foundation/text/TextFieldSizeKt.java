package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldSizeKt {
    public static final Modifier a(Modifier modifier, final TextStyle textStyle) {
        return ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1
            {
                super(3);
            }

            private static final Object d(State state) {
                return state.getValue();
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(1582736677);
                if (ComposerKt.M()) {
                    ComposerKt.U(1582736677, i3, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
                }
                Density density = (Density) composer.q(CompositionLocalsKt.f());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.q(CompositionLocalsKt.h());
                LayoutDirection layoutDirection = (LayoutDirection) composer.q(CompositionLocalsKt.m());
                boolean Z = composer.Z(textStyle) | composer.Z(layoutDirection);
                TextStyle textStyle2 = textStyle;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = TextStyleKt.d(textStyle2, layoutDirection);
                    composer.w(objG);
                }
                TextStyle textStyle3 = (TextStyle) objG;
                boolean Z2 = composer.Z(resolver) | composer.Z(textStyle3);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    FontFamily fontFamilyL = textStyle3.l();
                    FontWeight fontWeightQ = textStyle3.q();
                    if (fontWeightQ == null) {
                        fontWeightQ = FontWeight.f29233b.g();
                    }
                    FontStyle fontStyleO = textStyle3.o();
                    int i4 = fontStyleO != null ? fontStyleO.i() : FontStyle.f29211b.b();
                    FontSynthesis fontSynthesisP = textStyle3.p();
                    objG2 = resolver.a(fontFamilyL, fontWeightQ, i4, fontSynthesisP != null ? fontSynthesisP.m() : FontSynthesis.f29215b.a());
                    composer.w(objG2);
                }
                State state = (State) objG2;
                TextStyle textStyle4 = textStyle;
                Object objG3 = composer.G();
                Composer.Companion companion = Composer.f23746a;
                if (objG3 == companion.a()) {
                    objG3 = new TextFieldSize(layoutDirection, density, resolver, textStyle4, d(state));
                    composer.w(objG3);
                }
                final TextFieldSize textFieldSize = (TextFieldSize) objG3;
                textFieldSize.c(layoutDirection, density, resolver, textStyle3, d(state));
                Modifier.Companion companion2 = Modifier.b8;
                boolean zI = composer.I(textFieldSize);
                Object objG4 = composer.G();
                if (zI || objG4 == companion.a()) {
                    objG4 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return m73invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                        }

                        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m73invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                            long jB = textFieldSize.b();
                            final Placeable placeableN0 = measurable.n0(Constraints.d(j3, RangesKt.p((int) (jB >> 32), Constraints.n(j3), Constraints.l(j3)), 0, RangesKt.p((int) (jB & 4294967295L), Constraints.m(j3), Constraints.k(j3)), 0, 10, null));
                            return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.f139807a;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    Placeable.PlacementScope.m(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composer.w(objG4);
                }
                Modifier modifierA = LayoutModifierKt.a(companion2, (Function3) objG4);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierA;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null);
    }
}
