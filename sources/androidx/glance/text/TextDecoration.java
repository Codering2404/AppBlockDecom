package androidx.glance.text;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class TextDecoration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39758b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f39759c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f39760d = c(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f39761e = c(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39762a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TextDecoration.f39761e;
        }

        public final int b() {
            return TextDecoration.f39760d;
        }

        private Companion() {
        }
    }

    public static final boolean d(int i3, int i4) {
        return (i4 | i3) == i3;
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof TextDecoration) && i3 == ((TextDecoration) obj).h();
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        if (i3 == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((f39760d & i3) != 0) {
            arrayList.add("Underline");
        }
        if ((i3 & f39761e) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public boolean equals(Object obj) {
        return e(this.f39762a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f39762a;
    }

    public int hashCode() {
        return f(this.f39762a);
    }

    public String toString() {
        return g(this.f39762a);
    }

    public static int c(int i3) {
        return i3;
    }
}
