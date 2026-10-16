package cz.mobilesoft.coreblock.repository;

import com.facebook.internal.Utility;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$2", f = "DiagnosticRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class DiagnosticRepository$getRevenueCatInfoJson$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteArrayOutputStream f97691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f97692c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticRepository$getRevenueCatInfoJson$2(ByteArrayOutputStream byteArrayOutputStream, String str, Continuation continuation) {
        super(2, continuation);
        this.f97691b = byteArrayOutputStream;
        this.f97692c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DiagnosticRepository$getRevenueCatInfoJson$2(this.f97691b, this.f97692c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f97690a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(this.f97691b);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream, UTF_8), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            bufferedWriter.write(this.f97692c);
            Unit unit = Unit.f139807a;
            CloseableKt.a(bufferedWriter, null);
            return Unit.f139807a;
        } finally {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DiagnosticRepository$getRevenueCatInfoJson$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
