package cz.mobilesoft.coreblock.storage.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$3", f = "RatingDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class RatingDataStore$setShownDate$3 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingDataStore f124500c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDataStore$setShownDate$3(RatingDataStore ratingDataStore, Continuation continuation) {
        super(2, continuation);
        this.f124500c = ratingDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RatingDataStore$setShownDate$3 ratingDataStore$setShownDate$3 = new RatingDataStore$setShownDate$3(this.f124500c, continuation);
        ratingDataStore$setShownDate$3.f124499b = obj;
        return ratingDataStore$setShownDate$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((RatingDataStore$setShownDate$3) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutablePreferences mutablePreferences = (MutablePreferences) this.f124499b;
        IntrinsicsKt.f();
        if (this.f124498a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f124500c.o0(mutablePreferences);
        return Unit.f139807a;
    }
}
