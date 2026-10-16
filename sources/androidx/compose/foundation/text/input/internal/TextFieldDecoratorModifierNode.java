package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.AutofillHighlightKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements DrawModifierNode, PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {
    private final MutableState A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TransformedTextFieldState f10497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextLayoutState f10498d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextFieldSelectionState f10499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputTransformation f10500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private KeyboardOptions f10503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private KeyboardActionHandler f10504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MutableInteractionSource f10506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MutableSharedFlow f10508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f10509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private HoverInteraction.Enter f10510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final DragAndDropTargetModifierNode f10511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f10512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private WindowInfo f10513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Job f10514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TextFieldKeyEventHandler f10515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 f10516w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Function1 f10517x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Job f10518y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Function0 f10519z;

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z2, boolean z3, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z4, MutableInteractionSource mutableInteractionSource, boolean z5, MutableSharedFlow mutableSharedFlow) {
        this.f10497c = transformedTextFieldState;
        this.f10498d = textLayoutState;
        this.f10499f = textFieldSelectionState;
        this.f10500g = inputTransformation;
        this.f10501h = z2;
        this.f10502i = z3;
        this.f10503j = keyboardOptions;
        this.f10504k = keyboardActionHandler;
        this.f10505l = z4;
        this.f10506m = mutableInteractionSource;
        this.f10507n = z5;
        this.f10508o = mutableSharedFlow;
        textFieldSelectionState.B0(new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m78invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m78invoke() {
                DelegatableNodeKt.i(TextFieldDecoratorModifierNode.this);
            }
        });
        this.f10509p = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1", f = "TextFieldDecoratorModifier.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f10566a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f10567b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ TextFieldDecoratorModifierNode f10568c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ PointerInputScope f10569d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, PointerInputScope pointerInputScope, Continuation continuation) {
                    super(2, continuation);
                    this.f10568c = textFieldDecoratorModifierNode;
                    this.f10569d = pointerInputScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10568c, this.f10569d, continuation);
                    anonymousClass1.f10567b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.f10566a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f10567b;
                    final TextFieldSelectionState textFieldSelectionStateN2 = this.f10568c.N2();
                    final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10568c;
                    PointerInputScope pointerInputScope = this.f10569d;
                    Function0<Unit> function0 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: CONSTRUCTOR (r8v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit>) = 
                          (r12v4 'textFieldSelectionStateN2' androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState A[DONT_INLINE])
                          (r6v0 'textFieldDecoratorModifierNode' androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode A[DONT_INLINE])
                         A[DECLARE_VAR, MD:(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void (m)] (LINE:28) call: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$requestFocus$1.<init>(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$requestFocus$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 19 more
                        */
                    /*
                        this = this;
                        kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r0 = r11.f10566a
                        if (r0 != 0) goto L4c
                        kotlin.ResultKt.b(r12)
                        java.lang.Object r12 = r11.f10567b
                        r0 = r12
                        kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r12 = r11.f10568c
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r12.N2()
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r11.f10568c
                        androidx.compose.ui.input.pointer.PointerInputScope r7 = r11.f10569d
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$requestFocus$1 r8 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$requestFocus$1
                        r8.<init>(r12, r6)
                        kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.f140919d
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1 r3 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1
                        r9 = 0
                        r3.<init>(r12, r7, r9)
                        r4 = 1
                        r5 = 0
                        r1 = 0
                        kotlinx.coroutines.BuildersKt.d(r0, r1, r2, r3, r4, r5)
                        r10 = r2
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 r1 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2
                        r2 = r6
                        r6 = 0
                        r3 = r12
                        r4 = r7
                        r5 = r8
                        r1.<init>(r2, r3, r4, r5, r6)
                        r6 = r4
                        r7 = r5
                        r4 = 1
                        r5 = 0
                        r3 = r1
                        r1 = 0
                        r2 = r10
                        kotlinx.coroutines.BuildersKt.d(r0, r1, r2, r3, r4, r5)
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3 r3 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3
                        r3.<init>(r12, r6, r7, r9)
                        kotlinx.coroutines.BuildersKt.d(r0, r1, r2, r3, r4, r5)
                        kotlin.Unit r12 = kotlin.Unit.f139807a
                        return r12
                    L4c:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objF = CoroutineScopeKt.f(new AnonymousClass1(this.f10565a, pointerInputScope, null), continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }
        }));
        this.f10511r = (DragAndDropTargetModifierNode) m2(TextFieldDragAndDropNode_androidKt.b(new Function0<Set<? extends MediaType>>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set invoke() {
                return ReceiveContentConfigurationKt.b(this.f10549a) != null ? TextFieldDecoratorModifierKt.f10496b : TextFieldDecoratorModifierKt.f10495a;
            }
        }, new Function2<ClipEntry, ClipMetadata, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(ClipEntry clipEntry, ClipMetadata clipMetadata) {
                ClipEntry clipEntryA;
                this.f10550a.F2();
                this.f10550a.N2().G();
                String strA = TransferableContent_androidKt.a(clipEntry);
                ReceiveContentConfiguration receiveContentConfigurationB = ReceiveContentConfigurationKt.b(this.f10550a);
                if (receiveContentConfigurationB != null) {
                    TransferableContent transferableContentE = receiveContentConfigurationB.a().e(new TransferableContent(clipEntry, clipMetadata, TransferableContent.Source.f5205b.b(), null, 8, null));
                    strA = (transferableContentE == null || (clipEntryA = transferableContentE.a()) == null) ? null : TransferableContent_androidKt.a(clipEntryA);
                }
                String str = strA;
                if (str != null) {
                    TransformedTextFieldState.x(this.f10550a.O2(), str, false, null, false, 14, null);
                }
                return Boolean.TRUE;
            }
        }, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$3
            {
                super(1);
            }

            public final void c(DragAndDropEvent dragAndDropEvent) {
                if (ReceiveContentConfigurationKt.b(this.f10551a) != null) {
                    DragAndDropRequestPermission_androidKt.b(this.f10551a, dragAndDropEvent);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DragAndDropEvent) obj);
                return Unit.f139807a;
            }
        }, null, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$4
            {
                super(1);
            }

            public final void c(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentListener receiveContentListenerA;
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10552a;
                HoverInteraction.Enter enter = new HoverInteraction.Enter();
                this.f10552a.I2().b(enter);
                textFieldDecoratorModifierNode.f10510q = enter;
                ReceiveContentConfiguration receiveContentConfigurationB = ReceiveContentConfigurationKt.b(this.f10552a);
                if (receiveContentConfigurationB == null || (receiveContentListenerA = receiveContentConfigurationB.a()) == null) {
                    return;
                }
                receiveContentListenerA.a();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DragAndDropEvent) obj);
                return Unit.f139807a;
            }
        }, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$5
            {
                super(1);
            }

            public final void c(long j3) {
                long jD = TextLayoutStateKt.d(this.f10553a.P2(), j3);
                int i3 = TextLayoutState.i(this.f10553a.P2(), jD, false, 2, null);
                if (i3 >= 0) {
                    this.f10553a.O2().B(TextRangeKt.a(i3));
                }
                this.f10553a.N2().I0(Handle.f9697a, jD);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, null, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$6
            {
                super(1);
            }

            public final void c(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentListener receiveContentListenerA;
                this.f10554a.F2();
                this.f10554a.N2().G();
                ReceiveContentConfiguration receiveContentConfigurationB = ReceiveContentConfigurationKt.b(this.f10554a);
                if (receiveContentConfigurationB == null || (receiveContentListenerA = receiveContentConfigurationB.a()) == null) {
                    return;
                }
                receiveContentListenerA.d();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DragAndDropEvent) obj);
                return Unit.f139807a;
            }
        }, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$7
            {
                super(1);
            }

            public final void c(DragAndDropEvent dragAndDropEvent) {
                this.f10555a.F2();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DragAndDropEvent) obj);
                return Unit.f139807a;
            }
        }, 72, null));
        this.f10515v = TextFieldKeyEventHandler_androidKt.b();
        this.f10516w = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.f10517x = ClipboardKeyCommandsHandler.a(new Function1<KeyCommand, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1", f = "TextFieldDecoratorModifier.kt", l = {385, 386, 387}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f10545a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ KeyCommand f10546b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ TextFieldDecoratorModifierNode f10547c;

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1$WhenMappings */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f10548a;

                    static {
                        int[] iArr = new int[KeyCommand.values().length];
                        try {
                            iArr[KeyCommand.f9739s.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[KeyCommand.f9741u.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[KeyCommand.f9740t.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f10548a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(KeyCommand keyCommand, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation continuation) {
                    super(2, continuation);
                    this.f10546b = keyCommand;
                    this.f10547c = textFieldDecoratorModifierNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f10546b, this.f10547c, continuation);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
                
                    if (r6.q0(r5) == r0) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
                
                    if (r6.K(r5) == r0) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
                
                    if (r6.H(false, r5) == r0) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
                
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
                        int r1 = r5.f10545a
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L1d
                        if (r1 == r4) goto L11
                        if (r1 == r3) goto L11
                        if (r1 != r2) goto L15
                    L11:
                        kotlin.ResultKt.b(r6)
                        goto L5f
                    L15:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1d:
                        kotlin.ResultKt.b(r6)
                        androidx.compose.foundation.text.KeyCommand r6 = r5.f10546b
                        int[] r1 = androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1.AnonymousClass1.WhenMappings.f10548a
                        int r6 = r6.ordinal()
                        r6 = r1[r6]
                        if (r6 == r4) goto L4f
                        if (r6 == r3) goto L40
                        if (r6 == r2) goto L31
                        goto L5f
                    L31:
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.f10547c
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.N2()
                        r5.f10545a = r2
                        java.lang.Object r6 = r6.q0(r5)
                        if (r6 != r0) goto L5f
                        goto L5e
                    L40:
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.f10547c
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.N2()
                        r5.f10545a = r3
                        java.lang.Object r6 = r6.K(r5)
                        if (r6 != r0) goto L5f
                        goto L5e
                    L4f:
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.f10547c
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.N2()
                        r5.f10545a = r4
                        r1 = 0
                        java.lang.Object r6 = r6.H(r1, r5)
                        if (r6 != r0) goto L5f
                    L5e:
                        return r0
                    L5f:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            {
                super(1);
            }

            public final void c(KeyCommand keyCommand) {
                BuildersKt__Builders_commonKt.d(this.f10544a.getCoroutineScope(), null, CoroutineStart.f140919d, new AnonymousClass1(keyCommand, this.f10544a, null), 1, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((KeyCommand) obj);
                return Unit.f139807a;
            }
        });
        this.f10519z = new Function0<ReceiveContentConfiguration>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$receiveContentConfigurationProvider$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ReceiveContentConfiguration invoke() {
                return ReceiveContentConfigurationKt.b(this.f10585a);
            }
        };
        this.A = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
    }

    private final void E2() {
        Job job = this.f10518y;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f10518y = null;
        MutableSharedFlow mutableSharedFlow = this.f10508o;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2() {
        HoverInteraction.Enter enter = this.f10510q;
        if (enter != null) {
            this.f10506m.b(new HoverInteraction.Exit(enter));
            this.f10510q = null;
        }
    }

    private final boolean G2() {
        return ((Boolean) this.A.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q2() {
        WindowInfo windowInfo = this.f10513t;
        return this.f10512s && (windowInfo != null && windowInfo.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R2(Continuation continuation) {
        Object objCollect = FlowKt.i0(FlowKt.x(SnapshotStateKt.q(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$observeUntransformedTextChanges$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.f10557a.O2().n().toString();
            }
        }), 1), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$observeUntransformedTextChanges$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, Continuation continuation2) {
                this.f10558a.V2(false);
                return Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S2() {
        this.f10499f.x0(Q2());
        if (Q2() && this.f10514u == null) {
            this.f10514u = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$onFocusChange$1(this, null), 3, null);
        } else {
            if (Q2()) {
                return;
            }
            Job job = this.f10514u;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f10514u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T2(final int i3) {
        KeyboardActionHandler keyboardActionHandler;
        ImeAction.Companion companion = ImeAction.f29348b;
        if (ImeAction.m(i3, companion.e()) || ImeAction.m(i3, companion.a()) || (keyboardActionHandler = this.f10504k) == null) {
            this.f10516w.a(i3);
        } else if (keyboardActionHandler != null) {
            keyboardActionHandler.a(new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onImeActionPerformed$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m79invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m79invoke() {
                    this.f10561a.f10516w.a(i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoftwareKeyboardController U2() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.q());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V2(boolean z2) {
        this.A.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2(boolean z2) {
        if (z2 || this.f10503j.l()) {
            this.f10518y = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$startInputSession$1(this, ReceiveContentConfigurationKt.b(this), null), 3, null);
        }
    }

    public final boolean H2() {
        return this.f10501h;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        this.f10498d.n(layoutCoordinates);
    }

    public final MutableInteractionSource I2() {
        return this.f10506m;
    }

    public final KeyboardOptions J2() {
        return this.f10503j;
    }

    public final boolean K2() {
        return this.f10502i;
    }

    public final boolean L2() {
        return this.f10505l;
    }

    public final MutableSharedFlow M2() {
        return this.f10508o;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence textFieldCharSequenceL = this.f10497c.l();
        long jG = textFieldCharSequenceL.g();
        SemanticsPropertiesKt.k0(semanticsPropertyReceiver, new AnnotatedString(this.f10497c.n().toString(), null, 2, null));
        SemanticsPropertiesKt.h0(semanticsPropertyReceiver, new AnnotatedString(textFieldCharSequenceL.toString(), null, 2, null));
        SemanticsPropertiesKt.B0(semanticsPropertyReceiver, jG);
        if (!this.f10501h) {
            SemanticsPropertiesKt.l(semanticsPropertyReceiver);
        }
        if (this.f10507n) {
            SemanticsPropertiesKt.O(semanticsPropertyReceiver);
        }
        final boolean z2 = this.f10501h && !this.f10502i;
        SemanticsPropertiesKt.g0(semanticsPropertyReceiver, z2);
        SemanticsPropertiesKt.c0(semanticsPropertyReceiver, ContentDataType.f25250a.a());
        SemanticsPropertiesKt.z(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            /* JADX INFO: loaded from: classes2.dex */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$1$1", f = "TextFieldDecoratorModifier.kt", l = {536}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f10523a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ TextFieldDecoratorModifierNode f10524b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation continuation) {
                    super(2, continuation);
                    this.f10524b = textFieldDecoratorModifierNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f10524b, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f10523a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.b(obj);
                        } else {
                            throw new IllegalStateException(QaXmqxvjHhxVy.sPfX);
                        }
                    } else {
                        ResultKt.b(obj);
                        TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10524b;
                        this.f10523a = 1;
                        if (textFieldDecoratorModifierNode.R2(this) == objF) {
                            return objF;
                        }
                    }
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AnnotatedString annotatedString) {
                if (!z2) {
                    return Boolean.FALSE;
                }
                this.O2().v(annotatedString);
                this.V2(true);
                BuildersKt__Builders_commonKt.d(this.getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.u(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List list) {
                TextLayoutResult textLayoutResultF = this.f10531a.P2().f();
                return Boolean.valueOf(textLayoutResultF != null ? list.add(textLayoutResultF) : false);
            }
        }, 1, null);
        if (z2) {
            SemanticsPropertiesKt.A0(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(AnnotatedString annotatedString) {
                    if (!z2) {
                        return Boolean.FALSE;
                    }
                    this.O2().v(annotatedString);
                    return Boolean.TRUE;
                }
            }, 1, null);
            SemanticsPropertiesKt.x(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(AnnotatedString annotatedString) {
                    if (!z2) {
                        return Boolean.FALSE;
                    }
                    TransformedTextFieldState.x(this.O2(), annotatedString, true, null, false, 12, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
        }
        SemanticsPropertiesKt.u0(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$5
            {
                super(3);
            }

            public final Boolean c(int i3, int i4, boolean z3) {
                TextFieldCharSequence textFieldCharSequenceN = z3 ? this.f10536a.O2().n() : this.f10536a.O2().o();
                long jG2 = textFieldCharSequenceN.g();
                if (!this.f10536a.H2() || Math.min(i3, i4) < 0 || Math.max(i3, i4) > textFieldCharSequenceN.length()) {
                    return Boolean.FALSE;
                }
                if (i3 == TextRange.n(jG2) && i4 == TextRange.i(jG2)) {
                    return Boolean.TRUE;
                }
                long jB = TextRangeKt.b(i3, i4);
                if (z3 || i3 == i4) {
                    this.f10536a.N2().L0(TextToolbarState.f10960a);
                } else {
                    this.f10536a.N2().L0(TextToolbarState.f10962c);
                }
                if (z3) {
                    this.f10536a.O2().C(jB);
                } else {
                    this.f10536a.O2().B(jB);
                }
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }
        }, 1, null);
        final int i3 = this.f10503j.i();
        SemanticsPropertiesKt.D(semanticsPropertyReceiver, i3, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f10537a.T2(i3);
                return Boolean.TRUE;
            }
        }, 2, null);
        SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!this.f10539a.Q2()) {
                    FocusRequesterModifierNodeKt.b(this.f10539a);
                } else if (!this.f10539a.K2()) {
                    this.f10539a.U2().show();
                }
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.F(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$8
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!this.f10540a.Q2()) {
                    FocusRequesterModifierNodeKt.b(this.f10540a);
                }
                this.f10540a.N2().L0(TextToolbarState.f10962c);
                return Boolean.TRUE;
            }
        }, 1, null);
        if (!TextRange.h(jG) && !this.f10507n) {
            SemanticsPropertiesKt.h(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$9

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$9$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$9$1", f = "TextFieldDecoratorModifier.kt", l = {622}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f10542a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ TextFieldDecoratorModifierNode f10543b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation continuation) {
                        super(2, continuation);
                        this.f10543b = textFieldDecoratorModifierNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f10543b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f10542a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            TextFieldSelectionState textFieldSelectionStateN2 = this.f10543b.N2();
                            this.f10542a = 1;
                            if (TextFieldSelectionState.I(textFieldSelectionStateN2, false, this, 1, null) == objF) {
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

                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    BuildersKt__Builders_commonKt.d(this.f10541a.getCoroutineScope(), null, null, new AnonymousClass1(this.f10541a, null), 3, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
            if (this.f10501h && !this.f10502i) {
                SemanticsPropertiesKt.j(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$10

                    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$10$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$10$1", f = "TextFieldDecoratorModifier.kt", l = {627}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f10526a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ TextFieldDecoratorModifierNode f10527b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation continuation) {
                            super(2, continuation);
                            this.f10527b = textFieldDecoratorModifierNode;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f10527b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f10526a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                TextFieldSelectionState textFieldSelectionStateN2 = this.f10527b.N2();
                                this.f10526a = 1;
                                if (textFieldSelectionStateN2.K(this) == objF) {
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

                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        BuildersKt__Builders_commonKt.d(this.f10525a.getCoroutineScope(), null, null, new AnonymousClass1(this.f10525a, null), 3, null);
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        }
        if (z2) {
            SemanticsPropertiesKt.Q(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$11

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$11$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$applySemantics$11$1", f = "TextFieldDecoratorModifier.kt", l = {634}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f10529a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ TextFieldDecoratorModifierNode f10530b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation continuation) {
                        super(2, continuation);
                        this.f10530b = textFieldDecoratorModifierNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f10530b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f10529a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            TextFieldSelectionState textFieldSelectionStateN2 = this.f10530b.N2();
                            this.f10529a = 1;
                            if (textFieldSelectionStateN2.q0(this) == objF) {
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

                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    BuildersKt__Builders_commonKt.d(this.f10528a.getCoroutineScope(), null, null, new AnonymousClass1(this.f10528a, null), 3, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
        }
        InputTransformation inputTransformation = this.f10500g;
        if (inputTransformation != null) {
            inputTransformation.N(semanticsPropertyReceiver);
        }
    }

    public final TextFieldSelectionState N2() {
        return this.f10499f;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        if (this.f10512s == focusState.a()) {
            return;
        }
        this.f10512s = focusState.a();
        S2();
        boolean z2 = this.f10501h && !this.f10502i;
        if (focusState.a()) {
            if (z2) {
                W2(false);
                return;
            }
            return;
        }
        E2();
        TransformedTextFieldState transformedTextFieldState = this.f10497c;
        TextFieldState textFieldState = transformedTextFieldState.f10664a;
        InputTransformation inputTransformation = transformedTextFieldState.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        textFieldBufferF.d();
        transformedTextFieldState.G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
        this.f10497c.h();
    }

    public final TransformedTextFieldState O2() {
        return this.f10497c;
    }

    public final TextLayoutState P2() {
        return this.f10498d;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean R0(KeyEvent keyEvent) {
        return this.f10515v.c(keyEvent, this.f10497c, this.f10499f, (FocusManager) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.g()), U2());
    }

    public final void X2(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z2, boolean z3, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z4, MutableInteractionSource mutableInteractionSource, boolean z5, MutableSharedFlow mutableSharedFlow) {
        TextFieldSelectionState textFieldSelectionState2;
        boolean z6;
        Job job;
        boolean z7 = this.f10501h;
        boolean z8 = z7 && !this.f10502i;
        TransformedTextFieldState transformedTextFieldState2 = this.f10497c;
        KeyboardOptions keyboardOptions2 = this.f10503j;
        TextFieldSelectionState textFieldSelectionState3 = this.f10499f;
        MutableInteractionSource mutableInteractionSource2 = this.f10506m;
        boolean z9 = this.f10507n;
        MutableSharedFlow mutableSharedFlow2 = this.f10508o;
        if (!z2 || z3) {
            textFieldSelectionState2 = textFieldSelectionState3;
            z6 = false;
        } else {
            textFieldSelectionState2 = textFieldSelectionState3;
            z6 = true;
        }
        this.f10497c = transformedTextFieldState;
        this.f10498d = textLayoutState;
        this.f10499f = textFieldSelectionState;
        this.f10500g = inputTransformation;
        this.f10501h = z2;
        this.f10502i = z3;
        this.f10503j = keyboardOptions;
        this.f10504k = keyboardActionHandler;
        this.f10505l = z4;
        this.f10506m = mutableInteractionSource;
        this.f10507n = z5;
        this.f10508o = mutableSharedFlow;
        if (z6 != z8 || !Intrinsics.areEqual(transformedTextFieldState, transformedTextFieldState2) || !Intrinsics.areEqual(keyboardOptions, keyboardOptions2) || !Intrinsics.areEqual(mutableSharedFlow, mutableSharedFlow2)) {
            if (z6 && Q2()) {
                W2(false);
            } else if (!z6) {
                E2();
            }
        }
        if (z2 != z7 || z6 != z8 || !ImeAction.m(keyboardOptions.i(), keyboardOptions2.i()) || z5 != z9) {
            SemanticsModifierNodeKt.b(this);
        }
        if (!Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2)) {
            this.f10509p.O0();
            if (isAttached()) {
                textFieldSelectionState.A0(this.f10519z);
                if (Q2() && (job = this.f10514u) != null) {
                    if (job != null) {
                        Job.DefaultImpls.b(job, null, 1, null);
                    }
                    this.f10514u = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$updateNode$1(textFieldSelectionState, null), 3, null);
                }
            }
            textFieldSelectionState.B0(new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$updateNode$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m85invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m85invoke() {
                    DelegatableNodeKt.i(this.f10596a);
                }
            });
        }
        if (Intrinsics.areEqual(mutableInteractionSource, mutableInteractionSource2)) {
            return;
        }
        this.f10509p.O0();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean d2() {
        return true;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.i2();
        if (G2()) {
            DrawScope.L1(contentDrawScope, ((Color) CompositionLocalConsumerModifierNodeKt.a(this, AutofillHighlightKt.a())).B(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        this.f10509p.g0(pointerEvent, pointerEventPass, j3);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f10511r.m(j3);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean o1(KeyEvent keyEvent) {
        return this.f10515v.b(keyEvent, this.f10497c, this.f10498d, this.f10499f, this.f10517x, this.f10501h && !this.f10502i, this.f10505l, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onKeyEvent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m80invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m80invoke() {
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10563a;
                textFieldDecoratorModifierNode.T2(textFieldDecoratorModifierNode.J2().i());
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        w0();
        this.f10499f.A0(this.f10519z);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        E2();
        this.f10499f.A0(null);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void p(LayoutCoordinates layoutCoordinates) {
        this.f10511r.p(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        this.f10509p.u1();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onObservedReadsChanged$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m81invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m81invoke() {
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10564a;
                textFieldDecoratorModifierNode.f10513t = (WindowInfo) CompositionLocalConsumerModifierNodeKt.a(textFieldDecoratorModifierNode, CompositionLocalsKt.u());
                this.f10564a.S2();
            }
        });
    }
}
