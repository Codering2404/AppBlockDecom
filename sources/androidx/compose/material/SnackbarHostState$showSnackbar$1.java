package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", l = {387, 390}, m = "showSnackbar")
final class SnackbarHostState$showSnackbar$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f14100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f14101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f14102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f14103d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f14104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f14105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f14106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ SnackbarHostState f14107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f14108j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarHostState$showSnackbar$1(SnackbarHostState snackbarHostState, Continuation continuation) {
        super(continuation);
        this.f14107i = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14106h = obj;
        this.f14108j |= Integer.MIN_VALUE;
        return this.f14107i.d(null, null, null, this);
    }
}
