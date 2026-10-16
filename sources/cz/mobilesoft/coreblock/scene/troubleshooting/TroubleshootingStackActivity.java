package cz.mobilesoft.coreblock.scene.troubleshooting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.enums.HelpItemResultLauncher;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

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
public final class TroubleshootingStackActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f122964g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f122965h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f122966f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent a(Context context, Collection collection) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(collection, MHoiDDglUlPJC.AlfiZ);
            Intent intent = new Intent(context, (Class<?>) TroubleshootingStackActivity.class);
            intent.putExtra("PERMISSIONS", new ArrayList(collection));
            return intent;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122973a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f122973a = iArr;
        }
    }

    private final void q0(TroubleshootingStackViewModel troubleshootingStackViewModel, Composer composer, final int i3) {
        int i4;
        final TroubleshootingStackViewModel troubleshootingStackViewModel2;
        Composer composerK = composer.k(-1175153756);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(troubleshootingStackViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1175153756, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivity.CommandProcessor (TroubleshootingStackActivity.kt:120)");
            }
            HelpItemResultLauncher.Companion companion = HelpItemResultLauncher.f96984d;
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TroubleshootingStackActivity.s0((HelpItem) obj, (ActivityResult) obj2);
                    }
                };
                composerK.w(objG);
            }
            HelpItemResultLauncher helpItemResultLauncherE = companion.e((Function2) objG, composerK, 54);
            boolean zI = composerK.I(this) | composerK.I(helpItemResultLauncherE);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion2.a()) {
                objG2 = new TroubleshootingStackActivity$CommandProcessor$1$1(this, helpItemResultLauncherE, null);
                composerK.w(objG2);
            }
            troubleshootingStackViewModel2 = troubleshootingStackViewModel;
            FlowExtKt.g(troubleshootingStackViewModel2, null, (Function2) objG2, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            troubleshootingStackViewModel2 = troubleshootingStackViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivity.t0(this.f123025a, troubleshootingStackViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(HelpItem helpItem, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(TroubleshootingStackActivity troubleshootingStackActivity, TroubleshootingStackViewModel troubleshootingStackViewModel, int i3, Composer composer, int i4) {
        troubleshootingStackActivity.q0(troubleshootingStackViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder u0(TroubleshootingStackActivity troubleshootingStackActivity) {
        Serializable serializableExtra = troubleshootingStackActivity.getIntent().getSerializableExtra("PERMISSIONS");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<cz.mobilesoft.coreblock.util.permissions.PermissionDTO>");
        return ParametersHolderKt.b(serializableExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function1 function1) {
        function1.invoke(TroubleshootingStackViewEvent.OnCloseClicked.f122985a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(CoroutineScope coroutineScope, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f122973a[event.ordinal()] == 1) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new TroubleshootingStackActivity$RootCompose$2$1$1(function1, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(TroubleshootingStackActivity troubleshootingStackActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        troubleshootingStackActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
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
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1328516794);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1328516794, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivity.RootCompose (TroubleshootingStackActivity.kt:83)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TroubleshootingStackActivity.u0(this.f123018a);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
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
            KClass kClassB = Reflection.b(TroubleshootingStackViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            TroubleshootingStackViewModel troubleshootingStackViewModel = (TroubleshootingStackViewModel) viewModelA;
            TroubleshootingStackViewState troubleshootingStackViewState = (TroubleshootingStackViewState) FlowExtKt.m(troubleshootingStackViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(troubleshootingStackViewModel, composerK, 0);
            boolean Z = composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TroubleshootingStackActivity.v0(function1N);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            TroubleshootingStackActivityKt.x(troubleshootingStackViewState, function1N, composerK, 0);
            boolean zI2 = composerK.I(coroutineScope) | composerK.Z(function1N);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TroubleshootingStackActivity.w0(coroutineScope, function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG4);
            }
            ComposableExtKt.j(null, (Function2) objG4, composerK, 0, 1);
            q0(troubleshootingStackViewModel, composerK, i4 & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivity.x0(this.f123022a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f122966f;
    }
}
