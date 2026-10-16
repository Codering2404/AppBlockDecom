package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
public final class TextFieldSelectionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UndoManager f11518a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LegacyTextFieldState f11521d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Function0 f11524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Clipboard f11525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CoroutineScope f11526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextToolbar f11527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HapticFeedback f11528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FocusRequester f11529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f11530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f11531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f11532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Integer f11533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f11534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final MutableState f11535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f11536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11537t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextFieldValue f11538u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SelectionLayout f11539v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TextDragObserver f11540w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MouseSelectionObserver f11541x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OffsetMapping f11519b = ValidatingOffsetMappingKt.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f11520c = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((TextFieldValue) obj);
            return Unit.f139807a;
        }

        public final void c(TextFieldValue textFieldValue) {
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f11522e = SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private VisualTransformation f11523f = VisualTransformation.f29459a.c();

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.f11518a = undoManager;
        Boolean bool = Boolean.TRUE;
        this.f11530m = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f11531n = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        Offset.Companion companion = Offset.f25596b;
        this.f11532o = companion.c();
        this.f11534q = companion.c();
        this.f11535r = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11536s = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11537t = -1;
        this.f11538u = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.f11540w = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private final void e() {
                this.f11569a.f0(null);
                this.f11569a.d0(null);
                this.f11569a.u0(true);
                this.f11569a.f11533p = null;
                boolean zH = TextRange.h(this.f11569a.U().h());
                this.f11569a.j0(zH ? HandleState.f9704c : HandleState.f9703b);
                LegacyTextFieldState legacyTextFieldStateP = this.f11569a.P();
                if (legacyTextFieldStateP != null) {
                    legacyTextFieldStateP.Q(!zH && TextFieldSelectionManagerKt.c(this.f11569a, true));
                }
                LegacyTextFieldState legacyTextFieldStateP2 = this.f11569a.P();
                if (legacyTextFieldStateP2 != null) {
                    legacyTextFieldStateP2.P(!zH && TextFieldSelectionManagerKt.c(this.f11569a, false));
                }
                LegacyTextFieldState legacyTextFieldStateP3 = this.f11569a.P();
                if (legacyTextFieldStateP3 == null) {
                    return;
                }
                legacyTextFieldStateP3.N(zH && TextFieldSelectionManagerKt.c(this.f11569a, true));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void b(long j3) {
                long j4;
                TextLayoutResultProxy textLayoutResultProxyL;
                TextLayoutResultProxy textLayoutResultProxyL2;
                if (this.f11569a.H() && this.f11569a.F() == null) {
                    this.f11569a.f0(Handle.f9699c);
                    this.f11569a.f11537t = -1;
                    this.f11569a.X();
                    LegacyTextFieldState legacyTextFieldStateP = this.f11569a.P();
                    if (legacyTextFieldStateP == null || (textLayoutResultProxyL2 = legacyTextFieldStateP.l()) == null || !textLayoutResultProxyL2.g(j3)) {
                        j4 = j3;
                        LegacyTextFieldState legacyTextFieldStateP2 = this.f11569a.P();
                        if (legacyTextFieldStateP2 != null && (textLayoutResultProxyL = legacyTextFieldStateP2.l()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = this.f11569a;
                            int iA = textFieldSelectionManager.N().a(TextLayoutResultProxy.e(textLayoutResultProxyL, j4, false, 2, null));
                            TextFieldValue textFieldValueS = textFieldSelectionManager.s(textFieldSelectionManager.U().f(), TextRangeKt.b(iA, iA));
                            textFieldSelectionManager.x(false);
                            HapticFeedback hapticFeedbackL = textFieldSelectionManager.L();
                            if (hapticFeedbackL != null) {
                                hapticFeedbackL.a(HapticFeedbackType.f26611b.i());
                            }
                            textFieldSelectionManager.O().invoke(textFieldValueS);
                        }
                    } else {
                        if (this.f11569a.U().i().length() == 0) {
                            return;
                        }
                        this.f11569a.x(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = this.f11569a;
                        j4 = j3;
                        this.f11569a.f11533p = Integer.valueOf(TextRange.n(textFieldSelectionManager2.v0(TextFieldValue.d(textFieldSelectionManager2.U(), null, TextRange.f28921b.a(), null, 5, null), j3, true, false, SelectionAdjustment.f11264a.o(), true)));
                    }
                    this.f11569a.j0(HandleState.f9702a);
                    this.f11569a.f11532o = j4;
                    TextFieldSelectionManager textFieldSelectionManager3 = this.f11569a;
                    textFieldSelectionManager3.d0(Offset.d(textFieldSelectionManager3.f11532o));
                    this.f11569a.f11534q = Offset.f25596b.c();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void d(long r10) {
                /*
                    Method dump skipped, instruction units count: 261
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.d(long):void");
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
        };
        this.f11541x = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean b(long j3) {
                LegacyTextFieldState legacyTextFieldStateP;
                if (!this.f11550a.H() || this.f11550a.U().i().length() == 0 || (legacyTextFieldStateP = this.f11550a.P()) == null || legacyTextFieldStateP.l() == null) {
                    return false;
                }
                f(this.f11550a.U(), j3, false, SelectionAdjustment.f11264a.m());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean c(long j3, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState legacyTextFieldStateP;
                if (!this.f11550a.H() || this.f11550a.U().i().length() == 0 || (legacyTextFieldStateP = this.f11550a.P()) == null || legacyTextFieldStateP.l() == null) {
                    return false;
                }
                FocusRequester focusRequesterI = this.f11550a.I();
                if (focusRequesterI != null) {
                    FocusRequester.h(focusRequesterI, 0, 1, null);
                }
                this.f11550a.f11532o = j3;
                this.f11550a.f11537t = -1;
                TextFieldSelectionManager.y(this.f11550a, false, 1, null);
                f(this.f11550a.U(), this.f11550a.f11532o, true, selectionAdjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean d(long j3, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState legacyTextFieldStateP;
                if (!this.f11550a.H() || this.f11550a.U().i().length() == 0 || (legacyTextFieldStateP = this.f11550a.P()) == null || legacyTextFieldStateP.l() == null) {
                    return false;
                }
                f(this.f11550a.U(), j3, false, selectionAdjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean e(long j3) {
                LegacyTextFieldState legacyTextFieldStateP = this.f11550a.P();
                if (legacyTextFieldStateP == null || legacyTextFieldStateP.l() == null || !this.f11550a.H()) {
                    return false;
                }
                this.f11550a.f11537t = -1;
                f(this.f11550a.U(), j3, false, SelectionAdjustment.f11264a.m());
                return true;
            }

            public final void f(TextFieldValue textFieldValue, long j3, boolean z2, SelectionAdjustment selectionAdjustment) {
                this.f11550a.j0(TextRange.h(this.f11550a.v0(textFieldValue, j3, z2, false, selectionAdjustment, false)) ? HandleState.f9704c : HandleState.f9703b);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void a() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect B() {
        char c3;
        long j3;
        float fIntBitsToFloat;
        LayoutCoordinates layoutCoordinatesK;
        TextLayoutResult textLayoutResultF;
        Rect rectE;
        LayoutCoordinates layoutCoordinatesK2;
        TextLayoutResult textLayoutResultF2;
        Rect rectE2;
        LayoutCoordinates layoutCoordinatesK3;
        LayoutCoordinates layoutCoordinatesK4;
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.B()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int iB = this.f11519b.b(TextRange.n(U().h()));
                int iB2 = this.f11519b.b(TextRange.i(U().h()));
                LegacyTextFieldState legacyTextFieldState2 = this.f11521d;
                long jC = (legacyTextFieldState2 == null || (layoutCoordinatesK4 = legacyTextFieldState2.k()) == null) ? Offset.f25596b.c() : layoutCoordinatesK4.x0(K(true));
                LegacyTextFieldState legacyTextFieldState3 = this.f11521d;
                long jC2 = (legacyTextFieldState3 == null || (layoutCoordinatesK3 = legacyTextFieldState3.k()) == null) ? Offset.f25596b.c() : layoutCoordinatesK3.x0(K(false));
                LegacyTextFieldState legacyTextFieldState4 = this.f11521d;
                float fIntBitsToFloat2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinatesK2 = legacyTextFieldState4.k()) == null) {
                    c3 = ' ';
                    j3 = 4294967295L;
                    fIntBitsToFloat = 0.0f;
                } else {
                    TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
                    c3 = ' ';
                    j3 = 4294967295L;
                    fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinatesK2.x0(Offset.e((((long) Float.floatToRawIntBits((textLayoutResultProxyL == null || (textLayoutResultF2 = textLayoutResultProxyL.f()) == null || (rectE2 = textLayoutResultF2.e(iB)) == null) ? 0.0f : rectE2.r())) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.f11521d;
                if (legacyTextFieldState5 != null && (layoutCoordinatesK = legacyTextFieldState5.k()) != null) {
                    TextLayoutResultProxy textLayoutResultProxyL2 = legacyTextFieldState.l();
                    fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutCoordinatesK.x0(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << c3) | (((long) Float.floatToRawIntBits((textLayoutResultProxyL2 == null || (textLayoutResultF = textLayoutResultProxyL2.f()) == null || (rectE = textLayoutResultF.e(iB2)) == null) ? 0.0f : rectE.r())) & j3))) & j3));
                }
                int i3 = (int) (jC >> c3);
                int i4 = (int) (jC2 >> c3);
                return new Rect(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.max(Float.intBitsToFloat((int) (jC & j3)), Float.intBitsToFloat((int) (jC2 & j3))) + (Dp.g(25) * legacyTextFieldState.x().a().getDensity()));
            }
        }
        return Rect.f25601e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(Offset offset) {
        this.f11536s.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Handle handle) {
        this.f11535r.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.e() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.E(handleState);
            }
        }
    }

    public static /* synthetic */ Job r(TextFieldSelectionManager textFieldSelectionManager, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return textFieldSelectionManager.q(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextFieldValue s(AnnotatedString annotatedString, long j3) {
        return new TextFieldValue(annotatedString, j3, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(boolean z2) {
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.O(z2);
        }
        if (z2) {
            t0();
        } else {
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long v0(TextFieldValue textFieldValue, long j3, boolean z2, boolean z3, SelectionAdjustment selectionAdjustment, boolean z4) {
        TextLayoutResultProxy textLayoutResultProxyL;
        int i3;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState == null || (textLayoutResultProxyL = legacyTextFieldState.l()) == null) {
            return TextRange.f28921b.a();
        }
        long jB = TextRangeKt.b(this.f11519b.b(TextRange.n(textFieldValue.h())), this.f11519b.b(TextRange.i(textFieldValue.h())));
        boolean z5 = false;
        int iD = textLayoutResultProxyL.d(j3, false);
        int iN = (z3 || z2) ? iD : TextRange.n(jB);
        int i4 = (!z3 || z2) ? iD : TextRange.i(jB);
        SelectionLayout selectionLayout = this.f11539v;
        if (z2 || selectionLayout == null || (i3 = this.f11537t) == -1) {
            i3 = -1;
        }
        SelectionLayout selectionLayoutC = SelectionLayoutKt.c(textLayoutResultProxyL.f(), iN, i4, i3, jB, z2, z3);
        if (!selectionLayoutC.i(selectionLayout)) {
            return textFieldValue.h();
        }
        this.f11539v = selectionLayoutC;
        this.f11537t = iD;
        Selection selectionA = selectionAdjustment.a(selectionLayoutC);
        long jB2 = TextRangeKt.b(this.f11519b.a(selectionA.e().d()), this.f11519b.a(selectionA.c().d()));
        if (TextRange.g(jB2, textFieldValue.h())) {
            return textFieldValue.h();
        }
        boolean z6 = TextRange.m(jB2) != TextRange.m(textFieldValue.h()) && TextRange.g(TextRangeKt.b(TextRange.i(jB2), TextRange.n(jB2)), textFieldValue.h());
        boolean z7 = TextRange.h(jB2) && TextRange.h(textFieldValue.h());
        if (z4 && textFieldValue.i().length() > 0 && !z6 && !z7 && (hapticFeedback = this.f11528k) != null) {
            hapticFeedback.a(HapticFeedbackType.f26611b.i());
        }
        this.f11520c.invoke(s(textFieldValue.f(), jB2));
        if (!z4) {
            u0(!TextRange.h(jB2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.f11521d;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.G(z4);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.f11521d;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.Q(!TextRange.h(jB2) && TextFieldSelectionManagerKt.c(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.f11521d;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.P(!TextRange.h(jB2) && TextFieldSelectionManagerKt.c(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.f11521d;
        if (legacyTextFieldState5 == null) {
            return jB2;
        }
        if (TextRange.h(jB2) && TextFieldSelectionManagerKt.c(this, true)) {
            z5 = true;
        }
        legacyTextFieldState5.N(z5);
        return jB2;
    }

    public static /* synthetic */ void w(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.v(offset);
    }

    public static /* synthetic */ void y(TextFieldSelectionManager textFieldSelectionManager, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        textFieldSelectionManager.x(z2);
    }

    public final Clipboard A() {
        return this.f11525h;
    }

    public final CoroutineScope C() {
        return this.f11526i;
    }

    public final Offset D() {
        return (Offset) this.f11536s.getValue();
    }

    public final long E(Density density) {
        int iB = this.f11519b.b(TextRange.n(U().h()));
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState != null ? legacyTextFieldState.l() : null;
        Intrinsics.checkNotNull(textLayoutResultProxyL);
        TextLayoutResult textLayoutResultF = textLayoutResultProxyL.f();
        Rect rectE = textLayoutResultF.e(RangesKt.p(iB, 0, textLayoutResultF.l().j().length()));
        return Offset.e((((long) Float.floatToRawIntBits(rectE.o() + (density.M1(TextFieldCursor_androidKt.a()) / 2))) << 32) | (((long) Float.floatToRawIntBits(rectE.i())) & 4294967295L));
    }

    public final Handle F() {
        return (Handle) this.f11535r.getValue();
    }

    public final boolean G() {
        return ((Boolean) this.f11530m.getValue()).booleanValue();
    }

    public final boolean H() {
        return ((Boolean) this.f11531n.getValue()).booleanValue();
    }

    public final FocusRequester I() {
        return this.f11529l;
    }

    public final float J(boolean z2) {
        TextLayoutResultProxy textLayoutResultProxyL;
        TextLayoutResult textLayoutResultF;
        int iN = z2 ? TextRange.n(U().h()) : TextRange.i(U().h());
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState == null || (textLayoutResultProxyL = legacyTextFieldState.l()) == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.b(textLayoutResultF, iN);
    }

    public final long K(boolean z2) {
        TextLayoutResultProxy textLayoutResultProxyL;
        TextLayoutResult textLayoutResultF;
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState == null || (textLayoutResultProxyL = legacyTextFieldState.l()) == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null) {
            return Offset.f25596b.b();
        }
        AnnotatedString annotatedStringS = S();
        if (annotatedStringS == null) {
            return Offset.f25596b.b();
        }
        if (!Intrinsics.areEqual(annotatedStringS.k(), textLayoutResultF.l().j().k())) {
            return Offset.f25596b.b();
        }
        long jH = U().h();
        return TextSelectionDelegateKt.b(textLayoutResultF, this.f11519b.b(z2 ? TextRange.n(jH) : TextRange.i(jH)), z2, TextRange.m(U().h()));
    }

    public final HapticFeedback L() {
        return this.f11528k;
    }

    public final MouseSelectionObserver M() {
        return this.f11541x;
    }

    public final OffsetMapping N() {
        return this.f11519b;
    }

    public final Function1 O() {
        return this.f11520c;
    }

    public final LegacyTextFieldState P() {
        return this.f11521d;
    }

    public final TextToolbar Q() {
        return this.f11527j;
    }

    public final TextDragObserver R() {
        return this.f11540w;
    }

    public final AnnotatedString S() {
        TextDelegate textDelegateX;
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState == null || (textDelegateX = legacyTextFieldState.x()) == null) {
            return null;
        }
        return textDelegateX.k();
    }

    public final UndoManager T() {
        return this.f11518a;
    }

    public final TextFieldValue U() {
        return (TextFieldValue) this.f11522e.getValue();
    }

    public final VisualTransformation V() {
        return this.f11523f;
    }

    public final TextDragObserver W(final boolean z2) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void a(long j3) {
                TextLayoutResultProxy textLayoutResultProxyL;
                this.f11548a.f0(z2 ? Handle.f9698b : Handle.f9699c);
                long jA = SelectionHandlesKt.a(this.f11548a.K(z2));
                LegacyTextFieldState legacyTextFieldStateP = this.f11548a.P();
                if (legacyTextFieldStateP == null || (textLayoutResultProxyL = legacyTextFieldStateP.l()) == null) {
                    return;
                }
                long jK = textLayoutResultProxyL.k(jA);
                this.f11548a.f11532o = jK;
                this.f11548a.d0(Offset.d(jK));
                this.f11548a.f11534q = Offset.f25596b.c();
                this.f11548a.f11537t = -1;
                LegacyTextFieldState legacyTextFieldStateP2 = this.f11548a.P();
                if (legacyTextFieldStateP2 != null) {
                    legacyTextFieldStateP2.G(true);
                }
                this.f11548a.u0(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void c() {
                this.f11548a.f0(null);
                this.f11548a.d0(null);
                this.f11548a.u0(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void d(long j3) {
                TextFieldSelectionManager textFieldSelectionManager = this.f11548a;
                textFieldSelectionManager.f11534q = Offset.q(textFieldSelectionManager.f11534q, j3);
                TextFieldSelectionManager textFieldSelectionManager2 = this.f11548a;
                textFieldSelectionManager2.d0(Offset.d(Offset.q(textFieldSelectionManager2.f11532o, this.f11548a.f11534q)));
                TextFieldSelectionManager textFieldSelectionManager3 = this.f11548a;
                TextFieldValue textFieldValueU = textFieldSelectionManager3.U();
                Offset offsetD = this.f11548a.D();
                Intrinsics.checkNotNull(offsetD);
                textFieldSelectionManager3.v0(textFieldValueU, offsetD.u(), false, z2, SelectionAdjustment.f11264a.l(), true);
                this.f11548a.u0(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.f11548a.f0(null);
                this.f11548a.d0(null);
                this.f11548a.u0(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void b(long j3) {
            }
        };
    }

    public final void X() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.f11527j;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.f28212a || (textToolbar = this.f11527j) == null) {
            return;
        }
        textToolbar.a();
    }

    public final boolean Y() {
        return !Intrinsics.areEqual(this.f11538u.i(), U().i());
    }

    public final Job Z() {
        CoroutineScope coroutineScope = this.f11526i;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new TextFieldSelectionManager$paste$1(this, null), 1, null);
        }
        return null;
    }

    public final void a0() {
        TextFieldValue textFieldValueS = s(U().f(), TextRangeKt.b(0, U().i().length()));
        this.f11520c.invoke(textFieldValueS);
        this.f11538u = TextFieldValue.d(this.f11538u, null, textFieldValueS.h(), null, 5, null);
        x(true);
    }

    public final void b0(Clipboard clipboard) {
        this.f11525h = clipboard;
    }

    public final void c0(CoroutineScope coroutineScope) {
        this.f11526i = coroutineScope;
    }

    public final void e0(long j3) {
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.D(j3);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.f11521d;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.M(TextRange.f28921b.a());
        }
        if (TextRange.h(j3)) {
            return;
        }
        z();
    }

    public final void g0(boolean z2) {
        this.f11530m.setValue(Boolean.valueOf(z2));
    }

    public final void h0(boolean z2) {
        this.f11531n.setValue(Boolean.valueOf(z2));
    }

    public final void i0(FocusRequester focusRequester) {
        this.f11529l = focusRequester;
    }

    public final void k0(HapticFeedback hapticFeedback) {
        this.f11528k = hapticFeedback;
    }

    public final void l0(OffsetMapping offsetMapping) {
        this.f11519b = offsetMapping;
    }

    public final void m0(Function1 function1) {
        this.f11520c = function1;
    }

    public final void n0(Function0 function0) {
        this.f11524g = function0;
    }

    public final void o() {
        Function0 function0 = this.f11524g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void o0(long j3) {
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.M(j3);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.f11521d;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.D(TextRange.f28921b.a());
        }
        if (TextRange.h(j3)) {
            return;
        }
        z();
    }

    public final void p() {
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.D(TextRange.f28921b.a());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.f11521d;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.M(TextRange.f28921b.a());
    }

    public final void p0(LegacyTextFieldState legacyTextFieldState) {
        this.f11521d = legacyTextFieldState;
    }

    public final Job q(boolean z2) {
        CoroutineScope coroutineScope = this.f11526i;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new TextFieldSelectionManager$copy$1(this, z2, null), 1, null);
        }
        return null;
    }

    public final void q0(TextToolbar textToolbar) {
        this.f11527j = textToolbar;
    }

    public final void r0(TextFieldValue textFieldValue) {
        this.f11522e.setValue(textFieldValue);
    }

    public final void s0(VisualTransformation visualTransformation) {
        this.f11523f = visualTransformation;
    }

    public final TextDragObserver t() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void b(long j3) {
                TextLayoutResultProxy textLayoutResultProxyL;
                long jA = SelectionHandlesKt.a(this.f11545a.K(true));
                LegacyTextFieldState legacyTextFieldStateP = this.f11545a.P();
                if (legacyTextFieldStateP == null || (textLayoutResultProxyL = legacyTextFieldStateP.l()) == null) {
                    return;
                }
                long jK = textLayoutResultProxyL.k(jA);
                this.f11545a.f11532o = jK;
                this.f11545a.d0(Offset.d(jK));
                this.f11545a.f11534q = Offset.f25596b.c();
                this.f11545a.f0(Handle.f9697a);
                this.f11545a.u0(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void c() {
                this.f11545a.f0(null);
                this.f11545a.d0(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void d(long j3) {
                TextLayoutResultProxy textLayoutResultProxyL;
                HapticFeedback hapticFeedbackL;
                TextFieldSelectionManager textFieldSelectionManager = this.f11545a;
                textFieldSelectionManager.f11534q = Offset.q(textFieldSelectionManager.f11534q, j3);
                LegacyTextFieldState legacyTextFieldStateP = this.f11545a.P();
                if (legacyTextFieldStateP == null || (textLayoutResultProxyL = legacyTextFieldStateP.l()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.f11545a;
                textFieldSelectionManager2.d0(Offset.d(Offset.q(textFieldSelectionManager2.f11532o, textFieldSelectionManager2.f11534q)));
                OffsetMapping offsetMappingN = textFieldSelectionManager2.N();
                Offset offsetD = textFieldSelectionManager2.D();
                Intrinsics.checkNotNull(offsetD);
                int iA = offsetMappingN.a(TextLayoutResultProxy.e(textLayoutResultProxyL, offsetD.u(), false, 2, null));
                long jB = TextRangeKt.b(iA, iA);
                if (TextRange.g(jB, textFieldSelectionManager2.U().h())) {
                    return;
                }
                LegacyTextFieldState legacyTextFieldStateP2 = textFieldSelectionManager2.P();
                if ((legacyTextFieldStateP2 == null || legacyTextFieldStateP2.A()) && (hapticFeedbackL = textFieldSelectionManager2.L()) != null) {
                    hapticFeedbackL.a(HapticFeedbackType.f26611b.i());
                }
                textFieldSelectionManager2.O().invoke(textFieldSelectionManager2.s(textFieldSelectionManager2.U().f(), jB));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.f11545a.f0(null);
                this.f11545a.d0(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void a(long j3) {
            }
        };
    }

    public final Job t0() {
        CoroutineScope coroutineScope = this.f11526i;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new TextFieldSelectionManager$showSelectionToolbar$1(this, null), 1, null);
        }
        return null;
    }

    public final Job u() {
        CoroutineScope coroutineScope = this.f11526i;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new TextFieldSelectionManager$cut$1(this, null), 1, null);
        }
        return null;
    }

    public final void v(Offset offset) {
        if (!TextRange.h(U().h())) {
            LegacyTextFieldState legacyTextFieldState = this.f11521d;
            TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState != null ? legacyTextFieldState.l() : null;
            this.f11520c.invoke(TextFieldValue.d(U(), null, TextRangeKt.a((offset == null || textLayoutResultProxyL == null) ? TextRange.k(U().h()) : this.f11519b.a(TextLayoutResultProxy.e(textLayoutResultProxyL, offset.u(), false, 2, null))), null, 5, null));
        }
        j0((offset == null || U().i().length() <= 0) ? HandleState.f9702a : HandleState.f9704c);
        u0(false);
    }

    public final void x(boolean z2) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.f11521d;
        if (legacyTextFieldState != null && !legacyTextFieldState.f() && (focusRequester = this.f11529l) != null) {
            FocusRequester.h(focusRequester, 0, 1, null);
        }
        this.f11538u = U();
        u0(z2);
        j0(HandleState.f9703b);
    }

    public final void z() {
        u0(false);
        j0(HandleState.f9702a);
    }
}
