package cz.mobilesoft.coreblock.view.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class StatisticsProfilesListViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f133480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f133481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComposeView f133482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AppIconCache f133483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableStateFlow f133484e;

    public StatisticsProfilesListViewHolder(Context context, List profiles) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        this.f133480a = context;
        this.f133481b = profiles;
        this.f133482c = new ComposeView(context, null, 0, 6, null);
        this.f133483d = new AppIconCache();
        this.f133484e = StateFlowKt.a(null);
    }

    private final void e(final State state, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1485477564);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1485477564, i4, -1, "cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder.RootCompose (StatisticsProfilesListViewHolder.kt:58)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(1324322091, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.viewholder.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsProfilesListViewHolder.f(state, this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.viewholder.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsProfilesListViewHolder.h(this.f133499a, state, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(State state, StatisticsProfilesListViewHolder statisticsProfilesListViewHolder, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1324322091, i3, -1, "cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder.RootCompose.<anonymous> (StatisticsProfilesListViewHolder.kt:60)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            List<ProfileViewDTO> list = (List) state.getValue();
            if (list == null) {
                composer.a0(-1873532049);
            } else {
                composer.a0(-1873532048);
                for (ProfileViewDTO profileViewDTO : list) {
                    AppIconCache appIconCache = statisticsProfilesListViewHolder.f133483d;
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.viewholder.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return StatisticsProfilesListViewHolder.g((ProfileItemEvent) obj);
                            }
                        };
                        composer.w(objG);
                    }
                    ProfileItemKt.I0(scaffoldStateG, profileViewDTO, appIconCache, null, false, null, (Function1) objG, composer, 1572864, 56);
                }
            }
            composer.U();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(ProfileItemEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(StatisticsProfilesListViewHolder statisticsProfilesListViewHolder, State state, int i3, Composer composer, int i4) {
        statisticsProfilesListViewHolder.e(state, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(StatisticsProfilesListViewHolder statisticsProfilesListViewHolder, LifecycleOwner lifecycleOwner, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1381345479, i3, -1, "cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder.addToContainer.<anonymous>.<anonymous> (StatisticsProfilesListViewHolder.kt:50)");
            }
            statisticsProfilesListViewHolder.e(FlowExtKt.b(statisticsProfilesListViewHolder.f133484e, null, lifecycleOwner, null, null, composer, 48, 12), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final View j(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.addView(this.f133482c);
        final LifecycleOwner lifecycleOwnerA = ViewTreeLifecycleOwner.a(container);
        if (lifecycleOwnerA != null) {
            CoroutinesHelperExtKt.e(lifecycleOwnerA, new StatisticsProfilesListViewHolder$addToContainer$1$1(this, null));
            this.f133482c.setContent(ComposableLambdaKt.c(-1381345479, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.viewholder.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsProfilesListViewHolder.k(this.f133495a, lifecycleOwnerA, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        }
        return this.f133482c;
    }

    public final Context l() {
        return this.f133480a;
    }

    public final List m() {
        return this.f133481b;
    }
}
