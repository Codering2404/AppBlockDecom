package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$9", f = "ScheduleViewModel.kt", l = {965, 973}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleViewEvent f114854d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114855f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$9(ScheduleViewEvent scheduleViewEvent, ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114854d = scheduleViewEvent;
        this.f114855f = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO q(ArrayList arrayList, ScheduleViewEvent scheduleViewEvent, ArrayList arrayList2, ScheduleDTO scheduleDTO) {
        ArrayList arrayList3 = new ArrayList(arrayList);
        ScheduleViewEvent.OnCopyProfileClicked onCopyProfileClicked = (ScheduleViewEvent.OnCopyProfileClicked) scheduleViewEvent;
        List listS = onCopyProfileClicked.a().s();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : listS) {
            if (((WebsiteProfileRelation) obj).a() == WebsiteProfileRelation.BlockingType.DOMAIN) {
                arrayList4.add(obj);
            }
        }
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        int size = arrayList4.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList4.get(i4);
            i4++;
            arrayList5.add(new WebsiteDTO(true, ((WebsiteProfileRelation) obj2).c()));
        }
        ArrayList arrayList6 = new ArrayList(arrayList5);
        List listS2 = onCopyProfileClicked.a().s();
        ArrayList arrayList7 = new ArrayList();
        for (Object obj3 : listS2) {
            if (((WebsiteProfileRelation) obj3).a() == WebsiteProfileRelation.BlockingType.KEYWORD) {
                arrayList7.add(obj3);
            }
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        int size2 = arrayList7.size();
        while (i3 < size2) {
            Object obj4 = arrayList7.get(i3);
            i3++;
            WebsiteProfileRelation websiteProfileRelation = (WebsiteProfileRelation) obj4;
            arrayList8.add(new KeywordDTO(Long.valueOf(websiteProfileRelation.b()), websiteProfileRelation.c(), websiteProfileRelation.e()));
        }
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, arrayList3, arrayList6, new ArrayList(arrayList8), arrayList2, null, false, false, false, 0L, 0L, null, false, Category.Companion.c(onCopyProfileClicked.a().p().z()), 267452415, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onEvent$9(this.f114854d, this.f114855f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onEvent$9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
