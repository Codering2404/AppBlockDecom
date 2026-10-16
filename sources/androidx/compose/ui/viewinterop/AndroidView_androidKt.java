package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class AndroidView_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f30109a = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        public final void invoke(View view) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f139807a;
        }
    };

    public static final void a(final Function1 function1, Modifier modifier, Function1 function12, Composer composer, final int i3, final int i4) {
        int i5;
        final Modifier modifier2;
        final Function1 function13;
        Composer composerK = composer.k(-1783766393);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            Modifier modifier3 = modifier;
            Function1 function14 = i7 != 0 ? f30109a : function12;
            if (ComposerKt.M()) {
                ComposerKt.U(-1783766393, i5, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:104)");
            }
            b(function1, modifier3, null, f30109a, function14, composerK, (i5 & 14) | 3072 | (i5 & 112) | (57344 & (i5 << 6)), 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
            function13 = function14;
        } else {
            composerK.Q();
            modifier2 = modifier;
            function13 = function12;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    AndroidView_androidKt.a(function1, modifier2, function13, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.jvm.functions.Function1 r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function1 r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.b(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function0 d(final Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2030558801, i3, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:252)");
        }
        final int iA = ComposablesKt.a(composer, 0);
        final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        final CompositionContext compositionContextD = ComposablesKt.d(composer, 0);
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.q(SaveableStateRegistryKt.e());
        final View view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
        boolean zI = composer.I(context) | ((((i3 & 14) ^ 6) > 4 && composer.Z(function1)) || (i3 & 6) == 4) | composer.I(compositionContextD) | composer.I(saveableStateRegistry) | composer.e(iA) | composer.I(view);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Object obj = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LayoutNode invoke() {
                    Context context2 = context;
                    Function1 function12 = function1;
                    CompositionContext compositionContext = compositionContextD;
                    SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    int i4 = iA;
                    KeyEvent.Callback callback = view;
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                    return new ViewFactoryHolder(context2, function12, compositionContext, saveableStateRegistry2, i4, (Owner) callback).getLayoutNode();
                }
            };
            composer.w(obj);
            objG = obj;
        }
        Function0 function0 = (Function0) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return function0;
    }

    public static final Function1 e() {
        return f30109a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewFactoryHolder f(LayoutNode layoutNode) {
        AndroidViewHolder androidViewHolderC0 = layoutNode.c0();
        if (androidViewHolderC0 != null) {
            return (ViewFactoryHolder) androidViewHolderC0;
        }
        InlineClassHelperKt.d("Required value was null.");
        throw new KotlinNothingValueException();
    }

    private static final void g(Composer composer, Modifier modifier, int i3, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        ComposeUiNode.Companion companion = ComposeUiNode.f8;
        Updater.e(composer, compositionLocalMap, companion.g());
        Updater.e(composer, modifier, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$1
            public final void c(LayoutNode layoutNode, Modifier modifier2) {
                AndroidView_androidKt.f(layoutNode).setModifier(modifier2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (Modifier) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composer, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$2
            public final void c(LayoutNode layoutNode, Density density2) {
                AndroidView_androidKt.f(layoutNode).setDensity(density2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (Density) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composer, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$3
            public final void c(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                AndroidView_androidKt.f(layoutNode).setLifecycleOwner(lifecycleOwner2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (LifecycleOwner) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composer, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$4
            public final void c(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                AndroidView_androidKt.f(layoutNode).setSavedStateRegistryOwner(savedStateRegistryOwner2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (SavedStateRegistryOwner) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composer, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f30139a;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.f30001a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LayoutDirection.f30002b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f30139a = iArr;
                }
            }

            public final void c(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                ViewFactoryHolder viewFactoryHolderF = AndroidView_androidKt.f(layoutNode);
                int i4 = WhenMappings.f30139a[layoutDirection2.ordinal()];
                int i5 = 1;
                if (i4 == 1) {
                    i5 = 0;
                } else if (i4 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                viewFactoryHolderF.setLayoutDirection(i5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((LayoutNode) obj, (LayoutDirection) obj2);
                return Unit.f139807a;
            }
        });
        Function2 function2B = companion.b();
        if (composer.i() || !Intrinsics.areEqual(composer.G(), Integer.valueOf(i3))) {
            composer.w(Integer.valueOf(i3));
            composer.p(Integer.valueOf(i3), function2B);
        }
    }
}
