package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;

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
public final class CursorAndWedgeAffinity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10707a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10708a;

        static {
            int[] iArr = new int[WedgeAffinity.values().length];
            try {
                iArr[WedgeAffinity.f10685a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WedgeAffinity.f10686b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f10708a = iArr;
        }
    }

    public static final int a(long j3) {
        return g(j3);
    }

    public static final WedgeAffinity b(long j3) {
        return h(j3);
    }

    public static long c(int i3) {
        return e((((long) i3) << 32) | (((long) (-1)) & 4294967295L));
    }

    public static long d(int i3, WedgeAffinity wedgeAffinity) {
        int i4 = -1;
        int i5 = wedgeAffinity == null ? -1 : WhenMappings.f10708a[wedgeAffinity.ordinal()];
        if (i5 != -1) {
            i4 = 1;
            if (i5 == 1) {
                i4 = 0;
            } else if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return e((((long) i3) << 32) | (((long) i4) & 4294967295L));
    }

    public static boolean f(long j3, Object obj) {
        return (obj instanceof CursorAndWedgeAffinity) && j3 == ((CursorAndWedgeAffinity) obj).k();
    }

    public static final int g(long j3) {
        return (int) (j3 >> 32);
    }

    public static final WedgeAffinity h(long j3) {
        int i3 = (int) (j3 & 4294967295L);
        if (i3 < 0) {
            return null;
        }
        return i3 == 0 ? WedgeAffinity.f10685a : WedgeAffinity.f10686b;
    }

    public static int i(long j3) {
        return Long.hashCode(j3);
    }

    public static String j(long j3) {
        return "CursorAndWedgeAffinity(value=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f10707a, obj);
    }

    public int hashCode() {
        return i(this.f10707a);
    }

    public final /* synthetic */ long k() {
        return this.f10707a;
    }

    public String toString() {
        return j(this.f10707a);
    }

    public static long e(long j3) {
        return j3;
    }
}
