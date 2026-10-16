package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
public abstract class WorkRequest {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f54593d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f54594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WorkSpec f54595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f54596c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f54597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f54598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private UUID f54599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WorkSpec f54600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set f54601e;

        public Builder(Class workerClass) {
            Intrinsics.checkNotNullParameter(workerClass, "workerClass");
            this.f54597a = workerClass;
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.f54599c = uuidRandomUUID;
            String string = this.f54599c.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            String name = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
            this.f54600d = new WorkSpec(string, name);
            String name2 = workerClass.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "workerClass.name");
            this.f54601e = SetsKt.mutableSetOf(name2);
        }

        public final Builder a(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.f54601e.add(tag);
            return g();
        }

        public final WorkRequest b() {
            WorkRequest workRequestC = c();
            Constraints constraints = this.f54600d.f55022j;
            boolean z2 = constraints.e() || constraints.f() || constraints.g() || constraints.h();
            WorkSpec workSpec = this.f54600d;
            if (workSpec.f55029q) {
                if (z2) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (workSpec.f55019g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            j(uuidRandomUUID);
            return workRequestC;
        }

        public abstract WorkRequest c();

        public final boolean d() {
            return this.f54598b;
        }

        public final UUID e() {
            return this.f54599c;
        }

        public final Set f() {
            return this.f54601e;
        }

        public abstract Builder g();

        public final WorkSpec h() {
            return this.f54600d;
        }

        public final Builder i(Constraints constraints) {
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            this.f54600d.f55022j = constraints;
            return g();
        }

        public final Builder j(UUID id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.f54599c = id;
            String string = id.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            this.f54600d = new WorkSpec(string, this.f54600d);
            return g();
        }

        public Builder k(long j3, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.f54600d.f55019g = timeUnit.toMillis(j3);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f54600d.f55019g) {
                return g();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final Builder l(Data inputData) {
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            this.f54600d.f55017e = inputData;
            return g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WorkRequest(UUID id, WorkSpec workSpec, Set tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f54594a = id;
        this.f54595b = workSpec;
        this.f54596c = tags;
    }

    public UUID a() {
        return this.f54594a;
    }

    public final String b() {
        String string = a().toString();
        Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
        return string;
    }

    public final Set c() {
        return this.f54596c;
    }

    public final WorkSpec d() {
        return this.f54595b;
    }
}
