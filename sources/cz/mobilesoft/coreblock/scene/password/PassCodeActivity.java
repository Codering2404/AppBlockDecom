package cz.mobilesoft.coreblock.scene.password;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class PassCodeActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f111670f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f111671g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, PassCodeType passCodeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(passCodeType, "passCodeType");
            Intent intent = new Intent(context, (Class<?>) PassCodeActivity.class);
            intent.putExtra("PASS_CODE_TYPE", passCodeType);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(PassCodeActivity passCodeActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        passCodeActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder t0(PassCodeType passCodeType) {
        return ParametersHolderKt.b(passCodeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(PassCodeType passCodeType, PassCodeActivity passCodeActivity) {
        if (passCodeType == PassCodeType.Remove || passCodeType == PassCodeType.Create) {
            passCodeActivity.finish();
        } else {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                passCodeActivity.startActivity(intent);
            } catch (Exception unused) {
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(PassCodeType passCodeType, final PassCodeActivity passCodeActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1644385242, i3, -1, "cz.mobilesoft.coreblock.scene.password.PassCodeActivity.RootCompose.<anonymous> (PassCodeActivity.kt:48)");
            }
            if (passCodeType == PassCodeType.Remove || passCodeType == PassCodeType.Create) {
                composer.a0(516341791);
                boolean zI = composer.I(passCodeActivity);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.password.a0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PassCodeActivity.w0(this.f111698a);
                        }
                    };
                    composer.w(objG);
                }
                ToolbarKt.e(null, (Function0) objG, null, false, ToolbarButtonType.Close, false, false, null, null, composer, 24576, FacebookRequestErrorClassification.ESC_APP_INACTIVE);
                composer.U();
            } else {
                composer.a0(514485852);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(PassCodeActivity passCodeActivity) {
        passCodeActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(PassCodeViewModel passCodeViewModel, final PassCodeActivity passCodeActivity, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(604701343, i3, -1, "cz.mobilesoft.coreblock.scene.password.PassCodeActivity.RootCompose.<anonymous> (PassCodeActivity.kt:56)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            boolean zI = composer.I(passCodeActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.password.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PassCodeActivity.y0(this.f111763a, (String) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean zI2 = composer.I(passCodeActivity);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.password.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PassCodeActivity.z0(this.f111764a);
                    }
                };
                composer.w(objG2);
            }
            PassCodeScreenKt.G(modifierH, passCodeViewModel, true, function1, (Function0) objG2, composer, 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(PassCodeActivity passCodeActivity, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        passCodeActivity.setResult(-1);
        passCodeActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(PassCodeActivity passCodeActivity) {
        passCodeActivity.finish();
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-190357791);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-190357791, i4, -1, "cz.mobilesoft.coreblock.scene.password.PassCodeActivity.RootCompose (PassCodeActivity.kt:28)");
            }
            Serializable serializableExtra = getIntent().getSerializableExtra("PASS_CODE_TYPE");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.password.PassCodeType");
            final PassCodeType passCodeType = (PassCodeType) serializableExtra;
            boolean zE = composerK.e(passCodeType.ordinal());
            Object objG = composerK.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.password.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PassCodeActivity.t0(passCodeType);
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
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(PassCodeViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            final PassCodeViewModel passCodeViewModel = (PassCodeViewModel) viewModelA;
            boolean zE2 = composerK.e(passCodeType.ordinal()) | composerK.I(this);
            Object objG2 = composerK.G();
            if (zE2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.password.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PassCodeActivity.u0(passCodeType, this);
                    }
                };
                composerK.w(objG2);
            }
            BackHandlerKt.a(false, (Function0) objG2, composerK, 0, 1);
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(-1644385242, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeActivity.v0(passCodeType, this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(604701343, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.password.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PassCodeActivity.x0(passCodeViewModel, this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeActivity.A0(this.f111760a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
