package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public abstract class TextFieldKeyEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldPreparedSelectionState f10606a = new TextFieldPreparedSelectionState();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DeadKeyCombiner f10607b = new DeadKeyCombiner();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KeyMapping f10608c = KeyMapping_androidKt.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableLongSet f10609d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10610a;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.f9739s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.f9740t.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.f9741u.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.f9723b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.f9724c.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.f9726f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.f9725d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.f9728h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.f9727g.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.f9733m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.f9734n.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.f9735o.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.f9736p.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.f9729i.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.f9730j.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.f9731k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.f9732l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.f9737q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.f9738r.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.f9742v.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.f9743w.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.f9744x.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.f9745y.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.f9746z.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.A.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.T.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.U.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.B.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.C.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.D.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.K.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.L.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.N.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.M.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.O.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.P.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.Q.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.R.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.E.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.F.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.G.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.H.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.I.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.J.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.S.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.V.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.W.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.X.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            f10610a = iArr;
        }
    }

    private final float a(TextLayoutState textLayoutState) {
        LayoutCoordinates layoutCoordinatesJ = textLayoutState.j();
        if (layoutCoordinatesJ == null) {
            return Float.NaN;
        }
        Rect rectR = null;
        if (!layoutCoordinatesJ.m()) {
            layoutCoordinatesJ = null;
        }
        if (layoutCoordinatesJ == null) {
            return Float.NaN;
        }
        LayoutCoordinates layoutCoordinatesE = textLayoutState.e();
        if (layoutCoordinatesE != null) {
            if (!layoutCoordinatesE.m()) {
                layoutCoordinatesE = null;
            }
            if (layoutCoordinatesE != null) {
                rectR = LayoutCoordinates.R(layoutCoordinatesE, layoutCoordinatesJ, false, 2, null);
            }
        }
        if (rectR != null) {
            return Float.intBitsToFloat((int) (rectR.q() & 4294967295L));
        }
        return Float.NaN;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final boolean d(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Function1 function1, boolean z2, boolean z3, Function0 function0) {
        WedgeAffinity wedgeAffinityT;
        Integer numA;
        boolean z4 = false;
        if (TextFieldKeyInput_androidKt.a(keyEvent) && (numA = this.f10607b.a(keyEvent)) != null) {
            String string = StringHelpers_jvmKt.a(new StringBuilder(2), numA.intValue()).toString();
            if (!z2) {
                return false;
            }
            TransformedTextFieldState.x(transformedTextFieldState, string, true, null, !TextFieldKeyEventHandler_androidKt.c(keyEvent), 4, null);
            this.f10606a.b();
            return true;
        }
        KeyCommand keyCommandA = this.f10608c.a(keyEvent);
        if (keyCommandA != null && (!keyCommandA.b() || z2)) {
            TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(transformedTextFieldState, textLayoutState.f(), TextFieldKeyEventHandler_androidKt.c(keyEvent), a(textLayoutState), this.f10606a);
            switch (WhenMappings.f10610a[keyCommandA.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    function1.invoke(keyCommandA);
                    z4 = true;
                    break;
                case 4:
                    textFieldPreparedSelection.e(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$processKeyDownEvent$1$1
                        public final void c(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.z();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((TextFieldPreparedSelection) obj);
                            return Unit.f139807a;
                        }
                    });
                    z4 = true;
                    break;
                case 5:
                    textFieldPreparedSelection.f(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$processKeyDownEvent$1$2
                        public final void c(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.H();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((TextFieldPreparedSelection) obj);
                            return Unit.f139807a;
                        }
                    });
                    z4 = true;
                    break;
                case 6:
                    textFieldPreparedSelection.A();
                    z4 = true;
                    break;
                case 7:
                    textFieldPreparedSelection.I();
                    z4 = true;
                    break;
                case 8:
                    textFieldPreparedSelection.F();
                    z4 = true;
                    break;
                case 9:
                    textFieldPreparedSelection.C();
                    z4 = true;
                    break;
                case 10:
                    textFieldPreparedSelection.P();
                    z4 = true;
                    break;
                case 11:
                    textFieldPreparedSelection.x();
                    z4 = true;
                    break;
                case 12:
                    textFieldPreparedSelection.Q();
                    z4 = true;
                    break;
                case 13:
                    textFieldPreparedSelection.y();
                    z4 = true;
                    break;
                case 14:
                    textFieldPreparedSelection.O();
                    z4 = true;
                    break;
                case 15:
                    textFieldPreparedSelection.L();
                    z4 = true;
                    break;
                case 16:
                    textFieldPreparedSelection.M();
                    z4 = true;
                    break;
                case 17:
                    textFieldPreparedSelection.N();
                    z4 = true;
                    break;
                case 18:
                    textFieldPreparedSelection.K();
                    z4 = true;
                    break;
                case 19:
                    textFieldPreparedSelection.J();
                    z4 = true;
                    break;
                case 20:
                    textFieldPreparedSelection.E().g();
                    z4 = true;
                    break;
                case 21:
                    textFieldPreparedSelection.B().g();
                    z4 = true;
                    break;
                case 22:
                    textFieldPreparedSelection.G().g();
                    z4 = true;
                    break;
                case 23:
                    textFieldPreparedSelection.D().g();
                    z4 = true;
                    break;
                case 24:
                    textFieldPreparedSelection.O().g();
                    z4 = true;
                    break;
                case 25:
                    textFieldPreparedSelection.L().g();
                    z4 = true;
                    break;
                case 26:
                    if (z3) {
                        function0.invoke();
                    } else {
                        TransformedTextFieldState.x(transformedTextFieldState, "\n", true, null, !TextFieldKeyEventHandler_androidKt.c(keyEvent), 4, null);
                    }
                    z4 = true;
                    break;
                case 27:
                    if (!z3) {
                        TransformedTextFieldState.x(transformedTextFieldState, "\t", true, null, !TextFieldKeyEventHandler_androidKt.c(keyEvent), 4, null);
                        z4 = true;
                    }
                    break;
                case 28:
                    textFieldPreparedSelection.R();
                    z4 = true;
                    break;
                case 29:
                    textFieldPreparedSelection.z().S();
                    z4 = true;
                    break;
                case 30:
                    textFieldPreparedSelection.H().S();
                    z4 = true;
                    break;
                case 31:
                    textFieldPreparedSelection.A().S();
                    z4 = true;
                    break;
                case 32:
                    textFieldPreparedSelection.I().S();
                    z4 = true;
                    break;
                case 33:
                    textFieldPreparedSelection.F().S();
                    z4 = true;
                    break;
                case 34:
                    textFieldPreparedSelection.C().S();
                    z4 = true;
                    break;
                case 35:
                    textFieldPreparedSelection.O().S();
                    z4 = true;
                    break;
                case 36:
                    textFieldPreparedSelection.L().S();
                    z4 = true;
                    break;
                case 37:
                    textFieldPreparedSelection.M().S();
                    z4 = true;
                    break;
                case 38:
                    textFieldPreparedSelection.N().S();
                    z4 = true;
                    break;
                case 39:
                    textFieldPreparedSelection.P().S();
                    z4 = true;
                    break;
                case 40:
                    textFieldPreparedSelection.x().S();
                    z4 = true;
                    break;
                case 41:
                    textFieldPreparedSelection.Q().S();
                    z4 = true;
                    break;
                case 42:
                    textFieldPreparedSelection.y().S();
                    z4 = true;
                    break;
                case 43:
                    textFieldPreparedSelection.K().S();
                    z4 = true;
                    break;
                case 44:
                    textFieldPreparedSelection.J().S();
                    z4 = true;
                    break;
                case 45:
                    textFieldPreparedSelection.h();
                    z4 = true;
                    break;
                case 46:
                    transformedTextFieldState.E();
                    z4 = true;
                    break;
                case 47:
                    transformedTextFieldState.u();
                    z4 = true;
                    break;
                case 48:
                    KeyEventHelpers_androidKt.b();
                    z4 = true;
                    break;
                default:
                    z4 = true;
                    break;
            }
            if (!TextRange.g(textFieldPreparedSelection.s(), textFieldPreparedSelection.i().g())) {
                transformedTextFieldState.B(textFieldPreparedSelection.s());
            }
            if (textFieldPreparedSelection.t() != null && (wedgeAffinityT = textFieldPreparedSelection.t()) != null) {
                if (TextRange.h(transformedTextFieldState.n().g())) {
                    transformedTextFieldState.D(new SelectionWedgeAffinity(wedgeAffinityT));
                    return z4;
                }
                transformedTextFieldState.D(SelectionWedgeAffinity.b(textFieldPreparedSelection.j(), null, wedgeAffinityT, 1, null));
            }
        }
        return z4;
    }

    public boolean b(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1 function1, boolean z2, boolean z3, Function0 function0) {
        long jA = KeyEvent_androidKt.a(keyEvent);
        int iB = KeyEvent_androidKt.b(keyEvent);
        KeyEventType.Companion companion = KeyEventType.f26731b;
        if (KeyEventType.f(iB, companion.b())) {
            MutableLongSet mutableLongSet = this.f10609d;
            if (mutableLongSet == null || !mutableLongSet.a(jA)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.f10609d;
            if (mutableLongSet2 != null) {
                mutableLongSet2.m(jA);
            }
            return true;
        }
        if (KeyEventType.f(KeyEvent_androidKt.b(keyEvent), companion.c()) && !TextFieldKeyInput_androidKt.a(keyEvent)) {
            return false;
        }
        boolean zD = d(keyEvent, transformedTextFieldState, textLayoutState, function1, z2, z3, function0);
        if (zD) {
            MutableLongSet mutableLongSet3 = this.f10609d;
            if (mutableLongSet3 == null) {
                mutableLongSet3 = new MutableLongSet(3);
                this.f10609d = mutableLongSet3;
            }
            mutableLongSet3.l(jA);
        }
        return zD;
    }

    public boolean c(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (TextRange.h(transformedTextFieldState.o().g()) || !KeyEventHelpers_androidKt.a(keyEvent)) {
            return false;
        }
        textFieldSelectionState.L();
        return true;
    }
}
