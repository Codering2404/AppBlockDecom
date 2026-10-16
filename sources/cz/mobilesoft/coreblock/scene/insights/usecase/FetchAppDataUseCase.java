package cz.mobilesoft.coreblock.scene.insights.usecase;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
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
public final class FetchAppDataUseCase extends SuspendUseCase<Params, List<? extends AggregatedItemRecord>> implements KoinComponent {
    public Object a(Params params, Continuation continuation) {
        Set setH = params.h();
        AppDistractionType appDistractionTypeA = params.a();
        String strName = appDistractionTypeA != null ? appDistractionTypeA.name() : null;
        Category categoryF = params.f();
        return Statistics.i(setH, strName, categoryF != null ? categoryF.name() : null, !params.d().isEmpty() ? (String[]) params.d().toArray(new String[0]) : params.c() ? (String[]) params.e().toArray(new String[0]) : null, params.c() ? null : params.e(), params.g(), params.b());
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppDistractionType f103700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Category f103701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f103702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f103703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f103704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f103705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set f103706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f103707h;

        public Params(AppDistractionType appDistractionType, Category category, long j3, long j4, List ignoredNames, List filteredApps, Set typeIds, boolean z2) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            Intrinsics.checkNotNullParameter(filteredApps, "filteredApps");
            Intrinsics.checkNotNullParameter(typeIds, "typeIds");
            this.f103700a = appDistractionType;
            this.f103701b = category;
            this.f103702c = j3;
            this.f103703d = j4;
            this.f103704e = ignoredNames;
            this.f103705f = filteredApps;
            this.f103706g = typeIds;
            this.f103707h = z2;
        }

        public final AppDistractionType a() {
            return this.f103700a;
        }

        public final long b() {
            return this.f103703d;
        }

        public final boolean c() {
            return this.f103707h;
        }

        public final List d() {
            return this.f103705f;
        }

        public final List e() {
            return this.f103704e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103700a == params.f103700a && this.f103701b == params.f103701b && this.f103702c == params.f103702c && this.f103703d == params.f103703d && Intrinsics.areEqual(this.f103704e, params.f103704e) && Intrinsics.areEqual(this.f103705f, params.f103705f) && Intrinsics.areEqual(this.f103706g, params.f103706g) && this.f103707h == params.f103707h;
        }

        public final Category f() {
            return this.f103701b;
        }

        public final long g() {
            return this.f103702c;
        }

        public final Set h() {
            return this.f103706g;
        }

        public int hashCode() {
            AppDistractionType appDistractionType = this.f103700a;
            int iHashCode = (appDistractionType == null ? 0 : appDistractionType.hashCode()) * 31;
            Category category = this.f103701b;
            return ((((((((((((iHashCode + (category != null ? category.hashCode() : 0)) * 31) + Long.hashCode(this.f103702c)) * 31) + Long.hashCode(this.f103703d)) * 31) + this.f103704e.hashCode()) * 31) + this.f103705f.hashCode()) * 31) + this.f103706g.hashCode()) * 31) + Boolean.hashCode(this.f103707h);
        }

        public String toString() {
            return "Params(appDistractionType=" + this.f103700a + ", selectedCategory=" + this.f103701b + ", start=" + this.f103702c + ", end=" + this.f103703d + ", ignoredNames=" + this.f103704e + ", filteredApps=" + this.f103705f + ", typeIds=" + this.f103706g + ", fetchOnlyIgnoredItems=" + this.f103707h + ")";
        }

        public /* synthetic */ Params(AppDistractionType appDistractionType, Category category, long j3, long j4, List list, List list2, Set set, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : appDistractionType, (i3 & 2) != 0 ? null : category, j3, j4, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 64) != 0 ? SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()), Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId())}) : set, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2);
        }
    }
}
