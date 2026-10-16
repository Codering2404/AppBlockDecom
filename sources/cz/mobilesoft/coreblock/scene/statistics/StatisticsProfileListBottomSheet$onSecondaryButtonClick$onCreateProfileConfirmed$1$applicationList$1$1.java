package cz.mobilesoft.coreblock.scene.statistics;

import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1", f = "StatisticsProfileListBottomSheet.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", v = 1)
final class StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApplicationDTO>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsProfileListBottomSheet f119709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f119710c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, String str, Continuation continuation) {
        super(2, continuation);
        this.f119709b = statisticsProfileListBottomSheet;
        this.f119710c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1(this.f119709b, this.f119710c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119708a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ApplicationDao applicationDaoS0 = this.f119709b.S0();
            List listListOf = CollectionsKt.listOf(this.f119710c);
            this.f119708a = 1;
            obj = applicationDaoS0.a0(listListOf, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Application application = (Application) CollectionsKt.firstOrNull((List) obj);
        if (application == null) {
            return null;
        }
        String strD = application.d();
        String strB = application.b();
        Category.Companion companion = Category.Companion;
        Integer numA = application.a();
        return new ApplicationDTO(strD, strB, companion.c(numA != null ? numA.intValue() : 0));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
