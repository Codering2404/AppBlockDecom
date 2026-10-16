package cz.mobilesoft.coreblock.util.paywalltrace;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CollapsedTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PaywallTrace f128960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f128961b;

    public CollapsedTrace(PaywallTrace trace, int i3) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.f128960a = trace;
        this.f128961b = i3;
    }

    public static /* synthetic */ CollapsedTrace b(CollapsedTrace collapsedTrace, PaywallTrace paywallTrace, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            paywallTrace = collapsedTrace.f128960a;
        }
        if ((i4 & 2) != 0) {
            i3 = collapsedTrace.f128961b;
        }
        return collapsedTrace.a(paywallTrace, i3);
    }

    public final CollapsedTrace a(PaywallTrace trace, int i3) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new CollapsedTrace(trace, i3);
    }

    public final int c() {
        return this.f128961b;
    }

    public final PaywallTrace d() {
        return this.f128960a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollapsedTrace)) {
            return false;
        }
        CollapsedTrace collapsedTrace = (CollapsedTrace) obj;
        return Intrinsics.areEqual(this.f128960a, collapsedTrace.f128960a) && this.f128961b == collapsedTrace.f128961b;
    }

    public int hashCode() {
        return (this.f128960a.hashCode() * 31) + Integer.hashCode(this.f128961b);
    }

    public String toString() {
        return "CollapsedTrace(trace=" + this.f128960a + ", repeats=" + this.f128961b + ")";
    }
}
