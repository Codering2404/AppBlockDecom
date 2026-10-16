package androidx.work.impl.constraints.controllers;

import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class NetworkConnectedController extends ConstraintController<NetworkState> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54883b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkConnectedController(ConstraintTracker tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f54883b = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public int b() {
        return this.f54883b;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean c(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.f55022j.d() == NetworkType.CONNECTED;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean e(NetworkState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (value.a() && value.d()) ? false : true;
    }
}
