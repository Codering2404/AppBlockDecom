package androidx.work;

import androidx.work.WorkRequest;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PeriodicWorkRequest extends WorkRequest {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f54560e = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(Builder builder) {
        super(builder.e(), builder.h(), builder.f());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class workerClass, long j3, TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            Intrinsics.checkNotNullParameter(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            h().p(repeatIntervalTimeUnit.toMillis(j3));
        }

        @Override // androidx.work.WorkRequest.Builder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public PeriodicWorkRequest c() {
            if (d() && h().f55022j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (h().f55029q) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new PeriodicWorkRequest(this);
        }

        public final Builder o(long j3) {
            if (j3 == Long.MAX_VALUE) {
                throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time");
            }
            h().n(j3);
            h().o(1);
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class workerClass, long j3, TimeUnit repeatIntervalTimeUnit, long j4, TimeUnit flexIntervalTimeUnit) {
            super(workerClass);
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            Intrinsics.checkNotNullParameter(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            Intrinsics.checkNotNullParameter(flexIntervalTimeUnit, "flexIntervalTimeUnit");
            h().q(repeatIntervalTimeUnit.toMillis(j3), flexIntervalTimeUnit.toMillis(j4));
        }

        @Override // androidx.work.WorkRequest.Builder
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Builder g() {
            return this;
        }
    }
}
