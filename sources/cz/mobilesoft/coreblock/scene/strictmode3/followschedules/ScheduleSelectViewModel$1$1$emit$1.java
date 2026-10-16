package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1$1", f = "ScheduleSelectViewModel.kt", l = {54}, m = "emit", v = 1)
final class ScheduleSelectViewModel$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f122077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f122078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f122079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f122080d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f122081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f122082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f122083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f122084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f122085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f122086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f122087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f122088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f122089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f122090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f122091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f122092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    /* synthetic */ Object f122093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ ScheduleSelectViewModel.AnonymousClass1.C03021 f122094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f122095t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleSelectViewModel$1$1$emit$1(ScheduleSelectViewModel.AnonymousClass1.C03021 c03021, Continuation continuation) {
        super(continuation);
        this.f122094s = c03021;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f122093r = obj;
        this.f122095t |= Integer.MIN_VALUE;
        return this.f122094s.emit(null, this);
    }
}
