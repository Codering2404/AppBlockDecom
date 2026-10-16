package androidx.constraintlayout.compose;

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;

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
public final class ConstrainedLayoutReference extends LayoutReference {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f30413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.VerticalAnchor f30414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.VerticalAnchor f30415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.HorizontalAnchor f30416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.VerticalAnchor f30417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.VerticalAnchor f30418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.HorizontalAnchor f30419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ConstraintLayoutBaseScope.BaselineAnchor f30420j;

    public ConstrainedLayoutReference(Object obj) {
        super(obj);
        this.f30413c = obj;
        this.f30414d = new ConstraintLayoutBaseScope.VerticalAnchor(a(), -2, this);
        this.f30415e = new ConstraintLayoutBaseScope.VerticalAnchor(a(), 0, this);
        this.f30416f = new ConstraintLayoutBaseScope.HorizontalAnchor(a(), 0, this);
        this.f30417g = new ConstraintLayoutBaseScope.VerticalAnchor(a(), -1, this);
        this.f30418h = new ConstraintLayoutBaseScope.VerticalAnchor(a(), 1, this);
        this.f30419i = new ConstraintLayoutBaseScope.HorizontalAnchor(a(), 1, this);
        this.f30420j = new ConstraintLayoutBaseScope.BaselineAnchor(a(), this);
    }

    @Override // androidx.constraintlayout.compose.LayoutReference
    public Object a() {
        return this.f30413c;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor b() {
        return this.f30419i;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor c() {
        return this.f30417g;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor d() {
        return this.f30414d;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor e() {
        return this.f30416f;
    }
}
