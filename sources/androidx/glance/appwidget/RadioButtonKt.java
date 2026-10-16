package androidx.glance.appwidget;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.text.TextStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RadioButtonKt {
    public static final void a(final boolean z2, final Action action, GlanceModifier glanceModifier, boolean z3, String str, TextStyle textStyle, RadioButtonColors radioButtonColors, int i3, Composer composer, final int i4, final int i5) {
        final RadioButtonColors radioButtonColorsA;
        int i6;
        Composer composerK = composer.k(-1703226720);
        GlanceModifier glanceModifier2 = (i5 & 4) != 0 ? GlanceModifier.f37605a : glanceModifier;
        boolean z4 = (i5 & 8) != 0 ? true : z3;
        final String str2 = (i5 & 16) != 0 ? "" : str;
        final TextStyle textStyle2 = (i5 & 32) != 0 ? null : textStyle;
        if ((i5 & 64) != 0) {
            i6 = i4 & (-3670017);
            radioButtonColorsA = RadioButtonDefaults.f38359a.a(composerK, 6);
        } else {
            radioButtonColorsA = radioButtonColors;
            i6 = i4;
        }
        final int i7 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-1703226720, i6, -1, "androidx.glance.appwidget.RadioButton (RadioButton.kt:88)");
        }
        d(z2, action, glanceModifier2, z4, str2, textStyle2, radioButtonColorsA, i7, composerK, (i6 & 14) | 64 | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final GlanceModifier glanceModifier3 = glanceModifier2;
        final boolean z5 = z4;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButton$1
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
                RadioButtonKt.a(z2, action, glanceModifier3, z5, str2, textStyle2, radioButtonColorsA, i7, composer2, i4 | 1, i5);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final boolean r23, final kotlin.jvm.functions.Function0 r24, androidx.glance.GlanceModifier r25, boolean r26, java.lang.String r27, androidx.glance.text.TextStyle r28, androidx.glance.appwidget.RadioButtonColors r29, int r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.RadioButtonKt.b(boolean, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, boolean, java.lang.String, androidx.glance.text.TextStyle, androidx.glance.appwidget.RadioButtonColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final boolean r23, final kotlin.jvm.functions.Function0 r24, androidx.glance.GlanceModifier r25, boolean r26, java.lang.String r27, androidx.glance.text.TextStyle r28, androidx.glance.appwidget.RadioButtonColors r29, int r30, java.lang.String r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.RadioButtonKt.c(boolean, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, boolean, java.lang.String, androidx.glance.text.TextStyle, androidx.glance.appwidget.RadioButtonColors, int, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final boolean f(GlanceModifier glanceModifier) {
        return glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.RadioButtonKt$isSelectableGroup$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(element instanceof SelectableGroupModifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final boolean z2, final Action action, GlanceModifier glanceModifier, boolean z3, String str, TextStyle textStyle, RadioButtonColors radioButtonColors, int i3, Composer composer, int i4, final int i5) {
        int i6;
        Composer composerK = composer.k(354884190);
        final GlanceModifier glanceModifier2 = (i5 & 4) != 0 ? GlanceModifier.f37605a : glanceModifier;
        final boolean z4 = (i5 & 8) != 0 ? true : z3;
        final String str2 = (i5 & 16) != 0 ? "" : str;
        final TextStyle textStyle2 = (i5 & 32) != 0 ? null : textStyle;
        final RadioButtonColors radioButtonColorsA = (i5 & 64) != 0 ? RadioButtonDefaults.f38359a.a(composerK, 6) : radioButtonColors;
        final int i7 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : i3;
        if (ComposerKt.M()) {
            i6 = i4;
            ComposerKt.U(354884190, i6, -1, HcgZcEUYo.CqQftcbNsJLT);
        } else {
            i6 = i4;
        }
        GlanceModifier glanceModifierA = (!z4 || action == null) ? glanceModifier2 : ActionKt.a(glanceModifier2, action);
        final Function0<EmittableRadioButton> function0 = new Function0<EmittableRadioButton>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final EmittableRadioButton invoke() {
                return new EmittableRadioButton(radioButtonColorsA);
            }
        };
        composerK.F(-1115894518);
        composerK.F(1886828752);
        if (!(composerK.m() instanceof Applier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(new Function0<EmittableRadioButton>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$$inlined$GlanceNode$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return function0.invoke();
                }
            });
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.e(composerA, Boolean.valueOf(z2), new Function2<EmittableRadioButton, Boolean, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$1
            public final void c(EmittableRadioButton emittableRadioButton, boolean z5) {
                emittableRadioButton.i(z5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, glanceModifierA, new Function2<EmittableRadioButton, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$2
            public final void c(EmittableRadioButton emittableRadioButton, GlanceModifier glanceModifier3) {
                emittableRadioButton.b(glanceModifier3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, (GlanceModifier) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z4), new Function2<EmittableRadioButton, Boolean, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$3
            public final void c(EmittableRadioButton emittableRadioButton, boolean z5) {
                emittableRadioButton.k(z5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, str2, new Function2<EmittableRadioButton, String, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$4
            public final void c(EmittableRadioButton emittableRadioButton, String str3) {
                emittableRadioButton.n(str3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, (String) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, textStyle2, new Function2<EmittableRadioButton, TextStyle, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$5
            public final void c(EmittableRadioButton emittableRadioButton, TextStyle textStyle3) {
                emittableRadioButton.m(textStyle3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, (TextStyle) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, radioButtonColorsA, new Function2<EmittableRadioButton, RadioButtonColors, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$6
            public final void c(EmittableRadioButton emittableRadioButton, RadioButtonColors radioButtonColors2) {
                emittableRadioButton.j(radioButtonColors2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, (RadioButtonColors) obj2);
                return Unit.f139807a;
            }
        });
        RadioButtonKt$RadioButtonElement$2$7 radioButtonKt$RadioButtonElement$2$7 = new Function2<EmittableRadioButton, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$7
            public final void c(EmittableRadioButton emittableRadioButton, int i8) {
                emittableRadioButton.l(i8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableRadioButton) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }
        };
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i7))) {
            composerA.w(Integer.valueOf(i7));
            composerA.p(Integer.valueOf(i7), radioButtonKt$RadioButtonElement$2$7);
        }
        composerK.y();
        composerK.Y();
        composerK.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final int i8 = i6;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i9) {
                RadioButtonKt.d(z2, action, glanceModifier2, z4, str2, textStyle2, radioButtonColorsA, i7, composer2, i8 | 1, i5);
            }
        });
    }
}
