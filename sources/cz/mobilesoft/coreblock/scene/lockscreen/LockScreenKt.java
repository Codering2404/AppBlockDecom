package cz.mobilesoft.coreblock.scene.lockscreen;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.DynamicLockScreen;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.LockScreensComponentsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D(final cz.mobilesoft.coreblock.scene.lockscreen.LockViewState r40, final kotlin.jvm.functions.Function1 r41, boolean r42, boolean r43, androidx.compose.foundation.layout.PaddingValues r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt.D(cz.mobilesoft.coreblock.scene.lockscreen.LockViewState, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final DynamicLockScreen E(MutableState mutableState) {
        return (DynamicLockScreen) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(boolean z2, LockViewState lockViewState, final Function1 function1, Composer composer, int i3) {
        int i4;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(588164755, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous> (LockScreen.kt:155)");
            }
            if (z2) {
                composer.a0(-1457056401);
            } else {
                composer.a0(-1450219165);
                Alignment.Horizontal horizontalG = Alignment.f25072a.g();
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierD = BackgroundKt.d(companion, ComposeColorsKt.j(composer, 0).H(), null, 2, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A);
                } else {
                    composer.v();
                }
                Composer composerA = Updater.a(composer);
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                if (lockViewState.D()) {
                    composer.a0(400547618);
                    float f3 = (float) 0.5d;
                    BoxKt.a(BorderKt.g(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), Dp.g(f3), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 4, null), composer, 0);
                    boolean Z = composer.Z(function1);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.z0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LockScreenKt.G(function1);
                            }
                        };
                        composer.w(objG);
                    }
                    i4 = 393432126;
                    ButtonKt.c((Function0) objG, PaddingKt.k(companion, 0.0f, Dp.g(16), 1, null), false, null, null, null, null, null, null, ComposableSingletons$LockScreenKt.f105329a.h(), composer, 805306416, 508);
                } else {
                    i4 = 393432126;
                    composer.a0(393432126);
                }
                composer.U();
                if (!lockViewState.u() || lockViewState.c() == null) {
                    composer.a0(i4);
                } else {
                    composer.a0(402173382);
                    LockScreensComponentsKt.f(SizeKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(60), 0.0f, 2, null), lockViewState.c(), composer, 6);
                }
                composer.U();
                composer.y();
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenAvailableSettingsClickEvent.f105463a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:218:0x08af  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x08b7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08f7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0931  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0a03  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0c87  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0c8f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0ccc  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0cd2  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0cd7  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0cda  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0d9c  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0da1  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0daa  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0e99  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0f65  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x1001  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x100b  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x1051  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x105b  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x10a5  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x11f6  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x1208  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x1275  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x1285  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r45v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v63 */
    /* JADX WARN: Type inference failed for: r6v64 */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit H(final cz.mobilesoft.coreblock.scene.lockscreen.LockViewState r45, final boolean r46, boolean r47, androidx.compose.foundation.ScrollState r48, final kotlin.jvm.functions.Function1 r49, final androidx.compose.runtime.MutableState r50, final androidx.compose.runtime.MutableState r51, androidx.compose.runtime.MutableFloatState r52, androidx.compose.runtime.MutableState r53, final android.content.Context r54, androidx.compose.foundation.layout.PaddingValues r55, androidx.compose.runtime.Composer r56, int r57) {
        /*
            Method dump skipped, instruction units count: 4751
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt.H(cz.mobilesoft.coreblock.scene.lockscreen.LockViewState, boolean, boolean, androidx.compose.foundation.ScrollState, kotlin.jvm.functions.Function1, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.MutableState, android.content.Context, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableFloatState mutableFloatState, LayoutCoordinates coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        mutableFloatState.s(Float.intBitsToFloat((int) (LayoutCoordinatesKt.f(coords) & 4294967295L)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(MutableFloatState mutableFloatState, LayoutCoordinates coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        mutableFloatState.s((int) (coords.a() >> 32));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier K(List list, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, MutableFloatState mutableFloatState3, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        Brush.Companion companion = Brush.Companion;
        float fC = mutableFloatState.c() / 2.0f;
        float fC2 = mutableFloatState2.c() - mutableFloatState3.c();
        return BackgroundKt.b(applyIf, Brush.Companion.h(companion, list, Offset.e((((long) Float.floatToRawIntBits(fC)) << 32) | (((long) Float.floatToRawIntBits(fC2)) & 4294967295L)), mutableFloatState.c() * 0.35f, 0, 8, null), RectangleShapeKt.a(), 0.0f, 4, null);
    }

    private static final boolean L(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void M(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenCloseButtonClickEvent.f105467a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        q0(mutableState, IntOffset.c(IntOffset.f((((long) ((int) Float.intBitsToFloat((int) (LayoutCoordinatesKt.f(coordinates) >> 32)))) << 32) | (((long) ((int) Float.intBitsToFloat((int) (LayoutCoordinatesKt.f(coordinates) & 4294967295L)))) & 4294967295L))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier P(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.m(applyIf, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier Q(long j3, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BackgroundKt.c(applyIf, j3, RoundedCornerShapeKt.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1, MutableState mutableState) {
        o0(mutableState, false);
        function1.invoke(LockViewEvent.LockScreenCustomBlockCreateNowClickEvent.f105470a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(MutableState mutableState) {
        M(mutableState, !L(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(MutableState mutableState) {
        M(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(final LockViewState lockViewState, final Function1 function1, ColumnScope DropdownMenu, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(14840455, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LockScreen.kt:361)");
            }
            if (lockViewState.y()) {
                composer.a0(-269464841);
                boolean zL = lockViewState.l();
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.a1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LockScreenKt.V(function1);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                AndroidMenu_androidKt.c((Function0) objG, null, zL, null, null, ComposableLambdaKt.e(1318725791, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.b1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return LockScreenKt.W(lockViewState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer2, 196608, 26);
            } else {
                composer2 = composer;
                composer2.a0(-289380357);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        AnswersHelper.f128199a.F2();
        function1.invoke(new LockViewEvent.LockScreenContactSupportClickEvent(ContactReason.Other, false, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(LockViewState lockViewState, RowScope DropdownMenuItem, Composer composer, int i3) {
        long jM;
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1318725791, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LockScreen.kt:369)");
            }
            String strB = StringResources_androidKt.b(R.string.i8, composer, 0);
            if (lockViewState.l()) {
                composer.a0(280142115);
                jM = ComposeColorsKt.j(composer, 0).L();
            } else {
                composer.a0(280142667);
                jM = ComposeColorsKt.j(composer, 0).M();
            }
            composer.U();
            TextKt.c(strB, null, jM, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(MutableFloatState mutableFloatState, LayoutCoordinates coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        mutableFloatState.s(Float.intBitsToFloat((int) (LayoutCoordinatesKt.f(coords) & 4294967295L)) + (((int) (coords.a() & 4294967295L)) / 2.0f));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(LockViewState lockViewState, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-415892875, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LockScreen.kt:551)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 4;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null);
            String strD = lockViewState.d();
            long jR = Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextStyle textStyleB = materialTheme.c(composer, i4).b();
            TextAlign.Companion companion2 = TextAlign.f29616b;
            TextKt.c(strD, modifierM, jR, 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, textStyleB, composer, 48, 0, 65016);
            TextKt.c(lockViewState.H(), PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            TextKt.c(lockViewState.I(), companion, Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).b(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenInAppUpdateCardClickEvent.f105472a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenCampaignCardClickEvent.f105466a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(MutableState mutableState, final MutableState mutableState2, Context context, LockViewState lockViewState, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1280879685, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous>.<anonymous>.<anonymous> (LockScreen.kt:758)");
        }
        IntOffset intOffsetP0 = p0(mutableState);
        int iL = intOffsetP0 != null ? IntOffset.l(intOffsetP0.r()) : 150;
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
        Object objG = composer.G();
        Composer.Companion companion2 = Composer.f23746a;
        if (objG == companion2.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LockScreenKt.i0(mutableState2);
                }
            };
            composer.w(objG);
        }
        Modifier modifierD = ClickableKt.d(modifierF, null, null, false, null, null, (Function0) objG, 28, null);
        Alignment.Companion companion3 = Alignment.f25072a;
        MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF2 = ComposedModifierKt.f(composer, modifierD);
        ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
        Function0 function0A = companion4.a();
        if (composer.m() == null) {
            ComposablesKt.c();
        }
        composer.L();
        if (composer.i()) {
            composer.P(function0A);
        } else {
            composer.v();
        }
        Composer composerA = Updater.a(composer);
        Updater.e(composerA, measurePolicyG, companion4.e());
        Updater.e(composerA, compositionLocalMapU, companion4.g());
        Function2 function2B = companion4.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF2, companion4.f());
        Modifier modifierM = PaddingKt.m(BoxScopeInstance.f6642a.f(companion, companion3.o()), Dp.g(16), Dp.g(Dp.g(iL / context.getResources().getDisplayMetrics().density) + Dp.g(48)), 0.0f, 0.0f, 12, null);
        int i4 = lockViewState.B() ? 42 : 4;
        Object objG2 = composer.G();
        if (objG2 == companion2.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LockScreenKt.j0(mutableState2);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean Z = composer.Z(function1);
        Object objG3 = composer.G();
        if (Z || objG3 == companion2.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.e1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LockScreenKt.k0(function1, mutableState2);
                }
            };
            composer.w(objG3);
        }
        CustomBlockScreenPopupKt.e(function0, (Function0) objG3, modifierM, i4, 0, composer, 6, 16);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(MutableState mutableState) {
        o0(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(MutableState mutableState) {
        o0(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(Function1 function1, MutableState mutableState) {
        o0(mutableState, false);
        function1.invoke(LockViewEvent.LockScreenCustomBlockCreateNowClickEvent.f105470a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(LockViewState lockViewState, Function1 function1, boolean z2, boolean z3, PaddingValues paddingValues, int i3, int i4, Composer composer, int i5) {
        D(lockViewState, function1, z2, z3, paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(MutableState mutableState, DynamicLockScreen dynamicLockScreen) {
        mutableState.setValue(dynamicLockScreen);
    }

    private static final boolean n0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final IntOffset p0(MutableState mutableState) {
        return (IntOffset) mutableState.getValue();
    }

    private static final void q0(MutableState mutableState, IntOffset intOffset) {
        mutableState.setValue(intOffset);
    }
}
