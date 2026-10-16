package cz.mobilesoft.coreblock.scene.permission;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionKt;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionsDTO;
import cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreenKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$1;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$2;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$3;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class PermissionActivity extends BaseComposeActivity implements KoinComponent {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f111772j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f111773k = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f111774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f111775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f111776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f111777i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, Collection collection, boolean z2, boolean z3, boolean z4, Boolean bool, Integer num, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = true;
            }
            if ((i3 & 8) != 0) {
                z3 = true;
            }
            if ((i3 & 16) != 0) {
                z4 = true;
            }
            if ((i3 & 32) != 0) {
                bool = null;
            }
            if ((i3 & 64) != 0) {
                num = null;
            }
            return companion.a(context, collection, z2, z3, z4, bool, num);
        }

        public final Intent a(Context context, Collection permissions, boolean z2, boolean z3, boolean z4, Boolean bool, Integer num) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.putExtra("PERMISSIONS", new ArrayList(permissions));
            intent.putExtra("ALLOW_SKIPPING_PERMISSIONS", z2);
            intent.putExtra("IS_PROBLEMS", z3);
            intent.putExtra("ANIMATE_SUCCESS", z4);
            if (bool != null) {
                intent.putExtra("IS_FOR_WIFI", bool.booleanValue());
            }
            if (num != null) {
                intent.putExtra("PROBLEM_TITLE_RES", num.intValue());
            }
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionActivity() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f111775g = LazyKt.a(lazyThreadSafetyModeB, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.permission.PermissionActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f111776h = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PermissionsHandler>() { // from class: cz.mobilesoft.coreblock.scene.permission.PermissionActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PermissionsHandler.class), objArr2, objArr3);
            }
        });
        this.f111777i = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionActivity.C0(this.f111809a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionsDTO C0(PermissionActivity permissionActivity) {
        ArrayList arrayList = (ArrayList) permissionActivity.getIntent().getSerializableExtra("PERMISSIONS");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        long longExtra = permissionActivity.getIntent().getLongExtra("PROFILE_ID", -1L);
        int intExtra = permissionActivity.getIntent().getIntExtra("PROFILE_TYPE_COMBINATIONS", 0);
        boolean booleanExtra = permissionActivity.getIntent().getBooleanExtra("IS_TILE_SERVICE", false);
        boolean booleanExtra2 = permissionActivity.getIntent().getBooleanExtra("ALLOW_SKIPPING_PERMISSIONS", true);
        boolean booleanExtra3 = permissionActivity.getIntent().getBooleanExtra("IS_PROBLEMS", true);
        boolean booleanExtra4 = permissionActivity.getIntent().getBooleanExtra("ANIMATE_SUCCESS", true);
        Integer numValueOf = Integer.valueOf(permissionActivity.getIntent().getIntExtra("PROBLEM_TITLE_RES", 0));
        return new PermissionsDTO(arrayList2, longExtra, intExtra, booleanExtra, booleanExtra2, booleanExtra3, booleanExtra4, permissionActivity.getIntent().hasExtra("IS_FOR_WIFI") ? Boolean.valueOf(permissionActivity.getIntent().getBooleanExtra("IS_FOR_WIFI", false)) : null, false, numValueOf.intValue() != 0 ? numValueOf : null, Function.MAX_NARGS, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(PermissionActivity permissionActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        permissionActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final PermissionActivity permissionActivity, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1072248438, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.permission.g
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PermissionActivity.v0(this.f111818a, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavigationKt$animatedComposable$1 navigationKt$animatedComposable$1 = NavigationKt$animatedComposable$1.f130488a;
        NavigationKt$animatedComposable$2 navigationKt$animatedComposable$2 = NavigationKt$animatedComposable$2.f130490a;
        NavigationKt$animatedComposable$3 navigationKt$animatedComposable$3 = NavigationKt$animatedComposable$3.f130492a;
        NavigationKt$animatedComposable$4 navigationKt$animatedComposable$4 = NavigationKt$animatedComposable$4.f130494a;
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavPermissionStack.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-876817919, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.permission.h
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PermissionActivity.w0(this.f111820a, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavSinglePermission.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(377964098, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.permission.i
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PermissionActivity.x0(this.f111822a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavLocationPermission.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(PermissionActivity permissionActivity, NavHostController navHostController, AnimatedContentScope animatedComposable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1072248438, i3, -1, "cz.mobilesoft.coreblock.scene.permission.PermissionActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PermissionActivity.kt:134)");
        }
        PermissionListScreenKt.E(permissionActivity.A0(), permissionActivity.B0(), navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(PermissionActivity permissionActivity, NavHostController navHostController, AnimatedContentScope animatedComposable, NavBackStackEntry backstackEntry, Composer composer, int i3) {
        Object next;
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(backstackEntry, "backstackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(-876817919, i3, -1, "cz.mobilesoft.coreblock.scene.permission.PermissionActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PermissionActivity.kt:141)");
        }
        NavSinglePermission navSinglePermission = (NavSinglePermission) NavBackStackEntryKt.a(backstackEntry, Reflection.b(NavSinglePermission.class));
        Iterator it = permissionActivity.A0().e().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(PermissionKt.a(((PermissionDTO) next).e()), navSinglePermission.a())) {
                break;
            }
        }
        PermissionDTO permissionDTO = (PermissionDTO) next;
        PermissionsDTO permissionsDTOB = permissionDTO != null ? PermissionsDTO.b(permissionActivity.A0(), CollectionsKt.listOf(permissionDTO), 0L, 0, false, false, false, false, null, permissionActivity.A0().e().size() > 1, null, 766, null) : null;
        if (permissionsDTOB == null) {
            navHostController.R();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return Unit.f139807a;
        }
        SinglePermissionScreenKt.n(permissionsDTOB, permissionActivity.B0(), navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(final PermissionActivity permissionActivity, AnimatedContentScope animatedComposable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(377964098, i3, -1, "cz.mobilesoft.coreblock.scene.permission.PermissionActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PermissionActivity.kt:170)");
        }
        Boolean boolH = permissionActivity.A0().h();
        boolean zBooleanValue = boolH != null ? boolH.booleanValue() : (ProfileType.WIFI.mask() & permissionActivity.A0().g()) > 0;
        boolean zC = permissionActivity.A0().c();
        boolean zI = composer.I(permissionActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PermissionActivity.y0(this.f111823a);
                }
            };
            composer.w(objG);
        }
        LocationPermissionScreenKt.X(zBooleanValue, zC, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(PermissionActivity permissionActivity) {
        permissionActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(PermissionActivity permissionActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        permissionActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public final PermissionsDTO A0() {
        return (PermissionsDTO) this.f111777i.getValue();
    }

    public final PermissionsHandler B0() {
        return (PermissionsHandler) this.f111776h.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(193196237);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(193196237, i4, -1, "cz.mobilesoft.coreblock.scene.permission.PermissionActivity.RootCompose (PermissionActivity.kt:106)");
            }
            PermissionDTO permissionDTO = (PermissionDTO) CollectionsKt.firstOrNull(A0().e());
            if (permissionDTO == null) {
                composerK.a0(253083757);
                Unit unit = Unit.f139807a;
                boolean zI = composerK.I(this);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new PermissionActivity$RootCompose$1$1(this, null);
                    composerK.w(objG);
                }
                EffectsKt.g(unit, (Function2) objG, composerK, 6);
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PermissionActivity.t0(this.f111810a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composerK.a0(248474677);
            composerK.U();
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            Object navSinglePermission = A0().e().size() > 1 ? NavPermissionStack.INSTANCE : permissionDTO.e() instanceof Permission.LOCATION ? NavLocationPermission.INSTANCE : new NavSinglePermission(PermissionKt.a(permissionDTO.e()));
            boolean zI2 = composerK.I(this) | composerK.I(navHostControllerB);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PermissionActivity.u0(this.f111813a, navHostControllerB, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG2);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navSinglePermission, null, null, null, null, null, null, null, null, null, (Function1) objG2, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionActivity.z0(this.f111815a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f111774f;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
