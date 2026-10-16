package androidx.work.impl.constraints;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class NetworkState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f54855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f54856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f54857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f54858d;

    public NetworkState(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f54855a = z2;
        this.f54856b = z3;
        this.f54857c = z4;
        this.f54858d = z5;
    }

    public final boolean a() {
        return this.f54855a;
    }

    public final boolean b() {
        return this.f54857c;
    }

    public final boolean c() {
        return this.f54858d;
    }

    public final boolean d() {
        return this.f54856b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.f54855a == networkState.f54855a && this.f54856b == networkState.f54856b && this.f54857c == networkState.f54857c && this.f54858d == networkState.f54858d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z2 = this.f54855a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i3 = r02 * 31;
        boolean z3 = this.f54856b;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i4 = (i3 + r2) * 31;
        boolean z4 = this.f54857c;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int i5 = (i4 + r22) * 31;
        boolean z5 = this.f54858d;
        return i5 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f54855a + ", isValidated=" + this.f54856b + ", isMetered=" + this.f54857c + ", isNotRoaming=" + this.f54858d + ')';
    }
}
