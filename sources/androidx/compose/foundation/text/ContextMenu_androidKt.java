package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class ContextMenu_androidKt {
    public static final void a(final TextFieldSelectionState textFieldSelectionState, boolean z2, Function2 function2, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        final Function2 function22;
        Composer composerK = composer.k(2103477555);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(textFieldSelectionState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2103477555, i4, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:67)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new ContextMenuState(null, 1, null);
                composerK.w(objG);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(MenuItemsAvailability.b(MenuItemsAvailability.f9861b.a()), null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState = (MutableState) objG3;
            boolean zI = composerK.I(coroutineScope);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new Function2<TextFieldSelectionState, TextContextMenuItems, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1", f = "ContextMenu.android.kt", l = {79, 80, 81}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f9519a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ TextContextMenuItems f9520b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ TextFieldSelectionState f9521c;

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1$WhenMappings */
                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        @Metadata
                        public /* synthetic */ class WhenMappings {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            public static final /* synthetic */ int[] f9522a;

                            static {
                                int[] iArr = new int[TextContextMenuItems.values().length];
                                try {
                                    iArr[TextContextMenuItems.f9893b.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[TextContextMenuItems.f9894c.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[TextContextMenuItems.f9895d.ordinal()] = 3;
                                } catch (NoSuchFieldError unused3) {
                                }
                                try {
                                    iArr[TextContextMenuItems.f9896f.ordinal()] = 4;
                                } catch (NoSuchFieldError unused4) {
                                }
                                try {
                                    iArr[TextContextMenuItems.f9897g.ordinal()] = 5;
                                } catch (NoSuchFieldError unused5) {
                                }
                                f9522a = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TextContextMenuItems textContextMenuItems, TextFieldSelectionState textFieldSelectionState, Continuation continuation) {
                            super(2, continuation);
                            this.f9520b = textContextMenuItems;
                            this.f9521c = textFieldSelectionState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f9520b, this.f9521c, continuation);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
                        
                            if (r6.q0(r5) == r0) goto L29;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
                        
                            if (r6.H(false, r5) == r0) goto L29;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
                        
                            if (r6.K(r5) == r0) goto L29;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
                        
                            return r0;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
                            /*
                                r5 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r1 = r5.f9519a
                                r2 = 3
                                r3 = 2
                                r4 = 1
                                if (r1 == 0) goto L1d
                                if (r1 == r4) goto L11
                                if (r1 == r3) goto L11
                                if (r1 != r2) goto L15
                            L11:
                                kotlin.ResultKt.b(r6)
                                goto L65
                            L15:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r0)
                                throw r6
                            L1d:
                                kotlin.ResultKt.b(r6)
                                androidx.compose.foundation.text.TextContextMenuItems r6 = r5.f9520b
                                int[] r1 = androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1.AnonymousClass1.WhenMappings.f9522a
                                int r6 = r6.ordinal()
                                r6 = r1[r6]
                                if (r6 == r4) goto L5a
                                if (r6 == r3) goto L4e
                                if (r6 == r2) goto L43
                                r0 = 4
                                if (r6 == r0) goto L3d
                                r0 = 5
                                if (r6 == r0) goto L37
                                goto L65
                            L37:
                                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.f9521c
                                r6.A()
                                goto L65
                            L3d:
                                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.f9521c
                                r6.t0()
                                goto L65
                            L43:
                                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.f9521c
                                r5.f9519a = r2
                                java.lang.Object r6 = r6.q0(r5)
                                if (r6 != r0) goto L65
                                goto L64
                            L4e:
                                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.f9521c
                                r5.f9519a = r3
                                r1 = 0
                                java.lang.Object r6 = r6.H(r1, r5)
                                if (r6 != r0) goto L65
                                goto L64
                            L5a:
                                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.f9521c
                                r5.f9519a = r4
                                java.lang.Object r6 = r6.K(r5)
                                if (r6 != r0) goto L65
                            L64:
                                return r0
                            L65:
                                kotlin.Unit r6 = kotlin.Unit.f139807a
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    {
                        super(2);
                    }

                    public final void c(TextFieldSelectionState textFieldSelectionState2, TextContextMenuItems textContextMenuItems) {
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(textContextMenuItems, textFieldSelectionState2, null), 1, null);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        c((TextFieldSelectionState) obj, (TextContextMenuItems) obj2);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG4);
            }
            Function1 function1A = TextFieldSelectionState_androidKt.a(textFieldSelectionState, contextMenuState, mutableState, (Function2) objG4);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$4$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m63invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m63invoke() {
                        ContextMenuState_androidKt.a(contextMenuState);
                    }
                };
                composerK.w(objG5);
            }
            Function0 function0 = (Function0) objG5;
            boolean zI2 = composerK.I(coroutineScope) | composerK.I(textFieldSelectionState);
            Object objG6 = composerK.G();
            if (zI2 || objG6 == companion.a()) {
                objG6 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1$1", f = "ContextMenu.android.kt", l = {96}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        Object f9506a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f9507b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ MutableState f9508c;

                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TextFieldSelectionState f9509d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(MutableState mutableState, TextFieldSelectionState textFieldSelectionState, Continuation continuation) {
                            super(2, continuation);
                            this.f9508c = mutableState;
                            this.f9509d = textFieldSelectionState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f9508c, this.f9509d, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            MutableState mutableState;
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f9507b;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                MutableState mutableState2 = this.f9508c;
                                TextFieldSelectionState textFieldSelectionState = this.f9509d;
                                this.f9506a = mutableState2;
                                this.f9507b = 1;
                                Object objD = ContextMenu_androidKt.d(textFieldSelectionState, this);
                                if (objD == objF) {
                                    return objF;
                                }
                                mutableState = mutableState2;
                                obj = objD;
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutableState = (MutableState) this.f9506a;
                                ResultKt.b(obj);
                            }
                            mutableState.setValue(obj);
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
                        m64invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m64invoke() {
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(mutableState, textFieldSelectionState, null), 1, null);
                    }
                };
                composerK.w(objG6);
            }
            function22 = function2;
            z3 = z2;
            ContextMenuArea_androidKt.b(contextMenuState, function0, function1A, null, z3, (Function0) objG6, function22, composerK, ((i4 << 9) & 57344) | 54 | ((i4 << 12) & 3670016), 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            z3 = z2;
            function22 = function2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$6
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
                    ContextMenu_androidKt.a(textFieldSelectionState, z3, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void b(final SelectionManager selectionManager, Function2 function2, Composer composer, final int i3) {
        int i4;
        final Function2 function22;
        Composer composerK = composer.k(605522716);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(selectionManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(605522716, i4, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:103)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new ContextMenuState(null, 1, null);
                composerK.w(objG);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$7$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m65invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m65invoke() {
                        ContextMenuState_androidKt.a(contextMenuState);
                    }
                };
                composerK.w(objG2);
            }
            function22 = function2;
            ContextMenuArea_androidKt.b(contextMenuState, (Function0) objG2, SelectionManager_androidKt.a(selectionManager, contextMenuState), null, false, null, function22, composerK, ((i4 << 15) & 3670016) | 54, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function22 = function2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$8
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
                    ContextMenu_androidKt.b(selectionManager, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void c(final TextFieldSelectionManager textFieldSelectionManager, Function2 function2, Composer composer, final int i3) {
        int i4;
        final Function2 function22;
        Composer composerK = composer.k(-1985516685);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(textFieldSelectionManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1985516685, i4, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:43)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new ContextMenuState(null, 1, null);
                composerK.w(objG);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(MenuItemsAvailability.b(MenuItemsAvailability.f9861b.a()), null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m61invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m61invoke() {
                        ContextMenuState_androidKt.a(contextMenuState);
                    }
                };
                composerK.w(objG4);
            }
            Function0 function0 = (Function0) objG4;
            Function1 function1A = TextFieldSelectionManager_androidKt.a(textFieldSelectionManager, contextMenuState, mutableState);
            boolean zH = textFieldSelectionManager.H();
            boolean zI = composerK.I(coroutineScope) | composerK.I(textFieldSelectionManager);
            Object objG5 = composerK.G();
            if (zI || objG5 == companion.a()) {
                objG5 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1$1", f = "ContextMenu.android.kt", l = {56}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        Object f9495a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f9496b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ MutableState f9497c;

                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TextFieldSelectionManager f9498d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(MutableState mutableState, TextFieldSelectionManager textFieldSelectionManager, Continuation continuation) {
                            super(2, continuation);
                            this.f9497c = mutableState;
                            this.f9498d = textFieldSelectionManager;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f9497c, this.f9498d, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            MutableState mutableState;
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f9496b;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                MutableState mutableState2 = this.f9497c;
                                TextFieldSelectionManager textFieldSelectionManager = this.f9498d;
                                this.f9495a = mutableState2;
                                this.f9496b = 1;
                                Object objE = ContextMenu_androidKt.e(textFieldSelectionManager, this);
                                if (objE == objF) {
                                    return objF;
                                }
                                mutableState = mutableState2;
                                obj = objE;
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutableState = (MutableState) this.f9495a;
                                ResultKt.b(obj);
                            }
                            mutableState.setValue(obj);
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
                        m62invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m62invoke() {
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(mutableState, textFieldSelectionManager, null), 1, null);
                    }
                };
                composerK.w(objG5);
            }
            function22 = function2;
            ContextMenuArea_androidKt.b(contextMenuState, function0, function1A, null, zH, (Function0) objG5, function22, composerK, ((i4 << 15) & 3670016) | 54, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function22 = function2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$3
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
                    ContextMenu_androidKt.c(textFieldSelectionManager, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1 r0 = (androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1) r0
            int r1 = r0.f9529d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9529d = r1
            goto L18
        L13:
            androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1 r0 = new androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f9528c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f9529d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r5 = r0.f9527b
            java.lang.Object r0 = r0.f9526a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.b(r6)
            goto L4f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.C()
            r0.f9526a = r5
            r0.f9527b = r6
            r0.f9529d = r3
            java.lang.Object r0 = r5.E(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L4f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            boolean r1 = r0.D()
            boolean r2 = r0.F()
            boolean r0 = r0.B()
            int r5 = androidx.compose.foundation.text.MenuItemsAvailability.d(r5, r6, r1, r2, r0)
            androidx.compose.foundation.text.MenuItemsAvailability r5 = androidx.compose.foundation.text.MenuItemsAvailability.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ContextMenu_androidKt.d(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[PHI: r2 r5 r7 r8
      0x0093: PHI (r2v3 ??) = (r2v1 ??), (r2v10 ??) binds: [B:20:0x005e, B:34:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r5v3 int) = (r5v1 int), (r5v11 int) binds: [B:20:0x005e, B:34:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r7v3 androidx.compose.foundation.text.selection.TextFieldSelectionManager) = 
      (r7v0 androidx.compose.foundation.text.selection.TextFieldSelectionManager)
      (r7v9 androidx.compose.foundation.text.selection.TextFieldSelectionManager)
     binds: [B:20:0x005e, B:34:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r8v10 int) = (r8v6 int), (r8v12 int) binds: [B:20:0x005e, B:34:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r8v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(androidx.compose.foundation.text.selection.TextFieldSelectionManager r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ContextMenu_androidKt.e(androidx.compose.foundation.text.selection.TextFieldSelectionManager, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
