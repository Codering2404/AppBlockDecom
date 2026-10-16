package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AppDifference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
public final class AppDifferenceUseCase extends SuspendUseCase<Params, List<? extends AppDifference>> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Pair f103663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pair f103664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103665c;

        public Params(Pair start, Pair end, List ignoredNames) {
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(end, "end");
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103663a = start;
            this.f103664b = end;
            this.f103665c = ignoredNames;
        }

        public final Pair a() {
            return this.f103664b;
        }

        public final List b() {
            return this.f103665c;
        }

        public final Pair c() {
            return this.f103663a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f103663a, params.f103663a) && Intrinsics.areEqual(this.f103664b, params.f103664b) && Intrinsics.areEqual(this.f103665c, params.f103665c);
        }

        public int hashCode() {
            return (((this.f103663a.hashCode() * 31) + this.f103664b.hashCode()) * 31) + this.f103665c.hashCode();
        }

        public String toString() {
            return "Params(start=" + this.f103663a + ", end=" + this.f103664b + ", ignoredNames=" + this.f103665c + ")";
        }
    }

    public Object a(Params params, Continuation continuation) {
        return Statistics.f133571a.l(CollectionsKt.listOf(Boxing.d(UsageAccess.Type.APPLICATION.getTypeId())), params.c(), params.a(), params.b());
    }
}
