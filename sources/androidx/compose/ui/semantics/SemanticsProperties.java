package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.text.AnnotatedString;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class SemanticsProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SemanticsProperties f28517a = new SemanticsProperties();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f28518b = SemanticsPropertiesKt.b("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list, List list2) {
            List mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SemanticsPropertyKey f28519c = SemanticsPropertiesKt.a("StateDescription");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SemanticsPropertyKey f28520d = SemanticsPropertiesKt.a("ProgressBarRangeInfo");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SemanticsPropertyKey f28521e = SemanticsPropertiesKt.b("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SemanticsPropertyKey f28522f = SemanticsPropertiesKt.a("SelectableGroup");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SemanticsPropertyKey f28523g = SemanticsPropertiesKt.a("CollectionInfo");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SemanticsPropertyKey f28524h = SemanticsPropertiesKt.a("CollectionItemInfo");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SemanticsPropertyKey f28525i = SemanticsPropertiesKt.a("Heading");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final SemanticsPropertyKey f28526j = SemanticsPropertiesKt.a("Disabled");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final SemanticsPropertyKey f28527k = SemanticsPropertiesKt.a("LiveRegion");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final SemanticsPropertyKey f28528l = SemanticsPropertiesKt.a("Focused");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final SemanticsPropertyKey f28529m = SemanticsPropertiesKt.a("IsContainer");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final SemanticsPropertyKey f28530n = new SemanticsPropertyKey("IsTraversalGroup", null, 2, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final SemanticsPropertyKey f28531o = new SemanticsPropertyKey("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final SemanticsPropertyKey f28532p = new SemanticsPropertyKey("HideFromAccessibility", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$HideFromAccessibility$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final SemanticsPropertyKey f28533q = new SemanticsPropertyKey("ContentType", new Function2<ContentType, ContentType, ContentType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ContentType invoke(ContentType contentType, ContentType contentType2) {
            return contentType;
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final SemanticsPropertyKey f28534r = new SemanticsPropertyKey("ContentDataType", new Function2<ContentDataType, ContentDataType, ContentDataType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ContentDataType invoke(ContentDataType contentDataType, ContentDataType contentDataType2) {
            return contentDataType;
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final SemanticsPropertyKey f28535s = new SemanticsPropertyKey("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((Float) obj, ((Number) obj2).floatValue());
        }

        public final Float c(Float f3, float f4) {
            return f3;
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final SemanticsPropertyKey f28536t = SemanticsPropertiesKt.a("HorizontalScrollAxisRange");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final SemanticsPropertyKey f28537u = SemanticsPropertiesKt.a("VerticalScrollAxisRange");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final SemanticsPropertyKey f28538v = SemanticsPropertiesKt.b("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final SemanticsPropertyKey f28539w = SemanticsPropertiesKt.b("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final SemanticsPropertyKey f28540x = SemanticsPropertiesKt.b("Role", new Function2<Role, Role, Role>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((Role) obj, ((Role) obj2).p());
        }

        public final Role c(Role role, int i3) {
            return role;
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final SemanticsPropertyKey f28541y = new SemanticsPropertyKey("TestTag", false, new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, String str2) {
            return str;
        }
    });

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final SemanticsPropertyKey f28542z = new SemanticsPropertyKey("LinkTestMarker", false, new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$LinkTestMarker$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });
    private static final SemanticsPropertyKey A = SemanticsPropertiesKt.b("Text", new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list, List list2) {
            List mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });
    private static final SemanticsPropertyKey B = new SemanticsPropertyKey("TextSubstitution", null, 2, null);
    private static final SemanticsPropertyKey C = new SemanticsPropertyKey("IsShowingTextSubstitution", null, 2, null);
    private static final SemanticsPropertyKey D = SemanticsPropertiesKt.a("InputText");
    private static final SemanticsPropertyKey E = SemanticsPropertiesKt.a("EditableText");
    private static final SemanticsPropertyKey F = SemanticsPropertiesKt.a("TextSelectionRange");
    private static final SemanticsPropertyKey G = SemanticsPropertiesKt.a("ImeAction");
    private static final SemanticsPropertyKey H = SemanticsPropertiesKt.a("Selected");
    private static final SemanticsPropertyKey I = SemanticsPropertiesKt.a("ToggleableState");
    private static final SemanticsPropertyKey J = SemanticsPropertiesKt.a("Password");
    private static final SemanticsPropertyKey K = SemanticsPropertiesKt.a("Error");
    private static final SemanticsPropertyKey L = new SemanticsPropertyKey("IndexForKey", null, 2, null);
    private static final SemanticsPropertyKey M = new SemanticsPropertyKey("IsEditable", null, 2, null);
    private static final SemanticsPropertyKey N = new SemanticsPropertyKey("MaxTextLength", null, 2, null);
    public static final int O = 8;

    private SemanticsProperties() {
    }

    public final SemanticsPropertyKey A() {
        return J;
    }

    public final SemanticsPropertyKey B() {
        return f28520d;
    }

    public final SemanticsPropertyKey C() {
        return f28540x;
    }

    public final SemanticsPropertyKey D() {
        return f28522f;
    }

    public final SemanticsPropertyKey E() {
        return H;
    }

    public final SemanticsPropertyKey F() {
        return f28519c;
    }

    public final SemanticsPropertyKey G() {
        return f28541y;
    }

    public final SemanticsPropertyKey H() {
        return A;
    }

    public final SemanticsPropertyKey I() {
        return F;
    }

    public final SemanticsPropertyKey J() {
        return B;
    }

    public final SemanticsPropertyKey K() {
        return I;
    }

    public final SemanticsPropertyKey L() {
        return f28535s;
    }

    public final SemanticsPropertyKey M() {
        return f28537u;
    }

    public final SemanticsPropertyKey a() {
        return f28523g;
    }

    public final SemanticsPropertyKey b() {
        return f28524h;
    }

    public final SemanticsPropertyKey c() {
        return f28534r;
    }

    public final SemanticsPropertyKey d() {
        return f28518b;
    }

    public final SemanticsPropertyKey e() {
        return f28533q;
    }

    public final SemanticsPropertyKey f() {
        return f28526j;
    }

    public final SemanticsPropertyKey g() {
        return E;
    }

    public final SemanticsPropertyKey h() {
        return K;
    }

    public final SemanticsPropertyKey i() {
        return f28528l;
    }

    public final SemanticsPropertyKey j() {
        return f28525i;
    }

    public final SemanticsPropertyKey k() {
        return f28532p;
    }

    public final SemanticsPropertyKey l() {
        return f28536t;
    }

    public final SemanticsPropertyKey m() {
        return G;
    }

    public final SemanticsPropertyKey n() {
        return L;
    }

    public final SemanticsPropertyKey o() {
        return D;
    }

    public final SemanticsPropertyKey p() {
        return f28531o;
    }

    public final SemanticsPropertyKey q() {
        return f28529m;
    }

    public final SemanticsPropertyKey r() {
        return f28539w;
    }

    public final SemanticsPropertyKey s() {
        return M;
    }

    public final SemanticsPropertyKey t() {
        return f28538v;
    }

    public final SemanticsPropertyKey u() {
        return C;
    }

    public final SemanticsPropertyKey v() {
        return f28530n;
    }

    public final SemanticsPropertyKey w() {
        return f28542z;
    }

    public final SemanticsPropertyKey x() {
        return f28527k;
    }

    public final SemanticsPropertyKey y() {
        return N;
    }

    public final SemanticsPropertyKey z() {
        return f28521e;
    }
}
