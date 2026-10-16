package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.statistics.model.AggregatedCategoryRecord;
import java.util.List;
import kotlin.Metadata;
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
public final class FetchAggregatedAppDataUseCase extends SuspendUseCase<Params, List<? extends AggregatedCategoryRecord>> implements KoinComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppDistractionType f103692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f103693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f103694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f103695d;

        public Params(AppDistractionType appDistractionType, long j3, long j4, List ignoredNames) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103692a = appDistractionType;
            this.f103693b = j3;
            this.f103694c = j4;
            this.f103695d = ignoredNames;
        }

        public final AppDistractionType a() {
            return this.f103692a;
        }

        public final long b() {
            return this.f103694c;
        }

        public final List c() {
            return this.f103695d;
        }

        public final long d() {
            return this.f103693b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103692a == params.f103692a && this.f103693b == params.f103693b && this.f103694c == params.f103694c && Intrinsics.areEqual(this.f103695d, params.f103695d);
        }

        public int hashCode() {
            AppDistractionType appDistractionType = this.f103692a;
            return ((((((appDistractionType == null ? 0 : appDistractionType.hashCode()) * 31) + Long.hashCode(this.f103693b)) * 31) + Long.hashCode(this.f103694c)) * 31) + this.f103695d.hashCode();
        }

        public String toString() {
            return "Params(appDistractionType=" + this.f103692a + ", start=" + this.f103693b + ", end=" + this.f103694c + ", ignoredNames=" + this.f103695d + ")";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase.Params r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$1) r0
            int r1 = r0.f103699d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f103699d = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$1
            r0.<init>(r9, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r8.f103697b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f103699d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r8.f103696a
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$Params r10 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase.Params) r10
            kotlin.ResultKt.b(r11)
            goto L75
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.statistics.api.Statistics r11 = cz.mobilesoft.statistics.api.Statistics.f133571a
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r11 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r11 = r11.getTypeId()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.d(r11)
            java.util.Set r11 = kotlin.collections.SetsKt.setOf(r11)
            java.util.List r3 = r10.c()
            cz.mobilesoft.coreblock.enums.AppDistractionType r1 = r10.a()
            if (r1 == 0) goto L59
            java.lang.String r1 = r1.name()
            goto L5a
        L59:
            r1 = 0
        L5a:
            long r4 = r10.d()
            long r6 = r10.b()
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r8.f103696a = r10
            r8.f103699d = r2
            r2 = r1
            r1 = r11
            java.lang.Object r11 = cz.mobilesoft.statistics.api.Statistics.g(r1, r2, r3, r4, r6, r8)
            if (r11 != r0) goto L75
            return r0
        L75:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$$inlined$sortedBy$1 r10 = new cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$invoke$$inlined$sortedBy$1
            r10.<init>()
            java.util.List r10 = kotlin.collections.CollectionsKt.sortedWith(r11, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase.a(cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
