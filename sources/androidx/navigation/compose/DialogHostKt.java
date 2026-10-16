package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.DialogNavigator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DialogHostKt {
    public static final void f(final DialogNavigator dialogNavigator, Composer composer, final int i3) {
        final DialogNavigator dialogNavigator2;
        Composer composerK = composer.k(294589392);
        int i4 = (i3 & 6) == 0 ? (composerK.I(dialogNavigator) ? 4 : 2) | i3 : i3;
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            dialogNavigator2 = dialogNavigator;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(294589392, i4, -1, "androidx.navigation.compose.DialogHost (DialogHost.kt:40)");
            }
            SaveableStateHolder saveableStateHolderA = SaveableStateHolderKt.a(composerK, 0);
            State stateB = SnapshotStateKt.b(dialogNavigator.r(), null, composerK, 0, 1);
            SnapshotStateList<NavBackStackEntry> snapshotStateListP = p(g(stateB), composerK, 0);
            k(snapshotStateListP, g(stateB), composerK, 0);
            State stateB2 = SnapshotStateKt.b(dialogNavigator.s(), null, composerK, 0, 1);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.f();
                composerK.w(objG);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
            composerK.a0(-367418626);
            for (final NavBackStackEntry navBackStackEntry : snapshotStateListP) {
                NavDestination navDestinationD = navBackStackEntry.d();
                Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.compose.DialogNavigator.Destination");
                DialogNavigator.Destination destination = (DialogNavigator.Destination) navDestinationD;
                boolean zI = composerK.I(dialogNavigator) | composerK.I(navBackStackEntry);
                Object objG2 = composerK.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: androidx.navigation.compose.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DialogHostKt.i(dialogNavigator, navBackStackEntry);
                        }
                    };
                    composerK.w(objG2);
                }
                DialogNavigator dialogNavigator3 = dialogNavigator;
                AndroidDialog_androidKt.a((Function0) objG2, destination.I(), ComposableLambdaKt.e(1129586364, true, new DialogHostKt$DialogHost$1$2(navBackStackEntry, dialogNavigator3, saveableStateHolderA, snapshotStateList, destination), composerK, 54), composerK, 384, 0);
                dialogNavigator = dialogNavigator3;
            }
            dialogNavigator2 = dialogNavigator;
            composerK.U();
            Set setH = h(stateB2);
            boolean Z = composerK.Z(stateB2) | composerK.I(dialogNavigator2);
            Object objG3 = composerK.G();
            if (Z || objG3 == Composer.f23746a.a()) {
                objG3 = new DialogHostKt$DialogHost$2$1(stateB2, dialogNavigator2, snapshotStateList, null);
                composerK.w(objG3);
            }
            EffectsKt.f(setH, snapshotStateList, (Function2) objG3, composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: androidx.navigation.compose.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DialogHostKt.j(dialogNavigator2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List g(State state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set h(State state) {
        return (Set) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        dialogNavigator.q(navBackStackEntry);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(DialogNavigator dialogNavigator, int i3, Composer composer, int i4) {
        f(dialogNavigator, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void k(final List list, final Collection collection, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1537894851);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(collection) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1537894851, i4, -1, "androidx.navigation.compose.PopulateVisibleList (DialogHost.kt:88)");
            }
            final boolean zBooleanValue = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
                Lifecycle lifecycle = navBackStackEntry.getLifecycle();
                boolean zB = composerK.b(zBooleanValue) | composerK.I(list) | composerK.I(navBackStackEntry);
                Object objG = composerK.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: androidx.navigation.compose.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DialogHostKt.l(navBackStackEntry, zBooleanValue, list, (DisposableEffectScope) obj);
                        }
                    };
                    composerK.w(objG);
                }
                EffectsKt.c(lifecycle, (Function1) objG, composerK, 0);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: androidx.navigation.compose.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DialogHostKt.n(list, collection, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult l(final NavBackStackEntry navBackStackEntry, final boolean z2, final List list, DisposableEffectScope disposableEffectScope) {
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.navigation.compose.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogHostKt.m(z2, list, navBackStackEntry, lifecycleOwner, event);
            }
        };
        navBackStackEntry.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$lambda$12$lambda$11$lambda$10$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                navBackStackEntry.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z2, List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (z2 && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(List list, Collection collection, int i3, Composer composer, int i4) {
        k(list, collection, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.runtime.snapshots.SnapshotStateList p(java.util.Collection r5, androidx.compose.runtime.Composer r6, int r7) {
        /*
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto Lf
            r0 = -1
            java.lang.String r1 = "androidx.navigation.compose.rememberVisibleList (DialogHost.kt:119)"
            r2 = 467378629(0x1bdba1c5, float:3.6335052E-22)
            androidx.compose.runtime.ComposerKt.U(r2, r7, r0, r1)
        Lf:
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.InspectionModeKt.a()
            java.lang.Object r7 = r6.q(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            boolean r0 = r6.Z(r5)
            java.lang.Object r1 = r6.G()
            if (r0 != 0) goto L2f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.f23746a
            java.lang.Object r0 = r0.a()
            if (r1 != r0) goto L69
        L2f:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.f()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L3e:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L63
            java.lang.Object r2 = r5.next()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            if (r7 == 0) goto L4f
            r3 = 1
            goto L5d
        L4f:
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.lifecycle.Lifecycle$State r3 = r3.getCurrentState()
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.f39950d
            boolean r3 = r3.b(r4)
        L5d:
            if (r3 == 0) goto L3e
            r0.add(r2)
            goto L3e
        L63:
            r1.addAll(r0)
            r6.w(r1)
        L69:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = (androidx.compose.runtime.snapshots.SnapshotStateList) r1
            boolean r5 = androidx.compose.runtime.ComposerKt.M()
            if (r5 == 0) goto L74
            androidx.compose.runtime.ComposerKt.T()
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.DialogHostKt.p(java.util.Collection, androidx.compose.runtime.Composer, int):androidx.compose.runtime.snapshots.SnapshotStateList");
    }
}
