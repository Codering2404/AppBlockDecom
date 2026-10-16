package cz.mobilesoft.coreblock.util.view;

import android.graphics.drawable.Drawable;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.view.AppIconCache$getCachedOrQuerySystemAsync$2", f = "AppIconCache.kt", l = {}, m = "invokeSuspend", v = 1)
final class AppIconCache$getCachedOrQuerySystemAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f129943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppIconCache f129944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f129945d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppIconCache$getCachedOrQuerySystemAsync$2(AppIconCache appIconCache, String str, Continuation continuation) {
        super(2, continuation);
        this.f129944c = appIconCache;
        this.f129945d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppIconCache$getCachedOrQuerySystemAsync$2 appIconCache$getCachedOrQuerySystemAsync$2 = new AppIconCache$getCachedOrQuerySystemAsync$2(this.f129944c, this.f129945d, continuation);
        appIconCache$getCachedOrQuerySystemAsync$2.f129943b = obj;
        return appIconCache$getCachedOrQuerySystemAsync$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f129942a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Drawable drawable = (Drawable) this.f129944c.f129941b.get(this.f129945d);
        if (drawable != null) {
            return drawable;
        }
        AppIconCache appIconCache = this.f129944c;
        String str = this.f129945d;
        Drawable drawableD = appIconCache.d(str);
        if (drawableD != null) {
            appIconCache.f129941b.put(str, drawableD);
        }
        return drawableD;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppIconCache$getCachedOrQuerySystemAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
