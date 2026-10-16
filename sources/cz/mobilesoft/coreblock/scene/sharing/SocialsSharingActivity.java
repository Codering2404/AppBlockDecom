package cz.mobilesoft.coreblock.scene.sharing;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
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
public final class SocialsSharingActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f119356f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f119357g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, SocialsSharePayload graphPayload) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(graphPayload, "graphPayload");
            Intent intent = new Intent(context, (Class<?>) SocialsSharingActivity.class);
            intent.putExtra("extra_graph_payload", graphPayload);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(SocialsSharingActivity socialsSharingActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        socialsSharingActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder p0(SocialsSharePayload socialsSharePayload) {
        return ParametersHolderKt.b(socialsSharePayload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(SocialsSharingActivity socialsSharingActivity) {
        socialsSharingActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(SocialsSharingActivity socialsSharingActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        socialsSharingActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Parcelable parcelable;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-2116415768);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2116415768, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialsSharingActivity.RootCompose (SocialsSharingActivity.kt:28)");
            }
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            CreationExtras creationExtrasA = null;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) intent.getParcelableExtra("extra_graph_payload", SocialsSharePayload.class);
            } else {
                Parcelable parcelableExtra = intent.getParcelableExtra("extra_graph_payload");
                if (!(parcelableExtra instanceof SocialsSharePayload)) {
                    parcelableExtra = null;
                }
                parcelable = (SocialsSharePayload) parcelableExtra;
            }
            final SocialsSharePayload socialsSharePayload = (SocialsSharePayload) parcelable;
            if (socialsSharePayload == null) {
                finish();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.s
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SocialsSharingActivity.o0(this.f119589a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            boolean zI = composerK.I(socialsSharePayload);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialsSharingActivity.p0(socialsSharePayload);
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
            CreationExtras creationExtrasA2 = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(SocialsSharingViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA == null ? creationExtrasA2 : creationExtrasA, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            SocialsSharingViewModel socialsSharingViewModel = (SocialsSharingViewModel) viewModelA;
            SocialsSharingViewState socialsSharingViewState = (SocialsSharingViewState) FlowExtKt.m(socialsSharingViewModel, composerK, 0);
            Function1 function1N = FlowExtKt.n(socialsSharingViewModel, composerK, 0);
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialsSharingActivity.q0(this.f119593a);
                    }
                };
                composerK.w(objG2);
            }
            SocialSharingScreenKt.p(paddingValues, socialsSharingViewState, function1N, (Function0) objG2, composerK, i4 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialsSharingActivity.s0(this.f119594a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }
}
