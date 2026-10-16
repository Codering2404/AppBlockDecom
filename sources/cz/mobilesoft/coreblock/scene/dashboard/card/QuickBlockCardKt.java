package cz.mobilesoft.coreblock.scene.dashboard.card;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorMatrix;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewEvent;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeLoadingDotsKt;
import cz.mobilesoft.coreblock.view.compose.ComposePlaceHoldersKt;
import cz.mobilesoft.coreblock.view.compose.IconClusterKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class QuickBlockCardKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f100439a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f100439a = iArr;
        }
    }

    public static final void A0(boolean z2, final PomodoroSession session, final PomodoroSession.SessionMode sessionMode, final Function1 onEvent, final Function0 function0, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        Function0 function02;
        final boolean z4;
        long jS;
        AnnotatedString.Builder builder;
        long jS2;
        int iS;
        long jS3;
        long jS4;
        long jS5;
        long jS6;
        long jS7;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(sessionMode, "sessionMode");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1648545246);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(session) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(sessionMode) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            function02 = function0;
            i5 |= composerK.I(function02) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function02 = function0;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (i6 != 0) {
                z3 = true;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1648545246, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.PomodoroContent (QuickBlockCard.kt:756)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (sessionMode instanceof PomodoroSession.SessionMode.Focus) {
                composerK.a0(1748679334);
                long jU = ComposeColorsKt.j(composerK, 0).u();
                int i7 = R.drawable.J5;
                if (z3) {
                    composerK.a0(1441887818);
                    jS5 = ComposeColorsKt.j(composerK, 0).p();
                } else {
                    composerK.a0(1441888619);
                    jS5 = ComposeColorsKt.j(composerK, 0).s();
                }
                composerK.U();
                j0(jU, jS5, i7, function02, composerK, (i5 >> 3) & 7168);
                composerK = composerK;
                composerK.a0(1441893194);
                builder = new AnnotatedString.Builder(0, 1, null);
                composerK.a0(1441894629);
                if (z3) {
                    composerK.a0(-1227968238);
                    jS6 = ComposeColorsKt.j(composerK, 0).p();
                } else {
                    composerK.a0(-1227967437);
                    jS6 = ComposeColorsKt.j(composerK, 0).s();
                }
                composerK.U();
                iS = builder.s(new SpanStyle(jS6, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.l(StringResources_androidKt.b(R.string.jo, composerK, 0));
                    Unit unit = Unit.f139807a;
                    builder.q(iS);
                    composerK.U();
                    AnnotatedString annotatedStringT = builder.t();
                    composerK.U();
                    if (z3) {
                        composerK.a0(1441903236);
                        jS7 = ComposeColorsKt.j(composerK, 0).b();
                    } else {
                        composerK.a0(1441903851);
                        jS7 = ComposeColorsKt.j(composerK, 0).s();
                    }
                    composerK.U();
                    B1(annotatedStringT, sessionMode.d(), jS7, composerK, 0, 0);
                    composerK.U();
                } finally {
                }
            } else {
                composerK.a0(1749486977);
                if (z3) {
                    composerK.a0(1441910020);
                    jS = ComposeColorsKt.j(composerK, 0).b();
                } else {
                    composerK.a0(1441910635);
                    jS = ComposeColorsKt.j(composerK, 0).s();
                }
                composerK.U();
                int i8 = R.drawable.k4;
                long jQ0 = ComposeColorsKt.j(composerK, 0).q0();
                boolean z5 = (i5 & 7168) == 2048;
                Object objG = composerK.G();
                if (z5 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.m0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.B0(onEvent);
                        }
                    };
                    composerK.w(objG);
                }
                j0(jS, jQ0, i8, (Function0) objG, composerK, 0);
                composerK = composerK;
                composerK.a0(1441920284);
                builder = new AnnotatedString.Builder(0, 1, null);
                composerK.a0(1441921237);
                if (z3) {
                    composerK.a0(-2048663961);
                    jS2 = ComposeColorsKt.j(composerK, 0).p();
                } else {
                    composerK.a0(-2048663160);
                    jS2 = ComposeColorsKt.j(composerK, 0).s();
                }
                composerK.U();
                iS = builder.s(new SpanStyle(jS2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.l(StringResources_androidKt.b(R.string.jo, composerK, 0));
                    Unit unit2 = Unit.f139807a;
                    builder.q(iS);
                    composerK.U();
                    composerK.a0(1441927710);
                    if (z3) {
                        composerK.a0(-2048657528);
                        jS3 = ComposeColorsKt.j(composerK, 0).q();
                    } else {
                        composerK.a0(-2048656696);
                        jS3 = ComposeColorsKt.j(composerK, 0).s();
                    }
                    composerK.U();
                    iS = builder.s(new SpanStyle(jS3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                    try {
                        builder.l(" • ");
                        builder.l(StringResources_androidKt.b(R.string.ko, composerK, 0));
                        builder.q(iS);
                        composerK.U();
                        AnnotatedString annotatedStringT2 = builder.t();
                        composerK.U();
                        if (z3) {
                            composerK.a0(1441939147);
                            jS4 = ComposeColorsKt.j(composerK, 0).q();
                        } else {
                            composerK.a0(1441939979);
                            jS4 = ComposeColorsKt.j(composerK, 0).s();
                        }
                        composerK.U();
                        B1(annotatedStringT2, sessionMode.d(), jS4, composerK, 0, 0);
                        composerK.U();
                    } finally {
                    }
                } finally {
                }
            }
            composerK.y();
            boolean z6 = z3;
            D0(z6, session, sessionMode.d(), composerK, i5 & 126, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z6;
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.C0(z4, session, sessionMode, onEvent, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(boolean z2, Modifier modifier, long j3, long j4, long j5, float f3, int i3, int i4, Composer composer, int i5) {
        z1(z2, modifier, j3, j4, j5, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1) {
        function1.invoke(QuickBlockViewEvent.OnPomodoroBreakSkip.f100563a);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void B1(final androidx.compose.ui.text.AnnotatedString r36, final long r37, long r39, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt.B1(androidx.compose.ui.text.AnnotatedString, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(boolean z2, PomodoroSession pomodoroSession, PomodoroSession.SessionMode sessionMode, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        A0(z2, pomodoroSession, sessionMode, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(AnnotatedString annotatedString, long j3, long j4, int i3, int i4, Composer composer, int i5) {
        B1(annotatedString, j3, j4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static final void D0(boolean z2, final PomodoroSession pomodoroSession, final long j3, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        PomodoroSession pomodoroSession2;
        final boolean z4;
        int i6;
        float f3;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z5;
        long jU;
        ?? r2;
        long jS;
        long jS2;
        long j4 = j3;
        Composer composerK = composer.k(-652970733);
        int i11 = i4 & 1;
        if (i11 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            pomodoroSession2 = pomodoroSession;
            i5 |= composerK.Z(pomodoroSession2) ? 32 : 16;
        } else {
            pomodoroSession2 = pomodoroSession;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i12 = 1;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i11 != 0) {
                z3 = true;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-652970733, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.PomodoroProgressBar (QuickBlockCard.kt:822)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            int iC = pomodoroSession2.c();
            Modifier modifierI = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f4));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(766169533);
            int iQ = pomodoroSession2.q();
            int i13 = 0;
            while (i13 < iQ) {
                if (i13 == iC && (pomodoroSession2.j() instanceof PomodoroSession.SessionMode.Focus)) {
                    composerK.a0(-2018421647);
                    Modifier.Companion companion3 = Modifier.b8;
                    RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                    int i14 = i5 & 14;
                    Composer composer2 = composerK;
                    i6 = iQ;
                    f3 = f4;
                    i7 = i5;
                    i9 = i13;
                    i8 = iC;
                    i10 = 1;
                    boolean z6 = z3;
                    z1(z6, RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), 0L, 0L, 0L, i12 - (j4 / pomodoroSession2.k()), composer2, i14, 28);
                    z5 = z6;
                    composerK = composer2;
                    if (i9 < pomodoroSession.q() - 1) {
                        composerK.a0(-2017948432);
                        SpacerKt.a(SizeKt.A(companion3, Dp.g(f3)), composerK, 6);
                    } else {
                        composerK.a0(-2052502613);
                    }
                    composerK.U();
                    composerK.U();
                    rowScopeInstance = rowScopeInstance2;
                } else {
                    i6 = iQ;
                    f3 = f4;
                    i7 = i5;
                    i8 = iC;
                    i9 = i13;
                    i10 = i12;
                    RowScopeInstance rowScopeInstance3 = rowScopeInstance;
                    z5 = z3;
                    if (i9 == i8) {
                        composerK.a0(-2017682545);
                        if (z5) {
                            composerK.a0(766201117);
                            r2 = 0;
                            jS = ComposeColorsKt.j(composerK, 0).b();
                        } else {
                            r2 = 0;
                            composerK.a0(766201732);
                            jS = ComposeColorsKt.j(composerK, 0).s();
                        }
                        composerK.U();
                        u0(rowScopeInstance3, jS, composerK, 6, 0);
                        rowScopeInstance = rowScopeInstance3;
                        Modifier.Companion companion4 = Modifier.b8;
                        Modifier modifierV = SizeKt.v(companion4, Dp.g(f3));
                        Alignment.Companion companion5 = Alignment.f25072a;
                        MeasurePolicy measurePolicyG = BoxKt.g(companion5.o(), r2);
                        int iA2 = ComposablesKt.a(composerK, r2);
                        CompositionLocalMap compositionLocalMapU2 = composerK.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierV);
                        ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                        Function0 function0A2 = companion6.a();
                        if (composerK.m() == null) {
                            ComposablesKt.c();
                        }
                        composerK.L();
                        if (composerK.i()) {
                            composerK.P(function0A2);
                        } else {
                            composerK.v();
                        }
                        Composer composerA2 = Updater.a(composerK);
                        Updater.e(composerA2, measurePolicyG, companion6.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion6.g());
                        Function2 function2B2 = companion6.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion6.f());
                        Modifier modifierF3 = BoxScopeInstance.f6642a.f(companion4, companion5.e());
                        if (z5) {
                            composerK.a0(545431084);
                            jS2 = ComposeColorsKt.j(composerK, r2).p();
                        } else {
                            composerK.a0(545431885);
                            jS2 = ComposeColorsKt.j(composerK, r2).s();
                        }
                        composerK.U();
                        ComposeLoadingDotsKt.e(modifierF3, jS2, composerK, 0, 0);
                        composerK.y();
                        composerK.U();
                    } else {
                        rowScopeInstance = rowScopeInstance3;
                        composerK.a0(-2017026771);
                        if (i9 < i8) {
                            composerK.a0(-2016830665);
                            if (z5) {
                                composerK.a0(766226557);
                                jU = ComposeColorsKt.j(composerK, 0).b();
                            } else {
                                composerK.a0(766227172);
                                jU = ComposeColorsKt.j(composerK, 0).s();
                            }
                            composerK.U();
                            composerK.U();
                        } else {
                            composerK.a0(766228964);
                            jU = ComposeColorsKt.j(composerK, 0).u();
                            composerK.U();
                        }
                        u0(rowScopeInstance, jU, composerK, 6, 0);
                        if (i9 < pomodoroSession.q() - 1) {
                            composerK.a0(-2016611216);
                            SpacerKt.a(SizeKt.A(Modifier.b8, Dp.g(f3)), composerK, 6);
                        } else {
                            composerK.a0(-2052502613);
                        }
                        composerK.U();
                        composerK.U();
                    }
                }
                i13 = i9 + 1;
                pomodoroSession2 = pomodoroSession;
                j4 = j3;
                i5 = i7;
                iC = i8;
                z3 = z5;
                f4 = f3;
                i12 = i10;
                iQ = i6;
            }
            boolean z7 = z3;
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z7;
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.E0(z4, pomodoroSession, j3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void D1(final MutableState showDialog, final Function0 onConfirmClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Composer composerK = composer.k(-1059943852);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(showDialog) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onConfirmClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1059943852, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.StrictModeActiveDialog (QuickBlockCard.kt:1168)");
            }
            ComposeDialogsKt.x0(showDialog, StringResources_androidKt.b(R.string.kr, composerK, 0), StringResources_androidKt.b(R.string.jr, composerK, 0), null, StringResources_androidKt.b(R.string.bA, composerK, 0), 0L, false, onConfirmClick, StringResources_androidKt.b(R.string.O4, composerK, 0), 0L, null, composerK, (i4 & 14) | ((i4 << 18) & 29360128), 0, 1640);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.v0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.E1(showDialog, onConfirmClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(boolean z2, PomodoroSession pomodoroSession, long j3, int i3, int i4, Composer composer, int i5) {
        D0(z2, pomodoroSession, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        D1(mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void F0(Composer composer, final int i3) {
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(261453232);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(261453232, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.PremiumFeatureRow (QuickBlockCard.kt:1106)");
            }
            if (((Boolean) composerK.q(InspectionModeKt.a())).booleanValue()) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.g1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return QuickBlockCardKt.G0(i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierM = PaddingKt.m(Modifier.b8, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null);
            String strP = StringHelperExtKt.p(StringResources_androidKt.b(R.string.rD, composerK, 0), StringResources_androidKt.b(R.string.jo, composerK, 0), " & ");
            Integer smallIconResId = PremiumFeature.QUICK_BLOCK_TIMER.getSmallIconResId();
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.h1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.H0(context);
                    }
                };
                composerK.w(objG);
            }
            CardsKt.s(modifierM, smallIconResId, strP, (Function0) objG, composerK, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.i1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.I0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    public static final void F1(Function1 function1, Composer composer, final int i3, final int i4) {
        Function1 function12;
        int i5;
        final Function1 function13;
        Composer composerK = composer.k(1468572407);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            function12 = function1;
        } else if ((i3 & 6) == 0) {
            function12 = function1;
            i5 = (composerK.I(function12) ? 4 : 2) | i3;
        } else {
            function12 = function1;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            function13 = i6 != 0 ? null : function12;
            if (ComposerKt.M()) {
                ComposerKt.U(1468572407, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.TimerRow (QuickBlockCard.kt:1069)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, Alignment.f25072a.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            ImageVector.Companion companion3 = ImageVector.f26323k;
            ButtonType.MediumRound mediumRound = new ButtonType.MediumRound(VectorResources_androidKt.b(companion3, R.drawable.r6, composerK, 6), null, StringResources_androidKt.b(R.string.rD, composerK, 0), null, false, 26, null);
            ButtonColor.ExtraLight extraLight = new ButtonColor.ExtraLight(false, Color.n(ComposeColorsKt.j(composerK, 0).l0()), false, null, 9, null);
            int i7 = i5 & 14;
            boolean zI = (i7 == 4) | composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.G1(function13, context);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(modifierC, mediumRound, extraLight, (Function0) objG, composerK, 0, 0);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            ButtonType.MediumRound mediumRound2 = new ButtonType.MediumRound(VectorResources_androidKt.b(companion3, R.drawable.m4, composerK, 6), null, StringResources_androidKt.b(R.string.jo, composerK, 0), null, false, 26, null);
            ButtonColor.ExtraLight extraLight2 = new ButtonColor.ExtraLight(false, Color.n(ComposeColorsKt.j(composerK, 0).l0()), false, null, 9, null);
            boolean zI2 = composerK.I(context) | (i7 == 4);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.H1(function13, context);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.i0(modifierC2, mediumRound2, extraLight2, (Function0) objG2, composerK, 0, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            function13 = function12;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.I1(function13, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(int i3, Composer composer, int i4) {
        F0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(Function1 function1, Context context) {
        if (function1 != null) {
            function1.invoke(QuickBlockViewEvent.OnTimerClicked.f100570a);
        } else {
            J1(context, false, false, ScheduleDescriptor.QuickBlockSource.TIMER);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.QUICK_BLOCK_TIMER), "blocking_tab", "qb_timer", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(Function1 function1, Context context) {
        if (function1 != null) {
            function1.invoke(QuickBlockViewEvent.OnPomodoroClicked.f100564a);
        } else {
            J1(context, false, false, ScheduleDescriptor.QuickBlockSource.POMODORO);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(int i3, Composer composer, int i4) {
        F0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(Function1 function1, int i3, int i4, Composer composer, int i5) {
        F1(function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void J0(Composer composer, final int i3) {
        Composer composerK = composer.k(602528345);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(602528345, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.PreviewIncluded (QuickBlockCard.kt:192)");
            }
            QuickBlockRepository.QuickBlockState.Stopped stopped = QuickBlockRepository.QuickBlockState.Stopped.f97890b;
            WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
            QuickBlockViewState quickBlockViewState = new QuickBlockViewState(stopped, null, null, CollectionsKt.listOf((Object[]) new WebsiteDTO[]{new WebsiteDTO("web1", blockingType, false, false, 12, null), new WebsiteDTO("web2", blockingType, false, false, 12, null)}), null, null, false, null, 0L, 0L, true, true, null, false, null, false, false, false, false, true, 521206, null);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.z0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickBlockCardKt.K0((QuickBlockViewEvent) obj);
                    }
                };
                composerK.w(objG2);
            }
            o1(quickBlockViewState, mutableState, (Function1) objG2, composerK, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.L0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void J1(Context context, boolean z2, boolean z3, ScheduleDescriptor.QuickBlockSource quickBlockSource) {
        context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.QuickBlock(z2, false, z3, false, null, quickBlockSource, 18, null), false, false, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(QuickBlockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    static /* synthetic */ void K1(Context context, boolean z2, boolean z3, ScheduleDescriptor.QuickBlockSource quickBlockSource, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            quickBlockSource = null;
        }
        J1(context, z2, z3, quickBlockSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(int i3, Composer composer, int i4) {
        J0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

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
    public static final void M0(final ScaffoldState scaffoldState, final MutableState showBottomSheet, Composer composer, final int i3) throws ClosedScopeException, NoBeanDefFoundException {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(showBottomSheet, "showBottomSheet");
        Composer composerK = composer.k(1171414277);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(showBottomSheet) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1171414277, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCard (QuickBlockCard.kt:213)");
            }
            if (((Boolean) composerK.q(InspectionModeKt.a())).booleanValue()) {
                composerK.a0(993594661);
                J0(composerK, 0);
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return QuickBlockCardKt.N0(scaffoldState, showBottomSheet, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composerK.a0(983927869);
            composerK.U();
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.O0(context);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(QuickBlockCardViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            QuickBlockCardViewModel quickBlockCardViewModel = (QuickBlockCardViewModel) viewModelA;
            QuickBlockViewState quickBlockViewState = (QuickBlockViewState) FlowExtKt.m(quickBlockCardViewModel, composerK, 0);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG2, CoroutinesHelperExtKt.b());
            final Function1 function1N = FlowExtKt.n(quickBlockCardViewModel, composerK, 0);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState = (MutableState) objG3;
            o1(quickBlockViewState, mutableState, function1N, composerK, 48);
            n0(coroutineScopeI, scaffoldState, quickBlockCardViewModel, function1N, showBottomSheet, mutableState, composerK, ((i4 << 3) & 112) | 196608 | ((i4 << 9) & 57344));
            boolean Z = composerK.Z(function1N);
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockCardKt.P0(function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG4);
            }
            ComposableExtKt.j(null, (Function2) objG4, composerK, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.Q0(scaffoldState, showBottomSheet, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ScaffoldState scaffoldState, MutableState mutableState, int i3, Composer composer, int i4) throws ClosedScopeException, NoBeanDefFoundException {
        M0(scaffoldState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder O0(Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        long j3;
        boolean z6;
        Activity activityB = ContextExtKt.b(context);
        Intent intent = activityB != null ? activityB.getIntent() : null;
        boolean z7 = true;
        boolean z8 = false;
        if (intent == null || !intent.getBooleanExtra("SHOW_TIME_SELECT", false)) {
            z2 = true;
            z7 = false;
        } else {
            z2 = true;
        }
        if (intent == null || intent.getBooleanExtra("SHOW_POMODORO", false) != z2) {
            z3 = false;
        } else {
            z3 = false;
            z8 = z2;
        }
        if (intent == null || intent.getBooleanExtra("OPEN_PERMISSION_SCREEN", z3) != z2) {
            z4 = z2;
            z2 = z3;
        } else {
            z4 = z2;
        }
        if (intent == null || intent.getBooleanExtra("SHOW_PREMIUM", z3) != z4) {
            z5 = z3;
        } else {
            z5 = z3;
            z3 = z4;
        }
        long longExtra = intent != null ? intent.getLongExtra("WIDGET_TIMER", 0L) : 0L;
        if (intent == null || intent.getBooleanExtra("SHOW_STRICT_MODE_WARNING", z5) != z4) {
            j3 = longExtra;
            z6 = z5;
        } else {
            j3 = longExtra;
            z6 = z4;
        }
        return ParametersHolderKt.b(new QuickBlockCardViewModel.Params(z7, z8, z2, z3, j3, z6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.f100439a[event.ordinal()];
        if (i3 == 1) {
            function1.invoke(QuickBlockViewEvent.OnResumed.f100565a);
        } else if (i3 == 2) {
            function1.invoke(QuickBlockViewEvent.OnViewInitialized.f100571a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(ScaffoldState scaffoldState, MutableState mutableState, int i3, Composer composer, int i4) throws ClosedScopeException, NoBeanDefFoundException {
        M0(scaffoldState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void R0(final cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewState r20, final kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function0 r22, final androidx.compose.ui.graphics.Color r23, final boolean r24, kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt.R0(cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Color, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(final QuickBlockViewState quickBlockViewState, final Function1 function1, final boolean z2, final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        Unit unit;
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-460209271, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockContent.<anonymous> (QuickBlockCard.kt:444)");
            }
            if (quickBlockViewState.w()) {
                composer2.a0(-558520306);
                Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(16));
                Arrangement arrangement = Arrangement.f6574a;
                MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), Alignment.f25072a.k(), composer2, 0);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyA, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                FlowLayoutKt.d(null, arrangement.e(), null, null, 0, 0, ComposableLambdaKt.e(300790378, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.c0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return QuickBlockCardKt.V0(quickBlockViewState, z2, function0, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 1572912, 61);
                if (quickBlockViewState.o() instanceof QuickBlockRepository.QuickBlockState.Running) {
                    composer2.a0(-552551953);
                    if (((QuickBlockRepository.QuickBlockState.Running) quickBlockViewState.o()).a() == null) {
                        composer2.a0(-552525976);
                        composer2.U();
                        unit = null;
                    } else {
                        composer2.a0(-552525975);
                        long jP = quickBlockViewState.p();
                        Long lValueOf = Long.valueOf(quickBlockViewState.r());
                        boolean Z = composer2.Z(function1);
                        Object objG = composer2.G();
                        if (Z || objG == Composer.f23746a.a()) {
                            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.e0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return QuickBlockCardKt.X0(function1);
                                }
                            };
                            composer2.w(objG);
                        }
                        u1(false, jP, lValueOf, (Function0) objG, composer, 0, 1);
                        composer2 = composer;
                        composer2.U();
                        unit = Unit.f139807a;
                    }
                    if (unit == null) {
                        composer2.a0(-552107010);
                        boolean Z2 = composer2.Z(function1);
                        Object objG2 = composer2.G();
                        if (Z2 || objG2 == Composer.f23746a.a()) {
                            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.f0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return QuickBlockCardKt.Y0(function1);
                                }
                            };
                            composer2.w(objG2);
                        }
                        v1(false, (Function0) objG2, composer2, 0, 1);
                        composer2.U();
                    } else {
                        composer2.a0(-433466253);
                        composer2.U();
                    }
                    composer2.U();
                } else if (quickBlockViewState.o() instanceof QuickBlockRepository.QuickBlockState.Pomodoro) {
                    composer2.a0(-551797630);
                    PomodoroSession pomodoroSessionB = ((QuickBlockRepository.QuickBlockState.Pomodoro) quickBlockViewState.o()).b();
                    PomodoroSession.SessionMode sessionModeJ = ((QuickBlockRepository.QuickBlockState.Pomodoro) quickBlockViewState.o()).b().j();
                    boolean Z3 = composer2.Z(function1);
                    Object objG3 = composer2.G();
                    if (Z3 || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.g0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return QuickBlockCardKt.Z0(function1);
                            }
                        };
                        composer2.w(objG3);
                    }
                    A0(false, pomodoroSessionB, sessionModeJ, function1, (Function0) objG3, composer2, 0, 1);
                    composer2.U();
                } else if (!quickBlockViewState.u() || (z2 && !quickBlockViewState.y())) {
                    composer2.a0(-551209684);
                    r0(quickBlockViewState, composer2, 0);
                    composer2.U();
                } else {
                    composer2.a0(-551110267);
                    w0(quickBlockViewState, function1, composer2, 0);
                    composer2.U();
                }
                composer2.y();
                composer2.U();
            } else {
                composer2.a0(-558745645);
                ComposePlaceHoldersKt.d(SizeKt.i(Modifier.b8, Dp.g(170)), 0L, null, composer2, 6, 6);
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final QuickBlockViewState quickBlockViewState, boolean z2, Function0 function0, FlowRowScope FlowRow, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Composer composer3 = composer;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer3.Z(FlowRow) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer3.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(300790378, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockContent.<anonymous>.<anonymous>.<anonymous> (QuickBlockCard.kt:449)");
            }
            if (!quickBlockViewState.v() || (!z2 && quickBlockViewState.u())) {
                composer3.a0(1525851896);
            } else {
                composer3.a0(1544497373);
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95532k2, composer3, 6), StringResources_androidKt.b(R.string.Wn, composer3, 0), FlowRow.d(SizeKt.v(PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(10), 0.0f, 11, null), Dp.g(24)), Alignment.f25072a.i()), null, null, 0.0f, null, composer, 0, 120);
                composer3 = composer;
            }
            composer3.U();
            String strB = StringResources_androidKt.b(R.string.zD, composer3, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composer3, 0).g();
            int iF = TextAlign.f29616b.f();
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            TextKt.c(strB, FlowRow.d(companion, companion2.i()), 0L, 0L, null, null, null, 0L, null, TextAlign.h(iF), 0L, 0, false, 0, 0, null, textStyleG, composer, 0, 0, 65020);
            SpacerKt.a(RowScope.c(FlowRow, companion, 1.0f, false, 2, null), composer, 0);
            if (quickBlockViewState.l().isEmpty()) {
                composer.a0(1545579986);
                composer2 = composer;
                ComposeCardsKt.m(FlowRow.d(companion, companion2.i()), new CardType.Custom(ComposeColorsKt.j(composer, 0).v(), null, null, null, 14, null), function0, ComposableLambdaKt.e(572458941, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.c1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockCardKt.W0(quickBlockViewState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer2, 3072, 0);
            } else {
                composer2 = composer;
                composer2.a0(1525851896);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer3.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(QuickBlockViewState quickBlockViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(572458941, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QuickBlockCard.kt:475)");
            }
            List listD = quickBlockViewState.d();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                ProfileWithBlockedItems.ApplicationProfileRelationWithApplication applicationProfileRelationWithApplication = (ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) obj;
                if (applicationProfileRelationWithApplication.a().a() == null || !quickBlockViewState.q().containsAll(Category.Companion.c(applicationProfileRelationWithApplication.a().a().intValue()))) {
                    if (!applicationProfileRelationWithApplication.b().g(2)) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                arrayList2.add(((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) obj2).d());
            }
            IconClusterKt.k(PaddingKt.i(Modifier.b8, Dp.g(8)), ExtensionsKt.h(arrayList2), ExtensionsKt.h(quickBlockViewState.s()), quickBlockViewState.t(), quickBlockViewState.q(), !quickBlockViewState.u() && quickBlockViewState.v(), (quickBlockViewState.u() || quickBlockViewState.v()) ? false : true, quickBlockViewState.j(), quickBlockViewState.c(), quickBlockViewState.i(), quickBlockViewState.e(), quickBlockViewState.f(), composer, 6, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(Function1 function1) {
        function1.invoke(QuickBlockViewEvent.OnStopClicked.f100568a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(Function1 function1) {
        function1.invoke(QuickBlockViewEvent.OnStopClicked.f100568a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function1 function1) {
        function1.invoke(QuickBlockViewEvent.OnStopClicked.f100568a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(QuickBlockViewState quickBlockViewState, Function1 function1, Function0 function0, Color color, boolean z2, Function0 function02, int i3, int i4, Composer composer, int i5) {
        R0(quickBlockViewState, function1, function0, color, z2, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void b1(Modifier modifier, final QuickBlockProfileDTO profile, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(profile, "profile");
        Composer composerK = composer.k(-741405624);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? composerK.Z(profile) : composerK.I(profile) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-741405624, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockGrayscaleContent (QuickBlockCard.kt:539)");
            }
            ComposeCardsKt.m(modifier3, new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-811418621, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.c1(profile, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i5 & 14) | 3456, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.h1(modifier3, profile, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final QuickBlockProfileDTO quickBlockProfileDTO, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-811418621, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockGrayscaleContent.<anonymous> (QuickBlockCard.kt:545)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            FlowLayoutKt.d(PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(4), 7, null), arrangement.e(), null, null, 0, 0, ComposableLambdaKt.e(-1869418402, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QuickBlockCardKt.d1(quickBlockProfileDTO, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572918, 60);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer2, 6);
            QuickBlockRepository.QuickBlockState quickBlockStateI = quickBlockProfileDTO.i();
            Unit unit = null;
            if (quickBlockStateI instanceof QuickBlockRepository.QuickBlockState.Running) {
                composer2.a0(-1108641698);
                Long lA = ((QuickBlockRepository.QuickBlockState.Running) quickBlockStateI).a();
                if (lA == null) {
                    composer2.a0(-1108634600);
                    composer2.U();
                } else {
                    composer2.a0(-1108634599);
                    u1(false, lA.longValue() - TimeHelperExt.c(), Long.valueOf(quickBlockProfileDTO.h().s()), null, composer2, 3078, 0);
                    composer2.U();
                    unit = Unit.f139807a;
                }
                if (unit == null) {
                    composer2.a0(-1108271713);
                    Object objG = composer2.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.z
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return QuickBlockCardKt.e1();
                            }
                        };
                        composer2.w(objG);
                    }
                    v1(false, (Function0) objG, composer2, 54, 0);
                    composer2.U();
                } else {
                    composer2.a0(-589951964);
                    composer2.U();
                }
                composer2.U();
            } else if (quickBlockStateI instanceof QuickBlockRepository.QuickBlockState.Pomodoro) {
                composer2.a0(-1108010910);
                QuickBlockRepository.QuickBlockState.Pomodoro pomodoro = (QuickBlockRepository.QuickBlockState.Pomodoro) quickBlockStateI;
                PomodoroSession pomodoroSessionB = pomodoro.b();
                PomodoroSession.SessionMode sessionModeJ = pomodoro.b().j();
                Object objG2 = composer2.G();
                if (objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.a0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return QuickBlockCardKt.f1((QuickBlockViewEvent) obj);
                        }
                    };
                    composer2.w(objG2);
                }
                A0(false, pomodoroSessionB, sessionModeJ, (Function1) objG2, null, composer2, 27654, 0);
                composer2.U();
            } else {
                composer2.a0(-1107625890);
                ButtonType.Big big = new ButtonType.Big(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.k4, composer2, 6), null, StringResources_androidKt.b(R.string.bA, composer2, 0), 0.0f, 10, null);
                ButtonColor.Disabled disabled = new ButtonColor.Disabled(false, null, false, null, 14, null);
                Object objG3 = composer2.G();
                if (objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.b0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.g1();
                        }
                    };
                    composer2.w(objG3);
                }
                ComposeButtonsKt.i0(null, big, disabled, (Function0) objG3, composer, 3072, 1);
                composer2 = composer;
                F1(null, composer2, 6, 0);
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(QuickBlockProfileDTO quickBlockProfileDTO, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(FlowRow) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1869418402, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockGrayscaleContent.<anonymous>.<anonymous>.<anonymous> (QuickBlockCard.kt:550)");
            }
            String strB = StringResources_androidKt.b(R.string.zD, composer, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            int iF = TextAlign.f29616b.f();
            Modifier.Companion companion = Modifier.b8;
            TextKt.c(strB, FlowRow.d(companion, Alignment.f25072a.i()), ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(iF), 0L, 0, false, 0, 0, null, textStyleG, composer, 0, 0, 65016);
            SpacerKt.a(RowScope.c(FlowRow, companion, 1.0f, false, 2, null), composer, 0);
            List listA = quickBlockProfileDTO.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) it.next()).d());
            }
            ImmutableList immutableListH = ExtensionsKt.h(arrayList);
            List<WebsiteProfileRelation> listM = quickBlockProfileDTO.m();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listM, 10));
            for (WebsiteProfileRelation websiteProfileRelation : listM) {
                arrayList2.add(new WebsiteDTO(websiteProfileRelation.c(), websiteProfileRelation.a(), websiteProfileRelation.e(), false, 8, null));
            }
            List listL = quickBlockProfileDTO.l();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listL, 10));
            Iterator it2 = listL.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((SubAppRelation) it2.next()).c());
            }
            IconClusterKt.k(FlowRow.d(Modifier.b8, Alignment.f25072a.i()), immutableListH, ExtensionsKt.h(arrayList3), arrayList2, quickBlockProfileDTO.j(), false, false, quickBlockProfileDTO.e(), quickBlockProfileDTO.k(), quickBlockProfileDTO.d(), quickBlockProfileDTO.b(), quickBlockProfileDTO.c(), composer, 1769472, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(QuickBlockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1() {
        return Unit.f139807a;
    }

    public static final void h0(boolean z2, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        final boolean z3;
        int i5;
        Composer composer2;
        long jS;
        Composer composerK = composer.k(958520878);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            boolean z4 = i6 != 0 ? true : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(958520878, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.ActiveStateRow (QuickBlockCard.kt:1044)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion2.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            int i7 = R.string.f95863z;
            String strB = StringResources_androidKt.b(i7, composerK, 0);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95562s1, composerK, 6);
            String strB2 = StringResources_androidKt.b(i7, composerK, 0);
            ColorFilter.Companion companion4 = ColorFilter.f25730b;
            float[] fArrC = ColorMatrix.c(null, 1, null);
            if (!z4) {
                ColorMatrix.f(fArrC, 0.0f);
            }
            Unit unit = Unit.f139807a;
            ImageKt.b(imageVectorB, strB2, null, null, null, 0.0f, companion4.a(fArrC), composerK, 0, 60);
            TextStyle textStyleJ = ComposeTypographyKt.g(composerK, 0).j();
            if (z4) {
                composerK.a0(-725086216);
                jS = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(-725085601);
                jS = ComposeColorsKt.j(composerK, 0).s();
            }
            composerK.U();
            composer2 = composerK;
            TextKt.c(strB, PaddingKt.m(rowScopeInstance.d(companion, companion2.i()), Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), jS, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleJ, composer2, 0, 0, 65528);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.i0(z3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(Modifier modifier, QuickBlockProfileDTO quickBlockProfileDTO, int i3, int i4, Composer composer, int i5) {
        b1(modifier, quickBlockProfileDTO, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(boolean z2, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        h0(z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void i1(MutableState mutableState, Composer composer, final int i3) throws ClosedScopeException, NoBeanDefFoundException {
        int i4;
        final MutableState mutableState2;
        Composer composerK = composer.k(-1248217052);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(mutableState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1248217052, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockTimerUpsellDialog (QuickBlockCard.kt:1130)");
            }
            composerK.F(860969189);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(511388516);
            boolean Z = composerK.Z(null) | composerK.Z(null);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = scopeD.e(Reflection.b(QuickBlockDataStore.class), null, null);
                composerK.w(objG);
            }
            composerK.Y();
            composerK.Y();
            final QuickBlockDataStore quickBlockDataStore = (QuickBlockDataStore) objG;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final State stateB = androidx.lifecycle.compose.FlowExtKt.b(quickBlockDataStore.z(), Boolean.TRUE, null, null, null, composerK, 48, 14);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QuickBlockCardKt.j1(stateB));
                    }
                });
                composerK.w(objG2);
            }
            State state = (State) objG2;
            String strB = StringResources_androidKt.b(R.string.or, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.nr, composerK, 0);
            String strB3 = StringResources_androidKt.b(R.string.Ci, composerK, 0);
            int i5 = R.drawable.U7;
            boolean zI = composerK.I(quickBlockDataStore);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickBlockCardKt.k1(quickBlockDataStore, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG3);
            }
            Function1 function1 = (Function1) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.l1();
                    }
                };
                composerK.w(objG4);
            }
            Function0 function0 = (Function0) objG4;
            boolean zI2 = composerK.I(context);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.m1(context);
                    }
                };
                composerK.w(objG5);
            }
            mutableState2 = mutableState;
            ComposeDialogsKt.K0(mutableState2, state, strB, strB2, strB3, function1, function0, (Function0) objG5, i5, composerK, (i4 & 14) | 1572912, 0);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            mutableState2 = mutableState;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.n1(mutableState2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void j0(final long j3, final long j4, final int i3, final Function0 function0, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        Function0 function02;
        Composer composerK = composer.k(-121759302);
        if ((i4 & 6) == 0) {
            i5 = (composerK.f(j3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.f(j4) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-121759302, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.CircleButton (QuickBlockCard.kt:973)");
            }
            if (function0 == null) {
                composerK.a0(1916190758);
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.s0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.k0();
                        }
                    };
                    composerK.w(objG);
                }
                function02 = (Function0) objG;
                composerK.U();
            } else {
                composerK.a0(-1046566393);
                composerK.U();
                function02 = function0;
            }
            float f3 = 0;
            ButtonKt.a(function02, SizeKt.v(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95470d, composerK, 0)), function0 != null, null, ButtonDefaults.f12323a.b(Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 0.0f, composerK, (ButtonDefaults.f12334l << 15) | 54, 28), RoundedCornerShapeKt.g(), null, ComposeButtonsKt.L0(j3, ComposeColorsKt.j(composerK, 0).p(), Color.n(ComposeColorsKt.j(composerK, 0).l0()), composerK, i5 & 14), null, ComposableLambdaKt.e(417340842, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QuickBlockCardKt.l0(i3, j4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 805306368, 328);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.m0(j3, j4, i3, function0, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j1(State state) {
        return !((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(QuickBlockDataStore quickBlockDataStore, boolean z2) {
        CoroutinesHelperExtKt.d(new QuickBlockCardKt$QuickBlockTimerUpsellDialog$1$1$1(quickBlockDataStore, z2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(int i3, long j3, RowScope Button, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i4 & 6) == 0) {
            i5 = (composer.Z(Button) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(417340842, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.CircleButton.<anonymous> (QuickBlockCard.kt:990)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, i3, composer, 6), StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.v(Button.d(Modifier.b8, Alignment.f25072a.i()), Dp.g(24)), j3, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(long j3, long j4, int i3, Function0 function0, int i4, Composer composer, int i5) {
        j0(j3, j4, i3, function0, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.QUICK_BLOCK_TIMER), "blocking_tab", "qb_timer", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    private static final void n0(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final QuickBlockCardViewModel quickBlockCardViewModel, final Function1 function1, final MutableState mutableState, final MutableState mutableState2, Composer composer, final int i3) throws ClosedScopeException, NoBeanDefFoundException {
        int i4;
        MutableState mutableState3;
        Composer composer2;
        Composer composerK = composer.k(-1653887176);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(quickBlockCardViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(mutableState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            mutableState3 = mutableState2;
            i4 |= composerK.Z(mutableState3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            mutableState3 = mutableState2;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1653887176, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.CommandProcessor (QuickBlockCard.kt:282)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            int i6 = i5 & 7168;
            boolean z2 = i6 == 2048;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockCardKt.o0(function1, (ActivityResult) obj, ((Long) obj2).longValue());
                    }
                };
                composerK.w(objG);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(0L, (Function2) objG, composerK, 6);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState4 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState5 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotLongStateKt.a(0L);
                composerK.w(objG4);
            }
            final MutableLongState mutableLongState = (MutableLongState) objG4;
            i1(mutableState4, composerK, 6);
            boolean z3 = i6 == 2048;
            Object objG5 = composerK.G();
            if (z3 || objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.p0(function1, mutableLongState);
                    }
                };
                composerK.w(objG5);
            }
            D1(mutableState5, (Function0) objG5, composerK, 6);
            boolean zI = ((57344 & i5) == 16384) | ((i5 & 112) == 32) | composerK.I(context) | composerK.I(activityLauncherP) | composerK.I(coroutineScope) | (i6 == 2048) | ((458752 & i5) == 131072);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                QuickBlockCardKt$CommandProcessor$2$1 quickBlockCardKt$CommandProcessor$2$1 = new QuickBlockCardKt$CommandProcessor$2$1(scaffoldState, context, activityLauncherP, coroutineScope, mutableState4, mutableLongState, mutableState5, mutableState3, mutableState, function1, null);
                composerK.w(quickBlockCardKt$CommandProcessor$2$1);
                objG6 = quickBlockCardKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(quickBlockCardViewModel, null, (Function2) objG6, composer2, (i5 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.q0(coroutineScope, scaffoldState, quickBlockCardViewModel, function1, mutableState, mutableState2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(MutableState mutableState, int i3, Composer composer, int i4) throws ClosedScopeException, NoBeanDefFoundException {
        i1(mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1, ActivityResult result, long j3) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            function1.invoke(new QuickBlockViewEvent.OnPermissionsGranted(j3));
        }
        return Unit.f139807a;
    }

    private static final void o1(final QuickBlockViewState quickBlockViewState, final MutableState mutableState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Color colorN;
        long jK;
        Composer composerK = composer.k(-2003541267);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(quickBlockViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2003541267, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.RootCompose (QuickBlockCard.kt:386)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zIsEmpty = quickBlockViewState.n().isEmpty();
            boolean z2 = !zIsEmpty;
            boolean z3 = quickBlockViewState.k() instanceof PomodoroSession.SessionMode.Break;
            if (!quickBlockViewState.v() || z3) {
                composerK.a0(-336797695);
                composerK.U();
                colorN = null;
            } else {
                composerK.a0(-336954183);
                if (zIsEmpty && quickBlockViewState.u()) {
                    composerK.a0(-336845776);
                    jK = ComposeColorsKt.j(composerK, 0).b();
                    composerK.U();
                } else {
                    composerK.a0(-336890354);
                    jK = ComposeColorsKt.j(composerK, 0).k();
                    composerK.U();
                }
                composerK.U();
                colorN = Color.n(jK);
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composerK.a0(-336735199);
                int i5 = i4 & 112;
                boolean z4 = ((i4 & 896) == 256) | (i5 == 32);
                Object objG = composerK.G();
                if (z4 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.k1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.p1(mutableState, function1);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean z5 = i5 == 32;
                Object objG2 = composerK.G();
                if (z5 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.l1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.q1(mutableState);
                        }
                    };
                    composerK.w(objG2);
                }
                ComposeDialogsKt.b1(function0, (Function0) objG2, composerK, 0);
            } else {
                composerK.a0(-353832939);
            }
            composerK.U();
            boolean z6 = (i4 & 112) == 32;
            Object objG3 = composerK.G();
            if (z6 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.m1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.r1(mutableState);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function02 = (Function0) objG3;
            int i6 = i4 & 14;
            boolean zI = composerK.I(context) | (i6 == 4);
            Object objG4 = composerK.G();
            if (zI || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.n1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.s1(quickBlockViewState, context);
                    }
                };
                composerK.w(objG4);
            }
            R0(quickBlockViewState, function1, function02, colorN, z2, (Function0) objG4, composerK, i6 | ((i4 >> 3) & 112), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.t1(quickBlockViewState, mutableState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function1 function1, MutableLongState mutableLongState) {
        function1.invoke(new QuickBlockViewEvent.OnStartConfirmed(mutableLongState.d()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(MutableState mutableState, Function1 function1) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(QuickBlockViewEvent.OnStopConfirmed.f100569a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(CoroutineScope coroutineScope, ScaffoldState scaffoldState, QuickBlockCardViewModel quickBlockCardViewModel, Function1 function1, MutableState mutableState, MutableState mutableState2, int i3, Composer composer, int i4) throws ClosedScopeException, NoBeanDefFoundException {
        n0(coroutineScope, scaffoldState, quickBlockCardViewModel, function1, mutableState, mutableState2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    private static final void r0(final QuickBlockViewState quickBlockViewState, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        String strB;
        String strB2;
        ImageVector imageVectorB;
        Composer composerK = composer.k(1988588685);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(quickBlockViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1988588685, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.EmptyContent (QuickBlockCard.kt:624)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final boolean zY = quickBlockViewState.y();
            if (zY) {
                composerK.a0(1561867833);
                strB = MessageFormat.format("{0}. {1}.", StringResources_androidKt.b(R.string.Mk, composerK, 0), StringResources_androidKt.b(R.string.I9, composerK, 0));
                Intrinsics.checkNotNullExpressionValue(strB, "format(...)");
                strB2 = StringResources_androidKt.b(R.string.M, composerK, 0);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95558r0, composerK, 6);
                composerK.U();
            } else {
                composerK.a0(1562253969);
                strB = StringResources_androidKt.b(R.string.pr, composerK, 0);
                strB2 = StringResources_androidKt.b(quickBlockViewState.u() ? R.string.l8 : R.string.Ne, composerK, 0);
                if (quickBlockViewState.u()) {
                    composerK.a0(1562599929);
                    composerK.U();
                    imageVectorB = null;
                } else {
                    composerK.a0(1562635269);
                    imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.k4, composerK, 6);
                    composerK.U();
                }
                composerK.U();
            }
            ImageVector imageVector = imageVectorB;
            String str = strB2;
            TextKt.c(strB, PaddingKt.m(Modifier.b8, 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composerK = composerK;
            ButtonType.Big big = new ButtonType.Big(imageVector, null, str, 0.0f, 10, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean zI = composerK.I(context) | composerK.b(zY);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.s0(context, zY);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composerK, 0, 1);
            if (quickBlockViewState.x()) {
                composerK.a0(1563227803);
                F1(null, composerK, 0, 1);
                composerK.U();
            } else {
                composerK.a0(1563259826);
                F0(composerK, 0);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.t0(quickBlockViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Context context, boolean z2) {
        K1(context, z2, false, null, 8, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(QuickBlockViewState quickBlockViewState, Context context) {
        if (quickBlockViewState.w()) {
            K1(context, quickBlockViewState.y(), false, null, 8, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(QuickBlockViewState quickBlockViewState, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        r0(quickBlockViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(QuickBlockViewState quickBlockViewState, MutableState mutableState, Function1 function1, int i3, Composer composer, int i4) {
        o1(quickBlockViewState, mutableState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u0(final androidx.compose.foundation.layout.RowScope r12, long r13, androidx.compose.runtime.Composer r15, final int r16, final int r17) {
        /*
            java.lang.String r0 = "$this$FullProgressBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -87162849(0xffffffffface001f, float:-5.348078E35)
            androidx.compose.runtime.Composer r15 = r15.k(r0)
            r1 = r16 & 6
            r2 = 4
            if (r1 != 0) goto L1d
            boolean r1 = r15.Z(r12)
            if (r1 == 0) goto L19
            r1 = r2
            goto L1a
        L19:
            r1 = 2
        L1a:
            r1 = r16 | r1
            goto L1f
        L1d:
            r1 = r16
        L1f:
            r3 = r16 & 48
            if (r3 != 0) goto L33
            r3 = r17 & 1
            if (r3 != 0) goto L30
            boolean r3 = r15.f(r13)
            if (r3 == 0) goto L30
            r3 = 32
            goto L32
        L30:
            r3 = 16
        L32:
            r1 = r1 | r3
        L33:
            r3 = r1 & 19
            r4 = 18
            r5 = 0
            if (r3 == r4) goto L3c
            r3 = 1
            goto L3d
        L3c:
            r3 = r5
        L3d:
            r4 = r1 & 1
            boolean r3 = r15.r(r3, r4)
            if (r3 == 0) goto La6
            r15.J()
            r3 = r16 & 1
            if (r3 == 0) goto L5d
            boolean r3 = r15.S()
            if (r3 == 0) goto L53
            goto L5d
        L53:
            r15.Q()
            r3 = r17 & 1
            if (r3 == 0) goto L6a
        L5a:
            r1 = r1 & (-113(0xffffffffffffff8f, float:NaN))
            goto L6a
        L5d:
            r3 = r17 & 1
            if (r3 == 0) goto L6a
            cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette r13 = cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt.j(r15, r5)
            long r13 = r13.u()
            goto L5a
        L6a:
            r15.z()
            boolean r3 = androidx.compose.runtime.ComposerKt.M()
            if (r3 == 0) goto L79
            r3 = -1
            java.lang.String r4 = "cz.mobilesoft.coreblock.scene.dashboard.card.FullProgressBar (QuickBlockCard.kt:886)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r3, r4)
        L79:
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.b8
            r10 = 2
            r11 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r6 = r12
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.c(r6, r7, r8, r9, r10, r11)
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.g(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.i(r0, r1)
            r1 = 50
            androidx.compose.foundation.shape.RoundedCornerShape r1 = androidx.compose.foundation.shape.RoundedCornerShapeKt.a(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.c(r0, r13, r1)
            androidx.compose.foundation.layout.SpacerKt.a(r0, r15, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto La4
            androidx.compose.runtime.ComposerKt.T()
        La4:
            r8 = r13
            goto Laa
        La6:
            r15.Q()
            goto La4
        Laa:
            androidx.compose.runtime.ScopeUpdateScope r13 = r15.n()
            if (r13 == 0) goto Lbd
            cz.mobilesoft.coreblock.scene.dashboard.card.f1 r6 = new cz.mobilesoft.coreblock.scene.dashboard.card.f1
            r7 = r12
            r10 = r16
            r11 = r17
            r6.<init>()
            r13.a(r6)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt.u0(androidx.compose.foundation.layout.RowScope, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u1(boolean r47, final long r48, java.lang.Long r50, final kotlin.jvm.functions.Function0 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt.u1(boolean, long, java.lang.Long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(RowScope rowScope, long j3, int i3, int i4, Composer composer, int i5) {
        u0(rowScope, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void v1(boolean z2, final Function0 onStopClicked, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        boolean z3;
        int i5;
        final boolean z4;
        Intrinsics.checkNotNullParameter(onStopClicked, "onStopClicked");
        Composer composerK = composer.k(-1563929865);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onStopClicked) ? 32 : 16;
        }
        int i7 = i5;
        if (composerK.r((i7 & 19) != 18, i7 & 1)) {
            z4 = i6 != 0 ? true : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-1563929865, i7, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.RunningContent (QuickBlockCard.kt:684)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composerK, 6);
            ButtonType.Big big = new ButtonType.Big(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.J5, composerK, 6), null, StringResources_androidKt.b(R.string.yA, composerK, 0), 0.0f, 10, null);
            ButtonColor.Light light = new ButtonColor.Light(z4, Color.n(ComposeColorsKt.j(composerK, 0).l0()), false, null, null, 24, null);
            boolean z5 = (i7 & 112) == 32;
            Object objG = composerK.G();
            if (z5 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockCardKt.w1(onStopClicked);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, big, light, (Function0) objG, composerK, 0, 1);
            h0(z4, composerK, i7 & 14, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.x1(z4, onStopClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void w0(final QuickBlockViewState quickBlockViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1555329342);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(quickBlockViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1555329342, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.OffContent (QuickBlockCard.kt:1002)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            if (quickBlockViewState.l().isEmpty()) {
                int i5 = i4;
                composerK.a0(-708427312);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composerK, 6);
                ButtonType.Big big = new ButtonType.Big(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.k4, composerK, 6), null, StringResources_androidKt.b(R.string.bA, composerK, 0), 0.0f, 10, null);
                boolean z2 = (i5 & 112) == 32;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.y0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.y0(function1);
                        }
                    };
                    composerK.w(objG);
                }
                ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composerK, 0, 1);
                if (quickBlockViewState.x()) {
                    composerK.a0(-707983113);
                    F1(function1, composerK, (i5 >> 3) & 14, 0);
                    composerK.U();
                } else {
                    composerK.a0(-707936427);
                    F0(composerK, 0);
                    composerK.U();
                }
                composerK.U();
            } else {
                composerK.a0(-709008965);
                int i6 = i4;
                TextKt.c(StringResources_androidKt.b(R.string.hr, composerK, 0), PaddingKt.m(Modifier.b8, 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
                composerK = composerK;
                ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.nk, composerK, 0), 0.0f, 11, null);
                boolean zI = composerK.I(context) | ((i6 & 14) == 4);
                Object objG2 = composerK.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.x0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickBlockCardKt.x0(context, quickBlockViewState);
                        }
                    };
                    composerK.w(objG2);
                }
                ComposeButtonsKt.i0(null, big2, accent, (Function0) objG2, composerK, 0, 1);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockCardKt.z0(quickBlockViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Context context, QuickBlockViewState quickBlockViewState) {
        K1(context, quickBlockViewState.y(), false, null, 8, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        v1(z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1) {
        function1.invoke(new QuickBlockViewEvent.OnStartClicked(0L, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(boolean z2, long j3, Long l3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        u1(z2, j3, l3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(QuickBlockViewState quickBlockViewState, Function1 function1, int i3, Composer composer, int i4) {
        w0(quickBlockViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z1(boolean r18, androidx.compose.ui.Modifier r19, long r20, long r22, long r24, final float r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt.z1(boolean, androidx.compose.ui.Modifier, long, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
