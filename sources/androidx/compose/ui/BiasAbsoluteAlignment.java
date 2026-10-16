package androidx.compose.ui;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
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
public final class BiasAbsoluteAlignment implements Alignment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25090c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Horizontal implements Alignment.Horizontal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f25091a;

        public Horizontal(float f3) {
            this.f25091a = f3;
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public int a(int i3, int i4, LayoutDirection layoutDirection) {
            return Math.round(((i4 - i3) / 2.0f) * (1 + this.f25091a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Horizontal) && Float.compare(this.f25091a, ((Horizontal) obj).f25091a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f25091a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.f25091a + ')';
        }
    }

    public BiasAbsoluteAlignment(float f3, float f4) {
        this.f25089b = f3;
        this.f25090c = f4;
    }

    @Override // androidx.compose.ui.Alignment
    public long a(long j3, long j4, LayoutDirection layoutDirection) {
        long jC = IntSize.c((((long) (((int) (j4 >> 32)) - ((int) (j3 >> 32)))) << 32) | (((long) (((int) (j4 & 4294967295L)) - ((int) (j3 & 4294967295L)))) & 4294967295L));
        float f3 = 1;
        return IntOffset.f((((long) Math.round((((int) (jC >> 32)) / 2.0f) * (this.f25089b + f3))) << 32) | (((long) Math.round((((int) (jC & 4294967295L)) / 2.0f) * (f3 + this.f25090c))) & 4294967295L));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiasAbsoluteAlignment)) {
            return false;
        }
        BiasAbsoluteAlignment biasAbsoluteAlignment = (BiasAbsoluteAlignment) obj;
        return Float.compare(this.f25089b, biasAbsoluteAlignment.f25089b) == 0 && Float.compare(this.f25090c, biasAbsoluteAlignment.f25090c) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f25089b) * 31) + Float.hashCode(this.f25090c);
    }

    public String toString() {
        return "BiasAbsoluteAlignment(horizontalBias=" + this.f25089b + ", verticalBias=" + this.f25090c + ')';
    }
}
