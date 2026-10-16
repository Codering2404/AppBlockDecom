package androidx.compose.foundation.text;

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
@JvmInline
public final class MenuItemsAvailability {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f9861b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9862c = c(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9863a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return MenuItemsAvailability.f9862c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ MenuItemsAvailability(int i3) {
        this.f9863a = i3;
    }

    public static final /* synthetic */ MenuItemsAvailability b(int i3) {
        return new MenuItemsAvailability(i3);
    }

    public static int d(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return c((z2 ? 1 : 0) | (z3 ? 2 : 0) | (z4 ? 4 : 0) | (z5 ? 8 : 0) | (z6 ? 16 : 0));
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof MenuItemsAvailability) && i3 == ((MenuItemsAvailability) obj).m();
    }

    public static final boolean f(int i3) {
        return (i3 & 16) == 16;
    }

    public static final boolean g(int i3) {
        return (i3 & 1) == 1;
    }

    public static final boolean h(int i3) {
        return (i3 & 4) == 4;
    }

    public static final boolean i(int i3) {
        return (i3 & 2) == 2;
    }

    public static final boolean j(int i3) {
        return (i3 & 8) == 8;
    }

    public static int k(int i3) {
        return Integer.hashCode(i3);
    }

    public static String l(int i3) {
        return "MenuItemsAvailability(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f9863a, obj);
    }

    public int hashCode() {
        return k(this.f9863a);
    }

    public final /* synthetic */ int m() {
        return this.f9863a;
    }

    public String toString() {
        return l(this.f9863a);
    }

    private static int c(int i3) {
        return i3;
    }
}
