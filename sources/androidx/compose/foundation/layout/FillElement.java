package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class FillElement extends ModifierNodeElement<FillNode> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f6766d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Direction f6767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6769c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FillElement a(float f3) {
            return new FillElement(Direction.f6756a, f3, "fillMaxHeight");
        }

        public final FillElement b(float f3) {
            return new FillElement(Direction.f6758c, f3, "fillMaxSize");
        }

        public final FillElement c(float f3) {
            return new FillElement(Direction.f6757b, f3, "fillMaxWidth");
        }

        private Companion() {
        }
    }

    public FillElement(Direction direction, float f3, String str) {
        this.f6767a = direction;
        this.f6768b = f3;
        this.f6769c = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FillNode create() {
        return new FillNode(this.f6767a, this.f6768b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(FillNode fillNode) {
        fillNode.m2(this.f6767a);
        fillNode.n2(this.f6768b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        return this.f6767a == fillElement.f6767a && this.f6768b == fillElement.f6768b;
    }

    public int hashCode() {
        return (this.f6767a.hashCode() * 31) + Float.hashCode(this.f6768b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d(this.f6769c);
        inspectorInfo.b().c("fraction", Float.valueOf(this.f6768b));
    }
}
