package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class ProvidedValue<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f24012i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompositionLocal f24013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SnapshotMutationPolicy f24015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f24016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f24017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f24018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f24019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24020h = true;

    public ProvidedValue(CompositionLocal compositionLocal, Object obj, boolean z2, SnapshotMutationPolicy snapshotMutationPolicy, MutableState mutableState, Function1 function1, boolean z3) {
        this.f24013a = compositionLocal;
        this.f24014b = z2;
        this.f24015c = snapshotMutationPolicy;
        this.f24016d = mutableState;
        this.f24017e = function1;
        this.f24018f = z3;
        this.f24019g = obj;
    }

    public final boolean a() {
        return this.f24020h;
    }

    public final CompositionLocal b() {
        return this.f24013a;
    }

    public final Function1 c() {
        return this.f24017e;
    }

    public final Object d() {
        if (this.f24014b) {
            return null;
        }
        MutableState mutableState = this.f24016d;
        if (mutableState != null) {
            return mutableState.getValue();
        }
        Object obj = this.f24019g;
        if (obj != null) {
            return obj;
        }
        ComposerKt.u("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }

    public final SnapshotMutationPolicy e() {
        return this.f24015c;
    }

    public final MutableState f() {
        return this.f24016d;
    }

    public final Object g() {
        return this.f24019g;
    }

    public final ProvidedValue h() {
        this.f24020h = false;
        return this;
    }

    public final boolean i() {
        return this.f24018f;
    }

    public final boolean j() {
        return (this.f24014b || g() != null) && !this.f24018f;
    }
}
