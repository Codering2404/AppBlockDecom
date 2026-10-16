package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.google.android.gms.common.api.Api;
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
public interface TextFieldLineLimits {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f10143a = Companion.f10144a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f10144a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final TextFieldLineLimits f10145b;

        static {
            int i3 = 0;
            f10145b = new MultiLine(i3, i3, 3, null);
        }

        private Companion() {
        }

        public final TextFieldLineLimits a() {
            return f10145b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SingleLine implements TextFieldLineLimits {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SingleLine f10148b = new SingleLine();

        private SingleLine() {
        }

        public String toString() {
            return "TextFieldLineLimits.SingleLine";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MultiLine implements TextFieldLineLimits {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10147c;

        public MultiLine(int i3, int i4) {
            this.f10146b = i3;
            this.f10147c = i4;
            boolean z2 = false;
            if (1 <= i3 && i3 <= i4) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            InlineClassHelperKt.a("Expected 1 ≤ minHeightInLines ≤ maxHeightInLines, were " + i3 + ", " + i4);
        }

        public final int a() {
            return this.f10147c;
        }

        public final int b() {
            return this.f10146b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MultiLine.class != obj.getClass()) {
                return false;
            }
            MultiLine multiLine = (MultiLine) obj;
            return this.f10146b == multiLine.f10146b && this.f10147c == multiLine.f10147c;
        }

        public int hashCode() {
            return (this.f10146b * 31) + this.f10147c;
        }

        public String toString() {
            return "MultiLine(minHeightInLines=" + this.f10146b + ", maxHeightInLines=" + this.f10147c + ')';
        }

        public /* synthetic */ MultiLine(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 1 : i3, (i5 & 2) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i4);
        }
    }
}
