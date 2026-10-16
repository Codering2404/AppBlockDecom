package androidx.compose.ui.layout;

import kotlin.Metadata;

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
public interface ContentScale {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f27054a = Companion.f27055a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f27055a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ContentScale f27056b = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                float fC = ContentScaleKt.c(j3, j4);
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fC)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fC))));
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ContentScale f27057c = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                float fD = ContentScaleKt.d(j3, j4);
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fD)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fD))));
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ContentScale f27058d = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 & 4294967295L)) / Float.intBitsToFloat((int) (j3 & 4294967295L));
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final ContentScale f27059e = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32)) / Float.intBitsToFloat((int) (j3 >> 32));
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ContentScale f27060f = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                if (Float.intBitsToFloat((int) (j3 >> 32)) <= Float.intBitsToFloat((int) (j4 >> 32)) && Float.intBitsToFloat((int) (j3 & 4294967295L)) <= Float.intBitsToFloat((int) (j4 & 4294967295L))) {
                    return ScaleFactor.a((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L));
                }
                float fD = ContentScaleKt.d(j3, j4);
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fD)) << 32) | (((long) Float.floatToRawIntBits(fD)) & 4294967295L));
            }
        };

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FixedScale f27061g = new FixedScale(1.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final ContentScale f27062h = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            public long a(long j3, long j4) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32)) / Float.intBitsToFloat((int) (j3 >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L)) / Float.intBitsToFloat((int) (j3 & 4294967295L));
                return ScaleFactor.a((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
            }
        };

        private Companion() {
        }

        public final ContentScale a() {
            return f27056b;
        }

        public final ContentScale b() {
            return f27062h;
        }

        public final ContentScale c() {
            return f27058d;
        }

        public final ContentScale d() {
            return f27059e;
        }

        public final ContentScale e() {
            return f27057c;
        }

        public final ContentScale f() {
            return f27060f;
        }

        public final FixedScale g() {
            return f27061g;
        }
    }

    long a(long j3, long j4);
}
