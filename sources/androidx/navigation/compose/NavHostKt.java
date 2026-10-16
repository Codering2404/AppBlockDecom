package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(NavHostController navHostController, Object obj, Modifier modifier, Alignment alignment, KClass kClass, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i3, int i4, int i5, Composer composer, int i6) {
        u(navHostController, obj, modifier, alignment, kClass, map, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition B(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.o(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition C(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.q(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i3, int i4, Composer composer, int i5) {
        t(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E(State state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float F(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult J(NavHostController navHostController, LifecycleOwner lifecycleOwner, DisposableEffectScope disposableEffectScope) {
        navHostController.c0(lifecycleOwner);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    private static final List K(State state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L(State state) {
        List listK = K(state);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (Intrinsics.areEqual(((NavBackStackEntry) obj).d().q(), "composable")) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M(State state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition N(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination navDestinationD = ((NavBackStackEntry) animatedContentTransitionScope.a()).d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) navDestinationD;
        EnterTransition enterTransition = null;
        if (((Boolean) composeNavigator.r().getValue()).booleanValue() || H(mutableState)) {
            Iterator it = NavDestination.f48864g.e(destination).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EnterTransition enterTransitionE0 = e0((NavDestination) it.next(), animatedContentTransitionScope);
                if (enterTransitionE0 != null) {
                    enterTransition = enterTransitionE0;
                    break;
                }
            }
            return enterTransition == null ? (EnterTransition) function1.invoke(animatedContentTransitionScope) : enterTransition;
        }
        Iterator it2 = NavDestination.f48864g.e(destination).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            EnterTransition enterTransitionC0 = c0((NavDestination) it2.next(), animatedContentTransitionScope);
            if (enterTransitionC0 != null) {
                enterTransition = enterTransitionC0;
                break;
            }
        }
        return enterTransition == null ? (EnterTransition) function12.invoke(animatedContentTransitionScope) : enterTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition O(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination navDestinationD = ((NavBackStackEntry) animatedContentTransitionScope.c()).d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) navDestinationD;
        ExitTransition exitTransition = null;
        if (((Boolean) composeNavigator.r().getValue()).booleanValue() || H(mutableState)) {
            Iterator it = NavDestination.f48864g.e(destination).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ExitTransition exitTransitionF0 = f0((NavDestination) it.next(), animatedContentTransitionScope);
                if (exitTransitionF0 != null) {
                    exitTransition = exitTransitionF0;
                    break;
                }
            }
            return exitTransition == null ? (ExitTransition) function1.invoke(animatedContentTransitionScope) : exitTransition;
        }
        Iterator it2 = NavDestination.f48864g.e(destination).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ExitTransition exitTransitionD0 = d0((NavDestination) it2.next(), animatedContentTransitionScope);
            if (exitTransitionD0 != null) {
                exitTransition = exitTransitionD0;
                break;
            }
        }
        return exitTransition == null ? (ExitTransition) function12.invoke(animatedContentTransitionScope) : exitTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SizeTransform P(Function1 function1, AnimatedContentTransitionScope animatedContentTransitionScope) {
        SizeTransform sizeTransformG0;
        NavDestination navDestinationD = ((NavBackStackEntry) animatedContentTransitionScope.a()).d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        Iterator it = NavDestination.f48864g.e((ComposeNavigator.Destination) navDestinationD).iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeTransformG0 = null;
                break;
            }
            sizeTransformG0 = g0((NavDestination) it.next(), animatedContentTransitionScope);
            if (sizeTransformG0 != null) {
                break;
            }
        }
        if (sizeTransformG0 != null) {
            return sizeTransformG0;
        }
        if (function1 != null) {
            return (SizeTransform) function1.invoke(animatedContentTransitionScope);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Q(final State state, final ComposeNavigator composeNavigator, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$69$lambda$68$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Iterator it = NavHostKt.M(state).iterator();
                while (it.hasNext()) {
                    composeNavigator.s((NavBackStackEntry) it.next());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform R(MutableObjectFloatMap mutableObjectFloatMap, ComposeNavigator composeNavigator, Function1 function1, Function1 function12, Function1 function13, State state, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        float f3;
        if (!M(state).contains(animatedContentTransitionScope.c())) {
            return AnimatedContentKt.f(EnterTransition.f3563a.a(), ExitTransition.f3566a.a());
        }
        String strF = ((NavBackStackEntry) animatedContentTransitionScope.c()).f();
        int iB = mutableObjectFloatMap.b(strF);
        if (iB >= 0) {
            f3 = mutableObjectFloatMap.f3071c[iB];
        } else {
            mutableObjectFloatMap.r(strF, 0.0f);
            f3 = 0.0f;
        }
        if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScope.a()).f(), ((NavBackStackEntry) animatedContentTransitionScope.c()).f())) {
            f3 = (((Boolean) composeNavigator.r().getValue()).booleanValue() || H(mutableState)) ? f3 - 1.0f : f3 + 1.0f;
        }
        mutableObjectFloatMap.r(((NavBackStackEntry) animatedContentTransitionScope.a()).f(), f3);
        return new ContentTransform((EnterTransition) function1.invoke(animatedContentTransitionScope), (ExitTransition) function12.invoke(animatedContentTransitionScope), f3, (SizeTransform) function13.invoke(animatedContentTransitionScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object S(NavBackStackEntry navBackStackEntry) {
        return navBackStackEntry.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i3, int i4, Composer composer, int i5) {
        t(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i3, int i4, Composer composer, int i5) {
        t(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition V(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.o(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }

    private static final EnterTransition c0(NavDestination navDestination, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Function1 function1Z;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1 function1I = ((ComposeNavigator.Destination) navDestination).I();
            if (function1I != null) {
                return (EnterTransition) function1I.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (function1Z = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).Z()) == null) {
            return null;
        }
        return (EnterTransition) function1Z.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition d0(NavDestination navDestination, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Function1 function1A0;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1 function1J = ((ComposeNavigator.Destination) navDestination).J();
            if (function1J != null) {
                return (ExitTransition) function1J.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (function1A0 = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).a0()) == null) {
            return null;
        }
        return (ExitTransition) function1A0.invoke(animatedContentTransitionScope);
    }

    private static final EnterTransition e0(NavDestination navDestination, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Function1 function1B0;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1 function1K = ((ComposeNavigator.Destination) navDestination).K();
            if (function1K != null) {
                return (EnterTransition) function1K.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (function1B0 = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).b0()) == null) {
            return null;
        }
        return (EnterTransition) function1B0.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition f0(NavDestination navDestination, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Function1 function1C0;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1 function1L = ((ComposeNavigator.Destination) navDestination).L();
            if (function1L != null) {
                return (ExitTransition) function1L.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (function1C0 = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).c0()) == null) {
            return null;
        }
        return (ExitTransition) function1C0.invoke(animatedContentTransitionScope);
    }

    private static final SizeTransform g0(NavDestination navDestination, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Function1 function1D0;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1 function1M = ((ComposeNavigator.Destination) navDestination).M();
            if (function1M != null) {
                return (SizeTransform) function1M.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (function1D0 = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).d0()) == null) {
            return null;
        }
        return (SizeTransform) function1D0.invoke(animatedContentTransitionScope);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final androidx.navigation.NavHostController r32, final androidx.navigation.NavGraph r33, androidx.compose.ui.Modifier r34, androidx.compose.ui.Alignment r35, kotlin.jvm.functions.Function1 r36, kotlin.jvm.functions.Function1 r37, kotlin.jvm.functions.Function1 r38, kotlin.jvm.functions.Function1 r39, kotlin.jvm.functions.Function1 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 1533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.t(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u(final androidx.navigation.NavHostController r29, final java.lang.Object r30, androidx.compose.ui.Modifier r31, androidx.compose.ui.Alignment r32, kotlin.reflect.KClass r33, java.util.Map r34, kotlin.jvm.functions.Function1 r35, kotlin.jvm.functions.Function1 r36, kotlin.jvm.functions.Function1 r37, kotlin.jvm.functions.Function1 r38, kotlin.jvm.functions.Function1 r39, final kotlin.jvm.functions.Function1 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.u(androidx.navigation.NavHostController, java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v(final androidx.navigation.NavHostController r27, final java.lang.String r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.Alignment r30, java.lang.String r31, kotlin.jvm.functions.Function1 r32, kotlin.jvm.functions.Function1 r33, kotlin.jvm.functions.Function1 r34, kotlin.jvm.functions.Function1 r35, kotlin.jvm.functions.Function1 r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.v(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition w(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.q(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i3, int i4, int i5, Composer composer, int i6) {
        v(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition y(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.o(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition z(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.q(AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null), 0.0f, 2, null);
    }
}
