package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TransformedTextFieldState {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Companion f10663h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldState f10664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputTransformation f10665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CodepointTransformation f10666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OutputTransformation f10667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final State f10668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final State f10669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f10670g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10671a;

            static {
                int[] iArr = new int[WedgeAffinity.values().length];
                try {
                    iArr[WedgeAffinity.f10685a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WedgeAffinity.f10686b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f10671a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TransformedText e(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, null, null, offsetMappingCalculator, 6, null);
            outputTransformation.a(textFieldBuffer);
            TextRange textRangeB = null;
            if (textFieldBuffer.f().b() == 0) {
                return null;
            }
            long jH = h(textFieldCharSequence.g(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange textRangeD = textFieldCharSequence.d();
            if (textRangeD != null) {
                textRangeB = TextRange.b(TransformedTextFieldState.f10663h.h(textRangeD.r(), offsetMappingCalculator, selectionWedgeAffinity));
            }
            return new TransformedText(TextFieldBuffer.A(textFieldBuffer, jH, textRangeB, null, 4, null), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TransformedText f(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence charSequenceA = CodepointTransformationKt.a(textFieldCharSequence, codepointTransformation, offsetMappingCalculator);
            TextRange textRangeB = null;
            if (charSequenceA == textFieldCharSequence) {
                return null;
            }
            long jH = h(textFieldCharSequence.g(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange textRangeD = textFieldCharSequence.d();
            if (textRangeD != null) {
                textRangeB = TextRange.b(TransformedTextFieldState.f10663h.h(textRangeD.r(), offsetMappingCalculator, selectionWedgeAffinity));
            }
            return new TransformedText(new TextFieldCharSequence(charSequenceA, jH, textRangeB, null, null, 24, null), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long g(long j3, OffsetMappingCalculator offsetMappingCalculator) {
            long jB = offsetMappingCalculator.b(TextRange.n(j3));
            long jB2 = TextRange.h(j3) ? jB : offsetMappingCalculator.b(TextRange.i(j3));
            int iMin = Math.min(TextRange.l(jB), TextRange.l(jB2));
            int iMax = Math.max(TextRange.k(jB), TextRange.k(jB2));
            return TextRange.m(j3) ? TextRangeKt.b(iMax, iMin) : TextRangeKt.b(iMin, iMax);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long h(long j3, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
            long jA;
            long jC = offsetMappingCalculator.c(TextRange.n(j3));
            long jC2 = TextRange.h(j3) ? jC : offsetMappingCalculator.c(TextRange.i(j3));
            WedgeAffinity wedgeAffinityC = null;
            WedgeAffinity wedgeAffinityD = selectionWedgeAffinity != null ? selectionWedgeAffinity.d() : null;
            if (TextRange.h(j3)) {
                wedgeAffinityC = wedgeAffinityD;
            } else if (selectionWedgeAffinity != null) {
                wedgeAffinityC = selectionWedgeAffinity.c();
            }
            if (wedgeAffinityD != null && !TextRange.h(jC)) {
                int i3 = WhenMappings.f10671a[wedgeAffinityD.ordinal()];
                if (i3 == 1) {
                    jC = TextRangeKt.a(TextRange.n(jC));
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jC = TextRangeKt.a(TextRange.i(jC));
                }
            }
            if (wedgeAffinityC != null && !TextRange.h(jC2)) {
                int i4 = WhenMappings.f10671a[wedgeAffinityC.ordinal()];
                if (i4 == 1) {
                    jA = TextRangeKt.a(TextRange.n(jC2));
                } else {
                    if (i4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jA = TextRangeKt.a(TextRange.i(jC2));
                }
                jC2 = jA;
            }
            int iMin = Math.min(TextRange.l(jC), TextRange.l(jC2));
            int iMax = Math.max(TextRange.k(jC), TextRange.k(jC2));
            return TextRange.m(j3) ? TextRangeKt.b(iMax, iMin) : TextRangeKt.b(iMin, iMax);
        }

        static /* synthetic */ long i(Companion companion, long j3, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.h(j3, offsetMappingCalculator, selectionWedgeAffinity);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class TransformedText {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextFieldCharSequence f10672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OffsetMappingCalculator f10673b;

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.f10672a = textFieldCharSequence;
            this.f10673b = offsetMappingCalculator;
        }

        public final OffsetMappingCalculator a() {
            return this.f10673b;
        }

        public final TextFieldCharSequence b() {
            return this.f10672a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) obj;
            return Intrinsics.areEqual(this.f10672a, transformedText.f10672a) && Intrinsics.areEqual(this.f10673b, transformedText.f10673b);
        }

        public int hashCode() {
            return (this.f10672a.hashCode() * 31) + this.f10673b.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + ((Object) this.f10672a) + ", offsetMapping=" + this.f10673b + ')';
        }
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, final CodepointTransformation codepointTransformation, final OutputTransformation outputTransformation) {
        this.f10664a = textFieldState;
        this.f10665b = inputTransformation;
        this.f10666c = codepointTransformation;
        this.f10667d = outputTransformation;
        this.f10668e = outputTransformation != null ? SnapshotStateKt.e(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$outputTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TransformedTextFieldState.TransformedText invoke() {
                return TransformedTextFieldState.f10663h.e(this.f10683a.f10664a.k(), outputTransformation, this.f10683a.m());
            }
        }) : null;
        this.f10669f = codepointTransformation != null ? SnapshotStateKt.e(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$codepointTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TransformedTextFieldState.TransformedText invoke() {
                TextFieldCharSequence textFieldCharSequenceK;
                TransformedTextFieldState.TransformedText transformedText;
                TransformedTextFieldState.Companion companion = TransformedTextFieldState.f10663h;
                State state = this.f10674a.f10668e;
                if (state == null || (transformedText = (TransformedTextFieldState.TransformedText) state.getValue()) == null || (textFieldCharSequenceK = transformedText.b()) == null) {
                    textFieldCharSequenceK = this.f10674a.f10664a.k();
                }
                return companion.f(textFieldCharSequenceK, codepointTransformation, this.f10674a.m());
            }
        }) : null;
        this.f10670g = SnapshotStateKt__SnapshotStateKt.e(new SelectionWedgeAffinity(WedgeAffinity.f10685a), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.e().b() <= 0 || !TextRange.h(textFieldBuffer.l())) {
            return;
        }
        D(new SelectionWedgeAffinity(WedgeAffinity.f10685a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TextFieldState.NotifyImeListener notifyImeListener, TransformedTextFieldState transformedTextFieldState, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z2) {
        TextFieldCharSequence textFieldCharSequenceB;
        TransformedText transformedTextE = f10663h.e(textFieldCharSequence, transformedTextFieldState.f10667d, transformedTextFieldState.m());
        if (transformedTextE != null && (textFieldCharSequenceB = transformedTextE.b()) != null) {
            textFieldCharSequence = textFieldCharSequenceB;
        }
        notifyImeListener.a(textFieldCharSequence, transformedTextFieldState.o(), z2);
    }

    public static /* synthetic */ void x(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z2, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        }
        if ((i3 & 8) != 0) {
            z3 = true;
        }
        transformedTextFieldState.w(charSequence, z2, textFieldEditUndoBehavior, z3);
    }

    public static /* synthetic */ void z(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j3, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        }
        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = textFieldEditUndoBehavior;
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        transformedTextFieldState.y(charSequence, j3, textFieldEditUndoBehavior2, z2);
    }

    public final void A() {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        TextFieldBufferKt.c(textFieldBufferF, 0, textFieldBufferF.j());
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void B(long j3) {
        C(r(j3));
    }

    public final void C(long j3) {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBufferKt.c(textFieldState.f(), TextRange.n(j3), TextRange.i(j3));
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void D(SelectionWedgeAffinity selectionWedgeAffinity) {
        this.f10670g.setValue(selectionWedgeAffinity);
    }

    public final void E() {
        this.f10664a.j().b();
    }

    public final void F(InputTransformation inputTransformation) {
        this.f10665b = inputTransformation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) obj;
        if (Intrinsics.areEqual(this.f10664a, transformedTextFieldState.f10664a) && Intrinsics.areEqual(this.f10666c, transformedTextFieldState.f10666c)) {
            return Intrinsics.areEqual(this.f10667d, transformedTextFieldState.f10667d);
        }
        return false;
    }

    public final void g() {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        TextFieldBufferKt.d(textFieldBufferF, TextRange.i(textFieldBufferF.l()), 0, 2, null);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void h() {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        TextFieldBufferKt.d(textFieldBufferF, TextRange.k(textFieldBufferF.l()), 0, 2, null);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public int hashCode() {
        int iHashCode = this.f10664a.hashCode() * 31;
        CodepointTransformation codepointTransformation = this.f10666c;
        int iHashCode2 = (iHashCode + (codepointTransformation != null ? codepointTransformation.hashCode() : 0)) * 31;
        OutputTransformation outputTransformation = this.f10667d;
        return iHashCode2 + (outputTransformation != null ? outputTransformation.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(final androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1) r0
            int r1 = r0.f10680f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10680f = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f10678c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f10680f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.f10677b
            androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener r5 = (androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener) r5
            java.lang.Object r5 = r0.f10676a
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r5 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState) r5
            kotlin.ResultKt.b(r6)
            goto L77
        L39:
            kotlin.ResultKt.b(r6)
            androidx.compose.foundation.text.input.OutputTransformation r6 = r4.f10667d
            if (r6 == 0) goto L46
            androidx.compose.foundation.text.input.internal.d1 r6 = new androidx.compose.foundation.text.input.internal.d1
            r6.<init>()
            r5 = r6
        L46:
            r0.f10676a = r4
            r0.f10677b = r5
            r0.f10680f = r3
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r6.<init>(r2, r3)
            r6.C()
            androidx.compose.foundation.text.input.TextFieldState r2 = e(r4)
            r2.c(r5)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1 r2 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
            r2.<init>()
            r6.m(r2)
            java.lang.Object r5 = r6.v()
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r5 != r6) goto L74
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L74:
            if (r5 != r1) goto L77
            return r1
        L77:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.i(androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void k() {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10978c;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        TextFieldBufferKt.b(textFieldBufferF, TextRange.l(textFieldBufferF.l()), TextRange.k(textFieldBufferF.l()));
        TextFieldBufferKt.d(textFieldBufferF, TextRange.l(textFieldBufferF.l()), 0, 2, null);
        G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final TextFieldCharSequence l() {
        TransformedText transformedText;
        TextFieldCharSequence textFieldCharSequenceB;
        State state = this.f10668e;
        return (state == null || (transformedText = (TransformedText) state.getValue()) == null || (textFieldCharSequenceB = transformedText.b()) == null) ? n() : textFieldCharSequenceB;
    }

    public final SelectionWedgeAffinity m() {
        return (SelectionWedgeAffinity) this.f10670g.getValue();
    }

    public final TextFieldCharSequence n() {
        return this.f10664a.k();
    }

    public final TextFieldCharSequence o() {
        TransformedText transformedText;
        TextFieldCharSequence textFieldCharSequenceB;
        State state = this.f10669f;
        return (state == null || (transformedText = (TransformedText) state.getValue()) == null || (textFieldCharSequenceB = transformedText.b()) == null) ? l() : textFieldCharSequenceB;
    }

    public final void p(int i3, long j3) {
        long jR = r(j3);
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        textFieldState.f().w(i3, TextRange.n(jR), TextRange.i(jR));
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final long q(int i3) {
        TransformedText transformedText;
        TransformedText transformedText2;
        State state = this.f10668e;
        OffsetMappingCalculator offsetMappingCalculatorA = null;
        OffsetMappingCalculator offsetMappingCalculatorA2 = (state == null || (transformedText2 = (TransformedText) state.getValue()) == null) ? null : transformedText2.a();
        State state2 = this.f10669f;
        if (state2 != null && (transformedText = (TransformedText) state2.getValue()) != null) {
            offsetMappingCalculatorA = transformedText.a();
        }
        long jB = offsetMappingCalculatorA != null ? offsetMappingCalculatorA.b(i3) : TextRangeKt.a(i3);
        return offsetMappingCalculatorA2 != null ? f10663h.g(jB, offsetMappingCalculatorA2) : jB;
    }

    public final long r(long j3) {
        TransformedText transformedText;
        TransformedText transformedText2;
        State state = this.f10668e;
        OffsetMappingCalculator offsetMappingCalculatorA = null;
        OffsetMappingCalculator offsetMappingCalculatorA2 = (state == null || (transformedText2 = (TransformedText) state.getValue()) == null) ? null : transformedText2.a();
        State state2 = this.f10669f;
        if (state2 != null && (transformedText = (TransformedText) state2.getValue()) != null) {
            offsetMappingCalculatorA = transformedText.a();
        }
        if (offsetMappingCalculatorA != null) {
            j3 = f10663h.g(j3, offsetMappingCalculatorA);
        }
        return offsetMappingCalculatorA2 != null ? f10663h.g(j3, offsetMappingCalculatorA2) : j3;
    }

    public final long s(long j3) {
        TransformedText transformedText;
        TransformedText transformedText2;
        State state = this.f10668e;
        OffsetMappingCalculator offsetMappingCalculatorA = null;
        OffsetMappingCalculator offsetMappingCalculatorA2 = (state == null || (transformedText2 = (TransformedText) state.getValue()) == null) ? null : transformedText2.a();
        State state2 = this.f10669f;
        if (state2 != null && (transformedText = (TransformedText) state2.getValue()) != null) {
            offsetMappingCalculatorA = transformedText.a();
        }
        if (offsetMappingCalculatorA2 != null) {
            j3 = Companion.i(f10663h, j3, offsetMappingCalculatorA2, null, 4, null);
        }
        return offsetMappingCalculatorA != null ? f10663h.h(j3, offsetMappingCalculatorA, m()) : j3;
    }

    public final void t(int i3) {
        B(TextRangeKt.a(i3));
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.f10664a + ", outputTransformation=" + this.f10667d + ", outputTransformedText=" + this.f10668e + ", codepointTransformation=" + this.f10666c + ", codepointTransformedText=" + this.f10669f + ", outputText=\"" + ((Object) l()) + "\", visualText=\"" + ((Object) o()) + "\")";
    }

    public final void u() {
        this.f10664a.j().a();
    }

    public final void v(CharSequence charSequence) {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        TextFieldBufferKt.b(textFieldBufferF, 0, textFieldBufferF.j());
        textFieldBufferF.append(charSequence.toString());
        G(textFieldBufferF);
        textFieldState.d(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void w(CharSequence charSequence, boolean z2, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z3) {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        if (z2) {
            textFieldBufferF.d();
        }
        long jL = textFieldBufferF.l();
        textFieldBufferF.p(TextRange.l(jL), TextRange.k(jL), charSequence);
        TextFieldBufferKt.d(textFieldBufferF, TextRange.l(jL) + charSequence.length(), 0, 2, null);
        G(textFieldBufferF);
        textFieldState.d(inputTransformation, z3, textFieldEditUndoBehavior);
    }

    public final void y(CharSequence charSequence, long j3, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z2) {
        TextFieldState textFieldState = this.f10664a;
        InputTransformation inputTransformation = this.f10665b;
        textFieldState.f().e().e();
        TextFieldBuffer textFieldBufferF = textFieldState.f();
        long jR = r(j3);
        textFieldBufferF.p(TextRange.l(jR), TextRange.k(jR), charSequence);
        TextFieldBufferKt.d(textFieldBufferF, TextRange.l(jR) + charSequence.length(), 0, 2, null);
        G(textFieldBufferF);
        textFieldState.d(inputTransformation, z2, textFieldEditUndoBehavior);
    }
}
