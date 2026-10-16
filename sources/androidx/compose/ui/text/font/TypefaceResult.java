package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface TypefaceResult extends State<Object> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Async implements TypefaceResult, State<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AsyncFontListLoader f29283a;

        public Async(AsyncFontListLoader asyncFontListLoader) {
            this.f29283a = asyncFontListLoader;
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.f29283a.getValue();
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean h() {
            return this.f29283a.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Immutable implements TypefaceResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f29284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29285b;

        public Immutable(Object obj, boolean z2) {
            this.f29284a = obj;
            this.f29285b = z2;
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.f29284a;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean h() {
            return this.f29285b;
        }

        public /* synthetic */ Immutable(Object obj, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i3 & 2) != 0 ? true : z2);
        }
    }

    boolean h();
}
