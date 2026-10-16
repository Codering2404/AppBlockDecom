package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.Category;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DailyStatisticsComparisonUseCase {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f103679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Category f103681d;

        public Params(long j3, long j4, List ignoredNames, Category category) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103678a = j3;
            this.f103679b = j4;
            this.f103680c = ignoredNames;
            this.f103681d = category;
        }

        public final long a() {
            return this.f103679b;
        }

        public final List b() {
            return this.f103680c;
        }

        public final Category c() {
            return this.f103681d;
        }

        public final long d() {
            return this.f103678a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103678a == params.f103678a && this.f103679b == params.f103679b && Intrinsics.areEqual(this.f103680c, params.f103680c) && this.f103681d == params.f103681d;
        }

        public int hashCode() {
            int iHashCode = ((((Long.hashCode(this.f103678a) * 31) + Long.hashCode(this.f103679b)) * 31) + this.f103680c.hashCode()) * 31;
            Category category = this.f103681d;
            return iHashCode + (category == null ? 0 : category.hashCode());
        }

        public String toString() {
            return "Params(start=" + this.f103678a + ", end=" + this.f103679b + ", ignoredNames=" + this.f103680c + ", selectedCategory=" + this.f103681d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103682a;

        public Result(long j3) {
            this.f103682a = j3;
        }

        public final long a() {
            return this.f103682a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && this.f103682a == ((Result) obj).f103682a;
        }

        public int hashCode() {
            return Long.hashCode(this.f103682a);
        }

        public String toString() {
            return "Result(deltaSeconds=" + this.f103682a + ")";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(cz.mobilesoft.coreblock.scene.insights.usecase.DailyStatisticsComparisonUseCase.Params r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.DailyStatisticsComparisonUseCase.a(cz.mobilesoft.coreblock.scene.insights.usecase.DailyStatisticsComparisonUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
