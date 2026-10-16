package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.preview_disabled.SchedulePreviewInactiveScreenKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
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
public final class SchedulePreviewActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f117350g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f117351h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f117352f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, ProfileViewDTO profileViewDTO, boolean z2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            return companion.a(context, profileViewDTO, z2);
        }

        public final Intent a(Context context, ProfileViewDTO profileViewDTO, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            Intent intent = new Intent(context, (Class<?>) SchedulePreviewActivity.class);
            intent.putExtra("PROFILE_VIEW_DTO", profileViewDTO);
            intent.putExtra("IS_NOT_ACTIVE", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            function1.invoke(SchedulePreviewViewEvent.OnProfileUpdated.f117405a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(SchedulePreviewActivity schedulePreviewActivity, SchedulePreviewViewModel schedulePreviewViewModel, Function1 function1, ScaffoldState scaffoldState, Function0 function0, int i3, Composer composer, int i4) {
        schedulePreviewActivity.A0(schedulePreviewViewModel, function1, scaffoldState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder D0(ProfileViewDTO profileViewDTO) {
        return ParametersHolderKt.b(profileViewDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(SchedulePreviewActivity schedulePreviewActivity) {
        schedulePreviewActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(final NavHostController navHostController, boolean z2, final SchedulePreviewViewState schedulePreviewViewState, final Function1 function1, final SchedulePreviewActivity schedulePreviewActivity, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(159328329, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.RootCompose.<anonymous> (SchedulePreviewActivity.kt:92)");
            }
            Object obj = z2 ? NavSchedulePreviewInactive.INSTANCE : NavSchedulePreview.INSTANCE;
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            boolean Z = composer.Z(schedulePreviewViewState) | composer.Z(function1) | composer.I(schedulePreviewActivity) | composer.I(navHostController);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SchedulePreviewActivity.G0(schedulePreviewViewState, function1, schedulePreviewActivity, navHostController, (NavGraphBuilder) obj2);
                    }
                };
                composer.w(objG);
            }
            NavHostKt.u(navHostController, obj, modifierH, null, null, null, null, null, null, null, null, (Function1) objG, composer, 0, 0, 2040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(final SchedulePreviewViewState schedulePreviewViewState, final Function1 function1, final SchedulePreviewActivity schedulePreviewActivity, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1043888374, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SchedulePreviewActivity.H0(schedulePreviewViewState, function1, schedulePreviewActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavSchedulePreview.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-870629503, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SchedulePreviewActivity.K0(schedulePreviewViewState, function1, schedulePreviewActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavSchedulePreviewInactive.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(1268210370, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SchedulePreviewActivity.N0(schedulePreviewViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavScheduleBlockingDetail.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, final SchedulePreviewActivity schedulePreviewActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1043888374, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewActivity.kt:99)");
        }
        boolean zI = composer.I(schedulePreviewActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SchedulePreviewActivity.I0(this.f117684a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SchedulePreviewActivity.J0(navHostController);
                }
            };
            composer.w(objG2);
        }
        SchedulePreviewScreenKt.W0(schedulePreviewViewState, function1, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(SchedulePreviewActivity schedulePreviewActivity) {
        schedulePreviewActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(NavHostController navHostController) {
        NavController.O(navHostController, NavScheduleBlockingDetail.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, final SchedulePreviewActivity schedulePreviewActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-870629503, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewActivity.kt:112)");
        }
        boolean zI = composer.I(schedulePreviewActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SchedulePreviewActivity.L0(this.f117706a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SchedulePreviewActivity.M0(navHostController);
                }
            };
            composer.w(objG2);
        }
        SchedulePreviewInactiveScreenKt.p(schedulePreviewViewState, function1, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(SchedulePreviewActivity schedulePreviewActivity) {
        schedulePreviewActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(NavHostController navHostController) {
        NavController.O(navHostController, NavScheduleBlockingDetail.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(SchedulePreviewViewState schedulePreviewViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1268210370, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewActivity.kt:125)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SchedulePreviewActivity.O0(navHostController);
                }
            };
            composer.w(objG);
        }
        SchedulePreviewBlockingDetailScreenKt.N(schedulePreviewViewState, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(SchedulePreviewActivity schedulePreviewActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        schedulePreviewActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public final void A0(final SchedulePreviewViewModel viewModel, final Function1 onEvent, final ScaffoldState scaffoldState, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-1552876052);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1552876052, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.CommandProcessor (SchedulePreviewActivity.kt:145)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z2 = (i5 & 112) == 32;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewActivity.B0(onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 0);
            boolean zI = composerK.I(context) | ((i5 & 7168) == 2048) | composerK.I(managedActivityResultLauncherA) | composerK.I(coroutineScope) | ((i5 & 896) == 256) | composerK.I(this);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                SchedulePreviewActivity$CommandProcessor$1$1 schedulePreviewActivity$CommandProcessor$1$1 = new SchedulePreviewActivity$CommandProcessor$1$1(managedActivityResultLauncherA, context, onCloseClicked, coroutineScope, this, scaffoldState, null);
                composerK.w(schedulePreviewActivity$CommandProcessor$1$1);
                objG3 = schedulePreviewActivity$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(viewModel, null, (Function2) objG3, composer2, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewActivity.C0(this.f117810a, viewModel, onEvent, scaffoldState, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
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
        Composer composer2;
        final SchedulePreviewActivity schedulePreviewActivity;
        Object serializableExtra;
        Bundle bundleB;
        final SchedulePreviewActivity schedulePreviewActivity2 = this;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(821561099);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(schedulePreviewActivity2) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(821561099, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity.RootCompose (SchedulePreviewActivity.kt:66)");
            }
            Intent intent = schedulePreviewActivity2.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            if (Build.VERSION.SDK_INT >= 33) {
                serializableExtra = intent.getSerializableExtra("PROFILE_VIEW_DTO", ProfileViewDTO.class);
            } else {
                Serializable serializableExtra2 = intent.getSerializableExtra("PROFILE_VIEW_DTO");
                if (!(serializableExtra2 instanceof ProfileViewDTO)) {
                    serializableExtra2 = null;
                }
                serializableExtra = (ProfileViewDTO) serializableExtra2;
            }
            final ProfileViewDTO profileViewDTO = (ProfileViewDTO) serializableExtra;
            final boolean booleanExtra = schedulePreviewActivity2.getIntent().getBooleanExtra("IS_NOT_ACTIVE", false);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            boolean Z = composerK.Z(profileViewDTO);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewActivity.D0(profileViewDTO);
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
            KClass kClassB = Reflection.b(SchedulePreviewViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            SchedulePreviewViewModel schedulePreviewViewModel = (SchedulePreviewViewModel) viewModelA;
            final SchedulePreviewViewState schedulePreviewViewState = (SchedulePreviewViewState) FlowExtKt.m(schedulePreviewViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(schedulePreviewViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            boolean zI = composerK.I(schedulePreviewActivity2);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewActivity.E0(this.f117729a);
                    }
                };
                composerK.w(objG2);
            }
            schedulePreviewActivity2.A0(schedulePreviewViewModel, function1N, scaffoldStateG, (Function0) objG2, composerK, 57344 & (i4 << 9));
            SchedulePreviewActivity schedulePreviewActivity3 = this;
            Composer composer3 = composerK;
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$SchedulePreviewActivityKt.f117336a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(159328329, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulePreviewActivity.F0(navHostControllerB, booleanExtra, schedulePreviewViewState, function1N, this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer3, 24576, 12582912, 131053);
            schedulePreviewActivity = schedulePreviewActivity3;
            composer2 = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
                schedulePreviewActivity = schedulePreviewActivity3;
                composer2 = composer3;
            }
        } else {
            Composer composer4 = composerK;
            composer4.Q();
            schedulePreviewActivity = schedulePreviewActivity2;
            composer2 = composer4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewActivity.P0(this.f117749a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f117352f;
    }
}
