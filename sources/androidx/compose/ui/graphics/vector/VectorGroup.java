package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class VectorGroup extends VectorNode implements Iterable<VectorNode>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f26515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f26516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f26517d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f26518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f26519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f26520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f26521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f26522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f26523k;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorGroup$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<VectorNode>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f26524a;

        AnonymousClass1(VectorGroup vectorGroup) {
            this.f26524a = vectorGroup.f26523k.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VectorNode next() {
            return (VectorNode) this.f26524a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26524a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public VectorGroup(String str, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list, List list2) {
        super(null);
        this.f26514a = str;
        this.f26515b = f3;
        this.f26516c = f4;
        this.f26517d = f5;
        this.f26518f = f6;
        this.f26519g = f7;
        this.f26520h = f8;
        this.f26521i = f9;
        this.f26522j = list;
        this.f26523k = list2;
    }

    public final VectorNode b(int i3) {
        return (VectorNode) this.f26523k.get(i3);
    }

    public final List d() {
        return this.f26522j;
    }

    public final String e() {
        return this.f26514a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof VectorGroup)) {
            VectorGroup vectorGroup = (VectorGroup) obj;
            return Intrinsics.areEqual(this.f26514a, vectorGroup.f26514a) && this.f26515b == vectorGroup.f26515b && this.f26516c == vectorGroup.f26516c && this.f26517d == vectorGroup.f26517d && this.f26518f == vectorGroup.f26518f && this.f26519g == vectorGroup.f26519g && this.f26520h == vectorGroup.f26520h && this.f26521i == vectorGroup.f26521i && Intrinsics.areEqual(this.f26522j, vectorGroup.f26522j) && Intrinsics.areEqual(this.f26523k, vectorGroup.f26523k);
        }
        return false;
    }

    public final float f() {
        return this.f26516c;
    }

    public final float g() {
        return this.f26517d;
    }

    public final float h() {
        return this.f26515b;
    }

    public int hashCode() {
        return (((((((((((((((((this.f26514a.hashCode() * 31) + Float.hashCode(this.f26515b)) * 31) + Float.hashCode(this.f26516c)) * 31) + Float.hashCode(this.f26517d)) * 31) + Float.hashCode(this.f26518f)) * 31) + Float.hashCode(this.f26519g)) * 31) + Float.hashCode(this.f26520h)) * 31) + Float.hashCode(this.f26521i)) * 31) + this.f26522j.hashCode()) * 31) + this.f26523k.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<VectorNode> iterator() {
        return new AnonymousClass1(this);
    }

    public final float l() {
        return this.f26518f;
    }

    public final float n() {
        return this.f26519g;
    }

    public final int o() {
        return this.f26523k.size();
    }

    public final float p() {
        return this.f26520h;
    }

    public final float q() {
        return this.f26521i;
    }
}
