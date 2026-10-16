package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

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
public final class HeightInLinesModifierKt {
    public static final Modifier a(Modifier modifier, final TextStyle textStyle, final int i3, final int i4) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("heightInLines");
                inspectorInfo.b().c("minLines", Integer.valueOf(i3));
                inspectorInfo.b().c("maxLines", Integer.valueOf(i4));
                inspectorInfo.b().c("textStyle", textStyle);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            private static final Object d(State state) {
                return state.getValue();
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i5) {
                composer.a0(408240218);
                if (ComposerKt.M()) {
                    ComposerKt.U(408240218, i5, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:62)");
                }
                HeightInLinesModifierKt.b(i3, i4);
                if (i3 == 1 && i4 == Integer.MAX_VALUE) {
                    Modifier.Companion companion = Modifier.b8;
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer.U();
                    return companion;
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
                    int i6 = fontStyleO != null ? fontStyleO.i() : FontStyle.f29211b.b();
                    FontSynthesis fontSynthesisP = textStyle3.p();
                    objG2 = resolver.a(fontFamilyL, fontWeightQ, i6, fontSynthesisP != null ? fontSynthesisP.m() : FontSynthesis.f29215b.a());
                    composer.w(objG2);
                }
                State state = (State) objG2;
                boolean Z3 = composer.Z(d(state)) | composer.Z(density) | composer.Z(resolver) | composer.Z(textStyle) | composer.Z(layoutDirection);
                Object objG3 = composer.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = Integer.valueOf((int) (TextFieldDelegateKt.a(textStyle3, density, resolver, TextFieldDelegateKt.c(), 1) & 4294967295L));
                    composer.w(objG3);
                }
                int iIntValue = ((Number) objG3).intValue();
                boolean Z4 = composer.Z(layoutDirection) | composer.Z(density) | composer.Z(resolver) | composer.Z(textStyle) | composer.Z(d(state));
                Object objG4 = composer.G();
                if (Z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = Integer.valueOf((int) (TextFieldDelegateKt.a(textStyle3, density, resolver, TextFieldDelegateKt.c() + '\n' + TextFieldDelegateKt.c(), 2) & 4294967295L));
                    composer.w(objG4);
                }
                int iIntValue2 = ((Number) objG4).intValue() - iIntValue;
                int i7 = i3;
                Integer numValueOf = i7 == 1 ? null : Integer.valueOf(((i7 - 1) * iIntValue2) + iIntValue);
                int i8 = i4;
                Integer numValueOf2 = i8 != Integer.MAX_VALUE ? Integer.valueOf(iIntValue + (iIntValue2 * (i8 - 1))) : null;
                Modifier modifierJ = SizeKt.j(Modifier.b8, numValueOf != null ? density.F(numValueOf.intValue()) : Dp.f29970b.c(), numValueOf2 != null ? density.F(numValueOf2.intValue()) : Dp.f29970b.c());
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierJ;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static final void b(int i3, int i4) {
        if (!(i3 > 0 && i4 > 0)) {
            InlineClassHelperKt.a("both minLines " + i3 + " and maxLines " + i4 + " must be greater than zero");
        }
        if (i3 <= i4) {
            return;
        }
        InlineClassHelperKt.a("minLines " + i3 + " must be less than or equal to maxLines " + i4);
    }
}
