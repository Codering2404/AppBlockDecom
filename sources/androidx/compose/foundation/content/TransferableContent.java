package androidx.compose.foundation.content;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
public final class TransferableContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClipEntry f5201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClipMetadata f5202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PlatformTransferableContent f5204d;

    public /* synthetic */ TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata, int i3, PlatformTransferableContent platformTransferableContent, DefaultConstructorMarker defaultConstructorMarker) {
        this(clipEntry, clipMetadata, i3, platformTransferableContent);
    }

    public final ClipEntry a() {
        return this.f5201a;
    }

    private TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata, int i3, PlatformTransferableContent platformTransferableContent) {
        this.f5201a = clipEntry;
        this.f5202b = clipMetadata;
        this.f5203c = i3;
        this.f5204d = platformTransferableContent;
    }

    public /* synthetic */ TransferableContent(ClipEntry clipEntry, ClipMetadata clipMetadata, int i3, PlatformTransferableContent platformTransferableContent, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(clipEntry, clipMetadata, i3, (i4 & 8) != 0 ? null : platformTransferableContent, null);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Source {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f5205b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f5206c = d(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f5207d = d(1);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f5208e = d(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5209a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Source.f5208e;
            }

            public final int b() {
                return Source.f5207d;
            }

            public final int c() {
                return Source.f5206c;
            }

            private Companion() {
            }
        }

        public static boolean e(int i3, Object obj) {
            return (obj instanceof Source) && i3 == ((Source) obj).i();
        }

        public static final boolean f(int i3, int i4) {
            return i3 == i4;
        }

        public static int g(int i3) {
            return Integer.hashCode(i3);
        }

        public static String h(int i3) {
            if (f(i3, f5206c)) {
                return "Source.Keyboard";
            }
            if (f(i3, f5207d)) {
                return "Source.DragAndDrop";
            }
            if (f(i3, f5208e)) {
                return "Source.Clipboard";
            }
            return "Invalid (" + i3 + ')';
        }

        public boolean equals(Object obj) {
            return e(this.f5209a, obj);
        }

        public int hashCode() {
            return g(this.f5209a);
        }

        public final /* synthetic */ int i() {
            return this.f5209a;
        }

        public String toString() {
            return h(this.f5209a);
        }

        public static int d(int i3) {
            return i3;
        }
    }
}
