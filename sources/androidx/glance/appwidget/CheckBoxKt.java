package androidx.glance.appwidget;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.action.Action;
import androidx.glance.action.ActionModifier;
import androidx.glance.appwidget.action.CompoundButtonAction;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CheckBoxKt {
    public static final void a(final boolean z2, final Action action, GlanceModifier glanceModifier, String str, TextStyle textStyle, CheckBoxColors checkBoxColors, int i3, Composer composer, final int i4, final int i5) {
        CheckBoxColors checkBoxColorsA;
        int i6;
        Composer composerK = composer.k(151986232);
        final GlanceModifier glanceModifier2 = (i5 & 4) != 0 ? GlanceModifier.f37605a : glanceModifier;
        final String str2 = (i5 & 8) != 0 ? "" : str;
        final TextStyle textStyle2 = (i5 & 16) != 0 ? null : textStyle;
        if ((i5 & 32) != 0) {
            i6 = i4 & (-458753);
            checkBoxColorsA = CheckboxDefaults.f37855a.a(composerK, 6);
        } else {
            checkBoxColorsA = checkBoxColors;
            i6 = i4;
        }
        int i7 = (i5 & 64) != 0 ? Integer.MAX_VALUE : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(151986232, i6, -1, "androidx.glance.appwidget.CheckBox (CheckBox.kt:62)");
        }
        d(z2, action, glanceModifier2, str2, textStyle2, checkBoxColorsA, i7, composerK, (i6 & 14) | 64 | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final CheckBoxColors checkBoxColors2 = checkBoxColorsA;
        final int i8 = i7;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBox$1
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
                CheckBoxKt.a(z2, action, glanceModifier2, str2, textStyle2, checkBoxColors2, i8, composer2, i4 | 1, i5);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final boolean r20, final kotlin.jvm.functions.Function0 r21, androidx.glance.GlanceModifier r22, java.lang.String r23, androidx.glance.text.TextStyle r24, androidx.glance.appwidget.CheckBoxColors r25, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.CheckBoxKt.b(boolean, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, java.lang.String, androidx.glance.text.TextStyle, androidx.glance.appwidget.CheckBoxColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final boolean r21, final kotlin.jvm.functions.Function0 r22, androidx.glance.GlanceModifier r23, java.lang.String r24, androidx.glance.text.TextStyle r25, androidx.glance.appwidget.CheckBoxColors r26, int r27, java.lang.String r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.CheckBoxKt.c(boolean, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, java.lang.String, androidx.glance.text.TextStyle, androidx.glance.appwidget.CheckBoxColors, int, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final boolean z2, final Action action, GlanceModifier glanceModifier, String str, TextStyle textStyle, CheckBoxColors checkBoxColors, int i3, Composer composer, final int i4, final int i5) {
        final CheckBoxColors checkBoxColorsA;
        int i6;
        Composer composerK = composer.k(-509269550);
        if ((i5 & 4) != 0) {
            glanceModifier = GlanceModifier.f37605a;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i5 & 8) != 0) {
            str = "";
        }
        final String str2 = str;
        final TextStyle textStyle2 = (i5 & 16) != 0 ? null : textStyle;
        if ((i5 & 32) != 0) {
            i6 = i4 & (-458753);
            checkBoxColorsA = CheckboxDefaults.f37855a.a(composerK, 6);
        } else {
            checkBoxColorsA = checkBoxColors;
            i6 = i4;
        }
        final int i7 = (i5 & 64) != 0 ? Integer.MAX_VALUE : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-509269550, i6, -1, "androidx.glance.appwidget.CheckBoxElement (CheckBox.kt:141)");
        }
        GlanceModifier glanceModifierA = action != null ? glanceModifier2.a(new ActionModifier(new CompoundButtonAction(action, z2))) : glanceModifier2;
        composerK.F(1157296644);
        boolean Z = composerK.Z(checkBoxColorsA);
        Object objG = composerK.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0<EmittableCheckBox>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final EmittableCheckBox invoke() {
                    return new EmittableCheckBox(checkBoxColorsA);
                }
            };
            composerK.w(objG);
        }
        composerK.Y();
        final Function0 function0 = (Function0) objG;
        composerK.F(-1115894518);
        composerK.F(1886828752);
        if (!(composerK.m() instanceof Applier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(new Function0<EmittableCheckBox>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$$inlined$GlanceNode$1
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
        Updater.e(composerA, Boolean.valueOf(z2), new Function2<EmittableCheckBox, Boolean, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$1
            public final void c(EmittableCheckBox emittableCheckBox, boolean z3) {
                emittableCheckBox.h(z3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, str2, new Function2<EmittableCheckBox, String, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$2
            public final void c(EmittableCheckBox emittableCheckBox, String str3) {
                emittableCheckBox.l(str3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, (String) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, glanceModifierA, new Function2<EmittableCheckBox, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$3
            public final void c(EmittableCheckBox emittableCheckBox, GlanceModifier glanceModifier3) {
                emittableCheckBox.b(glanceModifier3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, (GlanceModifier) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, textStyle2, new Function2<EmittableCheckBox, TextStyle, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$4
            public final void c(EmittableCheckBox emittableCheckBox, TextStyle textStyle3) {
                emittableCheckBox.k(textStyle3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, (TextStyle) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, checkBoxColorsA, new Function2<EmittableCheckBox, CheckBoxColors, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$5
            public final void c(EmittableCheckBox emittableCheckBox, CheckBoxColors checkBoxColors2) {
                emittableCheckBox.i(checkBoxColors2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, (CheckBoxColors) obj2);
                return Unit.f139807a;
            }
        });
        CheckBoxKt$CheckBoxElement$2$6 checkBoxKt$CheckBoxElement$2$6 = new Function2<EmittableCheckBox, Integer, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$2$6
            public final void c(EmittableCheckBox emittableCheckBox, int i8) {
                emittableCheckBox.j(i8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableCheckBox) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }
        };
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i7))) {
            composerA.w(Integer.valueOf(i7));
            composerA.p(Integer.valueOf(i7), checkBoxKt$CheckBoxElement$2$6);
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.CheckBoxKt$CheckBoxElement$3
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
                CheckBoxKt.d(z2, action, glanceModifier2, str2, textStyle2, checkBoxColorsA, i7, composer2, i4 | 1, i5);
            }
        });
    }
}
