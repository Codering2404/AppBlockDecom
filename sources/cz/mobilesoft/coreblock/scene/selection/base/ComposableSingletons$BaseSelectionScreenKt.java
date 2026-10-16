package cz.mobilesoft.coreblock.scene.selection.base;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.CoroutineScope;

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
public final class ComposableSingletons$BaseSelectionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BaseSelectionScreenKt f118402a = new ComposableSingletons$BaseSelectionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f118403b = ComposableLambdaKt.c(-124832552, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.x3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseSelectionScreenKt.r((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f118404c = ComposableLambdaKt.c(1597565435, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.z3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseSelectionScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f118405d = ComposableLambdaKt.c(2038607023, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.a4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseSelectionScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f118406e = ComposableLambdaKt.c(-656470853, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.b4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseSelectionScreenKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f118407f = ComposableLambdaKt.c(-1940870653, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseSelectionScreenKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1597565435, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.ComposableSingletons$BaseSelectionScreenKt.lambda$1597565435.<anonymous> (BaseSelectionScreen.kt:1113)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            ApplicationStateDTO applicationStateDTO = new ApplicationStateDTO(new ApplicationDTO("com.example.app", "App Name", null, false, false, 0, "App Name", false, null, 388, null), CollectionsKt.emptyList());
            Profile.BlockingMode blockingMode = Profile.BlockingMode.Blocklist;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BaseSelectionScreenKt.n(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            ApplicationItemKt.m(null, scaffoldStateG, applicationStateDTO, (Function1) objG, true, blockingMode, null, null, null, composer, (ApplicationStateDTO.f118052c << 6) | 224256, 449);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2038607023, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.ComposableSingletons$BaseSelectionScreenKt.lambda$2038607023.<anonymous> (BaseSelectionScreen.kt:1137)");
            }
            BaseSelectionViewState baseSelectionViewState = new BaseSelectionViewState(Success.f128020a, new BaseSelectionViewState.ApplicationViewState(null, null, MapsKt.mutableMapOf(TuplesKt.a("com.example.app", new ApplicationStateDTO(new ApplicationDTO("com.example.app", "App Name", null, false, false, 0, "App Name", false, null, 388, null), CollectionsKt.emptyList()))), false, null, null, 51, null), null, null, new BaseSelectionViewState.WebsiteKeywordsViewState(MapsKt.mutableMapOf(TuplesKt.a("Website Name", new RelationDTO("com.example.app", "Website Name", false))), MapsKt.mutableMapOf(TuplesKt.a("Website Name", new WebsiteStateDTO(new WebsiteDTO("Website Name", WebsiteProfileRelation.BlockingType.DOMAIN, false, false, 12, null), false, false, false, 12, null))), null, null, null, 28, null), TabItem.Keywords, null, null, null, null, null, null, false, 8140, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG2);
            }
            MutableState mutableState = (MutableState) objG2;
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.h4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(ComposableSingletons$BaseSelectionScreenKt.p());
                    }
                };
                composer.w(objG3);
            }
            PagerState pagerStateL = PagerStateKt.l(2, 0.0f, (Function0) objG3, composer, 390, 2);
            PersistentList persistentListA = ExtensionsKt.a();
            Object objG4 = composer.G();
            if (objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.y3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BaseSelectionScreenKt.q((BaseSelectionViewEvent) obj);
                    }
                };
                composer.w(objG4);
            }
            BaseSelectionScreenKt.U0(baseSelectionViewState, coroutineScope, scaffoldStateG, (Function1) objG4, mutableState, true, modalBottomSheetStateJ, pagerStateL, persistentListA, null, null, composer, (ModalBottomSheetState.f13222e << 18) | 100887552, 0, 1536);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(BaseSelectionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-124832552, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.ComposableSingletons$BaseSelectionScreenKt.lambda$-124832552.<anonymous> (BaseSelectionScreen.kt:511)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.Z4, composer, 0), "", SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composer, 0).M(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.me, composer, 0), PaddingKt.m(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).a(), composer, 48, 0, 65528);
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
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1940870653, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.ComposableSingletons$BaseSelectionScreenKt.lambda$-1940870653.<anonymous> (BaseSelectionScreen.kt:1225)");
            }
            WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
            PersistentList persistentListB = ExtensionsKt.b(new WebsiteDTO("Website Name", blockingType, false, false, 12, null), new WebsiteDTO("Website Name 2", blockingType, false, false, 12, null), new WebsiteDTO("Website Name 3", blockingType, false, false, 12, null));
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.e4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BaseSelectionScreenKt.t();
                    }
                };
                composer.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.f4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BaseSelectionScreenKt.u();
                    }
                };
                composer.w(objG3);
            }
            WebsitesForSelectedAppsBottomSheetKt.e(persistentListB, modalBottomSheetStateJ, coroutineScope, function0, (Function0) objG3, composer, (ModalBottomSheetState.f13222e << 3) | 27654);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-656470853, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.ComposableSingletons$BaseSelectionScreenKt.lambda$-656470853.<anonymous> (BaseSelectionScreen.kt:1193)");
            }
            WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
            BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState = new BaseSelectionViewState.WebsiteKeywordsViewState(MapsKt.mutableMapOf(TuplesKt.a("Website Name", new RelationDTO("com.example.app", "Website Name", false))), MapsKt.mutableMapOf(TuplesKt.a("Website Name", new WebsiteStateDTO(new WebsiteDTO("Website Name", blockingType, false, false, 12, null), false, false, false, 12, null))), null, null, null, 28, null);
            LazyListState lazyListStateB = LazyListStateKt.b(0, 0, composer, 0, 3);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BaseSelectionScreenKt.w((BaseSelectionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            BaseWebsiteSelectionScreenKt.p(websiteKeywordsViewState, blockingType, null, lazyListStateB, scaffoldStateG, (Function1) objG, composer, 196656, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(BaseSelectionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function2 l() {
        return f118403b;
    }
}
