package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import androidx.graphics.path.PathIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
final class AndroidPathIterator implements PathIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f25653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathIterator.ConicEvaluation f25654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f25656d = new float[8];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.graphics.path.PathIterator f25657f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25659b;

        static {
            int[] iArr = new int[PathIterator.ConicEvaluation.values().length];
            try {
                iArr[PathIterator.ConicEvaluation.f25841a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathIterator.ConicEvaluation.f25842b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25658a = iArr;
            int[] iArr2 = new int[PathSegment.Type.values().length];
            try {
                iArr2[PathSegment.Type.f25855a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PathSegment.Type.f25856b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PathSegment.Type.f25857c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PathSegment.Type.f25858d.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PathSegment.Type.f25859f.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f25659b = iArr2;
        }
    }

    public AndroidPathIterator(Path path, PathIterator.ConicEvaluation conicEvaluation, float f3) {
        PathIterator.ConicEvaluation conicEvaluation2;
        this.f25653a = path;
        this.f25654b = conicEvaluation;
        this.f25655c = f3;
        Path pathB = b();
        if (!(pathB instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path pathA = ((AndroidPath) pathB).A();
        int i3 = WhenMappings.f25658a[a().ordinal()];
        if (i3 == 1) {
            conicEvaluation2 = PathIterator.ConicEvaluation.AsConic;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            conicEvaluation2 = PathIterator.ConicEvaluation.AsQuadratics;
        }
        this.f25657f = new androidx.graphics.path.PathIterator(pathA, conicEvaluation2, c());
    }

    public PathIterator.ConicEvaluation a() {
        return this.f25654b;
    }

    public Path b() {
        return this.f25653a;
    }

    public float c() {
        return this.f25655c;
    }

    @Override // androidx.compose.ui.graphics.PathIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f25657f.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public PathSegment next() {
        PathSegment.Type typeC;
        float[] fArr = this.f25656d;
        if (fArr.length >= 8 && (typeC = AndroidPathIterator_androidKt.c(this.f25657f.a(fArr, 0))) != PathSegment.Type.f25861h) {
            if (typeC == PathSegment.Type.f25860g) {
                return PathSegmentKt.a();
            }
            int i3 = WhenMappings.f25659b[typeC.ordinal()];
            float[] fArr2 = i3 != 1 ? i3 != 2 ? (i3 == 3 || i3 == 4) ? new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]} : i3 != 5 ? new float[0] : new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]} : new float[]{fArr[0], fArr[1], fArr[2], fArr[3]} : new float[]{fArr[0], fArr[1]};
            return new PathSegment(typeC, fArr2, typeC == PathSegment.Type.f25858d ? fArr[6] : 0.0f);
        }
        return PathSegmentKt.b();
    }
}
