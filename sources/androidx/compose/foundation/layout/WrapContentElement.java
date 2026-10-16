package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f7308g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Direction f7309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f7311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7312d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f7313f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WrapContentElement a(final Alignment.Vertical vertical, boolean z2) {
            return new WrapContentElement(Direction.f6756a, z2, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$height$1
                {
                    super(2);
                }

                public final long c(long j3, LayoutDirection layoutDirection) {
                    return IntOffset.f((((long) 0) << 32) | (4294967295L & ((long) vertical.a(0, (int) (j3 & 4294967295L)))));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.c(c(((IntSize) obj).j(), (LayoutDirection) obj2));
                }
            }, vertical, "wrapContentHeight");
        }

        public final WrapContentElement b(final Alignment alignment, boolean z2) {
            return new WrapContentElement(Direction.f6758c, z2, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$size$1
                {
                    super(2);
                }

                public final long c(long j3, LayoutDirection layoutDirection) {
                    return alignment.a(IntSize.f29998b.a(), j3, layoutDirection);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.c(c(((IntSize) obj).j(), (LayoutDirection) obj2));
                }
            }, alignment, "wrapContentSize");
        }

        public final WrapContentElement c(final Alignment.Horizontal horizontal, boolean z2) {
            return new WrapContentElement(Direction.f6757b, z2, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
                {
                    super(2);
                }

                public final long c(long j3, LayoutDirection layoutDirection) {
                    return IntOffset.f((((long) 0) & 4294967295L) | (((long) horizontal.a(0, (int) (j3 >> 32), layoutDirection)) << 32));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.c(c(((IntSize) obj).j(), (LayoutDirection) obj2));
                }
            }, horizontal, "wrapContentWidth");
        }

        private Companion() {
        }
    }

    public WrapContentElement(Direction direction, boolean z2, Function2 function2, Object obj, String str) {
        this.f7309a = direction;
        this.f7310b = z2;
        this.f7311c = function2;
        this.f7312d = obj;
        this.f7313f = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WrapContentNode create() {
        return new WrapContentNode(this.f7309a, this.f7310b, this.f7311c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(WrapContentNode wrapContentNode) {
        wrapContentNode.o2(this.f7309a);
        wrapContentNode.p2(this.f7310b);
        wrapContentNode.n2(this.f7311c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.f7309a == wrapContentElement.f7309a && this.f7310b == wrapContentElement.f7310b && Intrinsics.areEqual(this.f7312d, wrapContentElement.f7312d);
    }

    public int hashCode() {
        return (((this.f7309a.hashCode() * 31) + Boolean.hashCode(this.f7310b)) * 31) + this.f7312d.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d(this.f7313f);
        inspectorInfo.b().c("align", this.f7312d);
        inspectorInfo.b().c("unbounded", Boolean.valueOf(this.f7310b));
    }
}
