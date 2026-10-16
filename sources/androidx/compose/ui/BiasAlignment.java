package androidx.compose.ui;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
public final class BiasAlignment implements Alignment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25093c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Horizontal implements Alignment.Horizontal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f25094a;

        public Horizontal(float f3) {
            this.f25094a = f3;
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public int a(int i3, int i4, LayoutDirection layoutDirection) {
            return Math.round(((i4 - i3) / 2.0f) * (1 + (layoutDirection == LayoutDirection.f30001a ? this.f25094a : (-1) * this.f25094a)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Horizontal) && Float.compare(this.f25094a, ((Horizontal) obj).f25094a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f25094a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.f25094a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Vertical implements Alignment.Vertical {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f25095a;

        public Vertical(float f3) {
            this.f25095a = f3;
        }

        @Override // androidx.compose.ui.Alignment.Vertical
        public int a(int i3, int i4) {
            return Math.round(((i4 - i3) / 2.0f) * (1 + this.f25095a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Vertical) && Float.compare(this.f25095a, ((Vertical) obj).f25095a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f25095a);
        }

        public String toString() {
            return "Vertical(bias=" + this.f25095a + ')';
        }
    }

    public BiasAlignment(float f3, float f4) {
        this.f25092b = f3;
        this.f25093c = f4;
    }

    @Override // androidx.compose.ui.Alignment
    public long a(long j3, long j4, LayoutDirection layoutDirection) {
        float f3 = (((int) (j4 >> 32)) - ((int) (j3 >> 32))) / 2.0f;
        float f4 = (((int) (j4 & 4294967295L)) - ((int) (j3 & 4294967295L))) / 2.0f;
        float f5 = 1;
        return IntOffset.f((((long) Math.round(f3 * ((layoutDirection == LayoutDirection.f30001a ? this.f25092b : (-1) * this.f25092b) + f5))) << 32) | (((long) Math.round(f4 * (f5 + this.f25093c))) & 4294967295L));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiasAlignment)) {
            return false;
        }
        BiasAlignment biasAlignment = (BiasAlignment) obj;
        return Float.compare(this.f25092b, biasAlignment.f25092b) == 0 && Float.compare(this.f25093c, biasAlignment.f25093c) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f25092b) * 31) + Float.hashCode(this.f25093c);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.f25092b + ", verticalBias=" + this.f25093c + ')';
    }
}
