package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.util.List;
import kotlin.Metadata;
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
public final class LongestContinuousUseUseCase extends SuspendUseCase<Params, RecordDuration> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f103789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103790c;

        public Params(long j3, long j4, List ignoredNames) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103788a = j3;
            this.f103789b = j4;
            this.f103790c = ignoredNames;
        }

        public final long a() {
            return this.f103789b;
        }

        public final List b() {
            return this.f103790c;
        }

        public final long c() {
            return this.f103788a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103788a == params.f103788a && this.f103789b == params.f103789b && Intrinsics.areEqual(this.f103790c, params.f103790c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f103788a) * 31) + Long.hashCode(this.f103789b)) * 31) + this.f103790c.hashCode();
        }

        public String toString() {
            return "Params(start=" + this.f103788a + ", end=" + this.f103789b + ", ignoredNames=" + this.f103790c + ")";
        }
    }

    public Object a(Params params, Continuation continuation) {
        Statistics statistics = Statistics.f133571a;
        long jC = params.c();
        long jA = params.a();
        return statistics.K(CollectionsKt.listOf(Boxing.d(UsageAccess.Type.APPLICATION.getTypeId())), params.b(), jC, jA, continuation);
    }
}
