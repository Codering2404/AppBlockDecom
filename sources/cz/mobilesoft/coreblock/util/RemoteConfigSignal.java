package cz.mobilesoft.coreblock.util;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RemoteConfigSignal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteConfigSignal f127906a = new RemoteConfigSignal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableStateFlow f127907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final StateFlow f127908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f127909d;

    static {
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(Boolean.FALSE);
        f127907b = mutableStateFlowA;
        f127908c = FlowKt.c(mutableStateFlowA);
        f127909d = 8;
    }

    private RemoteConfigSignal() {
    }

    public final StateFlow a() {
        return f127908c;
    }

    public final void b() {
        f127907b.setValue(Boolean.TRUE);
    }
}
