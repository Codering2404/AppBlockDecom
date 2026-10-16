package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
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
@DebugMetadata(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {96}, m = "invokeSuspend")
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f145153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f145154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f145155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f145156d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Path f145157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ FileSystem f145158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f145159h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f145157f = path;
        this.f145158g = fileSystem;
        this.f145159h = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileSystem$commonListRecursively$1 fileSystem$commonListRecursively$1 = new FileSystem$commonListRecursively$1(this.f145157f, this.f145158g, this.f145159h, continuation);
        fileSystem$commonListRecursively$1.f145156d = obj;
        return fileSystem$commonListRecursively$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        Iterator it;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f145155c;
        if (i3 == 0) {
            ResultKt.b(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f145156d;
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.addLast(this.f145157f);
            sequenceScope = sequenceScope2;
            arrayDeque = arrayDeque2;
            it = this.f145158g.k(this.f145157f).iterator();
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.f145154b;
            ArrayDeque arrayDeque3 = (ArrayDeque) this.f145153a;
            sequenceScope = (SequenceScope) this.f145156d;
            ResultKt.b(obj);
            arrayDeque = arrayDeque3;
        }
        while (it.hasNext()) {
            Path path = (Path) it.next();
            FileSystem fileSystem = this.f145158g;
            boolean z2 = this.f145159h;
            this.f145156d = sequenceScope;
            this.f145153a = arrayDeque;
            this.f145154b = it;
            this.f145155c = 1;
            if (FileSystem.a(sequenceScope, fileSystem, arrayDeque, path, z2, false, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((FileSystem$commonListRecursively$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
