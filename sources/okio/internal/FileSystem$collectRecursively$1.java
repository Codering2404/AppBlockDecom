package okio.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {116, 135, 145}, m = "collectRecursively")
final class FileSystem$collectRecursively$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f145140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f145141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f145142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f145143d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f145144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f145145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f145146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    /* synthetic */ Object f145147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f145148j;

    FileSystem$collectRecursively$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f145147i = obj;
        this.f145148j |= Integer.MIN_VALUE;
        return FileSystem.a(null, null, null, null, false, false, this);
    }
}
