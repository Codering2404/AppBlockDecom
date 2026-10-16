package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@LayoutScopeMarker
@Metadata
public final class ConstraintLayoutScope extends ConstraintLayoutBaseScope {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f30496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConstrainedLayoutReferences f30497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f30498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f30499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayList f30500j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ConstrainAsModifier extends InspectorValueInfo implements ParentDataModifier {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConstrainedLayoutReference f30501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function1 f30502c;

        public ConstrainAsModifier(final ConstrainedLayoutReference constrainedLayoutReference, final Function1 function1) {
            super(InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(InspectorInfo inspectorInfo) {
                    inspectorInfo.d("constrainAs");
                    inspectorInfo.b().c("ref", constrainedLayoutReference);
                    inspectorInfo.b().c("constrainBlock", function1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((InspectorInfo) obj);
                    return Unit.f139807a;
                }
            } : InspectableValueKt.a());
            this.f30501b = constrainedLayoutReference;
            this.f30502c = function1;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ConstraintLayoutParentData H(Density density, Object obj) {
            return new ConstraintLayoutParentData(this.f30501b, this.f30502c);
        }

        public boolean equals(Object obj) {
            Function1 function1 = this.f30502c;
            ConstrainAsModifier constrainAsModifier = obj instanceof ConstrainAsModifier ? (ConstrainAsModifier) obj : null;
            return function1 == (constrainAsModifier != null ? constrainAsModifier.f30502c : null);
        }

        public int hashCode() {
            return this.f30502c.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ConstrainedLayoutReferences {
        public ConstrainedLayoutReferences() {
        }

        public final ConstrainedLayoutReference a() {
            return ConstraintLayoutScope.this.m();
        }

        public final ConstrainedLayoutReference b() {
            return ConstraintLayoutScope.this.m();
        }

        public final ConstrainedLayoutReference c() {
            return ConstraintLayoutScope.this.m();
        }

        public final ConstrainedLayoutReference d() {
            return ConstraintLayoutScope.this.m();
        }
    }

    public ConstraintLayoutScope() {
        super(null);
        this.f30499i = this.f30498h;
        this.f30500j = new ArrayList();
    }

    @Override // androidx.constraintlayout.compose.ConstraintLayoutBaseScope
    public void j() {
        super.j();
        this.f30499i = this.f30498h;
    }

    public final Modifier l(Modifier modifier, ConstrainedLayoutReference constrainedLayoutReference, Function1 function1) {
        if (this.f30496f) {
            function1.invoke(new ConstrainScope(constrainedLayoutReference.a(), b(constrainedLayoutReference)));
        }
        return modifier.then(new ConstrainAsModifier(constrainedLayoutReference, function1));
    }

    public final ConstrainedLayoutReference m() {
        ArrayList arrayList = this.f30500j;
        int i3 = this.f30499i;
        this.f30499i = i3 + 1;
        ConstrainedLayoutReference constrainedLayoutReference = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList, i3);
        if (constrainedLayoutReference != null) {
            return constrainedLayoutReference;
        }
        ConstrainedLayoutReference constrainedLayoutReference2 = new ConstrainedLayoutReference(Integer.valueOf(this.f30499i));
        this.f30500j.add(constrainedLayoutReference2);
        return constrainedLayoutReference2;
    }

    public final ConstrainedLayoutReferences n() {
        ConstrainedLayoutReferences constrainedLayoutReferences = this.f30497g;
        if (constrainedLayoutReferences != null) {
            return constrainedLayoutReferences;
        }
        ConstrainedLayoutReferences constrainedLayoutReferences2 = new ConstrainedLayoutReferences();
        this.f30497g = constrainedLayoutReferences2;
        return constrainedLayoutReferences2;
    }
}
