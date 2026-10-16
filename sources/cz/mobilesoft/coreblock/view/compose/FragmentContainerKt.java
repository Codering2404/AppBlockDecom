package cz.mobilesoft.coreblock.view.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class FragmentContainerKt {
    public static final void f(Modifier modifier, final Function2 commit, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(commit, "commit");
        Composer composerK = composer.k(-1417530743);
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
            i5 |= composerK.I(commit) ? 32 : 16;
        }
        int i7 = i5;
        if (composerK.r((i7 & 19) != 18, i7 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1417530743, i7, -1, "cz.mobilesoft.coreblock.view.compose.FragmentContainer (FragmentContainer.kt:16)");
            }
            View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            boolean Z = composerK.Z(view);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                try {
                    objG = ViewKt.a(view);
                } catch (IllegalStateException unused) {
                    objG = null;
                }
                composerK.w(objG);
            }
            final Fragment fragment = (Fragment) objG;
            Object[] objArr = new Object[0];
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.o8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FragmentContainerKt.g();
                    }
                };
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) RememberSaveableKt.e(objArr, null, null, (Function0) objG2, composerK, 0, 6);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState2 = (MutableState) objG3;
            boolean Z2 = composerK.Z(view);
            Object objG4 = composerK.G();
            if (Z2 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.p8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FragmentContainerKt.i(mutableState, fragment, mutableState2, commit, (Context) obj);
                    }
                };
                composerK.w(objG4);
            }
            Function1 function1 = (Function1) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.q8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FragmentContainerKt.j((View) obj);
                    }
                };
                composerK.w(objG5);
            }
            Modifier modifier5 = modifier4;
            AndroidView_androidKt.a(function1, modifier5, (Function1) objG5, composerK, ((i7 << 3) & 112) | 384, 0);
            modifier3 = modifier5;
            composerK = composerK;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(fragment) | composerK.I(context);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.r8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FragmentContainerKt.k(fragment, context, mutableState2, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG6);
            }
            EffectsKt.a(view, context, mutableState2, (Function1) objG6, composerK, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.s8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FragmentContainerKt.l(modifier3, commit, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState g() {
        return SnapshotStateKt__SnapshotStateKt.e(Integer.valueOf(View.generateViewId()), null, 2, null);
    }

    private static final int h(MutableState mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentContainerView i(MutableState mutableState, Fragment fragment, MutableState mutableState2, Function2 function2, Context context) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(context, "context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(h(mutableState));
        if (fragment == null || (supportFragmentManager = fragment.getChildFragmentManager()) == null) {
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
        }
        if (supportFragmentManager != null) {
            FragmentTransaction fragmentTransactionQ = supportFragmentManager.q();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
            function2.invoke(fragmentTransactionQ, Integer.valueOf(fragmentContainerView.getId()));
            fragmentTransactionQ.j();
        }
        mutableState2.setValue(fragmentContainerView);
        return fragmentContainerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult k(final Fragment fragment, final Context context, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.view.compose.FragmentContainerKt$FragmentContainer$lambda$6$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                FragmentManager supportFragmentManager;
                Fragment fragment2 = fragment;
                Fragment fragmentM0 = null;
                if (fragment2 == null || (supportFragmentManager = fragment2.getChildFragmentManager()) == null) {
                    Context context2 = context;
                    FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                    supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
                }
                if (supportFragmentManager != null) {
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) mutableState.getValue();
                    fragmentM0 = supportFragmentManager.m0(fragmentContainerView != null ? fragmentContainerView.getId() : 0);
                }
                if (fragmentM0 == null || supportFragmentManager.Y0()) {
                    return;
                }
                FragmentTransaction fragmentTransactionQ = supportFragmentManager.q();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
                fragmentTransactionQ.r(fragmentM0);
                fragmentTransactionQ.j();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, Function2 function2, int i3, int i4, Composer composer, int i5) {
        f(modifier, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
