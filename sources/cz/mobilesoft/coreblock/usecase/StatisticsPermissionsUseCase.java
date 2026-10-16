package cz.mobilesoft.coreblock.usecase;

import android.content.Context;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsPermissionsUseCase extends FlowUseCase<Params, List<? extends PermissionDTO>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127323a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f127324a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return -1005824292;
        }

        public String toString() {
            return "Params";
        }
    }

    public StatisticsPermissionsUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f127323a = context;
    }

    public final Context a() {
        return this.f127323a;
    }

    public Flow b(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new StatisticsPermissionsUseCase$invoke$1(this, null));
    }
}
