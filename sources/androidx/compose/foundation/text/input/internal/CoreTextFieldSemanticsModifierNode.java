package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.CoreTextFieldKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldDelegate;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class CoreTextFieldSemanticsModifierNode extends DelegatingNode implements SemanticsModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TransformedText f10265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextFieldValue f10266d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LegacyTextFieldState f10267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OffsetMapping f10271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextFieldSelectionManager f10272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImeOptions f10273l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private FocusRequester f10274m;

    public CoreTextFieldSemanticsModifierNode(TransformedText transformedText, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, boolean z2, boolean z3, boolean z4, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, FocusRequester focusRequester) {
        this.f10265c = transformedText;
        this.f10266d = textFieldValue;
        this.f10267f = legacyTextFieldState;
        this.f10268g = z2;
        this.f10269h = z3;
        this.f10270i = z4;
        this.f10271j = offsetMapping;
        this.f10272k = textFieldSelectionManager;
        this.f10273l = imeOptions;
        this.f10274m = focusRequester;
        textFieldSelectionManager.n0(new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m76invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m76invoke() {
                DelegatableNodeKt.i(CoreTextFieldSemanticsModifierNode.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(LegacyTextFieldState legacyTextFieldState, String str, boolean z2, boolean z3) {
        Unit unit;
        if (z2 || !z3) {
            return;
        }
        androidx.compose.ui.text.input.TextInputSession textInputSessionH = legacyTextFieldState.h();
        if (textInputSessionH != null) {
            TextFieldDelegate.f9925a.g(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(str, 1)}), legacyTextFieldState.p(), legacyTextFieldState.o(), textInputSessionH);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            legacyTextFieldState.o().invoke(new TextFieldValue(str, TextRangeKt.a(str.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
        }
    }

    public final void B2(TransformedText transformedText, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, boolean z2, boolean z3, boolean z4, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, FocusRequester focusRequester) {
        boolean z5 = this.f10269h;
        boolean z6 = false;
        boolean z7 = z5 && !this.f10268g;
        boolean z8 = this.f10270i;
        ImeOptions imeOptions2 = this.f10273l;
        TextFieldSelectionManager textFieldSelectionManager2 = this.f10272k;
        if (z3 && !z2) {
            z6 = true;
        }
        this.f10265c = transformedText;
        this.f10266d = textFieldValue;
        this.f10267f = legacyTextFieldState;
        this.f10268g = z2;
        this.f10269h = z3;
        this.f10271j = offsetMapping;
        this.f10272k = textFieldSelectionManager;
        this.f10273l = imeOptions;
        this.f10274m = focusRequester;
        if (z3 != z5 || z6 != z7 || !Intrinsics.areEqual(imeOptions, imeOptions2) || z4 != z8 || !TextRange.h(textFieldValue.h())) {
            SemanticsModifierNodeKt.b(this);
        }
        if (Intrinsics.areEqual(textFieldSelectionManager, textFieldSelectionManager2)) {
            return;
        }
        textFieldSelectionManager.n0(new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$updateNodeSemantics$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m77invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m77invoke() {
                DelegatableNodeKt.i(this.f10288a);
            }
        });
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.k0(semanticsPropertyReceiver, this.f10266d.f());
        SemanticsPropertiesKt.h0(semanticsPropertyReceiver, this.f10265c.b());
        SemanticsPropertiesKt.B0(semanticsPropertyReceiver, this.f10266d.h());
        SemanticsPropertiesKt.c0(semanticsPropertyReceiver, ContentDataType.f25250a.a());
        SemanticsPropertiesKt.z(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AnnotatedString annotatedString) {
                this.f10276a.y2().I(true);
                this.f10276a.y2().C(true);
                CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f10276a;
                coreTextFieldSemanticsModifierNode.A2(coreTextFieldSemanticsModifierNode.y2(), annotatedString.k(), this.f10276a.x2(), this.f10276a.t2());
                return Boolean.TRUE;
            }
        }, 1, null);
        if (!this.f10269h) {
            SemanticsPropertiesKt.l(semanticsPropertyReceiver);
        }
        if (this.f10270i) {
            SemanticsPropertiesKt.O(semanticsPropertyReceiver);
        }
        boolean z2 = this.f10269h && !this.f10268g;
        SemanticsPropertiesKt.g0(semanticsPropertyReceiver, z2);
        SemanticsPropertiesKt.u(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List list) {
                boolean z3;
                if (this.f10279a.y2().l() != null) {
                    TextLayoutResultProxy textLayoutResultProxyL = this.f10279a.y2().l();
                    Intrinsics.checkNotNull(textLayoutResultProxyL);
                    list.add(textLayoutResultProxyL.f());
                    z3 = true;
                } else {
                    z3 = false;
                }
                return Boolean.valueOf(z3);
            }
        }, 1, null);
        if (z2) {
            SemanticsPropertiesKt.A0(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(AnnotatedString annotatedString) {
                    CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f10280a;
                    coreTextFieldSemanticsModifierNode.A2(coreTextFieldSemanticsModifierNode.y2(), annotatedString.k(), this.f10280a.x2(), this.f10280a.t2());
                    return Boolean.TRUE;
                }
            }, 1, null);
            SemanticsPropertiesKt.x(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(AnnotatedString annotatedString) {
                    Unit unit;
                    if (this.f10281a.x2() || !this.f10281a.t2()) {
                        return Boolean.FALSE;
                    }
                    androidx.compose.ui.text.input.TextInputSession textInputSessionH = this.f10281a.y2().h();
                    if (textInputSessionH != null) {
                        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f10281a;
                        TextFieldDelegate.f9925a.g(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), coreTextFieldSemanticsModifierNode.y2().p(), coreTextFieldSemanticsModifierNode.y2().o(), textInputSessionH);
                        unit = Unit.f139807a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode2 = this.f10281a;
                        coreTextFieldSemanticsModifierNode2.y2().o().invoke(new TextFieldValue(StringsKt.O0(coreTextFieldSemanticsModifierNode2.z2().i(), TextRange.n(coreTextFieldSemanticsModifierNode2.z2().h()), TextRange.i(coreTextFieldSemanticsModifierNode2.z2().h()), annotatedString).toString(), TextRangeKt.a(TextRange.n(coreTextFieldSemanticsModifierNode2.z2().h()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                    }
                    return Boolean.TRUE;
                }
            }, 1, null);
        }
        SemanticsPropertiesKt.u0(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$5
            {
                super(3);
            }

            public final Boolean c(int i3, int i4, boolean z3) {
                if (!z3) {
                    i3 = this.f10283a.w2().a(i3);
                }
                if (!z3) {
                    i4 = this.f10283a.w2().a(i4);
                }
                boolean z4 = false;
                if (this.f10283a.t2() && (i3 != TextRange.n(this.f10283a.z2().h()) || i4 != TextRange.i(this.f10283a.z2().h()))) {
                    if (Math.min(i3, i4) < 0 || Math.max(i3, i4) > this.f10283a.z2().f().length()) {
                        this.f10283a.v2().z();
                    } else {
                        if (z3 || i3 == i4) {
                            this.f10283a.v2().z();
                        } else {
                            TextFieldSelectionManager.y(this.f10283a.v2(), false, 1, null);
                        }
                        this.f10283a.y2().o().invoke(new TextFieldValue(this.f10283a.z2().f(), TextRangeKt.b(i3, i4), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        z4 = true;
                    }
                }
                return Boolean.valueOf(z4);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.D(semanticsPropertyReceiver, this.f10273l.e(), null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f10284a.y2().n().invoke(ImeAction.j(this.f10284a.u2().e()));
                return Boolean.TRUE;
            }
        }, 2, null);
        SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                CoreTextFieldKt.q(this.f10285a.y2(), this.f10285a.k0(), !this.f10285a.x2());
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.F(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$8
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextFieldSelectionManager.y(this.f10286a.v2(), false, 1, null);
                return Boolean.TRUE;
            }
        }, 1, null);
        if (!TextRange.h(this.f10266d.h()) && !this.f10270i) {
            SemanticsPropertiesKt.h(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$9
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    TextFieldSelectionManager.r(this.f10287a.v2(), false, 1, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
            if (this.f10269h && !this.f10268g) {
                SemanticsPropertiesKt.j(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$10
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        this.f10277a.v2().u();
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        }
        if (!this.f10269h || this.f10268g) {
            return;
        }
        SemanticsPropertiesKt.Q(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode$applySemantics$11
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f10278a.v2().Z();
                return Boolean.TRUE;
            }
        }, 1, null);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean d2() {
        return true;
    }

    public final FocusRequester k0() {
        return this.f10274m;
    }

    public final boolean t2() {
        return this.f10269h;
    }

    public final ImeOptions u2() {
        return this.f10273l;
    }

    public final TextFieldSelectionManager v2() {
        return this.f10272k;
    }

    public final OffsetMapping w2() {
        return this.f10271j;
    }

    public final boolean x2() {
        return this.f10268g;
    }

    public final LegacyTextFieldState y2() {
        return this.f10267f;
    }

    public final TextFieldValue z2() {
        return this.f10266d;
    }
}
