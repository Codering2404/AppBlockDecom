package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class StateRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StateRecord f25028b;

    public StateRecord(long j3) {
        this.f25027a = j3;
    }

    public abstract void c(StateRecord stateRecord);

    public abstract StateRecord d();

    public StateRecord e(long j3) {
        StateRecord stateRecordD = d();
        stateRecordD.f25027a = j3;
        return stateRecordD;
    }

    public final StateRecord f() {
        return this.f25028b;
    }

    public final long g() {
        return this.f25027a;
    }

    public final void h(StateRecord stateRecord) {
        this.f25028b = stateRecord;
    }

    public final void i(long j3) {
        this.f25027a = j3;
    }

    public StateRecord() {
        this(SnapshotKt.I().i());
    }
}
