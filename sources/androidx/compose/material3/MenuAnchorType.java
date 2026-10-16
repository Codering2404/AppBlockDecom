package androidx.compose.material3;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
public final class MenuAnchorType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f18132b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f18133c = e("PrimaryNotEditable");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f18134d = e(jTYhJgqLBN.HsgRQOWu);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f18135e = e("SecondaryEditable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18136a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return MenuAnchorType.f18134d;
        }

        public final String b() {
            return MenuAnchorType.f18133c;
        }

        public final String c() {
            return MenuAnchorType.f18135e;
        }

        private Companion() {
        }
    }

    private /* synthetic */ MenuAnchorType(String str) {
        this.f18136a = str;
    }

    public static final /* synthetic */ MenuAnchorType d(String str) {
        return new MenuAnchorType(str);
    }

    private static String e(String str) {
        return str;
    }

    public static boolean f(String str, Object obj) {
        return (obj instanceof MenuAnchorType) && Intrinsics.areEqual(str, ((MenuAnchorType) obj).j());
    }

    public static final boolean g(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    public static int h(String str) {
        return str.hashCode();
    }

    public static String i(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        return f(this.f18136a, obj);
    }

    public int hashCode() {
        return h(this.f18136a);
    }

    public final /* synthetic */ String j() {
        return this.f18136a;
    }

    public String toString() {
        return i(this.f18136a);
    }
}
