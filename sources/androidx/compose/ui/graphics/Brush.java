package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
public abstract class Brush {
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Brush b(Companion companion, List list, float f3, float f4, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                f3 = 0.0f;
            }
            if ((i4 & 4) != 0) {
                f4 = Float.POSITIVE_INFINITY;
            }
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.a(list, f3, f4, i3);
        }

        public static /* synthetic */ Brush e(Companion companion, List list, long j3, long j4, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                j3 = Offset.f25596b.c();
            }
            long j5 = j3;
            if ((i4 & 4) != 0) {
                j4 = Offset.f25596b.a();
            }
            long j6 = j4;
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.c(list, j5, j6, i3);
        }

        public static /* synthetic */ Brush h(Companion companion, List list, long j3, float f3, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                j3 = Offset.f25596b.b();
            }
            long j4 = j3;
            if ((i4 & 4) != 0) {
                f3 = Float.POSITIVE_INFINITY;
            }
            float f4 = f3;
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.f(list, j4, f4, i3);
        }

        public static /* synthetic */ Brush i(Companion companion, Pair[] pairArr, long j3, float f3, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                j3 = Offset.f25596b.b();
            }
            long j4 = j3;
            if ((i4 & 4) != 0) {
                f3 = Float.POSITIVE_INFINITY;
            }
            float f4 = f3;
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.g(pairArr, j4, f4, i3);
        }

        public static /* synthetic */ Brush m(Companion companion, List list, float f3, float f4, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                f3 = 0.0f;
            }
            if ((i4 & 4) != 0) {
                f4 = Float.POSITIVE_INFINITY;
            }
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.k(list, f3, f4, i3);
        }

        public static /* synthetic */ Brush n(Companion companion, Pair[] pairArr, float f3, float f4, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                f3 = 0.0f;
            }
            if ((i4 & 4) != 0) {
                f4 = Float.POSITIVE_INFINITY;
            }
            if ((i4 & 8) != 0) {
                i3 = TileMode.f25948b.a();
            }
            return companion.l(pairArr, f3, f4, i3);
        }

        public final Brush a(List list, float f3, float f4, int i3) {
            return c(list, Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), i3);
        }

        public final Brush c(List list, long j3, long j4, int i3) {
            return new LinearGradient(list, null, j3, j4, i3, null);
        }

        public final Brush d(Pair[] pairArr, long j3, long j4, int i3) {
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair pair : pairArr) {
                arrayList.add(Color.n(((Color) pair.f()).B()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.e()).floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, j3, j4, i3, null);
        }

        public final Brush f(List list, long j3, float f3, int i3) {
            return new RadialGradient(list, null, j3, f3, i3, null);
        }

        public final Brush g(Pair[] pairArr, long j3, float f3, int i3) {
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair pair : pairArr) {
                arrayList.add(Color.n(((Color) pair.f()).B()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.e()).floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, j3, f3, i3, null);
        }

        public final Brush j(Pair[] pairArr, long j3) {
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair pair : pairArr) {
                arrayList.add(Color.n(((Color) pair.f()).B()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.e()).floatValue()));
            }
            return new SweepGradient(j3, arrayList, arrayList2, null);
        }

        public final Brush k(List list, float f3, float f4, int i3) {
            return c(list, Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), i3);
        }

        public final Brush l(Pair[] pairArr, float f3, float f4, int i3) {
            return d((Pair[]) Arrays.copyOf(pairArr, pairArr.length), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), i3);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo218applyToPq9zytI(long j3, Paint paint, float f3);

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo219getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    private Brush() {
        this.intrinsicSize = Size.f25617b.a();
    }
}
