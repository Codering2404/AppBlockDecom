package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

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
public final class SelectionContainerKt {
    public static final void a(final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(336063542);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(336063542, i4, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:69)");
            }
            CompositionLocalKt.b(SelectionRegistrarKt.a().d(null), function2, composerK, ((i4 << 3) & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1
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
                    SelectionContainerKt.a(function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void b(Modifier modifier, final Selection selection, final Function1 function1, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(2078139907);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(selection) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
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
                ComposerKt.U(2078139907, i5, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:89)");
            }
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.e(new Object[0], SelectionRegistrarImpl.f11484m.a(), null, new Function0<SelectionRegistrarImpl>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$registrarImpl$1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final SelectionRegistrarImpl invoke() {
                    return new SelectionRegistrarImpl();
                }
            }, composerK, 3072, 4);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new SelectionManager(selectionRegistrarImpl);
                composerK.w(objG);
            }
            final SelectionManager selectionManager = (SelectionManager) objG;
            final Clipboard clipboard = (Clipboard) composerK.q(CompositionLocalsKt.d());
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG2;
            selectionManager.a0((HapticFeedback) composerK.q(CompositionLocalsKt.k()));
            boolean Z = composerK.Z(coroutineScope) | composerK.Z(clipboard);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function1<AnnotatedString, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1", f = "SelectionContainer.kt", l = {103}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f11289a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ Clipboard f11290b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ AnnotatedString f11291c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Clipboard clipboard, AnnotatedString annotatedString, Continuation continuation) {
                            super(2, continuation);
                            this.f11290b = clipboard;
                            this.f11291c = annotatedString;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f11290b, this.f11291c, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f11289a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                Clipboard clipboard = this.f11290b;
                                ClipEntry clipEntryF = ClipboardUtils_androidKt.f(this.f11291c);
                                this.f11289a = 1;
                                if (clipboard.b(clipEntryF, this) == objF) {
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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(AnnotatedString annotatedString) {
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(clipboard, annotatedString, null), 1, null);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((AnnotatedString) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG3);
            }
            selectionManager.d0((Function1) objG3);
            selectionManager.i0((TextToolbar) composerK.q(CompositionLocalsKt.r()));
            selectionManager.e0(function1);
            selectionManager.f0(selection);
            SimpleLayoutKt.a(modifier.then(selectionManager.A()), ComposableLambdaKt.e(-1869667463, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4
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
                    if (!composer2.r((i7 & 3) != 2, i7 & 1)) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1869667463, i7, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:118)");
                    }
                    final SelectionManager selectionManager2 = selectionManager;
                    final SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                    final Function2 function22 = function2;
                    ContextMenu_androidKt.b(selectionManager2, ComposableLambdaKt.e(577209674, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            if (!composer3.r((i8 & 3) != 2, i8 & 1)) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(577209674, i8, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:119)");
                            }
                            ProvidedValue providedValueD = SelectionRegistrarKt.a().d(selectionRegistrarImpl2);
                            final Function2 function23 = function22;
                            final SelectionManager selectionManager3 = selectionManager2;
                            CompositionLocalKt.b(providedValueD, ComposableLambdaKt.e(-272381430, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.4.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.f139807a;
                                }

                                public final void invoke(Composer composer4, int i9) {
                                    if (!composer4.r((i9 & 3) != 2, i9 & 1)) {
                                        composer4.Q();
                                        return;
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.U(-272381430, i9, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:120)");
                                    }
                                    function23.invoke(composer4, 0);
                                    if (selectionManager3.L() && selectionManager3.z() && !selectionManager3.N()) {
                                        composer4.a0(-881553831);
                                        Selection selectionD = selectionManager3.D();
                                        if (selectionD == null) {
                                            composer4.a0(-881514989);
                                        } else {
                                            composer4.a0(-881514988);
                                            final SelectionManager selectionManager4 = selectionManager3;
                                            composer4.a0(1495586214);
                                            List listListOf = CollectionsKt.listOf((Object[]) new Boolean[]{Boolean.TRUE, Boolean.FALSE});
                                            int size = listListOf.size();
                                            int i10 = 0;
                                            while (i10 < size) {
                                                boolean zBooleanValue = ((Boolean) listListOf.get(i10)).booleanValue();
                                                boolean zB = composer4.b(zBooleanValue);
                                                Object objG4 = composer4.G();
                                                if (zB || objG4 == Composer.f23746a.a()) {
                                                    objG4 = selectionManager4.I(zBooleanValue);
                                                    composer4.w(objG4);
                                                }
                                                final TextDragObserver textDragObserver = (TextDragObserver) objG4;
                                                boolean zB2 = composer4.b(zBooleanValue);
                                                Object objG5 = composer4.G();
                                                if (zB2 || objG5 == Composer.f23746a.a()) {
                                                    objG5 = zBooleanValue ? new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$positionProvider$1$1
                                                        {
                                                            super(0);
                                                        }

                                                        public final long c() {
                                                            Offset offsetH = selectionManager4.H();
                                                            return offsetH != null ? offsetH.u() : Offset.f25596b.b();
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            return Offset.d(c());
                                                        }
                                                    } : new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$positionProvider$1$2
                                                        {
                                                            super(0);
                                                        }

                                                        public final long c() {
                                                            Offset offsetX = selectionManager4.x();
                                                            return offsetX != null ? offsetX.u() : Offset.f25596b.b();
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            return Offset.d(c());
                                                        }
                                                    };
                                                    composer4.w(objG5);
                                                }
                                                Function0 function0 = (Function0) objG5;
                                                ResolvedTextDirection resolvedTextDirectionC = zBooleanValue ? selectionD.e().c() : selectionD.c().c();
                                                float fG = zBooleanValue ? selectionManager4.G() : selectionManager4.w();
                                                int i11 = i10;
                                                SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function0);
                                                boolean zD = selectionD.d();
                                                Modifier.Companion companion2 = Modifier.b8;
                                                boolean zI = composer4.I(textDragObserver);
                                                Object objG6 = composer4.G();
                                                if (zI || objG6 == Composer.f23746a.a()) {
                                                    objG6 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$1$1
                                                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                                                            Object objC = LongPressTextDragObserverKt.c(pointerInputScope, textDragObserver, continuation);
                                                            return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
                                                        }
                                                    };
                                                    composer4.w(objG6);
                                                }
                                                AndroidSelectionHandles_androidKt.b(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, zBooleanValue, resolvedTextDirectionC, zD, 0L, fG, SuspendingPointerInputFilterKt.d(companion2, textDragObserver, (PointerInputEventHandler) objG6), composer4, 0, 16);
                                                i10 = i11 + 1;
                                            }
                                            composer4.U();
                                        }
                                        composer4.U();
                                        composer4.U();
                                    } else {
                                        composer4.a0(-879541497);
                                        composer4.U();
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.T();
                                    }
                                }
                            }, composer3, 54), composer3, ProvidedValue.f24012i | 48);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), composer2, 48);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48, 0);
            boolean zI = composerK.I(selectionManager);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final SelectionManager selectionManager2 = selectionManager;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                selectionManager2.P();
                                selectionManager2.b0(false);
                            }
                        };
                    }
                };
                composerK.w(objG4);
            }
            EffectsKt.c(selectionManager, (Function1) objG4, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$6
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
                    SelectionContainerKt.b(modifier2, selection, function1, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final void c(final Modifier modifier, Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        final Function2 function22;
        Composer composerK = composer.k(-1075498320);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1075498320, i5, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:52)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            int i7 = i5;
            Selection selectionD = d(mutableState);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    {
                        super(1);
                    }

                    public final void c(Selection selection) {
                        SelectionContainerKt.e(mutableState, selection);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Selection) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG2);
            }
            int i8 = (i7 & 14) | 384 | ((i7 << 6) & 7168);
            Modifier modifier2 = modifier;
            function22 = function2;
            b(modifier2, selectionD, (Function1) objG2, function22, composerK, i8, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier = modifier2;
        } else {
            function22 = function2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    SelectionContainerKt.c(modifier, function22, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    private static final Selection d(MutableState mutableState) {
        return (Selection) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState mutableState, Selection selection) {
        mutableState.setValue(selection);
    }
}
