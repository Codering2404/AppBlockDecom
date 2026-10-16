package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public ProvidableCompositionLocal(Function0 function0) {
        super(function0, null);
    }

    private final ValueHolder f(ProvidedValue providedValue) {
        if (!providedValue.i()) {
            return providedValue.c() != null ? new ComputedValueHolder(providedValue.c()) : providedValue.f() != null ? new DynamicValueHolder(providedValue.f()) : new StaticValueHolder(providedValue.d());
        }
        MutableState mutableStateF = providedValue.f();
        if (mutableStateF == null) {
            Object objG = providedValue.g();
            SnapshotMutationPolicy snapshotMutationPolicyE = providedValue.e();
            if (snapshotMutationPolicyE == null) {
                snapshotMutationPolicyE = SnapshotStateKt.r();
            }
            mutableStateF = SnapshotStateKt.i(objG, snapshotMutationPolicyE);
        }
        return new DynamicValueHolder(mutableStateF);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[PHI: r5
      0x0034: PHI (r5v2 androidx.compose.runtime.ValueHolder) = (r5v5 androidx.compose.runtime.ValueHolder), (r5v6 androidx.compose.runtime.ValueHolder) binds: [B:17:0x0044, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.runtime.CompositionLocal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.ValueHolder b(androidx.compose.runtime.ProvidedValue r4, androidx.compose.runtime.ValueHolder r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof androidx.compose.runtime.DynamicValueHolder
            r1 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r4.i()
            if (r0 == 0) goto L47
            r1 = r5
            androidx.compose.runtime.DynamicValueHolder r1 = (androidx.compose.runtime.DynamicValueHolder) r1
            androidx.compose.runtime.MutableState r5 = r1.c()
            java.lang.Object r0 = r4.d()
            r5.setValue(r0)
            goto L47
        L1a:
            boolean r0 = r5 instanceof androidx.compose.runtime.StaticValueHolder
            if (r0 == 0) goto L36
            boolean r0 = r4.j()
            if (r0 == 0) goto L47
            java.lang.Object r0 = r4.d()
            androidx.compose.runtime.StaticValueHolder r5 = (androidx.compose.runtime.StaticValueHolder) r5
            java.lang.Object r2 = r5.c()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L47
        L34:
            r1 = r5
            goto L47
        L36:
            boolean r0 = r5 instanceof androidx.compose.runtime.ComputedValueHolder
            if (r0 == 0) goto L47
            kotlin.jvm.functions.Function1 r0 = r4.c()
            androidx.compose.runtime.ComputedValueHolder r5 = (androidx.compose.runtime.ComputedValueHolder) r5
            kotlin.jvm.functions.Function1 r2 = r5.c()
            if (r0 != r2) goto L47
            goto L34
        L47:
            if (r1 != 0) goto L4e
            androidx.compose.runtime.ValueHolder r4 = r3.f(r4)
            return r4
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProvidableCompositionLocal.b(androidx.compose.runtime.ProvidedValue, androidx.compose.runtime.ValueHolder):androidx.compose.runtime.ValueHolder");
    }

    public abstract ProvidedValue c(Object obj);

    public final ProvidedValue d(Object obj) {
        return c(obj);
    }

    public final ProvidedValue e(Object obj) {
        return c(obj).h();
    }
}
