package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class PathSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f25852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f25853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25854c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Type {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Type f25855a = new Type("Move", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Type f25856b = new Type("Line", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Type f25857c = new Type("Quadratic", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Type f25858d = new Type("Conic", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Type f25859f = new Type("Cubic", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Type f25860g = new Type("Close", 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Type f25861h = new Type("Done", 6);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ Type[] f25862i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f25863j;

        static {
            Type[] typeArrA = a();
            f25862i = typeArrA;
            f25863j = EnumEntriesKt.a(typeArrA);
        }

        private Type(String str, int i3) {
        }

        private static final /* synthetic */ Type[] a() {
            return new Type[]{f25855a, f25856b, f25857c, f25858d, f25859f, f25860g, f25861h};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f25862i.clone();
        }
    }

    public PathSegment(Type type, float[] fArr, float f3) {
        this.f25852a = type;
        this.f25853b = fArr;
        this.f25854c = f3;
    }

    public final float[] a() {
        return this.f25853b;
    }

    public final Type b() {
        return this.f25852a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PathSegment.class == obj.getClass()) {
            PathSegment pathSegment = (PathSegment) obj;
            if (this.f25852a == pathSegment.f25852a && Arrays.equals(this.f25853b, pathSegment.f25853b) && this.f25854c == pathSegment.f25854c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f25852a.hashCode() * 31) + Arrays.hashCode(this.f25853b)) * 31) + Float.hashCode(this.f25854c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PathSegment(type=");
        sb.append(this.f25852a);
        sb.append(", points=");
        String string = Arrays.toString(this.f25853b);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append(", weight=");
        sb.append(this.f25854c);
        sb.append(')');
        return sb.toString();
    }
}
