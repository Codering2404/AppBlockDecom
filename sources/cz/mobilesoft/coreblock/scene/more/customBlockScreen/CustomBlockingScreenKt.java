package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CustomBlockingScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107068a;

        static {
            int[] iArr = new int[ConfigType.values().length];
            try {
                iArr[ConfigType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigType.ROTATING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfigType.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfigType.ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f107068a = iArr;
        }
    }

    public static final void B(final CustomBlockingViewState viewState, final Function1 onEvent, final Function0 onCloseClick, final Function1 onConfigClicked, Composer composer, final int i3) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Intrinsics.checkNotNullParameter(onConfigClicked, "onConfigClicked");
        Composer composerK = composer.k(-955530784);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onConfigClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-955530784, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreen (CustomBlockingScreen.kt:122)");
            }
            String strE = viewState.e();
            if (strE == null) {
                composerK.a0(826042562);
            } else {
                composerK.a0(826042563);
                if (viewState.c().isEmpty()) {
                    composerK.a0(-725499552);
                } else {
                    composerK.a0(-719709279);
                    boolean Z = composerK.Z(viewState.c()) | composerK.Z(strE);
                    Object objG = composerK.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        Iterator it = viewState.c().iterator();
                        int i6 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i5 = -1;
                                break;
                            } else {
                                if (Intrinsics.areEqual(((CustomBlockingScreenConfigEntity) it.next()).i(), strE)) {
                                    i5 = i6;
                                    break;
                                }
                                i6++;
                            }
                        }
                        objG = Integer.valueOf(RangesKt.f(i5, 0));
                        composerK.w(objG);
                    }
                    int iIntValue = ((Number) objG).intValue();
                    boolean z2 = (i4 & 14) == 4;
                    Object objG2 = composerK.G();
                    if (z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.b0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(CustomBlockingScreenKt.C(viewState));
                            }
                        };
                        composerK.w(objG2);
                    }
                    boolean z3 = false;
                    final PagerState pagerStateL = PagerStateKt.l(iIntValue, 0.0f, (Function0) objG2, composerK, 0, 2);
                    final int size = viewState.c().size();
                    final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity = (CustomBlockingScreenConfigEntity) viewState.c().get(pagerStateL.v() % size);
                    Object objG3 = composerK.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG3 == companion.a()) {
                        objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                        composerK.w(objG3);
                    }
                    final MutableState mutableState = (MutableState) objG3;
                    final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
                    final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
                    Object objG4 = composerK.G();
                    if (objG4 == companion.a()) {
                        objG4 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                        composerK.w(objG4);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) objG4;
                    boolean zI = composerK.I(coroutineScope) | composerK.Z(scaffoldStateG) | composerK.I(context);
                    Object objG5 = composerK.G();
                    if (zI || objG5 == companion.a()) {
                        objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.j0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CustomBlockingScreenKt.D(coroutineScope, scaffoldStateG, context);
                            }
                        };
                        composerK.w(objG5);
                    }
                    final Function0 function0 = (Function0) objG5;
                    String strB = StringResources_androidKt.b(R.string.v9, composerK, 0);
                    String strB2 = StringResources_androidKt.b(R.string.q9, composerK, 0);
                    String strB3 = StringResources_androidKt.b(R.string.di, composerK, 0);
                    if ((i4 & 112) == 32) {
                        z3 = true;
                    }
                    boolean Z2 = z3 | composerK.Z(customBlockingScreenConfigEntity);
                    Object objG6 = composerK.G();
                    if (Z2 || objG6 == companion.a()) {
                        objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.k0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CustomBlockingScreenKt.E(onEvent, customBlockingScreenConfigEntity);
                            }
                        };
                        composerK.w(objG6);
                    }
                    ComposeDialogsKt.x0(mutableState, strB, null, null, strB2, 0L, false, (Function0) objG6, strB3, 0L, null, composerK, 6, 0, 1644);
                    ScaffoldKt.a(null, scaffoldStateG, ComposableLambdaKt.e(-1908586366, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.l0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomBlockingScreenKt.F(viewState, customBlockingScreenConfigEntity, onCloseClick, onEvent, onConfigClicked, function0, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerK, 54), ComposableLambdaKt.e(-111135903, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.m0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomBlockingScreenKt.G(viewState, customBlockingScreenConfigEntity, mutableState, onConfigClicked, function0, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerK, 54), ComposableSingletons$CustomBlockingScreenKt.f107054a.d(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1998604393, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.n0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomBlockingScreenKt.H(viewState, pagerStateL, customBlockingScreenConfigEntity, size, onConfigClicked, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerK, 54), composerK, 28032, 12582912, 131041);
                    composerK = composerK;
                }
                composerK.U();
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomBlockingScreenKt.I(viewState, onEvent, onCloseClick, onConfigClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(CustomBlockingViewState customBlockingViewState) {
        return customBlockingViewState.c().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(CoroutineScope coroutineScope, ScaffoldState scaffoldState, Context context) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new CustomBlockingScreenKt$CustomBlockingScreen$1$onBlockedByStrictMode$1$1$1(scaffoldState, context, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        function1.invoke(new CustomBlockingViewEvent.OnConfigDeleted(customBlockingScreenConfigEntity));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(CustomBlockingViewState customBlockingViewState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1908586366, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreen.<anonymous>.<anonymous> (CustomBlockingScreen.kt:164)");
            }
            Q(customBlockingViewState, customBlockingScreenConfigEntity, function0, function1, function12, function02, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(CustomBlockingViewState customBlockingViewState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, MutableState mutableState, Function1 function1, Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-111135903, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreen.<anonymous>.<anonymous> (CustomBlockingScreen.kt:184)");
            }
            J(customBlockingViewState, customBlockingScreenConfigEntity, mutableState, function1, function0, composer, 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(CustomBlockingViewState customBlockingViewState, PagerState pagerState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, int i3, Function1 function1, PaddingValues it, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i4 & 6) == 0) {
            i4 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1998604393, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreen.<anonymous>.<anonymous> (CustomBlockingScreen.kt:174)");
            }
            b0(customBlockingViewState, it, pagerState, customBlockingScreenConfigEntity, i3, function1, composer, (i4 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(CustomBlockingViewState customBlockingViewState, Function1 function1, Function0 function0, Function1 function12, int i3, Composer composer, int i4) {
        B(customBlockingViewState, function1, function0, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void J(final cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState r44, final cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r45, final androidx.compose.runtime.MutableState r46, final kotlin.jvm.functions.Function1 r47, kotlin.jvm.functions.Function0 r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreenKt.J(cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function1 function1, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        function1.invoke(customBlockingScreenConfigEntity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(boolean z2, MutableState mutableState, Function0 function0) {
        if (z2) {
            mutableState.setValue(Boolean.TRUE);
        } else {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(boolean z2, Function1 function1, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Context context) {
        if (z2) {
            function1.invoke(customBlockingScreenConfigEntity);
        } else {
            i0(context);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(boolean z2, Function1 function1, Context context) {
        if (z2) {
            function1.invoke(null);
        } else {
            i0(context);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(CustomBlockingViewState customBlockingViewState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, MutableState mutableState, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        J(customBlockingViewState, customBlockingScreenConfigEntity, mutableState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Q(final cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState r21, final cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r22, final kotlin.jvm.functions.Function0 r23, final kotlin.jvm.functions.Function1 r24, final kotlin.jvm.functions.Function1 r25, kotlin.jvm.functions.Function0 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreenKt.Q(cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1772364881, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreenTopBar.<anonymous> (CustomBlockingScreen.kt:326)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composer, 0).b(), StringResources_androidKt.b(R.string.N7, composer, 0), function0, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, CustomBlockingViewState customBlockingViewState, Function1 function1, Function1 function12, boolean z2, boolean z3, long j3, Function0 function0, RowScope TopAppBar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1718262598, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreenTopBar.<anonymous> (CustomBlockingScreen.kt:334)");
            }
            if (customBlockingScreenConfigEntity.m() == ConfigType.ADD || Intrinsics.areEqual(customBlockingScreenConfigEntity.i(), customBlockingViewState.e())) {
                composer.a0(-1356014776);
            } else {
                composer.a0(-1340693584);
                e0(customBlockingScreenConfigEntity, function1, function12, z2, z3, j3, customBlockingScreenConfigEntity.l() >= customBlockingViewState.d(), function0, composer, 0, 0);
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
    public static final Unit U(CustomBlockingViewState customBlockingViewState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function0 function0, Function1 function1, Function1 function12, Function0 function02, int i3, int i4, Composer composer, int i5) {
        Q(customBlockingViewState, customBlockingScreenConfigEntity, function0, function1, function12, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void V(final CustomBlockingViewState customBlockingViewState, final int i3, final int i4, final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, final Function1 function1, Composer composer, final int i5) throws XmlPullParserException, IOException {
        int i6;
        Composer composer2;
        long j3;
        int i7;
        Modifier.Companion companion;
        Composer composer3;
        int i8;
        int i9;
        long jY;
        int i10;
        Composer composerK = composer.k(-379480332);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(customBlockingViewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.e(i4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.Z(customBlockingScreenConfigEntity) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i6 & 9363) != 9362, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-379480332, i6, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.PageContent (CustomBlockingScreen.kt:472)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity2 = (CustomBlockingScreenConfigEntity) customBlockingViewState.c().get(i3 % i4);
            int i11 = WhenMappings.f107068a[customBlockingScreenConfigEntity2.m().ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                composerK.a0(-744159040);
                LockViewState lockViewState = new LockViewState(null, StringResources_androidKt.c(R.string.Kt, new Object[]{"Instagram"}, composerK, 0), 0, 0, false, 0, false, false, false, false, true, false, false, null, false, StringHelper.h(StringResources_androidKt.c(R.string.Y3, new Object[]{StringResources_androidKt.b(R.string.Y4, composerK, 0)}, composerK, 0)).toString(), StringResources_androidKt.b(R.string.M0, composerK, 0), StringResources_androidKt.c(R.string.d4, new Object[]{2, 23}, composerK, 0), null, null, null, null, false, null, ContextCompat.getDrawable(context, R.drawable.O2), customBlockingScreenConfigEntity.l() > 0, customBlockingScreenConfigEntity.l() > 0 ? String.valueOf(customBlockingScreenConfigEntity.l()) : "", 0.0f, false, false, false, customBlockingScreenConfigEntity2, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, 2029812733, 7, null);
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomBlockingScreenKt.W((LockViewEvent) obj);
                        }
                    };
                    composerK.w(objG);
                }
                LockScreenKt.D(lockViewState, (Function1) objG, true, false, null, composerK, 432, 24);
                composer2 = composerK;
                composer2.U();
                Unit unit = Unit.f139807a;
            } else {
                if (i11 != 4) {
                    composerK.a0(391636570);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(-742936400);
                final long jM = ComposeColorsKt.j(composerK, 0).M();
                Modifier.Companion companion2 = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion2, 0.0f, 1, null);
                if (customBlockingViewState.g()) {
                    composerK.a0(391680547);
                    j3 = ComposeColorsKt.j(composerK, 0).X();
                    composerK.U();
                } else {
                    composerK.a0(391681407);
                    composerK.U();
                    j3 = Color.f25715b.j();
                }
                long j4 = j3;
                boolean z2 = true;
                float f3 = 24;
                Modifier modifierC = BackgroundKt.c(modifierF, j4, RoundedCornerShapeKt.d(Dp.g(f3)));
                boolean z3 = !customBlockingViewState.g();
                boolean zF = composerK.f(jM);
                Object objG2 = composerK.G();
                if (zF || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.d0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomBlockingScreenKt.X(jM, (Modifier) obj);
                        }
                    };
                    composerK.w(objG2);
                }
                Modifier modifierR = ComposableExtKt.r(modifierC, z3, (Function1) objG2);
                Alignment.Companion companion3 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierR);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A = companion4.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyG, companion4.e());
                Updater.e(composerA, compositionLocalMapU, companion4.g());
                Function2 function2B = companion4.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                if (customBlockingViewState.g()) {
                    i7 = i6;
                    companion = companion2;
                    composer3 = composerK;
                    i8 = 4;
                    composer3.a0(-1668714361);
                } else {
                    composerK.a0(-1645387016);
                    Modifier modifierA = ClipKt.a(SizeKt.f(companion2, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f3)));
                    if (DarkThemeKt.a(composerK, 0)) {
                        composerK.a0(-1577090383);
                        i10 = R.drawable.N1;
                    } else {
                        composerK.a0(-1577088462);
                        i10 = R.drawable.O1;
                    }
                    Painter painterC = PainterResources_androidKt.c(i10, composerK, 0);
                    composerK.U();
                    composer3 = composerK;
                    companion = companion2;
                    z2 = true;
                    i7 = i6;
                    i8 = 4;
                    ImageKt.a(painterC, null, modifierA, null, ContentScale.f27054a.a(), 0.0f, null, composer3, 24624, 104);
                }
                composer3.U();
                Modifier modifierA2 = ClipKt.a(boxScopeInstance.f(companion, companion3.e()), RoundedCornerShapeKt.g());
                boolean z4 = (i7 & 14) == i8 ? z2 : false;
                if ((i7 & 57344) != 16384) {
                    z2 = false;
                }
                boolean zI = z4 | z2 | composer3.I(context);
                Object objG3 = composer3.G();
                if (zI || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CustomBlockingScreenKt.Z(customBlockingViewState, function1, context);
                        }
                    };
                    composer3.w(objG3);
                }
                Modifier modifierF3 = ClickableKt.f(modifierA2, false, null, null, (Function0) objG3, 7, null);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95554q0, composer3, 6);
                if (customBlockingViewState.g()) {
                    composer3.a0(-1577058015);
                    i9 = 0;
                    jY = ComposeColorsKt.j(composer3, 0).b();
                } else {
                    i9 = 0;
                    composer3.a0(-1577057406);
                    jY = ComposeColorsKt.j(composer3, 0).Y();
                }
                composer3.U();
                Composer composer4 = composer3;
                IconCircleBackgroundKt.c(modifierF3, Dp.g(48), 0.0f, imageVectorB, ComposeColorsKt.j(composer3, i9).q0(), jY, null, composer4, 48, 68);
                composer2 = composer4;
                composer2.y();
                composer2.U();
                Unit unit2 = Unit.f139807a;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomBlockingScreenKt.a0(customBlockingViewState, i3, i4, customBlockingScreenConfigEntity, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier X(final long j3, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return DrawModifierKt.b(applyIf, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenKt.Y(j3, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(long j3, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        float fM1 = drawBehind.M1(Dp.g(1));
        float fM12 = drawBehind.M1(Dp.g(24));
        PathEffect pathEffectA = PathEffect.f25832a.a(new float[]{10.0f, 10.0f}, 0.0f);
        float f3 = fM1 / 2;
        long jE = Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawBehind.b() >> 32)) - fM1;
        DrawScope.f2(drawBehind, j3, jE, Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawBehind.b() & 4294967295L)) - fM1)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), CornerRadius.b((((long) Float.floatToRawIntBits(fM12)) << 32) | (((long) Float.floatToRawIntBits(fM12)) & 4294967295L)), new Stroke(fM1, 0.0f, 0, 0, pathEffectA, 14, null), 0.0f, null, 0, 224, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(CustomBlockingViewState customBlockingViewState, Function1 function1, Context context) {
        if (customBlockingViewState.g()) {
            function1.invoke(null);
        } else {
            i0(context);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(CustomBlockingViewState customBlockingViewState, int i3, int i4, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function1 function1, int i5, Composer composer, int i6) throws XmlPullParserException, IOException {
        V(customBlockingViewState, i3, i4, customBlockingScreenConfigEntity, function1, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    private static final void b0(final CustomBlockingViewState customBlockingViewState, final PaddingValues paddingValues, final PagerState pagerState, final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, final int i3, final Function1 function1, Composer composer, final int i4) {
        int i5;
        int i6;
        Composer composerK = composer.k(-111219708);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(customBlockingViewState) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.Z(pagerState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.Z(customBlockingScreenConfigEntity) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-111219708, i5, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.RootCompose (CustomBlockingScreen.kt:415)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.h(companion, paddingValues), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            Color.Companion companion2 = Color.f25715b;
            Modifier modifierD = BackgroundKt.d(modifierM, companion2.j(), null, 2, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i7 = i5;
            PagerKt.a(pagerState, BackgroundKt.d(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), companion2.j(), null, 2, null), PaddingKt.c(Dp.g(40), 0.0f, 2, null), null, 1, Dp.g(24), null, null, false, false, null, null, null, null, ComposableLambdaKt.e(457025389, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.z
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CustomBlockingScreenKt.c0(customBlockingViewState, i3, customBlockingScreenConfigEntity, function1, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, ((i5 >> 6) & 14) | 221568, 24576, 16328);
            int i8 = WhenMappings.f107068a[customBlockingScreenConfigEntity.m().ordinal()];
            if (i8 == 1) {
                i6 = R.string.b3;
            } else if (i8 == 2) {
                i6 = R.string.Ic;
            } else {
                if (i8 != 3 && i8 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                i6 = R.string.N8;
            }
            TextKt.c(StringResources_androidKt.b(i6, composerK, 0), columnScopeInstance.c(PaddingKt.m(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), companion3.g()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65532);
            composerK = composerK;
            PremiumReviewsCarouselCardKt.o(i3, pagerState, columnScopeInstance.c(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null), companion3.g()), composerK, ((i7 >> 12) & 14) | ((i7 >> 3) & 112), 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomBlockingScreenKt.d0(customBlockingViewState, paddingValues, pagerState, customBlockingScreenConfigEntity, i3, function1, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(CustomBlockingViewState customBlockingViewState, int i3, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function1 function1, PagerScope HorizontalPager, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(457025389, i5, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.RootCompose.<anonymous>.<anonymous> (CustomBlockingScreen.kt:431)");
        }
        V(customBlockingViewState, i4, i3, customBlockingScreenConfigEntity, function1, composer, i5 & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(CustomBlockingViewState customBlockingViewState, PaddingValues paddingValues, PagerState pagerState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, int i3, Function1 function1, int i4, Composer composer, int i5) {
        b0(customBlockingViewState, paddingValues, pagerState, customBlockingScreenConfigEntity, i3, function1, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void e0(final cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r26, final kotlin.jvm.functions.Function1 r27, final kotlin.jvm.functions.Function1 r28, boolean r29, boolean r30, long r31, boolean r33, kotlin.jvm.functions.Function0 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingScreenKt.e0(cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, boolean, long, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function1 function1, boolean z2, Context context, Function1 function12) {
        int i3 = WhenMappings.f107068a[customBlockingScreenConfigEntity.m().ordinal()];
        if (i3 == 1 || i3 == 2) {
            AnswersHelper.f128199a.x1();
            function1.invoke(new CustomBlockingViewEvent.OnConfigSelected(customBlockingScreenConfigEntity.i()));
        } else if (i3 != 3) {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (z2) {
                function12.invoke(null);
            } else {
                i0(context);
            }
        } else if (z2) {
            AnswersHelper.f128199a.x1();
            function1.invoke(new CustomBlockingViewEvent.OnConfigSelected(customBlockingScreenConfigEntity.i()));
        } else {
            i0(context);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function1 function1, Function1 function12, boolean z2, boolean z3, long j3, boolean z4, Function0 function0, int i3, int i4, Composer composer, int i5) {
        e0(customBlockingScreenConfigEntity, function1, function12, z2, z3, j3, z4, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void i0(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.CUSTOM_BLOCK_SCREEN), "profile_tab", "custom_block_screen", false, false, false, null, 240, null));
    }
}
