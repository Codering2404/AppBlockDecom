package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ModalBottomSheet_androidKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18397a;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.f30290c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.f30289b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.f30288a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18397a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void a(final kotlin.jvm.functions.Function0 r30, androidx.compose.ui.Modifier r31, androidx.compose.material3.SheetState r32, float r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, float r39, long r40, kotlin.jvm.functions.Function2 r42, androidx.compose.foundation.layout.WindowInsets r43, androidx.compose.material3.ModalBottomSheetProperties r44, final kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.a(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void b(final Function0 function0, final ModalBottomSheetProperties modalBottomSheetProperties, final Animatable animatable, final Function2 function2, Composer composer, final int i3) {
        int i4;
        final LayoutDirection layoutDirection;
        int i5;
        int i6;
        Object obj;
        Composer composer2;
        Composer composerK = composer.k(1254951810);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(modalBottomSheetProperties) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(animatable) : composerK.I(animatable) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1254951810, i4, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:272)");
            }
            View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            CompositionContext compositionContextD = ComposablesKt.d(composerK, 0);
            final State stateP = SnapshotStateKt.p(function2, composerK, (i4 >> 9) & 14);
            Composer composer3 = composerK;
            UUID uuid = (UUID) RememberSaveableKt.e(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialogId$1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, composerK, 3072, 6);
            Object objG = composer3.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer3));
                composer3.w(objG);
            }
            CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
            boolean zA = DarkThemeKt.a(composer3, 0);
            boolean Z = composer3.Z(view) | composer3.Z(density);
            Object objG2 = composer3.G();
            if (Z || objG2 == companion.a()) {
                layoutDirection = layoutDirection2;
                i5 = 0;
                i6 = i4;
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = new ModalBottomSheetDialogWrapper(function0, modalBottomSheetProperties, view, layoutDirection, density, uuid, animatable, coroutineScopeA, zA);
                modalBottomSheetDialogWrapper.h(compositionContextD, ComposableLambdaKt.c(-1560960657, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer4, int i7) {
                        if ((i7 & 3) == 2 && composer4.l()) {
                            composer4.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-1560960657, i7, -1, "androidx.compose.material3.ModalBottomSheetDialog.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:296)");
                        }
                        Modifier modifierF = SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((SemanticsPropertyReceiver) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.k(semanticsPropertyReceiver);
                            }
                        }, 1, null);
                        State state = stateP;
                        MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                        int iA = ComposablesKt.a(composer4, 0);
                        CompositionLocalMap compositionLocalMapU = composer4.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer4, modifierF);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                        Function0 function0A = companion2.a();
                        if (composer4.m() == null) {
                            ComposablesKt.c();
                        }
                        composer4.L();
                        if (composer4.i()) {
                            composer4.P(function0A);
                        } else {
                            composer4.v();
                        }
                        Composer composerA = Updater.a(composer4);
                        Updater.e(composerA, measurePolicyG, companion2.e());
                        Updater.e(composerA, compositionLocalMapU, companion2.g());
                        Function2 function2B = companion2.b();
                        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                            composerA.w(Integer.valueOf(iA));
                            composerA.p(Integer.valueOf(iA), function2B);
                        }
                        Updater.e(composerA, modifierF2, companion2.f());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                        ModalBottomSheet_androidKt.c(state).invoke(composer4, 0);
                        composer4.y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }));
                composer3.w(modalBottomSheetDialogWrapper);
                obj = modalBottomSheetDialogWrapper;
            } else {
                obj = objG2;
                i6 = i4;
                layoutDirection = layoutDirection2;
                i5 = 0;
            }
            final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper2 = (ModalBottomSheetDialogWrapper) obj;
            boolean zI = composer3.I(modalBottomSheetDialogWrapper2);
            Object objG3 = composer3.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        modalBottomSheetDialogWrapper2.show();
                        final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper3 = modalBottomSheetDialogWrapper2;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                modalBottomSheetDialogWrapper3.dismiss();
                                modalBottomSheetDialogWrapper3.g();
                            }
                        };
                    }
                };
                composer3.w(objG3);
            }
            EffectsKt.c(modalBottomSheetDialogWrapper2, (Function1) objG3, composer3, i5);
            int i7 = (composer3.I(modalBottomSheetDialogWrapper2) ? 1 : 0) | ((i6 & 14) == 4 ? 1 : i5) | ((i6 & 112) == 32 ? 1 : i5) | (composer3.Z(layoutDirection) ? 1 : 0);
            Object objG4 = composer3.G();
            if (i7 != 0 || objG4 == companion.a()) {
                objG4 = new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m169invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m169invoke() {
                        modalBottomSheetDialogWrapper2.k(function0, modalBottomSheetProperties, layoutDirection);
                    }
                };
                composer3.w(objG4);
            }
            EffectsKt.j((Function0) objG4, composer3, i5);
            composer2 = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
                composer2 = composer3;
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer4, int i8) {
                    ModalBottomSheet_androidKt.b(function0, modalBottomSheetProperties, animatable, function2, composer4, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 c(State state) {
        return (Function2) state.getValue();
    }

    public static final boolean f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i3 = WhenMappings.f18397a[secureFlagPolicy.ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        if (i3 == 3) {
            return z2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
