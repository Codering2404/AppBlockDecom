package cz.mobilesoft.coreblock.storage.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$2", f = "RatingDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class RatingDataStore$recordLovedIt$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f124492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RatingDataStore f124493d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDataStore$recordLovedIt$2(int i3, RatingDataStore ratingDataStore, Continuation continuation) {
        super(2, continuation);
        this.f124492c = i3;
        this.f124493d = ratingDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RatingDataStore$recordLovedIt$2 ratingDataStore$recordLovedIt$2 = new RatingDataStore$recordLovedIt$2(this.f124492c, this.f124493d, continuation);
        ratingDataStore$recordLovedIt$2.f124491b = obj;
        return ratingDataStore$recordLovedIt$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((RatingDataStore$recordLovedIt$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutablePreferences mutablePreferences = (MutablePreferences) this.f124491b;
        IntrinsicsKt.f();
        if (this.f124490a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f124492c <= 0) {
            this.f124493d.o0(mutablePreferences);
        } else {
            mutablePreferences.k(DataStoreKeysKt.r2(), Boxing.e(System.currentTimeMillis()));
            mutablePreferences.k(DataStoreKeysKt.u2(), Boxing.d(0));
        }
        return Unit.f139807a;
    }
}
