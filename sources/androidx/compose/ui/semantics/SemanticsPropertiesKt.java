package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SemanticsPropertiesKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f28560a = {Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.e(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};

    static {
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        semanticsProperties.F();
        semanticsProperties.B();
        semanticsProperties.z();
        semanticsProperties.x();
        semanticsProperties.i();
        semanticsProperties.q();
        semanticsProperties.v();
        semanticsProperties.e();
        semanticsProperties.c();
        semanticsProperties.L();
        semanticsProperties.l();
        semanticsProperties.M();
        semanticsProperties.C();
        semanticsProperties.G();
        semanticsProperties.J();
        semanticsProperties.u();
        semanticsProperties.o();
        semanticsProperties.g();
        semanticsProperties.I();
        semanticsProperties.m();
        semanticsProperties.E();
        semanticsProperties.a();
        semanticsProperties.b();
        semanticsProperties.K();
        semanticsProperties.s();
        semanticsProperties.y();
        SemanticsActions.f28471a.d();
    }

    public static final void A(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.l(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void A0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        z0(semanticsPropertyReceiver, str, function1);
    }

    public static /* synthetic */ void B(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        A(semanticsPropertyReceiver, str, function0);
    }

    public static final void B0(SemanticsPropertyReceiver semanticsPropertyReceiver, long j3) {
        SemanticsProperties.f28517a.I().d(semanticsPropertyReceiver, f28560a[18], TextRange.b(j3));
    }

    public static final void C(SemanticsPropertyReceiver semanticsPropertyReceiver, int i3, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.m(), ImeAction.j(i3));
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.m(), new AccessibilityAction(str, function0));
    }

    public static final void C0(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.f28517a.J().d(semanticsPropertyReceiver, f28560a[14], annotatedString);
    }

    public static /* synthetic */ void D(SemanticsPropertyReceiver semanticsPropertyReceiver, int i3, String str, Function0 function0, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        C(semanticsPropertyReceiver, i3, str, function0);
    }

    public static final void D0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.A(), new AccessibilityAction(str, function1));
    }

    public static final void E(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.n(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void E0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        D0(semanticsPropertyReceiver, str, function1);
    }

    public static /* synthetic */ void F(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        E(semanticsPropertyReceiver, str, function0);
    }

    public static final void F0(SemanticsPropertyReceiver semanticsPropertyReceiver, ToggleableState toggleableState) {
        SemanticsProperties.f28517a.K().d(semanticsPropertyReceiver, f28560a[23], toggleableState);
    }

    public static final void G(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.o(), new AccessibilityAction(str, function0));
    }

    public static final void G0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.v().d(semanticsPropertyReceiver, f28560a[6], Boolean.valueOf(z2));
    }

    public static /* synthetic */ void H(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        G(semanticsPropertyReceiver, str, function0);
    }

    public static final void H0(SemanticsPropertyReceiver semanticsPropertyReceiver, float f3) {
        SemanticsProperties.f28517a.L().d(semanticsPropertyReceiver, f28560a[9], Float.valueOf(f3));
    }

    public static final void I(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.p(), new AccessibilityAction(str, function0));
    }

    public static final void I0(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.f28517a.M().d(semanticsPropertyReceiver, f28560a[11], scrollAxisRange);
    }

    public static /* synthetic */ void J(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        I(semanticsPropertyReceiver, str, function0);
    }

    public static final void J0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.B(), new AccessibilityAction(str, function1));
    }

    public static final void K(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.q(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void K0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        J0(semanticsPropertyReceiver, str, function1);
    }

    public static /* synthetic */ void L(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        K(semanticsPropertyReceiver, str, function0);
    }

    public static final void M(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.r(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void N(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        M(semanticsPropertyReceiver, str, function0);
    }

    public static final void O(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.A(), Unit.f139807a);
    }

    public static final void P(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.s(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void Q(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        P(semanticsPropertyReceiver, str, function0);
    }

    public static final void R(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.t(), Unit.f139807a);
    }

    public static final void S(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.t(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void T(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        S(semanticsPropertyReceiver, str, function0);
    }

    public static final void U(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.u(), new AccessibilityAction(str, function2));
    }

    public static /* synthetic */ void V(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        U(semanticsPropertyReceiver, str, function2);
    }

    public static final void W(SemanticsPropertyReceiver semanticsPropertyReceiver, Function2 function2) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.v(), function2);
    }

    public static final void X(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.w(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void Y(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        X(semanticsPropertyReceiver, str, function1);
    }

    public static final void Z(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.D(), Unit.f139807a);
    }

    public static final SemanticsPropertyKey a(String str) {
        return new SemanticsPropertyKey(str, true);
    }

    public static final void a0(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionInfo collectionInfo) {
        SemanticsProperties.f28517a.a().d(semanticsPropertyReceiver, f28560a[21], collectionInfo);
    }

    public static final SemanticsPropertyKey b(String str, Function2 function2) {
        return new SemanticsPropertyKey(str, true, function2);
    }

    public static final void b0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.q().d(semanticsPropertyReceiver, f28560a[5], Boolean.valueOf(z2));
    }

    public static final void c(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.a(), new AccessibilityAction(str, function0));
    }

    public static final void c0(SemanticsPropertyReceiver semanticsPropertyReceiver, ContentDataType contentDataType) {
        SemanticsProperties.f28517a.c().d(semanticsPropertyReceiver, f28560a[8], contentDataType);
    }

    public static /* synthetic */ void d(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        c(semanticsPropertyReceiver, str, function0);
    }

    public static final void d0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.d(), CollectionsKt.listOf(str));
    }

    public static final void e(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.b(), new AccessibilityAction(str, function0));
    }

    public static final void e0(SemanticsPropertyReceiver semanticsPropertyReceiver, ContentType contentType) {
        SemanticsProperties.f28517a.e().d(semanticsPropertyReceiver, f28560a[7], contentType);
    }

    public static /* synthetic */ void f(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        e(semanticsPropertyReceiver, str, function0);
    }

    public static final void f0(SemanticsPropertyReceiver semanticsPropertyReceiver, List list) {
        SemanticsActions.f28471a.d().d(semanticsPropertyReceiver, f28560a[26], list);
    }

    public static final void g(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.c(), new AccessibilityAction(str, function0));
    }

    public static final void g0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.s().d(semanticsPropertyReceiver, f28560a[24], Boolean.valueOf(z2));
    }

    public static /* synthetic */ void h(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        g(semanticsPropertyReceiver, str, function0);
    }

    public static final void h0(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.f28517a.g().d(semanticsPropertyReceiver, f28560a[17], annotatedString);
    }

    public static final void i(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.e(), new AccessibilityAction(str, function0));
    }

    public static final void i0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.i().d(semanticsPropertyReceiver, f28560a[4], Boolean.valueOf(z2));
    }

    public static /* synthetic */ void j(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        i(semanticsPropertyReceiver, str, function0);
    }

    public static final void j0(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.f28517a.l().d(semanticsPropertyReceiver, f28560a[10], scrollAxisRange);
    }

    public static final void k(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.r(), Unit.f139807a);
    }

    public static final void k0(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.f28517a.o().d(semanticsPropertyReceiver, f28560a[16], annotatedString);
    }

    public static final void l(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.f(), Unit.f139807a);
    }

    public static final void l0(SemanticsPropertyReceiver semanticsPropertyReceiver, int i3) {
        SemanticsProperties.f28517a.x().d(semanticsPropertyReceiver, f28560a[3], LiveRegionMode.c(i3));
    }

    public static final void m(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.f(), new AccessibilityAction(str, function0));
    }

    public static final void m0(SemanticsPropertyReceiver semanticsPropertyReceiver, int i3) {
        SemanticsProperties.f28517a.y().d(semanticsPropertyReceiver, f28560a[25], Integer.valueOf(i3));
    }

    public static /* synthetic */ void n(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        m(semanticsPropertyReceiver, str, function0);
    }

    public static final void n0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.f28517a.z().d(semanticsPropertyReceiver, f28560a[2], str);
    }

    public static final void o(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.h(), str);
    }

    public static final void o0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.x(), new AccessibilityAction(str, function1));
    }

    public static final void p(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.g(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void p0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        o0(semanticsPropertyReceiver, str, function1);
    }

    public static /* synthetic */ void q(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        p(semanticsPropertyReceiver, str, function0);
    }

    public static final void q0(SemanticsPropertyReceiver semanticsPropertyReceiver, ProgressBarRangeInfo progressBarRangeInfo) {
        SemanticsProperties.f28517a.B().d(semanticsPropertyReceiver, f28560a[1], progressBarRangeInfo);
    }

    public static final void r(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, final Function0 function0) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.h(), new AccessibilityAction(str, new Function1<List<Float>, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$getScrollViewportLength$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List list) {
                boolean z2;
                Float f3 = (Float) function0.invoke();
                if (f3 == null) {
                    z2 = false;
                } else {
                    list.add(f3);
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        }));
    }

    public static final void r0(SemanticsPropertyReceiver semanticsPropertyReceiver, int i3) {
        SemanticsProperties.f28517a.C().d(semanticsPropertyReceiver, f28560a[12], Role.j(i3));
    }

    public static /* synthetic */ void s(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        r(semanticsPropertyReceiver, str, function0);
    }

    public static final void s0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.E().d(semanticsPropertyReceiver, f28560a[20], Boolean.valueOf(z2));
    }

    public static final void t(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.i(), new AccessibilityAction(str, function1));
    }

    public static final void t0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.y(), new AccessibilityAction(str, function3));
    }

    public static /* synthetic */ void u(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        t(semanticsPropertyReceiver, str, function1);
    }

    public static /* synthetic */ void u0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        t0(semanticsPropertyReceiver, str, function3);
    }

    public static final void v(SemanticsPropertyReceiver semanticsPropertyReceiver, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.n(), function1);
    }

    public static final void v0(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z2) {
        SemanticsProperties.f28517a.u().d(semanticsPropertyReceiver, f28560a[15], Boolean.valueOf(z2));
    }

    public static final void w(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.j(), new AccessibilityAction(str, function1));
    }

    public static final void w0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.f28517a.F().d(semanticsPropertyReceiver, f28560a[0], str);
    }

    public static /* synthetic */ void x(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        w(semanticsPropertyReceiver, str, function1);
    }

    public static final void x0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.f28517a.G().d(semanticsPropertyReceiver, f28560a[13], str);
    }

    public static final void y(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.k(), new AccessibilityAction(str, function1));
    }

    public static final void y0(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        semanticsPropertyReceiver.a(SemanticsProperties.f28517a.H(), CollectionsKt.listOf(annotatedString));
    }

    public static /* synthetic */ void z(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        y(semanticsPropertyReceiver, str, function1);
    }

    public static final void z0(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1) {
        semanticsPropertyReceiver.a(SemanticsActions.f28471a.z(), new AccessibilityAction(str, function1));
    }
}
