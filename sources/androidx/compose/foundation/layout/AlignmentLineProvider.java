package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public abstract class AlignmentLineProvider {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Block extends AlignmentLineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f6564a;

        public Block(Function1 function1) {
            super(null);
            this.f6564a = function1;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int a(Placeable placeable) {
            return ((Number) this.f6564a.invoke(placeable)).intValue();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Block) && Intrinsics.areEqual(this.f6564a, ((Block) obj).f6564a);
        }

        public int hashCode() {
            return this.f6564a.hashCode();
        }

        public String toString() {
            return "Block(lineProviderBlock=" + this.f6564a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Value extends AlignmentLineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlignmentLine f6565a;

        public Value(AlignmentLine alignmentLine) {
            super(null);
            this.f6565a = alignmentLine;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int a(Placeable placeable) {
            return placeable.p0(this.f6565a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && Intrinsics.areEqual(this.f6565a, ((Value) obj).f6565a);
        }

        public int hashCode() {
            return this.f6565a.hashCode();
        }

        public String toString() {
            return "Value(alignmentLine=" + this.f6565a + ')';
        }
    }

    public /* synthetic */ AlignmentLineProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int a(Placeable placeable);

    private AlignmentLineProvider() {
    }
}
