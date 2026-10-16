package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
public final class SemanticsActions {
    private static final SemanticsPropertyKey A;
    private static final SemanticsPropertyKey B;
    private static final SemanticsPropertyKey C;
    private static final SemanticsPropertyKey D;
    public static final int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SemanticsActions f28471a = new SemanticsActions();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f28472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SemanticsPropertyKey f28473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SemanticsPropertyKey f28474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SemanticsPropertyKey f28475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SemanticsPropertyKey f28476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SemanticsPropertyKey f28477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SemanticsPropertyKey f28478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SemanticsPropertyKey f28479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final SemanticsPropertyKey f28480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final SemanticsPropertyKey f28481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final SemanticsPropertyKey f28482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final SemanticsPropertyKey f28483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final SemanticsPropertyKey f28484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final SemanticsPropertyKey f28485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final SemanticsPropertyKey f28486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final SemanticsPropertyKey f28487q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final SemanticsPropertyKey f28488r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final SemanticsPropertyKey f28489s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final SemanticsPropertyKey f28490t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final SemanticsPropertyKey f28491u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final SemanticsPropertyKey f28492v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final SemanticsPropertyKey f28493w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final SemanticsPropertyKey f28494x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final SemanticsPropertyKey f28495y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final SemanticsPropertyKey f28496z;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2<AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AccessibilityAction invoke(AccessibilityAction accessibilityAction, AccessibilityAction accessibilityAction2) {
                String strB;
                Function functionA;
                if (accessibilityAction == null || (strB = accessibilityAction.b()) == null) {
                    strB = accessibilityAction2.b();
                }
                if (accessibilityAction == null || (functionA = accessibilityAction.a()) == null) {
                    functionA = accessibilityAction2.a();
                }
                return new AccessibilityAction(strB, functionA);
            }
        };
        f28472b = SemanticsPropertiesKt.b("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        f28473c = SemanticsPropertiesKt.b("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f28474d = SemanticsPropertiesKt.b("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f28475e = SemanticsPropertiesKt.b("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        f28476f = new SemanticsPropertyKey("ScrollByOffset", null, 2, null);
        f28477g = SemanticsPropertiesKt.b("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        f28478h = SemanticsPropertiesKt.b("OnAutofillText", semanticsPropertiesKt$ActionPropertyKey$1);
        f28479i = SemanticsPropertiesKt.b("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        f28480j = SemanticsPropertiesKt.b("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        f28481k = SemanticsPropertiesKt.b("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        f28482l = SemanticsPropertiesKt.b("SetTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f28483m = SemanticsPropertiesKt.b("ShowTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f28484n = SemanticsPropertiesKt.b("ClearTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f28485o = SemanticsPropertiesKt.b("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        f28486p = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f28487q = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f28488r = SemanticsPropertiesKt.b("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        f28489s = SemanticsPropertiesKt.b("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        f28490t = SemanticsPropertiesKt.b("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        f28491u = SemanticsPropertiesKt.b("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        f28492v = SemanticsPropertiesKt.b("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        f28493w = SemanticsPropertiesKt.b("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        f28494x = SemanticsPropertiesKt.b("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        f28495y = SemanticsPropertiesKt.a("CustomActions");
        f28496z = SemanticsPropertiesKt.b("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        A = SemanticsPropertiesKt.b("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        B = SemanticsPropertiesKt.b("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        C = SemanticsPropertiesKt.b("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
        D = SemanticsPropertiesKt.b("GetScrollViewportLength", semanticsPropertiesKt$ActionPropertyKey$1);
        E = 8;
    }

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey A() {
        return f28482l;
    }

    public final SemanticsPropertyKey B() {
        return f28483m;
    }

    public final SemanticsPropertyKey a() {
        return f28484n;
    }

    public final SemanticsPropertyKey b() {
        return f28492v;
    }

    public final SemanticsPropertyKey c() {
        return f28488r;
    }

    public final SemanticsPropertyKey d() {
        return f28495y;
    }

    public final SemanticsPropertyKey e() {
        return f28489s;
    }

    public final SemanticsPropertyKey f() {
        return f28493w;
    }

    public final SemanticsPropertyKey g() {
        return f28491u;
    }

    public final SemanticsPropertyKey h() {
        return D;
    }

    public final SemanticsPropertyKey i() {
        return f28472b;
    }

    public final SemanticsPropertyKey j() {
        return f28485o;
    }

    public final SemanticsPropertyKey k() {
        return f28478h;
    }

    public final SemanticsPropertyKey l() {
        return f28473c;
    }

    public final SemanticsPropertyKey m() {
        return f28486p;
    }

    public final SemanticsPropertyKey n() {
        return f28474d;
    }

    public final SemanticsPropertyKey o() {
        return B;
    }

    public final SemanticsPropertyKey p() {
        return A;
    }

    public final SemanticsPropertyKey q() {
        return C;
    }

    public final SemanticsPropertyKey r() {
        return f28496z;
    }

    public final SemanticsPropertyKey s() {
        return f28490t;
    }

    public final SemanticsPropertyKey t() {
        return f28494x;
    }

    public final SemanticsPropertyKey u() {
        return f28475e;
    }

    public final SemanticsPropertyKey v() {
        return f28476f;
    }

    public final SemanticsPropertyKey w() {
        return f28477g;
    }

    public final SemanticsPropertyKey x() {
        return f28479i;
    }

    public final SemanticsPropertyKey y() {
        return f28480j;
    }

    public final SemanticsPropertyKey z() {
        return f28481k;
    }
}
