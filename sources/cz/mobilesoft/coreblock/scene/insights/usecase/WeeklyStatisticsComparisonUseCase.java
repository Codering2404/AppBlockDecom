package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.StatisticsHelper;
import cz.mobilesoft.statistics.api.Statistics;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class WeeklyStatisticsComparisonUseCase extends SuspendUseCase<Params, Result> implements KoinComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Float f103825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Float f103826b;

        public Result(Float f3, Float f4) {
            this.f103825a = f3;
            this.f103826b = f4;
        }

        public final Float a() {
            return this.f103825a;
        }

        public final Float b() {
            return this.f103826b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual((Object) this.f103825a, (Object) result.f103825a) && Intrinsics.areEqual((Object) this.f103826b, (Object) result.f103826b);
        }

        public int hashCode() {
            Float f3 = this.f103825a;
            int iHashCode = (f3 == null ? 0 : f3.hashCode()) * 31;
            Float f4 = this.f103826b;
            return iHashCode + (f4 != null ? f4.hashCode() : 0);
        }

        public String toString() {
            return "Result(weeklyDifference=" + this.f103825a + ", weeklyDifferencePercentage=" + this.f103826b + ")";
        }
    }

    private final float a(Params params, Pair pair) {
        Integer[] numArr = {Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId())};
        String[] strArr = (String[]) params.a().toArray(new String[0]);
        Category categoryB = params.b();
        return Statistics.Q(numArr, strArr, null, categoryB != null ? categoryB.name() : null, null, ((Number) pair.e()).longValue(), ((Number) pair.f()).longValue(), true).c().a();
    }

    public Object b(Params params, Continuation continuation) {
        Calendar calendar = Calendar.getInstance();
        Pair pair = new Pair(Boxing.e(StatisticsHelper.k(params.c())), Boxing.e(StatisticsHelper.l(params.c())));
        calendar.setTimeInMillis(params.c());
        calendar.add(7, -7);
        long timeInMillis = calendar.getTimeInMillis();
        long jA = (long) a(params, new Pair(Boxing.e(StatisticsHelper.k(timeInMillis)), Boxing.e(StatisticsHelper.l(timeInMillis))));
        long jA2 = (long) a(params, pair);
        if (jA <= 0 || jA2 <= 0) {
            return null;
        }
        float f3 = jA2;
        float f4 = jA;
        return new Result(Boxing.c(f3 - f4), Boxing.c((f3 / f4) - 1));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Category f103823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103824c;

        public Params(long j3, Category category, List ignoredNames) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103822a = j3;
            this.f103823b = category;
            this.f103824c = ignoredNames;
        }

        public final List a() {
            return this.f103824c;
        }

        public final Category b() {
            return this.f103823b;
        }

        public final long c() {
            return this.f103822a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103822a == params.f103822a && this.f103823b == params.f103823b && Intrinsics.areEqual(this.f103824c, params.f103824c);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.f103822a) * 31;
            Category category = this.f103823b;
            return ((iHashCode + (category == null ? 0 : category.hashCode())) * 31) + this.f103824c.hashCode();
        }

        public String toString() {
            return "Params(start=" + this.f103822a + ", selectedCategory=" + this.f103823b + ", ignoredNames=" + this.f103824c + ")";
        }

        public /* synthetic */ Params(long j3, Category category, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, (i3 & 2) != 0 ? null : category, list);
        }
    }
}
