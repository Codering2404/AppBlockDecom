package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DataStoreInMemoryCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableStateFlow f35689a;

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.f35832b;
        Intrinsics.checkNotNull(unInitialized, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.f35689a = StateFlowKt.a(unInitialized);
    }

    public final State a() {
        return (State) this.f35689a.getValue();
    }

    public final Flow b() {
        return this.f35689a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.datastore.core.State c(androidx.datastore.core.State r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlinx.coroutines.flow.MutableStateFlow r0 = r5.f35689a
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            boolean r3 = r2 instanceof androidx.datastore.core.ReadException
            if (r3 == 0) goto L14
            r3 = 1
            goto L1a
        L14:
            androidx.datastore.core.UnInitialized r3 = androidx.datastore.core.UnInitialized.f35832b
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
        L1a:
            if (r3 == 0) goto L1d
            goto L2b
        L1d:
            boolean r3 = r2 instanceof androidx.datastore.core.Data
            if (r3 == 0) goto L2d
            int r3 = r6.a()
            int r4 = r2.a()
            if (r3 <= r4) goto L31
        L2b:
            r2 = r6
            goto L31
        L2d:
            boolean r3 = r2 instanceof androidx.datastore.core.Final
            if (r3 == 0) goto L38
        L31:
            boolean r1 = r0.compareAndSet(r1, r2)
            if (r1 == 0) goto L7
            return r2
        L38:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreInMemoryCache.c(androidx.datastore.core.State):androidx.datastore.core.State");
    }
}
