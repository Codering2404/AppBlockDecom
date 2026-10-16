package cz.mobilesoft.coreblock.view.bottomsheet;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.compose.FlowExtKt;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.ViewBottomButtonsBinding;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.profile.ProfileItemType;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
public abstract class ProfileListBottomSheet extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ComposeView f130203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f130204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f130205d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f130206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f130207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f130208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MutableStateFlow f130209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MutableStateFlow f130210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MutableStateFlow f130211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f130212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f130213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ActivityResultLauncher f130214n;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileListBottomSheet() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f130206f = LazyKt.a(lazyThreadSafetyMode, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ApplicationProfileRelationDao.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f130207g = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f130208h = LazyKt.a(lazyThreadSafetyMode, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StrictModeRepository.class), objArr4, objArr5);
            }
        });
        this.f130209i = StateFlowKt.a(null);
        this.f130210j = StateFlowKt.a(SetsKt.emptySet());
        this.f130211k = StateFlowKt.a(Float.valueOf(0.0f));
        this.f130213m = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ProfileListBottomSheet.p0(this.f130244a));
            }
        });
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProfileListBottomSheet.X(this.f130245a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f130214n = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(State state, final State state2, final ScaffoldState scaffoldState, final ProfileListBottomSheet profileListBottomSheet, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List list = (List) state.getValue();
        if (list != null) {
            final Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileListBottomSheet.R((ProfileViewDTO) obj);
                }
            };
            final ProfileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$1 profileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Object obj) {
                    return null;
                }
            };
            LazyColumn.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return function1.invoke(list.get(i3));
                }
            }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return profileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$1.invoke(list.get(i3));
                }
            }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$RootCompose$lambda$0$0$0$0$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                    int i5;
                    if ((i4 & 6) == 0) {
                        i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
                    } else {
                        i5 = i4;
                    }
                    if ((i4 & 48) == 0) {
                        i5 |= composer.e(i3) ? 32 : 16;
                    }
                    if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    final ProfileViewDTO profileViewDTO = (ProfileViewDTO) list.get(i3);
                    composer.a0(-750347368);
                    boolean Z = composer.Z(state2);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        final State state3 = state2;
                        objG = SnapshotStateKt.e(new Function0<Boolean>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$RootCompose$1$1$1$1$2$isSelected$1$1
                            @Override // kotlin.jvm.functions.Function0
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final Boolean invoke() {
                                return Boolean.valueOf(((Set) state3.getValue()).contains(Long.valueOf(profileViewDTO.k())));
                            }
                        });
                        composer.w(objG);
                    }
                    ScaffoldState scaffoldState2 = scaffoldState;
                    Boolean bool = (Boolean) ((State) objG).getValue();
                    boolean zI = composer.I(profileListBottomSheet);
                    Object objG2 = composer.G();
                    if (zI || objG2 == Composer.f23746a.a()) {
                        objG2 = new ProfileListBottomSheet$RootCompose$1$1$1$1$2$1$1(profileListBottomSheet);
                        composer.w(objG2);
                    }
                    ProfileItemKt.I0(scaffoldState2, profileViewDTO, null, bool, false, null, (Function1) ((KFunction) objG2), composer, 384, 48);
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
        } else {
            LazyListScope.c(LazyColumn, null, null, ComposableSingletons$ProfileListBottomSheetKt.f130196a.b(), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object R(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "profile_" + it.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(ProfileListBottomSheet profileListBottomSheet, int i3, Composer composer, int i4) {
        profileListBottomSheet.P(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ProfileListBottomSheet profileListBottomSheet, ActivityResult result) {
        Intent intentC;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() != -1 || (intentC = result.c()) == null) {
            return;
        }
        Long lValueOf = Long.valueOf(intentC.getLongExtra("PROFILE_ID", -1L));
        if (lValueOf.longValue() == -1) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            profileListBottomSheet.x0(lValueOf.longValue());
        }
    }

    private final StrictModeRepository j0() {
        return (StrictModeRepository) this.f130208h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(ProfileItemEvent profileItemEvent) {
        if (profileItemEvent instanceof ProfileItemEvent.OnProfileSelected) {
            ProfileItemEvent.OnProfileSelected onProfileSelected = (ProfileItemEvent.OnProfileSelected) profileItemEvent;
            y0(onProfileSelected.a(), onProfileSelected.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ProfileListBottomSheet profileListBottomSheet, List list, Set selectedIDs) {
        Intrinsics.checkNotNullParameter(selectedIDs, "selectedIDs");
        boolean z2 = true;
        if (list == null || !(!list.isEmpty())) {
            profileListBottomSheet.a0().setText(R.string.g4);
            profileListBottomSheet.a0().setEnabled(true);
            profileListBottomSheet.g0().setVisibility(8);
        } else {
            profileListBottomSheet.a0().setText(R.string.d8);
            Button buttonA0 = profileListBottomSheet.a0();
            if (selectedIDs.isEmpty() && profileListBottomSheet.o0()) {
                z2 = false;
            }
            buttonA0.setEnabled(z2);
            profileListBottomSheet.g0().setVisibility(0);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0(ProfileListBottomSheet profileListBottomSheet) {
        return profileListBottomSheet.j0().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(final ProfileListBottomSheet profileListBottomSheet, DialogInterface dialogInterface) {
        profileListBottomSheet.f0().setContent(ComposableLambdaKt.c(1735971731, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ProfileListBottomSheet.s0(this.f130247a, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final ViewGroup viewGroup = (ViewGroup) ((BottomSheetDialog) dialogInterface).findViewById(com.google.android.material.R.id.f79628e);
        if (viewGroup != null) {
            int color = ContextCompat.getColor(viewGroup.getContext(), R.color.f95448c);
            Object parent = profileListBottomSheet.f0().getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setBackgroundTintList(ColorStateList.valueOf(color));
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            final ViewBottomButtonsBinding viewBottomButtonsBindingC = ViewBottomButtonsBinding.c(profileListBottomSheet.getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(viewBottomButtonsBindingC, "inflate(...)");
            Button bottomButton = viewBottomButtonsBindingC.f96856b;
            Intrinsics.checkNotNullExpressionValue(bottomButton, "bottomButton");
            profileListBottomSheet.C0(bottomButton);
            Button secondaryButton = viewBottomButtonsBindingC.f96858d;
            Intrinsics.checkNotNullExpressionValue(secondaryButton, "secondaryButton");
            profileListBottomSheet.E0(secondaryButton);
            profileListBottomSheet.g0().setText(R.string.g4);
            View gradientView = viewBottomButtonsBindingC.f96857c;
            Intrinsics.checkNotNullExpressionValue(gradientView, "gradientView");
            gradientView.setVisibility(8);
            viewBottomButtonsBindingC.getRoot().setBackgroundColor(color);
            ViewTreeObserver viewTreeObserver = viewBottomButtonsBindingC.getRoot().getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet$onCreateDialog$1$2$1$listener$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        viewBottomButtonsBindingC.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        profileListBottomSheet.f130211k.setValue(Float.valueOf(ViewHelper.j(viewBottomButtonsBindingC.getRoot().getHeight(), viewGroup.getContext())));
                    }
                });
            }
            viewGroup.addView(viewBottomButtonsBindingC.getRoot());
            profileListBottomSheet.a0().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileListBottomSheet.u0(this.f130248a, view);
                }
            });
            profileListBottomSheet.g0().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileListBottomSheet.v0(this.f130249a, view);
                }
            });
            profileListBottomSheet.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(final ProfileListBottomSheet profileListBottomSheet, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1735971731, i3, -1, "cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet.onCreateDialog.<anonymous>.<anonymous>.<anonymous> (ProfileListBottomSheet.kt:137)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(-421835646, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileListBottomSheet.t0(this.f130251a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(ProfileListBottomSheet profileListBottomSheet, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-421835646, i3, -1, "cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet.onCreateDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileListBottomSheet.kt:138)");
            }
            profileListBottomSheet.P(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ProfileListBottomSheet profileListBottomSheet, View view) {
        profileListBottomSheet.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ProfileListBottomSheet profileListBottomSheet, View view) {
        profileListBottomSheet.z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(boolean z2, ProfileViewDTO profileViewDTO) {
        if (!z2 || W(profileViewDTO)) {
            Set mutableSet = CollectionsKt.toMutableSet((Iterable) this.f130210j.getValue());
            if (!mutableSet.remove(Long.valueOf(profileViewDTO.k()))) {
                mutableSet.add(Long.valueOf(profileViewDTO.k()));
            }
            this.f130210j.setValue(mutableSet);
        }
    }

    protected final void A0(Long l3) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            CoroutinesHelperExtKt.e(activity, new ProfileListBottomSheet$reloadProfiles$1$1(activity, this, l3, null));
        }
    }

    public final void C0(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.f130204c = button;
    }

    public final void D0(ComposeView composeView) {
        Intrinsics.checkNotNullParameter(composeView, "<set-?>");
        this.f130203b = composeView;
    }

    public final void E0(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.f130205d = button;
    }

    public final void P(Composer composer, final int i3) {
        int i4;
        final ProfileListBottomSheet profileListBottomSheet = this;
        Composer composerK = composer.k(1464564204);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(profileListBottomSheet) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1464564204, i4, -1, "cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet.RootCompose (ProfileListBottomSheet.kt:209)");
            }
            final State stateB = FlowExtKt.b(profileListBottomSheet.f130209i, null, null, null, null, composerK, 48, 14);
            final State stateB2 = FlowExtKt.b(profileListBottomSheet.f130210j, SetsKt.emptySet(), null, null, null, composerK, 48, 14);
            State stateB3 = FlowExtKt.b(profileListBottomSheet.f130211k, Float.valueOf(0.0f), null, null, null, composerK, 48, 14);
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(BackgroundKt.d(NestedScrollModifierKt.b(companion, NestedScrollInteropConnectionKt.h(null, composerK, 0, 1), null, 2, null), Color.f25715b.j(), null, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(8), 7, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(profileListBottomSheet.k0(), composerK, 0), SizeKt.h(PaddingKt.k(companion, 0.0f, Dp.g(24), 1, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 48, 0, 65016);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(16));
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(((Number) stateB3.getValue()).floatValue()), 7, null), 0.0f, 1, null);
            boolean Z = composerK.Z(stateB) | composerK.Z(stateB2) | composerK.Z(scaffoldStateG) | composerK.I(this);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileListBottomSheet.Q(stateB, stateB2, scaffoldStateG, this, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            profileListBottomSheet = this;
            LazyDslKt.b(modifierH, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composerK, 24576, 494);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileListBottomSheet.S(this.f130256a, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public abstract boolean W(ProfileViewDTO profileViewDTO);

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApplicationProfileRelationDao Y() {
        return (ApplicationProfileRelationDao) this.f130206f.getValue();
    }

    protected final ActivityResultLauncher Z() {
        return this.f130214n;
    }

    public final Button a0() {
        Button button = this.f130204c;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("primaryButton");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ProfileDao b0() {
        return (ProfileDao) this.f130207g.getValue();
    }

    public abstract ProfileItemType c0();

    protected final MutableStateFlow d0() {
        return this.f130209i;
    }

    public abstract Object e0(Continuation continuation);

    public final ComposeView f0() {
        ComposeView composeView = this.f130203b;
        if (composeView != null) {
            return composeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    public final Button g0() {
        Button button = this.f130205d;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secondaryButton");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableStateFlow h0() {
        return this.f130210j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String i0() {
        return this.f130212l;
    }

    public abstract int k0();

    protected final void m0() {
        FlowsExtKt.a(this, this.f130209i, this.f130210j, new Function2() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ProfileListBottomSheet.n0(this.f130250a, (List) obj, (Set) obj2);
            }
        });
    }

    public abstract boolean o0();

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ProfileListBottomSheet.q0(this.f130246a, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.setupDialog(dialog, i3);
        Fragment targetFragment = getTargetFragment();
        this.f130212l = targetFragment != null ? targetFragment.getClass().getSimpleName() : null;
        B0(this, null, 1, null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        D0(new ComposeView(contextRequireContext, null, 0, 6, null));
        dialog.setContentView(f0());
    }

    public abstract void w0();

    public abstract void x0(long j3);

    public abstract void z0();

    public static /* synthetic */ void B0(ProfileListBottomSheet profileListBottomSheet, Long l3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(pnxuebdT.iIim);
        }
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        profileListBottomSheet.A0(l3);
    }
}
