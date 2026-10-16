package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class TextFieldKeyInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LegacyTextFieldState f9933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextFieldSelectionManager f9934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextFieldValue f9935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPreparedSelectionState f9938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OffsetMapping f9939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final UndoManager f9940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DeadKeyCombiner f9941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final KeyMapping f9942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1 f9943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f9944l;

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z2, boolean z3, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(legacyTextFieldState, textFieldSelectionManager, textFieldValue, z2, z3, textPreparedSelectionState, offsetMapping, undoManager, deadKeyCombiner, keyMapping, function1, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(EditCommand editCommand) {
        f(CollectionsKt.listOf(editCommand));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(List list) {
        EditProcessor editProcessorP = this.f9933a.p();
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(0, new FinishComposingTextCommand());
        this.f9943k.invoke(editProcessorP.b(mutableList));
    }

    private final void g(Function1 function1) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.f9935c, this.f9939g, this.f9933a.l(), this.f9938f);
        function1.invoke(textFieldPreparedSelection);
        if (TextRange.g(textFieldPreparedSelection.u(), this.f9935c.h()) && Intrinsics.areEqual(textFieldPreparedSelection.e(), this.f9935c.f())) {
            return;
        }
        this.f9943k.invoke(textFieldPreparedSelection.Z());
    }

    private final CommitTextCommand m(KeyEvent keyEvent) {
        Integer numA;
        if (TextFieldKeyInput_androidKt.a(keyEvent) && (numA = this.f9941i.a(keyEvent)) != null) {
            return new CommitTextCommand(StringHelpers_jvmKt.a(new StringBuilder(), numA.intValue()).toString(), 1);
        }
        return null;
    }

    public final TextFieldSelectionManager h() {
        return this.f9934b;
    }

    public final boolean i() {
        return this.f9937e;
    }

    public final LegacyTextFieldState j() {
        return this.f9933a;
    }

    public final UndoManager k() {
        return this.f9940h;
    }

    public final boolean l(KeyEvent keyEvent) {
        final KeyCommand keyCommandA;
        CommitTextCommand commitTextCommandM = m(keyEvent);
        if (commitTextCommandM != null) {
            if (!this.f9936d) {
                return false;
            }
            e(commitTextCommandM);
            this.f9938f.b();
            return true;
        }
        if (!KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) || (keyCommandA = this.f9942j.a(keyEvent)) == null || (keyCommandA.b() && !this.f9936d)) {
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.f140137a = true;
        g(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f9957a;

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
                    f9957a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldPreparedSelection textFieldPreparedSelection) {
                TextFieldValue textFieldValueG;
                TextFieldValue textFieldValueC;
                switch (WhenMappings.f9957a[keyCommandA.ordinal()]) {
                    case 1:
                        this.h().q(false);
                        break;
                    case 2:
                        this.h().Z();
                        break;
                    case 3:
                        this.h().u();
                        break;
                    case 4:
                        textFieldPreparedSelection.b(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.1
                            public final void c(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                textFieldPreparedSelection2.A();
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c((TextFieldPreparedSelection) obj);
                                return Unit.f139807a;
                            }
                        });
                        break;
                    case 5:
                        textFieldPreparedSelection.c(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.2
                            public final void c(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                textFieldPreparedSelection2.I();
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c((TextFieldPreparedSelection) obj);
                                return Unit.f139807a;
                            }
                        });
                        break;
                    case 6:
                        textFieldPreparedSelection.B();
                        break;
                    case 7:
                        textFieldPreparedSelection.J();
                        break;
                    case 8:
                        textFieldPreparedSelection.G();
                        break;
                    case 9:
                        textFieldPreparedSelection.D();
                        break;
                    case 10:
                        textFieldPreparedSelection.Q();
                        break;
                    case 11:
                        textFieldPreparedSelection.z();
                        break;
                    case 12:
                        textFieldPreparedSelection.c0();
                        break;
                    case 13:
                        textFieldPreparedSelection.b0();
                        break;
                    case 14:
                        textFieldPreparedSelection.P();
                        break;
                    case 15:
                        textFieldPreparedSelection.M();
                        break;
                    case 16:
                        textFieldPreparedSelection.N();
                        break;
                    case 17:
                        textFieldPreparedSelection.O();
                        break;
                    case 18:
                        textFieldPreparedSelection.L();
                        break;
                    case 19:
                        textFieldPreparedSelection.K();
                        break;
                    case 20:
                        List listY = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.3
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                return new DeleteSurroundingTextCommand(TextRange.i(textFieldPreparedSelection2.u()) - textFieldPreparedSelection2.q(), 0);
                            }
                        });
                        if (listY != null) {
                            this.f(listY);
                        }
                        break;
                    case 21:
                        List listY2 = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.4
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                int iL = textFieldPreparedSelection2.l();
                                if (iL != -1) {
                                    return new DeleteSurroundingTextCommand(0, iL - TextRange.i(textFieldPreparedSelection2.u()));
                                }
                                return null;
                            }
                        });
                        if (listY2 != null) {
                            this.f(listY2);
                        }
                        break;
                    case 22:
                        List listY3 = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.5
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer numT = textFieldPreparedSelection2.t();
                                if (numT == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.i(textFieldPreparedSelection2.u()) - numT.intValue(), 0);
                            }
                        });
                        if (listY3 != null) {
                            this.f(listY3);
                        }
                        break;
                    case 23:
                        List listY4 = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.6
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer numM = textFieldPreparedSelection2.m();
                                if (numM != null) {
                                    return new DeleteSurroundingTextCommand(0, numM.intValue() - TextRange.i(textFieldPreparedSelection2.u()));
                                }
                                return null;
                            }
                        });
                        if (listY4 != null) {
                            this.f(listY4);
                        }
                        break;
                    case 24:
                        List listY5 = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.7
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer numI = textFieldPreparedSelection2.i();
                                if (numI == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.i(textFieldPreparedSelection2.u()) - numI.intValue(), 0);
                            }
                        });
                        if (listY5 != null) {
                            this.f(listY5);
                        }
                        break;
                    case 25:
                        List listY6 = textFieldPreparedSelection.Y(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.8
                            @Override // kotlin.jvm.functions.Function1
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer numF = textFieldPreparedSelection2.f();
                                if (numF != null) {
                                    return new DeleteSurroundingTextCommand(0, numF.intValue() - TextRange.i(textFieldPreparedSelection2.u()));
                                }
                                return null;
                            }
                        });
                        if (listY6 != null) {
                            this.f(listY6);
                        }
                        break;
                    case 26:
                        if (!this.i()) {
                            this.e(new CommitTextCommand("\n", 1));
                        } else {
                            this.j().n().invoke(ImeAction.j(this.f9944l));
                        }
                        break;
                    case 27:
                        if (!this.i()) {
                            this.e(new CommitTextCommand("\t", 1));
                        } else {
                            booleanRef.f140137a = false;
                        }
                        break;
                    case 28:
                        textFieldPreparedSelection.R();
                        break;
                    case 29:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.A()).S();
                        break;
                    case 30:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.I()).S();
                        break;
                    case 31:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.B()).S();
                        break;
                    case 32:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.J()).S();
                        break;
                    case 33:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.G()).S();
                        break;
                    case 34:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.D()).S();
                        break;
                    case 35:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.P()).S();
                        break;
                    case 36:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.M()).S();
                        break;
                    case 37:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.N()).S();
                        break;
                    case 38:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.O()).S();
                        break;
                    case 39:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.Q()).S();
                        break;
                    case 40:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.z()).S();
                        break;
                    case 41:
                        textFieldPreparedSelection.c0().S();
                        break;
                    case 42:
                        textFieldPreparedSelection.b0().S();
                        break;
                    case 43:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.L()).S();
                        break;
                    case 44:
                        ((TextFieldPreparedSelection) textFieldPreparedSelection.K()).S();
                        break;
                    case 45:
                        textFieldPreparedSelection.d();
                        break;
                    case 46:
                        UndoManager undoManagerK = this.k();
                        if (undoManagerK != null) {
                            undoManagerK.b(textFieldPreparedSelection.Z());
                        }
                        UndoManager undoManagerK2 = this.k();
                        if (undoManagerK2 != null && (textFieldValueG = undoManagerK2.g()) != null) {
                            this.f9943k.invoke(textFieldValueG);
                            break;
                        }
                        break;
                    case 47:
                        UndoManager undoManagerK3 = this.k();
                        if (undoManagerK3 != null && (textFieldValueC = undoManagerK3.c()) != null) {
                            this.f9943k.invoke(textFieldValueC);
                            break;
                        }
                        break;
                    case 48:
                        KeyEventHelpers_androidKt.b();
                        break;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldPreparedSelection) obj);
                return Unit.f139807a;
            }
        });
        UndoManager undoManager = this.f9940h;
        if (undoManager != null) {
            undoManager.a();
        }
        return booleanRef.f140137a;
    }

    private TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z2, boolean z3, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i3) {
        this.f9933a = legacyTextFieldState;
        this.f9934b = textFieldSelectionManager;
        this.f9935c = textFieldValue;
        this.f9936d = z2;
        this.f9937e = z3;
        this.f9938f = textPreparedSelectionState;
        this.f9939g = offsetMapping;
        this.f9940h = undoManager;
        this.f9941i = deadKeyCombiner;
        this.f9942j = keyMapping;
        this.f9943k = function1;
        this.f9944l = i3;
    }

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z2, boolean z3, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(legacyTextFieldState, textFieldSelectionManager, (i4 & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null) : textFieldValue, (i4 & 8) != 0 ? true : z2, (i4 & 16) != 0 ? false : z3, textPreparedSelectionState, (i4 & 64) != 0 ? OffsetMapping.f29394a.a() : offsetMapping, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : undoManager, deadKeyCombiner, (i4 & 512) != 0 ? KeyMapping_androidKt.a() : keyMapping, (i4 & 1024) != 0 ? new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldValue) obj);
                return Unit.f139807a;
            }

            public final void c(TextFieldValue textFieldValue2) {
            }
        } : function1, i3, null);
    }
}
