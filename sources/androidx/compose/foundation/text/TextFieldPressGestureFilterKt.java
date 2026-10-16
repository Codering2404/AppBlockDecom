package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class TextFieldPressGestureFilterKt {
    public static final Modifier a(Modifier modifier, final MutableInteractionSource mutableInteractionSource, boolean z2, final Function1 function1) {
        return z2 ? ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-102778667);
                if (ComposerKt.M()) {
                    ComposerKt.U(-102778667, i3, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
                }
                Object objG = composer.G();
                Composer.Companion companion = Composer.f23746a;
                if (objG == companion.a()) {
                    objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                    composer.w(objG);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objG;
                Object objG2 = composer.G();
                if (objG2 == companion.a()) {
                    objG2 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                    composer.w(objG2);
                }
                final MutableState mutableState = (MutableState) objG2;
                final State stateP = SnapshotStateKt.p(function1, composer, 0);
                Object obj = mutableInteractionSource;
                boolean Z = composer.Z(obj);
                final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                Object objG3 = composer.G();
                if (Z || objG3 == companion.a()) {
                    objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final MutableState mutableState2 = mutableState;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    PressInteraction.Press press = (PressInteraction.Press) mutableState2.getValue();
                                    if (press != null) {
                                        PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                        if (mutableInteractionSource4 != null) {
                                            mutableInteractionSource4.b(cancel);
                                        }
                                        mutableState2.setValue(null);
                                    }
                                }
                            };
                        }
                    };
                    composer.w(objG3);
                }
                EffectsKt.c(obj, (Function1) objG3, composer, 0);
                Modifier.Companion companion2 = Modifier.b8;
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                boolean zI = composer.I(coroutineScope) | composer.Z(mutableInteractionSource) | composer.Z(stateP);
                final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource;
                Object objG4 = composer.G();
                if (zI || objG4 == companion.a()) {
                    objG4 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        @Metadata
                        @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", l = {67}, m = "invokeSuspend")
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            int f9978a;

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            private /* synthetic */ Object f9979b;

                            /* JADX INFO: renamed from: c, reason: collision with root package name */
                            /* synthetic */ long f9980c;

                            /* JADX INFO: renamed from: d, reason: collision with root package name */
                            final /* synthetic */ CoroutineScope f9981d;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            final /* synthetic */ MutableState f9982f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            final /* synthetic */ MutableInteractionSource f9983g;

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            /* JADX INFO: loaded from: classes2.dex */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1", f = "TextFieldPressGestureFilter.kt", l = {60, 64}, m = "invokeSuspend")
                            static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                Object f9984a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                int f9985b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ MutableState f9986c;

                                /* JADX INFO: renamed from: d, reason: collision with root package name */
                                final /* synthetic */ long f9987d;

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                final /* synthetic */ MutableInteractionSource f9988f;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00251(MutableState mutableState, long j3, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
                                    super(2, continuation);
                                    this.f9986c = mutableState;
                                    this.f9987d = j3;
                                    this.f9988f = mutableInteractionSource;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new C00251(this.f9986c, this.f9987d, this.f9988f, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((C00251) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                                    /*
                                        r7 = this;
                                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                        int r1 = r7.f9985b
                                        r2 = 0
                                        r3 = 2
                                        r4 = 1
                                        if (r1 == 0) goto L28
                                        if (r1 == r4) goto L20
                                        if (r1 != r3) goto L17
                                        java.lang.Object r0 = r7.f9984a
                                        androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
                                        kotlin.ResultKt.b(r8)
                                        goto L67
                                    L17:
                                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                        r0 = 0
                                        java.lang.String r0 = kotlin.comparisons.xn.YvFRmou.klgjACIYBrc
                                        r8.<init>(r0)
                                        throw r8
                                    L20:
                                        java.lang.Object r1 = r7.f9984a
                                        androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                                        kotlin.ResultKt.b(r8)
                                        goto L4c
                                    L28:
                                        kotlin.ResultKt.b(r8)
                                        androidx.compose.runtime.MutableState r8 = r7.f9986c
                                        java.lang.Object r8 = r8.getValue()
                                        androidx.compose.foundation.interaction.PressInteraction$Press r8 = (androidx.compose.foundation.interaction.PressInteraction.Press) r8
                                        if (r8 == 0) goto L50
                                        androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.f9988f
                                        androidx.compose.runtime.MutableState r5 = r7.f9986c
                                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                                        r6.<init>(r8)
                                        if (r1 == 0) goto L4d
                                        r7.f9984a = r5
                                        r7.f9985b = r4
                                        java.lang.Object r8 = r1.a(r6, r7)
                                        if (r8 != r0) goto L4b
                                        goto L65
                                    L4b:
                                        r1 = r5
                                    L4c:
                                        r5 = r1
                                    L4d:
                                        r5.setValue(r2)
                                    L50:
                                        androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
                                        long r4 = r7.f9987d
                                        r8.<init>(r4, r2)
                                        androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.f9988f
                                        if (r1 == 0) goto L68
                                        r7.f9984a = r8
                                        r7.f9985b = r3
                                        java.lang.Object r1 = r1.a(r8, r7)
                                        if (r1 != r0) goto L66
                                    L65:
                                        return r0
                                    L66:
                                        r0 = r8
                                    L67:
                                        r8 = r0
                                    L68:
                                        androidx.compose.runtime.MutableState r0 = r7.f9986c
                                        r0.setValue(r8)
                                        kotlin.Unit r8 = kotlin.Unit.f139807a
                                        return r8
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1.C00251.invokeSuspend(java.lang.Object):java.lang.Object");
                                }
                            }

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2", f = "TextFieldPressGestureFilter.kt", l = {76}, m = "invokeSuspend")
                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                Object f9989a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                int f9990b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ MutableState f9991c;

                                /* JADX INFO: renamed from: d, reason: collision with root package name */
                                final /* synthetic */ boolean f9992d;

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                final /* synthetic */ MutableInteractionSource f9993f;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(MutableState mutableState, boolean z2, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
                                    super(2, continuation);
                                    this.f9991c = mutableState;
                                    this.f9992d = z2;
                                    this.f9993f = mutableInteractionSource;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new AnonymousClass2(this.f9991c, this.f9992d, this.f9993f, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    MutableState mutableState;
                                    MutableState mutableState2;
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f9990b;
                                    if (i3 == 0) {
                                        ResultKt.b(obj);
                                        PressInteraction.Press press = (PressInteraction.Press) this.f9991c.getValue();
                                        if (press != null) {
                                            boolean z2 = this.f9992d;
                                            MutableInteractionSource mutableInteractionSource = this.f9993f;
                                            mutableState = this.f9991c;
                                            Interaction release = z2 ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press);
                                            if (mutableInteractionSource != null) {
                                                this.f9989a = mutableState;
                                                this.f9990b = 1;
                                                if (mutableInteractionSource.a(release, this) == objF) {
                                                    return objF;
                                                }
                                                mutableState2 = mutableState;
                                            }
                                            mutableState.setValue(null);
                                        }
                                        return Unit.f139807a;
                                    }
                                    if (i3 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    mutableState2 = (MutableState) this.f9989a;
                                    ResultKt.b(obj);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    return Unit.f139807a;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(CoroutineScope coroutineScope, MutableState mutableState, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
                                super(3, continuation);
                                this.f9981d = coroutineScope;
                                this.f9982f = mutableState;
                                this.f9983g = mutableInteractionSource;
                            }

                            public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f9981d, this.f9982f, this.f9983g, continuation);
                                anonymousClass1.f9979b = pressGestureScope;
                                anonymousClass1.f9980c = j3;
                                return anonymousClass1.invokeSuspend(Unit.f139807a);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) throws Throwable {
                                Object objF = IntrinsicsKt.f();
                                int i3 = this.f9978a;
                                if (i3 == 0) {
                                    ResultKt.b(obj);
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.f9979b;
                                    BuildersKt__Builders_commonKt.d(this.f9981d, null, null, new C00251(this.f9982f, this.f9980c, this.f9983g, null), 3, null);
                                    this.f9978a = 1;
                                    obj = pressGestureScope.D0(this);
                                    if (obj == objF) {
                                        return objF;
                                    }
                                } else {
                                    if (i3 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                }
                                BuildersKt__Builders_commonKt.d(this.f9981d, null, null, new AnonymousClass2(this.f9982f, ((Boolean) obj).booleanValue(), this.f9983g, null), 3, null);
                                return Unit.f139807a;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, mutableState, mutableInteractionSource4, null);
                            final State state = stateP;
                            Object objK = TapGestureDetectorKt.k(pointerInputScope, anonymousClass1, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.2
                                {
                                    super(1);
                                }

                                public final void c(long j3) {
                                    ((Function1) state.getValue()).invoke(Offset.d(j3));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    c(((Offset) obj2).u());
                                    return Unit.f139807a;
                                }
                            }, continuation);
                            return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
                        }
                    };
                    composer.w(objG4);
                }
                Modifier modifierD = SuspendingPointerInputFilterKt.d(companion2, mutableInteractionSource3, (PointerInputEventHandler) objG4);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierD;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null) : modifier;
    }
}
