package cz.mobilesoft.coreblock.view.compose.slider;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class NumberedKeyboardButton {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Backspace extends NumberedKeyboardButton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Backspace f132026a = new Backspace();

        private Backspace() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DoubleZeroes extends NumberedKeyboardButton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoubleZeroes f132027a = new DoubleZeroes();

        private DoubleZeroes() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Number extends NumberedKeyboardButton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f132028a;

        public Number(int i3) {
            super(null);
            this.f132028a = i3;
        }

        public final int a() {
            return this.f132028a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Number) && this.f132028a == ((Number) obj).f132028a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f132028a);
        }

        public String toString() {
            return "Number(number=" + this.f132028a + ")";
        }
    }

    public /* synthetic */ NumberedKeyboardButton(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NumberedKeyboardButton() {
    }
}
