package cz.mobilesoft.coreblock.repository;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ApplicationRepository", f = "ApplicationRepository.kt", l = {86, 87, 88, 91, 94, 108, 111, 123, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 154, 169, 173, 187, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 194}, m = "insertApplications", v = 1)
final class ApplicationRepository$insertApplications$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97470d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f97475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f97476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f97477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f97478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f97479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f97480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f97481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f97482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f97483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f97484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f97485t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    /* synthetic */ Object f97486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ ApplicationRepository f97487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f97488w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationRepository$insertApplications$1(ApplicationRepository applicationRepository, Continuation continuation) {
        super(continuation);
        this.f97487v = applicationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97486u = obj;
        this.f97488w |= Integer.MIN_VALUE;
        return this.f97487v.o(null, false, this);
    }
}
