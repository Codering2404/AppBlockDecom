package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BasicTooltipKt {
    /* JADX WARN: Removed duplicated region for block: B:127:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.window.PopupPositionProvider r20, final kotlin.jvm.functions.Function2 r21, androidx.compose.foundation.BasicTooltipState r22, androidx.compose.ui.Modifier r23, boolean r24, boolean r25, final kotlin.jvm.functions.Function2 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltipKt.a(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.foundation.BasicTooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final PopupPositionProvider popupPositionProvider, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope, final boolean z2, final Function2 function2, Composer composer, final int i3) {
        PopupPositionProvider popupPositionProvider2;
        int i4;
        Composer composerK = composer.k(-487341126);
        if ((i3 & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i4 = (composerK.Z(popupPositionProvider2) ? 4 : 2) | i3;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(basicTooltipState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(coroutineScope) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-487341126, i4, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.kt:133)");
            }
            final String strA = BasicTooltipStrings.f4724a.a(composerK, 6);
            boolean zI = composerK.I(coroutineScope) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0<Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$1$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$TooltipPopup$1$1$1", f = "BasicTooltip.kt", l = {}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f4664a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ BasicTooltipState f4665b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(BasicTooltipState basicTooltipState, Continuation continuation) {
                            super(2, continuation);
                            this.f4665b = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f4665b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            IntrinsicsKt.f();
                            if (this.f4664a != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            this.f4665b.dismiss();
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m27invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m27invoke() {
                        if (basicTooltipState.isVisible()) {
                            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(basicTooltipState, null), 3, null);
                        }
                    }
                };
                composerK.w(objG);
            }
            AndroidPopup_androidKt.a(popupPositionProvider2, (Function0) objG, new PopupProperties(z2, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.e(-2085908648, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-2085908648, i5, -1, "androidx.compose.foundation.TooltipPopup.<anonymous> (BasicTooltip.kt:144)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    boolean Z = composer2.Z(strA);
                    final String str = strA;
                    Object objG2 = composer2.G();
                    if (Z || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.l0(semanticsPropertyReceiver, LiveRegionMode.f28448b.a());
                                SemanticsPropertiesKt.n0(semanticsPropertyReceiver, str);
                            }
                        };
                        composer2.w(objG2);
                    }
                    Modifier modifierF = SemanticsModifierKt.f(companion, false, (Function1) objG2, 1, null);
                    Function2 function22 = function2;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierF);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, measurePolicyG, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF2, companion2.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    function22.invoke(composer2, 0);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, (i4 & 14) | 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$TooltipPopup$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    BasicTooltipKt.b(popupPositionProvider, basicTooltipState, coroutineScope, z2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final boolean z2, final BasicTooltipState basicTooltipState, Modifier modifier, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-111661630);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(basicTooltipState) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-111661630, i5, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.kt:112)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            Modifier modifierF = f(g(modifier, z2, basicTooltipState), BasicTooltipStrings.f4724a.b(composerK, 6), z2, basicTooltipState, (CoroutineScope) objG);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i5 >> 9) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$WrappedAnchor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    BasicTooltipKt.c(z2, basicTooltipState, modifier2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    private static final Modifier f(Modifier modifier, final String str, boolean z2, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope) {
        return z2 ? SemanticsModifierKt.e(modifier, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.BasicTooltipKt$anchorSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                String str2 = str;
                final CoroutineScope coroutineScope2 = coroutineScope;
                final BasicTooltipState basicTooltipState2 = basicTooltipState;
                SemanticsPropertiesKt.E(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.foundation.BasicTooltipKt$anchorSemantics$1.1

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$anchorSemantics$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$anchorSemantics$1$1$1", f = "BasicTooltip.kt", l = {220}, m = "invokeSuspend")
                    static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f4686a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ BasicTooltipState f4687b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00041(BasicTooltipState basicTooltipState, Continuation continuation) {
                            super(2, continuation);
                            this.f4687b = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C00041(this.f4687b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f4686a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                BasicTooltipState basicTooltipState = this.f4687b;
                                this.f4686a = 1;
                                if (BasicTooltipState.d(basicTooltipState, null, this, 1, null) == objF) {
                                    return objF;
                                }
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        BuildersKt__Builders_commonKt.d(coroutineScope2, null, null, new C00041(basicTooltipState2, null), 3, null);
                        return Boolean.TRUE;
                    }
                });
            }
        }) : modifier;
    }

    private static final Modifier g(Modifier modifier, boolean z2, final BasicTooltipState basicTooltipState) {
        return z2 ? SuspendingPointerInputFilterKt.d(SuspendingPointerInputFilterKt.d(modifier, basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$1

            /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1", f = "BasicTooltip.kt", l = {162}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f4689a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f4690b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ PointerInputScope f4691c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ BasicTooltipState f4692d;

                /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1", f = "BasicTooltip.kt", l = {166, 169, 175}, m = "invokeSuspend")
                static final class C00051 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    Object f4693a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f4694b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    private /* synthetic */ Object f4695c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ CoroutineScope f4696d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ BasicTooltipState f4697f;

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1", f = "BasicTooltip.kt", l = {172}, m = "invokeSuspend")
                    static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f4698a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ BasicTooltipState f4699b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00061(BasicTooltipState basicTooltipState, Continuation continuation) {
                            super(2, continuation);
                            this.f4699b = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C00061(this.f4699b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f4698a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                BasicTooltipState basicTooltipState = this.f4699b;
                                MutatePriority mutatePriority = MutatePriority.f5072b;
                                this.f4698a = 1;
                                if (basicTooltipState.c(mutatePriority, this) == objF) {
                                    return objF;
                                }
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C00061) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00051(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation continuation) {
                        super(2, continuation);
                        this.f4696d = coroutineScope;
                        this.f4697f = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        C00051 c00051 = new C00051(this.f4696d, this.f4697f, continuation);
                        c00051.f4695c = obj;
                        return c00051;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                        return ((C00051) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
                    
                        if (r1 == r0) goto L28;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r16) throws java.lang.Throwable {
                        /*
                            r15 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r15.f4694b
                            r2 = 3
                            r3 = 2
                            r4 = 1
                            if (r1 == 0) goto L3e
                            if (r1 == r4) goto L2f
                            if (r1 == r3) goto L20
                            if (r1 != r2) goto L18
                            kotlin.ResultKt.b(r16)
                            r1 = r16
                            goto La8
                        L18:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                            r0.<init>(r1)
                            throw r0
                        L20:
                            java.lang.Object r1 = r15.f4693a
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r3 = r15.f4695c
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                            kotlin.ResultKt.b(r16)
                            r7 = r1
                            r1 = r16
                            goto L84
                        L2f:
                            java.lang.Object r1 = r15.f4693a
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r4 = r15.f4695c
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                            kotlin.ResultKt.b(r16)
                            r7 = r1
                            r1 = r16
                            goto L5a
                        L3e:
                            kotlin.ResultKt.b(r16)
                            java.lang.Object r1 = r15.f4695c
                            r5 = r1
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                            r15.f4695c = r5
                            r15.f4693a = r7
                            r15.f4694b = r4
                            r6 = 0
                            r9 = 1
                            r10 = 0
                            r8 = r15
                            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r5, r6, r7, r8, r9, r10)
                            if (r1 != r0) goto L59
                            goto La7
                        L59:
                            r4 = r5
                        L5a:
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            int r1 = r1.n()
                            androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.f26922b
                            int r6 = r5.d()
                            boolean r6 = androidx.compose.ui.input.pointer.PointerType.h(r1, r6)
                            if (r6 != 0) goto L76
                            int r5 = r5.c()
                            boolean r1 = androidx.compose.ui.input.pointer.PointerType.h(r1, r5)
                            if (r1 == 0) goto Lc1
                        L76:
                            r15.f4695c = r4
                            r15.f4693a = r7
                            r15.f4694b = r3
                            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.s(r4, r7, r15)
                            if (r1 != r0) goto L83
                            goto La7
                        L83:
                            r3 = r4
                        L84:
                            androidx.compose.foundation.gestures.LongPressResult r1 = (androidx.compose.foundation.gestures.LongPressResult) r1
                            boolean r1 = r1 instanceof androidx.compose.foundation.gestures.LongPressResult.Success
                            if (r1 == 0) goto Lc1
                            kotlinx.coroutines.CoroutineScope r9 = r15.f4696d
                            androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1 r12 = new androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1
                            androidx.compose.foundation.BasicTooltipState r1 = r15.f4697f
                            r4 = 0
                            r12.<init>(r1, r4)
                            r13 = 3
                            r14 = 0
                            r10 = 0
                            r11 = 0
                            kotlinx.coroutines.BuildersKt.d(r9, r10, r11, r12, r13, r14)
                            r15.f4695c = r4
                            r15.f4693a = r4
                            r15.f4694b = r2
                            java.lang.Object r1 = r3.T0(r7, r15)
                            if (r1 != r0) goto La8
                        La7:
                            return r0
                        La8:
                            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
                            java.util.List r0 = r1.c()
                            int r1 = r0.size()
                            r2 = 0
                        Lb3:
                            if (r2 >= r1) goto Lc1
                            java.lang.Object r3 = r0.get(r2)
                            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                            r3.a()
                            int r2 = r2 + 1
                            goto Lb3
                        Lc1:
                            kotlin.Unit r0 = kotlin.Unit.f139807a
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00051.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation continuation) {
                    super(2, continuation);
                    this.f4691c = pointerInputScope;
                    this.f4692d = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4691c, this.f4692d, continuation);
                    anonymousClass1.f4690b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f4689a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.f4690b;
                        PointerInputScope pointerInputScope = this.f4691c;
                        C00051 c00051 = new C00051(coroutineScope, this.f4692d, null);
                        this.f4689a = 1;
                        if (ForEachGestureKt.e(pointerInputScope, c00051, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, basicTooltipState, null), continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }
        }), basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$2

            /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1", f = "BasicTooltip.kt", l = {186}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f4701a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f4702b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ PointerInputScope f4703c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ BasicTooltipState f4704d;

                /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1", f = "BasicTooltip.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend")
                static final class C00071 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    Object f4705a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f4706b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    private /* synthetic */ Object f4707c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ CoroutineScope f4708d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ BasicTooltipState f4709f;

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1", f = "BasicTooltip.kt", l = {195}, m = "invokeSuspend")
                    static final class C00081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f4710a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ BasicTooltipState f4711b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00081(BasicTooltipState basicTooltipState, Continuation continuation) {
                            super(2, continuation);
                            this.f4711b = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C00081(this.f4711b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f4710a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                BasicTooltipState basicTooltipState = this.f4711b;
                                MutatePriority mutatePriority = MutatePriority.f5072b;
                                this.f4710a = 1;
                                if (basicTooltipState.c(mutatePriority, this) == objF) {
                                    return objF;
                                }
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C00081) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00071(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation continuation) {
                        super(2, continuation);
                        this.f4708d = coroutineScope;
                        this.f4709f = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        C00071 c00071 = new C00071(this.f4708d, this.f4709f, continuation);
                        c00071.f4707c = obj;
                        return c00071;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                        return ((C00071) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0033 -> B:12:0x0036). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                        /*
                            r12 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r12.f4706b
                            r2 = 1
                            if (r1 == 0) goto L1f
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r12.f4705a
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r3 = r12.f4707c
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                            kotlin.ResultKt.b(r13)
                            goto L36
                        L17:
                            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r13.<init>(r0)
                            throw r13
                        L1f:
                            kotlin.ResultKt.b(r13)
                            java.lang.Object r13 = r12.f4707c
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.f26831b
                            r3 = r13
                        L29:
                            r12.f4707c = r3
                            r12.f4705a = r1
                            r12.f4706b = r2
                            java.lang.Object r13 = r3.T0(r1, r12)
                            if (r13 != r0) goto L36
                            return r0
                        L36:
                            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                            java.util.List r4 = r13.c()
                            r5 = 0
                            java.lang.Object r4 = r4.get(r5)
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            int r4 = r4.n()
                            androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.f26922b
                            int r5 = r5.b()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerType.h(r4, r5)
                            if (r4 == 0) goto L29
                            int r13 = r13.h()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.f26835b
                            int r5 = r4.a()
                            boolean r5 = androidx.compose.ui.input.pointer.PointerEventType.j(r13, r5)
                            if (r5 == 0) goto L75
                            kotlinx.coroutines.CoroutineScope r6 = r12.f4708d
                            androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1 r9 = new androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1
                            androidx.compose.foundation.BasicTooltipState r13 = r12.f4709f
                            r4 = 0
                            r9.<init>(r13, r4)
                            r10 = 3
                            r11 = 0
                            r7 = 0
                            r8 = 0
                            kotlinx.coroutines.BuildersKt.d(r6, r7, r8, r9, r10, r11)
                            goto L29
                        L75:
                            int r4 = r4.b()
                            boolean r13 = androidx.compose.ui.input.pointer.PointerEventType.j(r13, r4)
                            if (r13 == 0) goto L29
                            androidx.compose.foundation.BasicTooltipState r13 = r12.f4709f
                            r13.dismiss()
                            goto L29
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltipKt$handleGestures$2.AnonymousClass1.C00071.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation continuation) {
                    super(2, continuation);
                    this.f4703c = pointerInputScope;
                    this.f4704d = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4703c, this.f4704d, continuation);
                    anonymousClass1.f4702b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f4701a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.f4702b;
                        PointerInputScope pointerInputScope = this.f4703c;
                        C00071 c00071 = new C00071(coroutineScope, this.f4704d, null);
                        this.f4701a = 1;
                        if (pointerInputScope.c0(c00071, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, basicTooltipState, null), continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }
        }) : modifier;
    }
}
