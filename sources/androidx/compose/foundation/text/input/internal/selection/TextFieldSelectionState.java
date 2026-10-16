package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
public final class TextFieldSelectionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedTextFieldState f10754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextLayoutState f10755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Density f10756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HapticFeedback f10761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextToolbarHandler f10762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Clipboard f10763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f10764k = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Function0 f10765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Function0 f10766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f10767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f10768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableState f10769p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableState f10770q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final MutableState f10771r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f10772s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SelectionLayout f10773t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f10774u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private PressInteraction.Press f10775v;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InputType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InputType f10776a = new InputType("None", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InputType f10777b = new InputType("Touch", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final InputType f10778c = new InputType("Mouse", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ InputType[] f10779d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f10780f;

        static {
            InputType[] inputTypeArrA = a();
            f10779d = inputTypeArrA;
            f10780f = EnumEntriesKt.a(inputTypeArrA);
        }

        private InputType(String str, int i3) {
        }

        private static final /* synthetic */ InputType[] a() {
            return new InputType[]{f10776a, f10777b, f10778c};
        }

        public static InputType valueOf(String str) {
            return (InputType) Enum.valueOf(InputType.class, str);
        }

        public static InputType[] values() {
            return (InputType[]) f10779d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function0 f10781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10782b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f10783c = Offset.f25596b.b();

        public TextFieldMouseSelectionObserver(Function0 function0) {
            this.f10781a = function0;
        }

        private final long f(long j3, SelectionAdjustment selectionAdjustment, boolean z2) {
            Integer numValueOf = Integer.valueOf(this.f10782b);
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.f10755b.h(this.f10783c, false);
            int iH = TextFieldSelectionState.this.f10755b.h(j3, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jJ0 = textFieldSelectionState.J0(textFieldSelectionState.f10754a.o(), iIntValue, iH, false, selectionAdjustment, false, z2);
            if (this.f10782b == -1 && !TextRange.h(jJ0)) {
                this.f10782b = TextRange.n(jJ0);
            }
            if (TextRange.m(jJ0)) {
                jJ0 = TextFieldSelectionStateKt.d(jJ0);
            }
            TextFieldSelectionState.this.f10754a.B(jJ0);
            TextFieldSelectionState.this.L0(TextToolbarState.f10962c);
            return jJ0;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void a() {
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDragDone";
                }
            });
            TextFieldSelectionState.this.v0(InputType.f10776a);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean b(long j3) {
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtendDrag";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean c(long j3, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.f10757d || TextFieldSelectionState.this.f10754a.o().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onStart";
                }
            });
            TextFieldSelectionState.this.v0(InputType.f10778c);
            this.f10781a.invoke();
            TextFieldSelectionState.this.f10774u = -1;
            this.f10782b = -1;
            this.f10783c = j3;
            this.f10782b = TextRange.n(f(j3, selectionAdjustment, true));
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean d(final long j3, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.f10757d || TextFieldSelectionState.this.f10754a.o().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDrag " + ((Object) Offset.s(j3));
                }
            });
            f(j3, selectionAdjustment, false);
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean e(long j3) {
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtend";
                }
            });
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10799a;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.f10350a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.f10353d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.f10351b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.f10352c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f10799a = iArr;
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f10754a = transformedTextFieldState;
        this.f10755b = textLayoutState;
        this.f10756c = density;
        this.f10757d = z2;
        this.f10758e = z3;
        this.f10759f = z4;
        this.f10760g = z5;
        Offset.Companion companion = Offset.f25596b;
        this.f10767n = SnapshotStateKt__SnapshotStateKt.e(Offset.d(companion.b()), null, 2, null);
        this.f10768o = SnapshotStateKt__SnapshotStateKt.e(Offset.d(companion.b()), null, 2, null);
        this.f10769p = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f10770q = SnapshotStateKt__SnapshotStateKt.e(InputType.f10776a, null, 2, null);
        this.f10771r = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f10772s = SnapshotStateKt__SnapshotStateKt.e(TextToolbarState.f10960a, null, 2, null);
        this.f10774u = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(boolean z2) {
        this.f10771r.setValue(Boolean.valueOf(z2));
    }

    private final void D0(long j3) {
        this.f10767n.setValue(Offset.d(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(TextToolbarState textToolbarState) {
        this.f10772s.setValue(textToolbarState);
    }

    public static /* synthetic */ Object I(TextFieldSelectionState textFieldSelectionState, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return textFieldSelectionState.H(z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long J0(TextFieldCharSequence textFieldCharSequence, int i3, int i4, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3, boolean z4) {
        HapticFeedback hapticFeedback;
        TextRange textRangeB = TextRange.b(textFieldCharSequence.g());
        long jR = textRangeB.r();
        if (z4 || (!z3 && TextRange.h(jR))) {
            textRangeB = null;
        }
        long jG0 = g0(i3, i4, textRangeB, z2, selectionAdjustment);
        if (!TextRange.g(jG0, textFieldCharSequence.g())) {
            boolean z5 = TextRange.m(jG0) != TextRange.m(textFieldCharSequence.g()) && TextRange.g(TextRangeKt.b(TextRange.i(jG0), TextRange.n(jG0)), textFieldCharSequence.g());
            if (m0() && !z5 && (hapticFeedback = this.f10761h) != null) {
                hapticFeedback.a(HapticFeedbackType.f26611b.i());
            }
        }
        return jG0;
    }

    static /* synthetic */ long K0(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i3, int i4, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3, boolean z4, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            z3 = false;
        }
        if ((i5 & 64) != 0) {
            z4 = false;
        }
        return textFieldSelectionState.J0(textFieldCharSequence, i3, i4, z2, selectionAdjustment, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M(androidx.compose.ui.input.pointer.PointerInputScope r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1) r0
            int r1 = r0.f10832g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f10832g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.f10830d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f10832g
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3c
            java.lang.Object r9 = r6.f10829c
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r0 = r6.f10828b
            r1 = r0
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r0 = r6.f10827a
            r2 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r2 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r2
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L39
            goto L87
        L39:
            r0 = move-exception
            r10 = r0
            goto L93
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            kotlin.ResultKt.b(r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.f25596b
            long r3 = r1.b()
            r10.f140143a = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            long r3 = r1.b()
            r7.f140143a = r3
            r1 = r2
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r2 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch: java.lang.Throwable -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L8d
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r3 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch: java.lang.Throwable -> L8d
            r3.<init>()     // Catch: java.lang.Throwable -> L8d
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r4 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch: java.lang.Throwable -> L8d
            r4.<init>()     // Catch: java.lang.Throwable -> L8d
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch: java.lang.Throwable -> L8d
            r5.<init>()     // Catch: java.lang.Throwable -> L8d
            r6.f10827a = r8     // Catch: java.lang.Throwable -> L8d
            r6.f10828b = r10     // Catch: java.lang.Throwable -> L8d
            r6.f10829c = r7     // Catch: java.lang.Throwable -> L8d
            r6.f10832g = r1     // Catch: java.lang.Throwable -> L8d
            r1 = r9
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L8d
            if (r9 != r0) goto L84
            return r0
        L84:
            r2 = r8
            r1 = r10
            r9 = r7
        L87:
            N(r1, r9, r2)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L8d:
            r0 = move-exception
            r9 = r0
            r2 = r8
            r1 = r10
            r10 = r9
            r9 = r7
        L93:
            N(r1, r9, r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.M(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if ((longRef.f140143a & 9223372034707292159L) != 9205357640488583168L) {
            Offset.Companion companion = Offset.f25596b;
            longRef.f140143a = companion.b();
            longRef2.f140143a = companion.b();
            textFieldSelectionState.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(androidx.compose.ui.input.pointer.PointerInputScope r15, final boolean r16, kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.O(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if ((longRef.f140143a & 9223372034707292159L) != 9205357640488583168L) {
            textFieldSelectionState.G();
            Offset.Companion companion = Offset.f25596b;
            longRef.f140143a = companion.b();
            longRef2.f140143a = companion.c();
            textFieldSelectionState.f10774u = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect T() {
        float fIntBitsToFloat;
        Rect rectE;
        Rect rectE2;
        TextFieldCharSequence textFieldCharSequenceO = this.f10754a.o();
        if (TextRange.h(textFieldCharSequenceO.g())) {
            Rect rectW = W();
            LayoutCoordinates layoutCoordinatesH0 = h0();
            return RectKt.c(layoutCoordinatesH0 != null ? layoutCoordinatesH0.x0(rectW.t()) : Offset.f25596b.c(), rectW.q());
        }
        LayoutCoordinates layoutCoordinatesH02 = h0();
        long jX0 = layoutCoordinatesH02 != null ? layoutCoordinatesH02.x0(b0(true)) : Offset.f25596b.c();
        LayoutCoordinates layoutCoordinatesH03 = h0();
        long jX02 = layoutCoordinatesH03 != null ? layoutCoordinatesH03.x0(b0(false)) : Offset.f25596b.c();
        LayoutCoordinates layoutCoordinatesH04 = h0();
        float fIntBitsToFloat2 = 0.0f;
        if (layoutCoordinatesH04 != null) {
            TextLayoutResult textLayoutResultF = this.f10755b.f();
            fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinatesH04.x0(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits((textLayoutResultF == null || (rectE2 = textLayoutResultF.e(TextRange.n(textFieldCharSequenceO.g()))) == null) ? 0.0f : rectE2.r())) & 4294967295L))) & 4294967295L));
        } else {
            fIntBitsToFloat = 0.0f;
        }
        LayoutCoordinates layoutCoordinatesH05 = h0();
        if (layoutCoordinatesH05 != null) {
            TextLayoutResult textLayoutResultF2 = this.f10755b.f();
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutCoordinatesH05.x0(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits((textLayoutResultF2 == null || (rectE = textLayoutResultF2.e(TextRange.i(textFieldCharSequenceO.g()))) == null) ? 0.0f : rectE.r())) & 4294967295L))) & 4294967295L));
        }
        int i3 = (int) (jX0 >> 32);
        int i4 = (int) (jX02 >> 32);
        return new Rect(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.max(Float.intBitsToFloat((int) (jX0 & 4294967295L)), Float.intBitsToFloat((int) (jX02 & 4294967295L))));
    }

    private final long U() {
        LayoutCoordinates layoutCoordinatesH0 = h0();
        return layoutCoordinatesH0 != null ? LayoutCoordinatesKt.g(layoutCoordinatesH0) : Offset.f25596b.b();
    }

    private final boolean Z() {
        return this.f10757d && !this.f10758e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b0(boolean z2) {
        TextLayoutResult textLayoutResultF = this.f10755b.f();
        if (textLayoutResultF == null) {
            return Offset.f25596b.c();
        }
        long jG = this.f10754a.o().g();
        return TextSelectionDelegateKt.b(textLayoutResultF, z2 ? TextRange.n(jG) : TextRange.i(jG), z2, TextRange.m(jG));
    }

    private final long c0() {
        return ((Offset) this.f10768o.getValue()).u();
    }

    private final boolean e0() {
        return ((Boolean) this.f10771r.getValue()).booleanValue();
    }

    private final long f0() {
        return ((Offset) this.f10767n.getValue()).u();
    }

    private final long g0(int i3, int i4, TextRange textRange, boolean z2, SelectionAdjustment selectionAdjustment) {
        TextLayoutResult textLayoutResultF = this.f10755b.f();
        if (textLayoutResultF == null) {
            return TextRange.f28921b.a();
        }
        if (textRange == null && Intrinsics.areEqual(selectionAdjustment, SelectionAdjustment.f11264a.k())) {
            return TextRangeKt.b(i3, i4);
        }
        SelectionLayout selectionLayoutC = SelectionLayoutKt.c(textLayoutResultF, i3, i4, this.f10774u, textRange != null ? textRange.r() : TextRange.f28921b.a(), textRange == null, z2);
        if (textRange != null && !selectionLayoutC.i(this.f10773t)) {
            return textRange.r();
        }
        long jG = selectionAdjustment.a(selectionLayoutC).g();
        this.f10773t = selectionLayoutC;
        this.f10774u = z2 ? i3 : i4;
        return jG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates h0() {
        LayoutCoordinates layoutCoordinatesJ = this.f10755b.j();
        if (layoutCoordinatesJ == null || !layoutCoordinatesJ.m()) {
            return null;
        }
        return layoutCoordinatesJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextToolbarState i0() {
        return (TextToolbarState) this.f10772s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        TextToolbarHandler textToolbarHandler = this.f10762i;
        if (textToolbarHandler != null) {
            textToolbarHandler.b();
        }
    }

    private final boolean k0() {
        Rect rectI;
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            long j3 = W().j();
            companion.m(snapshotD, snapshotE, function1G);
            LayoutCoordinates layoutCoordinatesH0 = h0();
            if (layoutCoordinatesH0 == null || (rectI = SelectionManagerKt.i(layoutCoordinatesH0)) == null) {
                return false;
            }
            return SelectionManagerKt.d(rectI, j3);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        D0(U());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o0(Continuation continuation) {
        Object objCollect = FlowKt.x(FlowKt.v(SnapshotStateKt.q(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TextFieldCharSequence invoke() {
                return this.f10893a.f10754a.o();
            }
        }), TextFieldSelectionState$observeTextChanges$3.f10894a), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation continuation2) {
                this.f10895a.C0(false);
                this.f10895a.L0(TextToolbarState.f10960a);
                return Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p0(Continuation continuation) {
        Object objCollect = SnapshotStateKt.q(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Rect invoke() {
                Rect rectX;
                boolean zH = TextRange.h(this.f10896a.f10754a.o().g());
                if (((!zH || this.f10896a.i0() != TextToolbarState.f10961b) && (zH || this.f10896a.i0() != TextToolbarState.f10962c)) || this.f10896a.Y() != null || !this.f10896a.m0()) {
                    return Rect.f25601e.a();
                }
                LayoutCoordinates layoutCoordinatesH0 = this.f10896a.h0();
                Rect rectI = layoutCoordinatesH0 != null ? SelectionManagerKt.i(layoutCoordinatesH0) : null;
                if (rectI == null) {
                    return Rect.f25601e.a();
                }
                LayoutCoordinates layoutCoordinatesH02 = this.f10896a.h0();
                Offset offsetD = layoutCoordinatesH02 != null ? Offset.d(layoutCoordinatesH02.x0(rectI.t())) : null;
                Intrinsics.checkNotNull(offsetD);
                Rect rectC = RectKt.c(offsetD.u(), rectI.q());
                Rect rectT = this.f10896a.T();
                Rect rect = rectC.z(rectT) ? rectT : null;
                return (rect == null || (rectX = rect.x(rectC)) == null) ? Rect.f25601e.a() : rectX;
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Rect rect, Continuation continuation2) {
                if (Intrinsics.areEqual(rect, Rect.f25601e.a())) {
                    this.f10897a.j0();
                } else {
                    TextToolbarHandler textToolbarHandler = this.f10897a.f10762i;
                    if (textToolbarHandler != null) {
                        Object objA = textToolbarHandler.a(this.f10897a, rect, continuation2);
                        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
                    }
                }
                return Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r0(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1) r0
            int r1 = r0.f10906d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10906d = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f10904b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10906d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f10903a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.b(r9)
            goto L48
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L35:
            kotlin.ResultKt.b(r9)
            androidx.compose.ui.platform.Clipboard r9 = r8.f10763j
            if (r9 == 0) goto L62
            r0.f10903a = r8
            r0.f10906d = r3
            java.lang.Object r9 = r9.a(r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            r0 = r8
        L48:
            androidx.compose.ui.platform.ClipEntry r9 = (androidx.compose.ui.platform.ClipEntry) r9
            if (r9 == 0) goto L62
            java.lang.String r2 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.e(r9)
            if (r2 != 0) goto L53
            goto L62
        L53:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r1 = r0.f10754a
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r4 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.f10978c
            r6 = 10
            r7 = 0
            r3 = 0
            r5 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.x(r1, r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L62:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.r0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0(long j3) {
        int iX;
        int iN;
        TextLayoutResult textLayoutResultF = this.f10755b.f();
        if (textLayoutResultF == null || (iX = textLayoutResultF.x(j3)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.f10754a;
        long jQ = transformedTextFieldState.q(iX);
        long jS = transformedTextFieldState.s(jQ);
        int i3 = WhenMappings.f10799a[((TextRange.h(jQ) && TextRange.h(jS)) ? IndexTransformationType.f10350a : (TextRange.h(jQ) || TextRange.h(jS)) ? (!TextRange.h(jQ) || TextRange.h(jS)) ? IndexTransformationType.f10353d : IndexTransformationType.f10351b : IndexTransformationType.f10352c).ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity = null;
        if (i3 == 1 || i3 == 2) {
            iN = TextRange.n(jQ);
        } else if (i3 == 3) {
            selectionWedgeAffinity = MathUtilsKt.b(j3, textLayoutResultF.e(TextRange.n(jS)), textLayoutResultF.e(TextRange.i(jS))) < 0 ? new SelectionWedgeAffinity(WedgeAffinity.f10685a) : new SelectionWedgeAffinity(WedgeAffinity.f10686b);
            iN = TextRange.n(jQ);
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            iN = MathUtilsKt.b(j3, textLayoutResultF.e(TextRange.n(jS)), textLayoutResultF.e(TextRange.i(jS))) < 0 ? TextRange.n(jQ) : TextRange.i(jQ);
        }
        long jA = TextRangeKt.a(iN);
        if (TextRange.g(jA, this.f10754a.n().g()) && (selectionWedgeAffinity == null || Intrinsics.areEqual(selectionWedgeAffinity, this.f10754a.m()))) {
            return false;
        }
        this.f10754a.C(jA);
        if (selectionWedgeAffinity != null) {
            this.f10754a.D(selectionWedgeAffinity);
        }
        return true;
    }

    private final void z0(long j3) {
        this.f10768o.setValue(Offset.d(j3));
    }

    public final void A() {
        Function0 function0 = this.f10765l;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void A0(Function0 function0) {
        this.f10766m = function0;
    }

    public final boolean B() {
        return Z() && TextRange.h(this.f10754a.o().g());
    }

    public final void B0(Function0 function0) {
        this.f10765l = function0;
    }

    public final boolean C() {
        return (TextRange.h(this.f10754a.o().g()) || this.f10760g) ? false : true;
    }

    public final boolean D() {
        return (TextRange.h(this.f10754a.o().g()) || !Z() || this.f10760g) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r8 == r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1) r0
            int r1 = r0.f10803d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10803d = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f10801b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10803d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r8)
            goto L91
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            java.lang.Object r2 = r0.f10800a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r2 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r2
            kotlin.ResultKt.b(r8)
            goto L5c
        L3e:
            kotlin.ResultKt.b(r8)
            boolean r8 = r7.Z()
            if (r8 != 0) goto L4c
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r8
        L4c:
            androidx.compose.ui.platform.Clipboard r8 = r7.f10763j
            if (r8 == 0) goto L6a
            r0.f10800a = r7
            r0.f10803d = r5
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L5b
            goto L90
        L5b:
            r2 = r7
        L5c:
            androidx.compose.ui.platform.ClipEntry r8 = (androidx.compose.ui.platform.ClipEntry) r8
            if (r8 == 0) goto L68
            boolean r8 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.c(r8)
            if (r8 != r5) goto L68
            r8 = r5
            goto L6c
        L68:
            r8 = r4
            goto L6c
        L6a:
            r2 = r7
            goto L68
        L6c:
            if (r8 == 0) goto L73
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r8
        L73:
            kotlin.jvm.functions.Function0 r8 = r2.f10766m
            r6 = 0
            if (r8 == 0) goto L7f
            java.lang.Object r8 = r8.invoke()
            androidx.compose.foundation.content.internal.ReceiveContentConfiguration r8 = (androidx.compose.foundation.content.internal.ReceiveContentConfiguration) r8
            goto L80
        L7f:
            r8 = r6
        L80:
            if (r8 == 0) goto L97
            androidx.compose.ui.platform.Clipboard r8 = r2.f10763j
            if (r8 == 0) goto L94
            r0.f10800a = r6
            r0.f10803d = r3
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L91
        L90:
            return r1
        L91:
            r6 = r8
            androidx.compose.ui.platform.ClipEntry r6 = (androidx.compose.ui.platform.ClipEntry) r6
        L94:
            if (r6 == 0) goto L97
            r4 = r5
        L97:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.E(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean F() {
        return TextRange.j(this.f10754a.o().g()) != this.f10754a.o().length();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F0(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) r0
            int r1 = r0.f10929d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10929d = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f10927b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10929d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.f10926a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2e
            goto L4d
        L2e:
            r6 = move-exception
            goto L60
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.b(r6)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2 r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2     // Catch: java.lang.Throwable -> L5e
            r2 = 0
            r6.<init>(r5, r2)     // Catch: java.lang.Throwable -> L5e
            r0.f10926a = r5     // Catch: java.lang.Throwable -> L5e
            r0.f10929d = r4     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.f(r6, r0)     // Catch: java.lang.Throwable -> L5e
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
        L4d:
            r0.C0(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r6 = r0.i0()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.f10960a
            if (r6 == r1) goto L5b
            r0.j0()
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L5e:
            r6 = move-exception
            r0 = r5
        L60:
            r0.C0(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = r0.i0()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.f10960a
            if (r1 == r2) goto L6e
            r0.j0()
        L6e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.F0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void G() {
        w0(null);
        Offset.Companion companion = Offset.f25596b;
        z0(companion.b());
        D0(companion.b());
    }

    public final Object G0(PointerInputScope pointerInputScope, Function0 function0, Continuation continuation) {
        Object objN = SelectionGesturesKt.n(pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(boolean r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1) r0
            int r1 = r0.f10808f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10808f = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f10806c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10808f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r7 = r0.f10805b
            java.lang.Object r0 = r0.f10804a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.b(r8)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.f10754a
            androidx.compose.foundation.text.input.TextFieldCharSequence r8 = r8.o()
            long r4 = r8.g()
            boolean r2 = androidx.compose.ui.text.TextRange.h(r4)
            if (r2 == 0) goto L4d
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L4d:
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            java.lang.CharSequence r8 = androidx.compose.foundation.text.input.TextFieldCharSequenceKt.a(r8)
            java.lang.String r8 = r8.toString()
            r4 = 2
            r5 = 0
            r2.<init>(r8, r5, r4, r5)
            androidx.compose.ui.platform.Clipboard r8 = r6.f10763j
            if (r8 == 0) goto L71
            androidx.compose.ui.platform.ClipEntry r2 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.f(r2)
            r0.f10804a = r6
            r0.f10805b = r7
            r0.f10808f = r3
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L71
            return r1
        L71:
            r0 = r6
        L72:
            if (r7 != 0) goto L77
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L77:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r7 = r0.f10754a
            r7.h()
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.H(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void H0(HapticFeedback hapticFeedback, Clipboard clipboard, TextToolbarHandler textToolbarHandler, Density density, boolean z2, boolean z3, boolean z4) {
        if (!z2) {
            j0();
        }
        this.f10761h = hapticFeedback;
        this.f10763j = clipboard;
        this.f10762i = textToolbarHandler;
        this.f10756c = density;
        this.f10757d = z2;
        this.f10758e = z3;
        this.f10760g = z4;
    }

    public final void I0(Handle handle, long j3) {
        w0(handle);
        z0(j3);
    }

    public final Object J(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object K(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1) r0
            int r1 = r0.f10826d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10826d = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f10824b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10826d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f10823a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.b(r7)
            goto L6e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r7 = r6.f10754a
            androidx.compose.foundation.text.input.TextFieldCharSequence r7 = r7.o()
            long r4 = r7.g()
            boolean r2 = androidx.compose.ui.text.TextRange.h(r4)
            if (r2 == 0) goto L4b
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L4b:
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            java.lang.CharSequence r7 = androidx.compose.foundation.text.input.TextFieldCharSequenceKt.a(r7)
            java.lang.String r7 = r7.toString()
            r4 = 2
            r5 = 0
            r2.<init>(r7, r5, r4, r5)
            androidx.compose.ui.platform.Clipboard r7 = r6.f10763j
            if (r7 == 0) goto L6d
            androidx.compose.ui.platform.ClipEntry r2 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.f(r2)
            r0.f10823a = r6
            r0.f10826d = r3
            java.lang.Object r7 = r7.b(r2, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            r0 = r6
        L6e:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r7 = r0.f10754a
            r7.k()
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.K(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void L() {
        if (!TextRange.h(this.f10754a.o().g())) {
            this.f10754a.g();
        }
        C0(false);
        L0(TextToolbarState.f10960a);
    }

    public final void L0(TextToolbarState textToolbarState) {
        E0(textToolbarState);
    }

    public final Object Q(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final Function0 function0, final Function0 function02, Continuation continuation) {
        Object objK = TapGestureDetectorKt.k(pointerInputScope, new TextFieldSelectionState$detectTextFieldTapGestures$2(mutableInteractionSource, this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(long j3) {
                TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.f10757d && this.l0()) {
                    if (!this.f10758e) {
                        function02.invoke();
                        if (this.f10754a.o().length() > 0) {
                            this.C0(true);
                        }
                    }
                    this.L0(TextToolbarState.f10960a);
                    long jB = this.f10755b.b(j3);
                    TextFieldSelectionState textFieldSelectionState = this;
                    textFieldSelectionState.s0(TextLayoutStateKt.b(textFieldSelectionState.f10755b, jB));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, continuation);
        return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
    }

    public final Object R(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objC0 = pointerInputScope.c0(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return objC0 == IntrinsicsKt.f() ? objC0 : Unit.f139807a;
    }

    public final void S() {
        j0();
        this.f10763j = null;
        this.f10761h = null;
    }

    public final TextFieldHandleState V(boolean z2) {
        TextFieldCharSequence textFieldCharSequenceO = this.f10754a.o();
        boolean zE0 = e0();
        boolean z3 = X() == InputType.f10776a;
        Handle handleY = Y();
        if (zE0 && z3 && TextRange.h(textFieldCharSequenceO.g()) && textFieldCharSequenceO.i() && textFieldCharSequenceO.length() > 0 && (handleY == Handle.f9697a || k0())) {
            return new TextFieldHandleState(true, z2 ? W().j() : Offset.f25596b.b(), 0.0f, ResolvedTextDirection.f29612a, false, null);
        }
        return TextFieldHandleState.f10714f.a();
    }

    public final Rect W() {
        TextLayoutResult textLayoutResultF = this.f10755b.f();
        if (textLayoutResultF == null) {
            return Rect.f25601e.a();
        }
        TextFieldCharSequence textFieldCharSequenceO = this.f10754a.o();
        if (!TextRange.h(textFieldCharSequenceO.g())) {
            return Rect.f25601e.a();
        }
        Rect rectE = textLayoutResultF.e(TextRange.n(textFieldCharSequenceO.g()));
        float fE = RangesKt.e((float) Math.floor(this.f10756c.M1(TextFieldCursor_androidKt.a())), 1.0f);
        float f3 = fE / 2;
        float fE2 = RangesKt.e(RangesKt.j(textLayoutResultF.l().d() == LayoutDirection.f30001a ? rectE.o() + (fE / 2) : rectE.p() - (fE / 2), ((int) (textLayoutResultF.B() >> 32)) - f3), f3);
        float fFloor = ((int) fE) % 2 == 1 ? ((float) Math.floor(fE2)) + 0.5f : (float) Math.rint(fE2);
        return new Rect(fFloor - f3, rectE.r(), fFloor + f3, rectE.i());
    }

    public final InputType X() {
        return (InputType) this.f10770q.getValue();
    }

    public final Handle Y() {
        return (Handle) this.f10769p.getValue();
    }

    public final long a0() {
        return (c0() & 9223372034707292159L) == 9205357640488583168L ? Offset.f25596b.b() : (f0() & 9223372034707292159L) == 9205357640488583168L ? TextLayoutStateKt.b(this.f10755b, c0()) : Offset.q(c0(), Offset.p(f0(), U()));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState d0(boolean r15, boolean r16) {
        /*
            r14 = this;
            if (r15 == 0) goto L5
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.f9698b
            goto L7
        L5:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.f9699c
        L7:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r14.f10755b
            androidx.compose.ui.text.TextLayoutResult r1 = r1.f()
            if (r1 != 0) goto L16
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r15 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.f10714f
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r15 = r15.a()
            return r15
        L16:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r2 = r14.f10754a
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r2.o()
            long r2 = r2.g()
            boolean r4 = androidx.compose.ui.text.TextRange.h(r2)
            if (r4 == 0) goto L2d
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r15 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.f10714f
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r15 = r15.a()
            return r15
        L2d:
            long r4 = r14.b0(r15)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r6 = r14.X()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r7 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType.f10776a
            r8 = 1
            r9 = 0
            if (r6 != r7) goto L57
            androidx.compose.foundation.text.Handle r6 = r14.Y()
            if (r6 == r0) goto L55
            androidx.compose.ui.layout.LayoutCoordinates r0 = r14.h0()
            if (r0 == 0) goto L52
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.i(r0)
            if (r0 == 0) goto L52
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.d(r0, r4)
            goto L53
        L52:
            r0 = r9
        L53:
            if (r0 == 0) goto L57
        L55:
            r0 = r8
            goto L58
        L57:
            r0 = r9
        L58:
            if (r0 != 0) goto L61
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r15 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.f10714f
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r15 = r15.a()
            return r15
        L61:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = r14.f10754a
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.o()
            boolean r0 = r0.i()
            if (r0 != 0) goto L74
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r15 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.f10714f
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r15 = r15.a()
            return r15
        L74:
            if (r15 == 0) goto L7b
            int r0 = androidx.compose.ui.text.TextRange.n(r2)
            goto L84
        L7b:
            int r0 = androidx.compose.ui.text.TextRange.i(r2)
            int r0 = r0 - r8
            int r0 = java.lang.Math.max(r0, r9)
        L84:
            androidx.compose.ui.text.style.ResolvedTextDirection r11 = r1.c(r0)
            boolean r12 = androidx.compose.ui.text.TextRange.m(r2)
            if (r16 == 0) goto La0
            androidx.compose.ui.layout.LayoutCoordinates r0 = r14.h0()
            if (r0 == 0) goto L9e
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.i(r0)
            if (r0 == 0) goto L9e
            long r4 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.a(r4, r0)
        L9e:
            r8 = r4
            goto La7
        La0:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.f25596b
            long r4 = r0.b()
            goto L9e
        La7:
            if (r15 == 0) goto Lae
            int r15 = androidx.compose.ui.text.TextRange.n(r2)
            goto Lb2
        Lae:
            int r15 = androidx.compose.ui.text.TextRange.i(r2)
        Lb2:
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState
            float r10 = androidx.compose.foundation.text.TextLayoutHelperKt.b(r1, r15)
            r13 = 0
            r7 = 1
            r6.<init>(r7, r8, r10, r11, r12, r13)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.d0(boolean, boolean):androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState");
    }

    public final boolean l0() {
        return this.f10759f;
    }

    public final boolean m0() {
        return ((Boolean) this.f10764k.getValue()).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
    
        if (r4.r0(r0) == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r0(r0) == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q0(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1) r0
            int r1 = r0.f10902f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10902f = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f10900c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10902f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r13)
            goto Lb9
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L38:
            java.lang.Object r2 = r0.f10899b
            androidx.compose.foundation.content.internal.ReceiveContentConfiguration r2 = (androidx.compose.foundation.content.internal.ReceiveContentConfiguration) r2
            java.lang.Object r4 = r0.f10898a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r4 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r4
            kotlin.ResultKt.b(r13)
            goto L6c
        L44:
            kotlin.ResultKt.b(r13)
            goto Lc5
        L49:
            kotlin.ResultKt.b(r13)
            kotlin.jvm.functions.Function0 r13 = r12.f10766m
            if (r13 == 0) goto Lbc
            java.lang.Object r13 = r13.invoke()
            r2 = r13
            androidx.compose.foundation.content.internal.ReceiveContentConfiguration r2 = (androidx.compose.foundation.content.internal.ReceiveContentConfiguration) r2
            if (r2 != 0) goto L5a
            goto Lbc
        L5a:
            androidx.compose.ui.platform.Clipboard r13 = r12.f10763j
            if (r13 == 0) goto Laa
            r0.f10898a = r12
            r0.f10899b = r2
            r0.f10902f = r4
            java.lang.Object r13 = r13.a(r0)
            if (r13 != r1) goto L6b
            goto Lc4
        L6b:
            r4 = r12
        L6c:
            r6 = r13
            androidx.compose.ui.platform.ClipEntry r6 = (androidx.compose.ui.platform.ClipEntry) r6
            if (r6 != 0) goto L72
            goto Lab
        L72:
            androidx.compose.ui.platform.ClipMetadata r7 = r6.b()
            androidx.compose.foundation.content.ReceiveContentListener r13 = r2.a()
            androidx.compose.foundation.content.TransferableContent$Source$Companion r0 = androidx.compose.foundation.content.TransferableContent.Source.f5205b
            int r8 = r0.a()
            androidx.compose.foundation.content.TransferableContent r5 = new androidx.compose.foundation.content.TransferableContent
            r10 = 8
            r11 = 0
            r9 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            androidx.compose.foundation.content.TransferableContent r13 = r13.e(r5)
            if (r13 == 0) goto La7
            androidx.compose.ui.platform.ClipEntry r13 = r13.a()
            if (r13 == 0) goto La7
            java.lang.String r6 = androidx.compose.foundation.content.TransferableContent_androidKt.a(r13)
            if (r6 == 0) goto La7
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r5 = r4.f10754a
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r8 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.f10978c
            r10 = 10
            r11 = 0
            r7 = 0
            r9 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.x(r5, r6, r7, r8, r9, r10, r11)
        La7:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        Laa:
            r4 = r12
        Lab:
            r13 = 0
            r0.f10898a = r13
            r0.f10899b = r13
            r0.f10902f = r3
            java.lang.Object r13 = r4.r0(r0)
            if (r13 != r1) goto Lb9
            goto Lc4
        Lb9:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        Lbc:
            r0.f10902f = r5
            java.lang.Object r13 = r12.r0(r0)
            if (r13 != r1) goto Lc5
        Lc4:
            return r1
        Lc5:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.q0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void t0() {
        this.f10754a.A();
    }

    public final Object u0(PointerInputScope pointerInputScope, boolean z2, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final void v0(InputType inputType) {
        this.f10770q.setValue(inputType);
    }

    public final void w0(Handle handle) {
        this.f10769p.setValue(handle);
    }

    public final void x0(boolean z2) {
        this.f10759f = z2;
    }

    public final void y0(boolean z2) {
        this.f10764k.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class TextFieldTextDragObserver implements TextDragObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function0 f10790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10791b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f10792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f10793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handle f10794e;

        public TextFieldTextDragObserver(Function0 function0) {
            this.f10790a = function0;
            Offset.Companion companion = Offset.f25596b;
            this.f10792c = companion.b();
            this.f10793d = companion.c();
            this.f10794e = Handle.f9699c;
        }

        private final void e() {
            if ((this.f10792c & 9223372034707292159L) != 9205357640488583168L) {
                TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStop";
                    }
                });
                TextFieldSelectionState.this.G();
                this.f10791b = -1;
                Offset.Companion companion = Offset.f25596b;
                this.f10792c = companion.b();
                this.f10793d = companion.c();
                TextFieldSelectionState.this.f10774u = -1;
                TextFieldSelectionState.this.v0(InputType.f10776a);
                this.f10790a.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void b(final long j3) {
            if (TextFieldSelectionState.this.f10757d) {
                TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onStart$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStart after longPress at " + ((Object) Offset.s(j3));
                    }
                });
                TextFieldSelectionState.this.I0(this.f10794e, j3);
                TextFieldSelectionState.this.C0(false);
                TextFieldSelectionState.this.v0(InputType.f10777b);
                this.f10792c = j3;
                this.f10793d = Offset.f25596b.c();
                TextFieldSelectionState.this.f10774u = -1;
                if (TextFieldSelectionState.this.f10755b.f() == null) {
                    return;
                }
                if (TextFieldSelectionState.this.f10755b.k(j3)) {
                    if (TextFieldSelectionState.this.f10754a.o().length() == 0) {
                        return;
                    }
                    int i3 = TextLayoutState.i(TextFieldSelectionState.this.f10755b, j3, false, 2, null);
                    long jK0 = TextFieldSelectionState.K0(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.f10754a.o(), TextRange.f28921b.a(), null, null, null, 28, null), i3, i3, false, SelectionAdjustment.f11264a.o(), false, false, 96, null);
                    TextFieldSelectionState.this.f10754a.B(jK0);
                    TextFieldSelectionState.this.L0(TextToolbarState.f10962c);
                    this.f10791b = TextRange.n(jK0);
                    return;
                }
                int i4 = TextLayoutState.i(TextFieldSelectionState.this.f10755b, j3, false, 2, null);
                HapticFeedback hapticFeedback = TextFieldSelectionState.this.f10761h;
                if (hapticFeedback != null) {
                    hapticFeedback.a(HapticFeedbackType.f26611b.i());
                }
                TextFieldSelectionState.this.f10754a.t(i4);
                TextFieldSelectionState.this.C0(true);
                TextFieldSelectionState.this.L0(TextToolbarState.f10961b);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void d(long j3) {
            int iIntValue;
            int iH;
            SelectionAdjustment selectionAdjustmentO;
            if (!TextFieldSelectionState.this.f10757d || TextFieldSelectionState.this.f10755b.f() == null || TextFieldSelectionState.this.f10754a.o().length() == 0) {
                return;
            }
            long jQ = Offset.q(this.f10793d, j3);
            this.f10793d = jQ;
            final long jQ2 = Offset.q(this.f10792c, jQ);
            TextFieldSelectionStateKt.c(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Touch.onDrag at " + ((Object) Offset.s(jQ2));
                }
            });
            if (this.f10791b >= 0 || TextFieldSelectionState.this.f10755b.k(jQ2)) {
                Integer numValueOf = Integer.valueOf(this.f10791b);
                if (numValueOf.intValue() < 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.f10755b.h(this.f10792c, false);
                iH = TextFieldSelectionState.this.f10755b.h(jQ2, false);
                if (this.f10791b < 0 && iIntValue == iH) {
                    return;
                }
                selectionAdjustmentO = SelectionAdjustment.f11264a.o();
                TextFieldSelectionState.this.L0(TextToolbarState.f10962c);
            } else {
                iIntValue = TextLayoutState.i(TextFieldSelectionState.this.f10755b, this.f10792c, false, 2, null);
                iH = TextLayoutState.i(TextFieldSelectionState.this.f10755b, jQ2, false, 2, null);
                selectionAdjustmentO = iIntValue == iH ? SelectionAdjustment.f11264a.m() : SelectionAdjustment.f11264a.o();
            }
            int i3 = iIntValue;
            int i4 = iH;
            SelectionAdjustment selectionAdjustment = selectionAdjustmentO;
            long jG = TextFieldSelectionState.this.f10754a.o().g();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jK0 = TextFieldSelectionState.K0(textFieldSelectionState, textFieldSelectionState.f10754a.o(), i3, i4, false, selectionAdjustment, false, false, 64, null);
            if (this.f10791b == -1 && !TextRange.h(jK0)) {
                this.f10791b = TextRange.n(jK0);
            }
            if (TextRange.m(jK0)) {
                jK0 = TextFieldSelectionStateKt.d(jK0);
            }
            if (!TextRange.g(jK0, jG)) {
                Handle handle = (TextRange.n(jK0) == TextRange.n(jG) || TextRange.i(jK0) != TextRange.i(jG)) ? ((TextRange.n(jK0) != TextRange.n(jG) || TextRange.i(jK0) == TextRange.i(jG)) && ((float) (TextRange.n(jK0) + TextRange.i(jK0))) / 2.0f <= ((float) (TextRange.n(jG) + TextRange.i(jG))) / 2.0f) ? Handle.f9698b : Handle.f9699c : Handle.f9698b;
                this.f10794e = handle;
            }
            if (TextRange.h(jG) || !TextRange.h(jK0)) {
                TextFieldSelectionState.this.f10754a.B(jK0);
            }
            TextFieldSelectionState.this.I0(this.f10794e, jQ2);
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            e();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            e();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void c() {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void a(long j3) {
        }
    }
}
