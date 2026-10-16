package cz.mobilesoft.coreblock.scene.sharing.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager$executeCopyToClipboard$2$imageUri$1", f = "SocialShareManager.kt", l = {}, m = "invokeSuspend", v = 1)
final class SocialShareManager$executeCopyToClipboard$2$imageUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SocialShareManager f119526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f119527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bitmap f119528d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialShareManager$executeCopyToClipboard$2$imageUri$1(SocialShareManager socialShareManager, Context context, Bitmap bitmap, Continuation continuation) {
        super(2, continuation);
        this.f119526b = socialShareManager;
        this.f119527c = context;
        this.f119528d = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SocialShareManager$executeCopyToClipboard$2$imageUri$1(this.f119526b, this.f119527c, this.f119528d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f119525a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return this.f119526b.i(this.f119527c, this.f119528d);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SocialShareManager$executeCopyToClipboard$2$imageUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
