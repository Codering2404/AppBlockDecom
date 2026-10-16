package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

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
public final class SelectionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SelectionRegistrarImpl f11420a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HapticFeedback f11424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f11425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextToolbar f11426g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Offset f11429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LayoutCoordinates f11430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f11431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f11432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f11433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f11434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableState f11435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableState f11436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SelectionLayout f11437r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f11438s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f11421b = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f11422c = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f11423d = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$1
        {
            super(1);
        }

        public final void c(Selection selection) {
            this.f11460a.f0(selection);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Selection) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FocusRequester f11427h = new FocusRequester();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f11428i = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        this.f11420a = selectionRegistrarImpl;
        Offset.Companion companion = Offset.f25596b;
        this.f11431l = SnapshotStateKt__SnapshotStateKt.e(Offset.d(companion.c()), null, 2, null);
        this.f11432m = SnapshotStateKt__SnapshotStateKt.e(Offset.d(companion.c()), null, 2, null);
        this.f11433n = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11434o = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11435p = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11436q = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        selectionRegistrarImpl.p(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            public final void c(long j3) {
                if (SelectionManager.this.f11420a.b().a(j3)) {
                    SelectionManager.this.m0();
                    SelectionManager.this.p0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Number) obj).longValue());
                return Unit.f139807a;
            }
        });
        selectionRegistrarImpl.u(new Function4<Boolean, LayoutCoordinates, Offset, SelectionAdjustment, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(4);
            }

            public final void c(boolean z2, LayoutCoordinates layoutCoordinates, long j3, SelectionAdjustment selectionAdjustment) {
                long jA = layoutCoordinates.a();
                Rect rect = new Rect(0.0f, 0.0f, (int) (jA >> 32), (int) (jA & 4294967295L));
                if (!SelectionManagerKt.d(rect, j3)) {
                    j3 = TextLayoutStateKt.a(j3, rect);
                }
                long jN = SelectionManager.this.n(layoutCoordinates, j3);
                if ((9223372034707292159L & jN) != 9205357640488583168L) {
                    SelectionManager.this.c0(z2);
                    SelectionManager.this.k0(jN, false, selectionAdjustment);
                    FocusRequester.h(SelectionManager.this.y(), 0, 1, null);
                    SelectionManager.this.g0(false);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).u(), (SelectionAdjustment) obj4);
                return Unit.f139807a;
            }
        });
        selectionRegistrarImpl.t(new Function2<Boolean, Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(2);
            }

            public final void c(boolean z2, long j3) {
                SelectionManager selectionManager = SelectionManager.this;
                Pair pairS = selectionManager.S(j3, selectionManager.D());
                Selection selection = (Selection) pairS.a();
                LongObjectMap longObjectMap = (LongObjectMap) pairS.b();
                if (!Intrinsics.areEqual(selection, SelectionManager.this.D())) {
                    SelectionManager.this.f11420a.v(longObjectMap);
                    SelectionManager.this.B().invoke(selection);
                }
                SelectionManager.this.c0(z2);
                FocusRequester.h(SelectionManager.this.y(), 0, 1, null);
                SelectionManager.this.g0(false);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c(((Boolean) obj).booleanValue(), ((Number) obj2).longValue());
                return Unit.f139807a;
            }
        });
        selectionRegistrarImpl.r(new Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(6);
            }

            public final Boolean c(boolean z2, LayoutCoordinates layoutCoordinates, long j3, long j4, boolean z3, SelectionAdjustment selectionAdjustment) {
                long jN = SelectionManager.this.n(layoutCoordinates, j3);
                long jN2 = SelectionManager.this.n(layoutCoordinates, j4);
                SelectionManager.this.c0(z2);
                return Boolean.valueOf(SelectionManager.this.o0(Offset.d(jN), jN2, z3, selectionAdjustment));
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return c(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).u(), ((Offset) obj4).u(), ((Boolean) obj5).booleanValue(), (SelectionAdjustment) obj6);
            }
        });
        selectionRegistrarImpl.s(new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m97invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m97invoke() {
                SelectionManager.this.g0(true);
                SelectionManager.this.Y(null);
                SelectionManager.this.V(null);
            }
        });
        selectionRegistrarImpl.q(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            public final void c(long j3) {
                if (SelectionManager.this.f11420a.b().a(j3)) {
                    SelectionManager.this.P();
                    SelectionManager.this.f0(null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Number) obj).longValue());
                return Unit.f139807a;
            }
        });
        selectionRegistrarImpl.o(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            public final void c(long j3) {
                Selection.AnchorInfo anchorInfoC;
                Selection.AnchorInfo anchorInfoE;
                Selection selectionD = SelectionManager.this.D();
                if (selectionD != null && (anchorInfoE = selectionD.e()) != null && j3 == anchorInfoE.e()) {
                    SelectionManager.this.h0(null);
                }
                Selection selectionD2 = SelectionManager.this.D();
                if (selectionD2 != null && (anchorInfoC = selectionD2.c()) != null && j3 == anchorInfoC.e()) {
                    SelectionManager.this.Z(null);
                }
                if (SelectionManager.this.f11420a.b().a(j3)) {
                    SelectionManager.this.p0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Number) obj).longValue());
                return Unit.f139807a;
            }
        });
    }

    private final SelectionLayout E(long j3, long j4, boolean z2) {
        LayoutCoordinates layoutCoordinatesQ = Q();
        List listW = this.f11420a.w(layoutCoordinatesQ);
        final MutableLongIntMap mutableLongIntMapA = LongIntMapKt.a();
        List list = listW;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            mutableLongIntMapA.n(((Selectable) listW.get(i3)).j(), i3);
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(j3, j4, layoutCoordinatesQ, z2, (j4 & 9223372034707292159L) == 9205357640488583168L ? null : D(), new Comparator() { // from class: androidx.compose.foundation.text.selection.SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Integer.valueOf(mutableLongIntMapA.b(((Number) obj).longValue())), Integer.valueOf(mutableLongIntMapA.b(((Number) obj2).longValue())));
            }
        }, null);
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((Selectable) listW.get(i4)).l(selectionLayoutBuilder);
        }
        return selectionLayoutBuilder.b();
    }

    private final boolean F() {
        return J() && L() && !N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J() {
        return v() != null;
    }

    private final Modifier O(Modifier modifier, final Function0 function0) {
        return SuspendingPointerInputFilterKt.d(modifier, Unit.f139807a, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1", f = "SelectionManager.kt", l = {754, 760}, m = "invokeSuspend")
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f11456a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f11457b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ SelectionManager f11458c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0 f11459d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SelectionManager selectionManager, Function0 function0, Continuation continuation) {
                    super(2, continuation);
                    this.f11458c = selectionManager;
                    this.f11459d = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f11458c, this.f11459d, continuation);
                    anonymousClass1.f11457b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
                
                    if (r11 == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r10.f11456a
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.ResultKt.b(r11)
                        r7 = r10
                        goto L4d
                    L13:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1b:
                        java.lang.Object r1 = r10.f11457b
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.b(r11)
                        r7 = r10
                        goto L3d
                    L24:
                        kotlin.ResultKt.b(r11)
                        java.lang.Object r11 = r10.f11457b
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        r10.f11457b = r4
                        r10.f11456a = r3
                        r5 = 0
                        r6 = 0
                        r8 = 2
                        r9 = 0
                        r7 = r10
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.h(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3c
                        goto L4c
                    L3c:
                        r1 = r4
                    L3d:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                        r4 = 0
                        r7.f11457b = r4
                        r7.f11456a = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.b(r1, r11, r3, r10)
                        if (r11 != r0) goto L4d
                    L4c:
                        return r0
                    L4d:
                        java.lang.Boolean r11 = (java.lang.Boolean) r11
                        boolean r11 = r11.booleanValue()
                        if (r11 != 0) goto L62
                        androidx.compose.foundation.text.selection.SelectionManager r11 = r7.f11458c
                        boolean r11 = androidx.compose.foundation.text.selection.SelectionManager.c(r11)
                        if (r11 != 0) goto L62
                        kotlin.jvm.functions.Function0 r11 = r7.f11459d
                        r11.invoke()
                    L62:
                        kotlin.Unit r11 = kotlin.Unit.f139807a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objE = ForEachGestureKt.e(pointerInputScope, new AnonymousClass1(this.f11454a, function0, null), continuation);
                return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
            }
        });
    }

    private final void T(SelectionLayout selectionLayout, Selection selection) {
        HapticFeedback hapticFeedback;
        if (j0() && (hapticFeedback = this.f11424e) != null) {
            hapticFeedback.a(HapticFeedbackType.f26611b.i());
        }
        this.f11420a.v(selectionLayout.h(selection));
        this.f11423d.invoke(selection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(Offset offset) {
        this.f11436q.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(long j3) {
        this.f11431l.setValue(Offset.d(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(long j3) {
        this.f11432m.setValue(Offset.d(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(Handle handle) {
        this.f11435p.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(Offset offset) {
        this.f11434o.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(Offset offset) {
        this.f11433n.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(long j3, boolean z2, SelectionAdjustment selectionAdjustment) {
        this.f11437r = null;
        n0(j3, Offset.f25596b.b(), z2, selectionAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        o();
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m0() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.foundation.text.selection.Selection r1 = r0.D()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.f11430k
            r3 = 0
            if (r1 == 0) goto L16
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r1.e()
            if (r4 == 0) goto L16
            androidx.compose.foundation.text.selection.Selectable r4 = r0.p(r4)
            goto L17
        L16:
            r4 = r3
        L17:
            if (r1 == 0) goto L24
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r1.c()
            if (r5 == 0) goto L24
            androidx.compose.foundation.text.selection.Selectable r5 = r0.p(r5)
            goto L25
        L24:
            r5 = r3
        L25:
            if (r4 == 0) goto L2c
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.z()
            goto L2d
        L2c:
            r6 = r3
        L2d:
            if (r5 == 0) goto L34
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.z()
            goto L35
        L34:
            r7 = r3
        L35:
            if (r1 == 0) goto Lab
            if (r2 == 0) goto Lab
            boolean r8 = r2.m()
            if (r8 == 0) goto Lab
            if (r6 != 0) goto L44
            if (r7 != 0) goto L44
            goto Lab
        L44:
            androidx.compose.ui.geometry.Rect r8 = androidx.compose.foundation.text.selection.SelectionManagerKt.i(r2)
            r9 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            r11 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            if (r6 == 0) goto L7b
            r13 = 1
            long r13 = r4.g(r1, r13)
            long r15 = r13 & r11
            int r4 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r4 != 0) goto L60
            goto L7b
        L60:
            long r13 = r2.S(r6, r13)
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.d(r13)
            long r13 = r4.u()
            androidx.compose.foundation.text.Handle r6 = r0.v()
            androidx.compose.foundation.text.Handle r15 = androidx.compose.foundation.text.Handle.f9698b
            if (r6 == r15) goto L7c
            boolean r6 = androidx.compose.foundation.text.selection.SelectionManagerKt.d(r8, r13)
            if (r6 == 0) goto L7b
            goto L7c
        L7b:
            r4 = r3
        L7c:
            r0.h0(r4)
            if (r7 == 0) goto La7
            r4 = 0
            long r4 = r5.g(r1, r4)
            long r11 = r11 & r4
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 != 0) goto L8c
            goto La7
        L8c:
            long r1 = r2.S(r7, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.d(r1)
            long r4 = r1.u()
            androidx.compose.foundation.text.Handle r2 = r0.v()
            androidx.compose.foundation.text.Handle r6 = androidx.compose.foundation.text.Handle.f9699c
            if (r2 == r6) goto La6
            boolean r2 = androidx.compose.foundation.text.selection.SelectionManagerKt.d(r8, r4)
            if (r2 == 0) goto La7
        La6:
            r3 = r1
        La7:
            r0.Z(r3)
            return
        Lab:
            r0.h0(r3)
            r0.Z(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.m0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long n(LayoutCoordinates layoutCoordinates, long j3) {
        LayoutCoordinates layoutCoordinates2 = this.f11430k;
        return (layoutCoordinates2 == null || !layoutCoordinates2.m()) ? Offset.f25596b.b() : Q().S(layoutCoordinates, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        TextToolbar textToolbar;
        if (z() && (textToolbar = this.f11426g) != null) {
            if (!this.f11438s || !L()) {
                if (textToolbar.getStatus() == TextToolbarStatus.f28212a) {
                    textToolbar.a();
                }
            } else {
                Rect rectR = r();
                if (rectR == null) {
                    return;
                }
                TextToolbar.c(textToolbar, rectR, M() ? new SelectionManager$updateSelectionToolbar$1(this) : null, null, null, K() ? null : new SelectionManager$updateSelectionToolbar$2(this), null, 12, null);
            }
        }
    }

    private final Rect r() {
        LayoutCoordinates layoutCoordinates;
        if (D() == null || (layoutCoordinates = this.f11430k) == null || !layoutCoordinates.m()) {
            return null;
        }
        List listW = this.f11420a.w(Q());
        ArrayList arrayList = new ArrayList(listW.size());
        int size = listW.size();
        for (int i3 = 0; i3 < size; i3++) {
            Selectable selectable = (Selectable) listW.get(i3);
            Selection selection = (Selection) this.f11420a.b().b(selectable.j());
            Pair pairA = selection != null ? TuplesKt.a(selectable, selection) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        List listE = SelectionManagerKt.e(arrayList);
        if (listE.isEmpty()) {
            return null;
        }
        Rect rectG = SelectionManagerKt.g(listE, layoutCoordinates);
        if (Intrinsics.areEqual(rectG, SelectionManagerKt.f11463a)) {
            return null;
        }
        Rect rectX = SelectionManagerKt.i(layoutCoordinates).x(rectG);
        if (rectX.p() - rectX.o() < 0.0f || rectX.i() - rectX.r() < 0.0f) {
            return null;
        }
        Rect rectB = rectX.B(LayoutCoordinatesKt.f(layoutCoordinates));
        return Rect.h(rectB, 0.0f, 0.0f, 0.0f, rectB.i() + (SelectionHandlesKt.b() * 4), 7, null);
    }

    public final Modifier A() {
        Modifier modifierC = Modifier.b8;
        Modifier modifierA = KeyInputModifierKt.a(SelectionGesturesKt.r(FocusableKt.b(FocusChangedModifierKt.a(FocusRequesterModifierKt.a(OnGloballyPositionedModifierKt.a(O(modifierC, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m98invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m98invoke() {
                this.f11449a.P();
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.f139807a;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                this.f11450a.U(layoutCoordinates);
            }
        }), this.f11427h), new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusState) obj);
                return Unit.f139807a;
            }

            public final void invoke(FocusState focusState) {
                if (!focusState.b() && this.f11451a.z()) {
                    this.f11451a.P();
                }
                this.f11451a.b0(focusState.b());
            }
        }), false, null, 3, null), new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z2) {
                this.f11452a.c0(z2);
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$5
            {
                super(1);
            }

            public final Boolean c(android.view.KeyEvent keyEvent) {
                boolean z2;
                if (SelectionManager_androidKt.b(keyEvent)) {
                    this.f11453a.o();
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((KeyEvent) obj).f());
            }
        });
        if (F()) {
            modifierC = SelectionManager_androidKt.c(modifierC, this);
        }
        return modifierA.then(modifierC);
    }

    public final Function1 B() {
        return this.f11423d;
    }

    public final AnnotatedString C() {
        if (D() == null || this.f11420a.b().e()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        List listW = this.f11420a.w(Q());
        int size = listW.size();
        for (int i3 = 0; i3 < size; i3++) {
            Selectable selectable = (Selectable) listW.get(i3);
            Selection selection = (Selection) this.f11420a.b().b(selectable.j());
            if (selection != null) {
                AnnotatedString text = selectable.getText();
                builder.j(selection.d() ? text.subSequence(selection.c().d(), selection.e().d()) : text.subSequence(selection.e().d(), selection.c().d()));
            }
        }
        return builder.t();
    }

    public final Selection D() {
        return (Selection) this.f11421b.getValue();
    }

    public final float G() {
        Selectable selectableP;
        Selection selectionD = D();
        if (selectionD == null || (selectableP = p(selectionD.e())) == null) {
            return 0.0f;
        }
        return selectableP.b(selectionD.e().d());
    }

    public final Offset H() {
        return (Offset) this.f11433n.getValue();
    }

    public final TextDragObserver I(final boolean z2) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager$handleDragObserver$1
            private final void e() {
                this.g0(true);
                this.Y(null);
                this.V(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void a(long j3) {
                LayoutCoordinates layoutCoordinatesZ;
                Offset offsetH = z2 ? this.H() : this.x();
                if (offsetH != null) {
                    offsetH.u();
                    Selection selectionD = this.D();
                    if (selectionD == null) {
                        return;
                    }
                    Selectable selectableP = this.p(z2 ? selectionD.e() : selectionD.c());
                    if (selectableP == null || (layoutCoordinatesZ = selectableP.z()) == null) {
                        return;
                    }
                    long jG = selectableP.g(selectionD, z2);
                    if ((9223372034707292159L & jG) == 9205357640488583168L) {
                        return;
                    }
                    long jA = SelectionHandlesKt.a(jG);
                    SelectionManager selectionManager = this;
                    selectionManager.V(Offset.d(selectionManager.Q().S(layoutCoordinatesZ, jA)));
                    this.Y(z2 ? Handle.f9698b : Handle.f9699c);
                    this.g0(false);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void b(long j3) {
                if (this.v() == null) {
                    return;
                }
                Selection selectionD = this.D();
                Intrinsics.checkNotNull(selectionD);
                Object objB = this.f11420a.m().b((z2 ? selectionD.e() : selectionD.c()).e());
                if (objB == null) {
                    InlineClassHelperKt.d("SelectionRegistrar should contain the current selection's selectableIds");
                    throw new KotlinNothingValueException();
                }
                Selectable selectable = (Selectable) objB;
                LayoutCoordinates layoutCoordinatesZ = selectable.z();
                if (layoutCoordinatesZ == null) {
                    InlineClassHelperKt.d("Current selectable should have layout coordinates.");
                    throw new KotlinNothingValueException();
                }
                long jG = selectable.g(selectionD, z2);
                if ((9223372034707292159L & jG) == 9205357640488583168L) {
                    return;
                }
                long jA = SelectionHandlesKt.a(jG);
                SelectionManager selectionManager = this;
                selectionManager.W(selectionManager.Q().S(layoutCoordinatesZ, jA));
                this.X(Offset.f25596b.c());
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void c() {
                e();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void d(long j3) {
                if (this.v() == null) {
                    return;
                }
                SelectionManager selectionManager = this;
                selectionManager.X(Offset.q(selectionManager.u(), j3));
                long jQ = Offset.q(this.t(), this.u());
                if (this.o0(Offset.d(jQ), this.t(), z2, SelectionAdjustment.f11264a.l())) {
                    this.W(jQ);
                    this.X(Offset.f25596b.c());
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                e();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                e();
            }
        };
    }

    public final boolean K() {
        Selection selection;
        List listW = this.f11420a.w(Q());
        if (listW.isEmpty()) {
            return true;
        }
        int size = listW.size();
        for (int i3 = 0; i3 < size; i3++) {
            Selectable selectable = (Selectable) listW.get(i3);
            AnnotatedString text = selectable.getText();
            if (text.length() != 0 && ((selection = (Selection) this.f11420a.b().b(selectable.j())) == null || Math.abs(selection.e().d() - selection.c().d()) != text.length())) {
                return false;
            }
        }
        return true;
    }

    public final boolean L() {
        return ((Boolean) this.f11422c.getValue()).booleanValue();
    }

    public final boolean M() {
        Selection selectionD = D();
        if (selectionD == null || Intrinsics.areEqual(selectionD.e(), selectionD.c())) {
            return false;
        }
        if (selectionD.e().e() == selectionD.c().e()) {
            return true;
        }
        List listW = this.f11420a.w(Q());
        int size = listW.size();
        for (int i3 = 0; i3 < size; i3++) {
            Selection selection = (Selection) this.f11420a.b().b(((Selectable) listW.get(i3)).j());
            if (selection != null && selection.e().d() != selection.c().d()) {
                return true;
            }
        }
        return false;
    }

    public final boolean N() {
        Selection selectionD = D();
        if (selectionD == null) {
            return true;
        }
        return Intrinsics.areEqual(selectionD.e(), selectionD.c());
    }

    public final void P() {
        HapticFeedback hapticFeedback;
        this.f11420a.v(LongObjectMapKt.a());
        g0(false);
        if (D() != null) {
            this.f11423d.invoke(null);
            if (!L() || (hapticFeedback = this.f11424e) == null) {
                return;
            }
            hapticFeedback.a(HapticFeedbackType.f26611b.i());
        }
    }

    public final LayoutCoordinates Q() {
        LayoutCoordinates layoutCoordinates = this.f11430k;
        if (layoutCoordinates == null) {
            InlineClassHelperKt.b("null coordinates");
            throw new KotlinNothingValueException();
        }
        if (!layoutCoordinates.m()) {
            InlineClassHelperKt.a("unattached coordinates");
        }
        return layoutCoordinates;
    }

    public final void R() {
        List listW = this.f11420a.w(Q());
        if (listW.isEmpty()) {
            return;
        }
        MutableLongObjectMap mutableLongObjectMapC = LongObjectMapKt.c();
        int size = listW.size();
        Selection selection = null;
        Selection selection2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            Selectable selectable = (Selectable) listW.get(i3);
            Selection selectionK = selectable.k();
            if (selectionK != null) {
                if (selection == null) {
                    selection = selectionK;
                }
                mutableLongObjectMapC.n(selectable.j(), selectionK);
                selection2 = selectionK;
            }
        }
        if (mutableLongObjectMapC.e()) {
            return;
        }
        if (selection != selection2) {
            Intrinsics.checkNotNull(selection);
            Selection.AnchorInfo anchorInfoE = selection.e();
            Intrinsics.checkNotNull(selection2);
            selection = new Selection(anchorInfoE, selection2.c(), false);
        }
        this.f11420a.v(mutableLongObjectMapC);
        this.f11423d.invoke(selection);
        this.f11437r = null;
    }

    public final Pair S(long j3, Selection selection) {
        HapticFeedback hapticFeedback;
        MutableLongObjectMap mutableLongObjectMapC = LongObjectMapKt.c();
        List listW = this.f11420a.w(Q());
        int size = listW.size();
        Selection selectionH = null;
        for (int i3 = 0; i3 < size; i3++) {
            Selectable selectable = (Selectable) listW.get(i3);
            Selection selectionK = selectable.j() == j3 ? selectable.k() : null;
            if (selectionK != null) {
                mutableLongObjectMapC.r(selectable.j(), selectionK);
            }
            selectionH = SelectionManagerKt.h(selectionH, selectionK);
        }
        if (L() && !Intrinsics.areEqual(selectionH, selection) && (hapticFeedback = this.f11424e) != null) {
            hapticFeedback.a(HapticFeedbackType.f26611b.i());
        }
        return new Pair(selectionH, mutableLongObjectMapC);
    }

    public final void U(LayoutCoordinates layoutCoordinates) {
        this.f11430k = layoutCoordinates;
        if (!z() || D() == null) {
            return;
        }
        Offset offsetD = layoutCoordinates != null ? Offset.d(LayoutCoordinatesKt.g(layoutCoordinates)) : null;
        if (Intrinsics.areEqual(this.f11429j, offsetD)) {
            return;
        }
        this.f11429j = offsetD;
        m0();
        p0();
    }

    public final void a0(HapticFeedback hapticFeedback) {
        this.f11424e = hapticFeedback;
    }

    public final void b0(boolean z2) {
        this.f11428i.setValue(Boolean.valueOf(z2));
    }

    public final void c0(boolean z2) {
        if (((Boolean) this.f11422c.getValue()).booleanValue() != z2) {
            this.f11422c.setValue(Boolean.valueOf(z2));
            p0();
        }
    }

    public final void d0(Function1 function1) {
        this.f11425f = function1;
    }

    public final void e0(final Function1 function1) {
        this.f11423d = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Selection selection) {
                this.f11461a.f0(selection);
                function1.invoke(selection);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Selection) obj);
                return Unit.f139807a;
            }
        };
    }

    public final void f0(Selection selection) {
        this.f11421b.setValue(selection);
        if (selection != null) {
            m0();
        }
    }

    public final void g0(boolean z2) {
        this.f11438s = z2;
        p0();
    }

    public final void i0(TextToolbar textToolbar) {
        this.f11426g = textToolbar;
    }

    public final boolean j0() {
        if (L()) {
            List listN = this.f11420a.n();
            int size = listN.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((Selectable) listN.get(i3)).getText().length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n0(long j3, long j4, boolean z2, SelectionAdjustment selectionAdjustment) {
        Y(z2 ? Handle.f9698b : Handle.f9699c);
        V(Offset.d(j3));
        SelectionLayout selectionLayoutE = E(j3, j4, z2);
        if (selectionLayoutE == null || !selectionLayoutE.i(this.f11437r)) {
            return false;
        }
        Selection selectionA = selectionAdjustment.a(selectionLayoutE);
        if (!Intrinsics.areEqual(selectionA, D())) {
            T(selectionLayoutE, selectionA);
        }
        this.f11437r = selectionLayoutE;
        return true;
    }

    public final void o() {
        Function1 function1;
        AnnotatedString annotatedStringC = C();
        if (annotatedStringC != null) {
            if (annotatedStringC.length() <= 0) {
                annotatedStringC = null;
            }
            if (annotatedStringC == null || (function1 = this.f11425f) == null) {
                return;
            }
            function1.invoke(annotatedStringC);
        }
    }

    public final boolean o0(Offset offset, long j3, boolean z2, SelectionAdjustment selectionAdjustment) {
        if (offset == null) {
            return false;
        }
        return n0(offset.u(), j3, z2, selectionAdjustment);
    }

    public final Selectable p(Selection.AnchorInfo anchorInfo) {
        return (Selectable) this.f11420a.m().b(anchorInfo.e());
    }

    public final LayoutCoordinates q() {
        return this.f11430k;
    }

    public final Offset s() {
        return (Offset) this.f11436q.getValue();
    }

    public final long t() {
        return ((Offset) this.f11431l.getValue()).u();
    }

    public final long u() {
        return ((Offset) this.f11432m.getValue()).u();
    }

    public final Handle v() {
        return (Handle) this.f11435p.getValue();
    }

    public final float w() {
        Selectable selectableP;
        Selection selectionD = D();
        if (selectionD == null || (selectableP = p(selectionD.c())) == null) {
            return 0.0f;
        }
        return selectableP.b(selectionD.c().d());
    }

    public final Offset x() {
        return (Offset) this.f11434o.getValue();
    }

    public final FocusRequester y() {
        return this.f11427h;
    }

    public final boolean z() {
        return ((Boolean) this.f11428i.getValue()).booleanValue();
    }
}
